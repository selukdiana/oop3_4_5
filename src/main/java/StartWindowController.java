import adapter.BinAdapter;
import adapter.TxtAdapter;
import adapter.XMLAdapter;
import command.*;
import decorator.JSONConvert;
import decorator.ZipArchive;
import serialize.Serialize;
import hierarchy.BasicPropertyProduct;
import hierarchy.character.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import util.DateSave;

import java.io.*;
import java.net.URL;

public class StartWindowController {

    private ObservableList<Product> productObservableList = FXCollections.observableArrayList();

    public ObservableList<Product> getHeroObservableList() {
        return productObservableList;
    }

    public TableView<Product> getHeroTableView() {
        return heroTableView;
    }

    @FXML
    private ComboBox<String> fileExtensionBox;

    @FXML
    private TableView<Product> heroTableView;

    @FXML
    private TableColumn<Product, String> nameHeroColumn;

    @FXML
    private TableColumn<Product, String> typeHeroColumn;

    @FXML
    private ComboBox<String> pluginCheckBox;



    @FXML
    void addHero() {
        navigatorTo(
                new Foundation("name", new BasicPropertyProduct(), ""),
                false,
                "Add Window"
        );
    }

    @FXML
    void clearTable() {
        productObservableList.clear();
    }

    @FXML
    void deleteHero() {
        if (heroTableView.getSelectionModel().isEmpty()) {
            showWarningDialog("The item was not selected");
            return;
        }
        productObservableList.remove(heroTableView.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void editHero() {
        if (heroTableView.getSelectionModel().isEmpty()) {
            showWarningDialog("The item was not selected");
            return;
        }
        navigatorTo(
                productObservableList.get(heroTableView.getSelectionModel().getSelectedIndex()),
                true,
                "Edit Window"
        );
    }

    @FXML
    void loadDataTable() {
        deserialize(fileExtensionBox.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void saveDataTable() {
        if (productObservableList.isEmpty()) {
            showWarningDialog("Table is empty");
            return;
        }
        Serialize adapter = getAdapter(fileExtensionBox.getSelectionModel().getSelectedIndex());
        int type = pluginCheckBox.getSelectionModel().getSelectedIndex();
        if (type == 2) {
            DateSave dateSave = new DateSave(adapter);
            dateSave.saveDate(productObservableList);
        } else if (type == 0) {
            Serialize json = new JSONConvert(adapter);
            json.serialize(productObservableList);
        } else {
            Serialize zip = new ZipArchive(adapter);
            zip.serialize(productObservableList);
        }
    }

    @FXML
    void initialize() {
        fileExtensionBox.getItems().addAll("xml", "bin", "str");
        fileExtensionBox.getSelectionModel().select(0);
        pluginCheckBox.getItems().addAll("JSON", "ZIP", "Nothing");
        pluginCheckBox.getSelectionModel().select(2);

        heroTableView.setItems(productObservableList);
        nameHeroColumn.setCellValueFactory(cellData -> cellData.getValue().getNameSSP());
        typeHeroColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeSSP());

    }

    private void showWarningDialog(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private Serialize getAdapter(int type) {
        switch (type) {
            case 0:
                return new XMLAdapter();
            case 1:
                return new BinAdapter();
            case 2:
                return new TxtAdapter();
            default:
                return null;
        }
    }

    private void deserialize(int type) {
        ProductTableOperationExecutor executor = new ProductTableOperationExecutor();
        switch (type) {
            case 0:
                executor.executeOperation(new DeserializeProductsTable(new XMLDeserialize(productObservableList)));
                break;
            case 1:
                executor.executeOperation(new DeserializeProductsTable(new BinDeserialize(productObservableList)));
                break;
            case 2:
                executor.executeOperation(new DeserializeProductsTable(new TxtDeserialize(productObservableList)));
                break;
        }
    }

    private void navigatorTo(Product product, boolean isEditState, String title) {
        Stage primaryStage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("createHeroWindow.fxml");
            loader.setLocation(xmlUrl);
            root = loader.load();
            CreateProductWindowController controller = loader.getController();
            controller.setCurrentHero(product);
            controller.setEditState(isEditState);
            controller.setStartWindowController(this);
            controller.fillFields();

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle(title);
        primaryStage.setResizable(false);
        assert root != null;
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

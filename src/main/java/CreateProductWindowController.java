import hierarchy.BasicPropertyProduct;
import hierarchy.character.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateProductWindowController {

    private Product currentProduct;

    private boolean isEditState;
    private  boolean isInit = true;

    private StartWindowController startWindowController;

    public void setEditState(boolean editState) {
        isEditState = editState;
    }

    public void setStartWindowController(StartWindowController startWindowController) {
        this.startWindowController = startWindowController;
    }

    @FXML
    private ComboBox<String> typeProductComboBox;

    @FXML
    private TextField brandTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField shelfLifeTextField;

    @FXML
    private TextField colorTextField;

    @FXML
    private VBox uniquePropsVBox;


    public CreateProductWindowController() {
    }

    @FXML
    void cancelAction() {
        ((Stage) uniquePropsVBox.getScene().getWindow()).close();
    }

    @FXML
    void okAction() {
        currentProduct.updatePropertyHero(
                brandTextField.getText(),
                new BasicPropertyProduct(
                        (countryTextField.getText()).toString(),
                        Double.parseDouble(priceTextField.getText()),
                        Integer.parseInt(shelfLifeTextField.getText()),
                        (colorTextField.getText()).toString()
                )
        );
        currentProduct.updateUniqueProperty(uniquePropsVBox);
        if (isEditState) {
            startWindowController.getHeroObservableList().
                    set(startWindowController.getHeroTableView().getSelectionModel().getFocusedIndex(), currentProduct);
        } else {
            startWindowController.getHeroObservableList().add(currentProduct);
        }
        ((Stage) uniquePropsVBox.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {
        typeProductComboBox.getItems().addAll("Powder", "Pencil", "Lipstick", "Foundation", "Concealer", "Blush");
        typeProductComboBox.getSelectionModel().selectedItemProperty().addListener((
                (options, oldValue, newValue) -> init(newValue)
        ));
    }

    private void init(String type) {
        if (isInit) {
            isInit = false;
        } else {
            changeType(type);
        }
    }

    private void changeType(String type) {
        switch (type) {
            case "Blush":
                currentProduct = new Blush(currentProduct.getBrand(), currentProduct.getBasicProperty(), 0, "");
                break;
            case "Pencil":
                currentProduct = new Pencil(currentProduct.getBrand(), currentProduct.getBasicProperty(), "", "");
                break;
            case "Lipstick":
                currentProduct = new Lipstick(currentProduct.getBrand(), currentProduct.getBasicProperty(), "");
                break;
            case "Concealer":
                currentProduct = new Concealer(currentProduct.getBrand(), currentProduct.getBasicProperty(), "", 0);
                break;
            case "Powder":
                currentProduct = new Powder(currentProduct.getBrand(), currentProduct.getBasicProperty(), 0);
                break;
            case "Foundation":
                currentProduct = new Foundation(currentProduct.getBrand(), currentProduct.getBasicProperty(), "");
                break;
        }
        currentProduct.setUniqueProperty(uniquePropsVBox);
    }


    private void fillBasicFields() {
        brandTextField.setText(currentProduct.getBrand());
        typeProductComboBox.getSelectionModel().select(currentProduct.getType());
        countryTextField.setText(currentProduct.getBasicProperty().getColor());
        priceTextField.setText(Double.toString(currentProduct.getBasicProperty().getPrice()));
        shelfLifeTextField.setText(Integer.toString(currentProduct.getBasicProperty().getShelf_life()));
        colorTextField.setText(currentProduct.getBasicProperty().getColor());
    }

    public void fillFields() {
        fillBasicFields();
        currentProduct.setUniqueProperty(uniquePropsVBox);
    }

    public void setCurrentHero(Product currentProduct) {
        this.currentProduct = currentProduct;
    }
}

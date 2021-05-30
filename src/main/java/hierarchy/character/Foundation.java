package hierarchy.character;

import hierarchy.BasicPropertyProduct;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class Foundation extends Product {
    protected String skin_type;

    public Foundation() {
        super("Джайна", ProductType.Foundation, new BasicPropertyProduct());
        skin_type = "";
        type = ProductType.Foundation;
    }


    public Foundation(String brand, BasicPropertyProduct basicProperty, String skin_type) {
        super(brand, ProductType.Foundation, basicProperty);
        this.skin_type = skin_type;
    }

    public String getSkin_type() {
        return skin_type;
    }

    public void setSkin_type(String skin_type) {
        this.skin_type = skin_type;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Skin type",
                "Enter skin type",
                skin_type
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(1);
        this.skin_type = textField.getText();
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + skin_type;
    }
}

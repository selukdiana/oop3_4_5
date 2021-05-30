package hierarchy.character;

import hierarchy.BasicPropertyProduct;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Lipstick extends Product {
    protected String effect;

    public Lipstick() {
        super("Леголас", ProductType.Lipstick, new BasicPropertyProduct());
        this.effect = "";
        type = ProductType.Lipstick;
    }

    public Lipstick(String brand, BasicPropertyProduct basicProperty, String effect) {
        super(brand, ProductType.Lipstick, basicProperty);
        this.effect = effect;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Effect",
                "Enter product effect",
                effect
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(1);;
        this.effect = textField.getText();
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + effect;
    }
}

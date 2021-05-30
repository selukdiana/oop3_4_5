package hierarchy.character;

import hierarchy.BasicPropertyProduct;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Concealer extends Foundation {
    private int dencity;

    public Concealer() {
        super("Гулдан", new BasicPropertyProduct(), "");
        dencity = 5;
        type = ProductType.Concealer;
    }



    public Concealer(String brand, BasicPropertyProduct basicProperty, String skin_type, int dencity) {
        super(brand, basicProperty, skin_type);
        this.dencity = dencity;
        type = ProductType.Concealer;
    }

    public int getDencity() {
        return dencity;
    }

    public void setDencity(int dencity) {
        this.dencity = dencity;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Dencity",
                "Enter product dencity",
                Double.toString(dencity)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        super.updateUniqueProperty(vBox);
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(2);
        this.dencity = Integer.parseInt(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + dencity;
    }
}

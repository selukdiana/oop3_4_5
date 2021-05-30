package hierarchy.character;

import hierarchy.BasicPropertyProduct;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Pencil extends Lipstick {
    private String active_ingredient;

    public Pencil() {
        super("Андуин", new BasicPropertyProduct(), "");
        active_ingredient = "";
        type = ProductType.Pencil;
    }

    public Pencil(String brand, BasicPropertyProduct basicProperty, String effect, String active_ingredient) {
        super(brand, basicProperty, effect);
        this.active_ingredient = active_ingredient;
        type = ProductType.Pencil;
    }



    public String getActive_ingredient() {
        return active_ingredient;
    }

    public void setActive_ingredient(String active_ingredient) {
        this.active_ingredient = active_ingredient;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Active ingredient",
                "Enter active ingredient",
                active_ingredient
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        super.updateUniqueProperty(vBox);
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(2);
        this.active_ingredient = textField.getText();
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + active_ingredient;
    }
}

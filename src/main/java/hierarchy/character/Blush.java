package hierarchy.character;

import hierarchy.BasicPropertyProduct;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Blush extends Powder {
    private String finish;

    public Blush() {
        super("Утер", new BasicPropertyProduct(), 3);
        finish = "";
        type = ProductType.Powder;
    }


    public Blush(String brand, BasicPropertyProduct basicProperty, int tenacity, String finish) {
        super(brand, basicProperty, tenacity);
        this.finish = finish;
        type = ProductType.Powder;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Finish",
                "Enter product finish",
                finish
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        super.updateUniqueProperty(vBox);
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(2);
        this.finish = textField.getText();
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + finish;
    }
}

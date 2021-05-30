package hierarchy.character;

import hierarchy.BasicPropertyProduct;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Powder extends Product {
    protected int tenacity;

    public Powder() {
        super("Горош", ProductType.Blush, new BasicPropertyProduct());
        this.tenacity = 5;
        type = ProductType.Blush;
    }


    public Powder(String brand, BasicPropertyProduct basicProperty, int tenacity) {
        super(brand, ProductType.Blush, basicProperty);
        this.tenacity = tenacity;
    }

    public double getTenacity() {
        return tenacity;
    }

    public void setTenacity(int tenacity) {
        this.tenacity = tenacity;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Tenacity",
                "Enter product tenacity",
                Double.toString(tenacity)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(1);
        this.tenacity = Integer.parseInt(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + tenacity;
    }
}

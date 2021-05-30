package hierarchy.character;

import hierarchy.BasicPropertyProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.Serializable;

public abstract class Product implements Serializable {
    protected int level;
    protected String brand;
    protected ProductType type;
    protected BasicPropertyProduct basicProperty;

    public Product(String brand, ProductType type, BasicPropertyProduct basicProperty) {
        this.level = 0;
        this.brand = brand;
        this.type = type;
        this.basicProperty = basicProperty;
    }

    public BasicPropertyProduct getBasicProperty() {
        return basicProperty;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type.toString();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setBasicProperty(BasicPropertyProduct basicProperty) {
        this.basicProperty = basicProperty;
    }

    public void setUniqueProperty(VBox vBox) {
        Label label = (Label) vBox.getChildren().get(0);
        vBox.getChildren().clear();
        vBox.getChildren().addAll(label);
    }

    public abstract void updateUniqueProperty(VBox vBox);

    public void updatePropertyHero(String name, BasicPropertyProduct basicProperty) {
        this.brand = name;
        this.basicProperty = basicProperty;
    }


    public SimpleStringProperty getNameSSP() {
        return new SimpleStringProperty(brand);
    }

    public SimpleStringProperty getTypeSSP() {
        return new SimpleStringProperty(type.toString());
    }

    @Override
    public String toString() {
        return brand + "-%-" + type.toString() + "-%-" + basicProperty.toString();
    }

    public static HBox createUiUniqueProperty(String textLabel, String promptText, String filedText) {
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        Label label = new Label(textLabel);
        TextField field = new TextField();
        field.setPromptText(promptText);
        field.setText(filedText);
        hBox.getChildren().addAll(label, field);
        return hBox;
    }
}

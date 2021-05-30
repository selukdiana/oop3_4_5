package command;

import hierarchy.character.Product;
import javafx.collections.ObservableList;

public abstract class ProductsTable {
    protected ObservableList<Product> productObservableList;

    public ProductsTable(ObservableList<Product> productObservableList) {
        this.productObservableList = productObservableList;
    }

    public abstract void deserialize();
}

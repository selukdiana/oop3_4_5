package serialize;

import hierarchy.character.Product;
import javafx.collections.ObservableList;

public interface Serialize {
    String getExtension();

    void serialize(ObservableList<Product> productObservableList);
}

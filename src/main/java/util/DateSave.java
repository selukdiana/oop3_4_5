package util;

import serialize.Serialize;
import hierarchy.character.Product;
import javafx.collections.ObservableList;

public class DateSave {
    private Serialize serialize;

    public DateSave(Serialize serialize) {
        super();
        this.serialize = serialize;
    }

    public void saveDate(ObservableList<Product> productObservableList) {
        serialize.serialize(productObservableList);
    }
}

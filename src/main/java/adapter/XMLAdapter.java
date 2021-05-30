package adapter;

import serialize.Serialize;
import serialize.XMLSerialize;
import hierarchy.character.Product;
import javafx.collections.ObservableList;

public class XMLAdapter extends XMLSerialize implements Serialize {

    @Override
    public String getExtension() {
        return "xml";
    }

    @Override
    public void serialize(ObservableList<Product> productObservableList) {

        saveProduct(productObservableList);
    }
}

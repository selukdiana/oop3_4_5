package decorator;

import serialize.Serialize;
import hierarchy.character.Product;
import javafx.collections.ObservableList;

public class SerializeDecorator implements Serialize {
    private Serialize serialize;

    public SerializeDecorator(Serialize serialize) {
        this.serialize = serialize;
    }

    @Override
    public String getExtension() {
        return serialize.getExtension();
    }

    @Override
    public void serialize(ObservableList<Product> productObservableList) {
        serialize.serialize(productObservableList);
    }
}

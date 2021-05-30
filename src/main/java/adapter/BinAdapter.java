package adapter;

import hierarchy.character.Product;
import serialize.BinSerialize;
import serialize.Serialize;
import javafx.collections.ObservableList;

public class BinAdapter extends BinSerialize implements Serialize {

    @Override
    public String getExtension() {
        return "bin";
    }

    @Override
    public void serialize(ObservableList<Product> productObservableList) {

        saveHero(productObservableList);
    }
}

package adapter;

import hierarchy.character.Product;
import serialize.Serialize;
import serialize.TxtSerialize;
import javafx.collections.ObservableList;

public class TxtAdapter extends TxtSerialize implements Serialize {

    @Override
    public String getExtension() {
        return "txt";
    }

    @Override
    public void serialize(ObservableList<Product> productObservableList) {

        saveHero(productObservableList);
    }
}

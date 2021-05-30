package decorator;

import hierarchy.character.Product;
import javafx.collections.ObservableList;
import plugin.PluginLoader;
import serialize.Serialize;

public class JSONConvert extends SerializeDecorator {

    public JSONConvert(Serialize serialize) {
        super(serialize);
    }

    public void serialize(ObservableList<Product> productObservableList) {
        super.serialize(productObservableList);
        serializeWithJSON();
    }

    private void serializeWithJSON() {

        new PluginLoader().loadPlugin("JSON").action(getExtension());
    }

}

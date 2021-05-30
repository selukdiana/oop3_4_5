package decorator;

import hierarchy.character.Product;
import javafx.collections.ObservableList;
import plugin.PluginLoader;
import serialize.Serialize;

public class ZipArchive extends SerializeDecorator {

    public ZipArchive(Serialize serialize) {
        super(serialize);
    }

    public void serialize(ObservableList<Product> productObservableList) {
        super.serialize(productObservableList);
        serializeWithZip();
    }

    private void serializeWithZip() {

        new PluginLoader().loadPlugin("Zip").action(getExtension());
    }
}

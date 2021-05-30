package command;

import hierarchy.character.Product;
import javafx.collections.ObservableList;
import util.TableSize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BinDeserialize extends ProductsTable {

    public BinDeserialize(ObservableList<Product> productObservableList) {
        super(productObservableList);
    }

    @Override
    public void deserialize() {
        try {
            FileInputStream fos = new FileInputStream("output.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fos);
            TableSize tableSize = (TableSize) objectInputStream.readObject();
            for (int i = 0; i < tableSize.getSize(); i++) {
                productObservableList.add((Product) objectInputStream.readObject());
            }
            objectInputStream.close();
            fos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

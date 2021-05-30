package command;

import hierarchy.character.Product;
import javafx.collections.ObservableList;
import util.TableSize;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLDeserialize extends ProductsTable {
    public XMLDeserialize(ObservableList<Product> productObservableList) {
        super(productObservableList);
    }

    @Override
    public void deserialize() {
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("output.xml")));
            TableSize tableSize = (TableSize) decoder.readObject();
            for (int i = 0; i < tableSize.getSize(); i++) {
                productObservableList.add((Product) decoder.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

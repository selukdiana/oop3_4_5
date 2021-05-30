package serialize;

import hierarchy.character.Product;
import javafx.collections.ObservableList;
import util.TableSize;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLSerialize {

    public void saveProduct(ObservableList<Product> productObservableList) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("output.xml")));
            encoder.writeObject(new TableSize(productObservableList.size()));
            for (Product product : productObservableList)
                encoder.writeObject(product);
            encoder.flush();
            encoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

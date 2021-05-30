package serialize;

import hierarchy.character.Product;
import javafx.collections.ObservableList;
import util.TableSize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinSerialize {

    public void saveProduct(ObservableList<Product> productObservableList) {
        try {
            FileOutputStream fos = new FileOutputStream("output.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(new TableSize(productObservableList.size()));
            for (Product product : productObservableList)
                objectOutputStream.writeObject(product);
            objectOutputStream.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

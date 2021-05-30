package serialize;

import hierarchy.character.Product;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;

public class TxtSerialize {

    public void saveProduct(ObservableList<Product> productObservableList) {
        for (Product product : productObservableList) {
            try {
                FileWriter fWriter = new FileWriter("output.txt", false);
                fWriter.write(product.toString() + "\n");
                fWriter.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

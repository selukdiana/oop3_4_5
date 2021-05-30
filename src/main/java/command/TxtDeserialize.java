package command;

import hierarchy.BasicPropertyProduct;
import hierarchy.character.*;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TxtDeserialize extends ProductsTable {

    public TxtDeserialize(ObservableList<Product> productObservableList) {
        super(productObservableList);
    }

    @Override
    public void deserialize() {
        List<String> reading = null;
        try {
            reading = Files.readAllLines(Paths.get("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String product : reading) {
            String[] res = product.split("-%-");
            switch (res[1]) {
                case "Blush":
                    productObservableList.add(new Blush(
                            res[0],
                            new BasicPropertyProduct(
                                    res[2].toString(),
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    res[5].toString()
                            ),
                            Integer.parseInt(res[6]),
                            res[7]
                    ));
                    break;
                case "Pencil":
                    productObservableList.add(new Pencil(
                            res[0],
                            new BasicPropertyProduct(
                                    res[2],
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    res[5]
                            ),
                            res[6],
                            res[7]
                    ));
                    break;
                case "Lipstick":
                    productObservableList.add(new Lipstick(
                            res[0],
                            new BasicPropertyProduct(
                                    res[2],
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    res[5]
                            ),
                            res[6]
                    ));
                    break;
                case "Concealer":
                    productObservableList.add(new Concealer(
                            res[0],
                            new BasicPropertyProduct(
                                    res[2],
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    res[5]
                            ),
                            res[6],
                            Integer.parseInt(res[7])
                    ));
                    break;
                case "Powder":
                    productObservableList.add(new Powder(
                            res[0],
                            new BasicPropertyProduct(
                                    res[2],
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    res[5]
                            ),
                            Integer.parseInt(res[6])
                    ));
                    break;
                case "Foundation":
                    productObservableList.add(new Foundation(
                            res[0],
                            new BasicPropertyProduct(
                                    res[2],
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    res[5]
                            ),
                            res[6]
                    ));
                    break;
            }
        }
    }
}

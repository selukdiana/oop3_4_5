package command;

import java.util.ArrayList;
import java.util.List;

public class ProductTableOperationExecutor {
    private final List<ProductTableOperation> productTableOperationList = new ArrayList<>();

    public void executeOperation(ProductTableOperation productTableOperation) {
        productTableOperationList.add(productTableOperation);
        productTableOperation.execute();
    }
}

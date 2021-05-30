package command;

public class DeserializeProductsTable implements ProductTableOperation {
    private ProductsTable productsTable;

    public DeserializeProductsTable(ProductsTable productsTable) {
        this.productsTable = productsTable;
    }


    @Override
    public void execute() {
        productsTable.deserialize();
    }
}

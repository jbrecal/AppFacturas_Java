package org.juanbrenes.appfacturas.model;

public class InvoiceItem {

    private int quantity;

    //Relaciones
    private Product product;

    //Constructor

    public InvoiceItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //método para calcular el importe

    public float calculateAmount(){
        return this.quantity * this.product.getPrice();
    }

    @Override
    public String toString() {
        return product.toString() +
                "\t" + quantity +
                "\t" +
                '\t' + calculateAmount();
    }
}

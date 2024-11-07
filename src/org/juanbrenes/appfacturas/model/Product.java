package org.juanbrenes.appfacturas.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private static int ultimoCliente;

    //Constructor


    public Product() {
        this.id = ++ultimoCliente;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id +
                "\t" + name +
                "\t" + price;
    }
}

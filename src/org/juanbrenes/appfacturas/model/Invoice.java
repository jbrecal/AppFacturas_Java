package org.juanbrenes.appfacturas.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {

    private int id;
    private String description;
    private Date date;


    // Relaciones

    private Customer customer;
    private InvoiceItem[] items;
    private int ItemIndex;

    public static final int MAX_ITEMS = 12;
    public static int ultimaFactura;

    //Constructor

    public Invoice(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
        this.items = new InvoiceItem[MAX_ITEMS];
        this.id = ++ultimaFactura;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public InvoiceItem[] getItems() {
        return items;
    }

    //método addItem
    public void addInvoiceItem(InvoiceItem item) {
        if (ItemIndex < MAX_ITEMS) { // mientras que sea menor al max podemos agregar elementos a la factura, así nos aseguramos que no se desborde el arreglo
            this.items[ItemIndex++] = item;
        }
    }

    //método para calcular el total de la factura
    public float calcularTotal(){
        float total = 0.0f;
        for(int i = 0; i < ItemIndex; i++){
            total += this.items[i].calculateAmount();
        }
        return total;
    }

    public String generateDetail(){
        StringBuilder sb = new StringBuilder("Invoice Nº: ");
        sb.append(id)
                .append("\nCustomer: ")
                .append(this.customer.getName())
                .append("\t NIF ")
                .append(customer.getNif())
                .append("\nDescription: ")
                .append(this.description)
                .append("\n");


        SimpleDateFormat df = new SimpleDateFormat("dd' of 'MMMM,yyyy");
        sb.append("Emission Date: ")
                .append(df.format(this.date))
                .append("\n")
                .append("\n#\tName\t€\tQuant.\tTotal\n");

        for(int i = 0; i < ItemIndex; i++){
            sb.append(this.items[i].toString())
                    .append("\n");
        }
        sb.append("\nTotal amount: " )
                .append(calcularTotal())
                .append("€");

        return sb.toString();
    }

    @Override
    public String toString() {
        return generateDetail();
    }
}

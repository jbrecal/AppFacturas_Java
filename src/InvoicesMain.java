import org.juanbrenes.appfacturas.model.*;

import java.util.Scanner;

public class InvoicesMain {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setNif("78989898C");
        customer.setName("Juan");

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the description of the invoice");
        String desc = sc.nextLine();
        Invoice invoice = new Invoice(desc, customer);

        Product product;
        String name;
        float price;
        int quantity;

        System.out.println();

        for(int i = 0; i < 2; i++){
            product = new Product();
            System.out.print("Insert product nº " + product.getId() + ": ");
            name = sc.next();
            product.setName(name);

            System.out.print("Insert price: ");
            price = sc.nextFloat();
            product.setPrice(price);

            System.out.print("Insert quantity: ");
            quantity = sc.nextInt();

            InvoiceItem item = new InvoiceItem(quantity, product);
            invoice.addInvoiceItem(item);

            System.out.println();
        }
        System.out.println(invoice);
    }
}

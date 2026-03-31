package inventorProduct;

import java.util.*;
import java.util.regex.*;
 abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateRevenue();   // price * quantity

    public abstract void printDetails();
}
class Electronics extends Product {
    private String brand;
    private int warranty;

    public Electronics(String id, String name, double price, int quantity,
                       String brand, int warranty) {
        super(id, name, price, quantity);
        this.brand = brand;
        this.warranty = warranty;
    }

    @Override
    public double calculateRevenue() {
        return price * quantity;
    }

    @Override
    public void printDetails() {
        System.out.println(id + " " + name + " " + price + " " + quantity
                + " " + brand + " " + warranty);
    }
}
 class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(String id, String name, double price, int quantity,
                    String size, String color) {
        super(id, name, price, quantity);
        this.size = size;
        this.color = color;
    }

    @Override
    public double calculateRevenue() {
        return price * quantity;
    }

    @Override
    public void printDetails() {
        System.out.println(id + " " + name + " " + price + " " + quantity
                + " " + size + " " + color);
    }
}
class InventoryManager {
    private List<Product> list = new ArrayList<>();

    public void addProduct(Product p) {
        list.add(p);
        System.out.println(p.getName() + " added");
    }

    public void printInventory() {
        System.out.println("Inventory:");
        for (Product p : list) {
            p.printDetails();
        }
    }

    public void printTotalRevenue() {
        double total = 0;
        for (Product p : list) {
            total += p.calculateRevenue();
        }
        System.out.printf("Total Revenue: %.2f\n", total);
    }
}
public class ProductMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        int n = Integer.parseInt(sc.nextLine());

        Pattern pattern = Pattern.compile("^TN-\\d{3}[A-Z]$");

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();

            if (input.startsWith("Electronics")) {

                String[] parts = input.split(":");

                String id = parts[1].replace("\"", "");
                Matcher matcher = pattern.matcher(id);

                if (!matcher.matches()) {
                    System.out.println("Invalid ID");
                    return;
                }

                String name = parts[2].replace("\"", "");
                String[] priceQty = parts[3].split(",");

                double price = Double.parseDouble(priceQty[0]);
                int quantity = Integer.parseInt(priceQty[1]);

                String brand = parts[4].replace("\"", "");
                int warranty = Integer.parseInt(parts[5].replace(".", ""));

                manager.addProduct(
                        new Electronics(id, name, price, quantity, brand, warranty)
                );
            }

            else if (input.startsWith("Clothing")) {

                String[] parts = input.split(":");

                String id = parts[1].replace("\"", "");
                Matcher matcher = pattern.matcher(id);

                if (!matcher.matches()) {
                    System.out.println("Invalid ID");
                    return;
                }

                String name = parts[2].replace("\"", "");
                String[] priceQty = parts[3].split(",");

                double price = Double.parseDouble(priceQty[0]);
                int quantity = Integer.parseInt(priceQty[1]);

                String size = parts[4].replace("\"", "");
                String color = parts[5].replace("\"", "");

                manager.addProduct(
                        new Clothing(id, name, price, quantity, size, color)
                );
            }
        }

        System.out.println();
        manager.printInventory();

        System.out.println();
        manager.printTotalRevenue();
    }
}
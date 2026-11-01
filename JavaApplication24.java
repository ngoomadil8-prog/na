
package javaapplication24;

import java.util.ArrayList;
import java.util.List;


public class JavaApplication24 {

     
    public static void main(String[] args) {
 OrderBox<Integer> small = new OrderBox<>();
    small.add(new Order<>("Burger", 15));
    small.add(new Order<>("Pizza", 25));

    OrderBox<Double> large = new OrderBox<>();
    large.add(new Order<>("Family Meal", 55.5));
    large.add(new Order<>("Seafood", 70.0));

    List<Number> prices = new ArrayList<>();
    small.export(prices);
    large.export(prices);

    System.out.println("RESTAURANT ORDER SYSTEM");
    System.out.println("Prices: " + prices);
    System.out.println("Total: " + OrderManager.total(prices));

    List<Object> orders = new ArrayList<>();
    small.copyTo(orders);
    large.copyTo(orders);
    System.out.println("Orders: " + orders);

    List<Object> defaults = new ArrayList<>();
    OrderManager.addDefaults(defaults);
    System.out.println("Default Prices: " + defaults);
}
}
class Order<T extends Number> { String name; T price;
Order(String name, T price) {
    this.name = name;
    this.price = price;
}

public String toString() {
    return name + ": " + price + " LYD";
}
}
class OrderBox<T extends Number> { List<Order<T>> list = new ArrayList<>();
void add(Order<T> order) {
    list.add(order);
}

void export(List<? super T> dest) {
    for (Order<T> order : list)
        dest.add(order.price);
}

void copyTo(List<? super Order<T>> dest) {
    dest.addAll(list);
}
}
class OrderManager { static double total(List<? extends Number> prices) { double sum = 0; for (Number p : prices) sum += p.doubleValue(); return sum; }
static void addDefaults(List<? super Number> list) {
    list.add(10);
    list.add(20.5);
}
}
    
    


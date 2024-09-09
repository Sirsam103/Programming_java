import java.util.HashMap;
import java.util.Map;

public class GroceryListManager2 {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, cost);
        }
    }

    public void removeItem(String item) {
        groceryList.remove(item);
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is empty.");
        } else {
            System.out.println("Grocery List:");
            int index = 1;
            for (Map.Entry<String, Double> entry : groceryList.entrySet()) {
                System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue() + "€");
                index++;
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (double cost : groceryList.values()) {
            total += cost;
        }
        return total;
    }

    public static void main(String[] args) {
        GroceryListManager2 groceryManager = new GroceryListManager2();

        groceryManager.addItem("Beer", 2.99);
        groceryManager.addItem("Broccoli", 3.49);
        groceryManager.addItem("Sausage", 1.99);

        groceryManager.displayList();

        System.out.println("\nIs \"Broccoli\" in the grocery list? " + groceryManager.checkItem("Broccoli"));

        groceryManager.removeItem("Broccoli");
        System.out.println("\nRemoving \"Broccoli\" from the list...");

        groceryManager.displayList();

        System.out.println("\nTotal cost of the grocery list: " + groceryManager.calculateTotalCost() + "€");
    }
}

import java.util.HashMap;
import java.util.Map;

public class GroceryListManager3 {
    private HashMap<String, Item> groceryList = new HashMap<>();

    private static class Item {
        double cost;
        String category;

        public Item(double cost, String category) {
            this.cost = cost;
            this.category = category;
        }

        public double getCost() {
            return cost;
        }

        public String getCategory() {
            return category;
        }
    }

    public void addItem(String item, double cost, String category) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, new Item(cost, category));
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
            for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
                System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue().getCost() + "€ (" + entry.getValue().getCategory() + ")");
                index++;
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double total = 0.0;
        for (Item item : groceryList.values()) {
            total += item.getCost();
        }
        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category \"" + category + "\":");
        int index = 1;
        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
            if (entry.getValue().getCategory().equalsIgnoreCase(category)) {
                System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue().getCost() + "€");
                index++;
            }
        }
        if (index == 1) {
            System.out.println("No items found in this category.");
        }
    }

    public static void main(String[] args) {
        GroceryListManager3 groceryManager = new GroceryListManager3();

        groceryManager.addItem("Beer", 2.99, "Beverages");
        groceryManager.addItem("Broccoli", 3.49, "Vegetables");
        groceryManager.addItem("Sausage", 1.99, "Meat");

        groceryManager.displayList();

        System.out.println("\nIs \"Broccoli\" in the grocery list? " + groceryManager.checkItem("Broccoli"));

        groceryManager.removeItem("Broccoli");
        System.out.println("\nRemoving \"Broccoli\" from the list...");

        groceryManager.displayList();

        System.out.println("\nTotal cost of the grocery list: " + groceryManager.calculateTotalCost() + "€");

        System.out.println("\nDisplaying items in category \"Beverages\":");
        groceryManager.displayByCategory("Beverages");
    }
}

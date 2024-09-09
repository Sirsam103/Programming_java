import java.util.HashMap;
import java.util.Map;

public class GroceryListManager4 {
    private HashMap<String, Item> groceryList = new HashMap<>();

    private static class Item {
        double cost;
        String category;
        int quantity;

        public Item(double cost, String category, int quantity) {
            this.cost = cost;
            this.category = category;
            this.quantity = quantity;
        }

        public double getCost() {
            return cost;
        }

        public String getCategory() {
            return category;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public void addItem(String item, double cost, String category, int quantity) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, new Item(cost, category, quantity));
        } else {
            Item existingItem = groceryList.get(item);
            existingItem.setQuantity(existingItem.getQuantity() + quantity); // Add to the existing quantity
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (groceryList.containsKey(item)) {
            groceryList.get(item).setQuantity(newQuantity);
        } else {
            System.out.println("Item \"" + item + "\" not found in the grocery list.");
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
                System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue().getCost() + "€ (" + entry.getValue().getCategory() + "), Quantity: " + entry.getValue().getQuantity());
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
            total += item.getCost() * item.getQuantity();
        }
        return total;
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category \"" + category + "\":");
        int index = 1;
        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
            if (entry.getValue().getCategory().equalsIgnoreCase(category)) {
                System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue().getCost() + "€" + ", Quantity: " + entry.getValue().getQuantity());
                index++;
            }
        }
        if (index == 1) {
            System.out.println("No items found in this category.");
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available items:");
        int index = 1;
        for (Map.Entry<String, Item> entry : groceryList.entrySet()) {
            if (entry.getValue().getQuantity() > 0) {
                System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue().getCost() + "€" + ", Quantity: " + entry.getValue().getQuantity());
                index++;
            }
        }
        if (index == 1) {
            System.out.println("No available items.");
        }
    }

    public static void main(String[] args) {
        GroceryListManager4 groceryManager = new GroceryListManager4();

        groceryManager.addItem("Beer", 2.99, "Beverages", 6);
        groceryManager.addItem("Broccoli", 3.49, "Vegetables", 3);
        groceryManager.addItem("Sausage", 1.99, "Meat", 16);

        groceryManager.displayList();

        System.out.println("\nIs \"Broccoli\" in the grocery list? " + groceryManager.checkItem("Broccoli"));

        groceryManager.removeItem("Broccoli");
        System.out.println("\nRemoving \"Broccoli\" from the list...");

        groceryManager.displayList();

        System.out.println("\nTotal cost of the grocery list: " + groceryManager.calculateTotalCost() + "€");

        System.out.println("\nDisplaying items in category \"Beverages\":");
        groceryManager.displayByCategory("Beverages");

        groceryManager.updateQuantity("Sausage", 8);
        System.out.println("\nUpdated quantity of sausage:");
        groceryManager.displayList();

        System.out.println("\nDisplaying available items:");
        groceryManager.displayAvailableItems();
    }
}

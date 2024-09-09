import java.util.HashMap;
import java.util.Map;

public class GroceryListManager5 {
    private HashMap<String, ShoppingList> shoppingLists = new HashMap<>();

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

    public static class ShoppingList {
        private String purpose;
        private HashMap<String, Item> items;

        public ShoppingList(String purpose) {
            this.purpose = purpose;
            this.items = new HashMap<>();
        }

        public void addItem(String item, double cost, String category, int quantity) {
            if (!items.containsKey(item)) {
                items.put(item, new Item(cost, category, quantity));
            } else {
                Item existingItem = items.get(item);
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
            }
        }

        public void displayList() {
            if (items.isEmpty()) {
                System.out.println("The shopping list for " + purpose + " is empty.");
            } else {
                System.out.println("Shopping List for " + purpose + ":");
                int index = 1;
                for (Map.Entry<String, Item> entry : items.entrySet()) {
                    System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue().getCost() + "€ (" + entry.getValue().getCategory() + "), Quantity: " + entry.getValue().getQuantity());
                    index++;
                }
            }
        }

        public double calculateTotalCost() {
            double total = 0.0;
            for (Item item : items.values()) {
                total += item.getCost() * item.getQuantity();
            }
            return Math.round(total * 100.0) / 100.0;
        }
    }

    public void createShoppingList(String purpose) {
        if (!shoppingLists.containsKey(purpose)) {
            shoppingLists.put(purpose, new ShoppingList(purpose));
        } else {
            System.out.println("A shopping list for this purpose already exists.");
        }
    }

    public void addItemToShoppingList(String purpose, String item, double cost, String category, int quantity) {
        if (shoppingLists.containsKey(purpose)) {
            shoppingLists.get(purpose).addItem(item, cost, category, quantity);
        } else {
            System.out.println("Shopping list for \"" + purpose + "\" not found.");
        }
    }

    public void displayShoppingList(String purpose) {
        if (shoppingLists.containsKey(purpose)) {
            shoppingLists.get(purpose).displayList();
        } else {
            System.out.println("Shopping list for \"" + purpose + "\" not found.");
        }
    }

    public void displayAllShoppingLists() {
        if (shoppingLists.isEmpty()) {
            System.out.println("No shopping lists available.");
        } else {
            for (String purpose : shoppingLists.keySet()) {
                displayShoppingList(purpose);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        GroceryListManager5 groceryManager = new GroceryListManager5();

        groceryManager.createShoppingList("Backyard BBQ");
        groceryManager.addItemToShoppingList("Backyard BBQ", "Beer", 1.49, "Beverages", 36);
        groceryManager.addItemToShoppingList("Backyard BBQ", "Sausage", 0.49, "Meat", 24);
        groceryManager.addItemToShoppingList("Backyard BBQ", "Buns", 0.29, "Bakery", 16);

        groceryManager.createShoppingList("Weekend Camping");
        groceryManager.addItemToShoppingList("Weekend Camping", "Water", 0.89, "Beverages", 6);
        groceryManager.addItemToShoppingList("Weekend Camping", "Canned Beans", 1.50, "Canned Goods", 4);

        groceryManager.displayAllShoppingLists();

        System.out.println("Total cost of Backyard BBQ list: " + groceryManager.shoppingLists.get("Backyard BBQ").calculateTotalCost() + "€");
    }
}

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (!groceryList.contains(item)) {
            groceryList.add(item);
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
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager groceryManager = new GroceryListManager();

        groceryManager.addItem("Beer");
        groceryManager.addItem("Sausage");
        groceryManager.addItem("Broccoli");

        groceryManager.displayList();

        System.out.println("\nIs \"Broccoli\" in the grocery list? " + groceryManager.checkItem("Broccoli"));

        groceryManager.removeItem("Broccoli");
        System.out.println("\nRemoving \"Broccoli\" from the list...");

        groceryManager.displayList();
    }
}

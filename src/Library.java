import java.util.ArrayList;
import java.util.List;

// Class using the Singleton Pattern
class Library {
    private static Library instance; // The single instance
    private List<Item> items; // List to store items

    // Assign ArrayList to items to store objects of Item class
    private Library() {
        items = new ArrayList<Item>();
    }

    // Method to get single instance
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
    return instance;
    }
    // Method to add items to library
    void addItem(Item item) {
        items.add(item);
    }
    // Method to show all items in library
    void listAvailableItems() {
        for (Item item : items) {
            System.out.println("Title : " + item.getTitle());
        }
    }
    // Search library method
    void findItemByTitle(String title) {
    for (Item item : items) {
        if (item.getTitle().equals(title)) {
            System.out.println("Item found: " + item.getTitle());
            return;
           }
        }
        System.out.println("Item not found");
    }
}
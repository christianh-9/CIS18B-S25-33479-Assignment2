public class LibraryTest {
    public static void main(String[] args) {
        // Using the factory pattern to create 2 books and 1 magazine
    Item book1 = LibraryItemFactory.createItem("Book", "Data Structures and Algorithms", "Micahel Goodrich", 1997, "97849340934");

    Item book2 = LibraryItemFactory.createItem("Book", "C++ Programming", "Bjarne Stroustrup", 2013, "0275954902");

    Item magazine = LibraryItemFactory.createItem("Magazine", "The Coding Manual", " ", 2024, "320");

    // Singleton pattern instance
    Library library = Library.getInstance();

    // Add our items to its library
    library.addItem(book1);
    library.addItem(book2);
    library.addItem(magazine);

    // Output all available items
    System.out.println("Available Items:");
    library.listAvailableItems();

    // Search method
    System.out.println("Lets Search for 'C++ Programming':");
    library.findItemByTitle("C++ Programming");

    // Demonstrate the borrow and return book functionality
    System.out.println("Christian will borrow 'Data Structures and Algorithms':");
    if (book1 instanceof Book) {
        ((Book) book1).borrowItem("Christian");
    }

    System.out.println("Sarah will try to borrow 'Data Structures and Algorithms':");
    if (book1 instanceof Book) {
        ((Book) book1).borrowItem("Sarah");
    }

    System.out.println("Christian will now return 'Data Structures and Algorithms':");
    if (book1 instanceof Book) {
        ((Book) book1).returnItem();
    }
    System.out.println("John will now try borrowing 'Data Structures and Algorithms':");
    if (book1 instanceof Book) {
        ((Book) book1).borrowItem("John");
       }
    }
}

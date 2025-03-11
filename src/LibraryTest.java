public class LibraryTest {
    public static void main(String[] args) {
        // Using the factory pattern to create 2 books and 1 magazine
    Item book1 = LibraryItemFactory.createItem("Book", "Data Structures and Algorithms", 1997, "Micahel Goodrich", "3094242323");

    Item book2 = LibraryItemFactory.createItem("Book", "C++ Programming", 2013, "Bjarne Stroustrup", "0275954902");

    Item magazine = LibraryItemFactory.createItem("Magazine", "The Coding Manual", 2024, "320", " ");

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

    System.out.println("Now we check if the book is borrowed");
    if (book1 instanceof Book) {
        if (((Book) book1).isBorrowed()) {
            System.out.println("The book is already borrowed");
            }
        else {
            System.out.println("The book is not borrowed");
            }
        }
    }
}

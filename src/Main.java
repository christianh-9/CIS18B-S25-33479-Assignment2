interface IBorrowable {
    void borrowItem(String borrower);
    void returnItem();
    Boolean isBorrowed();
}

class Item {
    private String title;
    private int publicationYear;

    // Constructor for Item
    Item(String t, int p) {
        title = t;
        publicationYear = p;
    }
    // Getter methods
    String getTitle() {
        return title;
    }
    int getPublicationYear() {
        return publicationYear;
    }
}

class Book extends Item implements IBorrowable {
    private String author;
    private String ISBN;
    private String borrower;

    // Constructor for Book
    Book(String t, int p, String a, String i) {
        super(t, p);
        author = a;
        ISBN = i;
        borrower = null;
    }
    // Getter methods
    String getAuthor() {
        return author;
    }
    String getISBN() {
        return ISBN;
    }
        // Implement interface methods
        public void borrowItem(String borrower) {
            if (this.borrower == null) {
                this.borrower = borrower;
                System.out.println("Borrowed: " + borrower);
            }
            else {
                System.out.println("Already Borrowed by: " + this.borrower);
            }
        }
        public void returnItem(){
            if (this.borrower != null) {
                System.out.println(this.borrower + " has returned the book");
                Book.this.borrower = null;
            }
            else {
                System.out.println("This book has not been borrowed");
            }
        }
        public Boolean isBorrowed() {
            return this.borrower != null;
        }
    }

class Magazine extends Item {
    private int issueNumber;

    // Constructor for magazine
    Magazine(String t, int p, int i) {
        super(t, p);
        issueNumber = i;
    }
    // Getter method
    int getIssueNumber() {
        return issueNumber;
    }
}
// Factory pattern class to create a book or magazine
class LibraryItemFactory {
    public static Item createItem(String type, String title, String author, int publicationYear, String extraData) {
        // To create a book object
        if (type.equalsIgnoreCase("Book")) {
            return new Book(title, publicationYear, author, extraData);
        }
        // To create a magazine object
        else if (type.equalsIgnoreCase("Magazine")) {
            int issueNumber = Integer.parseInt(extraData);
            return new Magazine(title, publicationYear, issueNumber);
        }
        // Exception handling for other types
        else {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}

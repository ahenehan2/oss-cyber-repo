import java.util.*;

/**
 * BookManager class to manage a collection of books. 
 * Supports operations such as adding, removing, searching, listing, and sorting books.
 */
public class BookManager {
    /**
     * Book class represents a single book with a title, author, year of publication, and ISBN.
     */
    private static class Book {
        private String title;
        private String author;
        private int year;
        private String isbn;

        /**
         * Constructor for the Book class.
         */
        public Book(String title, String author, int year, String isbn) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.isbn = isbn;
        }

        // Getter methods to access book attributes.
        public String getTitle() { 
            return title; 
        }
        public String getAuthor() { 
            return author; 
        }
        public int getYear() { 
            return year; 
        }
        public String getIsbn() { 
            return isbn; 
        }

        /**
         * Returns a string representation of the book.
         */
        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", Year: " + year + ", ISBN: " + isbn;
        }
    }

    private final Map<String, Book> booksByIsbn; // Stores books using ISBN as the key.

    /**
     * Constructor for the BookManager class.
     */
    public BookManager() {
        booksByIsbn = new HashMap<>();
    }

    /**
     * Adds a new book to the collection.
     * Prevents duplicate ISBN entries.
     */
    public boolean addBook(String title, String author, int year, String isbn) {
        if (booksByIsbn.containsKey(isbn)) {
            return false; // Duplicate ISBN detected
        }
        booksByIsbn.put(isbn, new Book(title, author, year, isbn));
        return true;
    }

    /**
     * Removes a book from the collection by its ISBN.
     */
    public boolean removeBook(String isbn) {
        return booksByIsbn.remove(isbn) != null;
    }

    /**
     * Searches for books by title or author (case-insensitive).
     */
    public List<Book> findBooksByTitleOrAuthor(String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksByIsbn.values()) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Returns a list of all books in the collection.
     */
    public List<Book> listBooks() {
        return new ArrayList<>(booksByIsbn.values());
    }

    /**
     * Sorts the books based on a provided comparator (title, author, or year).
     */
    public List<Book> sortBooks(Comparator<Book> comparator) {
        List<Book> sortedBooks = listBooks();
        sortedBooks.sort(comparator);
        return sortedBooks;
    }

    /**
     * Main method to test the BookManager functionalities.
     */
    public static void main(String[] args) {
        BookManager manager = new BookManager();

        // Adding sample books to the collection.
        manager.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565");
        manager.addBook("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084");
        manager.addBook("1984", "George Orwell", 1949, "9780451524935");

        // Display all books.
        System.out.println("All Books:");
        for (Book book : manager.listBooks()) {
            System.out.println(book);
        }

        // Find and display books by a specific author.
        System.out.println("\nBooks by George Orwell:");
        for (Book book : manager.findBooksByTitleOrAuthor("George Orwell")) {
            System.out.println(book);
        }

        // Display books sorted by title.
        System.out.println("\nBooks Sorted by Title:");
        for (Book book : manager.sortBooks(Comparator.comparing(Book::getTitle))) {
            System.out.println(book);
        }
    }
}
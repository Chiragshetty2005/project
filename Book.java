import java.util.*;
import java.io.*;

class Book {
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(int bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author +
                ", Genre: " + genre + ", Available: " + isAvailable;
    }
}

class User {
    private int userId;
    private String name;
    private String userType;
    private List<Integer> borrowedBooks;

    public User(int userId, String name, String userType) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }

    public List<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(int bookId) {
        borrowedBooks.add(bookId);
    }

    public void returnBook(int bookId) {
        borrowedBooks.remove((Integer) bookId);
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", User Type: " + userType + ", Borrowed Books: " + borrowedBooks;
    }
}

class Library {
    private List<Book> books;
    private Map<Integer, User> users;

    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
    }

    public Book searchBook(String keyword) {
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) || book.getGenre().contains(keyword)) {
                return book;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void borrowBook(int userId, int bookId) {
        User user = users.get(userId);
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                user.borrowBook(bookId);
                System.out.println("Book borrowed successfully!");
                return;
            }
        }
        System.out.println("Book is not available!");
    }

    public void returnBook(int userId, int bookId) {
        User user = users.get(userId);
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.isAvailable()) {
                book.setAvailable(true);
                user.returnBook(bookId);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book is not borrowed by this user!");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", "Fiction"));
        library.addBook(new Book(3, "1984", "George Orwell", "Dystopian"));

        // Adding sample users
        library.addUser(new User(1, "Alice", "Student"));
        library.addUser(new User(2, "Bob", "Teacher"));

        // Display all books
        System.out.println("Books in the library:");
        library.displayBooks();

        // Display all users
        System.out.println("\nUsers in the library:");
        library.displayUsers();

        // Borrow a book
        System.out.println("\nBorrowing a book:");
        library.borrowBook(1, 1);

        // Try to borrow the same book again
        System.out.println("\nTrying to borrow the same book:");
        library.borrowBook(2, 1);

        // Return the book
        System.out.println("\nReturning the book:");
        library.returnBook(1, 1);

        // Display all books after borrowing and returning
        System.out.println("\nBooks in the library after transactions:");
        library.displayBooks();
    }
}

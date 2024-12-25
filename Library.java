import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to hold the books (we will use a fixed size array for simplicity)
        String[] books = new String[100];
        String[] authors = new String[100];
        int[] years = new int[100];
        int bookCount = 0;  // Keeps track of the number of books

        while (true) {
            // Display menu
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Remove a Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:  // Add a Book
                    if (bookCount < 100) {
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter year of publication: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        books[bookCount] = title;
                        authors[bookCount] = author;
                        years[bookCount] = year;
                        bookCount++;
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Library is full. Cannot add more books.");
                    }
                    break;

                case 2:  // View All Books
                    if (bookCount == 0) {
                        System.out.println("No books available in the library.");
                    } else {
                        System.out.println("\nBooks in the Library:");
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println("Title: " + books[i] + ", Author: " + authors[i] + ", Year: " + years[i]);
                        }
                    }
                    break;

                case 3:  // Remove a Book
                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = scanner.nextLine();
                    boolean found = false;

                    // Find the book and remove it
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].equalsIgnoreCase(removeTitle)) {
                            // Shift books to remove the selected book
                            for (int j = i; j < bookCount - 1; j++) {
                                books[j] = books[j + 1];
                                authors[j] = authors[j + 1];
                                years[j] = years[j + 1];
                            }
                            bookCount--;
                            found = true;
                            System.out.println("Book removed successfully.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:  // Search for a Book
                    System.out.print("Enter book title or author to search: ");
                    String searchQuery = scanner.nextLine();
                    boolean bookFound = false;

                    // Search for the book by title or author
                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].equalsIgnoreCase(searchQuery) || authors[i].equalsIgnoreCase(searchQuery)) {
                            System.out.println("Found Book: Title: " + books[i] + ", Author: " + authors[i] + ", Year: " + years[i]);
                            bookFound = true;
                        }
                    }

                    if (!bookFound) {
                        System.out.println("No matching books found.");
                    }
                    break;

                case 5:  // Exit
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

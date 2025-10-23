import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String toString() {
        return "Book ID: " + bookId + " | Title: " + title + " | Author: " + author + " | Status: " + (isIssued ? "Issued" : "Available");
    }
}

class User {
    int userId;
    String userName;

    User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String toString() {
        return "User ID: " + userId + " | Name: " + userName;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    // Add a new book
    void addBook(int id, String title, String author) {
        Book b = new Book(id, title, author);
        books.add(b);
        System.out.println("Book added successfully!\n");
    }

    // View all books
    void viewBooks() {
        if (books.size() == 0) {
            System.out.println("No books available in the library.\n");
            return;
        }
        System.out.println("\nList of Books:");
        for (Book b : books) {
            System.out.println(b);
        }
        System.out.println();
    }

    // Add a new user
    void addUser(int id, String name) {
        User u = new User(id, name);
        users.add(u);
        System.out.println("User added successfully!\n");
    }

    // Issue a book
    void issueBook(int bookId, int userId) {
        Book foundBook = null;
        for (Book b : books) {
            if (b.bookId == bookId) {
                foundBook = b;
                break;
            }
        }

        if (foundBook == null) {
            System.out.println("Book not found!\n");
            return;
        }

        if (foundBook.isIssued) {
            System.out.println("Book is already issued!\n");
            return;
        }

        boolean userExists = false;
        for (User u : users) {
            if (u.userId == userId) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            System.out.println("User not found!\n");
            return;
        }

        foundBook.isIssued = true;
        System.out.println("Book issued successfully to User ID: " + userId + "\n");
    }

    // Return a book
    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!\n");
                } else {
                    System.out.println("This book was not issued.\n");
                }
                return;
            }
        }
        System.out.println("Book not found!\n");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice = 0;

        while (choice != 6) {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    lib.addBook(bookId, title, author);
                    break;

                case 2:
                    lib.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    lib.addUser(userId, name);
                    break;

                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    int issueBookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int issueUserId = sc.nextInt();
                    lib.issueBook(issueBookId, issueUserId);
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;

                case 6:
                    System.out.println("Exiting... Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again!\n");
                    break;
            }
        }

        sc.close();
    }
}

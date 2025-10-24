import java.io.*;
import java.util.*;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("=== Simple Notes Manager ===");

        do {
            System.out.println("\n1. Add Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Delete All Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    deleteNotes();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }


    private static void addNote() {
        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // Read and display all notes
    private static void viewNotes() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No notes found. Add some notes first!");
            return;
        }

        System.out.println("\n--- Your Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(count++ + ". " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }


    private static void deleteNotes() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.close(); // overwrites the file with empty content
            System.out.println("All notes deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error deleting notes: " + e.getMessage());
        }
    }
}

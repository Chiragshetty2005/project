import java.util.Scanner;

public class TodoListSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arrays to hold tasks and their details
        String[] tasks = new String[100];
        String[] dueDates = new String[100];
        boolean[] isCompleted = new boolean[100];
        int taskCount = 0;  // Keeps track of the number of tasks

        while (true) {
            // Display menu
            System.out.println("\nTo-Do List Management System");
            System.out.println("1. Add a Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove a Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:  // Add a Task
                    if (taskCount < 100) {
                        System.out.print("Enter task description: ");
                        String task = scanner.nextLine();
                        System.out.print("Enter due date (e.g., YYYY-MM-DD): ");
                        String dueDate = scanner.nextLine();

                        tasks[taskCount] = task;
                        dueDates[taskCount] = dueDate;
                        isCompleted[taskCount] = false;  // Task is not completed initially
                        taskCount++;
                        System.out.println("Task added successfully.");
                    } else {
                        System.out.println("To-Do list is full. Cannot add more tasks.");
                    }
                    break;

                case 2:  // View All Tasks
                    if (taskCount == 0) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nTasks in the To-Do List:");
                        for (int i = 0; i < taskCount; i++) {
                            String status = isCompleted[i] ? "Completed" : "Pending";
                            System.out.println((i + 1) + ". " + tasks[i] + " | Due Date: " + dueDates[i] + " | Status: " + status);
                        }
                    }
                    break;

                case 3:  // Mark Task as Completed
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    if (taskNumber > 0 && taskNumber <= taskCount) {
                        isCompleted[taskNumber - 1] = true;
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:  // Remove a Task
                    System.out.print("Enter task number to remove: ");
                    int removeTaskNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    if (removeTaskNumber > 0 && removeTaskNumber <= taskCount) {
                        // Shift tasks to remove the selected task
                        for (int i = removeTaskNumber - 1; i < taskCount - 1; i++) {
                            tasks[i] = tasks[i + 1];
                            dueDates[i] = dueDates[i + 1];
                            isCompleted[i] = isCompleted[i + 1];
                        }
                        taskCount--;
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Invalid task number.");
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

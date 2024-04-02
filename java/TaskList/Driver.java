import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Task Management Application: Create a task management application that allows users to add, update, and
  organize tasks, set due dates, and prioritize tasks based on their importance.
  Note that this is a prototype, and all data is cleared from the memory when the program stops running. */

public class Driver {
    private final List<Task> taskList = new ArrayList<>();


    // Add a task to the ArrayList.
    private void addTask(Task task){
        taskList.add(task);

    }

    // View the tasks in the ArrayList.
    private void viewTasks(){
        for (Task task: taskList){
            System.out.println("Task ID: " + task.getId() + "\n" + "Title: " + task.getTitle() + "\n" + "Details: " + task.getBody() + "\n" + "Priority: " + task.getPriority() + "\n" + "Owner: " + task.getOwner() + "\n" + "Assignee: " + task.getAssignee() + "\n" + "Status: " + task.getStatus() + "\n --- \n");
        }
    }

    // View the task titles.
    private void viewTaskTitles(){
        for (Task task: taskList){
            System.out.println("Task ID: \n" + task.getId() + "\n" + "Title: \n" + task.getTitle() + "\n" + "Status: \n" + task.getStatus());
        }
    }

    // Update a task.
    private void updateTask(int id){
        for(Task task: taskList){
            if (task.getId() == id){
                System.out.println("""
                        What do you want to update? Enter the number for the field you want to update.\s
                        (1) Title
                        (2) Body
                        (3) Priority
                        (4) Assignee
                        (5) Owner
                        (6) Status
                        """);
                Scanner scanner = new Scanner(System.in);
                int fieldToUpdate = scanner.nextInt();
                switch (fieldToUpdate) {
                    case 1 -> {
                        System.out.println("Enter a new title.");
                        try {
                            boolean scannerExists = scanner.hasNext();
                            if (scannerExists) {
                                int i = 0;
                                while (i <= 1) {
                                    String title = scanner.nextLine();
                                    task.setTitle(title);
                                    i++;
                                }
                                String newTitle = task.getTitle();
                                System.out.println("The new task title is: " + newTitle);
                            } else {
                                System.out.println("There was an issue.");
                            }
                        } catch (Exception e) {
                            System.out.println("Unable to update the title.");
                            System.exit(0);
                        }
                    }

                    case 2 -> {
                        System.out.println("Enter a new body.");
                        boolean scannerExists = scanner.hasNext();
                        try {
                            if (scannerExists) {
                                int i = 0;
                                while (i <= 1) {
                                    String body = scanner.nextLine();
                                    task.setBody(body);
                                    i++;
                                }
                                String newBody = task.getBody();
                                System.out.println("The new task body is: " + newBody);
                            }
                        } catch (Exception e) {
                            System.out.println("Unable to enter new body.");
                            System.exit(0);
                        }
                    }
                    case 3 -> {
                        System.out.println("Enter 0 for Low, 1 for Medium, or 2 for High priority.");
                        int priority = scanner.nextInt();
                        String[] priorities = {"Low", "Medium", "High"};
                        if (priority == 0) {
                            task.setPriority(priorities[0]);
                            System.out.println("The task's new priority is: " + priorities[0]);
                        } else if (priority == 1) {
                            task.setPriority(priorities[1]);
                            System.out.println("The task's new priority is: " + priorities[1]);
                        } else if (priority == 2) {
                            task.setPriority(priorities[2]);
                            System.out.println("The task's new priority is: " + priorities[2]);
                        } else {
                            System.out.println("You must enter either 0, 1, or 2 to set a priority level.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Enter a new assignee.");
                        boolean scannerExists = scanner.hasNext();
                            try {
                                if (scannerExists) {
                                    int i = 0;
                                    while (i <= 1) {
                                        String assignee = scanner.nextLine();
                                        task.setAssignee(assignee);
                                        i++;
                                    }
                                    String newAssignee = task.getAssignee();
                                    System.out.println("The new task assignee is: " + newAssignee);
                                }
                            } catch (Exception e){
                                System.out.println("Unable to update the assignee.");
                                System.exit(0);
                            }

                    }
                    case 5 -> {
                        System.out.println("Enter a new owner.");
                        boolean scannerExists = scanner.hasNext();
                        try {
                            if (scannerExists) {
                                int i = 0;
                                while (i <= 1) {
                                    String owner = scanner.nextLine();
                                    task.setOwner(owner);
                                    i++;
                                }
                                String newOwner = task.getOwner();
                                System.out.println("The new task owner is: " + newOwner);
                            }
                        } catch (Exception e){
                            System.out.println("Unable to update owner.");
                            System.exit(0);
                        }
                    }
                    case 6 -> {
                        System.out.println("""
                                           Enter ONE of the following options to update the status:
                                           (0) Not Started
                                           (1) In Progress
                                           (2) Blocked
                                           (3) Done
                                           """);
                        boolean scannerExists = scanner.hasNext();
                        String[] statuses = {"Not Started","In Progress", "Blocked", "Done"};
                        try {
                            if (scannerExists) {
                                int statusOptions = scanner.nextInt();
                                switch (statusOptions) {
                                    case 0 ->
                                        task.setStatus(statuses[0]);
                                    case 1 ->
                                        task.setStatus(statuses[1]);
                                    case 2 ->
                                        task.setStatus(statuses[2]);
                                    case 3 ->
                                        task.setStatus(statuses[3]);
                                    default ->
                                            task.setStatus("Status not set.");
                                }
                                String newStatus = task.getStatus();
                                System.out.println("The new task status is: " + newStatus);
                            }

                        } catch (Exception e){
                            System.out.println("Unable to update status.");
                            System.exit(0);
                        }
                    }
                    default -> System.out.println("You are returning to the main menu.");
                }
            }
        }
    }

    // Delete a task from the ArrayList.
    private void deleteTaskById(int id){
        taskList.removeIf(task -> task.getId() == id);
        viewTasks();
        emptyCheck();
    }

    // Check to see if the ArrayList is empty.
    private void emptyCheck(){
        boolean noTasks = taskList.isEmpty();
        if (noTasks) {
            System.out.println("There are no tasks in the task list.");
        }
    }

    // Delete all the tasks from the ArrayList and check to see if it is empty.
    private void deleteAllTasks(List<Task> taskList){
        taskList.clear();
        emptyCheck();
    }

    // Display menu options to the user.
    public void menuOptions(){
        System.out.println("""
                What would you like to do today?
                (1) Create a new task.
                (2) View all tasks.
                (3) Update a task.
                (4) Delete a task.
                (5) Delete all tasks.
                (6) Exit the program.
                Enter the number for the action you would like to take.
                """);
    }

    // Create a task object.
    private Task createTask(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\t,\t");
        System.out.println("Enter task id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the task title: ");
        String title = scanner.nextLine();
        System.out.println("Enter the task details: ");
        String body = scanner.nextLine();
        System.out.println("Enter the task priority: 0 for Low, 1 for Medium, or 2 for High: ");
        String priority = scanner.nextLine(); // Change it so that we have a switch statement here, pointing to objects in a priorities array.
        LocalDate createDate = LocalDate.now();
        System.out.println("Enter the task due date in YYYY-MM-DD format: ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter the task assignee: ");
        String assignee = scanner.nextLine();
        System.out.println("Enter the task owner: ");
        String owner = scanner.nextLine();
        String status = "Not Started";
        System.out.println("You have created a task! Task details:\n");
        String header = "ID\tTitle\tPriority\tCreate Date\tDue Date\tAssignee\tOwner\tStatus\tDetails";
        System.out.println(header + "\n" + id + "\t" + title + "\t"  + priority + "\t" + createDate + "\t" + dueDate + "\t" + assignee + "\t" + owner + "\t" + status + "\t" + body);
        return new Task(id, title, body, priority, createDate, dueDate, assignee, owner, status);
    }

    // Exit the program.
    private Task exit(){
        System.out.println("Thank you for using Task Management!");
        System.exit(0);
        return null;
    }

    public static void main(String[] args) {

        // Initialize the class.
        Driver driver = new Driver();

        // Welcome the user.
        String welcome = "Welcome to Task Management!";
        System.out.println(welcome);
        int taskAction;
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                // Display the menu, then accept user input for the next steps.
                // The switch statement associates the integers noted in the main menu with certain actions.
                driver.menuOptions();
                taskAction = scanner.nextInt();
                switch (taskAction) {
                    // Create a task. Menu item 1.
                    case 1 -> {
                        Task task = driver.createTask();
                        driver.addTask(task);
                    }
                    // View tasks. Menu item 2.
                    case 2 -> driver.viewTasks();
                    // View task titles, then select a task to update. Menu item 3.
                    case 3 -> {
                        driver.viewTaskTitles();
                        System.out.println("Enter the id for the task you want to update.");
                        int viewId = scanner.nextInt();
                        driver.updateTask(viewId);
                    }
                    // Display the task titles and ids, then select a task to delete. Menu item 4.
                    case 4 -> {
                        driver.viewTaskTitles();
                        System.out.println("Enter the id for the task you want to delete.");
                        int deleteId = scanner.nextInt();
                        driver.deleteTaskById(deleteId);
                    }
                    // Delete all the tasks in the ArrayList. Menu item 5.
                    case 5 -> driver.deleteAllTasks(driver.taskList);
                    // Exit the program. Menu item 6.
                    case 6 ->
                        driver.exit();
                    // Default messaging.
                    default -> System.out.println("You need to enter a task.");
                }
            } while (taskAction != 6); // Repeat the menu as long as the menu option selected isn't 6, which is the "quit" option.
        } catch (NoSuchElementException e){
            System.out.println("There is no such element."); // Print this if the element doesn't exist.
            // e.printStackTrace(); // Print what went wrong, for debugging reasons.
            System.exit(0); // Exit the program gracefully.
        }
    }
}

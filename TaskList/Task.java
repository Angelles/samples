// Create instance with the columns. The arraylist is a container for them. Create an instance, then add the instance to the arraylist.
// Use add, remove, etc. arraylist methods for getting information. to add the instance of the task.
// No need for constructors/getter/setter methods with an arraylist.

import java.time.LocalDate;

class Task {

    // Set fields.
    private int id;
    private String title;
    private String body;
    private String priority;
    private LocalDate createDate;
    private LocalDate dueDate;
    private String owner;
    private String assignee;
    private String status;

    // Create Task constructor.
    public Task(int id, String title, String body, String priority, LocalDate createDate, LocalDate dueDate, String owner, String assignee, String status) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.priority = priority;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.owner = owner;
        this.assignee = assignee;
        this.status = status;
    }

    // Set getters.
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getOwner() {
        return owner;
    }

    public String getAssignee() {
        return assignee;
    }
    public String getStatus() { return status; }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCreateDate(LocalDate createDate) {
        createDate = LocalDate.now();
        this.createDate = createDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setStatus(String status) { this.status = status; }

    // Put task in a string.
    public String toString(){
        return id + "\t" + title + "\t" + body + "\t" +  priority + "\t" + dueDate + "\t" + createDate + "\t" + owner + "\t" + assignee + System.getProperty("line.separator");
    }
}

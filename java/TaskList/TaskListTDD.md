# Term Project "Task Management" TDD

The purpose of this document is to describe the structure of the Task Management program.

## Purpose

The program is a prototype for a task management program. Users may perform the following actions:
- Create new tasks
- Save tasks to an ArrayList
- View existing task details
- Update individual tasks
- Delete individual tasks
- Delete all tasks

All actions take place in IntelliJ, as this is a prototype.

## Architecture

The core of the program consists of the following:
- A driver class that executes the logical flow of the program and contains methods for handling task data
- A constructor class that contains getter and setter methods for creating, viewing, updating, and deleting Task objects and elements

When objects are created, updated, or deleted, the task list ArrayList is updated to reflect the changes. 

Since this is a prototype that does not include file handling, the contents of the task list only exist in memory. The contents disappear when the program stops running.

Try/catch statements are in place to gracefully exit the program when an exception occurs. 

Note that the following are out of scope for this project:
- Input validation
- File handling
- Frontend/user interface

### Class diagram

The diagram below demonstrates the relationship between the classes.

```mermaid
classDiagram
    Task <.. Driver
class Task
note for Task "This is the constructor class."
Task : -int id
Task : -String title
Task : -String body
Task : -String priority
Task : -LocalDate createDate
Task : -LocalDate dueDate
Task : -String owner
Task : -String assignee
Task : -String status
Task : +getId()
Task : +getTitle()
Task : +getBody()
Task : +getPriority()
Task : +getCreateDate()
Task : +getDueDate()
Task : +getOwner()
Task : +getAssignee()
Task : +getStatus()
Task : +setId(int id)
Task : +setTitle(String title)
Task : +setBody(String body)
Task : +setPriority(String priority)
Task : +setCreateDate(LocalDate createDate)
Task : +setDueDate(LocalDate dueDate)
Task : +setOwner(String owner)
Task : +setAssignee(String assignee)
Task : +setStatus(String status)
Task : +toString()
class Driver
note for Driver "This is the main class."
Driver : - taskList
Driver : -addTask()
Driver : -viewTasks()
Driver : -viewTaskTitles()
Driver : -updateTask()
Driver : -deleteTaskById()
Driver : -emptyCheck()
Driver : -deleteAllTasks()
Driver : +menuOptions()
Driver : -createTask()
Driver : -exit()
Driver : +main()
```
## User journey

When the user starts the program, the user is prompted with a menu of actions the user can take. When the user selects
an action, a switch statement identifies which method to execute based on the user's input. The following flowchart identifies the happy path for each menu option.

### Flowchart

```mermaid
flowchart TD
  id1([Start - Main menu]) --> q1{Selects an option - which one?}
  q1{Select an option - which one?} --> id2(1- Create task)
  q1{Select an option - which one?} --> id3(2 - View all tasks)
  q1{Select an option - which one?} --> id4(3 - Update task)
  q1{Select an option - which one?} --> id5(4 - Delete task)
  q1{Select an option - which one?} --> id6(5 - Delete all tasks)
  q1{Select an option - which one?} -->  id7(6 - Exit program)
  id2(1 - Create task) --> pr2[[Create task method executes]]
  subgraph one
  pr2[[Create task method executes]] --> pr21(Enters id)
  pr21(Enters id) --> pr22(Enters title)
  pr22(Enters title) --> pr23(Enters body)
  pr23(Enters body) --> pr24(Enters priority)
  pr24(Enters priority) --> pr25(Enters due date)
  pr25(Enters due date) --> pr26(Enters the task assignee)
  pr26(Enters the task assignee) --> pr27(Enters the task owner)
  pr27(Enters the task owner) --> pr28(Status `Not Started` is automatically assigned - not printed)
  pr28(Status `Not Started` is automatically assigned - not printed) --> pr29(Confirmation message and task data print)
  end
  pr29(Confirmation message and task data print) --> id8(Main menu prints)
  id3(2- View all tasks) --> pr3[[View all tasks method executes]]
  subgraph two
  pr3[[View all tasks method executes]] --> pr31(All tasks details print)
  end
  pr31(All tasks details print)--> id8(Main menu prints)
  id4(3 - Update task) --> pr4[[Update task method executes]]
  subgraph three
  pr4[[Update task method executes]] --> pr41(Task ids, titles, statuses, and a prompt for input print)
  pr41(Task ids, titles, statuses, and a prompt for input print) --> pr42(Menu for field to update and prompt print)
  pr42(Menu for field to update and prompt print) --> pr43(New element data prints) 
  end 
  pr43(New element data prints) --> id8(Main menu prints)
  id5(4 - Delete task) --> pr5[[Delete task method executes]]
  subgraph four
  pr5[[Delete task method executes]] --> pr51(Task ids, titles, statuses, and prompt print)
  pr51(Task ids, titles, statuses, and prompt print) --> pr52(Remaining tasks print, if any exist. Otherwise, a no tasks exist message prints)
  end
  pr52(Remaining tasks print, if any exist. Otherwise, a no tasks exist message prints) --> id8(Main menu prints)
  id6(5 - Delete all tasks) --> pr6[[Delete all tasks method executes]]
  subgraph five
  pr6[[Delete all tasks method executes]] --> pr61(A no tasks exist message prints)
  end
  pr61(A no tasks exist message prints) --> id8(Main menu prints)
  id7(6 - Exit program) --> pr7[[Exit method executes]]
  subgraph six
  pr7[[Exit method executes]] --> pr71(Thank you message prints)
  pr71(Thank you message prints) --> pr72([Program ends with exit code 0])
  end
```

## Tech stack

- Backend: 
  - Java (JDK 20)
- Frontend substitute:
  - Intellij IDEA - displays output and gets user input

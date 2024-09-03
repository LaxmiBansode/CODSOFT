import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students;  // List to store all student objects
    private final String filePath = "students.txt";  // File path to save and load student data

    // Constructor to initialize the system and load students from the file
    public StudentManagementSystem() {
        students = new ArrayList<>();  // Initialize the list of students
        loadStudents();  // Load student data from the file
    }

    // Method to add a student
    public void addStudent(Student student) {
        // Check if a student with the same roll number already exists
        if (students.stream().anyMatch(s -> s.getRollNumber().equals(student.getRollNumber()))) {
            System.out.println("Student with this roll number already exists.");  // Inform user if student exists
        } else {
            students.add(student);  // Add the new student to the list
            saveStudents();  // Save the updated list of students to the file
            System.out.println("Student added successfully.");  // Confirm successful addition
        }
    }

    // Method to remove a student by roll number
    public void removeStudent(String rollNumber) {
        // Remove student with the specified roll number
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
        saveStudents();  // Save the updated list of students to the file
        System.out.println("Student removed successfully.");  // Confirm successful removal
    }

    // Method to search for a student by roll number
    public Student searchStudent(String rollNumber) {
        // Find and return the student with the specified roll number, or null if not found
        return students.stream()
                .filter(student -> student.getRollNumber().equals(rollNumber))
                .findFirst()
                .orElse(null);
    }

    // Method to display all students
    public void displayAllStudents() {
        // Check if there are no students and display a message
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            students.forEach(System.out::println);  // Print each student's details
        }
    }

    // Load students from the file
    private void loadStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");  // Split line into details
                if (details.length == 3) {  // Check if the line has the correct number of details
                    students.add(new Student(details[0], details[1], details[2]));  // Create a student object and add to the list
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());  // Handle file reading errors
        }
    }

    // Save students to the file
    private void saveStudents() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write each student's details to the file
            for (Student student : students) {
                bw.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());  // Handle file writing errors
        }
    }

    // Main method to run the Student Management System
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a scanner for user input
        StudentManagementSystem sms = new StudentManagementSystem();  // Create an instance of the system

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();  // Read user option
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    // Handle adding a new student
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    // Check if any field is empty and inform the user
                    if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
                        System.out.println("All fields must be filled.");
                    } else {
                        sms.addStudent(new Student(name, rollNumber, grade));  // Add the new student
                    }
                    break;
                case 2:
                    // Handle removing a student
                    System.out.print("Enter roll number of the student to remove: ");
                    String removeRollNumber = scanner.nextLine();
                    sms.removeStudent(removeRollNumber);  // Remove the student
                    break;
                case 3:
                    // Handle searching for a student
                    System.out.print("Enter roll number of the student to search: ");
                    String searchRollNumber = scanner.nextLine();
                    Student student = sms.searchStudent(searchRollNumber);  // Search for the student
                    if (student != null) {
                        System.out.println(student);  // Print student details
                    } else {
                        System.out.println("Student not found.");  // Inform if student not found
                    }
                    break;
                case 4:
                    // Handle displaying all students
                    sms.displayAllStudents();  // Show all students
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();  // Close the scanner
                    return;  // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");  // Handle invalid option
            }
        }
    }
}


/*Adding student
Student Management System Menu:
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Select an option: 1
Enter name: laxmi mallappa bansode
Enter roll number: 1001
Enter grade: A
Student added successfully.
 */

 /*Searching student
Student Management System Menu:
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Select an option: 3
Enter roll number of the student to search: 1001
Name: laxmi mallappa bansode, Roll Number: 1001, Grade: A
  */

/*removing student
 Student Management System Menu:
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Select an option: 2
Enter roll number of the student to remove: 1001
Student removed successfully.
 */

 /*
Student Management System Menu:
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Select an option: 4
Name: laxmi mallappa bansode, Roll Number: 1001, Grade: A
Name: Shruti sanjay shepur, Roll Number: 1002, Grade: B

  */

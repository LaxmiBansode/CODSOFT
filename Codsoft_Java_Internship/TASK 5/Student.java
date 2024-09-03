public class Student {
    // Private variables to store the student's details
    private String name;        // Stores the student's name
    private String rollNumber;  // Stores the student's roll number
    private String grade;       // Stores the student's grade

    // Constructor to initialize a new Student object
    public Student(String name, String rollNumber, String grade) {
        this.name = name;         // Set the student's name
        this.rollNumber = rollNumber; // Set the student's roll number
        this.grade = grade;       // Set the student's grade
    }

    // Method to get the student's name
    public String getName() {
        return name; // Return the student's name
    }

    // Method to get the student's roll number
    public String getRollNumber() {
        return rollNumber; // Return the student's roll number
    }

    // Method to get the student's grade
    public String getGrade() {
        return grade; // Return the student's grade
    }

    // Method to provide a readable summary of the student's information
    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
        // Combine name, roll number, and grade into a single string
    }
}

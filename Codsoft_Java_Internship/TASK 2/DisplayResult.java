/*1)Input : take marks obtained (out of 100) in each subject
2) calculate total marks : sum up the marks obtained in all subject 
3) calculate average percentage : divide the total marks by the total number of subjects to get the average percentage 
4)grade calculation : assign grades based on the average percetage achieved 
5) display Result : show the total marks , average percentage ,a and the corresponding grade to the user  */ 

import java.util.Scanner;   //to perform input operation

public class DisplayResult {

    //entry point function
    public static void main(String[] args) {

        // Scanner class's object to read input from console
        Scanner scanner = new Scanner(System.in);

        // Taking input (Number of subjects) from user and storing it in numSubjects variable  
        System.out.print("Enter the number of subjects: ");
        int noOfSubject = scanner.nextInt();

        // Array to store marks of every subject 
        int[] subjectMarks = new int[noOfSubject];

        // variable to store total marks obtain in all subjects 
        int totalMarks = 0;

        // Taking marks as a input for all indivisual subject 
        for (int i = 0; i < noOfSubject; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            subjectMarks[i] = scanner.nextInt();
            // checking the entered marks from user are between 0 and 100 if it is not then providing a correct message 
            if (subjectMarks[i] < 0 || subjectMarks[i] > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                i--; // Adjusting  the index to start from first again
            } else {
                totalMarks = subjectMarks[i]+totalMarks;
            }
        }

        // Average marks calculation
        double average = (double) totalMarks / noOfSubject;

        // calculating grade 
        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Displaying the result
        System.out.println("Total Marks: " + totalMarks+"|");
        System.out.println("Average Percentage: " + average + "% |");
        System.out.println("Grade: " + grade+"|");

        // Close the scanner
        scanner.close();
    }
}

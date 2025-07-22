package Code;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static class Student {
        String name;
        double[] grades;
        
        Student(String name, double[] grades) {
            this.name = name;
            this.grades = grades;
        }
        
        double calculateAverage() {
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.length;
        }
        
        double getHighestGrade() {
            double max = grades[0];
            for (double grade : grades) {
                if (grade > max) max = grade;
            }
            return max;
        }
        
        double getLowestGrade() {
            double min = grades[0];
            for (double grade : grades) {
                if (grade < min) min = grade;
            }
            return min;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        while (true) {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Summary Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter number of grades: ");
                int numGrades = scanner.nextInt();
                double[] grades = new double[numGrades];
                
                for (int i = 0; i < numGrades; i++) {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    grades[i] = scanner.nextDouble();
                    while (grades[i] < 0 || grades[i] > 100) {
                        System.out.print("Invalid grade. Enter grade " + (i + 1) + " (0-100): ");
                        grades[i] = scanner.nextDouble();
                    }
                }
                
                students.add(new Student(name, grades));
                System.out.println("Student added successfully!");
                
            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No students added yet.");
                } else {
                    System.out.println("\n=== Student Grade Summary ===");
                    for (Student student : students) {
                        System.out.println("\nStudent: " + student.name);
                        System.out.print("Grades: ");
                        for (double grade : student.grades) {
                            System.out.print(grade + " ");
                        }
                        System.out.printf("\nAverage: %.2f", student.calculateAverage());
                        System.out.printf("\nHighest: %.2f", student.getHighestGrade());
                        System.out.printf("\nLowest: %.2f\n", student.getLowestGrade());
                    }
                }
                
            } else if (choice == 3) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        
        scanner.close();
    }
}


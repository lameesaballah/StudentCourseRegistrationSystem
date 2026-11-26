import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        CourseRegistrationSystem system =
                new CourseRegistrationSystem();

        int choice = 0;

        do {

            System.out.println("\n================================");
            System.out.println(" Student Course Registration");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Display Available Courses");
            System.out.println("4. Register Student in Course");
            System.out.println("5. Display Registered Courses");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int studentId = Integer.parseInt(input.nextLine());

                    System.out.print("Enter Student Name: ");
                    String studentName = input.nextLine();

                    Student student =
                            new Student(studentId, studentName);

                    if (system.addStudent(student)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Student ID already exists.");
                    }

                    break;

                case 2:

                    System.out.print("Enter Course ID: ");
                    String courseId = input.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = input.nextLine();

                    Course course =
                            new Course(courseId, courseName);

                    if (system.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course ID already exists.");
                    }

                    break;

                case 3:

                    system.displayAvailableCourses();

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int id = Integer.parseInt(input.nextLine());

                    System.out.print("Enter Course ID: ");
                    String cId = input.nextLine();

                    if (system.registerStudentInCourse(id, cId)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println(
                                "Registration failed. Check student and course IDs or existing registration."
                        );
                    }

                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    int searchId = Integer.parseInt(input.nextLine());

                    system.displayRegisteredCourses(searchId);

                    break;

                case 6:

                    System.out.println("Thank you for using the system!");

                    break;

                default:

                    System.out.println("Invalid choice. Try again.");

            }

        } while (choice != 6);

        input.close();

    }
}
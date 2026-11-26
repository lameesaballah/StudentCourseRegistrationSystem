import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseRegistrationSystem {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    private Map<Integer, ArrayList<Course>> registeredCourses;

    public CourseRegistrationSystem() {

        students = new ArrayList<>();
        courses = new ArrayList<>();
        registeredCourses = new HashMap<>();

    }

    // Add Student
    public boolean addStudent(Student student) {

        for (Student s : students) {

            if (s.getStudentId() == student.getStudentId()) {
                return false;
            }

        }

        students.add(student);
        return true;
    }

    // Add Course
    public boolean addCourse(Course course) {

        for (Course c : courses) {

            if (c.getCourseId().equals(course.getCourseId())) {
                return false;
            }

        }

        courses.add(course);
        return true;
    }

    // Display Available Courses
    public void displayAvailableCourses() {

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\nAvailable Courses:");

        for (Course c : courses) {

            System.out.println(
                    c.getCourseId() + " - " + c.getCourseName()
            );

        }
    }

    // Register Student in Course
    public boolean registerStudentInCourse(int studentId, String courseId) {

        Student foundStudent = null;
        Course foundCourse = null;

        for (Student s : students) {

            if (s.getStudentId() == studentId) {
                foundStudent = s;
                break;
            }

        }

        for (Course c : courses) {

            if (c.getCourseId().equals(courseId)) {
                foundCourse = c;
                break;
            }

        }

        if (foundStudent == null || foundCourse == null) {
            return false;
        }

        ArrayList<Course> studentCourses =
                registeredCourses.computeIfAbsent(
                        studentId, k -> new ArrayList<>()
                );

        if (studentCourses.contains(foundCourse)) {
            return false;
        }

        studentCourses.add(foundCourse);

        return true;
    }

    // Display Student's Registered Courses
    public void displayRegisteredCourses(int studentId) {

        boolean studentExists = false;

        for (Student s : students) {

            if (s.getStudentId() == studentId) {
                studentExists = true;
                break;
            }

        }

        if (!studentExists) {
            System.out.println("Student not found.");
            return;
        }

        ArrayList<Course> studentCourses =
                registeredCourses.get(studentId);

        if (studentCourses == null || studentCourses.isEmpty()) {

            System.out.println("No registered courses.");

            return;
        }

        System.out.println("\nRegistered Courses:");

        for (Course c : studentCourses) {

            System.out.println(
                    c.getCourseId() + " - " + c.getCourseName()
            );

        }
    }

}
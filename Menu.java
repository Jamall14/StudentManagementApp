

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    Student students = new Student();
    static boolean running = true;


    public void displayMenu() {


        System.out.println("STUDENT MANAGEMENT APPLICATION");
        while (running) {

            System.out.println("****************************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            int in = input.nextInt();

            if (in != 1) {
                running = false;
                continue;
            }
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print a student report.");
            System.out.println("(5) Exit Application.");

            int choice = input.nextInt();
            switch (choice) {
                case 1 -> captureStudent();

                case 2 -> search();

                case 3 -> delete();

                case 4 -> report();

                case 5 -> exit();
            }
        }
    }

    public void captureStudent() {
        System.out.println("CREATE A NEW STUDENT");
        System.out.println("**************************");
        System.out.println("Enter the student id: ");
        int id = input.nextInt();

        System.out.println("Enter the student name: ");
        String name = input.next();

        System.out.println("Enter the student age: ");
        int age = input.nextInt();
        while (true) {
            if (age < 18) {
                System.out.println("You have entered a incorrect student age!!!");
                System.out.println("Please re-enter the student age: ");
                age = input.nextInt();
            } else {
                break;
            }
        }

        System.out.println("Enter the student email: ");
        String email = input.next();

        System.out.println("Enter the student course: ");
        String course = input.next();

        students.saveStudent(id, name, email, course, age);

    }

    public void search() {
        System.out.println("Enter the student id to search: ");
        int idSearch = input.nextInt();
        students.searchStudent(idSearch);
    }

    public void delete() {
        System.out.println("Enter the student id to delete: ");
        int idDelete = input.nextInt();
        students.deleteStudent(idDelete);
    }

    public void report() {
        students.studentReport();
    }

    public void exit() {
        System.out.println("Goodbye!");
        running = false;
    }
}

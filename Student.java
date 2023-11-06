

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Student {

    int studentID;
    String studentName;
    String studentEmail;
    String course;
    int studentAge;
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> emailList = new ArrayList<>();
    ArrayList<String> courseList = new ArrayList<>();
    ArrayList<Integer> ageList = new ArrayList<>();


    public Student() {
        this.studentID = 0;
        this.studentName = "";
        this.studentEmail = "";
        this.course = "";
        this.studentAge = 0;

    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public Student(int studentID, String studentName, String studentEmail, String course, int studentAge) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.course = course;
        this.studentAge = studentAge;

    }


    public void saveStudent(int studentID, String studentName, String studentEmail, String course, int studentAge) {
        idList.add(studentID);
        nameList.add(studentName);
        emailList.add(studentEmail);
        courseList.add(course);
        ageList.add(studentAge);
    }

    public void searchStudent(int studentID) {
        boolean found = false;
        for (int i = 0; i < idList.size(); i++) {
            int element = idList.get(i);

            if (element == studentID) {
                System.out.println("**************************");
                System.out.println("Enter the student id: " + idList.get(i));
                System.out.println("Enter the student name: " + nameList.get(i));
                System.out.println("Enter the student age: " + ageList.get(i));
                System.out.println("Enter the student email: " + emailList.get(i));
                System.out.println("Enter the student course: " + courseList.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with id:" + studentID + "not found.");
        }
    }

    public void deleteStudent(int studentID) {
        try (Scanner opt = new Scanner(System.in)) {
            for (int i = 0; i < idList.size(); i++) {
                if (idList.get(i) == studentID) {
                    System.out.println("Are you sure you want to remove student" + studentID + "from the system? Yes (y)");
                    String decision = opt.next();
                    if (Objects.equals(decision, "y")) {
                        idList.remove(i);
                        nameList.remove(i);
                        ageList.remove(i);
                        emailList.remove(i);
                        courseList.remove(i);
                        return;
                    }
                }
            }
        }
        System.out.println("Student with id:" + studentID + " not found!");
    }

    public void studentReport() {
        for (int i = 0; i < idList.size(); i++) {
            System.out.println("***************************");
            int sum = i + 1;
            System.out.println("Student: " + sum);
            System.out.println("**************************");
            System.out.println("Student ID: " + idList.get(i));
            System.out.println("Name: " + nameList.get(i));
            System.out.println("Age: " + ageList.get(i));
            System.out.println("Email: " + emailList.get(i));
            System.out.println("Course: " + courseList.get(i));
        }
    }

}

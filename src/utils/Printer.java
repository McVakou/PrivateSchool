package utils;

import dao.AssignmentDaoImpl;
import dao.CourseDaoImpl;
import dao.GlobalDaoImpl;
import dao.StudentDaoImpl;
import dao.TrainerDaoImpl;
import dto.AssCourseStudentMarks;
import java.util.List;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;

/**
 *
 * @author mcvakou
 */
public class Printer {
    //TODO NA DW AN YPARXEI LOGOS NA ELEKSW TIS LISTES .isEmpty()
    public static void printAllSudents() {
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Student> listOfStudent = sdi.getAllStudents();        
        sdi.printStudentList(listOfStudent);
    }

    public static void printAllTrainers() {
        TrainerDaoImpl tdi = new TrainerDaoImpl();
        List<Trainer> listOfTrainer = tdi.getAllTrainers();
        tdi.printTrainerList(listOfTrainer);
    }

    public static void printAllAssignments() {
        AssignmentDaoImpl adi = new AssignmentDaoImpl();
        List<Assignment> listOfAssignment = adi.getAllAssignments();
        adi.printAssignmentList(listOfAssignment);
    }

    public static void printAllCourses() {
        CourseDaoImpl cdi = new CourseDaoImpl();
        List<Course> listOfCourse = cdi.getAllCourses();
        cdi.printCourseList(listOfCourse);
    }
    //TODO
    public static void printStudentsOfACourse(int courseId) {
        //students by courseId
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Student> listOfStudent = sdi.getListStudentByCourseId(courseId);
        sdi.printStudentList(listOfStudent);
    }

    public static void printAssignmentsOfACourse(int course_id) {
        //assignments by courseId
        AssignmentDaoImpl adi = new AssignmentDaoImpl();
        List<Assignment> listOfAssignment = adi.getListAssignmentByCourseId(course_id);
        adi.printAssignmentList(listOfAssignment);
    }
    public static void printTrainersOfACourse(int course_id) {
        TrainerDaoImpl tdi = new TrainerDaoImpl();
        List<Trainer> listOfTrainer = tdi.getListTrainerByCourseId(course_id);
        tdi.printTrainerList(listOfTrainer);//
    }
    public static void printApCByStudentId(int student_id) {
        GlobalDaoImpl gdi = new GlobalDaoImpl();
        List<AssCourseStudentMarks> listACSM = gdi.getAssignmentPerCoursePerStudentByStudentId(student_id);
        gdi.printACSM(listACSM);
    }

    public static void printStudentsWithManyCourses() {
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Student> listOfStudent = sdi.getListStudentEnrolledToManyCourses();
        sdi.printStudentList(listOfStudent);//  
    }

    public static void printMenuMain() {
        System.out.println("Choose an operation:");
        System.out.println("Insert 0 to exit the program");
        System.out.println("Insert 1 to Print a list");
        System.out.println("Insert 2 to Create an entity (Student, Trainer, Assignment, Course)");
        System.out.println("Insert 3 to Associate entities AND see - alter grades");
        System.out.println("--------");
    }

    public static void printMenu1() {
        System.out.println("Choose an option:");
        System.out.println("Insert 0 to exit program");
        System.out.println("Insert 1 to print all students");
        System.out.println("Insert 2 to print all trainers");
        System.out.println("Insert 3 to print all assignments");
        System.out.println("Insert 4 to print all courses");
        System.out.println("Insert 5 to print all students per course");
        System.out.println("Insert 6 to print all trainers per course");
        System.out.println("Insert 7 to print all assignments per course");
        System.out.println("Insert 8 to print all the assignments per course per student");
        System.out.println("Insert 9 to print all students who are enrolled to more than one courses");

    }

    public static void printMenu2() {
        System.out.println("Choose an option:");
        System.out.println("Insert 0 to exit menu");
        System.out.println("Insert 1 to add entity Student");
        System.out.println("Insert 2 to add entity Trainer");
        System.out.println("Insert 3 to add entity Assignment");
        System.out.println("Insert 4 to add entity Course");

    }

    public static void printMenu3() {
        System.out.println("Choose an option:");
        System.out.println("Insert 0 to exit the menu");
        System.out.println("Insert 1 to enroll a student to a course");
        System.out.println("Insert 2 to assign a trainer to a course");
        System.out.println("Insert 3 to assign an assignment to a student of a course");
        System.out.println("Insert 4 to see the grades of an assignment");
        System.out.println("Insert 5 to see and change grades of an assignment");
    }

}

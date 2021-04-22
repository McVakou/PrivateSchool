package utils;

import dao.AssPerStudentPerCourseDaoImpl;
import dao.AssignmentDaoImpl;
import dao.CourseDaoImpl;
import dao.EnrollmentDaoImpl;
import dao.StudentDaoImpl;
import dao.TrainerDaoImpl;
import dao.TrainerPerCourseDaoImpl;
import dto.Marks;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.Scanner;
import models.Assignment;
import models.AssignmentPerStudentPerCourse;
import models.Course;
import models.Enrollment;
import models.Student;
import models.Trainer;
import models.TrainerPerCourse;
import static utils.Printer.printAllAssignments;
import static utils.Printer.printAllCourses;
import static utils.Printer.printAllSudents;
import static utils.Printer.printAssignmentsOfACourse;
import static utils.Printer.printStudentsOfACourse;

/**
 *
 * @author mcvakou
 */
public class Command {

    //---------------------------------NOT USING--------------------------------
    public String getField(Scanner sc, String message) {
        System.out.println(message);
        return (sc.nextLine());
    }

    public int getIntField(Scanner sc, String message) {
        System.out.println(message);
        //return(Double.parseDouble(sc.nextLine()));
        return (sc.nextInt());
    }

    //--------------------------------------------------------------------------
    
    //--------------------------GETTING LISTS-----------------------------------
    public int getCourseId(Scanner sc) {
        System.out.println("These are the avaliable courses:");
        printAllCourses();
        System.out.println("Input course's id");
        int course_id = sc.nextInt();
        return (course_id);
    }

    public int getStudentId(Scanner sc) {
        System.out.println("These are the avaliable students:");
        printAllSudents();
        System.out.println("Input Student's id");
        int studentId = sc.nextInt();
        return (studentId);
    }

    public int getAssignmentId(Scanner sc) {
        System.out.println("These are the avaliable assignment's");
        printAllAssignments();
        System.out.println("Input Assignment's id");
        int assignment_id = sc.nextInt();
        return (assignment_id);
    }

    public int getStudentIdOfACourse(Scanner sc, int course_id) {
        System.out.println("These are the student's of the course:");
        printStudentsOfACourse(course_id);
        System.out.println("Input student's id");
        int student_id = sc.nextInt();
        return (student_id);
    }

    public int getAssignmentIdOfACourse(Scanner sc, int course_id) {
        System.out.println("These are the assignments of the course:");
        printAssignmentsOfACourse(course_id);
        System.out.println("Input assignment's id");
        int assignment_id = sc.nextInt();
        return (assignment_id);
    }
    //--------------------------------------------------------------------------

    //------------------CREATING ENTITIES --------------------------------------
    public void createAndInsertStudent(Scanner sc) {
        //create student and insert him into database
//Den elegxw edw giati therww oti xreiazetai k allo field gia na einai swsto
//mporei na yparksei student me idio onoma,date,fees
        StudentDaoImpl SDI = new StudentDaoImpl();
        Student s = SDI.askDataStudent(sc);
        SDI.insertStudent(s);
    }

    public void createAndInsertTrainer(Scanner sc) {
        //create trainer and insert him into database
        TrainerDaoImpl tdi = new TrainerDaoImpl();
        List<Trainer> listOfTrainers = tdi.getAllTrainers();
        Trainer t = tdi.askDataTrainer(sc);
        if (listOfTrainers.contains(t)) {
            System.out.println("The trainer already exists!");
        } else {
            tdi.insertTrainer(t);
        }

    }

    public void createAndInsertAssignment(Scanner sc) {
        //create assignemnt and insert it into database
        AssignmentDaoImpl adi = new AssignmentDaoImpl();
        Assignment a = adi.askDataAssignment(sc);
        List<Assignment> listOfAss = adi.getAllAssignments();
        if (listOfAss.contains(a)) {
            System.out.println("These assignment already exists!");
        } else {
            adi.insertAssignment(a);
        }

    }

    public void createAndInsertCourse(Scanner sc) {
        //create course and insert it into database
        CourseDaoImpl cdi = new CourseDaoImpl();
        List<Course> listOfCourses = cdi.getAllCourses();
        Course c = cdi.askDataCourse(sc);
        if (listOfCourses.contains(c)) {
            System.out.println("The course already exists!");
        } else {
            cdi.insertCourse(c);
        }
        
    }
    //--------------------------------------------------------------------------

    //---------------------ASSOSIATION------------------------------------------
    public void enrollStudentToCourse(Scanner sc) {
        // enroll a student to course
        EnrollmentDaoImpl edi = new EnrollmentDaoImpl();
        List<Enrollment> listEnrollment = edi.getAllEnrollments();
        Enrollment enrollment = edi.askDataEnrollment(sc);
        if (listEnrollment.contains(enrollment)) {
            System.out.println("The student is already enrolled!");
        } else {
            edi.insertEnrollment(enrollment);
        }

    }

    public void assignTrainerToCourse(Scanner sc) {
        //insert trainer per course
        TrainerPerCourseDaoImpl tpcdi = new TrainerPerCourseDaoImpl();
        List<TrainerPerCourse> listTrainersThatTeach = tpcdi.getAllTrainersThatTeach();
        TrainerPerCourse tpc = tpcdi.askDataTrainerPerCourse(sc);
        if (listTrainersThatTeach.contains(tpc)) {
            System.out.println("The teacher already teaches this course!");
        } else {
            tpcdi.insertTrainerPerCourse(tpc);
        }

    }

    public void assignAssOfAStudentOfACourse(Scanner sc) {
        //insert assignment to a student of a course
        AssPerStudentPerCourseDaoImpl apspcdi = new AssPerStudentPerCourseDaoImpl();        
        List<AssignmentPerStudentPerCourse> listApSpC = apspcdi.getAllApSpC();
        AssignmentPerStudentPerCourse apspc = apspcdi.askDataApSpC(sc);
        if (listApSpC.contains(apspc)) {
            System.out.println("The student of that course already has that assignment!");
        } else {
            apspcdi.insertAssignmentPerStudentPerCourse(apspc);
        }

    }
    //--------------------------------------------------------------------------

    //-----------------------------MARKS----------------------------------------
    public void showMarks(Scanner sc) {
        AssPerStudentPerCourseDaoImpl apspcdi
                = new AssPerStudentPerCourseDaoImpl();
        Marks marks = apspcdi.askGradesOfAssOfCourse(sc);
        System.out.println(marks);
    }

    public void showAndGrade(Scanner sc) {
        AssPerStudentPerCourseDaoImpl apspcdi
                = new AssPerStudentPerCourseDaoImpl();
        apspcdi.grading(sc);
    }
    //--------------------------------------------------------------------------

    //USING ONLY IN MENUS
    public static int isNumeric() {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.next();
        boolean isNumber = s.chars().allMatch(Character::isDigit);
        if (isNumber) {
            return parseInt(s);
        } else {
            System.out.println("That's not a number try again!");
            return isNumeric();
        }
    }

}

package utils;

import java.util.Scanner;
import static utils.Command.isNumeric;

/**
 *
 * @author mcvakou
 */
public class Console_Simple {
    //TODO should optimise if time avaliable
    Printer pr = new Printer();
    Command cmd = new Command();

    public void mainProcess(Scanner sc) {

        int x, y;
        while (true) {
            pr.printMenuMain();
            y = isNumeric();
            
            if (y == 1) {
                pr.printMenu1();
                x = isNumeric();
                if (x == 1) {
                    pr.printAllSudents();
                } else if (x == 2) {
                    pr.printAllTrainers();
                } else if (x == 3) {
                    pr.printAllAssignments();
                } else if (x == 4) {
                    pr.printAllCourses();
                } else if (x == 5) {
                    //print Students by courseid
                    pr.printStudentsOfACourse(cmd.getCourseId(sc));
                } else if (x == 6) {
                    //print trainers by courseid
                    pr.printTrainersOfACourse(cmd.getCourseId(sc));
                } else if (x == 7) {
                    //print assignemnt by courseId
                    pr.printAssignmentsOfACourse(cmd.getCourseId(sc));
                } else if (x == 8) {
                    //print assignment per course by studentId
                    pr.printApCByStudentId(cmd.getStudentId(sc));
                } else if (x == 9) {
                    //printing students that have enrolled to many courses
                    pr.printStudentsWithManyCourses();
                }
            } else if (y == 2) {
                pr.printMenu2();
                x = isNumeric();
                if (x == 1) {
                    //create student and insert him into database
                    cmd.createAndInsertStudent(sc);
                } else if (x == 2) {
                    //create trainer and insert him into database
                    cmd.createAndInsertTrainer(sc);
                } else if (x == 3) {
                    //create assignemnt and insert it into database
                    cmd.createAndInsertAssignment(sc);
                } else if (x == 4) {
                    //create course and insert it into database
                    cmd.createAndInsertCourse(sc);
                }
            } else if (y == 3) {
                pr.printMenu3();
                x = isNumeric();
                if (x == 1) {
                    // insert student per course
                    cmd.enrollStudentToCourse(sc);
                } else if (x == 2) {
                    //insert trainer per course
                    cmd.assignTrainerToCourse(sc);
                } else if (x == 3) {                    
                    //insert assignment to a student of a course
                    cmd.assignAssOfAStudentOfACourse(sc);
                } else if (x == 4) {
                    //Shows marks
                    cmd.showMarks(sc);
                } else if (x == 5) {
                    //Shows and sets new marks
                    cmd.showAndGrade(sc);
                } else if (x == 0) {
                    break;
                }
            } else {
                break;
            }
            System.out.println("-----------------------------------------------"
                    + "--------------------------------------------------------"
                    + "--------------------------------------------");
        }
    }

}

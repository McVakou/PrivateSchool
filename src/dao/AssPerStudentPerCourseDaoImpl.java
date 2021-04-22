package dao;

import dto.Marks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AssignmentPerStudentPerCourse;
import utils.Command;
import utils.DbUtils;

/**
 *
 * @author mcvakou
 */
public class AssPerStudentPerCourseDaoImpl implements AssPerStudentPerCourseDaoInt {

    Connection con;

    public AssignmentPerStudentPerCourse askDataApSpC(Scanner sc) {
        //student_id, course_id, assignment_id// marks later
        //isws auta prepei na ta parw apo table enrollments
        AssignmentPerStudentPerCourse apspc = new AssignmentPerStudentPerCourse();
        Command cmd = new Command();
        int course_id = cmd.getCourseId(sc);
        int student_id = cmd.getStudentIdOfACourse(sc, course_id);
        //System.out.println("Now choose an assignment for the student");
        int assignment_id = cmd.getAssignmentIdOfACourse(sc, course_id);
        apspc.setAssignment_id(assignment_id);
        apspc.setStudent_id(student_id);
        apspc.setCourse_id(course_id);
        //tha mporousa na rwtaw edw an thelei na vathmologisei to assignment
        //alla den m'aresei.
        return (apspc);
    }

    public void insertAssignmentPerStudentPerCourse(AssignmentPerStudentPerCourse apspc) {
        String sql = "INSERT INTO ass_per_student_per_course"
                + " (assignment_id, student_id, course_id) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, apspc.getAssignment_id());
            ps.setInt(2, apspc.getStudent_id());
            ps.setInt(3, apspc.getCourse_id());
            ps.executeUpdate();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(AssPerStudentPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssPerStudentPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public List<AssignmentPerStudentPerCourse> getAllApSpC() {
        String sql = "SELECT * FROM ass_per_student_per_course";
        PreparedStatement ps = null;
        ArrayList<AssignmentPerStudentPerCourse> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AssignmentPerStudentPerCourse apspc
                        = new AssignmentPerStudentPerCourse(rs.getInt("assignment_id"),
                                rs.getInt("student_id"),
                                rs.getInt("course_id"),
                                rs.getInt("oral_mark"),
                                rs.getInt("total_mark"));
                result.add(apspc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssPerStudentPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssPerStudentPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }
    //apla pairnw marks apo apspc
    public Marks askGradesOfAssOfCourse(Scanner sc) {
        AssPerStudentPerCourseDaoImpl apspcdi = new AssPerStudentPerCourseDaoImpl();
        AssignmentPerStudentPerCourse apspc = apspcdi.askDataApSpC(sc);
        int oral_mark = apspc.getOral_mark();
        int total_mark = apspc.getTotal_mark();
        Marks marks = new Marks();
        marks.setOral_mark(oral_mark);
        marks.setTotal_mark(total_mark);
        return (marks);

    }
    
    public void grading(Scanner sc) {
        AssPerStudentPerCourseDaoImpl apspcdi = new AssPerStudentPerCourseDaoImpl();
        AssignmentPerStudentPerCourse apspc = apspcdi.askDataApSpC(sc);
        //----------------------Showing currentMarks----------------------------
        Marks currentMarks = new Marks();
        currentMarks.setOral_mark(apspc.getOral_mark());
        currentMarks.setTotal_mark(apspc.getTotal_mark());
        System.out.println("These are the current marks: " + currentMarks);        
        //----------------------------------------------------------------------   
        String sql = "UPDATE ass_per_student_per_course"
                + " SET oral_mark = ?, total_mark = ?"
                + " WHERE (assignment_id = ?) "
                + " and (student_id = ?) "
                + " and (course_id = ?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            System.out.println("Set oral mark 0-100");
            ps.setInt(1, sc.nextInt());
            System.out.println("Set total mark 0-100");
            ps.setInt(2, sc.nextInt());
            ps.setInt(3, apspc.getAssignment_id());
            ps.setInt(4, apspc.getStudent_id());
            ps.setInt(5, apspc.getCourse_id());
            ps.executeUpdate();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(AssPerStudentPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssPerStudentPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}



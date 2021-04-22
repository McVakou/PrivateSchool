package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Enrollment;
import utils.DbUtils;
import static utils.Printer.printAllCourses;
import static utils.Printer.printAllSudents;

/**
 *
 * @author mcvakou
 */
public class EnrollmentDaoImpl implements EnrollmentDaoInt {

    Connection con;

    public Enrollment askDataEnrollment(Scanner sc) {
        Enrollment enrollment = new Enrollment();
        // na tou deiksw olous tous students
        printAllSudents();
        System.out.println("Input the id of the student you want to enroll.");
        enrollment.setStudent_id(sc.nextInt()); // edw vazw to INT
        // na tou deiksw ola ta courses
        printAllCourses();
        System.out.println("Input the id of the course.");
        enrollment.setCourse_id(sc.nextInt());

        return (enrollment);
    }

    public void insertEnrollment(Enrollment enrollment) {
        String sql = "INSERT INTO"
                + " enrollments"
                + " (student_id, course_id) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, enrollment.getStudent_id());
            ps.setInt(2, enrollment.getCourse_id());
            ps.executeUpdate();
            System.out.println("success");
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EnrollmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    public ArrayList<Enrollment> getAllEnrollments() {
        String sql = "SELECT * FROM enrollments";
        PreparedStatement ps = null;
        ArrayList<Enrollment> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Enrollment e = new Enrollment(rs.getInt("student_id"),
                        rs.getInt("course_id"));
                result.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EnrollmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }

}

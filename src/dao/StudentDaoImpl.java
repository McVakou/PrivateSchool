package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;
import utils.DateUtils;
import utils.DbUtils;

/**
 *
 * @author mcvakou
 */
public class StudentDaoImpl implements StudentDaoInt {

    private Connection con;

    public Student askDataStudent(Scanner sc) {
        Student student = new Student();
        // first_name, last_name, tuition_fees, date_of_birth
        String first_name;
        String last_name;
        double tuition_fees;
        Date date_of_birth;
        System.out.println("Type Student's first name");
        student.setFirst_name(first_name = sc.nextLine());
        System.out.println("Type Student's last name");
        student.setLast_name(last_name = sc.nextLine());
        System.out.println("Type Student's tuition fees");
        student.setTuition_fees(tuition_fees = sc.nextDouble());
        System.out.println("Type Student's date of birth in this format: yyyy-MM-dd");
        student.setDate_of_birth(date_of_birth = DateUtils.parseStringToDate(sc.next()));
        return (student);

    }

    public void insertStudent(Student s) {
        String sql = "INSERT INTO students (first_name, last_name, tuition_fees, date_of_birth) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, s.getFirst_name());
            ps.setString(2, s.getLast_name());
            ps.setDouble(3, s.getTuition_fees());
            ps.setDate(4, new java.sql.Date(s.getDate_of_birth().getTime()));
            ps.executeUpdate();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Student> getAllStudents() {
        String sql1 = "SELECT";
        String sql2 = "* FROM students";
        String sql  = sql1 +sql2;
        PreparedStatement ps = null;
        ArrayList<Student> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDouble("tuition_fees"),
                        rs.getDate("date_of_birth"));
                result.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }

    public List<Student> getListStudentByCourseId(int courseId) {
//                                              int courseId anotherWayByCallingMethod            
        String sql = "SELECT s.student_id, s.first_name, s.last_name, s.tuition_fees, s.date_of_birth"
                + " FROM enrollments, students s, courses"
                + " WHERE enrollments.student_id = s.student_id"
                + " AND enrollments.course_id = courses.course_id"
                + " AND courses.course_id =?";

        //System.out.println(sql);
        PreparedStatement ps = null;
        ArrayList<Student> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDouble("tuition_fees"),
                        rs.getDate("date_of_birth"));
                result.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }

    public List<Student> getListStudentEnrolledToManyCourses() {
        String sql = "SELECT s.student_id, s.first_name, s.last_name, s.tuition_fees, s.date_of_birth"
                + " FROM enrollments e"
                + " INNER JOIN students s"
                + " ON e.student_id = s.student_id"
                + " GROUP BY e.student_id"
                + " HAVING COUNT(e.course_id)>1";
        PreparedStatement ps = null;
        ArrayList<Student> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDouble("tuition_fees"),
                        rs.getDate("date_of_birth"));
                result.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }

    public void printStudentList(List<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}

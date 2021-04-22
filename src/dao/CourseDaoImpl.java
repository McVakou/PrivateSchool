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
import models.Course;
import utils.DateUtils;
import utils.DbUtils;

/**
 *
 * @author mcvakou
 */
public class CourseDaoImpl implements CourseDaoInt {

    private Connection con;

    public Course askDataCourse(Scanner sc) {
        Course course = new Course();
        //title, stream, type, start_date, end_date
        String title;
        String stream;
        String type;
        Date start_date;
        Date end_date;
        System.out.println("Type Course's title");
        course.setTitle(title = sc.nextLine());
        System.out.println("Type Course's stream");
        course.setStream(stream = sc.nextLine());
        System.out.println("Type Course's type");
        course.setType(type = sc.nextLine());
        System.out.println("Type Course's start date in this format: yyyy-MM-dd");
        course.setStart_date(start_date = DateUtils.parseStringToDate(sc.nextLine()));
        System.out.println("Type Course's end_date in this format: yyyy-MM-dd");
        course.setEnd_date(end_date = DateUtils.parseStringToDate(sc.nextLine()));
        return (course);
    }

    @Override
    public void insertCourse(Course c) {
        String sql = "INSERT INTO courses"
                + " (title, stream, type, start_date, end_date) VALUES (?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection(); //THA MPOROUSA NA TO VALW K PANW STHN CLASS
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getTitle());
            ps.setString(2, c.getStream());
            ps.setString(3, c.getType());
            ps.setDate(4, new java.sql.Date(c.getStart_date().getTime()));
            ps.setDate(5, new java.sql.Date(c.getEnd_date().getTime()));
            ps.executeUpdate();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        PreparedStatement ps = null;
        ArrayList<Course> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course(rs.getInt("course_id"),
                        rs.getString("title"),
                        rs.getString("stream"),
                        rs.getString("type"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"));
                result.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }

    public void printCourseList(List<Course> list) {
        for (Course c : list) {
            System.out.println(c);// edw ousiastika ginetai h toString
        }

    }
}

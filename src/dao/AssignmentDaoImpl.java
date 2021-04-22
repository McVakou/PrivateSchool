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
import models.Assignment;
import utils.DateUtils;
import utils.DbUtils;

/**
 *
 * @author mcvakou
 */
public class AssignmentDaoImpl implements AssignmentDaoInt {

    private Connection con;

    public Assignment askDataAssignment(Scanner sc) {
        Assignment assignment = new Assignment();
        //title, description, sub_date_time
        String title;
        String description;
        Date sub_date_time;
        System.out.println("Type Assignment's title");
        assignment.setTitle(title = sc.nextLine());
        System.out.println("Type Assignment's description");
        assignment.setDescription(description = sc.nextLine());
        System.out.println("Type Assignment's submision date in this format: yyyy-MM-dd");
        assignment.setSub_date_time(sub_date_time = DateUtils.parseStringToDate(sc.next()));
        return (assignment);
    }

    @Override
    public void insertAssignment(Assignment a) {
        String sql = "INSERT INTO assignments"
                + " (title, description, sub_date_time) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection(); //THA MPOROUSA NA TO VALW K PANW STHN CLASS
            ps = con.prepareStatement(sql);
            ps.setInt(1, a.getAssignment_id());
            ps.setString(2, a.getTitle());
            //new java.sql.Date(*.get***().getTime()))
            ps.setDate(3, new java.sql.Date(a.getSub_date_time().getTime()));
            ps.executeUpdate();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public List<Assignment> getAllAssignments() {
        String sql = "SELECT * FROM assignments";
        PreparedStatement ps = null;
        ArrayList<Assignment> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Assignment a = new Assignment(rs.getInt("assignment_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("sub_date_time"));
                result.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }

    public List<Assignment> getListAssignmentByCourseId(int courseId) {
        // (Scanner sc) another way and getting courseId in this method           
        String sql = "SELECT a.assignment_id, a.title, a.description, a.sub_date_time"
                + " FROM assignments a, ass_per_course apc"
                + " WHERE apc.assignment_id = a.assignment_id"
                + " AND apc.course_id = ?";

        //System.out.println(sql);
        PreparedStatement ps = null;
        ArrayList<Assignment> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Assignment a = new Assignment(rs.getInt("assignment_id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("sub_date_time")
                );
                result.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }

    public void printAssignmentList(List<Assignment> list) {
        for (Assignment a : list) {
            System.out.println(a);
        }

    }

}

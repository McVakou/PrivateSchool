package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.TrainerPerCourse;
import utils.DbUtils;
import static utils.Printer.printAllCourses;
import static utils.Printer.printAllTrainers;

/**
 *
 * @author mcvakou
 */
public class TrainerPerCourseDaoImpl implements TrainerPerCourseDaoInt {

    Connection con;

    //TODO NA VALW ELEGXOUS STA INPUT
    public TrainerPerCourse askDataTrainerPerCourse(Scanner sc) {
        TrainerPerCourse tpc = new TrainerPerCourse();
        //na tou deiksw olous tous trainers
        printAllTrainers();
        System.out.println("Input the id of the trainer you want to teach a course");
        tpc.setTrainer_id(sc.nextInt());
        //na tou deiksw ola ta courses
        printAllCourses();
        System.out.println("Input the id of the course.");
        tpc.setCourse_id(sc.nextInt());
        //exw ftiaksei ena tpc
        return (tpc);
    }

    public void insertTrainerPerCourse(TrainerPerCourse tpc) {
        String sql = "INSERT INTO"
                + " trainer_per_course"
                + " (trainer_id, course_id) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, tpc.getTrainer_id());
            ps.setInt(2, tpc.getCourse_id());
            ps.executeUpdate();
            System.out.println("success");
        } catch (SQLException ex) {
            Logger.getLogger(TrainerPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
        public ArrayList<TrainerPerCourse> getAllTrainersThatTeach() {
        String sql = "SELECT * FROM trainer_per_course";
        PreparedStatement ps = null;
        ArrayList<TrainerPerCourse> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TrainerPerCourse tpc = new TrainerPerCourse(rs.getInt("trainer_id"),
                        rs.getInt("course_id"));
                result.add(tpc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainerPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerPerCourseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }
        
}

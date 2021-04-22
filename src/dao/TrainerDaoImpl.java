package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Trainer;
import utils.DbUtils;

/**
 *
 * @author mcvakou
 */
public class TrainerDaoImpl implements TrainerDaoInt {    
    private Connection con;

    public Trainer askDataTrainer(Scanner sc) {
        Trainer trainer = new Trainer();
        // first_name, last_name, subject
        String first_name;
        String last_name;
        String subject;
        System.out.println("Type Trainer's first name");
        trainer.setFirst_name(first_name=sc.nextLine());
        System.out.println("Type Trainer's last name");
        trainer.setLast_name(last_name= sc.nextLine());
        System.out.println("Type Trainer's subject");
        trainer.setSubject(subject=sc.nextLine());
        return (trainer);
    }

    @Override
    public void insertTrainer (Trainer t) {
        String sql = "INSERT INTO trainers (first_name, last_name, subject) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getFirst_name());
            ps.setString(2, t.getLast_name());
            ps.setString(3, t.getSubject());
            ps.executeUpdate();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Trainer> getAllTrainers() {
        String sql = "SELECT * FROM trainers";
        PreparedStatement ps = null;
        ArrayList<Trainer> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trainer t = new Trainer(rs.getInt("trainer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("subject"));
                result.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }
    
    public List<Trainer> getListTrainerByCourseId(int courseId) {
        // (Scanner sc) another way and getting courseId in this method           
        String sql = "SELECT trainers.trainer_id, trainers.first_name, trainers.last_name, trainers.subject"
                + " FROM trainers, trainer_per_course"
                + " WHERE trainer_per_course.trainer_id = trainers.trainer_id"
                + " AND trainer_per_course.course_id = ?";

        //System.out.println(sql);
        PreparedStatement ps = null;
        ArrayList<Trainer> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trainer t = new Trainer(rs.getInt("trainer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("subject")
                        );
                result.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(TrainerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (result);

    }
    

    public void printTrainerList(List<Trainer> list) {
        for (Trainer t : list) {
            System.out.println(t);
        }
    }
    
}

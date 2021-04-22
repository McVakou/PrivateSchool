package dao;

import java.util.ArrayList;
import java.util.Scanner;
import models.TrainerPerCourse;

/**
 *
 * @author mcvakou
 */
public interface TrainerPerCourseDaoInt {

    public TrainerPerCourse askDataTrainerPerCourse(Scanner sc);

    public void insertTrainerPerCourse(TrainerPerCourse tpc);
    
    public ArrayList<TrainerPerCourse> getAllTrainersThatTeach();
}

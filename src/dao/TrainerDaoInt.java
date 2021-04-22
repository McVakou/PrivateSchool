package dao;

import java.util.List;
import java.util.Scanner;
import models.Trainer;

/**
 *
 * @author mcvakou
 */
public interface TrainerDaoInt {

    public void insertTrainer(Trainer t);

    public List<Trainer> getAllTrainers();
    
    public Trainer askDataTrainer(Scanner sc);
    
    public List<Trainer> getListTrainerByCourseId(int courseId);
    
}

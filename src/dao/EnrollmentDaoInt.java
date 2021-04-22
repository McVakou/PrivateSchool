package dao;

import java.util.ArrayList;
import java.util.Scanner;
import models.Enrollment;

/**
 *
 * @author mcvakou
 */
public interface EnrollmentDaoInt {

    public Enrollment askDataEnrollment(Scanner sc);

    public void insertEnrollment(Enrollment enrollment);

    public ArrayList<Enrollment> getAllEnrollments();

}

package dao;

import java.util.List;
import java.util.Scanner;
import models.Assignment;

/**
 *
 * @author mcvakou
 */
public interface AssignmentDaoInt {

    public void insertAssignment(Assignment a);

    public List<Assignment> getAllAssignments();

    public Assignment askDataAssignment(Scanner sc);

    public List<Assignment> getListAssignmentByCourseId(int courseId);

}

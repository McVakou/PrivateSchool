package dao;

import dto.Marks;
import java.util.List;
import java.util.Scanner;
import models.AssignmentPerStudentPerCourse;

/**
 *
 * @author mcvakou
 */
public interface AssPerStudentPerCourseDaoInt {
    
    public AssignmentPerStudentPerCourse askDataApSpC(Scanner sc);
    
    public void insertAssignmentPerStudentPerCourse(AssignmentPerStudentPerCourse apspc);
    
    public List<AssignmentPerStudentPerCourse> getAllApSpC();
    
    public Marks askGradesOfAssOfCourse(Scanner sc);
    
    public void grading(Scanner sc);
}

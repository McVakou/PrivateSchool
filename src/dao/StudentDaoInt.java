package dao;

import java.util.List;
import java.util.Scanner;
import models.Student;


/**
 *
 * @author mcvakou
 */
public interface StudentDaoInt {
    
    public void insertStudent(Student s);
    
    public List<Student> getAllStudents();
    
    public Student askDataStudent(Scanner sc);
    
    public List<Student> getListStudentByCourseId(int courseID); //, Scanner sc second way
    
    public List<Student> getListStudentEnrolledToManyCourses();
}

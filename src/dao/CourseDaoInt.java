package dao;

import java.util.List;
import java.util.Scanner;
import models.Course;

/**
 *
 * @author mcvakou
 */
public interface CourseDaoInt {

    public void insertCourse(Course c);

    public List<Course> getAllCourses();

    public Course askDataCourse(Scanner sc);
}

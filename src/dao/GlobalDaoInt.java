package dao;

import dto.AssCourseStudentMarks;
import java.util.List;

/**
 *
 * @author mcvakou
 */
public interface GlobalDaoInt {
    
    
    public List<AssCourseStudentMarks> getAssignmentPerCoursePerStudentByStudentId(int studentId);
}

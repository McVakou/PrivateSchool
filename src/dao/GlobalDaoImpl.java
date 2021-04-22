package dao;

import dto.AssCourseStudentMarks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DbUtils;

/**
 *
 * @author mcvakou
 */
public class GlobalDaoImpl implements GlobalDaoInt {

    private Connection con = null;

    public List<AssCourseStudentMarks> getAssignmentPerCoursePerStudentByStudentId(int studentId) {
        String sql = "SELECT students.student_id, courses.course_id, courses.title AS course_title, courses.stream,"
                + "assignments.assignment_id, assignments.title AS assignment_title, assignments.sub_date_time,"
                + "ass_per_student_per_course.oral_mark, ass_per_student_per_course.total_mark"
                + " FROM assignments"
                + " INNER JOIN ass_per_student_per_course ON assignments.assignment_id = ass_per_student_per_course.assignment_id"
                + " INNER JOIN enrollments ON ass_per_student_per_course.course_id = enrollments.course_id"
                + " AND ass_per_student_per_course.student_id = enrollments.student_id"
                + " INNER JOIN courses ON enrollments.course_id = courses.course_id"
                + " INNER JOIN students ON enrollments.student_id = students.student_id"
                + " HAVING students.student_id = ?";
        PreparedStatement ps = null;
        ArrayList<AssCourseStudentMarks> result = new ArrayList();
        try {
            con = DbUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AssCourseStudentMarks acsm = new AssCourseStudentMarks(rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getString("course_title"),
                        rs.getString("stream"),
                        rs.getInt("assignment_id"),
                        rs.getString("assignment_title"),
                        rs.getDate("sub_date_time"),
                        rs.getInt("oral_mark"),
                        rs.getInt("total_mark"));

                result.add(acsm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GlobalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return (result);
    }

    public void printACSM(List<AssCourseStudentMarks> listACSM) {
        for (AssCourseStudentMarks acsm : listACSM) {
            System.out.println(acsm);
        }

    }

}

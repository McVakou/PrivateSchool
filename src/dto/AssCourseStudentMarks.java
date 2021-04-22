package dto;

import java.util.Date;

/**
 *
 * @author mcvakou
 */
public class AssCourseStudentMarks {

    int student_id;
    int course_id;
    String course_title;
    String stream;
    int assignment_id;
    String assignment_title;
    Date sub_date_time;
    int oral_mark;
    int total_mark;

    public AssCourseStudentMarks() {
    }

    public AssCourseStudentMarks(int student_id, int course_id, String course_title, String stream, int assignment_id, String assignment_title, Date sub_date_time) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.course_title = course_title;
        this.stream = stream;
        this.assignment_id = assignment_id;
        this.assignment_title = assignment_title;
        this.sub_date_time = sub_date_time;
    }

    public AssCourseStudentMarks(int student_id, int course_id, String course_title, String stream, int assignment_id, String assignment_title, Date sub_date_time, int oral_mark, int total_mark) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.course_title = course_title;
        this.stream = stream;
        this.assignment_id = assignment_id;
        this.assignment_title = assignment_title;
        this.sub_date_time = sub_date_time;
        this.oral_mark = oral_mark;
        this.total_mark = total_mark;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public String getStream() {
        return stream;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public String getAssignment_title() {
        return assignment_title;
    }

    public Date getSub_date_time() {
        return sub_date_time;
    }

    public int getOral_mark() {
        return oral_mark;
    }

    public int getTotal_mark() {
        return total_mark;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public void setAssignment_title(String assignment_title) {
        this.assignment_title = assignment_title;
    }

    public void setSub_date_time(Date sub_date_time) {
        this.sub_date_time = sub_date_time;
    }

    public void setOral_mark(int oral_mark) {
        this.oral_mark = oral_mark;
    }

    public void setTotal_mark(int total_mark) {
        this.total_mark = total_mark;
    }

    public String toString() {
        return "Student id:" + student_id + "|"
                + " Course id:" + course_id + "|"
                + " Course title:" + course_title + "|"
                + " Course Stream:" + stream + "|"
                + " Assignment id:" + assignment_id + "|"
                + " Assignment title:" + assignment_title + "|"
                + " Submission date:" + sub_date_time + "|"
                + " Oral mark:" + oral_mark + "|"
                + " Total mark:" + total_mark + "|";
    }

}

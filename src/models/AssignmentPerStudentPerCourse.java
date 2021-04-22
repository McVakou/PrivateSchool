package models;

/**
 *
 * @author mcvakou
 */
public class AssignmentPerStudentPerCourse {

    
    private int assignment_id;
    private int student_id;
    private int course_id;
    private int oral_mark;
    private int total_mark;

    public AssignmentPerStudentPerCourse() {
    }

    public AssignmentPerStudentPerCourse(int oral_mark, int total_mark) {
        this.oral_mark = oral_mark;
        this.total_mark = total_mark;
    }
    

    public AssignmentPerStudentPerCourse(int assignment_id, int student_id, int course_id, int oral_mark, int total_mark) {
        this.assignment_id = assignment_id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.oral_mark = oral_mark;
        this.total_mark = total_mark;
    }

    public AssignmentPerStudentPerCourse(int assignment_id, int student_id, int course_id) {
        this.assignment_id = assignment_id;
        this.student_id = student_id;
        this.course_id = course_id;
    }


    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getOral_mark() {
        return oral_mark;
    }

    public void setOral_mark(int oral_mark) {
        this.oral_mark = oral_mark;
    }

    public int getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(int total_mark) {
        this.total_mark = total_mark;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.assignment_id;
        hash = 59 * hash + this.student_id;
        hash = 59 * hash + this.course_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssignmentPerStudentPerCourse other = (AssignmentPerStudentPerCourse) obj;
        if (this.assignment_id != other.assignment_id) {
            return false;
        }
        if (this.student_id != other.student_id) {
            return false;
        }
        if (this.course_id != other.course_id) {
            return false;
        }
        return true;
    }

}

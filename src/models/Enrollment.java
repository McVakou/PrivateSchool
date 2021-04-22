package models;

/**
 *
 * @author mcvakou
 */
public class Enrollment {

    private int student_id;
    private int course_id;

    public Enrollment() {
    }

    public Enrollment(int student_id, int course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.student_id;
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
        final Enrollment other = (Enrollment) obj;
        if (this.student_id != other.student_id) {
            return false;
        }
        if (this.course_id != other.course_id) {
            return false;
        }
        return true;
    }
    

}

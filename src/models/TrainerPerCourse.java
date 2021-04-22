package models;

/**
 *
 * @author mcvakou
 */
public class TrainerPerCourse {

    private int trainer_id;
    private int course_id;

    public TrainerPerCourse() {
    }

    public TrainerPerCourse(int trainer_id, int course_id) {
        this.trainer_id = trainer_id;
        this.course_id = course_id;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.trainer_id;
        hash = 97 * hash + this.course_id;
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
        final TrainerPerCourse other = (TrainerPerCourse) obj;
        if (this.trainer_id != other.trainer_id) {
            return false;
        }
        if (this.course_id != other.course_id) {
            return false;
        }
        return true;
    }

}

package models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mcvakou
 */
public class Assignment {

    private int assignment_id;
    private String title;
    private String description;
    private Date sub_date_time;

    public Assignment() {
    }

    public Assignment(int assignment_id, String title, String description, Date sub_date_time) {
        this.assignment_id = assignment_id;
        this.title = title;
        this.description = description;
        this.sub_date_time = sub_date_time;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSub_date_time() {
        return sub_date_time;
    }

    public void setSub_date_time(Date sub_date_time) {
        this.sub_date_time = sub_date_time;
    }

    @Override
    public String toString() {
        return "Assignment id:" + assignment_id + "|"
                + " Title:" + title + "|"
                + " Description:" + description + "|"
                + " Submission date:" + sub_date_time + "|";

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.sub_date_time);
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
        final Assignment other = (Assignment) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.sub_date_time, other.sub_date_time)) {
            return false;
        }
        return true;
    }
    

}

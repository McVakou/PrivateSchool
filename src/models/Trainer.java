package models;

import java.util.Objects;

/**
 *
 * @author mcvakou
 */
public class Trainer {

    private int trainer_id;
    private String first_name;
    private String last_name;
    private String subject;

    public Trainer() {
    }

    public Trainer(String first_name, String last_name, String subject) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.subject = subject;
    }

    public Trainer(int trainer_id, String first_name, String last_name, String subject) {
        this.trainer_id = trainer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.subject = subject;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Trainer id:" + trainer_id + "|"
                + " First name:" + first_name + "|"
                + " Last name:" + last_name + "|"
                + " Subject:" + subject + "|";

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.first_name);
        hash = 41 * hash + Objects.hashCode(this.last_name);
        hash = 41 * hash + Objects.hashCode(this.subject);
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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }
    

}

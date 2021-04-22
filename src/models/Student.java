package models;

import java.util.Date;

/**
 *
 * @author mcvakou
 */
//DEN ELEGXW AN THA MPEI STUDENT STHN VASH GIATI MPOREI NA YPARKSOUN STUDENTS
//ME AKRIVWS TA IDIA STOIXEIA PERA APO ID
public class Student {

    private int student_id;
    private String first_name;
    private String last_name;
    private double tuition_fees;
    private Date date_of_birth;

    public Student() {
    }

    public Student(String first_name, String last_name, double tuition_fees, Date date_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.tuition_fees = tuition_fees;
        this.date_of_birth = date_of_birth;
    }

    public Student(int student_id, String first_name, String last_name, double tuition_fees, Date date_of_birth) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.tuition_fees = tuition_fees;
        this.date_of_birth = date_of_birth;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public double getTuition_fees() {
        return tuition_fees;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setTuition_fees(double tuition_fees) {
        this.tuition_fees = tuition_fees;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Student id:" + student_id + "|"
                + " First name:" + first_name + "|"
                + " Last name:" + last_name + "|"
                + " Tuition fees:" + tuition_fees + "|"
                + " Date of birth:" + date_of_birth + "|";
    }

}

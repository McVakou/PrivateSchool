package dto;

/**
 *
 * @author mcvakou
 */
public class Marks {
    //---------------------- NOT USING MAYBE LATER------------------------------
    private String first_name;
    private String last_name;
    private String title;
    private String description;
    //--------------------------------------------------------------------------
    private int oral_mark;
    private int total_mark;

    public Marks() {
    }

    public Marks(int oral_mark, int total_mark) {
        this.oral_mark = oral_mark;
        this.total_mark = total_mark;
    }
    

    public Marks(String first_name, String last_name, String title, String description) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
        this.description = description;
    }

    public Marks(String first_name, String last_name, String title, String description, int oral_mark, int total_mark) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
        this.description = description;
        this.oral_mark = oral_mark;
        this.total_mark = total_mark;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
    public String toString() {
        return "oral_mark: " + oral_mark + "| " + "total_mark: " + total_mark;
    }
    
    
}

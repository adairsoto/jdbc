package jdbc;

public class Course {

    private int id;
    private String name;
    private int hoursLength;

    public Course(int id, String name, int hoursLength) {
        this.id = id;
        this.name = name;
        this.hoursLength = hoursLength;
    }

    public Course(String name, int hoursLength) {
        this.name = name;
        this.hoursLength = hoursLength;
    }

    public Course() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursLength() {
        return hoursLength;
    }

    public void setHoursLength(int hoursLength) {
        this.hoursLength = hoursLength;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id = ").append(id);
        sb.append(", name = '").append(name).append('\'');
        sb.append(", length = '").append(hoursLength).append('\'');
        sb.append("}");
        return sb.toString();
    }
}

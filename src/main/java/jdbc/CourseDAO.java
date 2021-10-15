package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    //Select/List
    public List<Course> list() {

        List<Course> courses = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "SELECT * FROM course";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int hl = rs.getInt("hours_length");

                courses.add(new Course(id, name, hl));
            }

        } catch (SQLException e) {
            System.out.println("Select Failed");
            e.printStackTrace();
          }

        return courses;
    }

    //Select by ID
    public Course getByID (int id) {

        Course course = new Course();
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "SELECT * FROM course WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setHoursLength(rs.getInt("hours_length"));
            }


        } catch (SQLException e) {
            System.out.println("Select Failed");
            e.printStackTrace();
        }
        return course;
    }

    //Insert
    public static void create(Course course) {
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "INSERT INTO course(name, hours_length) VALUES(?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getHoursLength());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Insert Successful - " + rowsAffected + " row added");

        } catch (SQLException e) {
            System.out.println("Insert Failed");
            e.printStackTrace();
          }
    }

    //Delete
    public static void delete(int id) {
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "DELETE FROM course WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Delete Successful - " + rowsAffected + " row removed");

        } catch (SQLException e) {
            System.out.println("Delete Failed");
            e.printStackTrace();
          }
    }

    //Update
    public static void update(Course course) {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "UPDATE course SET name = ?, hours_length = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getName());
            stmt.setInt(2, course.getHoursLength());
            stmt.setInt(3, course.getId());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Update Successful - " + rowsAffected + " row updated");

        } catch (SQLException e) {
            System.out.println("Update Failed");
            e.printStackTrace();
          }
    }

}

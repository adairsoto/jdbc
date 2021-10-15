package jdbc;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Select/List
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.list();

        //Select by ID
        //Course selectCourse = courseDAO.getByID(4);
        //System.out.println(selectCourse);



        //Insert
        //Course insertCourse = new Course(".Net", 20);
        //CourseDAO.create(insertCourse);

        //Delete
        //CourseDAO.delete(3);

        //Update
        //Course updateCourse = courseDAO.getByID(1);
        //updateCourse.setName("Angular");
        //updateCourse.setHoursLength(17);

        //courseDAO.update(updateCourse);

        courseDAO.list().forEach(System.out::println);
    }
}

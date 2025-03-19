package mthree.com.fullstackschool.dao;

import mthree.com.fullstackschool.dao.mappers.CourseMapper;
import mthree.com.fullstackschool.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    private final JdbcTemplate jdbcTemplate;

    public CourseDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Course createNewCourse(Course course) {
        //YOUR CODE STARTS HERE

        final String INSERT_COURSE = "INSERT INTO course (courseCode, courseDesc, teacherId) " +
                "values (?, ?, ?)";
        jdbcTemplate.update(INSERT_COURSE, course.getCourseName(), course.getCourseDesc(), course.getTeacherId());

        return course;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Course> getAllCourses() {
        //YOUR CODE STARTS HERE

        final String SELECT_ALL_COURSES = "SELECT * from course";
        return jdbcTemplate.query(SELECT_ALL_COURSES, new CourseMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Course findCourseById(int id) {
        //YOUR CODE STARTS HERE

        final String SELECT_COURSE_BY_ID = "SELECT * from course " +
                "where cid = ?";
        return jdbcTemplate.queryForObject(SELECT_COURSE_BY_ID, new CourseMapper(), id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateCourse(Course course) {
        //YOUR CODE STARTS HERE

        final String UPDATE_COURSE = "UPDATE course set courseCode = ?, courseDesc = ?, " +
                "teacherId = ? where cid = ?";
        jdbcTemplate.update(UPDATE_COURSE, course.getCourseName(), course.getCourseDesc(), course.getTeacherId(), course.getCourseId());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteCourse(int id) {
        //YOUR CODE STARTS HERE

        //deletes any foreign key references from course_student table
        deleteAllStudentsFromCourse(id);

        final String DELETE_COURSE = "DELETE from course where cid = ?";
        jdbcTemplate.update(DELETE_COURSE, id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteAllStudentsFromCourse(int courseId) {
        //YOUR CODE STARTS HERE

        final String DELETE_ALL_STUDENTS_COURSE = "Delete from course_student where course_id = ?";
        jdbcTemplate.update(DELETE_ALL_STUDENTS_COURSE, courseId);

        //YOUR CODE ENDS HERE
    }
}

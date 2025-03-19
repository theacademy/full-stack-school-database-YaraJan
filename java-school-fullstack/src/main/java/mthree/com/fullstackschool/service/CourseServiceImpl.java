package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.CourseDao;
import mthree.com.fullstackschool.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseServiceInterface {

    //YOUR CODE STARTS HERE

    @Autowired
    CourseDao courseDao;

    //Added constructor for the test case
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    //YOUR CODE ENDS HERE

    public List<Course> getAllCourses() {
        //YOUR CODE STARTS HERE

        return courseDao.getAllCourses();

        //YOUR CODE ENDS HERE
    }

    public Course getCourseById(int id) {
        //YOUR CODE STARTS HERE
        Course retrievedCourse = new Course();

        try {
            retrievedCourse = courseDao.findCourseById(id);
        } catch (DataAccessException ex) {
            retrievedCourse.setCourseName("Course Not Found");
            retrievedCourse.setCourseDesc("Course Not Found");
        }

        return retrievedCourse;

        //YOUR CODE ENDS HERE
    }

    public Course addNewCourse(Course course) {
        //YOUR CODE STARTS HERE

        if(!course.getCourseName().isBlank() && !course.getCourseDesc().isBlank()) {
            return courseDao.createNewCourse(course);
        }

        if(course.getCourseName().isBlank()) {
            course.setCourseName("Name blank, course NOT added");
        }
        if(course.getCourseDesc().isBlank()) {
            course.setCourseDesc("Description blank, course NOT added");
        }

        return course;

        //YOUR CODE ENDS HERE
    }

    public Course updateCourseData(int id, Course course) {
        //YOUR CODE STARTS HERE

        if(id != course.getCourseId()) {
            course.setCourseName("IDs do not match, course not updated");
            course.setCourseDesc("IDs do not match, course not updated");
            return course;
        }

        courseDao.updateCourse(course);
        return course;

        //YOUR CODE ENDS HERE
    }

    public void deleteCourseById(int id) {
        //YOUR CODE STARTS HERE

        courseDao.deleteCourse(id);
        System.out.println("Course ID: " + id + " deleted");

        //YOUR CODE ENDS HERE
    }
}

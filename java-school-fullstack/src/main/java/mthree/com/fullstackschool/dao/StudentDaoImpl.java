package mthree.com.fullstackschool.dao;

import mthree.com.fullstackschool.dao.mappers.StudentMapper;
import mthree.com.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.*;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Student createNewStudent(Student student) {
        //YOUR CODE STARTS HERE

        final String INSERT_STUDENT = "Insert into student (fName, lName) " +
                "Values (?, ?)";
        jdbcTemplate.update(INSERT_STUDENT, student.getStudentFirstName(), student.getStudentLastName());

        return student;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE

        final String SELECT_ALL_STUDENTS = "Select * from student";
        return jdbcTemplate.query(SELECT_ALL_STUDENTS, new StudentMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Student findStudentById(int id) {
        //YOUR CODE STARTS HERE

        final String SELECT_STUDENT_BY_ID = "SELECT * from student where sid = ?";
        return jdbcTemplate.queryForObject(SELECT_STUDENT_BY_ID, new StudentMapper(), id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateStudent(Student student) {
        //YOUR CODE STARTS HERE

        final String UPDATE_STUDENT = "Update student set fName = ?, lName = ? " +
                "where sid = ?";
        jdbcTemplate.update(UPDATE_STUDENT, student.getStudentFirstName(), student.getStudentLastName(), student.getStudentId());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudent(int id) {
        //YOUR CODE STARTS HERE

        //deletes student from courses they are enrolled in to get rid of foreign key references
        final String DELETE_COURSE_STUDENT = "Delete from course_student " +
                "where student_id = ?";
        jdbcTemplate.update(DELETE_COURSE_STUDENT, id);

        final String DELETE_STUDENT = "Delete from student where sid = ?";
        jdbcTemplate.update(DELETE_STUDENT, id);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        final String ADD_STUDENT_COURSE = "INSERT INTO course_student (student_id, course_id) " +
                "values (?, ?)";
        jdbcTemplate.update(ADD_STUDENT_COURSE, studentId, courseId);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE

        final String DELETE_STUDENT_COURSE = "Delete from course_student " +
                "where student_id = ? and course_id = ?";
        jdbcTemplate.update(DELETE_STUDENT_COURSE, studentId, courseId);

        //YOUR CODE ENDS HERE
    }
}

package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestStudentMapper {
    private Logger logger = LoggerFactory.getLogger(TestStudentMapper.class);
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testLoginVerifyDao(){
        Student student = studentMapper.loginVerifyDao("student", "student");
        System.out.println(student);
    }

    @Test
    public void testQueryAllStudentDao(){
        Student student1 = new Student();
        student1.setStuName("a");
        List<Student> students = studentMapper.queryAllStudentDao(student1);
        for(Student student:students){
            logger.debug("student:"+student);
        }
    }

    @Test
    public void testInsertSelective(){
        Student student = studentMapper.selectByPrimaryKey(24);
        logger.debug("student:"+student);
    }

    @Test
    public void testqueryAllStudentByCourseIdAndSectionId(){
        List<Student> students = studentMapper.queryAllStudentByCourseIdAndSectionId(23, 10);
        for(Student student:students){
            logger.debug("student:"+student);
        }
    }

    @Test
    public void testQueryStudentByTeacher(){
        List<Student> students = studentMapper.queryStudentByTeacher(15,17,4);
        for(Student student:students){
            logger.debug("student:"+student);
        }
    }
}

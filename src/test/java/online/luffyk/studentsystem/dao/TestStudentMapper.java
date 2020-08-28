package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestStudentMapper {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testLoginVerifyDao(){
        Student student = studentMapper.loginVerifyDao("student", "student");
        System.out.println(student);
    }
}

package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestStudentService {
    @Resource
    private StudentService studentService;

    @Test
    public void testLoginVerifyService(){
        Student student = studentService.loginVerifyService("student", "student");
        System.out.println(student);
    }
}

package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestTeacherService {
    @Resource
    private TeacherService teacherService;

    @Test
    public void testLoginVerifyService(){
        Teacher teacher = teacherService.loginVerifyService("teacher", "teacher");
        System.out.println(teacher);
    }
}

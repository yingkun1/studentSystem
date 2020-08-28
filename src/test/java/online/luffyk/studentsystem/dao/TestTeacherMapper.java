package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestTeacherMapper {
    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void testLoginVerifyDao(){
        Teacher teacher = teacherMapper.loginVerifyDao("teacher", "teacher");
        System.out.println(teacher);
    }
}

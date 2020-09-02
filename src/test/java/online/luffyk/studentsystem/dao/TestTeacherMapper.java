package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.domain.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestTeacherMapper {
    private Logger logger = LoggerFactory.getLogger(TestTeacherMapper.class);
    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void testLoginVerifyDao(){
        Teacher teacher = teacherMapper.loginVerifyDao("teacher", "teacher");
        System.out.println(teacher);
    }

    @Test
    public void testQueryAllTeacherDao(){
        Teacher teacher = new Teacher();
        teacher.setName("张");
        List<Teacher> teachers = teacherMapper.queryAllTeacherDao(teacher);
        for(Teacher value:teachers){
            logger.debug("teacher"+value);
        }
    }

    @Test
    public void testSelectCourseAndClazzByTeacherId(){
        List<Teacher> teachers = teacherMapper.selectCourseAndClazzByTeacherId(4);
        for(Teacher teacher:teachers){
            logger.debug("teacher:"+teacher);
        }
    }
}

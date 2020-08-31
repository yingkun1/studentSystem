package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestCourseMapper {
    private Logger logger = LoggerFactory.getLogger(TestCourseMapper.class);
    @Resource
    private CourseMapper courseMapper;

    @Test
    public void testQueryAllCourseDao(){
        logger.debug("courseMapper:"+courseMapper);
        Course course = new Course();
        course.setCourseName("J");
        List<Course> courses = courseMapper.queryAllCourseDao(course);
        for(Course value:courses){
            logger.debug("course:"+value);
        }
    }
}

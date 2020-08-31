package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Course;
import online.luffyk.studentsystem.domain.Teacher;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     *
     * @param course 课程的信息
     * @return 返回模糊查询到的结果
     */
    List<Course> queryAllCourseDao(Course course);

    /**
     *
     * @param teacherId 讲师的id
     * @return
     */
    Course queryCourseByTeacherIdDao(Integer teacherId);
}
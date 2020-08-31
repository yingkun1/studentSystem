package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Course;

import java.util.List;

public interface CourseService {

    /**
     *
     * @param course
     * @return 查询到的课程信息
     */
    List<Course> queryAllCourseService(Course course);

    /**
     *
     * @param id 主键id
     * @return 受影响的行数
     */
    int deleteByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 课程的信息
     * @return 受影响的行数
     */
    int insertSelectiveService(Course record);

    /**
     *
     * @param id 主键id
     * @return 返回对应的课程信息
     */
    Course selectByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 课程的信息
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(Course record);
}

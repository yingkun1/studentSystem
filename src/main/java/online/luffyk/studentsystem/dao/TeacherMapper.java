package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    /**
     *
     * @param userName 用户名
     * @param password 用户密码
     * @return 若用户存在则进行返回
     */
    Teacher loginVerifyDao(@Param("userName") String userName, @Param("password") String password);

    /**
     *
     * @param teacher 教师信息
     * @return 教师的信息
     */
    List<Teacher> queryAllTeacherDao(Teacher teacher);

    /**
     *
     * @param teacherId 教师的id
     * @return 返回该教师所教授的课程和班级
     */
    List<Teacher> selectCourseAndClazzByTeacherId(Integer teacherId);

    Integer updatePwdDao(@Param("id") Integer id,@Param("newPwd") String newPwd);

}
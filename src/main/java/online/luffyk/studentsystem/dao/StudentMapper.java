package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     *
     * @param userName 用户名
     * @param password 用户密码
     * @return 若用户存在则进行返回
     */
    Student loginVerifyDao(@Param("userName") String userName, @Param("password") String password);

    /**
     *
     * @return 获取所有的学生信息
     */
    List<Student> queryAllStudentDao(Student student);

    /**
     *
     * @param sectionId 学期id
     * @param courseId 课程id
     * @return
     */
    List<Student> queryAllStudentByCourseIdAndSectionId(@Param("sectionId") Integer sectionId,@Param("courseId") Integer courseId);

    /**
     *
     * @param clazzId 班级Id
     * @param subjectId 专业Id
     * @param teacherId 教师Id
     * @return 对应的学生信息
     */
    List<Student> queryStudentByTeacher(Integer clazzId,Integer subjectId,Integer teacherId);

    Integer updatePwdDao(@Param("id") Integer id,@Param("newPwd") String newPwd);
}
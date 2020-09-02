package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Student;

import java.util.List;

public interface StudentService {
    Student loginVerifyService(String userName, String password);

    /**
     *
     * @return 获取所有的学生信息
     */
    List<Student> queryAllStudentService(Student student);

    /**
     *
     * @param id 主键
     * @return 受影响的行数
     */
    Integer deleteByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 学生的信息
     * @return 受影响的行数
     */
    int insertSelectiveService(Student record);

    /**
     *
     * @param id 主键
     * @return 主键对应的学生信息
     */
    Student selectByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 学生的信息
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelectiveService(Student record);

    /**
     *
     * @param sectionId 学期id
     * @param courseId 课程ids
     * @return 对应的学生信息
     */
    List<Student> queryAllStudentByCourseIdAndSectionIdService(Integer sectionId,Integer courseId);

    /**
     *
     * @param clazzId 班级di
     * @param subjectId 专业id
     * @param teacherId 教师id
     * @return
     */
    List<Student> queryStudentBuTeacherService(Integer clazzId,Integer subjectId,Integer teacherId);


}

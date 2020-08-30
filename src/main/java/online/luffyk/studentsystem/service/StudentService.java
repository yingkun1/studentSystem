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


}

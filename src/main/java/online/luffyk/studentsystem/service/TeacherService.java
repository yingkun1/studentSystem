package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher loginVerifyService(String userName, String password);

    /**
     *
     * @param teacher 教师的一些信息
     * @return 返回模糊查询的解构
     */
    List<Teacher> queryAllTeacherService(Teacher teacher);

    /**
     *
     * @param id 主键id
     * @return 删除对应的数据
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     *
     * @param record 教师的信息
     * @return 受影响的行数
     */
    Integer insertSelectiveService(Teacher record);

    /**
     *
     * @param id 主键id
     * @return 对应的教师信息
     */
    Teacher selectByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 教师的信息
     * @return 受影响的行数
     */
    Integer updateByPrimaryKeySelectiveService(Teacher record);
}

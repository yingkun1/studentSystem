package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.domain.User;
import org.apache.ibatis.annotations.Param;

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
}
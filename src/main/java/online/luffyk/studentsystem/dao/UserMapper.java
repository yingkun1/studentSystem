package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     *
     * @param userName 用户名
     * @param password 用户密码
     * @return 若用户存在则进行返回
     */
    User loginVerifyDao(@Param("userName") String userName,@Param("password") String password);

    /**
     *
     * @param user 用户信息
     * @return 模糊查询返回的结果
     */
    List<User> queryAllUserDao(User user);

    Integer updatePwdDao(@Param("id") Integer id,@Param("newPwd") String newPwd);
}
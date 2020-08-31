package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.User;

import java.util.List;

public interface UserService {
    User selectByPrimaryKeyService(Integer id);

    User loginVerifyService(String userName,String password);

    /**
     *
     * @param user 用户的信息
     * @return 模糊查询后用户的信息
     */
    List<User> queryAllUserService(User user);

    /**
     *
     * @param id 主键id
     * @return 受影响的行数
     */
    int deleteByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 用户的信息
     * @return 受影响的行数
     */
    int insertSelectiveService(User record);

    /**
     *
     * @param record 用户的信息
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelectiveService(User record);


}

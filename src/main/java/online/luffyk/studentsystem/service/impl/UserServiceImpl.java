package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.UserMapper;
import online.luffyk.studentsystem.domain.User;
import online.luffyk.studentsystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKeyService(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User loginVerifyService(String userName, String password) {
        return userMapper.loginVerifyDao(userName,password);
    }

    @Override
    public List<User> queryAllUserService(User user) {
        return userMapper.queryAllUserDao(user);
    }

    @Override
    public int deleteByPrimaryKeyService(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelectiveService(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer updatePwdDao(Integer id, String newPwd) {
        return userMapper.updatePwdDao(id,newPwd);
    }
}

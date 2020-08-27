package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.UserMapper;
import online.luffyk.studentsystem.domain.User;
import online.luffyk.studentsystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKeyService(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

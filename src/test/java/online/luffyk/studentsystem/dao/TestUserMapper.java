package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestUserMapper {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectByPrimaryKey(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void testloginVerifyDao(){
        User user = userMapper.loginVerifyDao("admin", "93a9ded8a9ab7cb69dba0c0575665204");
        System.out.println(user);
    }
}

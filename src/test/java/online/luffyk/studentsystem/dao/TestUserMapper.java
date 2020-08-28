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
        User user = userMapper.loginVerifyDao("admin", "21232f297a57a5a743894a0e4a801fc3");
        System.out.println(user);
    }
}

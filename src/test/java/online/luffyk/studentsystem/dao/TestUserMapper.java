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
}

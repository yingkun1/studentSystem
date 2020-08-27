package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestUserMapper {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testShowAllUser(){
        List<User> users = userMapper.showAllUser();
        for(User user:users){
            System.out.println(user);
        }
    }
}

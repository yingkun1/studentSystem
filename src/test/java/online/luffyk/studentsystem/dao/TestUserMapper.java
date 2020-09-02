package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestUserMapper {
    private Logger logger = LoggerFactory.getLogger(TestUserMapper.class);
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

    @Test
    public void testQueryAllUserDao(){
        User user = new User();
        user.setUserName("ad");
        user.setName("管");
        List<User> users = userMapper.queryAllUserDao(user);
        for(User value:users){
            logger.debug("user:"+value);
        }
    }

    @Test
    public void testUpdatePwdDao(){
        Integer integer = userMapper.updatePwdDao(19, "789");
        if(integer == 1){
            logger.debug("更新成功");
        }else{
            logger.debug("更新失败");
        }
    }
}

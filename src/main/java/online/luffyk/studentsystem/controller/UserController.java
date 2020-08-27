package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "你好，SpringBoot,我准备通过你和LayUI做一个学生信息管理系统";
    }

    @ResponseBody
    @RequestMapping("getUser")
    public Object getUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum ,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        System.out.println("pageNum:"+pageNum+"pageSize:"+pageSize);
        PageHelper.startPage(pageNum,pageSize);
//        List<User> users = userService.showAllUserService();
//        return users;
        return null;
    }
}

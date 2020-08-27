package online.luffyk.studentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "你好，SpringBoot,我准备通过你和LayUI做一个学生信息管理系统";
    }
}

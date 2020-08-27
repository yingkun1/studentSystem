package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.domain.User;
import online.luffyk.studentsystem.service.UserService;
import online.luffyk.studentsystem.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("hello")
    public String hello(){
        return "你好，SpringBoot,我准备通过你和LayUI做一个学生信息管理系统";
    }

    @GetMapping("get/{id}")
    public Object getUserById(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        User user = userService.selectByPrimaryKeyService(id);
        Result result = new Result(200, user, "获取用户信息成功");
        System.out.println(result);
        return result;
    }

    //    @ResponseBody
//    @RequestMapping("getById")
//    public Object getUser(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum ,@RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
////        System.out.println("pageNum:"+pageNum+"pageSize:"+pageSize);
////        PageHelper.startPage(pageNum,pageSize);
////        List<User> users = userService.showAllUserService();
////        return users;
//        return null;
//    }
}

package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.User;
import online.luffyk.studentsystem.service.UserService;
import online.luffyk.studentsystem.utils.Result;
import online.luffyk.studentsystem.utils.TableResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("user")
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "你好，SpringBoot,我准备通过你和LayUI做一个学生信息管理系统";
    }

    @ResponseBody
    @GetMapping("get/{id}")
    public Object getUserById(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        User user = userService.selectByPrimaryKeyService(id);
        Result result = new Result(200, user, "获取用户信息成功");
        System.out.println(result);
        return result;
    }

    @RequestMapping("list")
    public String list(){
        return "user_list";
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public TableResult queryAllUser(User user){
        if(user!=null && user.getPage()!=null && user.getLimit()!=null){
            Integer page = user.getPage();
            Integer limit = user.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<User> users = userService.queryAllUserService(user);
        if(users.size()>0){
            PageInfo<User> pageInfo = new PageInfo<>(users);
            return new TableResult(1000,"获取用户信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),users);
        }else{
            return new TableResult(-1,"获取用户信息失败",0,null);
        }
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String addPage(){
        return "user_add";
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Object add(User user){
        int i = userService.insertSelectiveService(user);
        if(i==1){
            return new Result(200,null,"添加数据成功");
        }else{
            return new Result(400,null,"添加数据失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String updatePage(String ids, Model model){
        User user = userService.selectByPrimaryKeyService(Integer.valueOf(ids));
        model.addAttribute("user",user);
        return "user_update";
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(User user){
        logger.debug("==========================================");
        logger.debug("user:"+user);
        logger.debug("==========================================");
        int i = userService.updateByPrimaryKeySelectiveService(user);
        if(i==1){
            return new Result(200,null,"用户信息更新成功");
        }else{
            return new Result(400,null,"用户信息更新失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Object delete(String ids){
        String[] split = ids.split("-");
        for(String value:split){
            int delete = userService.deleteByPrimaryKeyService(Integer.valueOf(value));
            if(delete == 1){
                logger.debug("删除成功");
            }else{
                logger.debug("删除失败");
            }
        }
        return new Result(200,null,"删除成功");

    }


}

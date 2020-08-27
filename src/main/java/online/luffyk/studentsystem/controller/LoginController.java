package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.domain.User;
import online.luffyk.studentsystem.service.UserService;
import online.luffyk.studentsystem.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @PostMapping("login")
    public Object loginVerify(String userName, String password, String type, String captcha, HttpSession session){
        logger.debug("userName:"+userName);
        logger.debug("password:"+password);
        logger.debug("type:"+type);
        logger.debug("captcha:"+captcha);
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(type) || StringUtils.isEmpty(captcha)){
            return new Result(400,null,"缺省参数");
        }
        User user = userService.loginVerifyService(userName, password);
        if(user!=null){
            session.setAttribute("user",user);
            return new Result(200,user,"登录成功");
        }else{
            return new Result(400,user,"登录失败");
        }
    }
}

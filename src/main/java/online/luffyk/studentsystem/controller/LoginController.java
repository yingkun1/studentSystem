package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.domain.User;
import online.luffyk.studentsystem.service.StudentService;
import online.luffyk.studentsystem.service.TeacherService;
import online.luffyk.studentsystem.service.UserService;
import online.luffyk.studentsystem.utils.MD5Util;
import online.luffyk.studentsystem.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Validated
@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @PostMapping("login")
    public Object loginVerify(@NotNull(message = "用户名不能为空") String userName,@NotNull(message = "密码不能为空") String password, @NotNull(message = "用户类型不能为空") String type, @NotNull(message = "验证码不能为空") String captcha, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        logger.debug("userName:"+userName);
        logger.debug("password:"+password);
        logger.debug("type:"+type);
        logger.debug("captcha:"+captcha);
        String code = (String) session.getAttribute("code");
        logger.debug("获取到的验证码为："+code);
        if(code.equalsIgnoreCase(captcha)){
            if(type.equals("1")){
                //管理员登录
                User user = userService.loginVerifyService(userName, MD5Util.getMD5(password));
                if(user!=null){
                    session.setAttribute("user",user);
                    session.setAttribute("type","1");
                    return new Result(200,user,"登录成功");
                }else{
                    return new Result(400, null,"用户名或密码错误");
                }
            }else if(type.equals("2")){
                //教师登录
                Teacher teacher = teacherService.loginVerifyService(userName, MD5Util.getMD5(password));
                if(teacher!=null){
                    session.setAttribute("user",teacher);
                    session.setAttribute("type","2");
                    return new Result(200,teacher,"登录成功");
                }else{
                    return new Result(400, null,"用户名或密码错误");
                }
            }else if(type.equals("3")){
                //学生登录
                Student student = studentService.loginVerifyService(userName, MD5Util.getMD5(password));
                if(student!=null){
                    session.setAttribute("user",student);
                    session.setAttribute("type","3");
                    return new Result(200,student,"登录成功");
                }else{
                    return new Result(400, null,"用户名或密码错误");
                }
            }else{
                return new Result(400,null,"用户类型不存在");
            }

        }else{
            return new Result(400,null,"验证码输入不正确");
        }

    }
}

package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.domain.User;
import online.luffyk.studentsystem.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;

@Validated
@Controller
public class ChangPwdController {
    private final Logger logger = LoggerFactory.getLogger(ChangPwdController.class);
    @RequestMapping(value = "/pwd",method = RequestMethod.GET)
    public String changePasswordPage(){
        return "pwdInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/pwd",method = RequestMethod.POST)
    public Result changePassword(@NotBlank String type, @NotBlank String id, @NotBlank String sourcePwd, @NotBlank String newPwd, HttpSession session){
        logger.debug("type:"+type);
        logger.debug("id:"+id);
        logger.debug("sourcePwd:"+sourcePwd);
        logger.debug("newPwd:"+newPwd);
        if(type == "1"){
            User user = (User) session.getAttribute("user");
            String userPwd = user.getUserPwd();
            if(userPwd!=sourcePwd){
                return new Result(400,null,"原密码不正确");
            }
        }
        if(type == "2"){
            Teacher teacher = (Teacher) session.getAttribute("user");
            String teacherPwd = teacher.getTeacherPwd();
            if(teacherPwd!=sourcePwd){
                return new Result(400,null,"原密码不正确");
            }
        }
        if(type == "3"){
            Student student = (Student) session.getAttribute("student");
            String stuPwd = student.getStuPwd();
            if(stuPwd!=sourcePwd){
                return new Result(400,null,"原密码不正确");
            }
        }

        return null;
    }

}

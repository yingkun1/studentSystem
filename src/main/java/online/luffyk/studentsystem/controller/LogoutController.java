package online.luffyk.studentsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
    @RequestMapping("logout")
    public String logout(HttpSession session){
        logger.debug("用户准备退出");
        session.invalidate();
        return "redirect:/login";
    }
}

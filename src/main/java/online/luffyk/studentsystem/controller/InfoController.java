package online.luffyk.studentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InfoController {
    @RequestMapping("/info")
    public String info(){
        return "info";
    }
}

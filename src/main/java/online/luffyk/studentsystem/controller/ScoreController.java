package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.domain.Score;
import online.luffyk.studentsystem.domain.Section;
import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.service.ScoreService;
import online.luffyk.studentsystem.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RequestMapping("score")
@Controller
public class ScoreController {
    private final Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Resource
    private ScoreService scoreService;

    @ResponseBody
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Result createScore(String sectionIds, String courseIds, HttpSession session){
        String[] sectionSplit = sectionIds.split("-");
        String[] courseSplit = courseIds.split("-");
        Student student = (Student) session.getAttribute("user");
        logger.debug("studentId:"+student.getId());
        for(int i=0;i<sectionSplit.length;i++){
            logger.debug("section:"+sectionSplit[i]+"course:"+courseSplit[i]);
            Score score = new Score(null, Integer.valueOf(sectionSplit[i]), Integer.valueOf(courseSplit[i]), student.getId(), null);
            int i1 = scoreService.insertSelectiveService(score);
            if(i1 == 1){
                logger.debug("插入成功");
            }else{
                logger.debug("插入失败,失败的课程id为："+courseSplit[i]);
            }
        }
        return new Result(200,null,"插入成功");
    }
}

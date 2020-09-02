package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.Score;
import online.luffyk.studentsystem.domain.Section;
import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.service.ScoreService;
import online.luffyk.studentsystem.utils.Result;
import online.luffyk.studentsystem.utils.TableResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

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
            Score score = new Score(null, Integer.valueOf(sectionSplit[i]), Integer.valueOf(courseSplit[i]), student.getId(), null,null,null,null);
            int i1 = scoreService.insertSelectiveService(score);
            if(i1 == 1){
                logger.debug("插入成功");
            }else{
                logger.debug("插入失败,失败的课程id为："+courseSplit[i]);
            }
        }
        return new Result(200,null,"插入成功");
    }

    @RequestMapping(value = "student_score",method = RequestMethod.GET)
    public String queryStudentScorePage(){
        return "student_score";
    }

    @ResponseBody
    @RequestMapping(value = "student_score",method = RequestMethod.POST)
    public TableResult queryStudentScore(Score score,HttpSession session){
        logger.debug("准备查询学生的成绩");
        Student student = (Student) session.getAttribute("user");
        logger.debug("学生的id为："+student.getId());
        if(score!=null && score.getPage()!=null && score.getLimit()!=null){
            Integer page = score.getPage();
            Integer limit = score.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<Score> scores = scoreService.selectByStudentIdService(student.getId());
        if(scores.size()>0){
            PageInfo<Score> pageInfo = new PageInfo<>(scores);
            return new TableResult(1000,"获取成绩信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),scores);
        }else{
            return new TableResult(-1,"获取成绩信息失败",0,null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result addScoreToDB(String scores,String scoreIds){
        logger.debug("=============================================");
        logger.debug("scores:"+scores);
        logger.debug("scoreIds:"+scoreIds);
        logger.debug("==============================================");
        String[] scoreArray = scores.split("-");
        String[] scoreIdArray = scoreIds.split("-");
        for(int i=0;i<scoreArray.length;i++){
            Score score = new Score();
            score.setId(Integer.valueOf(scoreIdArray[i]));
            score.setScore(new BigDecimal(scoreArray[i]));
            int update = scoreService.updateByPrimaryKeySelectiveService(score);
            if(update == 1){
                logger.debug("更新成功");
            }else{
                logger.debug("更新失败");
            }
        }
        return new Result(200,null,"更新成绩成功");
    }
}

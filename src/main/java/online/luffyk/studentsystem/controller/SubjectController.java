package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.Subject;
import online.luffyk.studentsystem.service.SubjectService;
import online.luffyk.studentsystem.utils.Result;
import online.luffyk.studentsystem.utils.TableResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("subject")
@Controller
public class SubjectController {
    private Logger logger = LoggerFactory.getLogger(SubjectController.class);
    @Resource
    private SubjectService subjectService;

    @RequestMapping("list")
    public String showAllSubject(){
        return "subject_list";
    }

    @GetMapping("add")
    public String addSubject(){
        return "subject_add";
    }

    @ResponseBody
    @PostMapping(value = "add")
    public Object addSubjectToDB(Subject subject){
        logger.debug("subject:"+subject);
        int insert = subjectService.insert(subject);
        if(insert == 1){
            return new Result(200,null,"插入数据成功");
        }else{
            return new Result(400,null,"插入数据失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String updateSubject(String ids, Model model){
        logger.debug("ids:"+ids);
        Subject subject = subjectService.selectByPrimaryKey(Integer.valueOf(ids));
        logger.debug("subject:"+subject);
        model.addAttribute("subject",subject);
        return "subject_update";
    }

    @ResponseBody
    @PostMapping("update")
    public Object updateSubjectToDB(Subject subject){
        logger.debug("subject:"+subject);
        int update = subjectService.updateByPrimaryKeySelectiveService(subject);
        if(update==1){
            return new Result(200,null,"更新成功");
        }else{
            return new Result(400,null,"更新失败");
        }

    }

    @ResponseBody
    @RequestMapping("query")
    public Object queryAllSubject(Subject subject){
        if(subject!=null && subject.getPage()!=null && subject.getLimit()!=null){
            Integer page = subject.getPage();
            Integer limit = subject.getLimit();
            logger.info("page:"+page+"limit:"+limit);
            logger.info("subject:"+subject);
            //分页
            PageHelper.startPage(page,limit);
        }
        List<Subject> subjects = subjectService.showAllSubjectService(subject);
        PageInfo<Subject> pageInfo = new PageInfo<>(subjects);
        logger.debug("pageInfo:"+pageInfo);

        if(subjects.size()>0){
            return new TableResult(1000,"获取全部专业信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),subjects);
        }else{
            return new TableResult(-1,"获取全部专业信息失败",0,subjects);
        }
    }

    @ResponseBody
    @RequestMapping("delete")
    public Object deleteSubjectByPrimaryKey(String ids){
        logger.debug("准备删除一个用户");
        logger.debug("ids:"+ids);
        String[] split = ids.split("-");
        for(String value:split){
            Integer integer = subjectService.deleteByPrimaryKeyService(Integer.valueOf(value));
            if(integer==1){
                logger.debug("删除成功");
            }else{
                logger.debug("删除失败，失败的id为:"+value);
            }
        }
        return new Result(200,null,"删除成功");
    }

}

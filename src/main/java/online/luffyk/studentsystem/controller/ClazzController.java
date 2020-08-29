package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.Clazz;
import online.luffyk.studentsystem.domain.Subject;
import online.luffyk.studentsystem.service.ClazzService;
import online.luffyk.studentsystem.service.SubjectService;
import online.luffyk.studentsystem.utils.Result;
import online.luffyk.studentsystem.utils.TableResult;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("clazz")
@Controller
public class ClazzController {
    private Logger logger = LoggerFactory.getLogger(ClazzController.class);
    @Resource
    private ClazzService clazzService;

    @Resource
    private SubjectService subjectService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String showAllClazz(){
        return "clazz_list";
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public TableResult queryAllClazz(Clazz clazz){
        if(clazz!=null && clazz.getLimit()!=null && clazz.getPage()!=null){
            Integer page = clazz.getPage();
            Integer limit = clazz.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<Clazz> clazzes = clazzService.showAllClazzService(clazz);
        PageInfo<Clazz> pageInfo = new PageInfo<>(clazzes);
        if(clazzes.size()>0){
            return new TableResult(1000,"获取全部班级信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),clazzes);
        }else{
            return new TableResult(-1,"没有获取到班级信息",0,null);
        }
    }

    /**
     *
     * @return 跳转到添加页面
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPage(Model model){
        List<Subject> subjects = subjectService.showAllSubjectService(null);
        model.addAttribute("subjects",subjects);
        return "clazz_add";
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(Clazz clazz){
        logger.debug("clazz:"+clazz);
        Integer integer = clazzService.addClazzService(clazz);
        if(integer == 1){
            return new Result(200,null,"添加班级信息成功");
        }else{
            return new Result(400,null,"添加班级信息失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(String ids){
        logger.debug("ids:"+ids);
        String[] split = ids.split("-");
        for(String value:split){
            Integer integer = clazzService.deleteClazzByPrimaryKey(Integer.valueOf(value));
            if(integer==1){
                logger.debug("删除成功");
            }else{
                logger.debug("删除失败，失败的id数据为："+value);
            }
        }
        return new Result(200,null,"删除成功");
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String updatePage(String ids,Model model){
        logger.debug("ids:"+ids);
        Clazz clazz = clazzService.selectByPrimaryKeyService(Integer.valueOf(ids));
        List<Subject> subjects = subjectService.showAllSubjectService(null);
        logger.debug("clazz:"+clazz);
        logger.debug("subjects:"+subjects);
        model.addAttribute("clazz",clazz);
        model.addAttribute("subjects",subjects);
        return "clazz_update";
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(Clazz clazz){
        logger.debug("clazz:"+clazz);
        logger.debug("准备更新数据");
        Integer update = clazzService.UpdateByPrimaryKeySelectiveService(clazz);
        if(update == 1){
            return new Result(200,null,"修改班级信息成功");
        }else{
            return new Result(400,null,"修改班级信息失败");
        }
    }
}

package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.Request;
import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.service.TeacherService;
import online.luffyk.studentsystem.utils.Result;
import online.luffyk.studentsystem.utils.TableResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("teacher")
@Controller
public class TeacherController {
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);
    @Resource
    private TeacherService teacherService;

    @RequestMapping("list")
    public String list(){
        return "teacher_list";
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public TableResult queryAllTeacher(Teacher teacher){
        if(teacher!=null && teacher.getPage()!=null && teacher.getLimit()!=null){
            Integer page = teacher.getPage();
            Integer limit = teacher.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<Teacher> teachers = teacherService.queryAllTeacherService(teacher);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        if(teachers.size()>0){
            return new TableResult(1000,"获取教师信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),teachers);
        }else{
            return new TableResult(-1,"获取教师信息失败",0,null);
        }
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String addPage(){
        return "teacher_add";
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result add(Teacher teacher){
        Integer integer = teacherService.insertSelectiveService(teacher);
        if(integer == 1){
            return new Result(200,null,"插入数据成功");
        }else{
            return new Result(400,null,"插入数据失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String updatePage(String ids, Model model){

        Teacher teacher = teacherService.selectByPrimaryKeyService(Integer.valueOf(ids));
        model.addAttribute("teacher",teacher);
        return "teacher_update";
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(Teacher teacher){
        logger.debug("============================================");
        logger.debug("teacher:"+teacher);
        logger.debug("============================================");
        Integer integer = teacherService.updateByPrimaryKeySelectiveService(teacher);
        if(integer == 1){
            return new Result(200,null,"教师信息修改成功");
        }else{
            return new Result(400,null,"教师信息修改失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(String ids){
        String[] split = ids.split("-");
        for(String value:split){
            Integer integer = teacherService.deleteByPrimaryKey(Integer.valueOf(value));
            if(integer == 1){
                logger.debug("删除成功");
            }else{
                logger.debug("删除失败，失败的id为："+ids);
            }
        }
        return new Result(200,null,"删除成功");
    }
}

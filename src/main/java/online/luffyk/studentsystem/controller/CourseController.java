package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.Course;
import online.luffyk.studentsystem.service.CourseService;
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

@RequestMapping("course")
@Controller
public class CourseController {
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    @Resource
    private CourseService courseService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "course_list";
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public TableResult queryAllCourse(Course course){
        if(course!=null && course.getPage()!=null && course.getLimit()!=null){
            Integer page = course.getPage();
            Integer limit = course.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<Course> courses = courseService.queryAllCourseService(course);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        if(courses.size()>0){
            return new TableResult(1000,"获取课程信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),courses);
        }else{
            return new TableResult(-1,"获取课程信息失败",0,null);
        }
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String addPage(){
        return "course_add";
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result add(Course course){
        int i = courseService.insertSelectiveService(course);
        if(i == 1){
            return new Result(200,null,"添加课程信息成功");
        }else{
            return new Result(400,null,"添加课程信息失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String updatePage(String ids, Model model){
        logger.debug("ids:"+ids);
        Course course = courseService.selectByPrimaryKeyService(Integer.valueOf(ids));
        model.addAttribute("course",course);
        return "course_update";
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(Course course){
        logger.debug("course:"+course);
        int i = courseService.updateByPrimaryKeySelective(course);
        if(i == 1){
            return new Result(200,null,"获取课程信息成功");
        }else{
            return new Result(400,null,"获取课程信息失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(String ids){
        String[] split = ids.split("-");
        for(String value:split){
            int delete = courseService.deleteByPrimaryKeyService(Integer.valueOf(value));
            if(delete == 1){
                logger.debug("删除成功");
            }else{
                logger.debug("删除失败");
            }
        }
        return new Result(200,null,"删除课程信息成功");
    }
}

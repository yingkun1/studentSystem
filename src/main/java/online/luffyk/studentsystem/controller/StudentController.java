package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.Clazz;
import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.domain.Subject;
import online.luffyk.studentsystem.service.ClazzService;
import online.luffyk.studentsystem.service.StudentService;
import online.luffyk.studentsystem.service.SubjectService;
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

@RequestMapping("student")
@Controller
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Resource
    private StudentService studentService;

    @Resource
    private SubjectService subjectService;

    @Resource
    private ClazzService clazzService;
    /**
     *
     * @return  跳转到学生展示页面
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "student_list";
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public TableResult queryAllStudent(Student student){
        if(student!=null && student.getPage()!=null && student.getLimit()!=null){
            Integer limit = student.getLimit();
            Integer page = student.getPage();
            PageHelper.startPage(page,limit);
        }
        List<Student> students = studentService.queryAllStudentService(student);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        if(students.size()>0){
            return new TableResult(1000,"获取学生信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),students);
        }else{
            return new TableResult(-1,"获取学生信息失败",0,null);
        }
    }

    /**
     *
     * @return 跳转到学生添加页面
     */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String addPage(Model model){
        List<Subject> subjects = subjectService.showAllSubjectService(null);
        model.addAttribute("subjects",subjects);
        return "student_add";
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result add(Student student){
        logger.debug("student:"+student);
        int count = studentService.insertSelectiveService(student);
        if(count == 1){
            return new Result(200,null,"添加数据成功");
        }else{
            return new Result(400,null,"添加数据失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.GET)
    public String updatePage(String ids,Model model){
        logger.debug("ids:"+ids);
        List<Subject> subjects = subjectService.showAllSubjectService(null);
        List<Clazz> clazzes = clazzService.showAllClazzService(null);
        Student student = studentService.selectByPrimaryKeyService(Integer.valueOf(ids));
        model.addAttribute("student",student);
        model.addAttribute("subjects",subjects);
        model.addAttribute("clazzes",clazzes);
        return "student_update";
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(Student student){
        logger.debug("======================================================");
        logger.debug("student:"+student);
        int update = studentService.updateByPrimaryKeySelectiveService(student);
        if(update == 1){
            return new Result(200,null,"更新学生信息成功");
        }else{
            return new Result(400,null,"更新学生信息失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Object delete(String ids){
        logger.debug("ids:"+ids);
        String[] split = ids.split("-");
        for(String value:split){
            Integer integer = studentService.deleteByPrimaryKeyService(Integer.valueOf(value));
            if(integer == 1){
                logger.debug("删除成功");
            }else{
                logger.debug("删除失败");
            }
        }
        return new Result(200,null,"删除成功");
    }
}

package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.service.StudentService;
import online.luffyk.studentsystem.utils.TableResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("student")
@Controller
public class StudentController {
    @Resource
    private StudentService studentService;
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
}

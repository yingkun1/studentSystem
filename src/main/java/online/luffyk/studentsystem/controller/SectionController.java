package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.dao.SectionMapper;
import online.luffyk.studentsystem.domain.*;
import online.luffyk.studentsystem.service.*;
import online.luffyk.studentsystem.utils.Result;
import online.luffyk.studentsystem.utils.TableResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("section")
@Controller
public class SectionController {
    private final Logger logger = LoggerFactory.getLogger(SectionController.class);

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "section_list";
    }

    @Resource
    private SubjectService subjectService;

    @Resource
    private SectionService sectionService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private CourseService courseService;

    @Resource
    private ClazzService clazzService;

    @Resource
    private StudentService studentService;
    /**
     *
     * @return 获取树所需要的数据
     */
    @ResponseBody
    @RequestMapping(value = "tree",method = RequestMethod.POST)
    public Object tree(){
        logger.debug("准备获取树相关的数据");
        List<Subject> subjects = subjectService.showAllSubjectAndClazzService();
        ArrayList<Object> arrayList = new ArrayList<>();
        for(Subject subject:subjects){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("id",subject.getId());
            hashMap.put("pId",0);
            hashMap.put("name",subject.getSubjectName());
            ArrayList<Object> arrayList1 = new ArrayList<>();
            if(subject.getClazzList().size()>0){
                List<Clazz> clazzList = subject.getClazzList();
                for(Clazz clazz:clazzList){
                    HashMap<String, Object> hashMap1 = new HashMap<>();
                    hashMap1.put("id",clazz.getId());
                    hashMap1.put("pId",clazz.getSubjectId());
                    hashMap1.put("name",clazz.getClazzName());
                    arrayList1.add(hashMap1);
                }
            }
            hashMap.put("children",arrayList1);
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public TableResult queryAllSection(@RequestBody Section section){
        if(section!=null && section.getPage()!=null && section.getLimit()!=null){
            Integer page = section.getPage();
            Integer limit = section.getLimit();
            logger.debug("page:"+page);
            logger.debug("limit:"+limit);
            PageHelper.startPage(page,limit);
        }
        List<Section> sections = sectionService.queryAllSectionService(section);
        if(sections.size()>0){
            PageInfo<Section> pageInfo = new PageInfo<>(sections);
            return new TableResult(1000,"获取学期信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),sections);
        }else{
            return new TableResult(-1,"暂时没有学期信息，请添加",0,null);
        }
    }


    @RequestMapping(value = "add/{clazzId}",method = RequestMethod.GET)
    public String addPage(@PathVariable("clazzId") Integer clazzId, Model model){
        logger.debug("=====================================================");
        logger.debug("clazzId:"+clazzId);
        logger.debug("=====================================================");
        Clazz clazz = clazzService.selectByPrimaryKeyService(clazzId);
        List<Teacher> teachers = teacherService.queryAllTeacherService(null);
        List<Course> courses = courseService.queryAllCourseService(null);
        model.addAttribute("clazz",clazz);
        model.addAttribute("teachers",teachers);
        model.addAttribute("courses",courses);
        return "section_add";
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Result add(Section section){
        int insert = sectionService.insertSelectiveService(section);
        if(insert == 1){
            return new Result(200,null,"添加学期信息成功");
        }else{
            return new Result(400,null,"添加学期信息失败");
        }
    }

    @RequestMapping("update")
    public String updatePage(String ids,Model model){
        Section section = sectionService.selectByPrimaryKeyService(Integer.valueOf(ids));
        List<Teacher> teachers = teacherService.queryAllTeacherService(null);
        List<Course> courses = courseService.queryAllCourseService(null);
        model.addAttribute("teachers",teachers);
        model.addAttribute("courses",courses);
        model.addAttribute("section",section);
        return "section_update";
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update(Section section){
        logger.debug("=====================================================");
        logger.debug("section:"+section);
        logger.debug("=====================================================");
        int update = sectionService.updateByPrimaryKeySelectiveService(section);
        if(update == 1){
            return new Result(200,null,"修改学期信息成功");
        }else{
            return new Result(400,null,"修改学期信息失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Result delete(String ids){
        String[] split = ids.split("-");
        for(String value:split){
            int delete = sectionService.deleteByPrimaryKeyService(Integer.valueOf(value));
            if(delete == 1){
                logger.debug("删除成功");
            }else{
                logger.debug("删除失败");
            }
        }
        return new Result(200,null,"学期信息删除成功");
    }

    @RequestMapping(value = "student_section",method = RequestMethod.GET)
    public String studentSectionPage(){
        return "student_section";
    }

    @ResponseBody
    @RequestMapping(value = "query_student_section",method = RequestMethod.POST)
    public TableResult studentSection(Section section,HttpSession session){
        Student student = (Student) session.getAttribute("user");
        logger.debug("student:"+student);
        Integer studentId = student.getId();
        if(section!=null&&section.getPage()!=null&&section.getLimit()!=null){
            Integer page = section.getPage();
            Integer limit = section.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<Section> sections = sectionService.queryByStudentService(studentId);
        if(sections.size()>0){
            PageInfo<Section> pageInfo = new PageInfo<>(sections);
            return new TableResult(1000,"获取到学生信息相关的学期信息",Integer.valueOf(String.valueOf(pageInfo.getTotal())),sections);
        }else{
            return new TableResult(-1,"没有获取学生信息相关的学期信息",0,null);
        }
    }

    @RequestMapping(value = "teacher_section",method = RequestMethod.GET)
    public String teacherSectionPage(){
        return "teacher_section";
    }

    @ResponseBody
    @RequestMapping(value = "teacher_section",method = RequestMethod.POST)
    public TableResult teacherSection(Teacher teacher,HttpSession session){
        Teacher teacher1 = (Teacher) session.getAttribute("user");
        Integer teacher1Id = teacher1.getId();
        logger.debug("===============================");
        logger.debug("teacherId:"+teacher1Id);
        logger.debug("===============================");
        if(teacher!=null && teacher.getPage()!=null&&teacher.getLimit()!=null){
            Integer page = teacher.getPage();
            Integer limit = teacher.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<Teacher> teachers = teacherService.SelectCourseAndClazzByTeacherIdService(teacher1Id);
        if(teachers.size()>0){
            PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
            return new TableResult(1000,"获取教师的课程和班级信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),teachers);
        }else{
            return new TableResult(-1,"获取教师的课程和班级信息失败",0,null);
        }

    }

    @RequestMapping(value = "teacher_student_score",method = RequestMethod.GET)
    public String teacherStudentScorePage(String courseId,String sectionId,Model model){
        logger.debug("courseId:"+courseId);
        logger.debug("sectionId:"+sectionId);
        List<Student> students = studentService.queryAllStudentByCourseIdAndSectionIdService(Integer.valueOf(sectionId), Integer.valueOf(courseId));
        logger.debug("students:"+students);
        model.addAttribute("students",students);
        model.addAttribute("courseId",courseId);
        model.addAttribute("sectionId",sectionId);
        return "teacher_student_score";
    }



}

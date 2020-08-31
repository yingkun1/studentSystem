package online.luffyk.studentsystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.luffyk.studentsystem.dao.SectionMapper;
import online.luffyk.studentsystem.domain.Clazz;
import online.luffyk.studentsystem.domain.Section;
import online.luffyk.studentsystem.domain.Subject;
import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.service.SectionService;
import online.luffyk.studentsystem.service.SubjectService;
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
    public TableResult queryAllSection(Section section){
        if(section!=null && section.getPage()!=null && section.getLimit()!=null){
            Integer page = section.getPage();
            Integer limit = section.getLimit();
            PageHelper.startPage(page,limit);
        }
        List<Section> sections = sectionService.queryAllSectionService();
        if(sections.size()>0){
            PageInfo<Section> pageInfo = new PageInfo<>(sections);
            return new TableResult(1000,"获取学期信息成功",Integer.valueOf(String.valueOf(pageInfo.getTotal())),sections);
        }else{
            return new TableResult(-1,"获取学期信息失败",0,null);
        }
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String addPage(Model model){
        List<Teacher> teachers = teacherService.queryAllTeacherService(null);
        model.addAttribute("teachers",teachers);
        return "section_add";
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

}

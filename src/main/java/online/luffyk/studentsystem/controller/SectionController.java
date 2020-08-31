package online.luffyk.studentsystem.controller;

import online.luffyk.studentsystem.domain.Clazz;
import online.luffyk.studentsystem.domain.Subject;
import online.luffyk.studentsystem.service.SubjectService;
import online.luffyk.studentsystem.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
    /**
     *
     * @return 获取树所需要的数据
     */
    @ResponseBody
    @RequestMapping(value = "tree",method = RequestMethod.POST)
    public Object tree(){
//        return "[\n" +
//                "\t\t\t{ id:1, pId:0, name:\"父节点1 - 展开\", open:true},\n" +
//                "\t\t\t{ id:11, pId:1, name:\"父节点11 - 折叠\"},\n" +
//                "\t\t\t{ id:111, pId:11, name:\"叶子节点111\"},\n" +
//                "\t\t\t{ id:112, pId:11, name:\"叶子节点112\"},\n" +
//                "\t\t\t{ id:113, pId:11, name:\"叶子节点113\"},\n" +
//                "\t\t\t{ id:114, pId:11, name:\"叶子节点114\"},\n" +
//                "\t\t\t{ id:12, pId:1, name:\"父节点12 - 折叠\"},\n" +
//                "\t\t\t{ id:121, pId:12, name:\"叶子节点121\"},\n" +
//                "\t\t\t{ id:122, pId:12, name:\"叶子节点122\"},\n" +
//                "\t\t\t{ id:123, pId:12, name:\"叶子节点123\"},\n" +
//                "\t\t\t{ id:124, pId:12, name:\"叶子节点124\"},\n" +
//                "\t\t\t{ id:13, pId:1, name:\"父节点13 - 没有子节点\", isParent:true},\n" +
//                "\t\t\t{ id:2, pId:0, name:\"父节点2 - 折叠\"},\n" +
//                "\t\t\t{ id:21, pId:2, name:\"父节点21 - 展开\", open:true},\n" +
//                "\t\t\t{ id:211, pId:21, name:\"叶子节点211\"},\n" +
//                "\t\t\t{ id:212, pId:21, name:\"叶子节点212\"},\n" +
//                "\t\t\t{ id:213, pId:21, name:\"叶子节点213\"},\n" +
//                "\t\t\t{ id:214, pId:21, name:\"叶子节点214\"},\n" +
//                "\t\t\t{ id:22, pId:2, name:\"父节点22 - 折叠\"},\n" +
//                "\t\t\t{ id:221, pId:22, name:\"叶子节点221\"},\n" +
//                "\t\t\t{ id:222, pId:22, name:\"叶子节点222\"},\n" +
//                "\t\t\t{ id:223, pId:22, name:\"叶子节点223\"},\n" +
//                "\t\t\t{ id:224, pId:22, name:\"叶子节点224\"},\n" +
//                "\t\t\t{ id:23, pId:2, name:\"父节点23 - 折叠\"},\n" +
//                "\t\t\t{ id:231, pId:23, name:\"叶子节点231\"},\n" +
//                "\t\t\t{ id:232, pId:23, name:\"叶子节点232\"},\n" +
//                "\t\t\t{ id:233, pId:23, name:\"叶子节点233\"},\n" +
//                "\t\t\t{ id:234, pId:23, name:\"叶子节点234\"},\n" +
//                "\t\t\t{ id:3, pId:0, name:\"父节点3 - 没有子节点\", isParent:true}\n" +
//                "\t\t]";
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
}

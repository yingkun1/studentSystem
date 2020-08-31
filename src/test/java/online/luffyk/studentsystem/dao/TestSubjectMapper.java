package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Subject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestSubjectMapper {
    private Logger logger = LoggerFactory.getLogger(TestSubjectMapper.class);
    @Resource
    private SubjectMapper subjectMapper;

    @Test
    public void testShowAllSubjectDao(){
//        Subject subject = new Subject(null, null, "工", null);
        List<Subject> subjects = subjectMapper.showAllSubjectDao(null);
        for(Subject value:subjects){
            System.out.println(value);
        }
    }

    @Test
    public void testDeleteByPrimaryKey(){
        int i = subjectMapper.deleteByPrimaryKey(21);
        if(i==1){
            logger.debug("删除成功");
        }else{
            logger.debug("删除失败");
        }
    }

    @Test
    public void testInsert(){
        Subject subject = new Subject(null, "音乐表演系", "艺术学院", "都是艺术型人才",null);
        int count = subjectMapper.insert(subject);
        if(count == 1){
            logger.debug("添加成功");
        }else{
            logger.debug("添加失败");
        }
    }

    @Test
    public void testSelectByPrimaryKey(){
        Subject subject = subjectMapper.selectByPrimaryKey(17);
        logger.info("subject:"+subject);
    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        Subject subject = subjectMapper.selectByPrimaryKey(39);
        subject.setCollege("明德专业");
        int update = subjectMapper.updateByPrimaryKeySelective(subject);
        if(update == 1){
            logger.debug("更新成功");
        }else{
            logger.debug("更新失败");
        }
    }

    @Test
    public void testShowAllSubjectAndClazzDao(){
        List<Subject> subjects = subjectMapper.showAllSubjectAndClazzDao();
        for(Subject subject:subjects){
            logger.debug("subject:"+subject);
        }
    }
}

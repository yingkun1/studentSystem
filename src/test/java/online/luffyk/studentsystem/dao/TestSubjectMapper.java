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
}

package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Section;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestSectionMapper {
    private final Logger logger = LoggerFactory.getLogger(TestSectionMapper.class);
    @Resource
    private SectionMapper sectionMapper;

    @Test
    public void testQueryAllSectionDao(){
        Section section1 = new Section();
        section1.setClazzId(16);
        List<Section> sections = sectionMapper.queryAllSectionDao(section1);
        for(Section section:sections){
            logger.debug("section:"+section);
        }
    }
}

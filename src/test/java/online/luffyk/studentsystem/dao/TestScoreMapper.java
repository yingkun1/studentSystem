package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Score;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestScoreMapper {
    private final Logger logger = LoggerFactory.getLogger(TestScoreMapper.class);
    @Resource
    private ScoreMapper scoreMapper;

    @Test
    public void testInsertSelective(){
        Score score = new Score(null, 12, 5, 17, null);
        int insert = scoreMapper.insertSelective(score);
        if(insert == 1){
            logger.debug("插入成功");
        }else{
            logger.debug("插入失败");
        }
    }
}

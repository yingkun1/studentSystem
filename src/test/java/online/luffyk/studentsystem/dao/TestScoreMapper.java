package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Score;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class TestScoreMapper {
    private final Logger logger = LoggerFactory.getLogger(TestScoreMapper.class);
    @Resource
    private ScoreMapper scoreMapper;

    @Test
    public void testInsertSelective(){
        Score score = new Score(null, 12, 5, 17, null,null,null,null);
        int insert = scoreMapper.insertSelective(score);
        if(insert == 1){
            logger.debug("插入成功");
        }else{
            logger.debug("插入失败");
        }
    }

    @Test
    public void testSelectByStudentIdDao(){
        List<Score> scores = scoreMapper.selectByStudentIdDao(16);
        for(Score score:scores){
            logger.debug("score:"+score);
        }
    }

    @Test
    public void testupdateByPrimaryKeySelective(){
        Score score = new Score();
        score.setId(55);
        score.setScore(new BigDecimal("99.8"));
        int update = scoreMapper.updateByPrimaryKeySelective(score);
        if(update == 1){
            logger.debug("更新成功");
        }else{
            logger.debug("更新失败");
        }
    }
}

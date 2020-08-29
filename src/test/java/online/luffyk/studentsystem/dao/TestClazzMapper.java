package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Clazz;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestClazzMapper {
    private Logger logger = LoggerFactory.getLogger(TestClazzMapper.class);

    @Resource
    private ClazzMapper clazzMapper;

    @Test
    public void testShowAllClazz(){
//        Clazz clazz1 = new Clazz(null,"编",null,null);
        List<Clazz> clazzes = clazzMapper.showAllClazzDao(null);
        for(Clazz clazz:clazzes){
            logger.debug("clazz:"+clazz);
        }
    }

    @Test
    public void testshowAllClazz2Dao(){
        Clazz clazz1 = new Clazz(null, "编", null, null, null);
        List<Clazz> clazzes = clazzMapper.showAllClazz2Dao(clazz1);
        for(Clazz clazz:clazzes){
            logger.debug("clazz:"+clazz);
        }
    }

    @Test
    public void testInsert(){
        Clazz clazz = new Clazz(null, "计科二班", 17, "测试数据",null);
        int insert = clazzMapper.insert(clazz);
        if(insert == 1){
            logger.debug("添加班级信息成功");
        }else{
            logger.debug("添加班级信息失败");
        }
    }

    @Test
    public void testDeleteByPrimaryKey(){
        int delete = clazzMapper.deleteByPrimaryKey(23);
        if(delete == 1){
            logger.debug("删除成功");
        }else{
            logger.debug("删除失败");
        }
    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        Clazz clazz = clazzMapper.selectByPrimaryKey(26);
        logger.debug("clazz:"+clazz);
        clazz.setClazzName("电信一班");
        int update = clazzMapper.updateByPrimaryKey(clazz);
        if(update == 1){
            logger.debug("修改成功");
        }else{
            logger.debug("修改失败");
        }
    }
}

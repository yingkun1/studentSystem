package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Clazz;

import java.util.List;

public interface ClazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);

    /**
     *
     * @return 获取所有的班级信息
     */
    List<Clazz> showAllClazzDao(Clazz clazz);

    /**
     *
     * @return 返回所有的班级信息
     */
    List<Clazz> showAllClazz2Dao(Clazz clazz);
}
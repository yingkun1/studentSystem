package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Section;

import java.util.List;

public interface SectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);

    /**
     *
     * @return 获取所有的学期信息
     */
    List<Section> queryAllSectionDao(Section section);


}
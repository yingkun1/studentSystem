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

    /**
     *
     * @param section 学期信息的参数
     * @return 获取所有的学期信息并包含课程和教师的信息
     */
    List<Section> queryAllSectionDao2(Section section);

    /**
     *
     * @param stuId 根据学生id查询学期信息
     * @return 学生对应的学期信息
     */
    List<Section> queryByStudentDao(Integer stuId);


}
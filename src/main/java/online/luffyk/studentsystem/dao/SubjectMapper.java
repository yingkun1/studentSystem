package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Subject;

import java.util.List;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    /**
     *
     * @return 返回所有的专业列表
     */
    List<Subject> showAllSubjectDao(Subject subject);

    /**
     *
     * @return 获取所有的专业和专业下的课程名称
     */
    List<Subject> showAllSubjectAndClazzDao();
}
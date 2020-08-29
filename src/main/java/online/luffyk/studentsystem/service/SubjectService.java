package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> showAllSubjectService(Subject subjects);

    /**
     *
     * @param id 专业的id
     * @return 受影响的行数
     */
    Integer deleteByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 专业的信息
     * @return 受影响的行数
     */
    int insert(Subject record);

    /**
     *
     * @param id 主键
     * @return 返回专业的信息
     */
    Subject selectByPrimaryKey(Integer id);

    /**
     *
     * @param record 更新的数据
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelectiveService(Subject record);
}

package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Section;

import java.util.List;

public interface SectionService {
    /**
     *
     * @return 返回所有的学期信息
     */
    List<Section> queryAllSectionService(Section section);



    /**
     *
     * @param id 主键id
     * @return 收影响的行数
     */
    int deleteByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 学期信息
     * @return 受影响的行数
     */
    int insertSelectiveService(Section record);

    /**
     *
     * @param id 主键id
     * @return 对应的学期信息
     */
    Section selectByPrimaryKeyService(Integer id);

    /**
     *
     * @param record 学期信息
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelectiveService(Section record);

    /**
     *
     * @param stuId 学生的id
     * @return 对应的学期信息
     */
    List<Section> queryByStudentService(Integer stuId);
}

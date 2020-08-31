package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Section;

import java.util.List;

public interface SectionService {
    /**
     *
     * @return 返回所有的学期信息
     */
    List<Section> queryAllSectionService();

    /**
     *
     * @param id 主键id
     * @return 收影响的行数
     */
    int deleteByPrimaryKeyService(Integer id);
}

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
}

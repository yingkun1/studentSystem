package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> showAllClazzService(Clazz clazz);

    /**
     *
     * @param clazz 班级信息
     * @return 受影响的行数
     */
    Integer addClazzService(Clazz clazz);

    /**
     *
     * @param id 班级的id
     * @return 受影响的行数
     */
    Integer deleteClazzByPrimaryKey(Integer id);

    /**
     *
     * @param clazz 班级信息
     * @return 受影响的行数
     */
    Integer UpdateByPrimaryKeySelectiveService(Clazz clazz);

    /**
     *
     * @param id 班级的id
     * @return 班级信息
     */
    Clazz selectByPrimaryKeyService(Integer id);

    List<Clazz> showAllClazzBySubjectIdService(Integer subjectId);


}

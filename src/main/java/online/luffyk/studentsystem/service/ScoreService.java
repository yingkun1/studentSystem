package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Score;

import java.util.List;

public interface ScoreService {
    /**
     *
     * @param record 学生学期信息
     * @return 受影响的行数
     */
    int insertSelectiveService(Score record);

    /**
     *
     * @param stuId 学生id
     * @return 学生成绩的信息
     */
    List<Score> selectByStudentIdService(Integer stuId);

    /**
     *
     * @param record 分数的信息
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelectiveService(Score record);
}

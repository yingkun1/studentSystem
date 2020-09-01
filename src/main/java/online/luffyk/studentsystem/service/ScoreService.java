package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Score;

public interface ScoreService {
    /**
     *
     * @param record 学生学期信息
     * @return 受影响的行数
     */
    int insertSelectiveService(Score record);
}

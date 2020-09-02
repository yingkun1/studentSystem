package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Score;

import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    /**
     *
     * @param stuId 学生的id
     * @return 该学生所有的成绩
     */
    List<Score> selectByStudentIdDao(Integer stuId);


}
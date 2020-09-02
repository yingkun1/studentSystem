package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.ScoreMapper;
import online.luffyk.studentsystem.domain.Score;
import online.luffyk.studentsystem.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public int insertSelectiveService(Score record) {
        return scoreMapper.insertSelective(record);
    }

    @Override
    public List<Score> selectByStudentIdService(Integer stuId) {
        return scoreMapper.selectByStudentIdDao(stuId);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Score record) {
        return scoreMapper.updateByPrimaryKeySelective(record);
    }
}

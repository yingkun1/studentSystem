package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.ScoreMapper;
import online.luffyk.studentsystem.domain.Score;
import online.luffyk.studentsystem.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public int insertSelectiveService(Score record) {
        return scoreMapper.insertSelective(record);
    }
}

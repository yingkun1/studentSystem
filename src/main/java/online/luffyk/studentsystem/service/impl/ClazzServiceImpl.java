package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.ClazzMapper;
import online.luffyk.studentsystem.domain.Clazz;
import online.luffyk.studentsystem.service.ClazzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzMapper clazzMapper;
    @Override
    public List<Clazz> showAllClazzService(Clazz clazz) {
        return clazzMapper.showAllClazz2Dao(clazz);
    }

    @Transactional
    @Override
    public Integer addClazzService(Clazz clazz) {
        return clazzMapper.insert(clazz);
    }

    @Transactional
    @Override
    public Integer deleteClazzByPrimaryKey(Integer id) {
        return clazzMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public Integer UpdateByPrimaryKeySelectiveService(Clazz clazz) {
        return clazzMapper.updateByPrimaryKeySelective(clazz);
    }

    @Override
    public Clazz selectByPrimaryKeyService(Integer id) {
        return clazzMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Clazz> showAllClazzBySubjectIdService(Integer subjectId) {
        return clazzMapper.showAllClazzBySubjectIdDao(subjectId);
    }
}

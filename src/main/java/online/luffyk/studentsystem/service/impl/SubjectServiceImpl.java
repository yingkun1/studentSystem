package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.SubjectMapper;
import online.luffyk.studentsystem.domain.Subject;
import online.luffyk.studentsystem.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> showAllSubjectService(Subject subject) {
        return subjectMapper.showAllSubjectDao(subject);
    }

    @Transactional
    @Override
    public Integer deleteByPrimaryKeyService(Integer id) {
        return subjectMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insert(Subject record) {
        return subjectMapper.insert(record);
    }

    @Override
    public Subject selectByPrimaryKey(Integer id) {
        return subjectMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelectiveService(Subject record) {
        return subjectMapper.updateByPrimaryKeySelective(record);
    }
}

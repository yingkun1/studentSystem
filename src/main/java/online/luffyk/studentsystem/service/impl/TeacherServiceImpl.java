package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.TeacherMapper;
import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher loginVerifyService(String userName, String password) {
        return teacherMapper.loginVerifyDao(userName,password);
    }

    @Override
    public List<Teacher> queryAllTeacherService(Teacher teacher) {
        return teacherMapper.queryAllTeacherDao(teacher);
    }

    @Transactional
    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public Integer insertSelectiveService(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    @Override
    public Teacher selectByPrimaryKeyService(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelectiveService(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }
}

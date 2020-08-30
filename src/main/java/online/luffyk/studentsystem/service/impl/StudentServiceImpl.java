package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.StudentMapper;
import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public Student loginVerifyService(String userName, String password) {
        return studentMapper.loginVerifyDao(userName,password);
    }

    @Override
    public List<Student> queryAllStudentService(Student student) {
        return studentMapper.queryAllStudentDao(student);
    }

    @Transactional
    @Override
    public Integer deleteByPrimaryKeyService(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insertSelectiveService(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKeyService(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }


}

package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.StudentMapper;
import online.luffyk.studentsystem.domain.Student;
import online.luffyk.studentsystem.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public Student loginVerifyService(String userName, String password) {
        return studentMapper.loginVerifyDao(userName,password);
    }
}

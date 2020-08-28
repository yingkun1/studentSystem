package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.TeacherMapper;
import online.luffyk.studentsystem.domain.Teacher;
import online.luffyk.studentsystem.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher loginVerifyService(String userName, String password) {
        return teacherMapper.loginVerifyDao(userName,password);
    }
}

package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Teacher;

public interface TeacherService {
    Teacher loginVerifyService(String userName, String password);
}

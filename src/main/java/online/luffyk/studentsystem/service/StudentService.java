package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Student;

public interface StudentService {
    Student loginVerifyService(String userName, String password);
}

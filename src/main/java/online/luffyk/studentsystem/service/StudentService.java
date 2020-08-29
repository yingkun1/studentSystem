package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.Student;

import java.util.List;

public interface StudentService {
    Student loginVerifyService(String userName, String password);

    /**
     *
     * @return 获取所有的学生信息
     */
    List<Student> queryAllStudentService(Student student);
}

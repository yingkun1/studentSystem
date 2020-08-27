package online.luffyk.studentsystem.service;

import online.luffyk.studentsystem.domain.User;

public interface UserService {
    User selectByPrimaryKeyService(Integer id);
}

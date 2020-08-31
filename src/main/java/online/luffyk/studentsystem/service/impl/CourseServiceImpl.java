package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.CourseMapper;
import online.luffyk.studentsystem.domain.Course;
import online.luffyk.studentsystem.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> queryAllCourseService(Course course) {
        return courseMapper.queryAllCourseDao(course);
    }

    @Transactional
    @Override
    public int deleteByPrimaryKeyService(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insertSelectiveService(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKeyService(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record) {
        return courseMapper.updateByPrimaryKeySelective(record);
    }
}

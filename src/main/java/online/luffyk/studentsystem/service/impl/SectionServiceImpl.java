package online.luffyk.studentsystem.service.impl;

import online.luffyk.studentsystem.dao.SectionMapper;
import online.luffyk.studentsystem.domain.Section;
import online.luffyk.studentsystem.service.SectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    @Resource
    private SectionMapper sectionMapper;

    @Override
    public List<Section> queryAllSectionService(Section section) {
        return sectionMapper.queryAllSectionDao2(section);
    }



    @Override
    public int deleteByPrimaryKeyService(Integer id) {
        return sectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelectiveService(Section record) {
        return sectionMapper.insertSelective(record);
    }

    @Override
    public Section selectByPrimaryKeyService(Integer id) {
        return sectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Section record) {
        return sectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Section> queryByStudentService(Integer stuId) {
        return sectionMapper.queryByStudentDao(stuId);
    }


}

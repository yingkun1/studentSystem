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
    public List<Section> queryAllSectionService() {
        return sectionMapper.queryAllSectionDao();
    }

    @Override
    public int deleteByPrimaryKeyService(Integer id) {
        return sectionMapper.deleteByPrimaryKey(id);
    }
}

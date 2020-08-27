package online.luffyk.studentsystem.dao;

import online.luffyk.studentsystem.domain.Request;

public interface RequestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Request record);

    int insertSelective(Request record);

    Request selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Request record);

    int updateByPrimaryKeyWithBLOBs(Request record);

    int updateByPrimaryKey(Request record);
}
package com.pangu.dao;

import com.pangu.po.PanguUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PanguUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(PanguUser record);

    int insertSelective(PanguUser record);

    PanguUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(PanguUser record);

    int updateByPrimaryKey(PanguUser record);
}
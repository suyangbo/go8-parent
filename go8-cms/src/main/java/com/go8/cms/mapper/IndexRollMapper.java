package com.go8.cms.mapper;

import com.go8.cms.pojo.IndexRoll;

import java.util.List;

public interface IndexRollMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexRoll record);

    int insertSelective(IndexRoll record);

    IndexRoll selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexRoll record);

    int updateByPrimaryKey(IndexRoll record);

    List<IndexRoll> selectIndexRolls();
}
package com.go8.cms.service;

import com.go8.cms.mapper.IndexRollMapper;
import com.go8.cms.pojo.IndexRoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IndexRollServiceImpl implements IndexRollService{
    @Autowired
    private IndexRollMapper indexRollMapper;

    @Override
    public List<IndexRoll> getIndexRolls() {
        return indexRollMapper.selectIndexRolls();
    }

    @Override
    public void add(IndexRoll roll) {
        Date now = new Date();
        roll.setGmtCreate(now);
        roll.setGmtModified(now);
        indexRollMapper.insert(roll);
    }

    @Override
    public void update(IndexRoll roll) {
        indexRollMapper.updateByPrimaryKeySelective(roll);
    }

    @Override
    public void delete(Long id) {
        indexRollMapper.deleteByPrimaryKey(id);
    }
}

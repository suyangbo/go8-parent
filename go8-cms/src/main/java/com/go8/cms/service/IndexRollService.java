package com.go8.cms.service;

import com.go8.cms.pojo.IndexRoll;

import java.util.List;

public interface IndexRollService {

    List<IndexRoll> getIndexRolls();

    void add(IndexRoll roll);

    void update(IndexRoll roll);

    void delete(Long id);
}


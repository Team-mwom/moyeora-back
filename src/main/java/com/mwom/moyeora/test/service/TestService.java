package com.mwom.moyeora.test.service;

import com.mwom.moyeora.test.mappers.TestMapper;
import com.mwom.moyeora.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public List<TestVo> selectAllList(){
        return testMapper.selectAllList();
    }

}

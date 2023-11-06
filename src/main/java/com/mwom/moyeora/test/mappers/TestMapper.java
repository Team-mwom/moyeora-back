package com.mwom.moyeora.test.mappers;

import com.mwom.moyeora.test.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    List<TestVo> selectAllList();
}

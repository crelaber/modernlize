package com.uwen.ur.model.dal.sys;

import com.uwen.ur.model.pojo.sys.UrFaqFile;
import com.uwen.ur.model.pojo.sys.UrFaqFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrFaqFileMapper {
    int countByExample(UrFaqFileExample example);

    int deleteByExample(UrFaqFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(UrFaqFile record);

    int insertSelective(UrFaqFile record);

    List<UrFaqFile> selectByExample(UrFaqFileExample example);

    UrFaqFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UrFaqFile record, @Param("example") UrFaqFileExample example);

    int updateByExample(@Param("record") UrFaqFile record, @Param("example") UrFaqFileExample example);

    int updateByPrimaryKeySelective(UrFaqFile record);

    int updateByPrimaryKey(UrFaqFile record);

    List<UrFaqFile> selectTreegirdByExample(UrFaqFileExample example);
}
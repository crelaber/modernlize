package com.uwen.ur.model.dal.sys;

import com.uwen.ur.model.pojo.sys.UrFaqInterest;
import com.uwen.ur.model.pojo.sys.UrFaqInterestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrFaqInterestMapper {
    int countByExample(UrFaqInterestExample example);

    int deleteByExample(UrFaqInterestExample example);

    int deleteByPrimaryKey(String id);

    int insert(UrFaqInterest record);

    int insertSelective(UrFaqInterest record);

    List<UrFaqInterest> selectByExample(UrFaqInterestExample example);

    UrFaqInterest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UrFaqInterest record, @Param("example") UrFaqInterestExample example);

    int updateByExample(@Param("record") UrFaqInterest record, @Param("example") UrFaqInterestExample example);

    int updateByPrimaryKeySelective(UrFaqInterest record);

    int updateByPrimaryKey(UrFaqInterest record);

    List<UrFaqInterest> selectTreegirdByExample(UrFaqInterestExample example);
}
package com.uwen.ur.model.dal.sys;

import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.pojo.sys.UrFaqTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrFaqTypeMapper {
    int countByExample(UrFaqTypeExample example);

    int deleteByExample(UrFaqTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(UrFaqType record);

    int insertSelective(UrFaqType record);

    List<UrFaqType> selectByExample(UrFaqTypeExample example);

    UrFaqType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UrFaqType record, @Param("example") UrFaqTypeExample example);

    int updateByExample(@Param("record") UrFaqType record, @Param("example") UrFaqTypeExample example);

    int updateByPrimaryKeySelective(UrFaqType record);

    int updateByPrimaryKey(UrFaqType record);

    List<UrFaqType> selectTreegirdByExample(UrFaqTypeExample example);
}
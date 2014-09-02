package com.uwen.ur.model.dal.sys;

import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.model.pojo.sys.UrFaqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrFaqMapper {
    int countByExample(UrFaqExample example);

    int deleteByExample(UrFaqExample example);

    int deleteByPrimaryKey(String id);

    int insert(UrFaq record);

    int insertSelective(UrFaq record);

    List<UrFaq> selectByExample(UrFaqExample example);

    UrFaq selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UrFaq record, @Param("example") UrFaqExample example);

    int updateByExample(@Param("record") UrFaq record, @Param("example") UrFaqExample example);

    int updateByPrimaryKeySelective(UrFaq record);

    int updateByPrimaryKey(UrFaq record);

    List<UrFaq> selectTreegirdByExample(UrFaqExample example);
}
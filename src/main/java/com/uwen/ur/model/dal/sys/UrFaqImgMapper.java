package com.uwen.ur.model.dal.sys;

import com.uwen.ur.model.pojo.sys.UrFaqImg;
import com.uwen.ur.model.pojo.sys.UrFaqImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrFaqImgMapper {
    int countByExample(UrFaqImgExample example);

    int deleteByExample(UrFaqImgExample example);

    int deleteByPrimaryKey(String id);

    int insert(UrFaqImg record);

    int insertSelective(UrFaqImg record);

    List<UrFaqImg> selectByExample(UrFaqImgExample example);

    UrFaqImg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UrFaqImg record, @Param("example") UrFaqImgExample example);

    int updateByExample(@Param("record") UrFaqImg record, @Param("example") UrFaqImgExample example);

    int updateByPrimaryKeySelective(UrFaqImg record);

    int updateByPrimaryKey(UrFaqImg record);

    List<UrFaqImg> selectTreegirdByExample(UrFaqImgExample example);
}
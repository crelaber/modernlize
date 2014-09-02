package com.uwen.ur.model.dal.sys;

import com.uwen.ur.model.pojo.sys.UrFaqImgRel;
import com.uwen.ur.model.pojo.sys.UrFaqImgRelExample;
import com.uwen.ur.model.pojo.sys.UrFaqImgRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrFaqImgRelMapper {
    int countByExample(UrFaqImgRelExample example);

    int deleteByExample(UrFaqImgRelExample example);

    int deleteByPrimaryKey(UrFaqImgRelKey key);

    int insert(UrFaqImgRel record);

    int insertSelective(UrFaqImgRel record);

    List<UrFaqImgRel> selectByExample(UrFaqImgRelExample example);

    UrFaqImgRel selectByPrimaryKey(UrFaqImgRelKey key);

    int updateByExampleSelective(@Param("record") UrFaqImgRel record, @Param("example") UrFaqImgRelExample example);

    int updateByExample(@Param("record") UrFaqImgRel record, @Param("example") UrFaqImgRelExample example);

    int updateByPrimaryKeySelective(UrFaqImgRel record);

    int updateByPrimaryKey(UrFaqImgRel record);

    List<UrFaqImgRel> selectTreegirdByExample(UrFaqImgRelExample example);
}
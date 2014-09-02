package com.uwen.ur.model.dal.sys;

import com.uwen.ur.model.pojo.sys.UrFaqFileRel;
import com.uwen.ur.model.pojo.sys.UrFaqFileRelExample;
import com.uwen.ur.model.pojo.sys.UrFaqFileRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrFaqFileRelMapper {
    int countByExample(UrFaqFileRelExample example);

    int deleteByExample(UrFaqFileRelExample example);

    int deleteByPrimaryKey(UrFaqFileRelKey key);

    int insert(UrFaqFileRel record);

    int insertSelective(UrFaqFileRel record);

    List<UrFaqFileRel> selectByExample(UrFaqFileRelExample example);

    UrFaqFileRel selectByPrimaryKey(UrFaqFileRelKey key);

    int updateByExampleSelective(@Param("record") UrFaqFileRel record, @Param("example") UrFaqFileRelExample example);

    int updateByExample(@Param("record") UrFaqFileRel record, @Param("example") UrFaqFileRelExample example);

    int updateByPrimaryKeySelective(UrFaqFileRel record);

    int updateByPrimaryKey(UrFaqFileRel record);

    List<UrFaqFileRel> selectTreegirdByExample(UrFaqFileRelExample example);
}
package com.uwen.ur.model.dal.sys.ext;

import java.util.List;

import com.uwen.ur.model.pojo.sys.UrFaqExample;
import com.uwen.ur.model.pojo.sys.ext.UrFaqExt;

public interface UrFaqExtMapper {
	
	int countByExample(UrFaqExample example);
	
	List<UrFaqExt> selectByExample(UrFaqExample example);
}

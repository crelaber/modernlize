package com.uwen.ur.model.dal.sys.ext;

import java.util.List;


import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExt;

public interface UrFaqTypeExtMapper {

	List<UrFaqTypeExt> selectAll();
	
	int batchLogicDeleteByPrimaryKey(UrFaqType u);
	
	int insertSelective(UrFaqTypeExt record);
   
	int insertBatch(List<UrFaqType> list);
	
	int updateByPrimaryKeySelective(UrFaqTypeExt u);
	
	
}

package com.uwen.ur.model.service.sys.ext;

import java.util.List;

import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExt;

import net.sf.json.JSONArray;

public interface UrFaqTypeExtService {

	JSONArray getAllTreeNodelist(String requestType) throws Exception;
	
	List<UrFaqTypeExt> getAllFaqType() throws Exception;
	
	void batchLogicDeleteByPrimaryKey(UrFaqType u) throws Exception;
	
	void insertBatch(List<UrFaqTypeExt> list);
	
	void updateBatch(List<UrFaqTypeExt> list);
	
}

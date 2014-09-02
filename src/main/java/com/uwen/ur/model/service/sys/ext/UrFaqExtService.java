package com.uwen.ur.model.service.sys.ext;

import java.util.List;

import net.sf.json.JSONArray;

import com.uwen.ur.model.interfaze.sys.MapperCallBack;
import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.model.pojo.sys.ext.UrFaqExt;
import com.uwen.ur.util.Page;
import com.uwen.ur.util.sys.FieldAppendArray;

public interface UrFaqExtService {
	
	  /**
     * 根据模型查找信息
     * 
     * @param 模型
     * @return 对象
     * @throws Exception
     */
    public List<UrFaqExt> listUrFaq(UrFaq record, String orderByClause, Page page, MapperCallBack callback) throws Exception;


	/**
     * 查询,字段并关联外键值
     * 
     * @param record
     * @param orderByClause
     * @param page
     * @param callback
     * @param appendArray
     * @return
     * @throws Exception
     */
    JSONArray listUrFaqAndFkText(UrFaq record, String orderByClause, Page page, MapperCallBack callback, FieldAppendArray appendArray) throws Exception;
    
    
}

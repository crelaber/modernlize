package com.uwen.ur.model.service.sys;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.uwen.ur.model.interfaze.sys.MapperCallBack;
import com.uwen.ur.model.pojo.sys.UrFaqInterest;
import com.uwen.ur.util.Page;
import com.uwen.ur.util.sys.FieldAppendArray;

public interface UrFaqInterestService {

    /**
     * 单个数据查询
     * 
     * @param record
     * @param callback
     * @return
     */
    UrFaqInterest findUrFaqInterest(UrFaqInterest record, MapperCallBack callback) throws Exception;
    
    /**
     * 单个数据查询,字段并关联外键值
     * 
     * @param record
     * @param callback
     * @return
     */
    JSONObject findUrFaqInterestAndFkText(UrFaqInterest record, MapperCallBack callback, FieldAppendArray appendArray) throws Exception;
    
    /**
     * 根据模型查找信息
     * 
     * @param 模型
     * @return 对象
     * @throws Exception
     */
    public List<UrFaqInterest> listUrFaqInterest(UrFaqInterest record, String orderByClause, Page page, MapperCallBack callback) throws Exception;

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
    JSONArray listUrFaqInterestAndFkText(UrFaqInterest record, String orderByClause, Page page, MapperCallBack callback, FieldAppendArray appendArray) throws Exception;
	
	
    /**
     * 新增数据
     * 
     * @param record
     * @throws Exception
     */
    void insertUrFaqInterest(UrFaqInterest record) throws Exception;

    /**
     * 物理删除数据
     * 
     * @param record
     * @param callback
     * @throws Exception
     */
    void dropUrFaqInterest(UrFaqInterest record, MapperCallBack callback) throws Exception;

    /**
     * 更新数据
     * 
     * @param record
     * @throws Exception
     */
    void modifyUrFaqInterest(UrFaqInterest record, MapperCallBack callback) throws Exception;
    
    /**
     * 根据主键来更新 只更新有值的属性
     * @param record
     * @throws Exception
     */
    void modifyUrFaqInterestByPkSelective(UrFaqInterest record) throws Exception;
    
    /**
     * 根据主键来更新 更新所有值
     * @param record
     * @throws Exception
     */
    void modifyUrFaqInterestByPk(UrFaqInterest record) throws Exception;
    
    /**
     * 总条数
     * 
     * @param record
     * @param callback
     * @throws Exception
     */
    int countUrFaqInterest(UrFaqInterest record, MapperCallBack callback) throws Exception;

    


}

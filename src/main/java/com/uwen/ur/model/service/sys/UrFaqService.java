package com.uwen.ur.model.service.sys;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.uwen.ur.model.interfaze.sys.MapperCallBack;
import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.util.Page;
import com.uwen.ur.util.sys.FieldAppendArray;

public interface UrFaqService {

    /**
     * 单个数据查询
     * 
     * @param record
     * @param callback
     * @return
     */
    UrFaq findUrFaq(UrFaq record, MapperCallBack callback) throws Exception;
    
    /**
     * 单个数据查询,字段并关联外键值
     * 
     * @param record
     * @param callback
     * @return
     */
    JSONObject findUrFaqAndFkText(UrFaq record, MapperCallBack callback, FieldAppendArray appendArray) throws Exception;
    
    /**
     * 根据模型查找信息
     * 
     * @param 模型
     * @return 对象
     * @throws Exception
     */
    public List<UrFaq> listUrFaq(UrFaq record, String orderByClause, Page page, MapperCallBack callback) throws Exception;

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
	
	
    /**
     * 新增数据
     * 
     * @param record
     * @throws Exception
     */
    void insertUrFaq(UrFaq record) throws Exception;

    /**
     * 物理删除数据
     * 
     * @param record
     * @param callback
     * @throws Exception
     */
    void dropUrFaq(UrFaq record, MapperCallBack callback) throws Exception;

    /**
     * 更新数据
     * 
     * @param record
     * @throws Exception
     */
    void modifyUrFaq(UrFaq record, MapperCallBack callback) throws Exception;
    
    /**
     * 根据主键来更新 只更新有值的属性
     * @param record
     * @throws Exception
     */
    void modifyUrFaqByPkSelective(UrFaq record) throws Exception;
    
    /**
     * 根据主键来更新 更新所有值
     * @param record
     * @throws Exception
     */
    void modifyUrFaqByPk(UrFaq record) throws Exception;
    
    /**
     * 总条数
     * 
     * @param record
     * @param callback
     * @throws Exception
     */
    int countUrFaq(UrFaq record, MapperCallBack callback) throws Exception;

    


}

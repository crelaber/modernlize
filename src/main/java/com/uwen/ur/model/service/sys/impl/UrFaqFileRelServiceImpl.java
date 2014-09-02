package com.uwen.ur.model.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.uwen.ur.common.CommonConstants;
import com.uwen.ur.model.dal.sys.UrFaqFileRelMapper;
import com.uwen.ur.model.interfaze.sys.FieldAppendAbstract;
import com.uwen.ur.model.interfaze.sys.MapperCallBack;
import com.uwen.ur.model.interfaze.sys.impl.MapperCallBackAdapter;
import com.uwen.ur.model.pojo.sys.UrFaqFileRel;
import com.uwen.ur.model.pojo.sys.UrFaqFileRelExample;
import com.uwen.ur.model.pojo.sys.UrFaqFileRelExample.Criteria;
import com.uwen.ur.model.service.sys.UrFaqFileRelService;
import com.uwen.ur.util.JUtil;
import com.uwen.ur.util.MapperUtil;
import com.uwen.ur.util.Page;
import com.uwen.ur.util.sys.FieldAppendArray;

@Service
@Scope("prototype")
public class UrFaqFileRelServiceImpl implements UrFaqFileRelService {
    @Autowired
    private UrFaqFileRelMapper mapper;

    /**
     * 单个数据查询
     * 
     * @param record
     * @param callback
     * @return
     */
    
    public UrFaqFileRel findUrFaqFileRel(UrFaqFileRel record, MapperCallBack callback) throws Exception {
        List<UrFaqFileRel> records = listUrFaqFileRel(record, null, new Page(0, 1), callback);
        if (null != records && records.size() > 0) {
            return records.get(0);
        }
        return null;
    }

    /**
     * 单个数据查询,字段并关联外键值
     * 
     * @param record
     * @param callback
     * @return
     */
    
    public JSONObject findUrFaqFileRelAndFkText(UrFaqFileRel record, MapperCallBack callback, FieldAppendArray appendArray) throws Exception {
        UrFaqFileRel rec = findUrFaqFileRel(record, callback);
        JSONObject jsonobj = null;
        if (null != rec) {
            //
            jsonobj = JSONObject.fromObject(rec,CommonConstants.JSON_CFG);
            // 遍历
            for (FieldAppendAbstract fieldAppend : appendArray) {
                // 属性名称
                String fieldName = fieldAppend.getFieldName();
                // 列表值
                Object listVal = fieldAppend.listValues(MapperUtil.getFiledVals(rec, fieldName));
                // 外键值
                Object oldVal = jsonobj.get(fieldName);
                // 最终返回值
                Object finalVal = fieldAppend.getValue(listVal, oldVal);
                //
                jsonobj.put(fieldAppend.getFieldName() + fieldAppend.getFieldSuffix(), finalVal);
            }
        }
        return jsonobj;
    }

    /**
     * 根据模型查找信息
     * 
     * @param 模型
     * @page 页面(不分页,则传null)
     * @orderByClause 排序(不需,则传null)
     * @return 对象
     * @throws Exception
     */
    
    public List<UrFaqFileRel> listUrFaqFileRel(UrFaqFileRel record, String orderByClause, Page page, MapperCallBack callback) throws Exception {
        if(null == callback) callback = new MapperCallBackAdapter();
        //
        callback.doRecord(record);
        //
        UrFaqFileRelExample example = new UrFaqFileRelExample();
        // 去掉重复结果集
        example.setDistinct(true);
        // 分页
        if (null != page) {
            example.setPage(page);
        }
        // 排序
        if (!JUtil.isNull(orderByClause)) {
            example.setOrderByClause(orderByClause);
        }
        // 设置查询条件
        Criteria criteria = example.createCriteria();
        //
        callback.doExample(example);
        // 构建查询条件
        MapperUtil.builderCriteria(criteria, record);
        //
        callback.doCriteria(criteria);
        if (null != page) {
            // 总条数
            int count = mapper.countByExample(example);
            page.setCount(count);
        }
        // 返回查询记录
        return mapper.selectByExample(example);
    }

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
    
    public JSONArray listUrFaqFileRelAndFkText(UrFaqFileRel record, String orderByClause, Page page, MapperCallBack callback, FieldAppendArray appendArray) throws Exception {
        // 属性,对应表,对应表字段
        List<UrFaqFileRel> records = listUrFaqFileRel(record, orderByClause, page, callback);
        //
        JSONArray array = JSONArray.fromObject(records,CommonConstants.JSON_CFG);
        //
        int size = array.size();
        //
        for (FieldAppendAbstract fieldAppend : appendArray) {
            List<String> oldFieldVals = MapperUtil.getFiledVals(records, fieldAppend.getFieldName());
            Object listVal = fieldAppend.listValues(oldFieldVals);
            for (int i = 0; i < size; i++) {
                //
                JSONObject jsonobj = array.getJSONObject(i);
                //
                Object oldVal = jsonobj.get(fieldAppend.getFieldName());
                //
                Object finalVal = fieldAppend.getValue(listVal, oldVal);
                //
                jsonobj.put(fieldAppend.getFieldName() + fieldAppend.getFieldSuffix(), finalVal);
            }
        }
        return array;
    }
    
	
    /**
     * 新增数据
     * 
     * @param record
     * @throws Exception
     */
    
    public void insertUrFaqFileRel(UrFaqFileRel record) throws Exception {
        // 执行操作
        int res = mapper.insertSelective(record);
        // 抛出异常
        if (res <= 0)
            throw new RuntimeException("UrFaqFileRel表新增数据失败");
    }

    /**
     * 物理删除数据
     * 
     * @param record
     * @param callback
     * @throws Exception
     */
    
    public void dropUrFaqFileRel(UrFaqFileRel record, MapperCallBack callback) throws Exception {
        //
        callback.doRecord(record);
        //
        UrFaqFileRelExample example = new UrFaqFileRelExample();
        // 设置查询条件
        Criteria criteria = example.createCriteria();
        //
        callback.doExample(example);
        // 构建查询条件
        MapperUtil.builderCriteria(criteria, record);
        //
        callback.doCriteria(criteria);
        // 执行操作
        int res = mapper.deleteByExample(example);
        // 抛出异常
        if (res <= 0)
            throw new RuntimeException("UrFaqFileRel表删除数据失败");
    }
    
    /**
     * 更新数据
     * 
     * @param record
     * @throws Exception
     */
    
    public void modifyUrFaqFileRel(UrFaqFileRel record, MapperCallBack callback) throws Exception {
        //
        callback.doRecord(record);
        //
        UrFaqFileRelExample example = new UrFaqFileRelExample();
        // 设置查询条件
        Criteria criteria = example.createCriteria();
        //
        callback.doExample(example);
        //
        callback.doCriteria(criteria);
        //
        if (!criteria.isValid()) {
            throw new RuntimeException("更新必须要设置条件!");
        }
        // 执行操作
        int res = mapper.updateByExampleSelective(record, example);
        // 抛出异常
        if (res <= 0) {
            throw new RuntimeException("UrFaqFileRel表更新数据失败");
        }

    }
    
    /**
     * 更新数据
     * 
     * @param record
     * @throws Exception
     */
    
    public void modifyUrFaqFileRelByPkSelective(UrFaqFileRel record) throws Exception {
        // 执行操作
        int res = mapper.updateByPrimaryKeySelective(record);
        // 抛出异常
        if (res <= 0) {
            throw new RuntimeException("UrFaqFileRel表更新数据失败");
        }
    }
    
    /**
     * 更新数据
     * 
     * @param record
     * @throws Exception
     */
    
    public void modifyUrFaqFileRelByPk(UrFaqFileRel record) throws Exception {
        // 执行操作
        int res = mapper.updateByPrimaryKey(record);
        // 抛出异常
        if (res <= 0) {
            throw new RuntimeException("UrFaqFileRel表更新数据失败");
        }
    }
    
    /**
     * 总条数
     * 
     * @param record
     * @throws Exception
     */
    
    public int countUrFaqFileRel(UrFaqFileRel record, MapperCallBack callback) throws Exception {
        //
        callback.doRecord(record);
        //
        UrFaqFileRelExample example = new UrFaqFileRelExample();
        // 设置查询条件
        Criteria criteria = example.createCriteria();
        //
        callback.doExample(example);
        //
        callback.doCriteria(criteria);
        // 执行操作
        int res = mapper.countByExample(example);
        return res;
    }
}

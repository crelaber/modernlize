package com.uwen.ur.model.service.sys.ext.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.uwen.ur.common.CommonConstants;
import com.uwen.ur.model.dal.sys.ext.UrFaqExtMapper;
import com.uwen.ur.model.interfaze.sys.FieldAppendAbstract;
import com.uwen.ur.model.interfaze.sys.MapperCallBack;
import com.uwen.ur.model.interfaze.sys.impl.MapperCallBackAdapter;
import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.model.pojo.sys.UrFaqExample;
import com.uwen.ur.model.pojo.sys.UrFaqExample.Criteria;
import com.uwen.ur.model.pojo.sys.ext.UrFaqExt;
import com.uwen.ur.model.service.sys.ext.UrFaqExtService;
import com.uwen.ur.util.JUtil;
import com.uwen.ur.util.MapperUtil;
import com.uwen.ur.util.Page;
import com.uwen.ur.util.sys.FieldAppendArray;
@Service
public class UrFaqExtServiceImpl implements UrFaqExtService {
    @Autowired
    private UrFaqExtMapper mapper;
	public List<UrFaqExt> listUrFaq(UrFaq record, String orderByClause,
			Page page, MapperCallBack callback) throws Exception {
    	  if(null == callback) callback = new MapperCallBackAdapter();
          //
          callback.doRecord(record);
          //
          UrFaqExample example = new UrFaqExample();
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

	public JSONArray listUrFaqAndFkText(UrFaq record, String orderByClause,
			Page page, MapperCallBack callback, FieldAppendArray appendArray)
			throws Exception {
		  // 属性,对应表,对应表字段
        List<UrFaqExt> records = listUrFaq(record, orderByClause, page, callback);
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

}

package com.uwen.ur.action.sys;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.uwen.ur.model.interfaze.sys.impl.MapperCallBackAdapter;
import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.model.pojo.sys.UrFaqExample.Criteria;
import com.uwen.ur.model.service.sys.UrFaqService;
import com.uwen.ur.util.sys.FieldAppendArray;
import com.uwen.ur.util.JUtil;
import com.uwen.ur.util.MapperUtil;
import com.uwen.ur.util.Page;

import com.uwen.ur.action.sys.BaseAction;
import com.uwen.ur.common.BasicJSON;
import com.uwen.ur.common.NormalDatagrid;

//导入自动注入类型

@Controller
@Scope("prototype")
public class UrFaqAction extends BaseAction{
    /**
     * 
     */
    private Logger log = LoggerFactory.getLogger(UrFaqAction.class);
    /**
     * 服务
     */
    @Autowired
    protected UrFaqService service;
    
    /**
     * 导入自动注入类型
     */
    /**
     * pojo
     */
    protected UrFaq record;

    protected int dbFlag = 0;// 0 全部 1 选择性的(判断 isNull)
    protected int comp = 0;// 返回组件类型 0:datagrid 1: combobox/没有分页信息的集合
	
	protected String sort = "sort"; // 排序
	
	protected String prefix = "record."; //前缀
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String addOrUpdate() {
        try {
     		if (JUtil.isNULL(record.getId())) {
                if (1 == dbFlag) {
                    // TODO
                } else {
                    //选择性的(判断 isNull)
			        record.setId(JUtil.uuid());
			        record.setAddDatetime(new Date());
			        record.setUpdateDatetime(record.getAddDatetime());
                    service.insertUrFaq(record);
                }
            } else {
		        record.setUpdateDatetime(new Date());
                if (1 == dbFlag) {
                    // 0 全部
                    service.modifyUrFaqByPk(record);
                } else {
                    //选择性的(判断 isNull)
                    service.modifyUrFaqByPkSelective(record);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        set$data(new BasicJSON(200,"success",null));
        return success();
    }
    
    public String findByPk() {
        try {
            FieldAppendArray appendArray = new FieldAppendArray();
            UrFaq rec = new UrFaq();
            rec.setId(record.getId());
            JSONObject obj = service.findUrFaqAndFkText(rec, new MapperCallBackAdapter(), appendArray);
            set$data(obj, prefix);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        return success();
    }
    
    public String find() {
        try {
            FieldAppendArray appendArray = new FieldAppendArray();
            JSONObject obj = service.findUrFaqAndFkText(record, null, appendArray);
            set$data(obj, prefix);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        return success();
    }
    
    //主键集合
    protected String pks;
    //当前页面
    protected int page = 1;
    //每页显示多少条
    protected int rows = 100;
    
    public String listByPk() {
        try {
            FieldAppendArray appendArray = new FieldAppendArray();
            UrFaq rec = new UrFaq();
            Page paging = Page.getInstance(page - 1, rows);
            JSONArray array = service.listUrFaqAndFkText(rec, sort, paging, new MapperCallBackAdapter(){
                
                public void doCriteria(Object obj) {
                    //
                    Criteria cri = (Criteria)obj;
                    //如
                    cri.andIdIn(JUtil.splitToListString(pks));
                }
            }, appendArray);
            //返回数据
            if(comp == 1){
            	set$data(array);
            }else{
            	set$data(new NormalDatagrid(paging.getCount(), array));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        return success();
    }
    
    //代理bean
    protected Map<String,String> beanProxy;
    
    /**
     * 根据代理bean查询集合
     * @return
     */
    public String list() {
        try {
            FieldAppendArray appendArray = new FieldAppendArray();
            UrFaq rec = new UrFaq();
            Page paging = Page.getInstance(page - 1, rows);
            JSONArray array = service.listUrFaqAndFkText(rec, sort, paging, new MapperCallBackAdapter(){
                
                public void doCriteria(Object obj) throws Exception{
                    MapperUtil.builderCriteria(obj, UrFaq.class, beanProxy);
                }
            }, appendArray);
            //返回数据
            if(comp == 1){
            	set$data(array);
            }else{
            	set$data(new NormalDatagrid(paging.getCount(), array));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        return success();
    }
    
    /**
     * 逻辑删除
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String delete(){
        try {
            //pageData = new HashMap();
            UrFaq delRecord = new UrFaq();
            delRecord.setId(record.getId());
            delRecord.setEnable(0);
            service.modifyUrFaqByPkSelective(delRecord);
            //pageData.put("state", "success");
            //pageData.put("msg", "操作成功!");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        set$data(new BasicJSON(200,"success",null));
        return success();
    }
    
    /**
     * 物理删除
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String drop(){
        try {
            //pageData = new HashMap();
            UrFaq delRecord = new UrFaq();
            delRecord.setId(record.getId());
            service.dropUrFaq(delRecord, new MapperCallBackAdapter());
            //pageData.put("state", "success");
            //pageData.put("msg", "操作成功!");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        set$data(new BasicJSON(200,"success",null));
        return success();
    }
    
    
    public int getDbFlag() {
        return dbFlag;
    }

    public void setDbFlag(int dbFlag) {
        this.dbFlag = dbFlag;
    }
    
    public String getPks() {
        return pks;
    }

    public void setPks(String pks) {
        this.pks = pks;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    
    public Map<String, String> getBeanProxy() {
        return beanProxy;
    }

    public void setBeanProxy(Map<String, String> beanProxy) {
        this.beanProxy = beanProxy;
    }

    public UrFaq getRecord() {
        return record;
    }

    public void setRecord(UrFaq record) {
        this.record = record;
    }
    
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}

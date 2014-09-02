package com.uwen.ur.action.sys.ext;

import java.util.Date;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.uwen.ur.action.sys.UrFaqAction;
import com.uwen.ur.common.BasicJSON;
import com.uwen.ur.common.NormalDatagrid;
import com.uwen.ur.model.interfaze.sys.impl.MapperCallBackAdapter;
import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.model.pojo.sys.ext.UrFaqExt;
import com.uwen.ur.model.service.sys.ext.UrFaqExtService;
import com.uwen.ur.util.JUtil;
import com.uwen.ur.util.MapperUtil;
import com.uwen.ur.util.Page;
import com.uwen.ur.util.sys.FieldAppendArray;

@Controller
@Scope("prototype")
public class UrFaqExtAction extends UrFaqAction {
	
	private Logger log = LoggerFactory.getLogger(UrFaqExtAction.class);
	
	@Autowired
	private UrFaqExtService UrFaqExtService;
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	    public String addOrUpdate() {
	        try {
	     		if (JUtil.isNULL(record.getId())) {
	                if (1 == dbFlag) {
	                    // TODO
	                } else {
	                    //选择性的(判断 isNull)
				        record.setId(JUtil.uuid12());
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
	
	 /**
     * 根据代理bean查询集合
     * @return
     */
    public String list() {
        try {
            FieldAppendArray appendArray = new FieldAppendArray();
            UrFaq rec = new UrFaq();
            Page paging = Page.getInstance(page - 1, rows);
            JSONArray array = UrFaqExtService.listUrFaqAndFkText(rec, sort, paging, new MapperCallBackAdapter(){
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
  
	
}

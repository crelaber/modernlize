package com.uwen.ur.action.sys.ext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.uwen.ur.action.sys.UrFaqTypeAction;
import com.uwen.ur.common.BasicJSON;
import com.uwen.ur.model.interfaze.sys.impl.MapperCallBackAdapter;
import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExt;
import com.uwen.ur.model.service.sys.ext.UrFaqTypeExtService;
import com.uwen.ur.util.JUtil;
import com.uwen.ur.util.MapperUtil;

//导入自动注入类型

@Controller
@Scope("prototype")
public class UrFaqTypeExtAction extends UrFaqTypeAction{
    /**
     * 
     */
    private Logger log = LoggerFactory.getLogger(UrFaqTypeExtAction.class);
    
    private String requestType;
    
    private String modifyDataArr;
    
    private String addDataArr;
    
    private String delDataArr;
    
	public void setModifyDataArr(String modifyDataArr) {
		this.modifyDataArr = modifyDataArr;
	}

	public void setAddDataArr(String addDataArr) {
		this.addDataArr = addDataArr;
	}

	public void setDelDataArr(String delDataArr) {
		this.delDataArr = delDataArr;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String addOrUpdate() {
    	record.setFaqTypeName("车型类");
    	return super.addOrUpdate();
    }
    @Autowired
    protected UrFaqTypeExtService urFaqTypeExtService;
    /**
     * 根据代理bean查询集合
     * @return
     */
    public String getAllTreeNodelist() {
        try {
            JSONArray array =urFaqTypeExtService.getAllTreeNodelist(requestType);
            set$data(array);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        return success();
    }
    
    /**
     * 批量进行添加修改删除
     */
    public String batchDealAll() {
        try {
        	System.out.println("addDataArr="+addDataArr);
        	System.out.println("modifyDataArr="+modifyDataArr);
        	System.out.println("delDataArr="+delDataArr);
            batchAdd();//批量新增
            batchModify();//批量修改
            batchDrop();//批量删除
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
            return exception();
        }
        set$data(new BasicJSON(200,"success",null));
        return success();
    }
    
    private UrFaqTypeExt JsonToJavaBean(JSONObject obj){//json转成对象
    	UrFaqTypeExt t = new UrFaqTypeExt();
    	t.setId(obj.getString("id"));
    	t.setFaqTypeDesc("");
    	t.setCreateUserId("00001");
    	t.setCreateUserName("yanghao");
    	t.setParentId(obj.getString("parentId"));
    	t.setFaqTypeName(obj.getString("text"));
    	return t;
    }
    
    private void  batchAdd(){//批量新增
    	try{
    	JSONArray aArr=null;
    	if(null!=addDataArr)
        aArr = JSONArray.fromObject(addDataArr);
    	List<UrFaqTypeExt> list = new ArrayList<UrFaqTypeExt>();
    	if(null!=aArr && 0!=aArr.size()){//进行处理
    		int i;
    		for(i=0;i<aArr.size();i++){
    			JSONObject o = aArr.getJSONObject(i);
    			UrFaqTypeExt t = JsonToJavaBean(o);
    			t.setAddDatetime(new Date());
    			t.setEnable(1);
    			t.setFaqTypeCode("-1");
    			list.add(t);
    		}
    	}
    	if(null!=list && 0!=list.size()){
               this.urFaqTypeExtService.insertBatch(list);
    	     }
    	}catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
        }
    }
    
    private void  batchModify(){//批量修改
		try{
		JSONArray mArr=null;
		if(null!=modifyDataArr)
		mArr = JSONArray.fromObject(modifyDataArr);
		List<UrFaqTypeExt> list = new ArrayList<UrFaqTypeExt>();
    	if(null!=mArr && 0!=mArr.size()){//进行处理
    		int i;
    		for(i=0;i<mArr.size();i++){
    			JSONObject o = mArr.getJSONObject(i);
    			UrFaqTypeExt t = JsonToJavaBean(o);
    			t.setUpdateDatetime(new Date());
    			t.setUpdateUserId("000001");
    			t.setUpdateUserName("yanghao");
    			list.add(t);
    		}
    	}
    	if(null!=list && 0!=list.size()){
    		   this.urFaqTypeExtService.updateBatch(list);
    	}
    	}catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
        }
    }
    
    private void  batchDrop(){//批量删除
    	try{
    	JSONArray dArr=null;
    	if(null!=delDataArr)
    	dArr = JSONArray.fromObject(delDataArr);
    	List<UrFaqTypeExt> delList  = new ArrayList<UrFaqTypeExt>();
    	List<UrFaqTypeExt> allList = this.urFaqTypeExtService.getAllFaqType();
    	if(null!=dArr && 0!=dArr.size()){//进行处理
    		int i;
    		for(i=0;i<dArr.size();i++){
    			JSONObject o = dArr.getJSONObject(i);
    			delList = getWillBeDeleteFaqTypeByPid(o.getString("id"),delList,allList);
    		}
    	}
    	if(null!=delList && 0!=delList.size()){//进行批量操作
    		this.urFaqTypeExtService.updateBatch(delList);
    	}
    	}catch (Exception e) {
            log.error(e.getMessage(), e);
            set$data(new BasicJSON(0,"fail",null));
        }
    }
    
    private UrFaqTypeExt setDealAttribute(UrFaqTypeExt u){
    	UrFaqTypeExt tmp = new UrFaqTypeExt();
    	tmp.setEnable(0);
    	tmp.setId(u.getId());
    	tmp.setParentId(u.getParentId());
    	tmp.setUpdateDatetime(new Date());
    	tmp.setUpdateUserId("00001");
    	tmp.setUpdateUserName("yanghao");
    	return tmp;
    }
    
    private List<UrFaqTypeExt> getWillBeDeleteFaqTypeByPid(String pId,List<UrFaqTypeExt> rtnList,List<UrFaqTypeExt> allList){
    	if(null==allList||0==allList.size()) return rtnList;
    	if(JUtil.isNull(pId)) return rtnList;
    	if(!isExitFaqType(pId,allList)) return rtnList;//pid不存在allList中
    	if(null==rtnList) rtnList = new ArrayList<UrFaqTypeExt>();
    	try {
    		int i;
    		for(i=0;i<allList.size();i++){//便利
    			UrFaqTypeExt u = allList.get(i);
    			if(u.getId().equals(pId)){//找到当前ID
    				if(!isExitFaqType(pId,rtnList)){//当前集合不存在此ID 我们加上
    					rtnList.add(setDealAttribute(u));
    				}
    			}else if(u.getParentId().equals(pId)){//找到子节点
    				if(!isExitFaqType(u.getId(), rtnList)){
    					rtnList.add(setDealAttribute(u));
    				}
    				rtnList=getWillBeDeleteFaqTypeByPid(u.getId(),rtnList,allList);
    			}
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtnList;
    }
    
    private boolean isExitFaqType(String id,List<UrFaqTypeExt> list){
    	if(null==list||0==list.size()) return false;
    	for(UrFaqType u:list){
    		if(u.getId().equals(id)) {
    			return true; 
    		}
    	}
    	return false;
    }
    
    private  void getAllFaqTypeByPid(UrFaqType pType){// 消耗sql资源太多 不采用
    	try {
    		beanProxy.put("parentId_EqualTo", pType.getParentId());
			List<UrFaqType> list = this.service.listUrFaqType(new UrFaqType(), null, null, new MapperCallBackAdapter(){
			    public void doCriteria(Object obj) throws Exception{
			        MapperUtil.builderCriteria(obj, UrFaqType.class, beanProxy);
			    }
			});
			if(null!=list && 0!=list.size()){
				int i;
				for(i=0;i<list.size();i++){
					UrFaqType tmpType = list.get(i);
					getAllFaqTypeByPid(tmpType);//便利子节点删除
				}
			}else{//没有发现有字节则进行删除操作
				UrFaqType tmp = new UrFaqType();
    			tmp.setId(pType.getId());
    			tmp.setEnable(0);//逻辑删除
    			tmp.setUpdateDatetime(new Date());
    			tmp.setUpdateUserId("000001");
    			tmp.setUpdateUserName("yanghao");
    			this.service.modifyUrFaqTypeByPk(tmp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return ;
    }
}

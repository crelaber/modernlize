/**
 * 
 */
package com.uwen.ur.model.service.sys.ext.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uwen.ur.common.BasicJSON;
import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExt;
import com.uwen.ur.util.JUtil;

/**
 * @author Kaixin
 *
 */
@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UrFaqTypeExtServiceImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Autowired
	UrFaqTypeExtServiceImpl urFaqTypeExtServiceImpl;
	/**
	 * Test method for {@link com.uwen.ur.model.service.sys.ext.impl.UrFaqTypeExtServiceImpl#getAllTreeNodelist(java.lang.String)}.
	 */
	@Test
	public void testGetAllTreeNodelist() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.uwen.ur.model.service.sys.ext.impl.UrFaqTypeExtServiceImpl#batchLogicDeleteByPrimaryKey(com.uwen.ur.model.pojo.sys.UrFaqType)}.
	 */
	@Test
	public void testBatchLogicDeleteByPrimaryKey() {
		UrFaqType u = new UrFaqType();
		try {
			urFaqTypeExtServiceImpl.batchLogicDeleteByPrimaryKey(u);
		} catch (Exception e) {
			fail("Exception : " + e.getMessage());
		}
	}
	private String delDataArr;
	@Test
	 public void  batchDrop(){//批量删除
    	try{
    	JSONArray dArr=null;
    	if(null!=delDataArr)
    	dArr = JSONArray.fromObject(delDataArr);
    	List<UrFaqTypeExt> delList  = new ArrayList<UrFaqTypeExt>();
    	List<UrFaqTypeExt> allList = urFaqTypeExtServiceImpl.getAllFaqType();
    	if(null!=dArr && 0!=dArr.size()){//进行处理
    		int i;
    		for(i=0;i<dArr.size();i++){
    			JSONObject o = dArr.getJSONObject(i);
    			delList = getWillBeDeleteFaqTypeByPid(o.getString("id"),delList,allList);
    		}
    	}
    	if(null!=delList && 0!=delList.size()){//进行批量操作
    		urFaqTypeExtServiceImpl.updateBatch(delList);
    	}
    	}catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	
	@Test
	public void testBatchUpdate() throws Exception{
		//System.out.println(start);
		List<UrFaqTypeExt> list = urFaqTypeExtServiceImpl.getAllFaqType();
		List<UrFaqTypeExt> list1 = new ArrayList<UrFaqTypeExt>();
		
		for (int i = 0; i < list.size(); i++) {
			UrFaqTypeExt u = new UrFaqTypeExt();
			u.setId(list.get(i).getId());
			u.setFaqTypeCode("yh_mo---");
			u.setParentId("s");
			u.setEnable(0);
			u.setFaqTypeName("yh_mo-" + i);
			u.setUpdateDatetime(new Date());
			u.setUpdateUserId("oooooo");
			list1.add(u);
		}
		
		long start = System.currentTimeMillis();
		urFaqTypeExtServiceImpl.updateBatch(list1);
		long end =System.currentTimeMillis();
		System.out.println("耗时---"+(end-start));
	}
	
	@Test
	public void testGetData(){
		List<UrFaqTypeExt> allList = new ArrayList<UrFaqTypeExt>();
		UrFaqTypeExt e = new UrFaqTypeExt();
		e.setId("001");
		e.setText("text1");
		e.setParentId("-1");
		allList.add(e);
		e = new UrFaqTypeExt();
		e.setId("002");
		e.setText("text2");
		e.setParentId("-1");
		allList.add(e);
		e = new UrFaqTypeExt();
		e.setId("0011");
		e.setText("text11");
		e.setParentId("001");
		allList.add(e);
		e = new UrFaqTypeExt();
		e.setId("0012");
		e.setText("text12");
		e.setParentId("001");
		allList.add(e);
		e = new UrFaqTypeExt();
		e.setId("00111");
		e.setText("text111");
		e.setParentId("0011");
		allList.add(e);
		e = new UrFaqTypeExt();
		e.setId("00121");
		e.setText("text121");
		e.setParentId("0012");
		allList.add(e);
		
		e = new UrFaqTypeExt();
		e.setId("00111-1");
		e.setText("text111-1");
		e.setParentId("00111");
		allList.add(e);
		
		e = new UrFaqTypeExt();
		e.setId("00111-2");
		e.setText("text111-2");
		e.setParentId("00111");
		allList.add(e);
		
		e = new UrFaqTypeExt();
		e.setId("00111-3");
		e.setText("text111-3");
		e.setParentId("00111");
		allList.add(e);
		
		e = new UrFaqTypeExt();
		e.setId("00111-2-1");
		e.setText("text111-2-1");
		e.setParentId("00111-2");
		allList.add(e);
		
		e = new UrFaqTypeExt();
		e.setId("00111-2-1-1");
		e.setText("text111-2-1-1");
		e.setParentId("00111-2-1");
		allList.add(e);
		
		List<UrFaqTypeExt>  list = new ArrayList<UrFaqTypeExt>();
		list=getWillBeDeleteFaqTypeByPid("00111",list,allList);
		list=getWillBeDeleteFaqTypeByPid("00111-2-1",list,allList);
		System.out.println(list);
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
	
	 public List<UrFaqTypeExt> getWillBeDeleteFaqTypeByPid1(String pId,List<UrFaqTypeExt> rtnList,List<UrFaqTypeExt> allList){
    	//获取总量
    	if(null==allList||0==allList.size()) return rtnList;
    	if(!isExitFaqType(pId,allList)) return rtnList;//pid不存在allList中
    	if(null==rtnList) rtnList = new ArrayList<UrFaqTypeExt>();
    	try {
			//List<UrFaqTypeExt> list = this.urFaqTypeExtService.getAllFaqType();
    		for(int i=0;i<allList.size();i++){
    			//便利
    			UrFaqTypeExt u = allList.get(i);
    			if(u.getId().equals(pId)){
    				//找到当前ID
    				if(!isExitFaqType(pId,rtnList)){//当前集合不存在此ID 我们加上
    					rtnList.add(u);
    				}
    	
    			}else if(u.getParentId().equals(pId)){
    				//找到子节点
    				if(!isExitFaqType(u.getId(), rtnList)){
    					rtnList.add(u);
    					rtnList=getWillBeDeleteFaqTypeByPid(u.getId(),rtnList,allList);
    				}
    			}
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtnList;
    }
	
	@Test
	public void testBatchInsert(){
		//System.out.println(start);
		List<UrFaqTypeExt> list = new ArrayList<UrFaqTypeExt>();
		for (int i = 0; i < 10000; i++) {
			UrFaqTypeExt u = new UrFaqTypeExt();
			u.setId(JUtil.uuid12());
			u.setFaqTypeCode("-1");
			u.setParentId("-1");
			//u.setEnable(1);
			u.setAddDatetime(new Date());
			u.setFaqTypeName("杨浩" + i);
			list.add(u);
		}
		
		long start = System.currentTimeMillis();
		urFaqTypeExtServiceImpl.insertBatch(list);
		long end =System.currentTimeMillis();
		System.out.println("耗时---"+(end-start));
	}
}

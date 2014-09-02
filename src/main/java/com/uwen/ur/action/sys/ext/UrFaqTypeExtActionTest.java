/**
 * 
 */
package com.uwen.ur.action.sys.ext;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

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
import com.uwen.ur.common.NormalDatagrid;
import com.uwen.ur.model.interfaze.sys.impl.MapperCallBackAdapter;
import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.service.sys.UrFaqTypeService;
import com.uwen.ur.util.MapperUtil;
import com.uwen.ur.util.Page;
import com.uwen.ur.util.sys.FieldAppendArray;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UrFaqTypeExtActionTest {

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

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqTypeAction#list()}.
	 */
	@Autowired
	private UrFaqTypeService service;
	
	//代理bean
    protected Map<String,String> beanProxy;
	@Test
	public final void testList() {
		 try {
	            FieldAppendArray appendArray = new FieldAppendArray();
	            UrFaqType rec = new UrFaqType();
	            beanProxy = new HashMap<String,String>();
	            beanProxy.put("enable", "0");
	            JSONArray array = service.listUrFaqTypeAndFkText(rec, null, null, new MapperCallBackAdapter(){
	                public void doCriteria(Object obj) throws Exception{
	                    MapperUtil.builderCriteria(obj, UrFaqType.class, beanProxy);
	                }
	            }, appendArray);
	            //返回数据
	            System.out.println("array="+array);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	}

}

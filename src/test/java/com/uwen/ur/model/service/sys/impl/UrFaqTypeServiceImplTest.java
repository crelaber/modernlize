/**
 * 
 */
package com.uwen.ur.model.service.sys.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExt;
import com.uwen.ur.model.service.sys.UrFaqService;
import com.uwen.ur.model.service.sys.UrFaqTypeService;
import com.uwen.ur.model.service.sys.ext.impl.UrFaqTypeExtServiceImpl;
import com.uwen.ur.util.JUtil;

/**
 * @author Kaixin
 *
 */
@Transactional
@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UrFaqTypeServiceImplTest {

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
	UrFaqTypeServiceImpl urFaqTypeServiceImpl;
	@Autowired
	UrFaqTypeExtServiceImpl urFaqTypeExtServiceImpl;
	@Autowired
	UrFaqService urFaqService;
	@Autowired 
	UrFaqTypeService urFaqTypeService;
	
	/**
	 * Test method for {@link com.uwen.ur.model.service.sys.impl.UrFaqTypeServiceImpl#insertUrFaqType(com.uwen.ur.model.pojo.sys.UrFaqType)}.
	 */
	@Test
	public void insrtFaqTest() throws Exception{
		UrFaq u1 = new UrFaq();
		u1.setId(JUtil.uuid12());
		u1.setQuestion("你吃饭了吗？");
		u1.setAnswer("我吃了啊!");
		u1.setCreateUserId("00000000001");
		u1.setCreateUserName("yh");
		urFaqService.insertUrFaq(u1);
		UrFaqType u = new UrFaqType();
		u.setId(JUtil.uuid12());
		u.setFaqTypeName("杨浩TEST-2014-12-01");
		u.setCreateUserId("00000000001");
		u.setCreateUserName("yh");
		u.setEnable(1);
		u.setFaqTypeCode("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		urFaqTypeService.insertUrFaqType(u);
	}
	
	
	@Test
	public void testBatchUpdate() throws Exception{
		//System.out.println(start);
		List<UrFaqTypeExt> list = urFaqTypeExtServiceImpl.getAllFaqType();
		List<UrFaqType> list1 = new ArrayList<UrFaqType>();
		for (int i = 0; i < list.size(); i++) {
			UrFaqType u = new UrFaqType();
			u.setId(list.get(i).getId());
			u.setFaqTypeCode("yanghao_modify");
			u.setParentId("-1");
			u.setEnable(0);
			u.setFaqTypeName("modify" + i);
			u.setUpdateDatetime(new Date());
			u.setUpdateUserId("xxxxxxx");
			list1.add(u);
		}
		int j;
		long start = System.currentTimeMillis();
		for(j=0;j<list1.size();j++){
			
			urFaqTypeServiceImpl.modifyUrFaqTypeByPkSelective(list1.get(j));
		}
		long end =System.currentTimeMillis();
		System.out.println("耗时---"+(end-start));
	}
	
	
	@Test
	public void testInsertUrFaqType() {
		List<UrFaqType> list = new ArrayList<UrFaqType>();
		for (int i = 0; i < 10000; i++) {
			UrFaqType u = new UrFaqType();
			u.setId(JUtil.uuid12());
			u.setFaqTypeName("杨浩" + i);
			list.add(u);
		}
		
		long start = System.currentTimeMillis();
		for (UrFaqType urFaqType : list) {
			try {
				urFaqTypeServiceImpl.insertUrFaqType(urFaqType);
			} catch (Exception e) {
				fail("Exception : " + e.getMessage());
				throw new RuntimeException(e);
			}
		}
		long end =System.currentTimeMillis();
		System.out.println("耗时---"+(end-start));
	}

}

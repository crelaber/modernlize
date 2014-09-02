/**
 * 
 */
package com.uwen.ur.action.sys;

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
import org.springframework.transaction.annotation.Transactional;

import com.uwen.ur.common.BasicJSON;
import com.uwen.ur.common.NormalDatagrid;
import com.uwen.ur.model.interfaze.sys.impl.MapperCallBackAdapter;
import com.uwen.ur.model.pojo.sys.UrFaq;
import com.uwen.ur.model.service.sys.UrFaqService;
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
public class UrFaqActionTest {

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
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#addOrUpdate()}.
	 */
	@Test
	public final void testAddOrUpdate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#findByPk()}.
	 */
	@Test
	public final void testFindByPk() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#find()}.
	 */
	@Test
	public final void testFind() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#listByPk()}.
	 */
	@Test
	public final void testListByPk() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#list()}.
	 */
	 @Autowired UrFaqService service;
	 //代理bean
	    protected Map<String,String> beanProxy;
	@Test
	public  void testList()  throws Exception{
		try {
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&--1");
            FieldAppendArray appendArray = new FieldAppendArray();
            UrFaq rec = new UrFaq();
            beanProxy=new HashMap<String,String>();
            beanProxy.put("enable_EqualTo", "1");
           // Page paging = Page.getInstance(page - 1, rows);
            JSONArray array = service.listUrFaqAndFkText(rec, null, null, new MapperCallBackAdapter(){
                
                public void doCriteria(Object obj) throws Exception{
                    MapperUtil.builderCriteria(obj, UrFaq.class, beanProxy);
                }
            }, appendArray);
           System.out.println("array="+array);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //set$data(new BasicJSON(0,"fail",null));
        }
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#delete()}.
	 */
	@Test
	public final void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#drop()}.
	 */
	@Test
	public final void testDrop() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getDbFlag()}.
	 */
	@Test
	public final void testGetDbFlag() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setDbFlag(int)}.
	 */
	@Test
	public final void testSetDbFlag() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getPks()}.
	 */
	@Test
	public final void testGetPks() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setPks(java.lang.String)}.
	 */
	@Test
	public final void testSetPks() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getPage()}.
	 */
	@Test
	public final void testGetPage() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setPage(int)}.
	 */
	@Test
	public final void testSetPage() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getRows()}.
	 */
	@Test
	public final void testGetRows() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setRows(int)}.
	 */
	@Test
	public final void testSetRows() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getBeanProxy()}.
	 */
	@Test
	public final void testGetBeanProxy() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setBeanProxy(java.util.Map)}.
	 */
	@Test
	public final void testSetBeanProxy() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getRecord()}.
	 */
	@Test
	public final void testGetRecord() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setRecord(com.uwen.ur.model.pojo.sys.UrFaq)}.
	 */
	@Test
	public final void testSetRecord() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getSort()}.
	 */
	@Test
	public final void testGetSort() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setSort(java.lang.String)}.
	 */
	@Test
	public final void testSetSort() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getComp()}.
	 */
	@Test
	public final void testGetComp() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setComp(int)}.
	 */
	@Test
	public final void testSetComp() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#getPrefix()}.
	 */
	@Test
	public final void testGetPrefix() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.uwen.ur.action.sys.UrFaqAction#setPrefix(java.lang.String)}.
	 */
	@Test
	public final void testSetPrefix() {
		fail("Not yet implemented"); // TODO
	}

}

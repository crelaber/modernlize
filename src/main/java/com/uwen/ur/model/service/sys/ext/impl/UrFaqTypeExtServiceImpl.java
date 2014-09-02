package com.uwen.ur.model.service.sys.ext.impl;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.uwen.ur.model.dal.sys.ext.UrFaqTypeExtMapper;
import com.uwen.ur.model.pojo.sys.UrFaqType;
import com.uwen.ur.model.pojo.sys.ext.UrFaqTypeExt;
import com.uwen.ur.model.service.sys.ext.UrFaqTypeExtService;
import com.uwen.ur.util.JUtil;
@Service
@Scope("prototype")
public class UrFaqTypeExtServiceImpl implements UrFaqTypeExtService {
    @Autowired
    UrFaqTypeExtMapper mapper;
    
    @Resource 
    public SqlSessionTemplate sqlSession; 
    
    private int size=5000;//每次提交的数据
    
    private SqlSession session;
    
	public JSONArray getAllTreeNodelist(String requestType) throws Exception {
		// TODO Auto-generated method stub
		List<UrFaqTypeExt> list = getAllFaqType();
		if(null==list) return new JSONArray();
		return JUtil.getNodeSelectTree(list,requestType);
	}
	public void batchLogicDeleteByPrimaryKey(UrFaqType u)
			throws Exception {
		// TODO Auto-generated method stub
		this.mapper.batchLogicDeleteByPrimaryKey(u);
	}
	
	public void updateBatch(List<UrFaqTypeExt> list){
		//批量更新 包括逻辑删除
		session = sqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		UrFaqTypeExtMapper m = session.getMapper(UrFaqTypeExtMapper.class);
		try{
			int i;
		for(i=0;i<list.size();i++){
			m.updateByPrimaryKeySelective(list.get(i));
			if(i%size==0 || i ==list.size()-1){ //每5000个提交一次
				session.commit();
				session.clearCache();	
			 }
		 }
		}catch(Exception e){
			session.rollback();//回滚
		}finally{
			session.close();
		}
	}
	
	public void insertBatch(List<UrFaqTypeExt> list) {
		// TODO Auto-generated method stub
		session = sqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		UrFaqTypeExtMapper m = session.getMapper(UrFaqTypeExtMapper.class);
		try{
			int i;
		for(i=0;i<list.size();i++){
			m.insertSelective(list.get(i));
			if(i%size==0 || i ==list.size()-1){ //每5000个提交一次
				session.commit();
				session.clearCache();	
			 }
		 }
		}catch(Exception e){
			session.rollback();//回滚
		}finally{
			session.close();
		}
	}
	public List<UrFaqTypeExt> getAllFaqType() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}

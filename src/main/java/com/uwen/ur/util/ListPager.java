package com.uwen.ur.util;

import java.util.ArrayList;
import java.util.List;

public class ListPager<T> {
	private List<T> list;
	private int pageSize = 1;
	
	public ListPager(List<T> list, int pageSize) {
		this.setList(list);
		this.setPageSize(pageSize);
	}
	
	/**
	 * 
	 * @param page 下标从1开始
	 * @return
	 */
	public List<T> getList(int page) {
		page = page < 1 ? 1 : page;
		int start = (page - 1) * pageSize;
		int end =  page * pageSize;
		int totalIndex = this.getTotal();
		end = end > totalIndex ? totalIndex : end;
		start = start > end ? end : start;
		return list.subList(start, end);
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotal() {
		return this.list.size();
	}
	
	public int getPageSum(){
		int total = getTotal();
		int sum = total/pageSize + total%pageSize;
		return sum;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			list.add(i + "");
		}
		
		ListPager<String> pager = new ListPager<String>(list, 3);
		test0(pager);
		test1(pager);
		test1_2(pager);
		test2(pager);
		test3(pager);
		test4(pager);
		
		System.out.println(pager.getPageSum());
	}
	
	public static void test0(ListPager<String> pager){
		List<String> result = pager.getList(0);
		StringBuilder actual  = new StringBuilder();
		for (String string : result) {
			actual.append(string);
			actual.append(",");
		}
		if(!"0,1,2,".equals(actual.toString())){
			throw new RuntimeException("测试用例未通过,实际值" + actual.toString());
		}
	}
	
	public static void test1(ListPager<String> pager){
		List<String> result = pager.getList(1);
		StringBuilder actual  = new StringBuilder();
		for (String string : result) {
			actual.append(string);
			actual.append(",");
		}
		if(!"0,1,2,".equals(actual.toString())){
			throw new RuntimeException("测试用例未通过,实际值" + actual.toString());
		}
	}
	
	public static void test1_2(ListPager<String> pager){
		List<String> result = pager.getList(2);
		StringBuilder actual  = new StringBuilder();
		for (String string : result) {
			actual.append(string);
			actual.append(",");
		}
		if(!"3,4,5,".equals(actual.toString())){
			throw new RuntimeException("测试用例未通过,实际值" + actual.toString());
		}
	}
	
	public static void test2(ListPager<String> pager){
		List<String> result = pager.getList(7);
		StringBuilder actual  = new StringBuilder();
		for (String string : result) {
			actual.append(string);
			actual.append(",");
		}
		if(!"18,19,20,".equals(actual.toString())){
			throw new RuntimeException("测试用例未通过,实际值" +actual.toString());
		}
	}
	public static void test3(ListPager<String> pager){
		List<String> result = pager.getList(34);
		StringBuilder actual  = new StringBuilder();
		for (String string : result) {
			actual.append(string);
			actual.append(",");
		}
		if(!"99,".equals(actual.toString())){
			throw new RuntimeException("测试用例未通过,实际值" +actual.toString());
		}
	}
	
	public static void test4(ListPager<String> pager){
		List<String> result = pager.getList(35);
		StringBuilder actual  = new StringBuilder();
		for (String string : result) {
			actual.append(string);
			actual.append(",");
		}
		if(!"".equals(actual.toString())){
			throw new RuntimeException("测试用例未通过,实际值" +actual.toString());
		}
	}
}

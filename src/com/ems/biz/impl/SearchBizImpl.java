package com.ems.biz.impl;

import java.util.Vector;

import com.ems.biz.SearchBiz;
import com.ems.dao.SearchDao;
import com.ems.dao.impl.SearchDaoImpl;

public class SearchBizImpl implements SearchBiz {

	private SearchDao searchdao;
	
	public Vector Search(String message) {
		
		searchdao = new SearchDaoImpl();
		
		return searchdao.Search(message);
	}

	
	public Vector search(String sql) {
		
		searchdao = new SearchDaoImpl();
	
		return searchdao.search(sql);
	}

	
	public int delete(String empId) {
		searchdao = new SearchDaoImpl();
		return searchdao.delete(empId);
	}

}

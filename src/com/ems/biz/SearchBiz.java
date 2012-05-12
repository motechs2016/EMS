package com.ems.biz;

import java.util.Vector;

public interface SearchBiz {
	
	public Vector<Vector<String>> search(String sql);
	
	public Vector<Vector<String>> Search(String message);
	
	public int delete(String empId);
}

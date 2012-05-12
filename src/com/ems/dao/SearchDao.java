package com.ems.dao;

import java.util.ArrayList;
import java.util.Vector;

public interface SearchDao {

	public Vector<Vector<String>> search(String sql);
	
	public Vector<Vector<String>> Search(String message);
	
	public int delete(String empId);
}

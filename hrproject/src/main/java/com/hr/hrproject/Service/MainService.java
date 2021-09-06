package com.hr.hrproject.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hr.hrproject.DAO.hrDao;

@Service
public class MainService {
	
	public MainService() {
		
		
	}
	
	@Autowired
	hrDao hrDAO;
	
	public void sendInfos(String username,String email) {
		// TODO Auto-generated method stub
		hrDAO.recordInfos(username,email);
	}

	public ArrayList<String[]> getAllUsers() {
		
		ArrayList<String[]> a1 = new ArrayList<String[]>();
		a1=hrDAO.getRecord();
		
		
		return a1;
		// TODO Auto-generated method stub
		
	}
}

package com.hybridsoft.iservices;

import java.util.ArrayList;


import com.hybridsoft.bean.Emplyoee;

public interface IEmployeeService {
	
	public void addNewEmployee(Emplyoee e);
	public void delete();
	public ArrayList<Emplyoee> getlistdata();
	public void deleteEmplyoee(int a);
}

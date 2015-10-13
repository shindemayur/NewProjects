package com.hybridsoft.servicesimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybridsoft.bean.Emplyoee;
import com.hybridsoft.idao.IEmplyoeeDao;
import com.hybridsoft.iservices.IEmployeeService;

public class EmplyoeeServicesImpl implements IEmployeeService 
{

	@Autowired
	IEmplyoeeDao iEmployeeDao;
	public void addNewEmployee(Emplyoee e) {
		// TODO Auto-generated method stub
		iEmployeeDao.addEmplyee(e);
		
	}
	public void delete()
	{
		// TODO Auto-generated method stub
		
	}
	
	
	public ArrayList<Emplyoee> getlistdata()
	{
		ArrayList<Emplyoee> Emp=new ArrayList<Emplyoee>();
		Emp=iEmployeeDao.getpagination(1,5);
		
		return Emp;
	}
	public void deleteEmplyoee(int a) {
		// TODO Auto-generated method stub
		
	}
	
	
}

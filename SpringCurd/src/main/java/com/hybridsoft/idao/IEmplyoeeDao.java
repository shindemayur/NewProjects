package com.hybridsoft.idao;

import java.util.ArrayList;

import com.hybridsoft.bean.Emplyoee;

public interface IEmplyoeeDao {
	
	public void addEmplyee(Emplyoee e);
	public ArrayList<Emplyoee>getlist();
	public void deletedata(int a);
	public ArrayList<Emplyoee>getpagination(int page,int recordperpage);

}

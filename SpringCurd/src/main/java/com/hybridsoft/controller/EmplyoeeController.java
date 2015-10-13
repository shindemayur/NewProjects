package com.hybridsoft.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hybridsoft.bean.Emplyoee;
import com.hybridsoft.iservices.IEmployeeService;

@Controller
public class EmplyoeeController {
	
	
	@Autowired
	IEmployeeService iEmployeeService;
	
	@RequestMapping("/register")
  public ModelAndView newuser(ModelMap model)
  {
		System.out.println("------------");
		model.addAttribute("employee", new Emplyoee());
		return new ModelAndView();
  }

	
	@RequestMapping("/index")
	public ModelAndView viewIndexPage(ModelMap model) 
	{
		System.out.println("============hi");
		//logger.info("====================excecuted Index Page=====================");
		model.addAttribute("employee", new Emplyoee());
		return new ModelAndView("reg");
		// return new ModelAndView("welcome");
	}
	
	@RequestMapping("/saveContact")
	public ModelAndView savedetails(@ModelAttribute Emplyoee emplyoee)
	{
		System.out.println(emplyoee.getName());
		System.out.println("in savedetails");
		iEmployeeService.addNewEmployee(emplyoee);
		return new ModelAndView("redirect:getlist.htm");
	}
	
	@RequestMapping("/getlist")
	public ModelAndView getdata()
	{
		ArrayList<Emplyoee> list=null;
		System.out.println("in getdata function");
		list=iEmployeeService.getlistdata();
		for(Emplyoee e:list)
		{
			System.out.println(e.getName());
		}
		return new ModelAndView("welcome","Elist",list);
	}
	
	
	@RequestMapping("/delete")
	public ModelAndView deletedata()
	{
		System.out.println("in deletedata function");
		int a=10;
		iEmployeeService.deleteEmplyoee(a);
		
		
		return null;
	}
	
	
	
	
	
	
}

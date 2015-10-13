package com.extremityindia.apps.controller;

import java.util.List;








import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.extremityindia.apps.bean.Employee;
import com.extremityindia.apps.iservice.IEmployeeService;



/**
 * @author Prasad Deokar
 *
 */
@Controller
@SessionAttributes("check")
public class EmployeeController {
	
	@Autowired
	IEmployeeService iEmployeeService;
	private static final Logger logger = Logger.getLogger(Employee.class);

	@RequestMapping("/index")
	public ModelAndView viewIndexPage() 
	{
		System.out.println("============hi");
		logger.info("====================excecuted Index Page=====================");
		return new ModelAndView("redirect:getEmployeeList.htm");
		// return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/registerhere")
	public ModelAndView viewRegistration(ModelMap model) 
	{
		if(logger.isDebugEnabled())
		{
			logger.debug("View Registration page executed!");
		}
		model.addAttribute("employee", new Employee());

		return new ModelAndView("registration");
	}

	@RequestMapping("/saveContact")
	public String saveEmployeeInoformation(@Valid Employee employee2,BindingResult result) 
	{
		System.out.println("before if");
		System.out.println("==========="+result.hasErrors());
		if(result.hasErrors())
		{
			logger.error("This is Error message", new Exception("Not valid Data"));
			return "registration";		
		}
		else{
			iEmployeeService.addEmployee(employee2);
			return "redirect:/index.htm";
		}
	}

	@RequestMapping("/getEmployeeList.htm")
	public ModelAndView getEmployeeList() {
		List<Employee> list = null;
		try {
			list = iEmployeeService.employeeList();
			System.out.println("list"+list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("welcome", "list", list);
	}

	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam int id)
	{
		System.out.println("id = " + id);
		try {
			iEmployeeService.deleteEmp(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/index.htm";
	}
	@RequestMapping(value = "/edit")
	public ModelAndView editPage(@RequestParam int id) 
	{
		System.out.println("id = " + id);
		List<Employee> list=iEmployeeService.editEmployee(id);
		return new ModelAndView("edit", "list", list);
	}

	@RequestMapping("/updateContact")
	public String updateEmployeeInoformation(@ModelAttribute Employee employee,
			BindingResult result) {
		try {
			iEmployeeService.updateEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index.htm";
	}

	/*@RequestMapping(method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model)
	{

		model.addAttribute("employee", new Employee());
		return "redirect:/registerhere.htm";

	}*/
	
	@RequestMapping("/check")
	public ModelAndView check(@RequestParam String check1,HttpSession session)
	
	{
		System.out.println("=======================================IN Method");
	//	session.putValue(arg0, arg1);
		ModelAndView view =new ModelAndView();
		
		view.addObject("check",check1);
		System.out.println("=============="+check1);
		view.setViewName("welcome");
		return  view;
		
	}
	
	
}

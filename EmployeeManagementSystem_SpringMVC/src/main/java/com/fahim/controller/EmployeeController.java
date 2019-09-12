package com.fahim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fahim.dao.EmployeeDao;
import com.fahim.model.Employee;

@Controller
public class EmployeeController {

	@Autowired 
	EmployeeDao employeeDao;
	
	@RequestMapping(path= {"/"},method=RequestMethod.GET)
	public ModelAndView getAllEmployeeData(ModelAndView view) {
		List<Employee> empList= employeeDao.getAllEmployee();
		view.addObject("employeeList", empList);
		view.setViewName("viewDetails");
		return view;
	}
	
	@RequestMapping(path= {"/saveEmployee"},method=RequestMethod.POST)
	public ModelAndView saveOrUpdateEmployeeData(@ModelAttribute("employee")Employee employee,ModelAndView view) {
		employeeDao.saveOrUpdate(employee);
		view.setViewName("redirect:/");
		return view;
	}
	
	/*
	 * @RequestMapping(path= {"/saveEmployee"},method=RequestMethod.POST) public
	 * ModelAndView
	 * saveOrUpdateEmployeeData(@Valid @ModelAttribute("employee")Employee
	 * employee,ModelAndView view,BindingResult br) { if(br.hasErrors()) {
	 * view.setViewName("employeeForm"); } else {
	 * employeeDao.saveOrUpdate(employee); view.setViewName("redirect:/"); } return
	 * view; }
	 */
	
	
	@RequestMapping(path= {"/newEmployee"},method=RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView view) {
		Employee employee = new Employee();
		view.addObject("employee", employee);
		view.addObject("buttonName", "Save");
		view.addObject("editPage", "false");
		view.setViewName("employeeForm");
		return view;
	}
	
	/*
	 * @RequestMapping(path= {"/"},method=RequestMethod.GET) public ModelAndView
	 * updateEmployeeData(@ModelAttribute("employee")Employee employee,ModelAndView
	 * view) { employeeDao.update(employee); view.setViewName("viewDetails"); return
	 * view; }
	 */
	
	@RequestMapping(path= {"/deleteEmployee"},method=RequestMethod.GET)
	public ModelAndView deleteEmployeeData(HttpServletRequest request,HttpServletResponse response,ModelAndView view) {
		int empId=Integer.parseInt(request.getParameter("empId"));
		employeeDao.delete(empId);
		view.setViewName("redirect:/");
		return view;
	}
	
	@RequestMapping(path= {"/updateEmployee"},method=RequestMethod.GET)
	public ModelAndView getEmployeeData(HttpServletRequest request,HttpServletResponse response,ModelAndView view) {
		int empId=Integer.parseInt(request.getParameter("empId"));
		Employee emp=employeeDao.getEmployee(empId);
		view.addObject("employee", emp);
		view.addObject("buttonName", "Update");
		view.addObject("editPage", "true");
		view.setViewName("employeeForm");
		return view;
	}
	
	
	
}

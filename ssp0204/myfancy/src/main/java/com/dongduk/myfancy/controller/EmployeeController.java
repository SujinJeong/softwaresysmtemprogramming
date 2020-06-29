package com.dongduk.myfancy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Commute;
import com.dongduk.myfancy.domain.Employee;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.EmployeeServiceImpl;


@Controller
@SessionAttributes({"employee", "employer"})
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@ModelAttribute("employeeForm")
	public EmployeeForm createEmployeeForm() {
		return new EmployeeForm();
	}
	
	@RequestMapping("store/emp")
	public String goEmp() {
		return "store/emp/emp";
	}
	
	@RequestMapping(value="store/emp/employer", method=RequestMethod.POST)
	public ModelAndView viewEmployeeList(HttpServletRequest request, @RequestParam String employer) {
		ModelAndView mav = new ModelAndView("store/emp/employer");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		if (employer.equals(store.getPassword())) {
			mav.addObject("employeeList", employeeService.getEmployeeList(store_id));
			return mav;
		} else {
			mav.setViewName("store/emp/emp");
			return mav;
		}
	}
	
	@RequestMapping("store/emp/employer/salary")
	public ModelAndView viewSalary(HttpServletRequest request, @RequestParam int move, @RequestParam String year, @RequestParam String month) {
		ModelAndView mav = new ModelAndView("store/emp/salary");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		boolean now;
		if (move < 0 && month.equals("1")) {
			year = Integer.toString(Integer.parseInt(year) - 1);
			month = "12";
		} else if (move > 0 && month.equals("12")) {
			year = Integer.toString(Integer.parseInt(year) + 1);
			month = "1";
		} else {
			month = Integer.toString(Integer.parseInt(month) + move);
		}
		if (Integer.parseInt(month) < 10) month = "0" + month;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		if ((year+month).equals(sdf.format(new Date())))
			now = true;
		else
			now = false;
		System.out.println(now);
		mav.addObject("employeeSalaryList", employeeService.getSalaryListByMonth(store_id, year+month));
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("now", now);
		return mav;
	}

	@RequestMapping("store/emp/employer/remove/{emp_id}")
	public ModelAndView removeEmp(HttpServletRequest request, @PathVariable int emp_id ) {
		ModelAndView mav = new ModelAndView("redirect:/store/emp/employer");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		employeeService.removeEmployee(emp_id, store_id);
		return mav;
	}

	@RequestMapping("store/emp/employer/update")
	public String updateEmp(@RequestParam int empId ) {
//		ModelAndView mav = new ModelAndView("redirect:/store/emp/employer/update/" + empId);
//		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
//		int store_id = store.getStore_id();
//		Employee emp = employeeService.getEmployee(empId, store_id);
//		mav.addObject("emp", emp);
		return "redirect:/store/emp/employer/update/" + empId;
	}
	
	@RequestMapping("store/emp/commute")
	public ModelAndView empCommuteView(HttpServletRequest request, @RequestParam int emp_id ) {
		ModelAndView mav = new ModelAndView("store/emp/commute");
		mav.addObject("commuteList", employeeService.getCommuteList(emp_id));
		mav.addObject("emp_id", emp_id);
		return mav;
	}
	
	@RequestMapping("store/emp/employee/start")
	public String empStartTime(HttpServletRequest request, @RequestParam int emp_id ) {
//		Commute commute = new Commute();
//		commute.setEmp_id(emp_id);
//		System.out.println("emp id : " + commute.getEmp_id());
//		System.out.println("emp finish time : " + commute.getFinish_time()); // null
		employeeService.insertStartTime(emp_id);
		return "redirect:store/emp/commute?emp_id=" + emp_id;
	}
	
	@RequestMapping("store/emp/employee/finish")
	public String empFinishTime(HttpServletRequest request, @RequestParam int emp_id ) {
		employeeService.insertFinishTime(emp_id);
		employeeService.updateWorkTime(emp_id, employeeService.getCommuteOfToday(emp_id).getWorktimeOfDay());
		return "redirect:store/emp/commute?emp_id=" + emp_id;
	}
	
//	@RequestMapping("/store/emp/commute")
//	public void 

	
}

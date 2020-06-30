package com.dongduk.myfancy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String goEmp(HttpSession session) {
		
		return "store/emp/emp";
	}
	
	@RequestMapping(value="store/emp/employer", method=RequestMethod.POST)
	public ModelAndView viewEmployeeList(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam String employer) {
		ModelAndView mav = new ModelAndView("store/emp/employer");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		if (employer.equals(store.getPassword())) {
			session.setAttribute("employerCheck", true);
			mav.addObject("employeeList", employeeService.getEmployeeList(store_id));
			return mav;
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
            try {
               out = response.getWriter();
               out.println("<script>alert('관리자 비밀번호가 맞지 않습니다.');</script>");
               out.flush();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
			mav.setViewName("store/emp/emp");
			return mav;
		}
	}
	
	@RequestMapping(value="store/emp/employer", method=RequestMethod.GET)
	public ModelAndView employerPageToGet(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("employerCheck") == null) return new ModelAndView("store/emp/emp");
		else {
			if (!((boolean)session.getAttribute("employerCheck"))) return new ModelAndView("store/emp/emp");
			else {
				ModelAndView mav = new ModelAndView("store/emp/employer");
				mav.addObject("employeeList", employeeService.getEmployeeList(((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id()));
				return mav;
			}
		}
	}
	
	@RequestMapping("store/emp/employer/salary")
<<<<<<< HEAD
	public ModelAndView viewSalary(HttpServletRequest request, HttpSession session, @RequestParam int move, @RequestParam String year, @RequestParam String month) {
		if (session.getAttribute("employerCheck") == null) return new ModelAndView("store/emp/emp");
		else {
			if (!((boolean)session.getAttribute("employerCheck"))) return new ModelAndView("store/emp/emp");
			else {
				ModelAndView mav = new ModelAndView("store/emp/salary");
				Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
				int store_id = store.getStore_id();
				boolean now;
				if (move < 0 && Integer.parseInt(month) == 1) {
					year = Integer.toString(Integer.parseInt(year) - 1);
					month = "12";
				} else if (move > 0 && Integer.parseInt(month) == 12) {
					year = Integer.toString(Integer.parseInt(year) + 1);
					month = "1";
				} else {
					month = Integer.toString(Integer.parseInt(month) + move);
				}
				if (Integer.parseInt(month) < 10 && Integer.parseInt(month) > 0) month = "0" + month;
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
		}
		
=======
	public ModelAndView viewSalary(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("store/emp/salary");
		Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		//mav.addObject("employeeSalaryList", employeeService.getSalary(store_id));
		return mav;
>>>>>>> refs/remotes/origin/develop
	}

	@RequestMapping("store/emp/employer/remove/{emp_id}")
	public String removeEmp(HttpServletRequest request, HttpSession session, @PathVariable int emp_id ) {
		if (session.getAttribute("employerCheck") == null) return "store/emp/emp";
		else {
			if (!((boolean)session.getAttribute("employerCheck"))) return "store/emp/emp";
			else {
				Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
				int store_id = store.getStore_id();
				employeeService.removeEmployee(emp_id, store_id);
				return "redirect:/store/emp/employer";
			}
		}		
	}

	@RequestMapping("store/emp/employer/update")
	public String updateEmp(@RequestParam int empId, HttpSession session ) {
		if (session.getAttribute("employerCheck") == null) return "store/emp/emp";
		else {
			if (!((boolean)session.getAttribute("employerCheck"))) return "store/emp/emp";
			else {
					return "redirect:/store/emp/employer/update/" + empId;
			}
		}
	}
	
	@RequestMapping("store/emp/commute")
	public ModelAndView empCommuteView(HttpServletRequest request, HttpServletResponse response, @RequestParam("emp_id") int emp_id) {
		ModelAndView mav = new ModelAndView("store/emp/commute");
		int store_id = ((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id();
		Employee emp = employeeService.getEmployee(emp_id, store_id);
		if (emp == null) {
			response.setContentType("text/html;charset=UTF-8");
            PrintWriter out;
            try {
               out = response.getWriter();
               out.println("<script>alert('직원 id " + emp_id + "은(는) 존재하지 않습니다.');</script>");
               out.flush();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
			return new ModelAndView("store/emp/emp");
		}
		mav.addObject("commuteList", employeeService.getCommuteList(emp_id, store_id));
		mav.addObject("emp_id", emp_id);
		mav.addObject("emp_name", emp.getEmp_name());
		return mav;
	}
	
	@RequestMapping("store/emp/employee/commuteClick")
	@ResponseBody
	public Commute empCommuteClick(HttpServletRequest request, @RequestParam int emp_id ) throws Exception{
		int store_id = ((Store)WebUtils.getSessionAttribute(request, "storeSession")).getStore_id();
		Commute commute = employeeService.getCommuteOfToday(emp_id, store_id);
		if (commute == null) {
			employeeService.insertStartTime(emp_id, store_id);
			commute = employeeService.getCommuteOfToday(emp_id, store_id);
			commute.setStartStr(employeeService.getStartTimeToString(emp_id, store_id));
		} else if (commute.getComplete() == 0) {
			if (employeeService.getWorkTimeByNow(emp_id, store_id) < 0.5) throw new Exception();
			employeeService.insertFinishTime(emp_id, store_id);
			commute.setStartStr(employeeService.getStartTimeToString(emp_id, store_id));
			commute.setFinishStr(employeeService.getFinishTimeToString(emp_id, store_id));
		} else {
			return null;
		}
		
		return commute;
	}
	
	
}

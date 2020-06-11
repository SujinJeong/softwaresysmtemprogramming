package com.dongduk.myfancy.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.myfancy.domain.Sales;
import com.dongduk.myfancy.service.SalesService;

@Controller
@RequestMapping("/store") // 포트 번호 다음에 입력하는 url 인듯 하다.
public class ViewSalesController {

	// 연결할 Service 클래스를 설정해준다.
	@Autowired
	private SalesService salesService;

	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public String list(@RequestParam("storeId") int storeid, @RequestParam Date salesdate,
			@ModelAttribute("sales") Sales sales, 
			Model model, HttpSession session, HttpServletRequest request) throws Exception
	{
		
//		/*** 로그인 ***/
//		// 세션이 있는지 확인한다, 만약 없다면 새로 생성하지 않는다.
//		session = request.getSession(false);
//
//		String admn_id = null;
//		// 세션을 불러와 admn_id에 넣는다. 없다면 null이나 ""이가 들어오겟죠
//		admn_id = (String)session.getAttribute("admn_id");
//
//		// 만약 admn_id가 null 또는 "" 이라면 (로그인을 하지 않은 상태라면) 
//		// 로그인 페이지로 강제로 보내라
//		if (admn_id == null || admn_id.equals(""))
//			return "redirect:/index";
//		/*** 로그인 ***/
//
//		// 매출은 해당 지점 id로 로그인 되어있을때 볼 수 있어야 한다.
//		if (!admn_id.equals(storeid))
//			return "redirect:/main";

		// Controller 에서 JSP 에게 전송 JSP파일에서는 EL을 사용하여 받는다.
		model.addAttribute("sales", salesService.getSalesByDay(salesdate, storeid));

		// JSP 파일 경로 (폴더명 / 파일명을 리턴해준다.)
		return "store/sales";
	}
}

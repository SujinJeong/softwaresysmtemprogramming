package com.dongduk.myfancy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Stock;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.StockService;

@Controller
@RequestMapping("/store")
public class ViewStockController {
	
		// 연결할 Service 클래스를 설정해준다.
		@Autowired
		private StockService stockService;

		@RequestMapping(value = "/stock", method = RequestMethod.GET)
		public String list(@ModelAttribute("stock") Stock stock, 
				Model model, HttpSession session, HttpServletRequest request) throws Exception
		{
			if (session.getAttribute("employerCheck") != null) session.removeAttribute("employerCheck");

			Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
			model.addAttribute("stock", stockService.getProductStock(store.getStore_id()));

			return "store/stock";
		}
}
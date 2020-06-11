package com.dongduk.myfancy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.StoreService;
import com.dongduk.myfancy.service.StoreServiceImpl;

@Controller
@SessionAttributes("storeSession")
public class LoginController {
	
	@Autowired
	private StoreServiceImpl storeService;
	
	@Autowired
	public void setStore(StoreServiceImpl storeService) {
		this.storeService = storeService;
	}
	
	@RequestMapping("/index")
	public String index(Model model) { 
		return "index";
	}
	
	@PostMapping("main")
	public ModelAndView login(HttpServletRequest request, 
			@RequestParam("id") int id, 
			@RequestParam("pw") String pw, 
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception { 
		Store store = storeService.getStoreByStoreIdAndPassword(id, pw);
		if (store == null) {
			return new ModelAndView("store/error", "message", 
					"Invalid id or password.  Login failed.");
		}
		else {
			model.addAttribute("storeSession", store);
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else
				return new ModelAndView("store/main");
		}
	}
	

}

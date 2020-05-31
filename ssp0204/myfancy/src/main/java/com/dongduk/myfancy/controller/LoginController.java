package com.dongduk.myfancy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dongduk.myfancy.domain.Store;

@Controller
public class LoginController {
	

	Store store = new Store();
	
	@RequestMapping("/index")
	public String members(Model model) { 
		return "index";
	}
	
	@PostMapping("main")
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("pw") String pw, Model model) { 
		int storeId = Integer.parseInt(id);
		if (store.getStore_id() == storeId) {
			if (store.getPassword().equals(pw)) {
				return "store/main";
			}
		}
		return "index";
	}
	

}

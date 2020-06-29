package com.dongduk.myfancy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Receive_product;
import com.dongduk.myfancy.domain.Sales;
import com.dongduk.myfancy.domain.Send;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.ReceiveService;

@Controller
@RequestMapping("/store")
public class ReceivceController {

	@Autowired
	private ReceiveService receiveService;

	// 발주 list 출력
	@RequestMapping(value = "/receive")
	public String getReceive(Model model, HttpServletRequest request) throws Exception {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		model.addAttribute("receive", receiveService.getOrderList(store.getStore_id()));

		return "store/receive/receive";
	}

	
	  // 입고확인 클릭시
	  @RequestMapping(value = "/receive/confirm")
	  @ResponseBody
	  public String confirmReceive(@RequestParam(value="checkedArr[]") List<String> checkArr, 
			  HttpServletRequest request) { 

		  Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
		  int order_id = 0, product_id = 0;
		  //arr에서 order_id, product_id 뽑아내기주기 위한 for문
		  for (int i = 0; i < checkArr.size(); i+=2) { 
			  for (int j = i; j <= i+1 ; j++) {
				  if(j % 2 == 0)
					  order_id = Integer.parseInt(checkArr.get(j));
				  else
					  product_id = Integer.parseInt(checkArr.get(j));
			  	}
			  Order_product op = receiveService.getOrderProduct(order_id, product_id);
			  
			  System.out.println("order_id: " + order_id);
			  System.out.println("product_id: " + product_id);
			  System.out.println("quantity: " + op.getQuantity());
			  System.out.println("store_id: " + store.getStore_id());
			  
			  receiveService.updateStock(op.getQuantity(), product_id, store.getStore_id(), order_id);
			  } 
		  return "redirect:/store/receive"; 
	  }
	 

	// 차이수량 조사 후 차이수량이 0이상인 물품들은 재발주
	@RequestMapping(value = "/receive/loss/reorder")
	public String postLoss(@ModelAttribute("loss") Receive_product receive, Model model, HttpServletRequest request)
			throws Exception {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		List<Receive_product> rProductList = new ArrayList<Receive_product>();

		// 차이수량이 나는 제품인 경우만 출력
		if (receive.getReceive_quantity() > 0 && receive.getLoss_quantity() > 0) {
			receiveService.insertReceiveQuantity(store.getStore_id(), rProductList);
		}
		model.addAttribute("loss", receiveService.getReceiveList(store.getStore_id()));

		// 재발주 된 뒤 입고관리 페이지로 다시 복귀
		return "redirect:/store/receive/receive";
	}
}

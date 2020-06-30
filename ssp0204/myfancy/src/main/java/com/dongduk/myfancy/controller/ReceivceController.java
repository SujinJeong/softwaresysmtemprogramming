package com.dongduk.myfancy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		
		//입고 list 출력
		@RequestMapping(value = "/receive", method = RequestMethod.GET)
		public String getReceive(
				@ModelAttribute("receive") Send send, Model model, 
				HttpSession session, HttpServletRequest request) throws Exception
		{	
			if (session.getAttribute("employerCheck") != null) session.removeAttribute("employerCheck");
			Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
			List<Order_product> oProductList = receiveService.getOrderList(store.getStore_id());
			model.addAttribute("receive", oProductList);

			return "/store/receive";
		}
		
		// 입고확인 클릭시
		@RequestMapping(value = "/receive", method = RequestMethod.POST)
		public String postReceive(@RequestParam("storeId") int storeid,
				@ModelAttribute("receive") Receive_product receive, 
				Model model, HttpSession session, HttpServletRequest request) throws Exception
		{	
			Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
			List<Receive_product> rProductList = new ArrayList<Receive_product>();
			List<Order_product> oProductList = receiveService.getOrderList(store.getStore_id());
			// 입고수량이 0이상인지 확인(0인 경우 아직 배송중) 0 보다 크면 입고목록에 추가
			if (receive.getReceive_quantity() > 0) {
				receiveService.insertReceiveQuantity(store.getStore_id(), rProductList);
			}
			if (receive.getLoss_quantity() > 0)
				receiveService.calLossQuantity(rProductList, oProductList);
			model.addAttribute("receive", rProductList);

			return "store/receive/loss";
		}
		
		// 차이수량 조사 후 재발주
		@RequestMapping(value = "/receive/loss", method = RequestMethod.POST)
		public String postLoss(@RequestParam("storeId") int storeid,
				@ModelAttribute("loss") Receive_product receive, 
				Model model, HttpSession session, HttpServletRequest request) throws Exception
		{	
			Store store = (Store)WebUtils.getSessionAttribute(request, "storeSession");
			List<Receive_product> rProductList = new ArrayList<Receive_product>();
			// 차이수량이 나는 제품인 경우만 출력
			if (receive.getReceive_quantity() > 0 && receive.getLoss_quantity() > 0) {
				receiveService.insertReceiveQuantity(store.getStore_id(), rProductList);
			}
			model.addAttribute("loss", receiveService.getReceiveList(store.getStore_id()));

			// 재발주 된 뒤 입고관리 페이지로 다시 복귀
			return "store/receive";
		}
}

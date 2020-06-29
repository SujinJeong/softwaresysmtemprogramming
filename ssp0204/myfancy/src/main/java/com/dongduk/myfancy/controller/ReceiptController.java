package com.dongduk.myfancy.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.SaleService;

@SessionAttributes("{storeSession, receipt}")
@Controller
public class ReceiptController {

	@Autowired
	SaleService saleService;

	//@ModelAttribute("receipt")
	@RequestMapping("/store/receipt")
	public String receiptForm(HttpServletRequest request, RedirectAttributes redirect, Model model) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		redirect.addAttribute("store_id", store.getStore_id());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = new java.util.Date();
		
		String date = sdf.format(dd);
		java.sql.Date d = java.sql.Date.valueOf(date); // default : 오늘 날짜(2020-06-18),,영수증 조회는 버튼 눌렀을때 
		Sale receiptForm = new Sale(); //saleRegist 역할
		String id = Integer.toString(receiptForm.getSale_id());
		String dated = dd.toString();
		//int s = Integer.parseInt(dd);
		//int ddd = (dated+id)
		//판매번호 : 날짜 + 아이디
		//receiptForm.setSale_id(dated+id);
		receiptForm.setSale_time(d);
		model.addAttribute("receipt", receiptForm);
		//redirect.addAttribute("receiptForm", receiptForm);
		return "/store/receipt/Receipt"; // 영수증 form 보내줌
	}
	

	@RequestMapping("/store/receipt/check")// 조회 버튼 ,,(날짜 입력칸 / 영수증 번호 입력칸)
	public ModelAndView receipt(@ModelAttribute("receipt") Sale receiptForm, HttpServletRequest request, RedirectAttributes redirect) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ModelAndView mav = new ModelAndView("/store/receipt/Receipt");
		
		Date receipt_date = receiptForm.getSale_time(); // 입력된 날짜(yyyy-MM-dd);
		System.out.println(receipt_date);
		List<Sale> receiptList = saleService.getSaleList(store.getStore_id(), receipt_date); // 해당 날짜의 판매 리스트(영수증 리스트)
		int input_receipt_id = receiptForm.getSale_id(); // 입력된 영수증 번호
		
		System.out.println(input_receipt_id);
		if(input_receipt_id > 1) { // 영수증 번호 입력되면 (날짜 + 판매 ID)
			//String date = sdf.format(receipt_date); // 입력된 날짜를 int로 변환
			// String input_receipt_idd = Integer.toString(input_receipt_id);
			//String receipt_id = input_receipt_idd.replace(date, ""); // 영수증 번호 - 날짜 = 판매 아이디
			List<Product> receipt = saleService.getSaleProductList(store.getStore_id(), input_receipt_id);
			mav.addObject("searchproduct", receipt);//해당하는 영수증 하나만 화면에 띄워줌
		}
		//날짜만 입력되면
		mav.addObject("receipts", receiptList); //날짜에 해당하는 모든 영수증 리스트 넘겨줌
		return mav;
	}
	
	// 처음엔 아무것도 안 뜨다가 날짜 입력하면 해당 날짜 영수증 조회
	// 하단의 영수증 조회 입력하면 해당 영수증만 조회 가능
	
}

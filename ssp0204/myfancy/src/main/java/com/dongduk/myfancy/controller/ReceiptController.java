package com.dongduk.myfancy.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@RequestMapping("/store/receipt")
	public String receiptForm(HttpServletRequest request, HttpSession session, RedirectAttributes redirect, Model model) {
		if (session.getAttribute("employerCheck") != null) session.removeAttribute("employerCheck");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		redirect.addAttribute("store_id", store.getStore_id());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = new java.util.Date();
		
		String date = sdf.format(dd);
		java.sql.Date d = java.sql.Date.valueOf(date); // default : 오늘 날짜 
		Sale receiptForm = new Sale(); //saleRegist 역할
		receiptForm.setSale_time(d);
		model.addAttribute("receipt", receiptForm);
		return "/store/receipt/Receipt"; // 영수증 form 보내줌
	}
	

	@RequestMapping("/store/receipt/check")// 조회 버튼 (날짜 입력칸 / 판매 번호 입력칸)
	public ModelAndView receipt(@ModelAttribute("receipt") Sale receiptForm, HttpServletRequest request, RedirectAttributes redirect) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		ModelAndView mav = new ModelAndView("/store/receipt/Receipt");
		
		Date receipt_date = receiptForm.getSale_time(); // 입력된 날짜(yyyy-MM-dd);
		System.out.println(receipt_date);
		List<Sale> receiptList = saleService.getSaleList(store.getStore_id(), receipt_date); // 해당 날짜의 판매 리스트(영수증 리스트)
		int input_receipt_id = receiptForm.getSale_id(); // 입력된 영수증 번호
		
		System.out.println(input_receipt_id);
		if(input_receipt_id > 1) { // 영수증 번호 입력되면 (날짜 + 판매 ID)
			List<Product> receipt = saleService.getSaleProductList(store.getStore_id(), input_receipt_id);
			mav.addObject("searchproduct", receipt);//해당하는 영수증 하나만 화면에 띄워줌
		}
		// 날짜만 입력되면
		mav.addObject("receipts", receiptList); //날짜에 해당하는 모든 영수증 리스트 넘겨줌
		return mav;
	}
}

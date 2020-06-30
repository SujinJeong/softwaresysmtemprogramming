package com.dongduk.myfancy.controller;

import java.text.ParseException;
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

   @RequestMapping("/store/receipt")
   public String receiptForm(HttpServletRequest request, RedirectAttributes redirect, Model model) {
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
   

<<<<<<< HEAD
   @RequestMapping("/store/receipt/check")// 조회 버튼 (날짜 입력칸 / 판매 번호 입력칸)
   public ModelAndView salelist(@ModelAttribute("receipt") Sale receiptForm, HttpServletRequest request, RedirectAttributes redirect) {
      Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
      ModelAndView mav = new ModelAndView("/store/receipt/Receipt");
      
      Date receipt_date = receiptForm.getSale_time(); // 입력된 날짜(yyyy-MM-dd);
      System.out.println(receipt_date);
      List<Sale> receiptList = saleService.getSaleList(store.getStore_id(), receipt_date); // 해당 날짜의 판매 리스트(영수증 리스트)
      // 날짜만 입력되면
      mav.addObject("receipts", receiptList); //날짜에 해당하는 모든 영수증 리스트 넘겨줌
      return mav;
   }
   
   @RequestMapping("/store/receipt/viewReceipt")// 판매번호로 상세조회
   public ModelAndView receipt(@RequestParam("sale_id") int sale_id,@RequestParam("sale_time") String sale_time,
         @ModelAttribute("receipt") Sale receiptForm, HttpServletRequest request, RedirectAttributes redirect) throws ParseException {
      Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
      ModelAndView mav = new ModelAndView("/store/receipt/Receipt");
      //String을 Date로 변환
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date date = sdf.parse(sale_time);
      
      if(sale_id > 1) { // 영수증 번호 입력되면 (날짜 + 판매 ID)
         List<Product> receipt = saleService.getSaleProductList(store.getStore_id(), sale_id);
         mav.addObject("receipts", saleService.getSaleList(store.getStore_id(), date)); //날짜에 해당하는 모든 영수증 리스트 넘겨줌
         mav.addObject("searchproduct", receipt); //해당하는 영수증 하나만 화면에 띄워줌
         mav.addObject("sale_id", sale_id);
      }
      return mav;
   }
}
=======
	@RequestMapping("/store/receipt/check")// 조회 버튼 (날짜 입력칸 / 판매 번호 입력칸)
	public ModelAndView salelist(@ModelAttribute("receipt") Sale receiptForm, HttpServletRequest request, RedirectAttributes redirect) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		ModelAndView mav = new ModelAndView("/store/receipt/Receipt");
		
		Date receipt_date = receiptForm.getSale_time(); // 입력된 날짜(yyyy-MM-dd);
		System.out.println(receipt_date);
		List<Sale> receiptList = saleService.getSaleList(store.getStore_id(), receipt_date); // 해당 날짜의 판매 리스트(영수증 리스트)
		// 날짜만 입력되면
		mav.addObject("receipts", receiptList); //날짜에 해당하는 모든 영수증 리스트 넘겨줌
		return mav;
	}
	
	@RequestMapping("/store/receipt/viewReceipt")// 판매번호로 상세조회
	public ModelAndView receipt(@RequestParam("sale_id") int sale_id,@RequestParam("sale_time") String sale_time,
			@ModelAttribute("receipt") Sale receiptForm, HttpServletRequest request, RedirectAttributes redirect) throws ParseException {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		ModelAndView mav = new ModelAndView("/store/receipt/Receipt");
		//String을 Date로 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sale_time);
		
		if(sale_id > 1) { // 영수증 번호 입력되면 (날짜 + 판매 ID)
			List<Product> receipt = saleService.getSaleProductList(store.getStore_id(), sale_id);
			mav.addObject("receipts", saleService.getSaleList(store.getStore_id(), date)); //날짜에 해당하는 모든 영수증 리스트 넘겨줌
			mav.addObject("searchproduct", receipt); //해당하는 영수증 하나만 화면에 띄워줌
			mav.addObject("sale_id", sale_id);
		}
		return mav;
	}
}
>>>>>>> refs/remotes/origin/develop

package com.dongduk.myfancy.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Payment;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Sale;
import com.dongduk.myfancy.domain.Sale_product;
import com.dongduk.myfancy.domain.Stock;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.ProductService;
import com.dongduk.myfancy.service.SaleService;
import com.dongduk.myfancy.service.StockService;

//상품들 목록 출력, 카테고리별 출력, 카트에 물품담기, 수량조사, 결제, 결제완료, 결제취소
@Controller
@SessionAttributes("sessionSaleCart")
@RequestMapping("/store/sale")
public class SaleController {

	@Autowired
	private ProductService productService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private StockService stockService;
	
	// 판매관리 누르면 물품들 보여주는 메소드
	@RequestMapping("/view")
	public ModelAndView viewProduct(HttpServletRequest request, @ModelAttribute("sessionSaleCart") Cart cart, Model model) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		List<Product> productList = productService.getProductList(store.getStore_id());
		List<Product> stockList = stockService.getProductStock(store.getStore_id());
		
		for ( int i = 0; i < productList.size(); i++) {
			productList.get(i).setQuantity(stockList.get(i).getQuantity());
			System.out.println(productList.get(i).getQuantity());
		}
	
		List<Product> soldoutList = new ArrayList<Product>();
		for ( int i = 0; i < stockList.size(); i ++) {
			if ( stockList.get(i).getQuantity() <= 0)
				soldoutList.add(stockList.get(i));
		}
		
		WebUtils.setSessionAttribute(request, "soldout", soldoutList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("store/sale/Sale");
		mv.addObject("productList", productList);
		mv.addObject("soldoutList",soldoutList);
		mv.addObject("sessionSaleCart", cart);
		return mv;
	}

	// 카트 객체 생성 및 세션으로 관리 -> 모든 request에 대해 handler method보다 먼저 호출됨 .. session이 있으면 호출안됨
	@ModelAttribute("sessionSaleCart")
	public Cart createCart(HttpSession session) {
		return new Cart();
	}
	
	// 선택한 물품 카트에 담는 메소드
	@RequestMapping("/addSaleProducts")
	public String addSaleProducts(@ModelAttribute("sessionSaleCart") Cart cart,
			@RequestParam("product_id") int product_id, HttpServletRequest request, Model model,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		Product product = productService.getProduct(product_id);
		List<Product> stockList = stockService.getProductStock(store.getStore_id());
		
		boolean contain = false; //카트에 이미 담겨있는지 확인하는 값
		int key = 0;	//카트에 담긴 물품의 수량
	
		Product stockProduct = stockService.getOneProductStock(store.getStore_id(), product_id);
	
		int productStock = stockProduct.getQuantity();
		
		if ( productStock > 0) {			//선택한 상품의 재고가 0보다 많을 때 실행됨
			if (cart.getCartList() == null) {
				cart.addProductForSale(product, 1);	//카트에 물품이 존재하지않으면 선택한 물품이 수량 1로 들어감 
			} else {	//카트에 물품이 담겨있으면
				for (Product p : cart.getCartList().keySet()) {	//카트리스트에 담겨있는 물품들 가져옴
					if (p.getProduct_id() == product_id) {	//선택한 물품의 id와 카트에 담겨있는 id가 같으면(카트에 동일상품이 있으면)
						contain = true;
						key = cart.getCartList().get(p);//카트안에 담겨있는 물품의 수량(key) 가져옴
						if ( productStock < (key+1)) {		//상품재고 보다 카트 수량이 하나 더 많다면			
							throw new Exception();
						}
					}
				}
			}
				if (contain) {	//선택한 물품이 카트에 이미 담겨있으면 수량 1 증가
					cart.addProductForSale(cart.findProduct(cart.getCartList(), product_id), key+1);
				} else {
					cart.addProductForSale(product, 1);			
				}
			}
		mv.setViewName("/store/sale/Sale");
		mv.addObject("cart", cart);
		return "redirect:/store/sale/view";
	}
	
	@RequestMapping(value="/payment")
	public ModelAndView payment(@RequestParam("payment_code") int payment_code,
			@RequestParam("amount") int amount, HttpServletRequest request) {
		
		Cart cart = (Cart) WebUtils.getSessionAttribute(request, "sessionSaleCart");
		ModelAndView mv = new ModelAndView();
			
		String codename = "카드결제";   //버튼 값
		String type = "submit";   //버튼 타입
		Payment payment = new Payment(cart.getSubSaleTotal());
		
		if (payment_code == 1) {   //카드 결제
			payment.setCardAmount(amount);
	        if (payment.getAmount() == amount) {   //카드로 전부 결제 
	        	type = "button";   //일반 버튼 타입으로 변경
	            codename = "완료";   //버튼 값 '완료'라고 변경
	        } else   //카드로 결제 후 남은 금액 있을 시(현금결제 해야함)
	            codename = "현금결제";   
	        payment.setAmount(payment.getAmount()-payment.getCardAmount());
	        
	        payment.setPayment_code(payment_code);
	        mv.addObject("codename", codename);
	        mv.addObject("type", type);
	     } else if (payment_code == 2){   //현금 결제
	    	 payment.setCashAmount(amount);
	         payment.setCardAmount(payment.getAmount()-payment.getCashAmount());
	         payment.setAmount(0);
	         payment.setPayment_code(payment_code);
	         type = "button";
	         codename = "완료";
	         mv.addObject("codename", codename);
	         mv.addObject("type", type);
	      } else {   //paymentcode == 0 (컨트롤러에서 여기로 바로 들어옴)
	         payment.setAmount(amount);
	         mv.addObject("codename", codename);
	         mv.addObject("type", type);
	     
	      }
	      mv.addObject("payment", payment);
	      request.setAttribute("payment", payment);
	      mv.setViewName("store/sale/Payment");
	      return mv;
	   }

	@RequestMapping("/remove") // 물품담는 창에서 취소 눌렀을 때 (동작함)
	public String removeCart(HttpServletRequest request) {
		Cart cart = (Cart) WebUtils.getSessionAttribute(request, "sessionSaleCart");
		cart.removeSale();
		return "redirect:/store/sale/view";
	}

	@RequestMapping("/receipt") // 결제완료 눌렀을 때 영수증 간략하게 보여주는 메소드
	public ModelAndView viewReceipt(HttpServletRequest request, SessionStatus sessionStatus) {
		Cart cart = (Cart) WebUtils.getSessionAttribute(request, "sessionSaleCart");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		Sale s = new Sale();
		s.setStore_id(store.getStore_id());
		s.setTotalamount(cart.getSubSaleTotal());
		saleService.insertSale(s);
		//cart 내 물품들 saleProduct에 insert하기
		Set<Entry<Product, Integer>> set = cart.getCartList().entrySet();
		Iterator<Entry<Product,Integer>> itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry<Product, Integer> e = (Map.Entry<Product, Integer>)itr.next();
			Sale_product sp = new Sale_product(e.getKey().getProduct_id(),s.getSale_id(),e.getValue());
			saleService.insertSaleProduct(sp);
		}
		List<Product> list = saleService.getSaleProductList(store.getStore_id(), s.getSale_id());
		//판매완료된 상품들 재고 마이너스
		for (int i = 0; i < list.size(); i++) {
			Product p = productService.getProduct(list.get(i).getProduct_id());
			p.setQuantity(p.getQuantity()-list.get(i).getQuantity());
			System.out.println(p.getQuantity());
			stockService.updateStock(p.getQuantity(), p.getProduct_id(), store.getStore_id());
		}		
		ModelAndView mv = new ModelAndView();
		mv.addObject("sale", s);
		mv.addObject("sp", list);
		mv.setViewName("store/sale/Receipt");
		WebUtils.setSessionAttribute(request, "sessionSaleCart", null);
		return mv;
	}
}

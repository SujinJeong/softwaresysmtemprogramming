package com.dongduk.myfancy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.service.ProductService;
import com.dongduk.myfancy.service.SaleService;

//상품들 목록 출력, 카테고리별 출력, 카트에 물품담기, 수량조사, 결제, 결제완료, 결제취소
@Controller
@SessionAttributes("sessionSaleCart")
@RequestMapping("/store/sale")
public class SaleController {

	@Autowired
	private ProductService productService;
	@Autowired
	private SaleService saleService;

	// 판매관리 누르면 물품들 보여주는 메소드 (동작함)
	@RequestMapping("/view")
	public ModelAndView viewProduct(HttpServletRequest request) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		List<Product> productList = productService.getProductList(store.getStore_id());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("store/sale/Sale");
		mv.addObject("productList", productList);
		return mv;
	}

	// 카테고리별로 물품들 보여주는 메소드
	public ModelAndView viewProductByCategory(@RequestParam("category_id") int category_id) {
		List<Product> productListByCategory = productService.getProductListByCategory(category_id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("store/sale/Sale");
		mv.addObject("productListByCategory", productListByCategory);
		return mv;
	}

	// 카트 객체 생성 및 세션으로 관리 -> 모든 request에 대해 handler method보다 먼저 호출됨 .. session이 있으면
	// 호출안됨
	@ModelAttribute("sessionSaleCart")
	public Cart createCart(HttpSession session) {
		System.out.println("createCart들어옴");
		Cart cart = (Cart) session.getAttribute("sessionSaleCart");
		if (cart != null) {
			System.out.println("카트존재");
		}
		if (cart == null) {
			cart = new Cart();
		}
		System.out.println("카트생성");
		return cart;
	}

	// 선택한 물품 카트에 담는 메소드
	@RequestMapping("/addSaleProducts")
	public String addSaleProducts(@ModelAttribute("sessionSaleCart") Cart cart,
			@RequestParam("product_id") int product_id, Model model) {

		Product product = productService.getProduct(product_id);
		System.out.println("물품추가");

		cart.addProductForSale(product);
		// cart.setQuantity(quantity);
		// Cart.java 중 checkInStock에서 구현
//		int insertQuantity = 소비자 수량 입력값(view에서 가져옴);
//		int productQuantity = product.getQuantity();
//			
//		if (insertQuantity > productQuantity) {
//			String msg = "상품 " + product.getProduct_name() +"의 개수가 모자랍니다.\n재고 : " + productQuantity;
//			mv.addObject("message", msg);
//		}	
//		else {
//			cart.setQuantityByProductId(insertQuantity);
//		}

//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/store/sale/Sale");
//		mv.addObject("cart", cart);
		return "redirect:/store/sale/view";
	}

//	@GetMapping("/payment") 
//	public ModelAndView payment(HttpServletRequest request) {
//		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession"); 
//		Cart cart = (Cart)WebUtils.getSessionAttribute(request, "sessionSaleCart"); 
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("cart", cart); 
//		mv.setViewName("store/sale/Payment"); 
//		return mv;
//	}
//	@GetMapping("/payment") 
//	public String payment(HttpServletRequest request,Model model) {
//		Cart cart = (Cart)WebUtils.getSessionAttribute(request, "sessionSaleCart"); 
//		model.addAttribute("cart");
//		return "store/sale/Payment";
//	}
	@RequestMapping(value="/payment",method=RequestMethod.GET) 
	public String payment() {
		return "store/sale/Payment";
	}

//	@RequestMapping(value="/payment",method=RequestMethod.POST)
//	public ModelAndView makeSale(HttpServletRequest request, 
//			@RequestParam("payment_code") int payment_code,
//			@RequestParam("amount") int amount)
	
	@RequestMapping(value="/payment",method=RequestMethod.POST)
	public ModelAndView makeSale(HttpServletRequest request, 
			@RequestParam(value="payment_code", required=false) int payment_code,
			@RequestParam(value="amount", required=false) int amount) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		Cart cart = (Cart) WebUtils.getSessionAttribute(request, "sessionSaleCart");
		if (payment_code == 1) { // 카드 결제
			int price = cart.getSubSaleTotal();
			int cardPrice = price - amount;

		} else { // 현금결제

		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("store/sale/Payment");

		return mv;
	}

	@RequestMapping("/remove") // 물품담는 창에서 취소 눌렀을 때 (동작함)
	public String removeCart(HttpServletRequest request, SessionStatus sessionStatus) {
		Cart cart = (Cart) WebUtils.getSessionAttribute(request, "sessionSaleCart");
		cart.removeSale(); // cart내 물품 삭제
		sessionStatus.setComplete();// session에서 객체 참조 삭제
		return "redirect:/store/sale/view";
	}

	@RequestMapping("/receipt") // 결제완료 눌렀을 때 영수증 간략하게 보여주는 메소드
	public ModelAndView viewReceipt(HttpServletRequest request) {
		Cart cart = (Cart) WebUtils.getSessionAttribute(request, "sessionSaleCart");

		ModelAndView mv = new ModelAndView();
//		mv.addObject("cart", cart);
		// sale, saleProduct 만들어서 넘겨주기
		mv.setViewName("store/sale/Receipt");
		return mv;
	}

}

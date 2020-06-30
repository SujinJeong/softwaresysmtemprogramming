package com.dongduk.myfancy.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Order;
import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.domain.Supplier;
import com.dongduk.myfancy.service.OrderService;
import com.dongduk.myfancy.service.ProductService;
import com.dongduk.myfancy.service.SupplierService;

@SessionAttributes("{storeSession, orderProducts, sessionOrderCart}") // order 내부의 session 별도로 또 사용(입력한 값 받아오도록)
@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@Autowired
	SupplierService supplierService;
	
	@Autowired
	ProductService productService;
	
	  //카트 객체 생성 및 세션으로 관리 -> 모든 request에 대해 handler method보다 먼저 호출됨
	   @ModelAttribute("sessionOrderCart")
	   public Cart createCart(HttpSession session) {
	      Cart cart = (Cart)session.getAttribute("sessionOrderCart");
	      if (cart == null) 
	    	  cart = new Cart();
	      return cart;
	   }
	   
	@RequestMapping("/store/order") //main.jsp에서 Order.jsp로 이동
	public String orderProduct(HttpServletRequest request, Model model, RedirectAttributes redirect) {
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		//Cart cart = new Cart();
		Order order = new Order();
		List<Order> orderlist = orderService.getOrderListByStore(store_id);
		order.setOrder_id(orderlist.size() + 1);
		order.setStore_id(store_id);
		List<Supplier> supplierList = supplierService.getSupplierList();// 거래처 리스트
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("order", order);
		redirect.addAttribute("store_id", store_id);
		//redirect.addAttribute("cart", cart); // error
		return "/store/order/Order"; // 발주 관리 화면
	}
	

//	@RequestMapping(method = RequestMethod.POST) // 거래처 선택했을때 controller에 들어와서 해당하는 물품들 다시 뷰에 출력해줌
//	public String orderProductList(HttpServletRequest request, Model model, RedirectAttributes redirect) {
//		String selectedSupplier = request.getParameter("supplierList");
//		List<Supplier> supplierList = supplierService.getSupplierList();
//		int supplier_id = 0;
//		for(int i = 0; i < supplierList.size(); i++) {
//			if(supplierList.get(i).getSupplier_name().equals(selectedSupplier)) {
//				supplier_id = supplierList.get(i).getSupplier_id();
//				break;
//			}
//		}
//		List<Product> productList = supplierService.getProductListBySupplier(supplier_id);	
//		//redirect.addAttribute(attributeName, attributeValue)
//		model.addAttribute("productList", productList);
//		//product 리스트를 객체 리스트로 보내서 그 값을 다시 가져와
//		return "/store/order/Order";
//	}
	
	//@ModelAttribute("orderProducts") // 거래처 선택했을때 url?action확실하게해주기..
	@RequestMapping("/store/order/selected/{supplier_name}")
	// 거래처 선택했을때 controller에 들어와서 해당하는 물품들 다시 뷰에 출력해줌
	public String productList(HttpServletRequest request, Model model,
			@PathVariable("supplier_name") String selectedSupplier, RedirectAttributes redirect){ //,  @RequestParam("supplier") String selectedSupplier
		//String selectedSupplier = request.getParameter("supplierList");
		//선택된 거래처값 고정되어야함
		List<Supplier> supplierList = supplierService.getSupplierList();
		int supplier_id = 0;
		for(int i = 0; i < supplierList.size(); i++) {
			if(supplierList.get(i).getSupplier_name().equals(selectedSupplier)) { // 선택한 거래처
				supplier_id = supplierList.get(i).getSupplier_id();
				break;
			}
		}
		//System.out.println(supplier_id); // 1
		List<Product> orderProducts = supplierService.getProductListBySupplier(supplier_id);	
		// 거래처의 해당 발주 물품들을 가져오는데 폼으로 활용하기 위해서 일단 수량을 0으로 초기화해서 보냄
		for(int i = 0; i < orderProducts.size(); i++) { 
			orderProducts.get(i).setQuantity(0);// 수량 0으로 초기화해서 보내
		}
		//redirect.addAttribute("supplier_id",supplier_id);
		model.addAttribute("orderProducts", orderProducts);
		return "store/order/Order";
		//product 리스트를 객체 리스트로 보내서 그 값을 다시 가져와
	}
	
	//error발생
	@RequestMapping("/store/order/addOrderProducts") // 발주 물품 담기 (cart에 담기)누르는 순간 발주 생성됨
	public String addOrderProducts(HttpServletRequest request, 
			@ModelAttribute("orderProducts") List<Product> productList, 
			@ModelAttribute("sessionOrderCart") Cart cart, Model model, RedirectAttributes redirect) {
		//현재 화면에 해당하는 거래처, 물품 리스트
//		for(int i = 0; i < productList.size(); i++) { 
//			System.out.println(productList.get(i).getProduct_name());// 출력안됨
//		}
		String selectedSupplier = request.getParameter("supplierList");
		List<Product> cartList = new ArrayList<Product>();
		for(int i = 0; i < productList.size(); i++) { // 거래처의 발주 물품들
			int order_product_quantity = productList.get(i).getQuantity();//form에서의 수량
			if(order_product_quantity > 0) {
				int product_id = productList.get(i).getProduct_id();
				Product product = productService.getProduct(product_id);
				cart.addProductForOrder(product, order_product_quantity);
				cartList.add(product);//왜하는거...? -> 카트에 담은 상품의 거래처, 상품명, 수량, 가격을 위하여,,
			}
		}
		model.addAttribute("cartList", cartList); // 왜험..?
		model.addAttribute("supplierName", selectedSupplier);
		//model.addAttribute("cart", cart);
		redirect.addAttribute("cart", cart); 
		return "store/order/Order";
	}							
	
//	@RequestMapping("/store/order/requestOrder") // 발주 등록
//	public String requestOrder(@ModelAttribute("sessionOrderCart") Cart cart, @RequestParam("store_id") int store_id, @RequestParam("order") Order order, Model model){
//		int total = 0;Product product = null;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String date = sdf.format(new java.util.Date());
//		java.sql.Date d = java.sql.Date.valueOf(date);
//		order.setOrder_date(d); // 현재 시각
//		List<Order_product> orderProductList = new ArrayList<Order_product>();//발주 상품 리스트
//		Map<Product, Integer> cartList = cart.getCartList(); // cart에 담긴 물품들
//		List<String[]> ol = new ArrayList<String[]>();
//		for(Map.Entry<Product, Integer> elem : cartList.entrySet()) { // cart에 담긴 물품들 발주
//			int product_id = elem.getKey().getProduct_id();
//			int order_product_quantity = elem.getValue();
//			product = productService.getProduct(product_id);
//			Order_product orderproduct = new Order_product();
//			orderproduct.setOrder_id(order.getOrder_id());
//			orderproduct.setProduct_id(product_id);
//			orderproduct.setQuantity(order_product_quantity);
//			orderProductList.add(orderproduct);
//			int supplier_id = elem.getKey().getSupplier_id();
//			Supplier s = supplierService.getSupplier(supplier_id);
//			String[] confirmed = new String[4];
//			confirmed[0] = s.getSupplier_name();
//			confirmed[1] = product.getProduct_name();
//			confirmed[2] = Integer.toString(order_product_quantity);
//			int result = order_product_quantity * product.getOrder_price();
//			confirmed[3] = Integer.toString(result);
//			ol.add(confirmed);
//		}
//		total = cart.getSubOrderTotal(product); // 카트에 담긴 총 금액
//		order.setAmount(total); // 발주 총 금액
//		orderService.insertOrder(orderProductList, store_id, order.getAmount());
//		orderService.insertOrderProduct(cart); // 굳이 필요한가,,?
//		model.addAttribute("order", order);
//		model.addAttribute("orderProductList", ol);
//		return "/store/order/confirmOrder";
//		//return "order/confirmOrder";
//	}
	
	// V
	@RequestMapping(value = {"/store/order/requestCancel" , "/store/order/confirmedComplete"}) // 발주 등록 취소,,main으로 돌아감
	public String requestCancel(){
		return "/store/main";
		//return "Main";
	}
	
}

package com.dongduk.myfancy.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Cart;
import com.dongduk.myfancy.domain.Order;
import com.dongduk.myfancy.domain.OrderCart;
import com.dongduk.myfancy.domain.Order_product;
import com.dongduk.myfancy.domain.Product;
import com.dongduk.myfancy.domain.Store;
import com.dongduk.myfancy.domain.Supplier;
import com.dongduk.myfancy.service.OrderService;
import com.dongduk.myfancy.service.ProductService;
import com.dongduk.myfancy.service.SupplierService;

@Controller
public class OrderController { 
	
	@Autowired
	OrderService orderService;

	@Autowired
	SupplierService supplierService;
	
	@Autowired
	ProductService productService;


	@ModelAttribute("orderProducts")
	public List<OrderCart> orderProductList(HttpServletRequest request, Model model){
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		List<Product> plist = productService. getProductList(store.getStore_id());
		List<OrderCart> cart = new ArrayList<OrderCart>();	
	
		 for(int i = 0; i < plist.size(); i++) { 
			OrderCart oc = new OrderCart();
		  oc.setProductName(plist.get(i).getProduct_name());
		  oc.setProductId(plist.get(i).getProduct_id());
		  oc.setSupplierId(plist.get(i).getSupplier_id()); //oc.setSupplierName("");
		  oc.setOrderPrice(plist.get(i).getOrder_price()); //int q = 0;
		  //oc.setQuantity(q); // 잡아봐 
		  cart.add(i, oc); 
		 }
		 System.out.println("물품리스트들"); 
		return cart;
	}
	
	@ModelAttribute("supplierList") 
	public List<Supplier> supplier(Model model){
		System.out.println("거래처 리스트 생성 완료"); 
		List<Supplier> sList = supplierService.getSupplierList();
		model.addAttribute("supplierList", sList);
		return sList; // 발주 관리 화면
	}

	@RequestMapping("/store/order") //main.jsp에서 Order.jsp로 이동
	public ModelAndView orderProduct(HttpServletRequest request, 
			RedirectAttributes redirect) {
		//발주관리창으로 들어오는 첫번째,,,-> 카트 처음 만든다는 의미,,모든게 처음임
		ModelAndView mav = new ModelAndView("/store/order/Order");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		List<OrderCart> cart = new ArrayList<OrderCart>(); // 오른쪽에 쌓일 카트,,
		WebUtils.setSessionAttribute(request, "cart", cart); // 1,1:화면 맨 처음 들어올때 세션 카트 만들어줌!
		Order order = new Order();
		List<Order> orderlist = orderService.getOrderListByStore(store_id);
		order.setOrder_id(orderlist.size() + 1);
		order.setStore_id(store_id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new java.util.Date());
		java.sql.Date ddate = java.sql.Date.valueOf(date);
		order.setOrder_date(ddate); //어차피 맨 마지막에 덮어씌울거야,오른쪽 화면의 날짜를 위한 값임
		WebUtils.setSessionAttribute(request, "order", order); // 마지막까지 발주값 지녀
		mav.addObject("order", order);
		System.out.println("화면으로 이동");
		return mav; // 발주 관리 화면
	}

	//거래처 선택할때마다 여기로 들어오는데 리스트 화면에서 사라짐
	@RequestMapping(value = "/store/order/selected/{supplier_id}", method = RequestMethod.GET)
	public String selectedSupplier(HttpServletRequest request, @PathVariable("supplier_id") int supplier_id,
			 @ModelAttribute("orderProducts") List<OrderCart> list,
			Model model) {
		List<OrderCart> cartList = (List<OrderCart>) WebUtils.getSessionAttribute(request, "cart");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		List<Product> plist = productService. getProductList(store.getStore_id()); // all products..
		model.addAttribute("id", supplier_id);
		model.addAttribute("orderProducts", list); // 물품리스트들
		System.out.println("카트에 담긴 물품 수 : " + cartList.size());
		if(cartList.size() > 0)  // 하나라도 담겨있으면 거래처 눌러도 오른쪽에 또 뜨도록,,
			model.addAttribute("cartList", cartList);
		return "/store/order/Order"; // 해당 거래처에 해당하는 물품리스트들로 갱신해서 다시 보내주고 수량 배열,,,인덱스 맞춰서,,,?
	}

	
	
	
	
	
	
	//수량에 0 미만의 값 입력,,에러 검증
	@RequestMapping(value = "/store/order/addOrderProducts", method = RequestMethod.POST) // 발주 물품 담기 (cart에 담기)누르는 순간 발주 생성됨
	public String addOrderProducts(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("orderProducts") List<OrderCart> productList, // form에서 건너온 물품리스트들
			@RequestParam("supplierId") int supplier_id,
			Model model) {
		//현재 화면에 해당하는 거래처, 물품 리스트
		List<OrderCart> cartList = (List<OrderCart>) WebUtils.getSessionAttribute(request, "cart");
		
		Supplier s = supplierService.getSupplier(supplier_id);
		int total=0;//order에 넣을 가격을 위하여,,총가격
		boolean same=false;
		for(int i = 0; i < productList.size(); i++) { // 거래처의 발주 물품들,,총 물품수량 출력됨,,물품리스트들
			String input = request.getParameter(Integer.toString(i)); // 입력한 수량
			//동일한 상품 카트에 이미 존재하면 수량만 증가시켜줘야함
			if(input!=null) { // 수량 입력된 것들 중에
				int quantity = Integer.parseInt(input);
				if(quantity > 0) { // 0 초과인 것만,,오른쪽에 들어갈 것들만,,
					int product_id = productList.get(i).getProductId();
					
					for(int j = 0; j < cartList.size(); j++) { // 카트 안에 이미 존재하면
						if(cartList.get(j).getProductId() == product_id) {
							cartList.get(j).setQuantity(cartList.get(j).getQuantity() + quantity);
							total += quantity*cartList.get(j).getOrderPrice();
							same=true;
							break;
						}
					}
					if(same==true)
						break;
					OrderCart oc = new OrderCart();
					oc.setSupplierName(s.getSupplier_name()); 
					oc.setSupplierId(supplier_id);
					oc.setProductName(productList.get(i).getProductName());
					oc.setProductId(product_id);
					int price =productList.get(i).getOrderPrice();
					int q = quantity;
					oc.setOrderPrice(price);
					oc.setQuantity(q); // 입력한 수량
					total += price*q; // 방금 누른것의실질적 금액
					cartList.add(oc);
				}
				if(quantity < 0) {//마이너스 값 입력시,,에러,,
					//해당 물품 이름 지정해주고 수량 음수는 안된다고 alert 발생
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out;
					try {
						out = response.getWriter();
						out.println("<script>alert('수량은 0 미만의 수를 입력할 수 없습니다.');</script>");
						out.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//return "redirect:/store/order/selected/" + supplier_id; // 다시 돌아가는데 아무 말 없이 돌아감
					
				}
			}
			//만약 카트에 동일 물품 존재한다면 수량 증가
			
		}//수량 0 초과인 물품들만 넣어주기
		

		Order order = (Order)WebUtils.getSessionAttribute(request, "order");
		int cartTotalPrice = 0;
		cartTotalPrice = total + order.getAmount(); // 지금까지의 발주금액 + 방금 담기 누른 것들의 금액
		
		
		order.setAmount(cartTotalPrice); // cart가 세션에 존재한다는 증거임,,
		model.addAttribute("order", order);
		model.addAttribute("cartList", cartList); // 갱신(생성/축적)
		WebUtils.setSessionAttribute(request, "order", order); // 갱신
		WebUtils.setSessionAttribute(request, "cart", cartList); // 갱신
		return "/store/order/Order";
	}							
	
	@RequestMapping("/store/order/requestOrder") // 발주 등록
	public ModelAndView requestOrder(HttpServletRequest request, 
			Model model){
		ModelAndView mav = new ModelAndView("/store/order/confirmOrder");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		Order order = (Order) WebUtils.getSessionAttribute(request, "order");
		List<OrderCart> cartList = (List<OrderCart>) WebUtils.getSessionAttribute(request, "cart");

		int store_id = store.getStore_id();
		int total = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new java.util.Date());
		java.sql.Date d = java.sql.Date.valueOf(date);
		order.setOrder_date(d); // 발주 등록버튼 누른 순간 현재 시각이 발주시간으로 들어감
			
		orderService.insertOrder(order);
		//order_id넣어줘,,이미order의amount계산되어있음
	
		for(int i = 0; i < cartList.size(); i++) { // order에 쌓인 orderProduct들,,
			//Order_product o = orderProductList.get(i);
			//System.out.println(cartList.get(i).getSupplierName());
			Order_product op = new Order_product();
			op.setProduct_id(cartList.get(i).getProductId());
			op.setOrder_id(order.getOrder_id());
			op.setQuantity(cartList.get(i).getQuantity());
			orderService.insertOrderProduct(op);
		}
		
		mav.addObject("order", order);
		//model.addattribute("cart", cartList);
		mav.addObject("orderProductList", cartList); // 찐 발주 목록
		return mav;
		//return "order/confirmOrder";
	}
	
	// V
	@RequestMapping(value = {"/store/order/requestCancel" , "/store/order/confirmedComplete"}) // 발주 등록 취소,,main으로 돌아감
	public String requestCancel(){
		return "/store/main";
		//return "Main";
	}
	
}

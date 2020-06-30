package com.dongduk.myfancy.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

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
	public List<OrderCart> orderProductList(HttpServletRequest request){
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		List<Product> plist = productService. getProductList(store.getStore_id());
		List<OrderCart> cart = new ArrayList<OrderCart>();	
	
		 for(int i = 0; i < plist.size(); i++) { 
			OrderCart oc = new OrderCart();
			  oc.setProductName(plist.get(i).getProduct_name());
			  oc.setProductId(plist.get(i).getProduct_id());
			  oc.setSupplierId(plist.get(i).getSupplier_id());
			  oc.setOrderPrice(plist.get(i).getOrder_price()); 
			  cart.add(i, oc); 
		 }
		return cart;
	}
	
	@ModelAttribute("supplierList") 
	public List<Supplier> supplier(Model model){
		List<Supplier> sList = supplierService.getSupplierList();
		model.addAttribute("supplierList", sList);
		return sList;
	}

	@RequestMapping("/store/order")
	public ModelAndView orderProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/store/order/Order");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		int store_id = store.getStore_id();
		List<OrderCart> cart = new ArrayList<OrderCart>(); 
		WebUtils.setSessionAttribute(request, "cart", cart); 
		Order order = new Order();
		List<Order> orderlist = orderService.getOrderListByStore(store_id);
		order.setOrder_id(orderlist.size() + 1);
		order.setStore_id(store_id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new java.util.Date());
		java.sql.Date ddate = java.sql.Date.valueOf(date);
		order.setOrder_date(ddate); 
		WebUtils.setSessionAttribute(request, "order", order);
		mav.addObject("order", order);
		return mav; 
	}

	@RequestMapping(value = "/store/order/selected/{supplier_id}", method = RequestMethod.GET)
	public String selectedSupplier(HttpServletRequest request, @PathVariable("supplier_id") int supplier_id,
			 @ModelAttribute("orderProducts") List<OrderCart> list,
			Model model) {
		List<OrderCart> cartList = (List<OrderCart>) WebUtils.getSessionAttribute(request, "cart");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		List<Product> plist = productService. getProductList(store.getStore_id()); 
		model.addAttribute("id", supplier_id);
		model.addAttribute("orderProducts", list); 
		if(cartList.size() > 0) 
			model.addAttribute("cartList", cartList);
		return "/store/order/Order";
	}

	@RequestMapping(value = "/store/order/addOrderProducts", method = RequestMethod.POST)
	public String addOrderProducts(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("orderProducts") List<OrderCart> productList,
			@RequestParam("supplierId") int supplier_id,
			Model model) {
		
		List<OrderCart> cartList = (List<OrderCart>) WebUtils.getSessionAttribute(request, "cart");
		
		Supplier s = supplierService.getSupplier(supplier_id);
		int total=0;
		boolean same=false;
		for(int i = 0; i < productList.size(); i++) { 
			String input = request.getParameter(Integer.toString(i)); 
			
			if(input!=null) {
				int quantity = Integer.parseInt(input);
				if(quantity > 0) { 
					int product_id = productList.get(i).getProductId();
					
					for(int j = 0; j < cartList.size(); j++) {
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
					oc.setQuantity(q); 
					total += price*q; 
					cartList.add(oc);
				}
				if(quantity < 0) {
					
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
					
				}
			}
			
		}
		

		Order order = (Order)WebUtils.getSessionAttribute(request, "order");
		int cartTotalPrice = 0;
		cartTotalPrice = total + order.getAmount();
		
		
		order.setAmount(cartTotalPrice); 
		model.addAttribute("order", order);
		model.addAttribute("cartList", cartList); 
		WebUtils.setSessionAttribute(request, "order", order); 
		WebUtils.setSessionAttribute(request, "cart", cartList); 
		return "/store/order/Order";
	}							
	
	@RequestMapping("/store/order/requestOrder") 
	public ModelAndView requestOrder(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/store/order/confirmOrder");
		Store store = (Store) WebUtils.getSessionAttribute(request, "storeSession");
		Order order = (Order) WebUtils.getSessionAttribute(request, "order");
		List<OrderCart> cartList = (List<OrderCart>) WebUtils.getSessionAttribute(request, "cart");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new java.util.Date());
		java.sql.Date d = java.sql.Date.valueOf(date);
		order.setOrder_date(d);
			
		orderService.insertOrder(order);
	
		for(int i = 0; i < cartList.size(); i++) { 
			Order_product op = new Order_product();
			op.setProduct_id(cartList.get(i).getProductId());
			op.setOrder_id(order.getOrder_id());
			op.setQuantity(cartList.get(i).getQuantity());
			orderService.insertOrderProduct(op);
		}
		
		mav.addObject("order", order);
		mav.addObject("orderProductList", cartList);
		return mav;
	}
	
	@RequestMapping(value = {"/store/order/requestCancel" , "/store/order/confirmedComplete"}) 
	public String requestCancel(){
		return "/store/main";
	}
	
}

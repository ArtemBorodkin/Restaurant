package ua.controller.admin;

import ua.service.OrderService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

	private final OrderService service;
	
	@Autowired
	public AdminOrderController(OrderService service){
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("meals", service.findAllMeals());
		model.addAttribute("places", service.findAllPlaces());
		model.addAttribute("oders", service.findAll());
		return "order";
	}
	
	@GetMapping("/admin/order/delete")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/order";
	}

	
}

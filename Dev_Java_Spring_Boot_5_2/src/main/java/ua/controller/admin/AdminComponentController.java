package ua.controller.admin;



import ua.service.ComponentService;
import ua.model.request.ComponentRequest;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/admin/component")
@SessionAttributes("component")
public class AdminComponentController {

	private final ComponentService service;
	
	@Autowired
	public AdminComponentController(ComponentService service){
		this.service = service;
	}
	
	@ModelAttribute("component")
	public ComponentRequest getForm(){
		return new ComponentRequest();
	}
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("ingredients", service.findAllIngredients());
		model.addAttribute("mss", service.findAllMss());
		model.addAttribute("components", service.findAllView());
		return "component";
	}
	
	@GetMapping("/delete/{id}")
	public String delte(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/component";
	}
	
	@PostMapping
	public String save(@ModelAttribute("component")@Valid ComponentRequest request, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors())return show(model);
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("component", service.findOneRequest(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/component";
	}
	
}

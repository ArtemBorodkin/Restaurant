package ua.controller.admin;

import ua.entity.User;
import java.security.Principal;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model, Principal principal, As as){
		if(principal != null){
			model.addAttribute("message", "Hello " + principal.getName());
		}else{
			model.addAttribute("message", "Hello visitor");
		}
		System.out.println(as);
		return "index";
	}
	@GetMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	static class As{
		
		private User user;
		
		public User getUser(){
			return user;
		}
		
		public void setUser(User user){
			this.user = user;
		}
		
	}
	
}

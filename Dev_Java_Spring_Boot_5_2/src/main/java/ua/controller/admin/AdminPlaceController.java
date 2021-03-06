package ua.controller.admin;

import ua.entity.Place;
import ua.service.PlaceService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/admin/place")
public class AdminPlaceController {

	public final PlaceService service;
	
	@Autowired
	public AdminPlaceController(PlaceService service){
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("places", service.findAll());
		return "place";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/place";
	}
	
	@PostMapping
	public String save(@RequestParam int number, @RequestParam int countOfPeople,@RequestParam boolean isFree){
		service.save(new Place(number, countOfPeople, isFree));
		return "redirect:/admin/place";
	}
	
}

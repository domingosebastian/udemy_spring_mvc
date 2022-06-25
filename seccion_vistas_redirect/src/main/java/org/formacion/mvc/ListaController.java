package org.formacion.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListaController {

	private List<String> valores = new ArrayList<>();
	
	@RequestMapping(path="/lista")
	public String lista (Model model) {
		
		model.addAttribute("lista", valores);

		return "lista";
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public String add(String nuevo) {
		valores.add(nuevo);
		return "redirect:/lista";
	}
	
}

package org.formacion.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListaController {

	private final List<String> valores = Arrays.asList("primero", "segundo", "tercero");

	@RequestMapping(path="/lista")
	public String lista (Model model) {
		model.addAttribute("titulo", "Lista de nombres");
		model.addAttribute("lista", valores);
		return "lista";
	}


	@RequestMapping(path="/persona/{id}")
	public String mostra(@PathVariable String id, Model model) {
		model.addAttribute("usuario", new Persona("persona " + id, "Selva"));
		return "persona";
	}
}

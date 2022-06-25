package org.formacion.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListaController {
	

	/**
	 * El Model es el tipo que nos permite pasar informacion del controller a la vista.
	 * 
	 * Para disponer de un Model podemos declararlo como parametro de nuestro metodo. Spring MVC
	 * nos pasara una referencia a un Model para nuestra peticion si encuentra este parametro en la 
	 * declaracion del metodo.
	 * 
	 * Tipicamente, lo que anadimos al model lo hemos obtenido de la logica de negocio, de una consulta
	 * a base de datos etc etc. Aqui, para simplificar, guardaremos siempre el mismo String. Evidentemente,
	 * en este caso, no tiene sentido usar el model ... pero es un simple ejemplo introductorio.
	 * 
	 * En el model guardamos elementos etiquetados con un String y con valor cualquier tipo no primitivo.
	 * Es decir, la etiqueta ("nombre" en este caso) siempre sera un String, pero el valor ("Lista de nombres",
	 * en nuestro ejemplo) puede ser un array, una Collection, un tipo creado nuestro, etc.
	 */
	@RequestMapping(path="/lista")
	public String estado (Model model) {
		
		// el view va ha recibir un atributo "nombre" con valor "Lista de nombres"
		model.addAttribute("nombre","Lista de nombres");
		
        return "lista";
	}
	
}

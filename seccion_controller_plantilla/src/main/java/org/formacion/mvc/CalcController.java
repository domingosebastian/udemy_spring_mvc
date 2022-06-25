package org.formacion.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Controlador web que ofrece funcionalidad para hacer calculos
 * 
 * El @RequestMapping a nivel de clase hace que todos los paths especificados
 * en los metodos con @RequestMapping tengan un path con el prefijo "/calc"
 */
@Controller
@RequestMapping("/calc")
public class CalcController {

	/**
	 * Mapping sencillo a /calc/info que devuelve un String fijo
	 * @ResponseBody hace que Spring MVC devuelva al cliente el valor devuelto
	 * por el metodo
	 */
	@RequestMapping(path="/info")
	@ResponseBody
	public String info() {
		return "Calculadora online";
	}
	
	/**
	 * Metodo con parametros.
	 */
	@RequestMapping(path="/suma")
	@ResponseBody
	public int suma (int a, int b) {
		return a + b;
	}
	
	/**
	 * Uso de un path variable: parte del path usado es mapeado a una variable del metodo
	 * p.e. /calc/siguiente/5 hace que el valor del parametro original sea 5
	 */
	@RequestMapping(path="/siguiente/{original}")
	@ResponseBody
	public int siguiente(@PathVariable int original) {
		return original +  1;
	}
	
}

package org.formacion.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListaController {
	

	/**
	 * Este metodo no dispone de la anotacion @ResponseBody, por lo que el String devuelto (lista)
	 * se considera el nombre logico de la vista a mostrar:
	 * El nombre fisico se construye con la formula:
	 *   "templates/" + nombre logico +  ".html"
	 * Por lo que el nombre logico lista se convierte en el nombre fisico:
	 *    templates/lista.html
	 * El contenido de las plantillas lo encontrareis a partir de src/main/resources
	 */
	@RequestMapping(path="/lista")
	public String estado () {
       return "lista";
	}
	
	/**
	 * Este metodo no tiene un String de retorno, por lo que el nombre logico de la vista
	 * se basa en el path de @RequestMapping (defecto)
	 */
	@RequestMapping(path="/defecto")
	public void resolucionPorDefecto () {}
	
	/**
	 * Esta variacion del metodo anterior nos muestra como podemos organizar nuestros templates
	 * en distintos subdirectorios. En este caso el template esta en:
	 *    templates/dir/defecto.html
	 */
	@RequestMapping(path="/dir/defecto")
	public void subdirectorio () {}
	
}

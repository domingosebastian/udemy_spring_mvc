package org.formacion.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PersonalController {

	/*
	 * No toqueis el codigo que esta en esta parte de la clase (hasta el texto "fin no tocar")
	 * 
	 * En los metodos que ireis construyendo, tratad este array como si fuese una base de datos,
	 *  por ejemplo: para obtener la persona con id 1 debereis hacer: baseDeDatos.get(1), etc etc
	 */
	
	private List<String> baseDeDatos = new ArrayList<>(Arrays.asList("Juana","Antonia","Pedro"));
	
	public List<String> getBaseDeDatos() {
		return baseDeDatos;
	}

	/* fin no tocar */
	
	// A partir de aqui, ya si, id poniendo vuestros metodos
	
}

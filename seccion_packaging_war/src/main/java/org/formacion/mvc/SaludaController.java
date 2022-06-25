package org.formacion.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// El controller es exactamente igual que en la version "fat-jar"
@Controller
public class SaludaController {

	
	@RequestMapping(path="/saluda")
	@ResponseBody
	public String saluda() {
		return "Hola mundo";
	}

}

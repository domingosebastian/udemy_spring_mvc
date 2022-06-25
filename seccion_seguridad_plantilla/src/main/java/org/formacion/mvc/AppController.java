package org.formacion.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@RequestMapping(path="/public.txt")
	public String infoGeneral() {
		return "Esto es un ejemplo de pagina publica";
	}
	
	@RequestMapping(path="/admin/info.txt")
	public String infoAdmin() {
		return "Esto solo lo puede ver un administrador";
	}
	
	@RequestMapping(path="/gestion/user.txt")
	public String infoGestores(@AuthenticationPrincipal User user,  Authentication authentication) {
	    String msg = "Hola " + user.getUsername() + ", estas en la parte de gestion. Perfiles: \n ";
	    for (GrantedAuthority o : authentication.getAuthorities()) {
	    	msg += o.getAuthority() + "\n";
	    }
		return msg;
	}
	
}

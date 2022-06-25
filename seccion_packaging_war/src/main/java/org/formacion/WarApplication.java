package org.formacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WarApplication extends SpringBootServletInitializer {

	/**
	 * El metodo configure sera invocado como parte del proceso de inicializacion de la aplicacions web.
	 * Sin este metodo, no se realizaria toda la configuracion del Spring MVC
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WarApplication.class);
    }

	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(WarApplication.class, args);
	 }
}

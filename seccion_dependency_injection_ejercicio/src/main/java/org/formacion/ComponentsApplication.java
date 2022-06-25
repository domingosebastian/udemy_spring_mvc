package org.formacion;

import org.formacion.component.ServicioConsultaEmpresas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ComponentsApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(ComponentsApplication.class, args);

		ServicioConsultaEmpresas servicio = ctx.getBean(ServicioConsultaEmpresas.class);
		
		System.out.println(servicio.infoEmpresa("cervezas.sa"));
		System.out.println(servicio.infoEmpresa("shandies.sa"));
		System.out.println(servicio.infoDiaria());
		
		
		ctx.close();
	}
}

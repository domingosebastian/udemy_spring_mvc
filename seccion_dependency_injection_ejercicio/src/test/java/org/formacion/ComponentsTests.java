package org.formacion;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.formacion.component.ClienteCotizacionesWS;
import org.formacion.component.IntegradorCotizaciones;
import org.formacion.component.ServicioConsultaEmpresas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentsTests {

	@Autowired(required=false)
	private IntegradorCotizaciones clienteWS;

	@Autowired(required=false)
	private ServicioConsultaEmpresas servicio;
	
	/**
	 * Modificad la clase ClienteCotizacionesWS para que sea un componente detectado por Spring
	 */
	@Test
	public void test_clientWS_component() {
		assertNotNull(clienteWS, "ClienteCotizacionesWS no es un componente ");
	}
	
	/**
	 * Modificad la clase ServicioConsultaEmpresas para que sea un componente detectado por Spring
	 */
	@Test
	public void test_servicioConsultaEmpresas_component() {
		assertNotNull(servicio, "ServicioConsultaEmpresas no es un componente ");
	}

	/**
	 * Modificad ServicioConsultaEmpresas para que, en lugar de devolver siempre 0, use los metodos de IntegradorCotizaciones
	 */
	@Test
	public void test_consulta_cotizacion_empresa() {
		assertNotNull(servicio, "ServicioConsultaEmpresas no es un component ");
		assertEquals("consulta cotizacion", "La empresa cervezas.sa cotiza a 30.0", servicio.infoEmpresa("cervezas.sa"));
		assertEquals("consulta cotizacion", "La empresa shandies.sa cotiza a 10.0", servicio.infoEmpresa("shandies.sa"));
	}
	
	/**
	 * Para este ejercicio supondremos dos cosas:
	 *   - la aplicacion se lanza cada dia, por tanto la consulta a infoDiaria siempre sera la misma durante toda la ejecucion
	 *   - consultar obtenMediaDiariaCotizaciones es muuuuy lento, y no queremos hacerlo para cada invocacion a infoDiaria(), ya que 
	 *     hemos dicho que siempre devolvera el mismo resultado
	 * Modificad la clase ServicioConsultaEmpresas para que muestre la informacion de obtenMediaDiariaCotizaciones 
	 * pero haciendo la consulta SOLO UNA VEZ.
	 */
	@Test
	public void test_infoDiari() {
		assertNotNull(servicio, "ServicioConsultaEmpresas no es un component ");
		assertEquals("consulta info diaria", "La cotizacion media diaria es 20.0", servicio.infoDiaria());
		
		// no comprobamos el resultado de esta segunda invocacion, solo es para comprobar que se
		// esta reusando el resultado de obtenMediaDiariaCotizaciones() anterior
		servicio.infoDiaria();
		
		ClienteCotizacionesWS client  = (ClienteCotizacionesWS) clienteWS;
		assertEquals(1,client.numeroInvocaciones, "Solo se ha invocado obtenMediaDiariaCotizaciones() una vez");
	}
}

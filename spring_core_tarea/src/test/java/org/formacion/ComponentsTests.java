package org.formacion;


import static org.junit.jupiter.api.Assertions.*;

import org.formacion.component.Almacen;
import org.formacion.component.Logger;
import org.formacion.component.TiendaVirtual;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComponentsTests {

	@Autowired(required=false)
	private Logger logger;

	@Autowired(required=false)
	private Almacen almacen;
	
	@Autowired(required=false) 
	private TiendaVirtual tienda;
	
	/*
	 * Modificad las clases Almacen Logger y Tienda Virtual para que sean componentes
	 */
	@Test
	public void test_componentes() {
		assertNotNull(logger, "Logger no es un componente");
		assertNotNull(almacen, "Almacen no es un componente");
		assertNotNull(tienda, "TiendaVirtual no es un componente");
	}
	
	/*
	 * Haced que cuando se compra un producto, la clase TiendaVirtual use una referencia
	 * a logger (pensad: una dependencia) e invoque:
	 * log ("comprado producto <nombre>");
	 * Donde <nombre>, evidentemente, es el nombre del producto comprado
	 */
	@Test
	public void test_compra_usa_logger() {
		tienda.compraProducto("ordenador");
		assertTrue(logger.getLogs().contains("comprado producto ordenador"));
	}
	
	/*
	 * Modificad otra vez la clase TiendaVirtual para que 
	 * cada vez que se compre un producto lo elimine del estoc (metodo consume de Almacen)
	 * Pista: aqui hay otra dependencia a declarar
	 */
	@Test
	public void test_compra_elimina_producto() {
		tienda.compraProducto("ordenador");
		assertFalse(almacen.estaDisponible("ordenador"));
	}
	
	/*
	 * Otra vez en la clase TiendaVirtual, haced que el metodo
	 * compraProducto compruebe que el producto esta disponible usando
	 * el metodo estaDisponible de almacen.
	 * Si el producto no esta disponible, el metodo compraProducto debe devolver false
	 */
	@Test
	public void test_compra_comprueba_estoc() {
		assertTrue(tienda.compraProducto("impresora"));
		assertFalse(tienda.compraProducto("no existe"));
	}
	
	/*
	 * Incluid como parte del proceso de inicializacion del componente
	 * TiendaVirtual un aviso al sistema de logs con el mensaje
	 * "creando tienda virtual"
	 */
	@Test
	public void test_avisa_inicio() {
		assertTrue(logger.getLogs().startsWith("creando tienda virtual"));
	}
}

package org.formacion.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Almacen {

	private List<String> productos = new ArrayList<>(Arrays.asList("ordenador", "impresora","teléfono"));
	
	public boolean estaDisponible (String producto) {
		return productos.contains(producto);
	}
	
	public void consume (String producto) {
		productos.remove(producto);
	}
	
	public int numeroProductos() {
		return productos.size();
	}
	
}

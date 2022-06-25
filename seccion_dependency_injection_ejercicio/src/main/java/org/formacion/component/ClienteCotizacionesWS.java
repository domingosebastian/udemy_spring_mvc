package org.formacion.component;

// esta clase debe ser detectada como un componente
public class ClienteCotizacionesWS implements IntegradorCotizaciones {

	public int numeroInvocaciones = 0;
	
	public float obtenMediaDiariaCotizaciones() {
		numeroInvocaciones++; // para controles del test
		return 20f; // no modifiqueis este valor, ya nos vale
	}
	
	@Override
	public float obtenCotitzacion(String empresa) {
		switch (empresa) {
		     case "cervezas.sa": return 30f;
		     case "shandies.sa": return 10f;
		     default : return 20f;
		}
	}

}

package org.formacion.component;

// esta clase debe ser detectada como un componente
public class ServicioConsultaEmpresas {

	// este servicio necesita de un integrador de cotizaciones para devolver la informacion
	// declarad la dependencia y haced que Spring la resuelva
	

	// modificad este metodo para cambiar el 0 por el valor obtenidor de ClienteCotizacionesWS
	public String infoEmpresa(String empresa) {
		return "La empresa " + empresa + " cotiza a 0";
	}

	
	// modificad este metodo para cambiar el 0 por el valor obtenido del clienteCotizacionesWS
	// esta es, seguramente, la parte mas dificil!
	// ¿Como hariais para que el metodo infoDiaria de obtenMediaDiariaCotizaciones solo se llamase una vez?
	// Pista: si solo de debe llamar una vez ... deberemos guardar el resultado en alguna parte ...
	public String infoDiaria() {
		return "La cotizacion media diaria es 0";
	}

}

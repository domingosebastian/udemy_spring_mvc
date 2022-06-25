package org.formacion.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculadoraController {

	/**
	 * Este método recibira las peticiones tratadas en este Controller que finalizen con
	 * un error del tipo ArithmeticException (o alguno de sus subtipos).
	 * 
	 * Una alternativa podria ser, en lugar de pasar el ArithmeticException como parametro del metodo
	 * ponerlo como atributo del @ExceptionHandler
	 *   @ExceptionHandler(ArithmeticException.class)
	 */
	@ExceptionHandler
	@ResponseBody
	public String error(ArithmeticException e) {
		return "Se ha producido un error en la operación: " + e.getMessage();
	}

	/**
	 * Versión que usa una respuesta ResponseEntity<Integer>
	 * El Integer que parametriza el ResponseEntity indica cual es el tipo del cuerpo (body)
	 * de la respuesta (fijaos en el rol similar que tiene el @ResponseBody)
	 * El objeto ResponseEntity tiene distintos metodos para acceder y modificar todos los elementos
	 * que forman la respuesta HTTP
	 */
	@RequestMapping(path="/divEntity")
	@ResponseBody
	public ResponseEntity<Integer> divisionEntity (int a, int b) {
		// en este ejemplo controlamos programaticamente si la respuesta es una 
		// respuesta de error o una respuesta correcta
		if (b == 0) {
			return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(a / b, HttpStatus.OK);
	}

	
	@RequestMapping(path="/div")
	@ResponseBody
	public int division (int a, int b) {
		return a / b;
	}
}

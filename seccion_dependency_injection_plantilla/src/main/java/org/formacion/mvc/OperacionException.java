package org.formacion.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esta seria una excepcion "normal" que usariamos en el codigo.
 * El hecho de anotarla con @ResponseStatus hace que Spring MVC sepa en que error
 * HTTP convertirla
 * El atributo code es el estado HTTP y conviene usar las constantes definidas en HttpStatus
 * La respuesta HTTP, a parte del codigo, tambien incluye un texto llamado reason que podemos configurar
 */
@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR, reason="Operacion incorrecta")
public class OperacionException extends RuntimeException {

}

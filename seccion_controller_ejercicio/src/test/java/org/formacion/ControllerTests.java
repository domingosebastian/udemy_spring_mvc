package org.formacion;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

import org.formacion.mvc.PersonalController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerTests {

	@Autowired(required=false)
	PersonalController controller;
	
    @Autowired
    private MockMvc mockMvc;

    /**
     * No hace falta decirlo ... pero por si acaso ;-)
     *   PersonaControllar debe ser un controller
     */
    @Test
    public void test_controlador() {
    	assertNotNull(controller, "controller es null!");
    }
    
    /**
     * Todos los metodos que se indican a continuacion han de ir en PersonaController
     * Todas las peticiones empiezan con /personal. Aprovechad esto para poner este prefijo
     * solo una vez en el controller (es decir, que no este en cada request mapping)
     * 
     * Consejo: como siempre, id uno a uno con los metodos y ejecutad con frecuencia los test !
     */
    
    /**
     * La peticion /personal/info debe devolver el texto:
     *   hay x personas
     * donde x es el numero de personas en la "base de datos" de PersonaController
     */
    
    @Test
    public void test_info() throws Exception {
        this.mockMvc.perform(get("/personal/info")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hay " + controller.getBaseDeDatos().size() + " personas")));
    }

    /**
     * La peticion /personal/consulta?id=x
     *  ha de devolver el nombre de la persona que ocupa el lugar x en la base de datos
     */
    @Test
    public void test_obtener_con_request_param() throws Exception {
        this.mockMvc.perform(get("/personal/consulta?id=0")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Juana")));
    	
        this.mockMvc.perform(get("/personal/consulta?id=1")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Antonia")));
    	
    }

    /**
     * Modificad el metodo anterior para que el parametro id sea opcional y, si no se pasa, se devuelva
     * el nombre de la persona con id 0 (si se pasa el parametro, debe funcionar como antes)
     */
    @Test
    public void test_obtener_con_request_param_opcional() throws Exception {
        this.mockMvc.perform(get("/personal/consulta")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Juana")));
    	
    }

    /**
     * La peticion /persona/persona/x
     *  debe devolver el nombre de la persona que ocupa el lugar x en la base de datos de persona controller.
     *  Fijaos que ahora el parametro es parte de la url, no es un parametro http
     */
    @Test
    public void test_obtener_con_path_variable() throws Exception {
        this.mockMvc.perform(get("/personal/persona/0")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Juana")));
    	
        this.mockMvc.perform(get("/personal/persona/1")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Antonia")));
    	
    }
    
    
    /**
     * Se han de poder dar de alta personas usando (solo) el metodo POST en la url
     *    /personal/alta
     * El parametro post necesario es "nombre" con el nombre de la persona 
     *  (no se ha de proporcionar id. El id sera "automaticamente" la posicion en la que queda
     *   insertada la persona en el List que simula la base de datos)
     * La peticion ha de devolver el texto "ok"
     */
    @Test
    public void test_alta() throws Exception {

        this.mockMvc.perform(get("/personal/alta?nombre=error")).andExpect(status().is4xxClientError());

    	this.mockMvc.perform(post("/personal/alta").param("nombre", "Jacinto")).andExpect(status().isOk())
        .andExpect(content().string(containsString("ok")));
    	
        this.mockMvc.perform(get("/personal/persona/3")).andExpect(status().isOk())
        .andExpect(content().string(containsString("Jacinto")));
    	
    }
    

}

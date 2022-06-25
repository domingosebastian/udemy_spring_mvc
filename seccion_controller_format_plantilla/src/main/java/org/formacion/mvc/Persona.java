package org.formacion.mvc;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JAXB (la herramienta que usara MVC para obtener la representacion en XML) requiere que
 * los objetos que queremos que sean raiz del XML generado (como es en este caso Persona)
 * esten anotados con @XmlRootElement.
 */
@XmlRootElement
public class Persona {

	private String nombre;
	
	// JSonProperty nos permite controlar, entre otras cosas, el nombre de la propiedad JSON
	@JsonProperty("localidad")
	private String municipio;
	
	// El tratamiento de fechas siempre es mas complejo que el resto!
	// Con esta anotacion, indicamos que queremos un formato de dia-mey-año
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date fechaNacimiento;
	
	// La propiedad password, por tener JsonIgnore, no formara parte de la respuesta
	@JsonIgnore
	private String password;
	
	public Persona() {
	}

	public Persona(String nombre, String municipio, Date fechaNacimiento, String password) {
		this.nombre = nombre;
		this.municipio = municipio;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name="localitat")
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@XmlTransient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

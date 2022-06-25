package org.formacion.component;

import org.springframework.stereotype.Component;

public class Logger {
	
	private StringBuilder sb = new StringBuilder();
	
	public void log(String info) {
	    sb.append(info).append("\n");	
	}
	
	public String getLogs() {
		return sb.toString();
	}

}

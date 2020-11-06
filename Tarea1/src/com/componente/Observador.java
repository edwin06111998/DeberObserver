package com.componente;

public interface Observador {
	
	/**
	 * Actualiza uno o varios de los atributos de la clase que implemente esta interfaz 
	 * @param objeto el cual va ayudar a actualizar cierta informacion que 
	 * 		  necesita el observador 
	 */
	public void actualizar(Object objeto);
}

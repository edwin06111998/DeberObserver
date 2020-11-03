package com.componente;

public interface Observado {
	
	/**
	 * Notifica al observador de los cambios realizados
	 */
	public void notificar();
	
	/**
	 * Establece un observador para este objeto
	 * @param obs el nuevo observador que mirara los cambios que sufre el objeto
	 */
	public void enlazarObservador(Observador obs);
}

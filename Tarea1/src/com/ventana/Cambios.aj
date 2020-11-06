package com.ventana;

import java.awt.Color;


public aspect Cambios {
	String antColor;
	
	/**
	 * Servira para recuperar los colores que se han cambiado
	 */
	pointcut cambios() : execution(public void com.ventana.Principal.actualizar(..));
	
	
	//Recuperamos el anterior color del panel antes del cambio 
	before() : cambios(){
		Principal princ = (Principal) thisJoinPoint.getThis(); //Obtenemos la clase del metodo
		antColor = darColor(princ.getColor());//Recuperamos el anterior color del Panel
	}
	
	//Recuperamos el color actual del panel e imprimimos por pantalla
	after() : cambios(){
		Principal princ = (Principal) thisJoinPoint.getThis();//Obtenemos la clase del metodo
		Color actualColor = princ.getColor();//Recuperamos el color actual
		
		//Se verifica si enrealidad se ha cambiado de color
		if(!antColor.equals(darColor(actualColor))) {			
			//si el panel cambio de color imprimimos el cambio
			System.out.println("Cambio de Color: de " + antColor + " a " + darColor(actualColor));
		}else {			
			//si el panel no cambio de color imprimmos el siguiente mensaje
			System.out.println("*** No se ha realizado un cambio de color");
		}		
	}
	
	/**
	 * Servira para obtener el numero de veces que ha cambiado de color el panel 
	 */
	pointcut mostrarNumCambios() : execution(private void com.ventana.Principal.cerrar());
	
	//Imprime las veces que la pantalla cambio de color
	before() : mostrarNumCambios(){
		Principal princ = (Principal) thisJoinPoint.getThis();
		System.out.println("***************");
		System.out.println(String.format("Se cambio el color de la pantalla %d veces", princ.getContador()));
		System.out.println("***************");
	}
	
	/**
	 * Verifica cual es el color en cuestion para retornar un String
	 * @param color el cual se va a verificar
	 * @return el nombre del color en español
	 */
	public String darColor(Color color) {
		String newColor = "";
		if(color.equals(new Color(238,238,238))){newColor = "Gris";}
		if(color.equals(new Color(255,255,0))){newColor = "Amarillo";}
		if(color.equals(new Color(0,0,255))){newColor = "Azul";}
		if(color.equals(new Color(255,0,0))){newColor = "Rojo";}	
		return newColor;
	}
}

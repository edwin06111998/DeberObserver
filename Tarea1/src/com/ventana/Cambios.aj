package com.ventana;

import java.awt.Color;


public aspect Cambios {
	String antColor;
	
	/**
	 * Servira para recuperar los colores que se han cambiado
	 */
	pointcut cambios() : execution(* *.actualizar(..));
	
	before() : cambios(){
		Principal princ = (Principal) thisJoinPoint.getThis(); //Obtenemos la clase del metodo
		antColor = darColor(princ.getColor());//Recuperamos el anterior color del Panel
	}
	
	after() : cambios(){
		Color nuevo = (Color) thisJoinPoint.getArgs()[0];// Obtenemos los argumentos del metodo e indicamos que queremos el primero
		System.out.println("Cambio de Color: de " + antColor + " a " + darColor(nuevo));//Imprimimos el cambio		
	}
	
	pointcut mostrarNumCambios() : execution(* *.cerrar());
	
	before() : mostrarNumCambios(){
		Principal princ = (Principal) thisJoinPoint.getThis();
		System.out.println("***************");
		System.out.println(String.format("Se cambio de pantalla %d veces", princ.getContador()));
		System.out.println("***************");
	}
	
	
	
	
	/**
	 * Verifica cual es el color en cuestion
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

package com.ventana;

import java.awt.Color;

import javax.swing.JFrame;

import com.componente.Observador;
import com.componente.Panel;

public class Principal extends JFrame implements Observador{
	
	private static final long serialVersionUID = 1L;
	private Color color;
	
	public Principal() {
		this.color = this.getBackground();
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void actualizar(Object objeto) {
		// TODO Auto-generated method stub
		this.setColor((Color) objeto);
	}
	

	public static void main(String[] args) {
		Principal ventana = new Principal();
		Panel pan1 = new Panel("Azul", "Rojo", "Amarillo");
		pan1.enlazarObservador(ventana);
		ventana.add(pan1);
		ventana.setVisible(true);
	}
}

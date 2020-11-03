package com.ventana;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.componente.Observador;
import com.componente.Panel;

public class Principal extends JFrame implements Observador{
	
	private static final long serialVersionUID = 1L;
	private Color color;
	private int contador;
	
	public Principal() {
		this.color = this.getBackground();
		this.setSize(300, 200);
		this.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent e)
            {               
               cerrar();
            }
		});
	}	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getContador() {
		return this.contador;
	}
	
	public void growCont() {
		this.contador++;
	}
	
	public void cerrar() {
		this.dispose();
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

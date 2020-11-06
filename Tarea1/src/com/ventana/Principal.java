package com.ventana;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.componente.Observador;
import com.componente.Panel;

public class Principal extends JFrame implements Observador{
	
	private static final long serialVersionUID = 1L;
	private Color colorPanel;//se guarda el color actual de la ventana
	private int contadorCambios;// servira para contar cuantos cambios se han realizado
	
	public Principal() {
		this.colorPanel = this.getBackground();
		this.setSize(300, 200);
		this.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent e){cerrar();}
		});
	}	

	public Color getColor() {
		return colorPanel;
	}

	public void setColor(Color color) {
		this.colorPanel = color;
	}
	
	public int getContador() {
		return this.contadorCambios;
	}
	
	/**
	 * Ayudara a cerrar la ventana activa
	 */
	private void cerrar() {
		this.dispose();
	}
	
	/**
	 * Ayudara a actualizar la informacion tanto del color de la ventana
	 * como aumentar el contador
	 */
	@Override
	public void actualizar(Object objeto) {
		// TODO Auto-generated method stub
		if(objeto instanceof Color) {
			//verificamos si el color no es igual al anterior
			if(!this.colorPanel.equals((Color) objeto)){
				//si es asi actualizamos el color y aumentamos el contador
				this.setColor((Color) objeto);
				this.contadorCambios++;
			}			
		}				
	}
	

	public static void main(String[] args) {
		Principal ventana = new Principal();
		Panel pan1 = new Panel("Azul", "Rojo", "Amarillo");
		pan1.enlazarObservador(ventana);
		ventana.add(pan1);
		ventana.setVisible(true);
	}
}

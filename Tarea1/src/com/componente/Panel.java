package com.componente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.ventana.Principal;

public class Panel extends JPanel implements Observado {
	
	private static final long serialVersionUID = 1L;
	private JButton btn1, btn2, btn3;	
	private Observador observador;
	
	public Panel(String name1, String name2, String name3) {
		//Creamos nuevos botones
		this.btn1 = new JButton(name1);
		this.btn2 = new JButton(name2);
		this.btn3 = new JButton(name3);	
		
		//Agregamos una accion al presionar los botones
		btn1.addActionListener(new CambioColor());
		btn2.addActionListener(new CambioColor());
		btn3.addActionListener(new CambioColor());
		
		//Agregamos los botones al panel
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
	}	
	
	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		Principal obs = (Principal) this.observador;
		obs.actualizar(this.getBackground());//Actualizamos la informacion del color 
	}
	
	@Override
	public void enlazarObservador(Observador obs) {
		this.observador = obs;		
	}
	
	/**
	 * Esta clase servira para indicar que hara cada boton al presionarlo en 
	 * este caso cambiar de color a la ventana	  
	 *
	 */
	private final class CambioColor implements ActionListener{
		
		/**
		 * Realiza la accion de cambiar de color al fondo del panel
		 */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub			
			JButton boton = (JButton) e.getSource();//Recuperamos el boton
			Panel pan = (Panel) boton.getParent();//Recuperamos el contenedor
			String nombre = boton.getText();//Recuperamos el texto del boton
			
			//Realizamos la respectiva verificacion y cambiamos el color
			if(nombre.equals("Azul")) {
				pan.setBackground(Color.BLUE);
				
			}
			if(nombre.equals("Rojo")) {
				pan.setBackground(Color.RED);
				
			}
			if(nombre.equals("Amarillo")) {
				pan.setBackground(Color.YELLOW);
				
			}
			
			//Notificamos al observador de los cambios
			pan.notificar();
		}		
	}
}

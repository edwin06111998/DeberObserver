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
		this.btn1 = new JButton(name1);
		this.btn2 = new JButton(name2);
		this.btn3 = new JButton(name3);	
		
		btn1.addActionListener(new CambioColor());
		btn2.addActionListener(new CambioColor());
		btn3.addActionListener(new CambioColor());
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
	}	
	
	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		Principal obs = (Principal) this.observador;
		obs.actualizar(this.getBackground());
	}
	
	@Override
	public void enlazarObservador(Observador obs) {
		this.observador = obs;		
	}
	
	
	private final class CambioColor implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub			
			JButton boton = (JButton) e.getSource();
			Panel pan = (Panel) boton.getParent();
			String name = boton.getText();
			
			if(name.equals("Azul")) {
				pan.setBackground(Color.BLUE);
				
			}
			if(name.equals("Rojo")) {
				pan.setBackground(Color.RED);
				
			}
			if(name.equals("Amarillo")) {
				pan.setBackground(Color.YELLOW);
				
			}
			pan.notificar();
		}		
	}
}

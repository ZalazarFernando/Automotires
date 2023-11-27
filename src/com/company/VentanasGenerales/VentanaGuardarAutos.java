package com.company.VentanasGenerales;

//ARREGLADO LO DE LOS SALTOS

import com.company.Graficas.BarraTitulo;
import com.company.Colores;
import com.company.ManejoDeColecciones;
import com.company.BotonesGenerales.BotonGuardar;
import com.company.Graficas.Imagenes;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.Color;
import java.lang.Character;

public class VentanaGuardarAutos extends JFrame implements Colores {
	// variables graficas
	private BarraTitulo barra = new BarraTitulo();
	private BotonGuardar boton = new BotonGuardar();

	private Panel panel = new Panel();
	private JComboBox marcasDeAutos;
	private JTextField modelo;
	private JTextField km;
	private JTextField precio;

	public VentanaGuardarAutos() {
		setSize(400, 300);// tamaño de ventana
		setLocationRelativeTo(null);// ventana en el centro de pantalla

		setResizable(false);// impide que la pantalla pueda cambiar su tamaño
		setUndecorated(true);

		iniciarComponentes();
	}

	protected void iniciarComponentes() {
		crearPanel();
		colocarListas();
		colocarText();
		// colocarPalabras();
		boton.botonGuardado(panel, modelo, km, precio, marcasDeAutos, this);
		boton.fotoAuto(panel, this);
		barra.crearBarra(panel, this, "GestorFZ - Guardar auto");
		imagenes();
	}

	private void crearPanel() {
		panel.setLayout(null);// deshabilita el diseño por defecto
		panel.setBackground(Color.decode(colorFondo));// agrega color al panel
		this.getContentPane().add(panel);// se agrega el panel a la ventana
	}

	private void imagenes() {
		Imagenes img = new Imagenes();
		img.imagAuto(panel, 10, 30);
		img.imagItem(panel, 35, 60);
		img.imgKM(panel, 10, 130);
		img.imagPrecio(panel, 10, 190);
		// img.imagLinea(panel,5,285);
	}

	private void colocarListas() {
		String[] marcas = { "Alfa Romero", "Aro", "Aston Martin", "Audi", "BAIC", "Bently", "BMW", "Bugatti",
				"Cadillac", "Changan", "Chery", "Chevrolet", "Chrisller", "Citroen", "Cupra", "Dacia", "Daewoo",
				"Daihatsu", "DFSK", "DS", "Dodge", "Ferrari", "Fiat", "Ford", "Foton", "Geely", "Great Wall", "Haval",
				"Hispano Suiza", "Honda", "Hummer", "Hyundai", "Infiniti", "Isuzu", "JAC", "Jaguar", "Jeep", "Kia",
				"Lamborghini", "Lancia", "Land Rover", "Lifan", "Lexus", "Lotus", "Maserati", "Mazda", "McLaren",
				"Mercedez-Benz", "Mini Couper", "Mitsubishi", "Nissan", "Opel", "Pagani", "Peugeot", "Piagio",
				"Polestar", "Pontiac", "Porsche", "RAM", "Renault", "Rivian", "Rolls Royce", "Rover", "SEAT",
				"Shineray", "Skoda", "Smart", "SsangYoung", "Subaru", "Suzuki", "Tata", "Tesla", "Torino", "Toyota",
				"Volkswagen", "Volvo" };
		marcasDeAutos = new JComboBox(marcas);
		marcasDeAutos.setBounds(60, 35, 200, 20);

		panel.add(marcasDeAutos);
	}

	private void colocarText() {
		textModelo();
		textKM();
		textPrecio();
	}

	private void textModelo() {
		modelo = new JTextField();
		modelo.setBounds(70, 80, 200, 20);
		modelo.setForeground(Color.GRAY);
		modelo.setText("Modelo del auto");
		modelo.setFont(new Font("arial", 2, 12));

		modelo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (modelo.getText().equals("Modelo del auto")) {
					modelo.setText("");
					modelo.setForeground(Color.black);
					modelo.setFont(new Font("arial", 0, 12));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (modelo.getText().isEmpty()) {
					modelo.setForeground(Color.GRAY);
					modelo.setText("Modelo del auto");
					modelo.setFont(new Font("arial", 2, 12));
				}
			}
		});

		panel.add(modelo);
	}

	private void textKM() {
		km = new JTextField();
		km.setBounds(60, 137, 150, 20);
		km.setForeground(Color.GRAY);
		km.setText("Kilometraje del auto");
		km.setFont(new Font("arial", 2, 12));

		// impide que en estos JTextField se escriban letras
		
		  km.addKeyListener(new KeyListener() {
		  
		  @Override public void keyPressed(KeyEvent arg0) {
		  
		  }
		  
		  @Override public void keyReleased(KeyEvent arg0) {
		  
		  }
		  
		  @Override public void keyTyped(KeyEvent arg0) { Character c =
		  arg0.getKeyChar();
		  
		  if( ((c < '0') || (c > '9')) && (c != '\b'/*back-space*/)){
		  arg0.consume(); } }
		  
		  });
		 

		// coloca las letras de antes de escribir
		km.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (km.getText().equals("Kilometraje del auto")) {
					km.setText("");
					km.setForeground(Color.black);
					km.setFont(new Font("arial", 0, 12));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (km.getText().isEmpty()) {
					km.setForeground(Color.GRAY);
					km.setText("Kilometraje del auto");
					km.setFont(new Font("arial", 2, 12));
				}
			}
		});

		panel.add(km);
	}

	private void textPrecio() {
		precio = new JTextField();
		precio.setBounds(60, 197, 100, 20);
		precio.setForeground(Color.GRAY);
		precio.setText("Precio");
		precio.setFont(new Font("arial", 2, 12));

		// impide que en estos JTextField se escriban letras
		precio.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {Character c = arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '\b' /*back-space*/)) {arg0.consume();}
			}

		});

		// coloca las letras de antes de escribir
		precio.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (precio.getText().equals("Precio")) {
					precio.setText("");
					precio.setForeground(Color.BLACK);
					precio.setFont(new Font("arial", 0, 12));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (precio.getText().isEmpty()) {
					precio.setForeground(Color.GRAY);
					precio.setText("Precio");
					precio.setFont(new Font("arial", 2, 12));
				}
			}
		});

		panel.add(precio);
	}

}

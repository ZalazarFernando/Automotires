package com.company;

import java.io.File;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ManejoDeColecciones {
	private LinkedList<Autos> autos = new LinkedList<Autos>();
	private LinkedList<Autos> aux = new LinkedList<Autos>();
	private Autos autoAux = new Autos();
	
	public void reconstruir() {
		autos = aux;
		autos.remove(0);
	}
	
	public void leerDatos(String linea,int numLinea,int band) {
		if (band < 6) {
			//System.out.println(linea);
			
			switch (numLinea) {
			case 1: {aux.add(autoAux); autoAux = new Autos(); break;}
			case 2: {autoAux.setMarca(linea); break;}
			case 3: {autoAux.setModelo(linea); break;}
			case 4: {autoAux.setKm(linea); break;}
			case 5: {autoAux.setPrecio(linea); break;}
			case 6: {break;}
			} 
		}
		
		if (band > 5 ) {
			switch (numLinea) {
			case 0: {aux.add(autoAux); autoAux = new Autos();break;}
			case 1: {autoAux.setMarca(linea);break;}
			case 2: {autoAux.setModelo(linea);break;}
			case 3: {autoAux.setKm(linea);break;}
			case 4: {autoAux.setPrecio(linea);break;}
			case 5: {break;}
			}
		}
    }
	
	public void agregarAutosColeccion( JTextField modelo,
            JTextField km, JTextField precio, JComboBox marcasDeAutos) {
    	
    	Autos auto = new Autos((String) marcasDeAutos.getSelectedItem(), modelo.getText(), km.getText(), 
    					precio.getText());
        
        autos.add(auto);
    }

	public LinkedList<Autos> getAutos() {
		return autos;
	}

	public void setAutos(LinkedList<Autos> autos) {
		this.autos = autos;
	}
}

package com.company.BotonesGenerales;

import com.company.ManejoDeColecciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.io.*;
import com.company.Autos;
import com.company.Colores;

public class BotonGuardar implements Colores{
    //variables de archivo
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    File archivo2;
    File carpeta = new File("Imagenes");
    String[] listado = carpeta.list();
    byte[] bytesImagenes = new byte[1024*100];
    AbrirArchivo arch = new AbrirArchivo();

    //variables de guardado
    private File f = new File("Autos.txt");
    private ManejoDeColecciones coleccion = new ManejoDeColecciones();

    public void fotoAuto(Panel panel,JFrame v){
    	ImageIcon imagen = new ImageIcon("Iconos/camara.png");

        JButton foto = new JButton();
        foto.setBounds(60,240,40,40);
        foto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), 
        		foto.getHeight(), Image.SCALE_SMOOTH)));
        foto.setContentAreaFilled(false);
        foto.setBorder(null);

        panel.add(foto);

        accFotoAuto(foto,v);
    }

    private void accFotoAuto(JButton foto,JFrame v){
    	
    	 foto.addMouseListener( new MouseListener() {

 			@Override
 			public void mouseClicked(MouseEvent e) { }

 			@Override
 			public void mouseEntered(MouseEvent e) {
 				ImageIcon imagen = new ImageIcon("Iconos/camara luz.png");
 		        foto.setBorder(null);
 		        foto.setBounds(60,240,40,40);
 		        foto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), 
 		        		foto.getHeight(), Image.SCALE_SMOOTH)));
 		        foto.setContentAreaFilled(false);
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				ImageIcon imagen = new ImageIcon("Iconos/camara.png");
 		        foto.setBounds(60,240,40,40);
 		        foto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(foto.getWidth(), 
 		        		foto.getHeight(), Image.SCALE_SMOOTH)));
 		        foto.setContentAreaFilled(false);
 		        foto.setBorder(null);
 			}

 			@Override
 			public void mousePressed(MouseEvent e) { }

 			@Override
 			public void mouseReleased(MouseEvent e) { }
         	
         });
    	
        ActionListener accion = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                archivo2 = new File("Imagenes/"+(encontrarNombre())+".jpg");
                if(seleccionado.showDialog(v,"Abrir archivo") == JFileChooser.APPROVE_OPTION){/*
                                                             *abre una ventana que permite seleccionar la imagen deseada*/
                    archivo = seleccionado.getSelectedFile();//el archivo toma lo que se seleccionó
                    if(archivo.canRead()){//de poder abrirse el archivo
                        if(archivo.getName().endsWith("jpg")){//si el archivo seleccionado es un jpg, o sea una imagen
                            bytesImagenes = arch.abrirImagen(archivo);//se abre la imagen
                            //foto.setIcon(new ImageIcon(bytesImagenes));
                            String respuesta = arch.guardarImagen(archivo2,bytesImagenes);
                            if(respuesta != null){
                                JOptionPane.showMessageDialog(null,respuesta);
                            }else{
                                JOptionPane.showMessageDialog(null, "error al guardar");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"por favor seleccione una imagenes");
                        }
                    }
                }
            }

       };
        
        foto.addActionListener(accion);
    }

    public void botonGuardado(Panel panel, JTextField modelo, 
    		JTextField km, JTextField precio, JComboBox marcasDeAutos, JFrame v) {
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(280, 250, 80, 30);
        botonGuardar.setBackground(Color.decode(colorEFondo));
        botonGuardar.setForeground(Color.decode(colorFondo));
        botonGuardar.setBorder(null);

        panel.add(botonGuardar);

        accionGuardar(botonGuardar, modelo, km, precio, marcasDeAutos, v);
    }

    private void accionGuardar(JButton botonGuardar, JTextField modelo,
                               JTextField km, JTextField precio, JComboBox marcasDeAutos, JFrame v) {
    	
    	botonGuardar.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) { }

			@Override
			public void mouseEntered(MouseEvent e) {
				botonGuardar.setBounds(280, 250, 80, 30);
		        botonGuardar.setBackground(Color.decode(colorLuminoso));
		        botonGuardar.setForeground(Color.decode(colorFondo));
		        botonGuardar.setBorder(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonGuardar.setBounds(280, 250, 80, 30);
		        botonGuardar.setBackground(Color.decode(colorEFondo));
		        botonGuardar.setForeground(Color.decode(colorFondo));
		        botonGuardar.setBorder(null);
			}

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }
    		
    	});
    	
        ActionListener accionDeGuardar = new ActionListener() {
            String lectura;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!f.exists()) {//si no existe el archivo lo crea
                    try {
                        f.createNewFile();
                        System.out.println(f.getName() + " Ah sido creado");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {//si existe, lo usa para escribir
                    try {
                        FileWriter w = new FileWriter(f.getAbsoluteFile(), true);/*f.getAbsoluteFile da al programador
                         *toda la información del archivo.
                         * el true en append: habilita la posibilidad de escribir
                         * debajo de lo ya escrito en el archivo
                         */

                        BufferedWriter bw = new BufferedWriter(w);//buffer del objeto para escribir
                        PrintWriter pw = new PrintWriter(bw);//permite usar el objeto FileWriter para escribir
                        
                        //agrega un auto a la coleccion con todos los detalles dados en los parametros
                        
                        coleccion.agregarAutosColeccion(modelo, km, precio, marcasDeAutos);
                        
                        pw.append("\n");
                        pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getMarca() + "\n");

                        pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getModelo() + "\n");
                        pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getKm() + "\n");
                        pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getPrecio() + "\n");
                        pw.append(archivo2.getName()+"\n");

                        pw.append("+"+marcasDeAutos.getSelectedIndex());
                        
                        pw.append("\n");

                        pw.close();
                        bw.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                v.dispose();//cierra sólo la ventana actual
            }
        };

        botonGuardar.addActionListener(accionDeGuardar);
    }

    private String encontrarNombre(){
        String nombreArchivo = null;//para ponerle nombre al archivo
        LinkedList<Character> listNumeros = new LinkedList<Character>();/*lista, para que se puedan poner varios dígitos
                                                                         *dentro de la variable aux */
        int[] aux = new int[listado.length];/*aquí se guardan los numeros que hay dentro de los nombres de los archivos
                                             *para poder saber si falta alguno en medio, y darle nombre a la nueva imagen*/
        String concatenar = null;//aquí se unen los numeros dentro de la lista, ya que ahí cada digito esta por separado

        for(int i=0;i<listado.length;i++){//primer for, para leer los elementos de la lista completa
            for(int j=0;j<listado[i].length();j++){//segundo for, para las letras de los elementos en la lista
                if(listado[i].charAt(j) == '.'){//cuando se encuentra el punto
                    break;//se sale de este for, ya que se encontró el numero completo dentro del nombre
                }
                else{
                    listNumeros.add(listado[i].charAt(j));//se guardan los dígitos por separado
                }
            }
            for (int j = 0; j < listNumeros.size();j++) {//se concatenan los dígitos para formar el número completo
                if(j==0){
                    concatenar = String.valueOf(listNumeros.get(j));//si es el primer dígito, sólo se lo guarda
                }
                else{
                    concatenar = concatenar.concat(String.valueOf(listNumeros.get(j)));
                }
            }
            aux[i] = Integer.parseInt(String.valueOf(concatenar));//se guardan los numeros, pasandolos a variable numérica

            //se llevan a 0 o null estas variables para que no concatenen todos los dígitos que hay en la lista entera
            concatenar = null;
            listNumeros.removeAll(listNumeros);

            if(listado.length == 1){
                break;
            }
        }

        //ordenamiento burbuja
        int ayuda;
        for(int i=0;i<aux.length-1;i++){
            for(int j=0;j<aux.length-i-1;j++){
                if(aux[j+1] < aux[j]){
                    ayuda = aux[j+1];
                    aux[j+1] = aux[j];
                    aux[j] = ayuda;
                }
            }
        }

        for(int i=0;i<aux.length;i++) {
            if (aux.length == 1) {
                nombreArchivo = String.valueOf(aux[i]+1);/*si la lista es de un elemento, sólo se coloca como nombre
                                                          *el siguiente numero a este*/
                break;
            }
            else if (i == aux.length-1){//si se llegó al final de la lista, se coloca el nçumero siguiente al número final
                nombreArchivo = String.valueOf(aux[i]+1);
                break;
            }
            else if (aux[i+1] > (aux[i]+1)) {//si el numero siguiente es mayor a lo que debería
                nombreArchivo = String.valueOf(aux[i]+1);//se crea el numero que debería seguir
                break;
            }
        }
        return nombreArchivo;
    }
}

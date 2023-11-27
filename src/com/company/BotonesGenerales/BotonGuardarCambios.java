package com.company.BotonesGenerales;

import javax.swing.*;

import com.company.Colores;
import com.company.ManejoDeColecciones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.LinkedList;

public class BotonGuardarCambios extends BotonEliminarAutoGuardado implements Colores{
    //variables de archivo imagen
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    File archivo2;
    File carpeta = new File("Imagenes");
    String[] listado = carpeta.list();//obtiene en forma de String[] todos los nombres de los archivos dentro de la carpeta
    byte[] bytesImagenes = new byte[1024*100];
    AbrirArchivo arch = new AbrirArchivo();
    String nombre;//guarda el nombre que se le dió a la imagen


    //variables de guardado
    private File f = new File("Autos.txt");
    private ManejoDeColecciones coleccion = new ManejoDeColecciones();
	/*
	 * private String box; private String precioTxt; private String kmTxt; private
	 * String textA;
	 */
    private static boolean borrarONo = true;

    public void botonGuardado(Panel panel,
                              JTextField modelo, JTextField km, JTextField precio,
                              JComboBox marcasDeAutos, JFrame v,String nomImg,int lineaComienzo,int lineaFinal) {
    	
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(300, 250, 80, 30);
        botonGuardar.setBackground(Color.decode(colorEFondo));
        botonGuardar.setForeground(Color.decode(colorFondo));
        botonGuardar.setBorder(null);

        panel.add(botonGuardar);

        accionGuardar(botonGuardar, modelo, km, precio, marcasDeAutos,
        		v, nomImg, lineaComienzo,lineaFinal);
    }

    private void accionGuardar(JButton botonGuardar, JTextField modelo,
                               JTextField km, JTextField precio, JComboBox marcasDeAutos,
                               JFrame v, String nomImg, int lineaComienzo,int lineaFinal) {
    	
    	botonGuardar.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				botonGuardar.setBounds(300, 250, 80, 30);
		        botonGuardar.setBackground(Color.decode(colorLuminoso));
		        botonGuardar.setForeground(Color.decode(colorFondo));
		        botonGuardar.setBorder(null);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonGuardar.setBounds(300, 250, 80, 30);
		        botonGuardar.setBackground(Color.decode(colorEFondo));
		        botonGuardar.setForeground(Color.decode(colorFondo));
		        botonGuardar.setBorder(null);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
    	
        ActionListener accionDeGuardar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escribirArchivo(lineaComienzo,lineaFinal);
                reescribirArchivoA(lineaComienzo,lineaComienzo);
                guardarCambios(modelo,km,precio,marcasDeAutos,v,nomImg);
            }
        };

        botonGuardar.addActionListener(accionDeGuardar);
    }

    private void guardarCambios( JTextField modelo,
                                JTextField km, JTextField precio, JComboBox marcasDeAutos, JFrame v, String nomImg){
        String lectura;
        File nuevoF = new File("B.txt");

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

				
				
				/*
				 * while((lectura = br.readLine()) != null) { if(lectura.indexOf("+")>-1){
				 * pw.append("\n"); break; } }
				 */
				 
                
                coleccion.agregarAutosColeccion(modelo, km, precio, marcasDeAutos);
				//pw.append("\n");
				 
                //guarda cada variable colocada en el archivo
                pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getMarca() + "\n");

                pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getModelo() + "\n");
                pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getKm() + "\n");
                pw.append(coleccion.getAutos().get(coleccion.getAutos().size()-1).getPrecio() + "\n");
                if(borrarONo == false){
                    pw.append(nombre+"\n");//si se borró la imagen, debe colocarse el nombre de la nueva imagen
                }else {
                    pw.append(nomImg + "\n");
                }

                pw.append("+"+marcasDeAutos.getSelectedIndex());

                /*while((lectura = br.readLine()) != null) {
                    if(lectura.indexOf("+")>-1){
                        pw.append("\n");
                        break;
                    }*/
                
                pw.append("\n");

                pw.close();
                bw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        v.dispose();//cierra sólo la ventana actual
    }

    public void colocarFoto(String imagen, Panel panel,JFrame v){
        ImageIcon imagenDelAuto = new ImageIcon("Imagenes/"+imagen);
        
        JLabel auto = new JLabel();
        auto.setBounds(v.getWidth() - 110,v.getHeight()- 260,100,100);
        auto.setIcon(new ImageIcon(imagenDelAuto.getImage().getScaledInstance(
        		auto.getWidth(),auto.getHeight(),Image.SCALE_SMOOTH)));

        panel.add(auto);

        accionFoto(auto,v);
    }

    private void accionFoto(JLabel auto,JFrame v){
        MouseListener accion = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                archivo2 = new File("Imagenes/"+(encontrarNombre())+".jpg");
                nombre = archivo2.getName();
                if(seleccionado.showDialog(v,"Abrir archivo") == JFileChooser.APPROVE_OPTION){/*
                 *abre una ventana que permite seleccionar la imagen deseada
                 * y si se presionó el botón de aprovación, entonces hace lo demás*/
                    archivo = seleccionado.getSelectedFile();//el archivo toma lo que se seleccionó
                    if(archivo.canRead()){//de poder abrirse el archivo
                        if(archivo.getName().endsWith("jpg")){//si el archivo seleccionado es un jpg, o sea una imagen
                            bytesImagenes = arch.abrirImagen(archivo);//se abre la imagen
                            String respuesta = arch.guardarImagen(archivo2,bytesImagenes);
                            borrarONo = false;
                            if(respuesta != null){
                                JOptionPane.showMessageDialog(null,respuesta);
                            }else{
                                JOptionPane.showMessageDialog(null, "error al guardar");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"por favor seleccione una imagenes");
                        }
                    }
                }else{
                    borrarONo = false;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        auto.addMouseListener(accion);
    }

    public void escribirArchivo(int lineaComienzo,int lineaFinal){
        File f = new File("Autos.txt");
        File nuevoF = new File("B.txt");
        String inf;
        int cont = 0,lineaCinco = 0;

        FileReader fr;
        BufferedReader bf;

        FileWriter fw;
        BufferedWriter bw;

        if (!nuevoF.exists()) {//creando nuevo archivo B para mezcla
            try {
                nuevoF.createNewFile();
                System.out.println("se creo B");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                //abriendo Archivo Autos.txt para leer
                fr = new FileReader(f);
                bf = new BufferedReader(fr);

                //abriendo nuevo archivo B para escribir.

                fw = new FileWriter(nuevoF);

                bw = new BufferedWriter(fw);

                while ((inf = bf.readLine()) != null) {//mientras el archivo Autos.txt no sea nulo
                    if (cont >= lineaComienzo && cont<lineaFinal) {/*si el contado es igual al area que se desea borrar*/
                        lineaCinco++;//busca la linea en que se encuentra el nombre del archivo Imagen
                        if(lineaCinco == 5){//si se encuentra la linea (siempre será 5 en este caso)
                            if(borrarONo == false) {
                                File imagen = new File("Imagenes/" + inf);//crea una referencia a ese archivo
                                imagen.delete();//elimina el archivo
                            }else{

                            }
                        }
                        cont++;
                        continue;
                    }
                    else {//si el contador llena a la linea deseada
                        fw.write(inf+"\n");//escribe lo que haya en archivo Autos.txt sobre archivo B
                    }
                    cont++;
                }

                bf.close();
                fr.close();

                bw.close();
                fw.close();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
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
                    concatenar = String.valueOf(listNumeros.get(j));//si es el primer dígito, sólo selo guarda
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

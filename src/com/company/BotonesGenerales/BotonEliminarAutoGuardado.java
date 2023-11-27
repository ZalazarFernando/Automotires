package com.company.BotonesGenerales;

import com.company.VentanasGenerales.VentanaGuardarAutos;
import com.company.VentanasGenerales.VentanaPregunta;
import com.company.Colores;
import com.company.ManejoDeColecciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class BotonEliminarAutoGuardado extends JButton implements Colores{
    
    //variable
    ManejoDeColecciones coleccion = new ManejoDeColecciones();

    public void botonEliminar(Panel panel, int lineaComienzo,int lineaFinal, int y) {
    	
        ImageIcon imgLinea = new ImageIcon("Iconos/separacion.png");
        
        JButton eliminar = new JButton();
        eliminar.setBounds(280, y+20, 30, 30);
        eliminar.setBorder(null);
        eliminar.setContentAreaFilled(false);
        eliminar.setIcon(new ImageIcon(imgLinea.getImage().getScaledInstance(eliminar.getWidth(), 
        		eliminar.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(eliminar);
        
        eliminar.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				ImageIcon imgLinea = new ImageIcon("Iconos/separacion luz.png");
				
				eliminar.setBounds(280, y+20, 30, 30);
		        eliminar.setBorder(null);
		        eliminar.setIcon(new ImageIcon(imgLinea.getImage().getScaledInstance(eliminar.getWidth(), 
		        		eliminar.getHeight(), Image.SCALE_SMOOTH)));
		        eliminar.setContentAreaFilled(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon imgLinea = new ImageIcon("Iconos/separacion.png");
				
				eliminar.setBounds(280, y+20, 30, 30);
		        eliminar.setBorder(null);
		        eliminar.setIcon(new ImageIcon(imgLinea.getImage().getScaledInstance(eliminar.getWidth(), 
		        		eliminar.getHeight(), Image.SCALE_SMOOTH)));
		        eliminar.setContentAreaFilled(false);
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

        accBotonEliminar(lineaComienzo,lineaFinal,eliminar);
    }

    private void accBotonEliminar(int lineaComienzo,int lineaFinal,JButton eliminar) {

        ActionListener borrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPregunta vp = new VentanaPregunta(lineaComienzo,lineaFinal,"¿Desea eliminar el auto?");
                vp.setVisible(true);
            }

        };

        eliminar.addActionListener(borrar);
    }

    public void botonEditar(Panel panel, int y, int numLineaComienzo, int numLineaFinal){
    	
        ImageIcon imgEdit = new ImageIcon("Iconos/Editar.png");
        
        JButton botonEdit = new JButton();
        botonEdit.setOpaque(true);
        botonEdit.setBorder(null);
        botonEdit.setContentAreaFilled(false);
        botonEdit.setBounds(330,y+50,30,30);
        botonEdit.setIcon(new ImageIcon(imgEdit.getImage().getScaledInstance(
        		botonEdit.getWidth(),botonEdit.getHeight(),Image.SCALE_SMOOTH)));
        
        botonEdit.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) { }

			@Override
			public void mouseEntered(MouseEvent e) { 
				ImageIcon imgEdit = new ImageIcon("Iconos/Editar luz.png");
				
				botonEdit.setBorder(null);
				botonEdit.setBounds(330,y+50,30,30);
				botonEdit.setIcon(new ImageIcon(imgEdit.getImage().getScaledInstance(
						botonEdit.getWidth(),botonEdit.getHeight(),Image.SCALE_SMOOTH)));
				botonEdit.setContentAreaFilled(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon imgEdit = new ImageIcon("Iconos/Editar.png");
		        
				botonEdit.setBorder(null);
				botonEdit.setBounds(330,y+50,30,30);
				botonEdit.setIcon(new ImageIcon(imgEdit.getImage().getScaledInstance(
						botonEdit.getWidth(),botonEdit.getHeight(),Image.SCALE_SMOOTH)));
				botonEdit.setContentAreaFilled(false);
			}

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }
    		
    	});

        panel.add(botonEdit);

        accBotonEditar(botonEdit,numLineaComienzo,numLineaFinal);
    }

    private void accBotonEditar(JButton editar,int numLineaComienzo,int numLineaFinal){
    	
    	
    	
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPregunta v1 = new VentanaPregunta(numLineaComienzo,numLineaFinal,"¿Desea editar los datos?");
                v1.setVisible(true);
            }
        };
        editar.addActionListener(accion);
    }

    public static void escribirArchivoB(int lineaComienzo,int lineaFinal){
    	
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
                
                PrintWriter pw = new PrintWriter(bw);

                while ((inf = bf.readLine()) != null) {//mientras el archivo Autos.txt no sea nulo
                	if(cont == 0) {
                		pw.append("\n");
                	}
                    if (cont >= lineaComienzo-1 && cont<lineaFinal) {//si el contado es igual al area que se desea borrar
                        lineaCinco++;//busca la linea en que se encuentra el nombre del archivo Imagen
                        if(lineaCinco == 5){//si se encuentra la linea (siempre serÃ¡ 5 en este caso)
                            File imagen = new File("Imagenes/"+inf);//crea una referencia a ese archivo
                            imagen.delete();//elimina el archivo
                        }
                        cont++;
                        continue;
                    }
                    else {//si el contador llena a la linea deseada
                        pw.write(inf+"\n");//escribe lo que haya en archivo Autos.txt sobre archivo B
                    }
                    cont++;
                }

                bf.close();
                fr.close();
                
                pw.close();
                bw.close();
                fw.close();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void reescribirArchivoA(int lineaComienzo,int lineaFinal){
    	
        File nuevoF =  new File("B.txt");
        File f = new File("Autos.txt");
        String linea;

        FileReader fr;
        BufferedReader br;

        FileWriter fw;
        BufferedWriter bw;

        if(!f.exists()){
            try{
                f.createNewFile();
                System.out.println("se creo Autos");
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        else{
            try{
                //abriendo archivo B para lectura
                fr = new FileReader(nuevoF);
                br = new BufferedReader(fr);
                //abriendo archivo Autos para escritura
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);

                while((linea = br.readLine()) != null){//linea va a tomar la linea del archivo B
                    fw.write(linea+"\n");//se va a escribir en el archivo Autos.txt
                }

                //cerrando lectura de B
                fr.close();
                br.close();
                //cerrando escritura de Autos.txt
                fw.close();
                bw.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}

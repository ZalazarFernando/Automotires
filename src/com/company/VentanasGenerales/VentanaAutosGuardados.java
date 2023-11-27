package com.company.VentanasGenerales;

import com.company.Graficas.BarraTitulo;
import com.company.BotonesGenerales.BotonEliminarAutoGuardado;
import com.company.Graficas.Imagenes;
import com.company.ManejoDeColecciones;
import com.company.Autos;
import com.company.Colores;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;


public class VentanaAutosGuardados extends JFrame implements Colores{
    private Panel panel = new Panel();
    private BarraTitulo barra = new BarraTitulo();
    private Imagenes img = new Imagenes();
    private BotonEliminarAutoGuardado botones = new BotonEliminarAutoGuardado();

    //variable de localizacion
    int y=50;
    ManejoDeColecciones coleccion = new ManejoDeColecciones();

    public VentanaAutosGuardados(){
        setSize(400,600);//tamaño de la ventana
        setLocationRelativeTo(null);//centra la ventana a la mitad de la pantalla

        setResizable(false);//impide que la pantalla pueda cambiar su tamaño
        setUndecorated(true);

        iniciarComponentes();
    }

    private void iniciarComponentes(){
        crearPanel();
        mostrarAutos();
        barra.crearBarra(panel,this,"GestorFZ - Autos guardados");
    }

    private void crearPanel(){
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorFondo));
        this.getContentPane().add(panel);
    }

    private void mostrarAutos(){
    	
        int cont=0, numLineaFinal=1,numLineaComienzo=1, band=0;

        File f = new File("Autos.txt");
        FileReader fr;
        BufferedReader br;
        
      //lectura del archivo
        String linea;
        
        

        try{//se intenta abrir el archivo para lectura
            //apertura de fichero y creacion de buffer
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            
            while((linea=br.readLine())!=null) { //mientras no sea null, la variable toma la linea que haya 
            									//en el archivo
                if(linea.indexOf("+")>-1){//cuando llega encuentra "+" es porque terminó de
                							//escribir los datos de cada auto
                    img.imagLinea(panel,5,y);//dibuja una linea cuando termina de escribir los datos del auto
                    numLineaFinal++;
                    boton(numLineaComienzo,numLineaFinal);/*se dan estos datos para saber donde comienza y terminan
                                                           *los datos de cada auto*/
                    numLineaComienzo=numLineaFinal;/* El comienzo toma el valor del final
                                                    * ya que el final de los datos anteriores
                                                    * son el comienzo de los datos siguientes*/
                    
                    
                    y += 15;
                    cont=0;
                    continue;
                }
                
                escritura(linea,cont);//escritura de datos
                if(cont == 5){
                    colocarImagenDeAuto(linea);
                }
                y += 15;//baja para poder escribir el siguiente dato en el Frame
                cont++;
                numLineaFinal++;
            }
    		
            br.close();
            fr.close();

        }catch(Exception ex){//de no poder abrirlo se escribe un mensaje de error
            ex.printStackTrace();
        }
        
        try {
        	fr = new FileReader(f);
        	br = new BufferedReader(fr);
        	
        	cont=1;
            
            while((linea=br.readLine())!=null) {
    			if(linea.indexOf("+") > -1) {
    				cont = 0;
    				continue;
    			}
    			coleccion.leerDatos(linea,cont,band);
    			cont++;
    			band++;
    		}
            
    		coleccion.reconstruir();
    		
            br.close();
            fr.close();
            
        }catch(IOException e) {
        	e.printStackTrace();
        }
    }

    private void escritura(String linea,int numlinea){
        JLabel text = new JLabel();
        
        if(numlinea == 1){//si la linea es 1 quiere decir que es la marca
            text.setText("Marca: "+linea);
        }
        else if(numlinea == 2){//si la linea es 2 quiere decir que es el modelo
            text.setText("Modelo: "+linea);
        }
        else if(numlinea == 3){//si la linea es 3 quiere decir que es el kilometraje
            text.setText(linea+"km");
        }
        else if(numlinea == 4){//si la linea es 4 quiere decir que es el precio
            text.setText("Precio: $"+linea);
        }
        else if(numlinea == 5){
            //text.setText("");
        }

        text.setBounds(30,y+20,200,20);
        text.setForeground(Color.decode(colorEFondo));
        panel.add(text);
    }

    private void colocarImagenDeAuto(String nombre){
        ImageIcon imagDelAuto = new ImageIcon("Imagenes/"+nombre);
        JLabel imagen = new JLabel();
        imagen.setBounds(280,y-60,80,60);
        imagen.setIcon(new ImageIcon(imagDelAuto.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_SMOOTH)));

        panel.add(imagen);
    }

    private void boton(int numLineaComienzo,int numLineaFinal){
        botones.botonEliminar(panel,numLineaComienzo,numLineaFinal,y-25);
        botones.botonEditar(panel,y-55,numLineaComienzo,numLineaFinal);
    }
}

package com.company.Graficas;

import com.company.Colores;
import com.company.VentanasGenerales.VentanaInicial;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class BarraTitulo extends JFrame implements Colores{
    
    public BarraTitulo() {
    	this.setUndecorated(true);
    }
    
    //metodo para generar barra de titulo inicial
    public void crearBarraInicial(Panel panel,JFrame v) {
    	crearBotonCerrar(panel,v);
        crearBotonMin(panel,v);
    	
    	ImageIcon img = new ImageIcon("Iconos/BarraTitulo.png");
	
    	JLabel barra = new JLabel();
    	barra.setBounds(0,0,400,100);
    	barra.setIcon(new ImageIcon(img.getImage().getScaledInstance(barra.getWidth(),
    			barra.getHeight(),Image.SCALE_SMOOTH)));
    	barra.setFocusable(false);
	
    	panel.add(barra);
    	
    	accBarraInicial(barra,v);
    }

    //método para generar la barra de titulo
    public void crearBarra(Panel panel,JFrame v,String nom){
        crearBotonCerrar(panel,v);
        crearBotonMin(panel,v);

        JLabel nombre = new JLabel(nom);
        nombre.setBounds(5,5,200,10);
        nombre.setFont(new Font("arial",1,12));
        nombre.setForeground(Color.decode(colorFondo));
        nombre.setFocusable(false);
        panel.add(nombre);

        JLabel barra = new JLabel();
        barra.setOpaque(true);
        barra.setBounds(0,0,400,20);
        barra.setBackground(Color.decode(colorEFondo));
        barra.setFocusable(false);
        panel.add(barra);

        accBarra(barra,v);
    }
    
    private void crearBotonCerrar(Panel panel,JFrame v) {
    	JButton cerrar = new JButton();
        cerrar.setOpaque(true);
        cerrar.setBounds(370,5,30,10);
        cerrar.setBackground(Color.decode(colorFondo));
        cerrar.setBorder(null);
        cerrar.setFocusable(false);
        panel.add(cerrar);

        accBotonCerrar(cerrar,v);
    }
    
    private void crearBotonMin(Panel panel,JFrame v) {
    	JButton min = new JButton();
        min.setOpaque(true);
        min.setBounds(350,5,10,10);
        min.setBackground(Color.decode(colorFondo));
        min.setBorder(null);
        min.setFocusable(false);
        panel.add(min);

        accBotonMin(min,v);
    }

    //acciones del botón cerrar.
    private void accBotonCerrar(JButton cerrar,JFrame v){
        MouseListener c = new MouseListener() {//acciones con el ratón
            @Override
            public void mouseClicked(MouseEvent e) {//cuando se clickee el botón con el ratón
                if(v instanceof VentanaInicial){//si es la ventana inicial
                    System.exit(-1);//cierra por completo el programa
                }
                else {
                    v.dispose();//cierra sólo esta ventana
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {//cuando se mantenga precionado el boton

            }

            @Override
            public void mouseReleased(MouseEvent e) {//cuando se clickea y aunque se suelte el click en otra area

            }

            @Override
            public void mouseEntered(MouseEvent e) {//cuando el ratón entra en el area del botón
                cerrar.setBackground(Color.decode("0xFF0000"));//el botón se vuelve rojo
            }

            @Override
            public void mouseExited(MouseEvent e) {//cuando el ratón sale del area del botón
                cerrar.setBackground(Color.decode(colorFondo));//el botón vuelve a su color original
            }
        };

        cerrar.addMouseListener(c);
    }

    //acciones botón minimizar
    private void accBotonMin(JButton min,JFrame v){
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//cuando se clickea el mouse
                v.setExtendedState(ICONIFIED);//determina el tamaño de la pantalla, ICONIDIED es igual a minimizar
            }

            @Override
            public void mousePressed(MouseEvent e) {//cuando se amntiene presionado el clcik

            }

            @Override
            public void mouseReleased(MouseEvent e) {// igual al clicked pero realiza la acción aunque se suelte en otra area

            }

            @Override
            public void mouseEntered(MouseEvent e) {//cuando el mouse entra en el area del boton
                min.setBackground(Color.GRAY); //vuelve el botón de color gris
            }

            @Override
            public void mouseExited(MouseEvent e) {//cuando el mouse sale del area del boton
                min.setBackground(Color.decode(colorFondo));//vuelve el boton al color original
            }
        };

        min.addMouseListener(m);
    }

    //acciones barra
    private void accBarra(JLabel barra,JFrame v){
        final int[] x = {0};
        final int[] y = { 0 };
        MouseMotionListener mov = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                v.setLocation(point.x - x[0], point.y - y[0]);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                x[0] = e.getX();
                y[0] = e.getY();
            }
        };

        barra.addMouseMotionListener(mov);
    }
    
  //acciones barra
    private void accBarraInicial(JLabel barra,JFrame v){
        final int[] x = {0};
        final int[] y = { 0 };
        MouseMotionListener mov = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                v.setLocation(point.x - x[0], point.y - y[0]);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                x[0] = e.getX();
                y[0] = e.getY();
            }
        };

        barra.addMouseMotionListener(mov);
    }

    
}
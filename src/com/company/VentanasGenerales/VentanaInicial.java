package com.company.VentanasGenerales;

import com.company.Graficas.BarraTitulo;
import com.sun.awt.AWTUtilities;
import com.company.Colores;
import com.company.BotonesGenerales.BotonInicio;

import javax.swing.*;
import java.awt.*;

public class VentanaInicial extends JFrame implements Colores{
    private Panel panel = new Panel();
    private BarraTitulo barra = new BarraTitulo();
    private BotonInicio botones = new BotonInicio();

    public VentanaInicial(){
        setSize(400,500);//tamaño de ventana
        setLocationRelativeTo(null);//ventana en el centro de pantalla

        setResizable(false);//impide que la pantalla pueda cambiar su tamañano
        setUndecorated(true);//quita la barra de titulo para poder generar la barra como se desee

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//cierra el programa cuando se cierra la ventana
    }

    private void iniciarComponentes(){
        crearPanel();
        crearBoton();
        //barra.crearBarra(panel,this,"GestorFZ");
        barra.crearBarraInicial(panel,this);
    }

    private void crearPanel(){
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorFondo));//color al panel
        this.getContentPane().add(panel);//agregar panel a la ventana
    }

    private void crearBoton(){
        botones.botonNuevoAuto(panel);
        botones.botonAutosGuardados(panel);
    }
}

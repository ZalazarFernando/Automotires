package com.company.VentanasGenerales;

import com.company.Graficas.BarraTitulo;
import com.company.Colores;
import com.company.BotonesGenerales.BotonesVentanaPregunta;

import javax.swing.*;
import java.awt.*;

public class VentanaPregunta extends JFrame implements Colores{
    private Panel panel = new Panel();
    private BotonesVentanaPregunta botones = new BotonesVentanaPregunta();
    private BarraTitulo barra = new BarraTitulo();
    private String texto;

    public VentanaPregunta(int lineaComienzo,int lineaFinal,String texto){
        this.texto = texto;

        setSize(new Dimension(250,100));//tamaño de la ventana
        setLocationRelativeTo(null);//la ventana siempre aparece en el medio

        setResizable(false);//impide que la pantalla pueda cambiar su tamaño
        setUndecorated(true);

        iniciarComponentes(lineaComienzo,lineaFinal);
    }

    private void iniciarComponentes(int lineaComienzo,int lineaFinal){
        crearPanel();
        crearTextPregunta();
        botones.botonAfirmativo(panel, "Si", this, lineaComienzo, lineaFinal,texto);//colocando boton si
        botones.botonNegativo(panel, "No", this);//colocando boton no
        barra.crearBarra(panel,this,"GestorFZ");//colocando barra
    }

    private void crearPanel(){
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorFondo));
        this.getContentPane().add(panel);
    }

    private void crearTextPregunta(){
        JLabel pregunta = new JLabel(texto);
        pregunta.setForeground(Color.decode(colorEFondo));
        pregunta.setBounds(10,20,250,20);
        pregunta.setFont(new Font("arial",1,10));
        pregunta.setBackground(Color.decode(colorFondo));
        pregunta.setOpaque(true);

        panel.add(pregunta);
    }
}

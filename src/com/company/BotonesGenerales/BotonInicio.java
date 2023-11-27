package com.company.BotonesGenerales;

import com.company.VentanasGenerales.VentanaAutosGuardados;
import com.company.VentanasGenerales.VentanaGuardarAutos;
import com.company.VentanasGenerales.VentanaInicial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonInicio extends JButton{
	
    public void botonNuevoAuto(Panel panel) {
        ImageIcon imagBotonNuevo = new ImageIcon("Iconos/boton nuevo.png");
        
        JButton nuevoAuto = new JButton();
        nuevoAuto.setBounds(100, 110, 190, 190);
        nuevoAuto.setIcon(new ImageIcon(imagBotonNuevo.getImage().getScaledInstance(nuevoAuto.getWidth(), 
        		nuevoAuto.getHeight(), Image.SCALE_SMOOTH)));
        nuevoAuto.setContentAreaFilled(false);
        nuevoAuto.setBorder(null);

        panel.add(nuevoAuto);

        MouseListener accion = new MouseListener() {//acciones con el ratón
            @Override
            public void mouseClicked(MouseEvent e) {//cuando se clickee el botón con el ratón
            	VentanaGuardarAutos v1 = new VentanaGuardarAutos();
                v1.setVisible(true);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {//cuando se mantenga precionado el boton

            }

            @Override
            public void mouseReleased(MouseEvent e) {//cuando se clickea y aunque se suelte el click en otra area

            }

            @Override
            public void mouseEntered(MouseEvent e) {//cuando el raton entra en el area del botón
            	ImageIcon imagBotonNuevo = new ImageIcon("Iconos/boton nuevo luz.png");
            	nuevoAuto.setBorder(null);
                nuevoAuto.setBounds(100, 110, 190, 190);
                nuevoAuto.setIcon(new ImageIcon(imagBotonNuevo.getImage().getScaledInstance(nuevoAuto.getWidth()
                        , nuevoAuto.getHeight(), Image.SCALE_SMOOTH)));

                nuevoAuto.setContentAreaFilled(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {//cuando el ratón sale del area del botón
            	ImageIcon imagBotonNuevo = new ImageIcon("Iconos/boton nuevo.png");
            	nuevoAuto.setBorder(null);
                nuevoAuto.setBounds(100, 110, 190, 190);
                nuevoAuto.setIcon(new ImageIcon(imagBotonNuevo.getImage().getScaledInstance(nuevoAuto.getWidth()
                        , nuevoAuto.getHeight(), Image.SCALE_SMOOTH)));

                nuevoAuto.setContentAreaFilled(false);
            }
        };

        nuevoAuto.addMouseListener(accion);
    }

    public void botonAutosGuardados(Panel panel) {
        ImageIcon imagGuardados = new ImageIcon("Iconos/boton guardados.png");
        JButton botonGuardados = new JButton();
        botonGuardados.setBorder(null);
        botonGuardados.setBounds(100, 305, 190, 190);
        botonGuardados.setIcon(new ImageIcon(imagGuardados.getImage().getScaledInstance(botonGuardados.getWidth()
                , botonGuardados.getHeight(), Image.SCALE_SMOOTH)));

        botonGuardados.setContentAreaFilled(false);

        panel.add(botonGuardados);

		/*
		 * ActionListener accion = new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { VentanaAutosGuardados
		 * v1 = new VentanaAutosGuardados(); v1.setVisible(true); } };
		 */
        
        MouseListener accion = new MouseListener() {//acciones con el ratón
            @Override
            public void mouseClicked(MouseEvent e) {//cuando se clickee el botón con el ratón
            	VentanaAutosGuardados v1 = new VentanaAutosGuardados();
                v1.setVisible(true);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {//cuando se mantenga precionado el boton

            }

            @Override
            public void mouseReleased(MouseEvent e) {//cuando se clickea y aunque se suelte el click en otra area

            }

            @Override
            public void mouseEntered(MouseEvent e) {//cuando el raton entra en el area del botón
            	ImageIcon imagGuardados = new ImageIcon("Iconos/boton guardados luz.png");
            	botonGuardados.setBorder(null);
                botonGuardados.setBounds(100, 305, 190, 190);
                botonGuardados.setIcon(new ImageIcon(imagGuardados.getImage().getScaledInstance(botonGuardados.getWidth()
                        , botonGuardados.getHeight(), Image.SCALE_SMOOTH)));

                botonGuardados.setContentAreaFilled(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {//cuando el ratón sale del area del botón
            	ImageIcon imagGuardados = new ImageIcon("Iconos/boton guardados.png");
            	botonGuardados.setBorder(null);
                botonGuardados.setBounds(100, 305, 190, 190);
                botonGuardados.setIcon(new ImageIcon(imagGuardados.getImage().getScaledInstance(botonGuardados.getWidth()
                        , botonGuardados.getHeight(), Image.SCALE_SMOOTH)));

                botonGuardados.setContentAreaFilled(false);
            }
        };

        botonGuardados.addMouseListener(accion);
    }
}

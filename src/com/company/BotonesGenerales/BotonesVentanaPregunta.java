package com.company.BotonesGenerales;

import com.company.Colores;
import com.company.VentanasGenerales.VentanaEditarAuto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonesVentanaPregunta extends JFrame implements Colores{

    public void botonAfirmativo(Panel panel, String nom, JFrame v, int lineaComienzo,
                                int lineaFinal,String texto){

		
		  JButton afirmativo = new JButton(nom); 
		  afirmativo.setBounds(50,50,60,30);
		  afirmativo.setBackground(Color.decode(colorEFondo));
		  afirmativo.setForeground(Color.decode(colorFondo));
		  afirmativo.setBorder(null);
        
		  afirmativo.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				afirmativo.setBounds(50,50,60,30);
		        afirmativo.setBackground(Color.decode(colorLuminoso));
		        afirmativo.setForeground(Color.decode(colorFondo));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				afirmativo.setBounds(50,50,60,30);
		        afirmativo.setBackground(Color.decode(colorEFondo));
		        afirmativo.setForeground(Color.decode(colorFondo));
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

        panel.add(afirmativo);

        if(texto.equals("¿Desea eliminar el auto?")) {
            accAfirmativo(afirmativo, v, lineaComienzo, lineaFinal);
        }
        else{
            accAfirmativoEditar(afirmativo,v,lineaComienzo,lineaFinal);
        }
    }

    private void accAfirmativo(JButton afirmativo,JFrame v,int lineaComienzo,int lineaFinal){
        ActionListener accion = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BotonEliminarAutoGuardado.escribirArchivoB(lineaComienzo, lineaFinal);
                BotonEliminarAutoGuardado.reescribirArchivoA(lineaComienzo, lineaFinal);
                v.dispose();
            }
        };

        afirmativo.addActionListener(accion);
    }

    private void accAfirmativoEditar(JButton afirmativo,JFrame v,int lineaComienzo,int lineaFinal){
        VentanaEditarAuto v2 = new VentanaEditarAuto(lineaComienzo,lineaFinal);
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.dispose();
                v2.setVisible(true);
            }
        };

        afirmativo.addActionListener(accion);
    }

    public void botonNegativo(Panel panel,String nom,JFrame v){
        JButton negativo = new JButton(nom);
        negativo.setBounds(125,50,60,30);
        negativo.setBackground(Color.decode(colorEFondo));
        negativo.setForeground(Color.decode(colorFondo));
        negativo.setBorder(null);
        
        negativo.addMouseListener( new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) { }

			@Override
			public void mouseEntered(MouseEvent e) {
				negativo.setBounds(125,50,60,30);
		        negativo.setBackground(Color.decode(colorLuminoso));
		        negativo.setForeground(Color.decode(colorFondo));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				negativo.setBounds(125,50,60,30);
		        negativo.setBackground(Color.decode(colorEFondo));
		        negativo.setForeground(Color.decode(colorFondo));
			}

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }
        	
        });

        panel.add(negativo);

        accNegativo(negativo,v);
    }

    private void accNegativo(JButton negativo,JFrame v){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.dispose();
            }
        };
        negativo.addActionListener(accion);
    }
}

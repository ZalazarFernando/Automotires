package com.company.Graficas;

import javax.swing.*;
import java.awt.*;
//import java.util.List;

public class Imagenes extends JFrame{
    public void imagLinea(Panel panel,int x,int y) {
        ImageIcon imagLineaSep = new ImageIcon("Iconos/separacion.png");
        JLabel etiqLineaSep = new JLabel();
        etiqLineaSep.setBounds(x, y+20, 375, 15);
        etiqLineaSep.setIcon(new ImageIcon(imagLineaSep.getImage().getScaledInstance(etiqLineaSep.getWidth(), etiqLineaSep.getHeight(), Image.SCALE_SMOOTH)));

        panel.add(etiqLineaSep);
    }

    public void imagAuto(Panel panel,int x,int y) {
        ImageIcon imagAuto = new ImageIcon("Iconos/auto.png");
        JLabel etiqImagAuto = new JLabel();
        etiqImagAuto.setBounds(x, y, 30, 30);
        etiqImagAuto.setIcon(new ImageIcon(imagAuto.getImage().getScaledInstance(etiqImagAuto.getWidth(), etiqImagAuto.getHeight(), Image.SCALE_SMOOTH)));

        panel.add(etiqImagAuto);
    }

    public void imagItem(Panel panel,int x,int y) {
        ImageIcon imagenItem = new ImageIcon("Iconos/item.png");
        JLabel etiqImagItem = new JLabel();
        etiqImagItem.setBounds(x, y, 30, 30);
        etiqImagItem.setIcon(new ImageIcon(imagenItem.getImage().getScaledInstance(etiqImagItem.getWidth(), etiqImagItem.getHeight(), Image.SCALE_SMOOTH)));

        panel.add(etiqImagItem);
    }

    public void imgKM(Panel panel,int x,int y) {
        ImageIcon imagKMH = new ImageIcon("Iconos/kmh.png");
        JLabel etiqImagKMH = new JLabel();
        etiqImagKMH.setBounds(x, y, 30, 30);
        etiqImagKMH.setIcon(new ImageIcon(imagKMH.getImage().getScaledInstance(etiqImagKMH.getWidth(), etiqImagKMH.getHeight(), Image.SCALE_SMOOTH)));

        panel.add(etiqImagKMH);
    }

    public void imagPrecio(Panel panel,int x,int y) {
        ImageIcon imagPrecio = new ImageIcon("Iconos/precio.png");
        JLabel etiqPrecio = new JLabel();
        etiqPrecio.setBounds(x, y, 30, 30);
        etiqPrecio.setIcon(new ImageIcon(imagPrecio.getImage().getScaledInstance(etiqPrecio.getWidth(), etiqPrecio.getHeight(), Image.SCALE_SMOOTH)));

        panel.add(etiqPrecio);
    }

    private void imagTanque(Panel panel){
        /*ImageIcon imagTanque = new ImageIcon("tanque.png");
        JLabel etiqTanque = new JLabel();
        etiqTanque.setBounds(10,195,30,30);
        etiqTanque.setIcon(new ImageIcon(imagTanque.getImage().getScaledInstance(etiqTanque.getWidth(),etiqTanque.getHeight(),Image.SCALE_SMOOTH)));

        panel.add(etiqTanque);

        ImageIcon imagAceite = new ImageIcon("aceite.png");
        JLabel etiqImagAceite = new JLabel();
        etiqImagAceite.setBounds(10,250,30,30);
        etiqImagAceite.setIcon(new ImageIcon(imagAceite.getImage().getScaledInstance(etiqImagAceite.getWidth(),etiqImagAceite.getHeight(),Image.SCALE_SMOOTH)));

        panel.add(etiqImagAceite);*/
    }
}

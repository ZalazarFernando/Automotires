package com.company.BotonesGenerales;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class AbrirArchivo extends JFrame {
    //variables de archivos
    FileInputStream entrada;
    FileOutputStream salida;

    //colores
    String colorFondo = "0x1C1C1C";
    String colorEFondo = "0x3f51b5";

    public byte[] abrirImagen(File archivo) {
        byte[] bytesImgen = new byte[1024 * 100];

        try {
            entrada = new FileInputStream(archivo);
            entrada.read(bytesImgen);
        } catch (Exception e) {

        }

        return bytesImgen;
    }

    public String guardarImagen(File archivo, byte[] bytesImagen) {
        String respuesta = null;

        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImagen);
            respuesta = "la imagen se guardo con exito";
        } catch (Exception e) {

        }

        return respuesta;
    }
}
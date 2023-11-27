package com.company.VentanasGenerales;

import com.company.Colores;
import com.company.BotonesGenerales.BotonGuardarCambios;
import com.company.Graficas.BarraTitulo;
import com.company.Graficas.Imagenes;

//BORRAR EL AUTO ANTERIOR PARA LUEGO GUARDAR LOS CAMBIOS

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;

public class VentanaEditarAuto extends JFrame implements Colores{
    Panel panel = new Panel();
    BarraTitulo barra = new BarraTitulo();
    BotonGuardarCambios botonG = new BotonGuardarCambios();

    //datos del auto
    private JComboBox marcasDeAutos;
    private JTextField modelo;
    private JTextField km;
    private JTextField precio;

    //variables que obtienen los datos del archivo
    private String modelotxt,kmtxt,preciotxt,index,imagen;

    //lineas entre las que se encuentra el auto
    private int lineaComienzo, lineaFinal;

    public VentanaEditarAuto(int lineaComienzo,int lineaFinal) {
        this.lineaComienzo = lineaComienzo;
        this.lineaFinal = lineaFinal;

        setSize(400, 300);//Tamaño de la ventana
        setLocationRelativeTo(null);

        setResizable(false);//impide que la pantalla pueda cambiar su tamaño
        setUndecorated(true);//Borra la barra de titulo para poder crearla a placer

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        crearPanel();
        obtenerDatos();
        colocarListas();
        colocarText();
        imagenes();
        barra.crearBarra(panel, this, "GestorFZ - Editar Auto");
        botonG.botonGuardado(panel, modelo, km, precio, marcasDeAutos, this,imagen,lineaComienzo,lineaFinal);
        botonG.colocarFoto(imagen,panel,this);
    }

    private void crearPanel() {
        panel.setLayout(null);
        panel.setBackground(Color.decode(colorFondo));
        getContentPane().add(panel);
    }

    private void imagenes() {
        Imagenes img = new Imagenes();
        img.imagAuto(panel, 10, 30);
        img.imagItem(panel, 35, 60);
        img.imgKM(panel, 10, 130);
        img.imagPrecio(panel, 10, 190);
        img.imagLinea(panel, 5, 285);
    }

    private void colocarListas() {
        String[] marcas = {"Alfa Romero","Aro","Aston Martin","Audi","BAIC","Bently","BMW","Bugatti","Cadillac","Changan",
                           "Chery","Chevrolet","Chrisller","Citroen","Cupra","Dacia","Daewoo","Daihatsu","DFSK","DS","Dodge",
                            "Ferrari","Fiat","Ford","Foton","Geely","Great Wall","Haval","Hispano Suiza","Honda","Hummer",
                            "Hyundai","Infiniti","Isuzu","JAC","Jaguar","Jeep","Kia","Lamborghini","Lancia","Land Rover",
                            "Lifan","Lexus","Lotus","Maserati","Mazda","McLaren","Mercedez-Benz","Mini Couper","Mitsubishi",
                            "Nissan","Opel","Pagani","Peugeot","Piagio","Polestar","Pontiac","Porsche","RAM","Renault",
                            "Rivian","Rolls Royce","Rover","SEAT","Shineray","Skoda","Smart","SsangYoung","Subaru",
                            "Suzuki","Tata","Tesla","Torino","Toyota","Volkswagen","Volvo"};
        marcasDeAutos = new JComboBox(marcas);
        marcasDeAutos.setBounds(60, 35, 200, 20);
        marcasDeAutos.setSelectedIndex(encontrarIndice());

        panel.add(marcasDeAutos);
    }

    private void colocarText() {
        textModelo();
        textKM();
        textPrecio();
    }

    private void textModelo() {
        modelo = new JTextField(modelotxt);
        modelo.setBounds(70, 80, 200, 20);
        modelo.setForeground(Color.GRAY);
        modelo.setFont(new Font("arial", 2, 12));

        modelo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (modelo.getText().equals(modelotxt)) {
                    modelo.setText("");
                    modelo.setForeground(Color.black);
                    modelo.setFont(new Font("arial", 0, 12));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (modelo.getText().isEmpty()) {
                    modelo.setForeground(Color.GRAY);
                    modelo.setText(modelotxt);
                    modelo.setFont(new Font("arial", 2, 12));
                }
            }
        }
        );

        panel.add(modelo);
    }

    private void textKM() {
        km = new JTextField(kmtxt);
        km.setBounds(60, 137, 150, 20);
        km.setForeground(Color.GRAY);
        km.setFont(new Font("arial", 2, 12));

        km.addFocusListener(new FocusListener() {
                                @Override
                                public void focusGained(FocusEvent e) {
                                    if (km.getText().equals(kmtxt)) {
                                        km.setText("");
                                        km.setForeground(Color.black);
                                        km.setFont(new Font("arial", 0, 12));
                                    }
                                }

                                @Override
                                public void focusLost(FocusEvent e) {
                                    if (km.getText().isEmpty()) {
                                        km.setForeground(Color.GRAY);
                                        km.setText(kmtxt);
                                        km.setFont(new Font("arial", 2, 12));
                                    }
                                }
                            }
        );

        panel.add(km);
    }

    private void textPrecio() {
        precio = new JTextField(preciotxt);
        precio.setBounds(60, 197, 100, 20);
        precio.setForeground(Color.GRAY);
        precio.setFont(new Font("arial", 2, 12));

        precio.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (precio.getText().equals(preciotxt)) {
                    precio.setText("");
                    precio.setForeground(Color.BLACK);
                    precio.setFont(new Font("arial", 0, 12));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (precio.getText().isEmpty()) {
                    precio.setForeground(Color.GRAY);
                    precio.setText(preciotxt);
                    precio.setFont(new Font("arial", 2, 12));
                }
            }
        });

        panel.add(precio);
    }

    private void obtenerDatos() {
        File f = new File("Autos.txt");
        String lectura;
        int car = 0;
        int cont=0,contAreaEncontrada=0;
        char indice;

        if (!f.exists()) {//si no existe el archivo lo crea
            try {
                f.createNewFile();
                System.out.println(f.getName() + " Ah sido creado");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {//si existe, lo usa para escribir
            try {
                FileReader r = new FileReader(f);
                BufferedReader br = new BufferedReader(r);

                while ((lectura = br.readLine()) != null) {
                    if (cont > lineaComienzo-2 && cont < lineaFinal+8) {
                        if (contAreaEncontrada == 2) {
                            modelotxt = lectura;//le da a la nueva ventana el modelo del auto
                        } else if (contAreaEncontrada == 3) {
                            kmtxt = lectura;//le da a la nueva ventana el kilometraje del auto
                        } else if (contAreaEncontrada == 4) {
                            preciotxt = lectura;//le da a la nueva ventana el precio del auto
                        } else if(contAreaEncontrada == 5){
                            imagen = lectura;
                        }
                        if (lectura.indexOf("+")>-1) {
                            index = lectura;/*obtiene lo que hay después del más
                                             *(donde se guarda el indice de la lista autos */
                        }

                        contAreaEncontrada++;
                        cont++;
                    }
                    cont++;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private int encontrarIndice(){
        String aux = null;
        int indice;
        for(int i=0;i<index.length();i++){
            if(index.equals("+")){
                continue;
            }
            aux = index.substring(i);
        }
        index = aux;
        indice = Integer.parseInt(aux);

        return indice;
    }
}
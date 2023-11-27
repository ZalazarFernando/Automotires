package com.company;

public class Autos {
	private String marca, modelo, km, precio;
	
	public Autos() {
		
	}

	public Autos(String marca, String modelo, String km, String precio) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setKm(km);
		this.setPrecio(precio);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
}

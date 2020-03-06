/**
 * 
 */
package com.pedro.modelo;

/**
 * @author Westermeyer
 *
 */
public class Carrito {
	
	private String nombre;
	
	private String descripcion;
	
	private double peso;
	
	private Integer categoria;
	
	private int unidades;
	
	public Carrito() {
		super();
	}
	
	public Carrito(String nombre, String descripcion, double peso, int unidades) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.unidades = unidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

}

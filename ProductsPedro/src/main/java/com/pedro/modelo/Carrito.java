/**
 * 
 */
package com.pedro.modelo;

// TODO: Auto-generated Javadoc
/**
 * The Class Carrito.
 *
 * @author Westermeyer
 */
public class Carrito {
	
	/** The cod prod. */
	private Integer codProd;
	
	/** The nombre. */
	private String nombre;
	
	/** The descripcion. */
	private String descripcion;
	
	/** The peso. */
	private double peso;
	
	/** The categoria. */
	private Integer categoria;
	
	/** The unidades. */
	private int unidades;

	/**
	 * Instantiates a new carrito.
	 */
	public Carrito() {
		super();
	}
	
	/**
	 * Instantiates a new carrito.
	 *
	 * @param codProd the cod prod
	 * @param nombre the nombre
	 * @param descripcion the descripcion
	 * @param peso the peso
	 * @param unidades the unidades
	 */
	public Carrito(Integer codProd, String nombre, String descripcion, double peso, int unidades) {
		super();
		this.codProd = codProd;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.unidades = unidades;
	}
	
	/**
	 * Gets the cod prod.
	 *
	 * @return the cod prod
	 */
	public Integer getCodProd() {
		return codProd;
	}

	/**
	 * Sets the cod prod.
	 *
	 * @param codProd the new cod prod
	 */
	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}

	/**
	 * Gets the unidades.
	 *
	 * @return the unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * Sets the unidades.
	 *
	 * @param unidades the new unidades
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Gets the peso.
	 *
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Sets the peso.
	 *
	 * @param peso the new peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public Integer getCategoria() {
		return categoria;
	}

	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

}

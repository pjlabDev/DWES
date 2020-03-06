/**
 * 
 */
package com.pedro.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Productos.
 *
 * @author estudiante
 */

@Entity
@Table(name="Productos")
public class Productos {
	
	/** The CodProd. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodProd;
	
	/** The Nombre. */
	@NotNull
	@Column
	private String Nombre;
	
	/** The Descripcion. */
	@NotNull
	@Column
	private String Descripcion;
	
	/** The Peso. */
	@NotNull
	@Column
	private double Peso;
	
	/** The Stock. */
	@NotNull
	@Column
	private int Stock;
	
	/** The Categoria. */
	@NotNull
	@Column
	private int Categoria;
	
	/**
	 * Instantiates a new productos.
	 *
	 * @param CodProd the cod prod
	 * @param Nombre the nombre
	 * @param Descripcion the descripcion
	 * @param Peso the peso
	 * @param Stock the stock
	 * @param Categoria the categoria
	 */
	public Productos(int CodProd, String Nombre, String Descripcion, double Peso, int Stock, int Categoria) {
		this.CodProd = CodProd;
		this.Nombre = Nombre;
		this.Descripcion = Descripcion;
		this.Peso = Peso;
		this.Stock = Stock;
		this.Categoria = Categoria;
	}
	
	public Productos() {
		
	}

	/**
	 * Gets the cod prod.
	 *
	 * @return the cod prod
	 */
	public int getCodProd() {
		return CodProd;
	}

	/**
	 * Sets the cod prod.
	 *
	 * @param codProd the new cod prod
	 */
	public void setCodProd(int codProd) {
		CodProd = codProd;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return Descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	/**
	 * Gets the peso.
	 *
	 * @return the peso
	 */
	public double getPeso() {
		return Peso;
	}

	/**
	 * Sets the peso.
	 *
	 * @param peso the new peso
	 */
	public void setPeso(double peso) {
		Peso = peso;
	}

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	public int getStock() {
		return Stock;
	}

	/**
	 * Sets the stock.
	 *
	 * @param stock the new stock
	 */
	public void setStock(int stock) {
		Stock = stock;
	}

	/**
	 * Gets the categoria.
	 *
	 * @return the categoria
	 */
	public int getCategoria() {
		return Categoria;
	}

	/**
	 * Sets the categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	
}

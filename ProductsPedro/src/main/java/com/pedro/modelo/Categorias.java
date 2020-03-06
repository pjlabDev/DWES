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

/**
 * The Class Categorias.
 *
 * @author estudiante
 */

@Entity
@Table
public class Categorias {

	/** The Codat. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int CodCat;
	
	/** The Nombre. */
	@NotNull
	@Column
	private String Nombre;
	
	/** The Descripcion. */
	@NotNull
	@Column
	private String Descripcion;
	
	/**
	 * Instantiates a new categorias.
	 *
	 * @param CodCat the codcat
	 * @param Nombre the nombre
	 * @param Descripcion the descripcion
	 */
	public Categorias(int CodCat, String Nombre, String Descripcion) {
		this.CodCat = CodCat;
		this.Nombre = Nombre;
		this.Descripcion = Descripcion;
	}
	
	public Categorias() {
		
	}
	
	public int getCodCat() {
		return CodCat;
	}

	public void setCodCat(int codCat) {
		CodCat = codCat;
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
	
}

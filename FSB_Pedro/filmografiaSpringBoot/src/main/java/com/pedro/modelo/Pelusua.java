/**
 * 
 */
package com.pedro.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author usuario
 *
 */
@Entity
@Table
public class Pelusua {

	@Id
	private int iDPelicula;
	
	private int iDUsuario;
	
	private int calificacion;

	public Pelusua(int idPelicula, int idUsuario, int calificacion) {

		this.iDPelicula = idPelicula;
		this.iDUsuario = idUsuario;
		this.calificacion = calificacion;

	}
	
	public Pelusua() {
		
	}

	public int getIdPelicula() {
		return iDPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.iDPelicula = idPelicula;
	}

	public int getIdUsuario() {
		return iDUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.iDUsuario = idUsuario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}

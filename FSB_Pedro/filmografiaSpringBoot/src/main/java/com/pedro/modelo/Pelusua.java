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
	private int IDPelicula;
	
	private int IDUsuario;
	
	private int Calificacion;

	public Pelusua(int idPelicula, int idUsuario, int calificacion) {

		this.IDPelicula = idPelicula;
		this.IDUsuario = idUsuario;
		this.Calificacion = calificacion;

	}
	
	public Pelusua() {
		
	}

	public int getIdPelicula() {
		return IDPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.IDPelicula = idPelicula;
	}

	public int getIdUsuario() {
		return IDUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.IDUsuario = idUsuario;
	}

	public int getCalificacion() {
		return Calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.Calificacion = calificacion;
	}

}

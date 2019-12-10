/**
 * 
 */
package com.pedro.filmografia.domain;

import javax.validation.constraints.Size;

/**
 * @author pedro
 *
 */
public class Pelicula {

	@Size(min = 2, max = 20)
	private String director;
	
	private String titulo;
	private String fecha;

	public Pelicula(String director, String titulo, String fecha) {

		this.director = director;
		this.titulo = titulo;
		this.fecha = fecha;

	}

	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}

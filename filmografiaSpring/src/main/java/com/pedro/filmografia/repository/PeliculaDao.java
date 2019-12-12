/**
 * 
 */
package com.pedro.filmografia.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

import com.pedro.filmografia.domain.Pelicula;
import com.pedro.filmografia.domain.Usuario;

/**
 * @author pedro
 *
 */
public interface PeliculaDao {
	
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException;
	public List<Usuario> mostrarUsuarios() throws SQLException;
	public String loginDirector(String nombre, String password) throws SQLException;
	public List<Pelicula> mostrarPelis() throws SQLException;
	public String altaDirector(String director, String pass) throws SQLException;
	public String altaPelicula(String director, String titulo, String fecha) throws SQLException;
	public String modificarPelicula(String director, String tituloPeli, String fecha, String titulo) throws SQLException;
	public String eliminarPelicula(String titulo) throws SQLException;
	public TreeSet<String> listaDirectores();
	
}

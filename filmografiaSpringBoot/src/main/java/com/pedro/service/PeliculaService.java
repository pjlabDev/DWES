/**
 * 
 */
package com.pedro.service;

import java.sql.SQLException;
import java.util.List;
import java.util.TreeSet;

import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;

/**
 * @author pedro
 *
 */
public interface PeliculaService {
	
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException;
	public List<Usuario> mostrarUsuarios() throws SQLException;
	public List<Usuario> loginDirector(String nombre, String password) throws SQLException;
	public List<Pelicula> mostrarPelis() throws SQLException;
	public void altaDirector(String director, String pass) throws SQLException;
	public void altaPelicula(String director, String titulo, String fecha) throws SQLException;
	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo) throws SQLException;
	public void eliminarPelicula(String titulo) throws SQLException;
	public TreeSet<String> listaDirectores();
	
}

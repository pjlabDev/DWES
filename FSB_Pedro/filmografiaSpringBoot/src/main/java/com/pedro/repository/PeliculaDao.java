/**
 * 
 */
package com.pedro.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;

/**
 * @author pedro
 *
 */
public interface PeliculaDao {
	
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException;
	public List<Usuario> mostrarUsuarios() throws SQLException;
	public List<Usuario> loginDirector(String nombre, String password) throws SQLException;
	public List<Pelicula> mostrarPelis() throws SQLException;
	public void altaUsuario(String nombre, String apellidos, String usuario, String pass) throws SQLException;
	public void altaPelicula(String director, String titulo, String fecha, String foto, String descripcion) throws SQLException;
	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo, String foto, String descripcion) throws SQLException;
	public void eliminarPelicula(String titulo) throws SQLException;
	public List<Pelicula> buscarPelis(String titulo, String director) throws SQLException;
	public String calificarPeli(int idPelicula, int idUsuario, int calificacion) throws SQLException;
	public List<Integer> sacarIDUser(String usuario) throws SQLException;
	public Set<String> listaDirectores();
	
}

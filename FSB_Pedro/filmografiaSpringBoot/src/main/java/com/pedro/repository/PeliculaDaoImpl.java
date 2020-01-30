/**
 * 
 */
package com.pedro.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;
import com.pedro.service.PeliculaServiceImpl;

/**
 * @author pedro
 *
 */
@Repository("peliculaDao")
public class PeliculaDaoImpl {

	PeliculaServiceImpl pService = new PeliculaServiceImpl();
	List<Pelicula> listaPelis;
	Set<String> listaDirectores = new TreeSet<>();


	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPeliculasDirector(director);

		return listaPelis;

	}


	public List<Usuario> loginDirector(String nombre, String password) throws SQLException {

		List<Usuario> listaUser;

		listaUser = pService.loginDirector(nombre, password);

		return listaUser;

	}


	public List<Pelicula> mostrarPelis() throws SQLException{

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPelis();
		
		return listaPelis;

	}


	public void altaUsuario(String nombre, String apellidos, String usuario, String pass) throws SQLException {

		pService.altaUsuario(nombre, apellidos, usuario, pass);
	}


	public void altaPelicula(String director, String titulo, String fecha, String foto, String descripcion) throws SQLException {

		pService.altaPelicula(director, titulo, fecha, foto, descripcion);
	}


	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo, String foto, String descripcion) throws SQLException {

		pService.modificarPelicula(director, tituloPeli, fecha, titulo, foto, descripcion);
	}


	public void eliminarPelicula(String titulo) throws SQLException {
		
		pService.eliminarPelicula(titulo);
	}

	
	public Set<String> listaDirectores() {
	
		listaDirectores = pService.listaDirectores();
		
		return listaDirectores;

	}


	public List<Usuario> mostrarUsuarios() throws SQLException{
		List<Usuario> listaUsers;

		listaUsers = pService.mostrarUsuarios();

		return listaUsers;
	}


	public List<Pelicula> buscarPelis(String titulo, String director) throws SQLException {
		
		listaPelis = new ArrayList<>();
		
		listaPelis = pService.buscarPelis(titulo, director);

		return listaPelis;
	}


	public String calificarPeli(int idPelicula, int idUsuario, int calificacion) throws SQLException {
		
		String message;
		
		message = pService.calificarPeli(idPelicula, idUsuario, calificacion);
		
		return message;
	}


	public List<Integer> sacarIDUser(String usuario) {
		
		List<Integer> id;
		
		id = pService.sacarIDUser(usuario);
		
		return id;
	}

}

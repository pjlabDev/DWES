/**
 * 
 */
package com.pedro.filmografia.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.pedro.filmografia.domain.Pelicula;
import com.pedro.filmografia.domain.Usuario;
import com.pedro.filmografia.service.PeliculaServiceImpl;

/**
 * @author pedro
 *
 */
@Repository(value = "peliculaDao")
public class PeliculaDaoImpl implements PeliculaDao {

	PeliculaServiceImpl pService = new PeliculaServiceImpl();
	List<Pelicula> listaPelis;
	TreeSet<String> listaDirectores = new TreeSet<>();

	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPeliculasDirector(director);

		return listaPelis;

	}

	public String loginDirector(String nombre, String password) throws SQLException {

		String linea = null;

		linea = pService.loginDirector(nombre, password);

		return linea;

	}

	public List<Pelicula> mostrarPelis() throws SQLException {

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPelis();
		
		return listaPelis;

	}

	public String altaDirector(String director, String pass) throws SQLException {

		String message = null;

		message = pService.altaDirector(director, pass);

		return message;

	}

	public String altaPelicula(String director, String titulo, String fecha) throws SQLException {

		String message = null;

		message = pService.altaPelicula(director, titulo, fecha);
		
		return message;

	}

	public String modificarPelicula(String director, String tituloPeli, String fecha, String titulo)
			throws SQLException {

		String message;

		message = pService.modificarPelicula(director, tituloPeli, fecha, titulo);

		return message;
	}

	public String eliminarPelicula(String titulo) throws SQLException {

		String message = null;

		message = pService.eliminarPelicula(titulo);

		return message;

	}

	public TreeSet<String> listaDirectores() {
		
		listaDirectores = pService.listaDirectores();
		
		return listaDirectores;

	}

	@Override
	public List<Usuario> mostrarUsuarios() throws SQLException {
		List<Usuario> listaUsers = new ArrayList<>();

		listaUsers = pService.mostrarUsuarios();

		return listaUsers;
	}

}

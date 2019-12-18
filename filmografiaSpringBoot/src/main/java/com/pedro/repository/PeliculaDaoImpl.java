/**
 * 
 */
package com.pedro.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;
import com.pedro.service.PeliculaServiceImpl;

/**
 * @author pedro
 *
 */
@Repository("peliculaDao")
public class PeliculaDaoImpl implements PeliculaDao {

	PeliculaServiceImpl pService = new PeliculaServiceImpl();
	List<Pelicula> listaPelis;
	TreeSet<String> listaDirectores = new TreeSet<>();

	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPeliculasDirector(director);

		return listaPelis;

	}

	public List<Usuario> loginDirector(String nombre, String password) throws SQLException {

		List<Usuario> listaUser = new ArrayList<>();

		listaUser = pService.loginDirector(nombre, password);

		return listaUser;

	}

	public List<Pelicula> mostrarPelis() throws SQLException{

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPelis();
		
		return listaPelis;

	}

	public void altaUsuario(String director, String pass) throws SQLException, MySQLIntegrityConstraintViolationException {

		pService.altaUsuario(director, pass);
	}

	public void altaPelicula(String director, String titulo, String fecha) throws SQLException {

		pService.altaPelicula(director, titulo, fecha);
	}

	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo) throws SQLException {

		pService.modificarPelicula(director, tituloPeli, fecha, titulo);
	}

	public void eliminarPelicula(String titulo) throws SQLException {
		
		pService.eliminarPelicula(titulo);
	}

	public TreeSet<String> listaDirectores() {
	
		listaDirectores = pService.listaDirectores();
		
		return listaDirectores;

	}

	@Override
	public List<Usuario> mostrarUsuarios() throws SQLException{
		List<Usuario> listaUsers = new ArrayList<>();

		listaUsers = pService.mostrarUsuarios();

		return listaUsers;
	}

}

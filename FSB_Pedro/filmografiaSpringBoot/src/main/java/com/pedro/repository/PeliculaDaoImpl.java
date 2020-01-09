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

	@Override
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPeliculasDirector(director);

		return listaPelis;

	}

	@Override
	public List<Usuario> loginDirector(String nombre, String password) throws SQLException {

		List<Usuario> listaUser = new ArrayList<>();

		listaUser = pService.loginDirector(nombre, password);

		return listaUser;

	}

	@Override
	public List<Pelicula> mostrarPelis() throws SQLException{

		listaPelis = new ArrayList<>();
		
		listaPelis = pService.mostrarPelis();
		
		return listaPelis;

	}

	@Override
	public void altaUsuario(String director, String pass) throws SQLException, MySQLIntegrityConstraintViolationException {

		pService.altaUsuario(director, pass);
	}

	@Override
	public void altaPelicula(String director, String titulo, String fecha, String foto, String descripcion) throws SQLException {

		pService.altaPelicula(director, titulo, fecha, foto, descripcion);
	}

	@Override
	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo, String foto, String descripcion) throws SQLException {

		pService.modificarPelicula(director, tituloPeli, fecha, titulo, foto, descripcion);
	}

	@Override
	public void eliminarPelicula(String titulo) throws SQLException {
		
		pService.eliminarPelicula(titulo);
	}

	@Override
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

	@Override
	public List<Pelicula> buscarPelis(String titulo, String director) throws SQLException {
		
		listaPelis = new ArrayList<>();
		
		listaPelis = pService.buscarPelis(titulo, director);

		return listaPelis;
	}

	@Override
	public void calificarPeli(int idPelicula, int idUsuario, int calificacion) throws SQLException {
		
		pService.calificarPeli(idPelicula, idUsuario, calificacion);
		
	}

	@Override
	public List<Integer> sacarIDUser(String usuario) throws SQLException {
		
		List<Integer> id = new ArrayList<Integer>();
		
		id = pService.sacarIDUser(usuario);
		
		return id;
	}

}

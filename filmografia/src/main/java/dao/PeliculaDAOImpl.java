/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pelicula;

/**
 * @author usuario
 *
 */
public class PeliculaDAOImpl implements PeliculaDAO {

	BBDD bd = new BBDD();

	@Override
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {
		// TODO Auto-generated method stub
		List<Pelicula> listaPelis = new ArrayList<>();

		listaPelis = bd.mostrarPeliculasDirector(director);

		return listaPelis;
	}

	@Override
	public String loginDirector(String nombre, String password) throws SQLException {
		// TODO Auto-generated method stub
		String linea;

		linea = bd.loginDirector(nombre, password);

		return linea;
	}

	@Override
	public List<Pelicula> mostrarPelis() throws SQLException {
		// TODO Auto-generated method stub
		List<Pelicula> listaPelis = new ArrayList<>();

		listaPelis = bd.mostrarPelis();

		return listaPelis;
	}

	@Override
	public String altaDirector(String director, String pass) throws SQLException {
		// TODO Auto-generated method stub
		String message;

		message = bd.altaDirector(director, pass);

		return message;
	}

	@Override
	public String altaPelicula(String director, String titulo, String fecha) throws SQLException {
		// TODO Auto-generated method stub

		String message;

		message = bd.altaPelicula(director, titulo, fecha);

		return message;
	}

	@Override
	public String modificarPelicula(String director, String tituloPeli, String fecha, String titulo) throws SQLException {
		// TODO Auto-generated method stub
		String message;
		
		message = bd.modificarPelicula(director, tituloPeli, fecha, titulo);
		
		return message;
	}

	@Override
	public String eliminarPelicula(String titulo) throws SQLException {
		// TODO Auto-generated method stub
		String message;
		
		message = bd.eliminarPelicula(titulo);
		
		return message;
	}

}

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

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;
import com.pedro.service.ProductServiceImpl;

/**
 * @author pedro
 *
 */
@Repository("productRepository")
public class ProductRepository {

	ProductServiceImpl pService = new ProductServiceImpl();
	List<Categorias> listaCat;
	List<Productos> listaProd;
	Set<String> listaDirectores = new TreeSet<>();
	List<Carrito> listaCarrito;

	
	public List<Restaurantes> login(String correo, String clave) throws SQLException {

		List<Restaurantes> listaRes;

		listaRes = pService.login(correo, clave);

		return listaRes;

	}
	
	public List<Categorias> mostrarNombreCategorias1() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pService.mostrarNombreCategorias1();

		return listaCat;

	}
	
	public List<Categorias> mostrarNombreCategorias2() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pService.mostrarNombreCategorias2();

		return listaCat;

	}
	
	public List<Categorias> mostrarNombreCategorias3() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pService.mostrarNombreCategorias3();

		return listaCat;

	}
	
	public List<Productos> mostrarProductosxCat(int codCat) throws SQLException{
		
		listaProd = new ArrayList<>();
		
		listaProd = pService.mostrarProductosxCat(codCat);
		
		return listaProd;
		
	}
	
	public List<Carrito> agregarCarrito(String nombre, String descripcion, double peso, int unidades) {
		
		listaCarrito = pService.agregarCarrito(nombre, descripcion, peso, unidades);
		
		return listaCarrito;
		
	}


//	public List<Pelicula> mostrarPelis() throws SQLException{
//
//		listaPelis = new ArrayList<>();
//		
//		listaPelis = pService.mostrarPelis();
//		
//		return listaPelis;
//
//	}
//
//
//	public void altaUsuario(String nombre, String apellidos, String usuario, String pass) throws SQLException {
//
//		pService.altaUsuario(nombre, apellidos, usuario, pass);
//	}
//
//
//	public void altaPelicula(String director, String titulo, String fecha, String foto, String descripcion) throws SQLException {
//
//		pService.altaPelicula(director, titulo, fecha, foto, descripcion);
//	}
//
//
//	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo, String foto, String descripcion) throws SQLException {
//
//		pService.modificarPelicula(director, tituloPeli, fecha, titulo, foto, descripcion);
//	}
//
//
//	public void eliminarPelicula(String titulo) throws SQLException {
//		
//		pService.eliminarPelicula(titulo);
//	}
//
//	
//	public Set<String> listaDirectores() {
//	
//		listaDirectores = pService.listaDirectores();
//		
//		return listaDirectores;
//
//	}
//
//
//	public List<Usuario> mostrarUsuarios() throws SQLException{
//		List<Usuario> listaUsers;
//
//		listaUsers = pService.mostrarUsuarios();
//
//		return listaUsers;
//	}
//
//
//	public List<Pelicula> buscarPelis(String titulo, String director) throws SQLException {
//		
//		listaPelis = new ArrayList<>();
//		
//		listaPelis = pService.buscarPelis(titulo, director);
//
//		return listaPelis;
//	}
//
//
//	public String calificarPeli(int idPelicula, int idUsuario, int calificacion) throws SQLException {
//		
//		String message;
//		
//		message = pService.calificarPeli(idPelicula, idUsuario, calificacion);
//		
//		return message;
//	}
//
//
//	public List<Integer> sacarIDUser(String usuario) {
//		
//		List<Integer> id;
//		
//		id = pService.sacarIDUser(usuario);
//		
//		return id;
//	}

}

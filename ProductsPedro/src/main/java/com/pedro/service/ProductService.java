/**
 * 
 */
package com.pedro.service;


import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;

/**
 * @author pedro
 *
 */
public interface ProductService {
	
	public List<Categorias> mostrarNombreCategorias1() throws SQLException;
	public List<Categorias> mostrarNombreCategorias2() throws SQLException;
	public List<Categorias> mostrarNombreCategorias3() throws SQLException;
	public List<Productos> mostrarProductosxCat(int codCat) throws SQLException;
	public List<Carrito> agregarCarrito(String nombre, String descripcion, double peso, int unidades);
//	public List<Usuario> mostrarUsuarios() throws SQLException;
	public List<Restaurantes> login(String correo, String clave) throws SQLException;
//	public List<Pelicula> mostrarPelis() throws SQLException;
//	public void altaUsuario(String nombre, String apellidos, String usuario, String pass) throws SQLException;
//	public void altaPelicula(String director, String titulo, String fecha, String foto, String descripcion) throws SQLException;
//	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo, String foto, String descripcion) throws SQLException;
//	public void eliminarPelicula(String titulo) throws SQLException;
//	public List<Pelicula> buscarPelis(String titulo, String director) throws SQLException;
//	public String calificarPeli(int idPelicula, int idUsuario, int calificacion) throws SQLException;
//	public List<Integer> sacarIDUser(String usuario) throws SQLException;
//	public Set<String> listaDirectores();
	
}

/**
 * 
 */
package com.pedro.service;


import java.sql.SQLException;
import java.util.List;

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
	public List<Carrito> agregarCarrito(Integer codProd, String nombre, String descripcion, double peso, int unidades);
	public List<Restaurantes> login(String correo, String clave) throws SQLException;
	public List<Carrito> verCarrito();
	
}

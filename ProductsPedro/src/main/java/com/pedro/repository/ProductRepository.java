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
	
	public List<Carrito> agregarCarrito(Integer codProd, String nombre, String descripcion, double peso, int unidades) {
		
		listaCarrito.addAll(pService.agregarCarrito(codProd, nombre, descripcion, peso, unidades));
		
		return listaCarrito;
		
	}
	
	public List<Carrito> verCarrito(){
		
		return listaCarrito;
		
	}

}

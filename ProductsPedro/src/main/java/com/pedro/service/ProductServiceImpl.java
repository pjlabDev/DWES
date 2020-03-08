/**
 * 
 */
package com.pedro.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Pedidos;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;
import com.pedro.repository.ProductRepository;

/**
 * @author pedro
 *
 */
public class ProductServiceImpl implements ProductService {
	
	List<Categorias> listaCat;
	List<Productos> listaProd;
	Set<String> listaDirectores = new TreeSet<>();
	List<Carrito> listaCarrito;
	ProductRepository pRepo = new ProductRepository();
	
	@Override
	public List<Restaurantes> login(String correo, String clave) throws SQLException {

		List<Restaurantes> listaRes;

		listaRes = pRepo.login(correo, clave);

		return listaRes;

	}
	
	@Override
	public List<Categorias> mostrarNombreCategorias1() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pRepo.mostrarNombreCategorias1();

		return listaCat;

	}
	
	@Override
	public List<Categorias> mostrarNombreCategorias2() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pRepo.mostrarNombreCategorias2();

		return listaCat;

	}
	
	@Override
	public List<Categorias> mostrarNombreCategorias3() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pRepo.mostrarNombreCategorias3();

		return listaCat;

	}
	
	@Override
	public List<Productos> mostrarProductosxCat(int codCat) throws SQLException{
		
		listaProd = new ArrayList<>();
		
		listaProd = pRepo.mostrarProductosxCat(codCat);
		
		return listaProd;
		
	}
	
	@Override
	public List<Carrito> agregarCarrito(Integer codProd, String nombre, String descripcion, double peso, int unidades) {
		
		listaCarrito.addAll(pRepo.agregarCarrito(codProd, nombre, descripcion, peso, unidades));
		
		return listaCarrito;
		
	}
	
	@Override
	public List<Carrito> verCarrito(){
		
		return listaCarrito;
		
	}
	
	@Override
	public List<Integer> obtenerCodRes(String correo) throws SQLException {
		
		List<Integer> listaCodRes;
		
		listaCodRes = pRepo.obtenerCodRes(correo);
		
		return listaCodRes;
	}
	
	@Override
	public void altaPedido(String fecha, int enviado, int codRes) throws SQLException {

		pRepo.altaPedido(fecha, enviado, codRes);
	}

	@Override
	public List<Pedidos> listarPedidosNoEnviados() throws SQLException {
		
		List<Pedidos> listaPedidos;
		
		listaPedidos = pRepo.listarPedidosNoEnviados();
		
		return listaPedidos;
	}

	@Override
	public void altaPedidosProductos(int pedido, int producto, int unidades) throws SQLException {
		
		pRepo.altaPedidosProductos(pedido, producto, unidades);
		
	}

	@Override
	public void enviarPedido() throws SQLException {
		
		pRepo.enviarPedido();
		
	}
	
}

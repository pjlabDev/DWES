/**
 * 
 */
package com.pedro.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Pedidos;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;
import com.pedro.repository.ProductRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceImpl.
 *
 * @author pedro
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The lista cat. */
	List<Categorias> listaCat;
	
	/** The lista prod. */
	List<Productos> listaProd;
	
	/** The lista carrito. */
	List<Carrito> listaCarrito;
	
	/** The p repo. */
	ProductRepository pRepo = new ProductRepository();
	
	/**
	 * Login.
	 *
	 * @param correo the correo
	 * @param clave the clave
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Restaurantes> login(String correo, String clave) throws SQLException {

		List<Restaurantes> listaRes;

		listaRes = pRepo.login(correo, clave);

		return listaRes;

	}
	
	/**
	 * Mostrar nombre categorias 1.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Categorias> mostrarNombreCategorias1() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pRepo.mostrarNombreCategorias1();

		return listaCat;

	}
	
	/**
	 * Mostrar nombre categorias 2.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Categorias> mostrarNombreCategorias2() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pRepo.mostrarNombreCategorias2();

		return listaCat;

	}
	
	/**
	 * Mostrar nombre categorias 3.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Categorias> mostrarNombreCategorias3() throws SQLException {

		listaCat = new ArrayList<>();
		
		listaCat = pRepo.mostrarNombreCategorias3();

		return listaCat;

	}
	
	/**
	 * Mostrar productosx cat.
	 *
	 * @param codCat the cod cat
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Productos> mostrarProductosxCat(int codCat) throws SQLException{
		
		listaProd = new ArrayList<>();
		
		listaProd = pRepo.mostrarProductosxCat(codCat);
		
		return listaProd;
		
	}
	
	/**
	 * Agregar carrito.
	 *
	 * @param codProd the cod prod
	 * @param nombre the nombre
	 * @param descripcion the descripcion
	 * @param peso the peso
	 * @param unidades the unidades
	 * @return the list
	 */
	@Override
	public List<Carrito> agregarCarrito(Integer codProd, String nombre, String descripcion, double peso, int unidades) {
		
		listaCarrito.addAll(pRepo.agregarCarrito(codProd, nombre, descripcion, peso, unidades));
		
		return listaCarrito;
		
	}
	
	/**
	 * Ver carrito.
	 *
	 * @return the list
	 */
	@Override
	public List<Carrito> verCarrito(){
		
		return listaCarrito;
		
	}
	
	/**
	 * Obtener cod res.
	 *
	 * @param correo the correo
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Integer> obtenerCodRes(String correo) throws SQLException {
		
		List<Integer> listaCodRes;
		
		listaCodRes = pRepo.obtenerCodRes(correo);
		
		return listaCodRes;
	}
	
	/**
	 * Alta pedido.
	 *
	 * @param fecha the fecha
	 * @param enviado the enviado
	 * @param codRes the cod res
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void altaPedido(String fecha, int enviado, int codRes) throws SQLException {

		pRepo.altaPedido(fecha, enviado, codRes);
	}

	/**
	 * Listar pedidos no enviados.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Pedidos> listarPedidosNoEnviados() throws SQLException {
		
		List<Pedidos> listaPedidos;
		
		listaPedidos = pRepo.listarPedidosNoEnviados();
		
		return listaPedidos;
	}

	/**
	 * Alta pedidos productos.
	 *
	 * @param pedido the pedido
	 * @param producto the producto
	 * @param unidades the unidades
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void altaPedidosProductos(int pedido, int producto, int unidades) throws SQLException {
		
		pRepo.altaPedidosProductos(pedido, producto, unidades);
		
	}

	/**
	 * Enviar pedido.
	 *
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void enviarPedido() throws SQLException {
		
		pRepo.enviarPedido();
		
	}

	/**
	 * Updatear stock.
	 *
	 * @param unidades the unidades
	 * @param codProd the cod prod
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void updatearStock(int unidades, int codProd) throws SQLException {
		
		pRepo.updatearStock(unidades, codProd);
		
	}

	/**
	 * Mostrar productosx cod.
	 *
	 * @param codProd the cod prod
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@Override
	public List<Productos> mostrarProductosxCod(int codProd) throws SQLException {
		
		List<Productos> listaProd;
		
		listaProd = pRepo.mostrarProductosxCod(codProd);
		
		return listaProd;
	}
	
}

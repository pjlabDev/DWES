/**
 * 
 */
package com.pedro.repository;

import java.sql.SQLException;
import java.util.List;

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Pedidos;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductRepositoryI.
 *
 * @author pedro
 */
public interface ProductRepositoryI {
	
	/**
	 * Mostrar nombre categorias 1.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Categorias> mostrarNombreCategorias1() throws SQLException;
	
	/**
	 * Mostrar nombre categorias 2.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Categorias> mostrarNombreCategorias2() throws SQLException;
	
	/**
	 * Mostrar nombre categorias 3.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Categorias> mostrarNombreCategorias3() throws SQLException;
	
	/**
	 * Mostrar productosx cat.
	 *
	 * @param codCat the cod cat
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Productos> mostrarProductosxCat(int codCat) throws SQLException;
	
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
	public List<Carrito> agregarCarrito(Integer codProd, String nombre, String descripcion, double peso, int unidades);
	
	/**
	 * Login.
	 *
	 * @param correo the correo
	 * @param clave the clave
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Restaurantes> login(String correo, String clave) throws SQLException;
	
	/**
	 * Ver carrito.
	 *
	 * @return the list
	 */
	public List<Carrito> verCarrito();
	
	/**
	 * Alta pedido.
	 *
	 * @param fecha the fecha
	 * @param enviado the enviado
	 * @param codRes the cod res
	 * @throws SQLException the SQL exception
	 */
	public void altaPedido(String fecha, int enviado, int codRes) throws SQLException;
	
	/**
	 * Obtener cod res.
	 *
	 * @param correo the correo
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Integer> obtenerCodRes(String correo) throws SQLException;
	
	/**
	 * Alta pedidos productos.
	 *
	 * @param pedido the pedido
	 * @param producto the producto
	 * @param unidades the unidades
	 * @throws SQLException the SQL exception
	 */
	public void altaPedidosProductos(int pedido, int producto, int unidades) throws SQLException;
	
	/**
	 * Listar pedidos no enviados.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Pedidos> listarPedidosNoEnviados() throws SQLException;
	
	/**
	 * Enviar pedido.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void enviarPedido() throws SQLException;
	
	/**
	 * Mostrar productosx cod.
	 *
	 * @param codProd the cod prod
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	public List<Productos> mostrarProductosxCod(int codProd) throws SQLException;
	
	/**
	 * Updatear stock.
	 *
	 * @param unidades the unidades
	 * @param codProd the cod prod
	 * @throws SQLException the SQL exception
	 */
	public void updatearStock(int unidades, int codProd) throws SQLException;

}

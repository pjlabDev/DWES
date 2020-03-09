/**
 * 
 */
package com.pedro.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Repository;

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Pedidos;
import com.pedro.modelo.PedidosProductos;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductRepository.
 *
 * @author pedro
 */
@Repository("productRepository")
public class ProductRepository implements ProductRepositoryI {
	
	/** The lista directores. */
	Set<String> listaDirectores = new TreeSet<>();
	
	/** The lista carrito. */
	List<Carrito> listaCarrito = new ArrayList<>();
	
	/** The emfactory. */
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	
	/** The model. */
	DefaultTableModel model;
	
	/**
	 * Mostrar nombre categorias 1.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorias> mostrarNombreCategorias1() throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Categorias> listaCat;
		
		Query query = em.createQuery("SELECT c FROM Categorias c WHERE c.CodCat = :codcat", Categorias.class);
		query.setParameter("codcat", 1);

		listaCat = query.getResultList();
		
		return listaCat;

	}
	
	/**
	 * Mostrar nombre categorias 2.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorias> mostrarNombreCategorias2() throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Categorias> listaCat;
		
		Query query = em.createQuery("SELECT c FROM Categorias c WHERE c.CodCat = :codcat", Categorias.class);
		query.setParameter("codcat", 2);

		listaCat = query.getResultList();
		
		return listaCat;

	}
	
	/**
	 * Mostrar nombre categorias 3.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorias> mostrarNombreCategorias3() throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Categorias> listaCat;
		
		Query query = em.createQuery("SELECT c FROM Categorias c WHERE c.CodCat = :codcat", Categorias.class);
		query.setParameter("codcat", 3);

		listaCat = query.getResultList();
		
		return listaCat;

	}

	/**
	 * Login.
	 *
	 * @param correo the correo
	 * @param clave the clave
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurantes> login(String correo, String clave) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Restaurantes> listaRes;
		
		Query query = em.createQuery("SELECT r FROM Restaurantes r WHERE r.Correo = :correo AND r.Clave = :clave", Restaurantes.class);
		query.setParameter("correo", correo);
		query.setParameter("clave", clave);
		
		listaRes = query.getResultList();

		return listaRes;

	}
	
	/**
	 * Mostrar productosx cat.
	 *
	 * @param codCat the cod cat
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Productos> mostrarProductosxCat(int codCat) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Productos> listaProd;
		
		Query query = em.createQuery("SELECT p FROM Productos p WHERE p.Categoria = :codCat AND p.Stock > 0", Productos.class);
		query.setParameter("codCat", codCat);

		listaProd = query.getResultList();
		
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
		
		Carrito car = new Carrito(codProd, nombre, descripcion, peso, unidades);
		
		listaCarrito.add(car);
		
		return listaCarrito;

	}
	
	/**
	 * Ver carrito.
	 *
	 * @return the list
	 */
	public List<Carrito> verCarrito() {
		return listaCarrito;
	}
	
	/**
	 * Obtener cod res.
	 *
	 * @param correo the correo
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> obtenerCodRes(String correo) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Integer> listaCodRes;
		
		Query query = em.createQuery("SELECT r.CodRes FROM Restaurantes r WHERE r.Correo = :correo");
		query.setParameter("correo", correo);

		listaCodRes = query.getResultList();
		
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
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Pedidos p = new Pedidos();
		p.setFecha(fecha);
		p.setEnviado(enviado);
		p.setCodRes(codRes);
		
		em.persist(p);
		em.getTransaction( ).commit( );
		
	}
	
	/**
	 * Listar pedidos no enviados.
	 *
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedidos> listarPedidosNoEnviados() throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Pedidos> listaPedidos;
		
		Query query = em.createQuery("SELECT p FROM Pedidos p WHERE p.Enviado = 0", Pedidos.class);

		listaPedidos = query.getResultList();
		
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
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		PedidosProductos pp = new PedidosProductos();
		pp.setPedido(pedido);
		pp.setProducto(producto);
		pp.setUnidades(unidades);
		
		em.persist(pp);
		em.getTransaction( ).commit( );
	}

	/**
	 * Enviar pedido.
	 *
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void enviarPedido() throws SQLException {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("UPDATE Pedidos p SET p.Enviado = 1 WHERE p.Enviado = 0");
		
		query.executeUpdate();
		em.getTransaction( ).commit( );
		
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
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("UPDATE Productos p SET p.Stock = (p.Stock - :unidades) WHERE p.CodProd = :codProd");
		query.setParameter("unidades", unidades);
		query.setParameter("codProd", codProd);
		
		query.executeUpdate();
		em.getTransaction( ).commit( );
		
	}

	/**
	 * Mostrar productosx cod.
	 *
	 * @param codProd the cod prod
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Productos> mostrarProductosxCod(int codProd) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Productos> listaProd;
		
		Query query = em.createQuery("SELECT p FROM Productos p WHERE p.CodProd = :codProd", Productos.class);
		query.setParameter("codProd", codProd);

		listaProd = query.getResultList();
		
		return listaProd;
	}

}

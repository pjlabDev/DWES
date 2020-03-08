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

/**
 * @author pedro
 *
 */
@Repository("productRepository")
public class ProductRepository implements ProductRepositoryI {

	Set<String> listaDirectores = new TreeSet<>();
	List<Carrito> listaCarrito = new ArrayList<>();
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	DefaultTableModel model;
	
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Productos> mostrarProductosxCat(int codCat) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Productos> listaProd;
		
		Query query = em.createQuery("SELECT p FROM Productos p WHERE p.Categoria = :codCat", Productos.class);
		query.setParameter("codCat", codCat);

		listaProd = query.getResultList();
		
		return listaProd;

	}
	
	@Override
	public List<Carrito> agregarCarrito(Integer codProd, String nombre, String descripcion, double peso, int unidades) {
		
		Carrito car = new Carrito(codProd, nombre, descripcion, peso, unidades);
		
		listaCarrito.add(car);
		
		return listaCarrito;

	}
	
	public List<Carrito> verCarrito() {
		return listaCarrito;
	}
	
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

	@Override
	public void enviarPedido() throws SQLException {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("UPDATE Pedidos p SET p.Enviado = 1 WHERE p.Enviado = 0");
		
		query.executeUpdate();
		em.getTransaction( ).commit( );
		
	}

}

/**
 * 
 */
package com.pedro.service;

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

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;

/**
 * @author pedro
 *
 */
public class ProductServiceImpl implements ProductService {

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
	
}

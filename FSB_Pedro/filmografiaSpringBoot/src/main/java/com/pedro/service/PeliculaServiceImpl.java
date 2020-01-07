/**
 * 
 */
package com.pedro.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;

/**
 * @author pedro
 *
 */
public class PeliculaServiceImpl implements PeliculaService {

	TreeSet<String> listaDirectores = new TreeSet<>();
	int result;
	int result2;
	int result3;
	Pelicula p = new Pelicula();
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	DefaultTableModel model;

	
	@SuppressWarnings("unchecked")
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		
		Query query = em.createQuery("SELECT p FROM Pelicula p WHERE p.director = :director", Pelicula.class);
		query.setParameter("director", director);

		listaPelis = query.getResultList();
		
		if(director != null && !listaPelis.isEmpty()) {
			listaDirectores.add(director);
		}

		return listaPelis;

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> loginDirector(String nombre, String password) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Usuario> listaUser = new ArrayList<Usuario>();
		
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.password = :password", Usuario.class);
		query.setParameter("nombre", nombre);
		query.setParameter("password", password);
		
		listaUser = query.getResultList();

		return listaUser;

	}

	@SuppressWarnings("unchecked")
	public List<Pelicula> mostrarPelis() throws SQLException {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		
		Query query = em.createQuery("SELECT p FROM Pelicula p", Pelicula.class);

		listaPelis = query.getResultList();

		return listaPelis;

	}

	@SuppressWarnings("unchecked")
	public void altaUsuario(String usuario, String pass) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Integer> listaId = new ArrayList<Integer>();
		
		Query query = em.createQuery("SELECT MAX(u.id) FROM Usuario u");
		
		listaId = query.getResultList();
		
		Usuario u = new Usuario();
		u.setId(listaId.get(0) + 1);
		u.setNombre(usuario);
		u.setPassword(pass);
		
		em.persist(u);
		em.getTransaction( ).commit( );
		
	}

	@SuppressWarnings("unchecked")
	public void altaPelicula(String director, String titulo, String fecha, String foto) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Integer> listaId = new ArrayList<Integer>();
		
		Query query = em.createQuery("SELECT MAX(p.id) FROM Pelicula p");
		
		listaId = query.getResultList();
		
		Pelicula p = new Pelicula();
		p.setId(listaId.get(0) + 1);
		p.setDirector(director);
		p.setTitulo(titulo);
		p.setFecha(fecha);
		p.setFoto(foto);
		
		em.persist(p);
		em.getTransaction( ).commit( );

	}

	public void modificarPelicula(String director, String titulo, String fecha, String tituloPeli, String foto, String descripcion) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("UPDATE Pelicula p "
				+ "SET p.director = :director, p.titulo = :titulo, p.fecha = :fecha, p.foto = :foto, "
				+ "p.descripcion = :descripcion WHERE p.titulo = :tituloPeli");
		
		query.setParameter("director", director);
		query.setParameter("titulo", titulo);
		query.setParameter("fecha", fecha);
		query.setParameter("foto",foto);
		query.setParameter("descripcion", descripcion);
		query.setParameter("tituloPeli", tituloPeli);
		
		query.executeUpdate();
		em.getTransaction( ).commit( );
		
	}

	public void eliminarPelicula(String titulo) throws SQLException {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("DELETE FROM Pelicula p WHERE p.titulo = :titulo");
		query.setParameter("titulo", titulo);
		
		query.executeUpdate();
		em.getTransaction( ).commit( );
		
	}

	public TreeSet<String> listaDirectores() {

		return listaDirectores;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> mostrarUsuarios() throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Usuario> listaUsers = new ArrayList<>();
		
		Query query = em.createQuery("SELECT u FROM Usuario u");
		
		listaUsers = query.getResultList();

		return listaUsers;
	}
	
}

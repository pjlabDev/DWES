/**
 * 
 */
package com.pedro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;

/**
 * @author pedro
 *
 */
public class PeliculaServiceImpl implements PeliculaService {

	TreeSet<String> listaDirectores = new TreeSet<>();
	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int result;
	int result2;
	int result3;
	Pelicula p = new Pelicula();
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");

	
	@SuppressWarnings("unchecked")
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		
		Query query = em.createQuery("SELECT p FROM Pelicula p WHERE p.director = :director", Pelicula.class);
		query.setParameter("director", director);

		listaPelis = query.getResultList();

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

	public void altaDirector(String usuario, String pass) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Usuario u = new Usuario();
		u.setNombre(usuario);
		u.setPassword(pass);
		
		em.persist(u);
		em.getTransaction( ).commit( );
		
	}

	public void altaPelicula(String director, String titulo, String fecha) throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Pelicula p = new Pelicula();
		p.setDirector(director);
		p.setTitulo(titulo);
		p.setFecha(fecha);
		
		em.persist(p);
		em.getTransaction( ).commit( );

	}

	public void modificarPelicula(String director, String tituloPeli, String fecha, String titulo)
			throws SQLException {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("UPDATE Pelicula p SET p.director = :director, p.titulo = :titulo, p.fecha = :fecha WHERE p.titulo = :tituloPeli");
		
		query.setParameter("director", director);
		query.setParameter("titulo", titulo);
		query.setParameter("fecha", fecha);
		query.setParameter("tituloPeli", tituloPeli);
		
		query.executeUpdate();
		em.getTransaction( ).commit( );
		
	}

	public void eliminarPelicula(String titulo) throws SQLException {

		String message = null;

		pst = con.prepareStatement("DELETE FROM pelicula WHERE titulo = ?");

		pst.setString(1, titulo);

		result = pst.executeUpdate();

		if (result > 0) {
			message = "Pelicula eliminada con exito.";
		}

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

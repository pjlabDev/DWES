/**
 * 
 */
package com.pedro.filmografia.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.pedro.filmografia.domain.Pelicula;

/**
 * @author pedro
 *
 */
@Repository(value="peliculaDao")
public class PeliculaDaoImpl implements PeliculaDao {
	
	TreeSet<String> listaDirectores = new TreeSet<>();
	private EntityManager em = null;


    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {

		return em.createQuery("SELECT * FROM pelicula WHERE director = '" + director + "'").getResultList();
	}

//	public String loginDirector(String nombre, String password) throws SQLException {
//
////		String linea = null;
////
////		st = con.createStatement();
////
////		rs = st.executeQuery(
////				"SELECT * FROM directores WHERE nombre = '" + nombre + "' AND password = '" + password + "'");
////
////		while (rs.next()) {
////
////			linea = rs.getString(1);
////
////		}
//
//		return null;
//
//	}
//
//	public List<Pelicula> mostrarPelis() throws SQLException {
//
////		List<Pelicula> listaPelis = new ArrayList<>();
////
////		st = con.createStatement();
////
////		rs = st.executeQuery("SELECT * FROM pelicula");
////
////		while (rs.next()) {
////
////			listaPelis.add(new Pelicula(rs.getString(1), rs.getString(2), rs.getString(3)));
////
////		}
//
//		return null;
//
//	}
//
//	public String altaDirector(String director, String pass) throws SQLException {
//
////		String message = null;
////
////		pst = con.prepareStatement("INSERT INTO directores VALUES(?,?)");
////
////		pst.setString(1, director);
////		pst.setString(2, pass);
////
////		result = pst.executeUpdate();
////
////		if (result > 0) {
////			message = "Nuevo usuario administrador insertado en la base de datos.";
////		}
//
//		return null;
//
//	}
//
//	public String altaPelicula(String director, String titulo, String fecha) throws SQLException {
//
////		String message = null;
////
////		pst = con.prepareStatement("INSERT INTO pelicula VALUES(?,?,?)");
////
////		pst.setString(1, director);
////		pst.setString(2, titulo);
////		pst.setString(3, fecha);
////
////		result = pst.executeUpdate();
////
////		if (result > 0) {
////			message = "Nueva pelicula insertada en la base de datos.";
////		}
//		
//		return null;
//
//	}
//	
//	public String modificarPelicula(String director, String tituloPeli, String fecha, String titulo) throws SQLException {
//		
////		String message = null;
////		
////		st = con.createStatement();
////		
////		result = st.executeUpdate("UPDATE pelicula SET director = '" + director + "' WHERE titulo = '" + tituloPeli + "'");
////		result2 = st.executeUpdate("UPDATE pelicula SET titulo = '" + titulo + "' WHERE titulo = '" + tituloPeli + "'");
////		result3 = st.executeUpdate("UPDATE pelicula SET fecha = '" + fecha + "' WHERE titulo = '" + tituloPeli + "'");
////
////		if(result>0 || result2>0 || result3>0) {
////			
////			message = "Pelicula modificada con exito.";
////			
////		}		
//		
//		return null;
//	}
//	
//	public String eliminarPelicula(String titulo) throws SQLException {
//
////		String message = null;
////
////		pst = con.prepareStatement("DELETE FROM pelicula WHERE titulo = ?");
////
////		pst.setString(1, titulo);
////
////		result = pst.executeUpdate();
////
////		if (result > 0) {
////			message = "Pelicula eliminada con exito.";
////		}
//
//		return null;
//
//	}
//	
//	public TreeSet<String> listaDirectores(){
//		
//		return listaDirectores;
//		
//	}
	
}

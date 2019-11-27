/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pelicula;

/**
 * @author usuario
 *
 */
public class BBDD {

	Connection con;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	int result;
	int result2;
	int result3;
	String forName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cine";
	String user = "root";
	String pass = "";

	public BBDD() {

		try {

			Class.forName(forName);
			con = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Pelicula> mostrarPeliculasDirector(String director) throws SQLException {

		List<Pelicula> listaPelis = new ArrayList<>();

		st = con.createStatement();

		rs = st.executeQuery("SELECT * FROM pelicula WHERE director = '" + director + "'");

		while (rs.next()) {

			listaPelis.add(new Pelicula(rs.getString(1), rs.getString(2), rs.getString(3)));

		}

		return listaPelis;

	}

	public String loginDirector(String nombre, String password) throws SQLException {

		String linea = null;

		st = con.createStatement();

		rs = st.executeQuery(
				"SELECT * FROM directores WHERE nombre = '" + nombre + "' AND password = '" + password + "'");

		while (rs.next()) {

			linea = rs.getString(1);

		}

		return linea;

	}

	public List<Pelicula> mostrarPelis() throws SQLException {

		List<Pelicula> listaPelis = new ArrayList<>();

		st = con.createStatement();

		rs = st.executeQuery("SELECT * FROM pelicula");

		while (rs.next()) {

			listaPelis.add(new Pelicula(rs.getString(1), rs.getString(2), rs.getString(3)));

		}

		return listaPelis;

	}

	public String altaDirector(String director, String pass) throws SQLException {

		String message = null;

		pst = con.prepareStatement("INSERT INTO directores VALUES(?,?)");

		pst.setString(1, director);
		pst.setString(2, pass);

		result = pst.executeUpdate();

		if (result > 0) {
			message = "Nuevo usuario administrador insertado en la base de datos.";
		}

		return message;

	}

	public String altaPelicula(String director, String titulo, String fecha) throws SQLException {

		String message = null;

		pst = con.prepareStatement("INSERT INTO pelicula VALUES(?,?,?)");

		pst.setString(1, director);
		pst.setString(2, titulo);
		pst.setString(3, fecha);

		result = pst.executeUpdate();

		if (result > 0) {
			message = "Nueva pelicula insertada en la base de datos.";
		}
		
		return message;

	}
	
	public String modificarPelicula(String director, String tituloPeli, String fecha, String titulo) throws SQLException {
		
		String message = null;
		
		st = con.createStatement();
		
		result = st.executeUpdate("UPDATE pelicula SET director = '" + director + "' WHERE titulo = '" + tituloPeli + "'");
		result2 = st.executeUpdate("UPDATE pelicula SET titulo = '" + titulo + "' WHERE titulo = '" + tituloPeli + "'");
		result3 = st.executeUpdate("UPDATE pelicula SET fecha = '" + fecha + "' WHERE titulo = '" + tituloPeli + "'");

		if(result>0 || result2>0 || result3>0) {
			
			message = "Pelicula modificada con exito.";
			
		}else {
			message = "q va tt";
		}
		
		
		return message;
	}
	
	public String eliminarPelicula(String titulo) throws SQLException {

		String message = null;

		pst = con.prepareStatement("DELETE FROM pelicula WHERE titulo = ?");

		pst.setString(1, titulo);

		result = pst.executeUpdate();

		if (result > 0) {
			message = "Pelicula eliminada con exito.";
		}

		return message;

	}

}

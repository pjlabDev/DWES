package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PeliculaDAOImpl;
import model.Pelicula;

/**
 * Servlet implementation class CineController
 */
public class CineController extends HttpServlet {
	PeliculaDAOImpl pelDao = new PeliculaDAOImpl();
	RequestDispatcher rd;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CineController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action != null) {

			if (action.equalsIgnoreCase("Consultar")) {

				this.mostrarPeliculasDirector(request, response);

			} else if (action.equalsIgnoreCase("Login")) {

				this.loginDirectores(request, response);

			} else if (action.equalsIgnoreCase("Mantenimiento Peliculas")) {

				this.mostrarPelis(request, response);

			}else if(action.equalsIgnoreCase("Añadir director")) {
				
				this.altaDirector(request, response);
				
			}else if(action.equalsIgnoreCase("Añadir pelicula")) {
				
				this.altaPelicula(request, response);
				
			}else if(action.equalsIgnoreCase("Modificar pelicula")) {
				
				this.modificarPelicula(request, response);
				
			}else if(action.equalsIgnoreCase("Eliminar pelicula")) {
				
				this.eliminarPelicula(request, response);
				
			}

		}

	}

	public void mostrarPeliculasDirector(HttpServletRequest request, HttpServletResponse response) {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		String director;
		String message = null;

		director = request.getParameter("director");

		try {

			listaPelis = pelDao.mostrarPeliculasDirector(director);

			if (listaPelis.isEmpty()) {
				rd = request.getRequestDispatcher("consultaDirector.jsp");
				message = "No existe el director que buscas.";
			} else {
				rd = request.getRequestDispatcher("listadoPeliculas.jsp");
			}

			request.setAttribute("message", message);
			request.setAttribute("listaPelis", listaPelis);
			request.setAttribute("director", director);

			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loginDirectores(HttpServletRequest request, HttpServletResponse response) {

		String director;
		String message = null;
		RequestDispatcher rd;

		try {

			director = pelDao.loginDirector(request.getParameter("director"), request.getParameter("password"));

			if (director == null) {
				message = "No existe el director en la base de datos.";
				rd = request.getRequestDispatcher("login.jsp");
			} else {

				rd = request.getRequestDispatcher("welcomeUser.jsp");
			}

			request.setAttribute("message", message);
			request.setAttribute("director", director);

			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarPelis(HttpServletRequest request, HttpServletResponse response) {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		RequestDispatcher rd;

		try {

			String director = request.getParameter("director");

			listaPelis = pelDao.mostrarPelis();

			request.setAttribute("listaPelis", listaPelis);

			request.setAttribute("director", director);

			rd = request.getRequestDispatcher("mantenimientoPeliculas.jsp");

			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void altaDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message;

		String director = request.getParameter("director");

		String pass = request.getParameter("pass");

		try {

			message = pelDao.altaDirector(director, pass);

			request.setAttribute("message", message);

			rd = request.getRequestDispatcher("directorSuccess.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rd = request.getRequestDispatcher("errorPageToDirector.jsp");
			rd.forward(request, response);
		}
	}

	public void altaPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message;

		String director = request.getParameter("director");

		String titulo = request.getParameter("titulo");
		
		String fecha = request.getParameter("fecha");

		try {

			message = pelDao.altaPelicula(director, titulo, fecha);

			request.setAttribute("message", message);

			rd = request.getRequestDispatcher("peliculaSuccess.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rd = request.getRequestDispatcher("errorPageToPelis.jsp");
			rd.forward(request, response);
		}
	}
	
	public void modificarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message;

		String director = request.getParameter("director");

		String tituloPeli = request.getParameter("tituloPeli");
		
		String fecha = request.getParameter("fecha");
		
		String titulo = request.getParameter("titulo");

		try {

			message = pelDao.modificarPelicula(director, tituloPeli, fecha, titulo);
			
			request.setAttribute("message", message);

			rd = request.getRequestDispatcher("peliculaSuccess.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rd = request.getRequestDispatcher("errorPageToPelis.jsp");
			rd.forward(request, response);
		}
	}
	
	public void eliminarPelicula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message;
		String titulo = request.getParameter("titulo");

		try {

			message = pelDao.eliminarPelicula(titulo);
			
			request.setAttribute("message", message);

			rd = request.getRequestDispatcher("peliculaSuccess.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd = request.getRequestDispatcher("errorPageToPelis.jsp");
			rd.forward(request, response);
		}
	}
	
	
	
	
	
	

}

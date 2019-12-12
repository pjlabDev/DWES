/**
 * 
 */
package com.pedro.filmografia.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pedro.filmografia.domain.Pelicula;
import com.pedro.filmografia.domain.Usuario;
import com.pedro.filmografia.repository.PeliculaDao;

/**
 * @author pedro
 *
 */
@Controller
@RequestMapping("/filmografia")
public class HomeController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	PeliculaDao peliculaDao;

	@RequestMapping(value = "/principal")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);

		return new ModelAndView("principal", "now", now);
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public ModelAndView listaPeliculasDirector(@RequestParam("director") String director, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		String message = null;

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		listaPelis = peliculaDao.mostrarPeliculasDirector(director);

		if (listaPelis.isEmpty()) {
			message = "El director que ha puesto no existe en la base de datos.";
			return new ModelAndView("consultaDirector", "message", message);
		}

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("listaPelis", listaPelis);
		myModel.put("director", director);

		return new ModelAndView("listadoPeliculas", "model", myModel);
	}

	@RequestMapping(value = "/loginUser")
	public ModelAndView logIn(@RequestParam("usuario") String usuario, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String message = null;
		String user;

		user = peliculaDao.loginDirector(usuario, password);

		if (user == null) {

			message = "No existe el director en la base de datos.";

			return new ModelAndView("login", "message", message);

		}

		return new ModelAndView("welcomeUser", "user", user);

	}

	@RequestMapping(value = "/addUser")
	public ModelAndView addUser(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Usuario> listaUsers = new ArrayList<Usuario>();

		try {

			peliculaDao.altaDirector(username, password);

			listaUsers = peliculaDao.mostrarUsuarios();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ModelAndView("errorPageToPelis");
		}

		return new ModelAndView("listadoUsers", "listaUsers", listaUsers);

	}

	@RequestMapping(value = "/MantenimientoPelicula")
	public ModelAndView mantPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		listaPelis = peliculaDao.mostrarPelis();

		return new ModelAndView("mantenimientoPeliculas", "listaPelis", listaPelis);

	}

	@RequestMapping(value = "/addPeliculas")
	public ModelAndView addPeliculas(@RequestParam("director") String director, @RequestParam("titulo") String titulo,
			@RequestParam("fecha") String fecha, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {

			peliculaDao.altaPelicula(director, titulo, fecha);

			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ModelAndView("errorPageToPelis");
		}

		return new ModelAndView("mantenimientoPeliculas", "listaPelis", listaPelis);

	}

	@RequestMapping(value = "/updatePeliculas")
	public ModelAndView updatePeliculas(@RequestParam("director") String director,
			@RequestParam("titulo") String titulo, @RequestParam("fecha") String fecha,
			@RequestParam("tituloPeli") String tituloPeli, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		String message = null;
		Map<String, Object> myModel = new HashMap<String, Object>();

		try {
			
			if(tituloPeli.equalsIgnoreCase("PELICULAS")) {
				
				message = "Introduzca el titulo de una pelicula.";
				listaPelis = peliculaDao.mostrarPelis();
				
				myModel.put("message", message);
				myModel.put("listaPelis", listaPelis);
				
				return new ModelAndView("modificarPelicula", "model", myModel);
				
			}else {
				
				peliculaDao.modificarPelicula(director, tituloPeli, fecha, titulo);
				listaPelis = peliculaDao.mostrarPelis();
				
				return new ModelAndView("mantenimientoPeliculas", "listaPelis", listaPelis);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ModelAndView("errorPageToPelis");
		}

	}

	@RequestMapping(value = "/deletePeliculas")
	public ModelAndView deletePeliculas(@RequestParam("titulo") String titulo, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		String message = null;
		Map<String, Object> myModel = new HashMap<String, Object>();

		
		try {
			
			if(titulo.equalsIgnoreCase("PELICULAS")) {
				
				message = "Introduzca el titulo de una pelicula.";
				listaPelis = peliculaDao.mostrarPelis();
				
				myModel.put("message", message);
				myModel.put("listaPelis", listaPelis);
				
				return new ModelAndView("eliminarPelicula", "model", myModel);
				
			}else {
			
				peliculaDao.eliminarPelicula(titulo);
	
				listaPelis = peliculaDao.mostrarPelis();
				
				return new ModelAndView("mantenimientoPeliculas", "listaPelis", listaPelis);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ModelAndView("errorPageToPelis");
		}

	}
	
	@RequestMapping(value = "/listaDirectoresConsultados")
	public ModelAndView listaDirectores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		TreeSet<String> listaDirectores = new TreeSet<>();

		listaDirectores = peliculaDao.listaDirectores();

		return new ModelAndView("listaDirectores", "listaDirectores", listaDirectores);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/infoPage")
	public ModelAndView irInfoPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("infoPage");
	}	
	
	@RequestMapping(value = "/consultaDirector")
	public ModelAndView irDirector(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("consultaDirector");
	}
	
	@RequestMapping(value = "/addFormUser")
	public ModelAndView iraddUserPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("altaDirector");
	}
	
	@RequestMapping(value = "/loginPage")
	public ModelAndView irlogInPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/formPeliculas")
	public ModelAndView irformPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		return new ModelAndView("altaPelicula");
	}

	@RequestMapping(value = "/updateFormPeliculas")
	public ModelAndView updateFormPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		listaPelis = peliculaDao.mostrarPelis();

		return new ModelAndView("modificarPelicula", "listaPelis", listaPelis);
	}

	@RequestMapping(value = "/deleteFormPeliculas")
	public ModelAndView irdeleteFormPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		listaPelis = peliculaDao.mostrarPelis();

		return new ModelAndView("eliminarPelicula", "listaPelis", listaPelis);
	}
	
}

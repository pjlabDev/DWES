/**
 * 
 */
package com.pedro.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;
import com.pedro.repository.PeliculaDaoImpl;

/**
 * 
 * @author usuario
 *
 */
@Controller
@EnableAutoConfiguration
public class HomeController {

	PeliculaDaoImpl peliculaDao = new PeliculaDaoImpl();

	@RequestMapping("/")
	public String irPrincipal() {
		return "principal";
	}

	@RequestMapping("/infoPage")
	public String secondPage() {
		return "infoPage";
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.POST)
	public String listaPeliculasDirector(@RequestParam("director") String director, ModelMap mp) {
		
		String message = null;

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {
			
			listaPelis = peliculaDao.mostrarPeliculasDirector(director);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}

		if (listaPelis.isEmpty()) {
			message = "No existe ningún director con ese nombre en la base de datos.";
			mp.put("message", message);
			return "consultaDirector";

		}

		mp.put("listaPelis", listaPelis);
		mp.put("director", director);

		return "listadoPeliculas";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String Login(@RequestParam("usuario") String nombre, @RequestParam("password") String password, ModelMap mp) {

		String message = null;

		List<Usuario> listaUser = new ArrayList<>();

		try {
			
			listaUser = peliculaDao.loginDirector(nombre, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}

		if (listaUser.isEmpty()) {
			message = "Usuario no encontrado en la base de datos.";
			mp.put("message", message);
			return "login";

		}

		mp.put("listaUser", listaUser);

		return "welcomeUser";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap mp) {
		
		List<Usuario> listaUsers = new ArrayList<Usuario>();
		
		try {

			peliculaDao.altaDirector(username, password);

			listaUsers = peliculaDao.mostrarUsuarios();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}
		
		mp.put("listaUsers", listaUsers);
		
		return "listadoUsers";

	}
	
	@RequestMapping(value = "/MantenimientoPelicula")
	public String mantPelis(ModelMap mp) {
		
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {
			
			listaPelis = peliculaDao.mostrarPelis();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}
		
		mp.put("listaPelis", listaPelis);
		
		return "mantenimientoPeliculas";

	}
	
	@RequestMapping(value = "/addPeliculas", method = RequestMethod.POST)
	public String addPeliculas(@RequestParam("director") String director, @RequestParam("titulo") String titulo,
			@RequestParam("fecha") String fecha, ModelMap mp) {
		
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		
		try {
			
			peliculaDao.altaPelicula(director, titulo, fecha);
			
			listaPelis = peliculaDao.mostrarPelis();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}
		
		mp.put("listaPelis", listaPelis);
		
		return "mantenimientoPeliculas";

	}
	
	@RequestMapping(value = "/updatePeliculas", method = RequestMethod.POST)
	public String updatePeliculas(@RequestParam("director") String director,
			@RequestParam("titulo") String titulo, @RequestParam("fecha") String fecha,
			@RequestParam("tituloPeli") String tituloPeli, ModelMap mp) {
		
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		
		try {
			
			peliculaDao.modificarPelicula(director, titulo, fecha, tituloPeli);
			listaPelis = peliculaDao.mostrarPelis();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}
		
		mp.put("listaPelis", listaPelis);
		
		return "mantenimientoPeliculas";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping("/consultaDirector")
	public String consultaDirector() {
		return "consultaDirector";
	}

	@RequestMapping("/loginPage")
	public String irLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/addFormUser")
	public String iraddUserPage() {

		return "altaDirector";
	}

	@RequestMapping(value = "/formPeliculas")
	public String irformPeliculas() {

		return "altaPelicula";
	}

	@RequestMapping(value = "/updateFormPeliculas")
	public String updateFormPeliculas(@RequestParam("tituloPeli") String tituloPeli, ModelMap mp) {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {
			
			listaPelis = peliculaDao.mostrarPelis();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}
		
		mp.put("listaPelis", listaPelis);
		mp.put("tituloPeli", tituloPeli);

		return "modificarPelicula";
	}

	@RequestMapping(value = "/deleteFormPeliculas")
	public String irdeleteFormPeliculas(ModelMap mp) {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {
			
			listaPelis = peliculaDao.mostrarPelis();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}
		
		mp.put("listaPelis", listaPelis);

		return "eliminarPelicula";
	}
	
}
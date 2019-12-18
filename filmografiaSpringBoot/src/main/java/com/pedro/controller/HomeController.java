/**
 * 
 */
package com.pedro.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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

	TreeSet<String> listaDirectores = new TreeSet<>();
	PeliculaDaoImpl peliculaDao = new PeliculaDaoImpl();

//	Método que lleva a la página principal, dejando vacia la lista de directores consultados.
	@RequestMapping("/")
	public String irPrincipal(ModelMap mp) {

		listaDirectores.clear();

		return "principal";
	}

//	Éste método nos devuelve una lista de las peliculas que tiene un director, consultado anteriormente.
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

//	Login de usuarios administradores.
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String Login(@RequestParam("usuario") String nombre, @RequestParam("password") String password,
			ModelMap mp) {

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

//	Alta de usuarios administradores.
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap mp) {
		String message = null;
		
		List<Usuario> listaUsers = new ArrayList<Usuario>();

		try {

			peliculaDao.altaUsuario(username, password);

			listaUsers = peliculaDao.mostrarUsuarios();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "Ya existe el usuario en la base de datos.";
			mp.put("message", message);
			return "altaUsuario";
		}

		mp.put("listaUsers", listaUsers);

		return "listadoUsers";

	}

//	Método que nos dirige a Mantenimiento de peliculas, mostrando un listado completo de las peliculas con toda su información
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

//	Alta de nuevas peliculas
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

		return "redirect:MantenimientoPelicula";

	}

//	Metodo que nos permite modificar la información de las peliculas.
	@RequestMapping(value = "/updatePeliculas", method = RequestMethod.POST)
	public String updatePeliculas(@RequestParam("director") String director, @RequestParam("titulo") String titulo,
			@RequestParam("fecha") String fecha, @RequestParam("tituloPeli") String tituloPeli, ModelMap mp) {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {

			peliculaDao.modificarPelicula(director, titulo, fecha, tituloPeli);
			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}

		mp.put("listaPelis", listaPelis);

		return "redirect:MantenimientoPelicula";

	}

	@RequestMapping(value = "/deletePeliculas", method = RequestMethod.POST)
	public String deletePeliculas(@RequestParam("titulo") String titulo, ModelMap mp) {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {

			peliculaDao.eliminarPelicula(titulo);
			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}

		mp.put("listaPelis", listaPelis);

		return "redirect:MantenimientoPelicula";

	}

	@RequestMapping(value = "/listaDirectoresConsultados")
	public String listaDirectores(ModelMap mp) {

		listaDirectores = peliculaDao.listaDirectores();

		mp.put("listaDirectores", listaDirectores);

		return "listaDirectores";

	}

	@RequestMapping("/infoPage")
	public String infoPage() {
		return "infoPage";
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

		return "altaUsuario";
	}

	@RequestMapping(value = "/formPeliculas")
	public String irformPeliculas() {

		return "altaPelicula";
	}
	
	@RequestMapping(value = "/updateFormPeliculas")
	public String updateFormPeliculas(@RequestParam("tituloPeli") String tituloPeli,
			@RequestParam("director") String director, @RequestParam("fecha") String fecha, ModelMap mp) {

		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {

			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "errorPageToPelis";
		}

		mp.put("listaPelis", listaPelis);
		mp.put("director", director);
		mp.put("fecha", fecha);
		mp.put("tituloPeli", tituloPeli);

		return "modificarPelicula";
	}

}
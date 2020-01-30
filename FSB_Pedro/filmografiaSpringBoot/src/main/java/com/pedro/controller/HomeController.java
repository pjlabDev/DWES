/**
 * 
 */
package com.pedro.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	String user = "usuario";
	String mensaje = "message";
	String ventanaMantenimientoPeliculas = "mantenimientoPeliculas";
	String listaDePeliculas = "listaPelis";
	String listaDePeliculasCard = "listaPeliculasCard";
	String errorPage = "errorPageToPelis";
	String directorBD = "director";
	Set<String> listaDirectores = new TreeSet<>();
	PeliculaDaoImpl peliculaDao = new PeliculaDaoImpl();

//	Método que lleva a la página principal, dejando vacia la lista de directores consultados.
	@GetMapping(path = "/")
	public String irPrincipal(ModelMap mp) {

		listaDirectores.clear();

		return "principal";
	}

//	Éste método nos devuelve una lista de las peliculas que tiene un director, consultado anteriormente.
	@PostMapping(path = "/consultar")
	public String listaPeliculasDirector(@RequestParam("director") String director, ModelMap mp) {

		String message = null;

		List<Pelicula> listaPelis;

		try {

			listaPelis = peliculaDao.mostrarPeliculasDirector(director);

		} catch (SQLException e) {
			return errorPage;
		}

		if (listaPelis.isEmpty()) {
			message = "No existe ningún director con ese nombre en la base de datos.";
			mp.put(mensaje, message);
			return "consultaDirector";

		}

		mp.put(listaDePeliculas, listaPelis);
		mp.put(directorBD, director);

		return "listadoPeliculas";
	}

//	Login de usuarios administradores.
	@PostMapping(path = "/loginUser")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password,
			ModelMap mp) {

		String message = null;

		List<Usuario> listaUser = new ArrayList<>();

		try {

			listaUser = peliculaDao.loginDirector(usuario, password);

		} catch (SQLException e) {
			return errorPage;
		}

		if (listaUser.isEmpty()) {
			message = "Usuario no encontrado en la base de datos.";
			mp.put(mensaje, message);
			return "login";

		}
		
		mp.put(user, usuario);
		
		return "welcomeUser";
	}

//	Alta de usuarios administradores.
	@PostMapping(path = "/addUser")
	public String addUser(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
			@RequestParam("username") String username, @RequestParam("password") String password, ModelMap mp) {
		
		List<Usuario> listaUsers;

		try {

			peliculaDao.altaUsuario(nombre, apellidos, username, password);

			listaUsers = peliculaDao.mostrarUsuarios();

		} catch (SQLException e) {
			return errorPage;
		}

		mp.put("listaUsers", listaUsers);

		return "listadoUsers";

	}

//	Método que nos dirige a Mantenimiento de peliculas, mostrando un listado completo de las peliculas con toda su información
	@PostMapping(path = "/MantenimientoPelicula")
	public String mantPelis(@RequestParam("usuario") String usuario, ModelMap mp) {

		List<Pelicula> listaPelis;

		try {

			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			return errorPage;
		}
		
		mp.put(user, usuario);
		mp.put(listaDePeliculas, listaPelis);

		return ventanaMantenimientoPeliculas;

	}

//	Alta de nuevas peliculas
	@PostMapping(value = "/addPeliculas")
	public String addPeliculas(@RequestParam("director") String director, @RequestParam("titulo") String titulo,
			@RequestParam("fecha") String fecha, @RequestParam("foto") String foto, 
			@RequestParam("descripcion") String descripcion, @RequestParam("usuario") String usuario, ModelMap mp) {

		List<Pelicula> listaPelis;

		try {

			peliculaDao.altaPelicula(director, titulo, fecha, foto, descripcion);

			listaPelis = peliculaDao.mostrarPelis();
			
		} catch (SQLException e) {
			return errorPage;
		}
		
		mp.put(user, usuario);
		mp.put(listaDePeliculas, listaPelis);

		return ventanaMantenimientoPeliculas;

	}

//	Metodo que nos permite modificar la información de las peliculas.
	@PostMapping(path = "/updatePeliculas")
	public String updatePeliculas(@RequestParam("director") String director, @RequestParam("titulo") String titulo,
			@RequestParam("fecha") String fecha, @RequestParam("tituloPeli") String tituloPeli, @RequestParam("foto") String foto, 
			@RequestParam("descripcion") String descripcion, @RequestParam("usuario") String usuario, ModelMap mp) {

		List<Pelicula> listaPelis;

		try {

			peliculaDao.modificarPelicula(director, titulo, fecha, tituloPeli, foto, descripcion);
			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			return errorPage;
		}

		mp.put(listaDePeliculas, listaPelis);
		mp.put(user, usuario);

		return ventanaMantenimientoPeliculas;

	}

//	Metodo del controlador que se utiliza para borrar peliculas en base de datos.
	@PostMapping(path = "/deletePeliculas")
	public String deletePeliculas(@RequestParam("titulo") String titulo, @RequestParam("usuario") String usuario, ModelMap mp) {

		List<Pelicula> listaPelis;

		try {

			peliculaDao.eliminarPelicula(titulo);
			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			return errorPage;
		}

		mp.put(listaDePeliculas, listaPelis);
		mp.put(user, usuario);

		return ventanaMantenimientoPeliculas;

	}
	
//	Metodo que muestra mas informacion en sobre las peliculas.
	@PostMapping(path = "/moreInfo")
	public String moreInfo(@RequestParam("titulo") String titulo, @RequestParam("director") String director,
			@RequestParam("fecha") String fecha, @RequestParam("descripcion") String descripcion, 
			@RequestParam("foto") String foto, ModelMap mp){
		
		mp.put(directorBD,director);
		mp.put("titulo", titulo);
		mp.put("fecha", fecha);
		mp.put("descripcion", descripcion);
		mp.put("foto", foto);
			
		
		return "moreInfoPeliculas";
		
	}

//	Muestra una lista con los directores que hemos consultado.
	@GetMapping(path = "/listaDirectoresConsultados")
	public String listaDirectores(ModelMap mp) {

		listaDirectores = peliculaDao.listaDirectores();

		mp.put("listaDirectores", listaDirectores);

		return "listaDirectores";

	}
	
	@PostMapping(path = "/buscarPelis")
	public String buscarPelis(@RequestParam("filtro") String titulo, @RequestParam("filtro") String director, ModelMap mp) {
		
		String message = null;

		List<Pelicula> listaPelis;

		try {

			listaPelis = peliculaDao.buscarPelis(titulo, director);

		} catch (SQLException e) {
			return errorPage;
		}

		if (listaPelis.isEmpty()) {
			message = "No hemos podido encontrar la pelicula.";
			mp.put(mensaje, message);
			
			try {
				listaPelis = peliculaDao.mostrarPelis();
				
				mp.put(listaDePeliculas, listaPelis);
						
			} catch (SQLException e) {
				return errorPage;
			}
			
			return listaDePeliculasCard;

		}

		mp.put(listaDePeliculas, listaPelis);

		return listaDePeliculasCard;
		
	}
	
	@PostMapping(path = "/calificarPelis")
	public String calificarPeli(@RequestParam("idUsuario") int idUsuario, @RequestParam("idPelicula") int idPelicula, 
			@RequestParam("calificacion") int calificacion, ModelMap mp) {
		
		List<Pelicula> listaPelis;
		String message = null;
		
		try {
			
			message = peliculaDao.calificarPeli(idPelicula, idUsuario, calificacion);
			listaPelis = peliculaDao.mostrarPelis();
			
		} catch (SQLException e) {
			return errorPage;
		}
		
		if(message.equalsIgnoreCase("Pelicula calificada")) {
			
			mp.put(listaDePeliculas, listaPelis);
			
			return ventanaMantenimientoPeliculas;
			
		}else {
			
			mp.put(listaDePeliculas, listaPelis);
			mp.put("id", idUsuario);
			mp.put(mensaje, message);
			return "calificacion";
			
		}
		
	}
	
	@PostMapping(path = "/sacarId")
	public String sacarID(@RequestParam("usuario") String usuario, ModelMap mp) {
		
		List<Integer> id;
		List<Pelicula> listaPelis;
		
		try {
			
			listaPelis = peliculaDao.mostrarPelis();
			id = peliculaDao.sacarIDUser(usuario);
				
			mp.put("id", id.get(0));
			mp.put(listaDePeliculas, listaPelis);
			
		} catch (SQLException e) {
			return errorPage;
		}
		
		return "calificacion";
		
	}
	
	
	
	
	
	
	
	
	//Metodos para cambiar de pestañas.

	@GetMapping(path = "/infoPage")
	public String infoPage() {
		return "infoPage";
	}

	@GetMapping(path = "/consultaDirector")
	public String consultaDirector() {
		return "consultaDirector";
	}

	@GetMapping(path = "/loginPage")
	public String irLoginPage() {
		return "login";
	}
	
	@PostMapping(path = "/volverwelcome")
	public String welcomeUser(@RequestParam("usuario") String usuario, ModelMap mp) {
		
		mp.put(user, usuario);
		
		return "welcomeUser";
		
	}

	@PostMapping(path = "/addFormUser")
	public String iraddUserPage(@RequestParam("usuario") String usuario, ModelMap mp) {

		mp.put(user, usuario);
		
		return "altaUsuario";
	}

	@PostMapping(path = "/formPeliculas")
	public String irformPeliculas() {

		return "altaPelicula";
	}
	
	//Este metodo me cambia a la pestaña de modificarPelicula junto con los datos de la pelicula, para poder
	//proceder a modificarla.
	@PostMapping(path = "/updateFormPeliculas")
	public String updateFormPeliculas(@RequestParam("tituloPeli") String tituloPeli,
			@RequestParam("director") String director, @RequestParam("fecha") String fecha, @RequestParam("foto") String foto,
			@RequestParam("descripcion") String descripcion, @RequestParam("usuario") String usuario, ModelMap mp) {

		List<Pelicula> listaPelis;

		try {

			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			return errorPage;
		}

		mp.put(listaDePeliculas, listaPelis);
		mp.put(directorBD, director);
		mp.put("fecha", fecha);
		mp.put("foto",foto);
		mp.put("descripcion",descripcion);
		mp.put("tituloPeli", tituloPeli);
		mp.put(user, usuario);
		
		return "modificarPelicula";
	}
	
	@GetMapping(path = "/cartelera")
	public String cartelera(ModelMap mp) {
		
		List<Pelicula> listaPelis;

		try {

			listaPelis = peliculaDao.mostrarPelis();

		} catch (SQLException e) {
			return errorPage;
		}

		mp.put(listaDePeliculas, listaPelis);
		
		return listaDePeliculasCard;
		
	}

}
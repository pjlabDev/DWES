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
import org.springframework.web.bind.annotation.RequestParam;

import com.pedro.modelo.Pelicula;
import com.pedro.repository.PeliculaDaoImpl;

/**
 * 
 * @author usuario
 *
 */
@Controller
@EnableAutoConfiguration
public class HomeController {
	
	PeliculaDaoImpl pdao = new PeliculaDaoImpl();
	
	@RequestMapping("/")
	public String irPrincipal() {
		return "principal";
	}
	
	@RequestMapping("/infoPage")
	public String secondPage() {
		return "infoPage";
	}
	
	@RequestMapping("/consultar")
	public String listaPeliculasDirector(@RequestParam("director") String director, ModelMap mp) throws SQLException {
		
		String message = null;
		
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();
		
		listaPelis = pdao.mostrarPeliculasDirector(director);
		
		if(listaPelis.isEmpty()) {
			message = "No existe ningún director con ese nombre en la base de datos.";
		}
		
		mp.put("listaPelis", listaPelis);
		mp.put("message", message);
		
		return "listadoPeliculas";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/consultaDirector")
	public String consultaDirector() {
		return "consultaDirector";
	}
	
	
}
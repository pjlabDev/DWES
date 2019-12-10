/**
 * 
 */
package com.pedro.filmografia.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pedro.filmografia.domain.Pelicula;
import com.pedro.filmografia.repository.PeliculaDao;

/**
 * @author pedro
 *
 */
@Controller
@RequestMapping(value = "/consultarDirector.htm")
public class ListadoPelicula {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	PeliculaDao peliculaDao;

	@RequestMapping(method = RequestMethod.POST)
	public String listaPelisDirector(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		List<Pelicula> listaPelis = new ArrayList<Pelicula>();

		try {

			listaPelis = peliculaDao.mostrarPeliculasDirector(usuario);
			
			request.setAttribute("listaPelis", listaPelis);
			
			return "listadoPelicula";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "ExceptionPage";
		}

	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected Pelicula formBackingObject(HttpServletRequest request) throws ServletException {
		Pelicula pelicula = new Pelicula();
		pelicula.setDirector("Pedro");
		return pelicula;
	}

}

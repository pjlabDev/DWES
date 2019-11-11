package net.itinajero.app.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFacade {
	
	public String impMetodo(ServletContext sc, HttpServletRequest request, HttpServletResponse response);
	
}

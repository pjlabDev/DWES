package net.itinajero.app.controller;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.dao.EmpleadoDAO;
import net.itinajero.app.model.DatosNoCorrectosException;

@Controller
public class MostrarEmpleadoController implements IFacade{
	
	EmpleadoDAO empDAO;
	
	@RequestMapping(value="/mostrarEmpleados", method=RequestMethod.POST)
	public String impMetodo(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		
		String view = "/mostrarEmpleados";
		
		empDAO = new EmpleadoDAO();
		
		try {
			
			request.setAttribute("listaEmp", empDAO.mostrarEmpleados());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatosNoCorrectosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return view;
	}
	
}

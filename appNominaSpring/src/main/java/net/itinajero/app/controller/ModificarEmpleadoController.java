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
public class ModificarEmpleadoController implements IFacade{

	EmpleadoDAO empDAO;
	
	@RequestMapping(value="/modificarEmpleado", method=RequestMethod.POST)
	public String impMetodo(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		
		empDAO = new EmpleadoDAO();
		
		String view = "/empleadoModificado";
		
		String dni = request.getParameter("dni");
		
		String nombre = request.getParameter("nombre");
		
		String sexo = request.getParameter("sexo");
		
		String categoria = request.getParameter("categoria");
		
		String anyos = request.getParameter("anyos");
		
		try {
			
			empDAO.modificarEmpleado(dni, nombre, sexo, categoria, anyos);
			
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

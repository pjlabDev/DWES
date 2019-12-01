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
import net.itinajero.app.model.Empleado;

@Controller
public class SacarEmpxDniController implements IFacade {

	EmpleadoDAO empDAO;
	
	@RequestMapping(value="/sacarEmpxDni", method=RequestMethod.POST)
	public String impMetodo(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		
		empDAO = new EmpleadoDAO();
		
		String view = "/modificarEmpleado";
		
		String dni = request.getParameter("dni");
		
		try {
			
			Empleado emp = empDAO.mostrarEmpleadosDni(dni);
			
			request.setAttribute("empleado", emp);
			
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

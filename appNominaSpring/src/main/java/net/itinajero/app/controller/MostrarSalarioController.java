package net.itinajero.app.controller;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.dao.EmpleadoDAO;

@Controller
public class MostrarSalarioController implements IFacade {

	EmpleadoDAO empDAO;
	
	@RequestMapping(value="/mostrarSalario", method=RequestMethod.POST)
	public String impMetodo(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		
		String view = "mostrarSalarioEmpleado";
		
		empDAO = new EmpleadoDAO();
		
		String dni = request.getParameter("dni");
		
		try {
			
			String salario = empDAO.mostrarSalarioDni(dni);
			
			request.setAttribute("salarioEmp", salario);
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return view;
	}

}

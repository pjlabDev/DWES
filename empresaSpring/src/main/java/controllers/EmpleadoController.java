/**
 * 
 */
package controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.EmpleadoDAO;
import laboral.DatosNoCorrectosException;
import laboral.Empleado;

/**
 * @author estudiante
 *
 */
@Controller
public class EmpleadoController {

	EmpleadoDAO empDAO;
	String pag = null;

	@RequestMapping("/")
	public String pagPrincipal() {

		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String goHome(@RequestParam String action, Model model)
			throws ClassNotFoundException, SQLException, DatosNoCorrectosException {

		empDAO = new EmpleadoDAO();

		if (action.equals("Mostrar Empleados")) {

			List<Empleado> empleado = empDAO.mostrarEmpleados();

			model.addAttribute("listaEmp", empleado);

			pag = "mostrarEmpleados";

		}

		return pag;

	}

}

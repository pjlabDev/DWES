/**
 * 
 */
package net.itinajero.app.dao;

import java.sql.SQLException;
import java.util.List;

import net.itinajero.app.model.DatosNoCorrectosException;
import net.itinajero.app.model.Empleado;

/**
 * @author estudiante
 *
 */
public interface IServiceDAO {
	
	public List<Empleado> mostrarEmpleados()throws ClassNotFoundException, SQLException, DatosNoCorrectosException;
	
	public String mostrarSalarioDni(String dni)throws ClassNotFoundException, SQLException;
	
	public Empleado mostrarEmpleadosDni(String dni)throws ClassNotFoundException, SQLException, DatosNoCorrectosException;
	
	public void modificarEmpleado(String dni, String nombre, String sexo, String categoria, String anyos)throws ClassNotFoundException, SQLException, DatosNoCorrectosException;

}

package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laboral.BBDD;

/**
 * Servlet implementation class modificarEmpleadoController
 */
public class modificarEmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarEmpleadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		BBDD bd = new BBDD();
		
		RequestDispatcher rd;
		
		String dni = request.getParameter("dni");
		
		String nombre = request.getParameter("nombre");
		
		bd.modificarNombreEmpleado(nombre, dni);
		
		String sexo = request.getParameter("sexo");
		
		bd.modificarSexoEmpleado(sexo, dni);
		
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		
		bd.modificarCategoriaEmpleado(dni, categoria);
		
		int anyos = Integer.parseInt(request.getParameter("anyos"));
		
		bd.modificarAnyosEmpleadoDNI(anyos, dni);
		
		rd = request.getRequestDispatcher("empleadoModificado.jsp");
		
		rd.forward(request, response);
		
	}

}

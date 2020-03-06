/**
 * 
 */
package com.pedro.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;
import com.pedro.repository.ProductRepository;
import com.pedro.service.ProductServiceImpl;

/**
 * 
 * @author usuario
 * 
 */
@Controller
@EnableAutoConfiguration
public class HomeController {
	
	String user = "usuario";
	String mensaje = "message";
	String ventanaMantenimientoPeliculas = "mantenimientoPeliculas";
	String listaDePeliculas = "listaPelis";
	String listaDePeliculasCard = "listaPeliculasCard";
	String errorPage = "errorPageToPelis";
	String directorBD = "director";
	Set<String> listaDirectores = new TreeSet<>();
	ProductRepository productR = new ProductRepository();
	ProductServiceImpl pService = new ProductServiceImpl();


	@GetMapping(path = "/")
	public String irPrincipal(ModelMap mp) {

		return "index";
	}

	@PostMapping(path = "/categoria")
	public String login(@RequestParam("correo") String correo, @RequestParam("clave") String clave,
			ModelMap mp) {

		String message = null;

		List<Restaurantes> listaRes = new ArrayList<>();
		List<Categorias> list1 = new ArrayList<>();
		List<Categorias> list2 = new ArrayList<>();
		List<Categorias> list3 = new ArrayList<>();

		try {

			listaRes = productR.login(correo, clave);
			list1 = productR.mostrarNombreCategorias1();
			list2 = productR.mostrarNombreCategorias2();
			list3 = productR.mostrarNombreCategorias3();

		} catch (SQLException e) {
			return errorPage;
		}

		if (listaRes.isEmpty()) {
			message = "Usuario no encontrado en la base de datos.";
			mp.put(mensaje, message);
			return "index";

		}
		
		mp.put("correo", correo);
		mp.put("clave", clave);
		mp.put("list1", list1);
		mp.put("list2", list2);
		mp.put("list3", list3);
		
		return "categorias";
	}
	
	@PostMapping(path = "/productos")
	public String mostrarProductos(@RequestParam("codCat") int codCat, @RequestParam("correo") String correo, @RequestParam("clave") String clave, ModelMap mp) {
		
		List<Productos> listaProd = new ArrayList<>();
		
		try {
			
			listaProd = productR.mostrarProductosxCat(codCat);
			
		} catch (SQLException e) {
			return errorPage;
		}
		
		mp.put("listaProd", listaProd);
		mp.put("codCat", codCat);
		mp.put("correo", correo);
		mp.put("clave", clave);
		
		return "productos";
	}
	
	@PostMapping(path = "/productosC")
	public String addCarrito(@RequestParam("codCat") int codCat, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("peso") String peso, @RequestParam("unidades") String unidades, ModelMap mp) {
		
		List<Productos> listaProd = new ArrayList<>();
		
		try {
			
			listaProd = pService.mostrarProductosxCat(codCat);
			
		} catch (SQLException e) {
			return errorPage;
		}
		
		pService.agregarCarrito(nombre, descripcion, Double.parseDouble(peso), Integer.parseInt(unidades));
		
		mp.put("listaProd", listaProd);
		
		return "productos";
	}
	
	@GetMapping(path = "/carrito")
	public String verCarrito(ModelMap mp) {
		
		List<Carrito> listaCarr = new ArrayList<>();
		
		listaCarr = pService.verCarrito();
		
		mp.put("carrito", listaCarr);
		
		return "carrito";	
	}

}
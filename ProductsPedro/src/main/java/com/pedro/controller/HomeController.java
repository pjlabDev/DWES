/**
 * 
 */
package com.pedro.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pedro.modelo.Carrito;
import com.pedro.modelo.Categorias;
import com.pedro.modelo.Pedidos;
import com.pedro.modelo.Productos;
import com.pedro.modelo.Restaurantes;
import com.pedro.repository.ProductRepository;
import com.pedro.service.EmailServiceImpl;
import com.pedro.service.ProductServiceImpl;

/**
 * 
 * @author pedro
 * 
 */
@Controller
@EnableAutoConfiguration
public class HomeController {
	
	ProductServiceImpl ps = new ProductServiceImpl();
	ProductRepository pr = new ProductRepository();
	List<Carrito> listaCarr = new ArrayList<>();
	Date d = new Date();
	
	EmailServiceImpl em = new EmailServiceImpl();
	
//	@Autowired
//	EmailService em;


	@GetMapping(path = "/")
	public String irPrincipal(ModelMap mp) {
		
		this.listaCarr.clear();
		
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

			listaRes = ps.login(correo, clave);
			list1 = ps.mostrarNombreCategorias1();
			list2 = ps.mostrarNombreCategorias2();
			list3 = ps.mostrarNombreCategorias3();
			
		} catch (Exception e) {
			return "errorPage";
		}

		if (listaRes.isEmpty()) {
			message = "Usuario no encontrado en la base de datos.";
			mp.put("message", message);
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
	public String mostrarProductos(@RequestParam("cod") int cod, @RequestParam("correo") String correo, @RequestParam("clave") String clave, ModelMap mp) {
		
		List<Productos> listaProd = new ArrayList<>();
		
		try {
			
			listaProd = ps.mostrarProductosxCat(cod);
			
		} catch (Exception e) {
			return "errorPage";
		}

		mp.put("listaProd", listaProd);
		mp.put("codCat", cod);
		mp.put("correo", correo);
		mp.put("clave", clave);
		
		return "productos";
	}
	
	@PostMapping(path = "/comprar")
	public String addCarrito(@RequestParam("codCat") int codCat, @RequestParam("codProd") Integer codProd,
			@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("peso") double peso, @RequestParam("unidades") int unidades, @RequestParam("correo") String correo, @RequestParam("clave") String clave, ModelMap mp) {
		
		Carrito car = new Carrito(codProd, nombre, descripcion, peso, unidades);
		
		try {
			
			mp.put("listaProd", ps.mostrarProductosxCat(codCat));
			
		} catch (Exception e) {
			return "errorPage";
		}
		
		this.listaCarr.add(car);
		mp.put("correo", correo);
		mp.put("clave", clave);
		mp.put("codCat", codCat);
		
		return "productos";
	}
	
	@PostMapping(path = "/carrito")
	public String verCarrito(@RequestParam("correo") String correo, @RequestParam("clave") String clave, ModelMap mp) {
		
		mp.put("carrito", this.listaCarr);
		mp.put("correo", correo);
		mp.put("clave", clave);
		
		return "carrito";
	}
	
	@PostMapping(path = "/eliminar")
	public String eliminarUnidad(@RequestParam("codProd") Integer codProd, @RequestParam("unidadesNuevas") String unidadesNuevas,
			@RequestParam("correo") String correo, @RequestParam("clave") String clave, ModelMap mp) {
		
		for (int i = 0; i < this.listaCarr.size(); i++) {
			
			if(this.listaCarr.get(i).getCodProd() == codProd) {
				if(this.listaCarr.get(i).getUnidades() > 1 && (this.listaCarr.get(i).getUnidades() - Integer.parseInt(unidadesNuevas)) > 0) {
					this.listaCarr.get(i).setUnidades(this.listaCarr.get(i).getUnidades() - Integer.parseInt(unidadesNuevas));
				}else {
					this.listaCarr.remove(i);
				}
			}
			
		}
		
		mp.put("carrito", this.listaCarr);
		mp.put("correo", correo);
		mp.put("clave", clave);
		
		return "carrito";
	}	
	
	@PostMapping(path = "/realizarPedido")
	public String realizarPedido(@RequestParam("correo") String correo, @RequestParam("clave") String clave, ModelMap mp) {
		
		List<Pedidos> listaPedidos = new ArrayList<>();
		
		List<Integer> listaCodRes;
		
		String fecha = (new SimpleDateFormat("yyyy-MM-dd").format(d));
		
		int codPedido = 0;
		
		try {
			
			listaCodRes = ps.obtenerCodRes(correo);
			
			ps.altaPedido(fecha, 0, listaCodRes.get(0));
			
			listaPedidos = ps.listarPedidosNoEnviados();
			
			for (Pedidos p  : listaPedidos) {
				codPedido = p.getCodPed();
			}
			
			for (int i = 0; i < this.listaCarr.size(); i++) {
				
				ps.altaPedidosProductos(codPedido, this.listaCarr.get(i).getCodProd(), this.listaCarr.get(i).getUnidades());				
				
				ps.updatearStock(this.listaCarr.get(i).getUnidades(), this.listaCarr.get(i).getCodProd());
				
			}
			
//			pr.enviarPedido();
			
		} catch (Exception e) {
			return "errorPage";
		}
		
		this.listaCarr.clear();
		
//		em.enviarEmail("perezprueba55@gmail.com");
		
		em.enviarCorreo(correo, "Compra realizada", "Su pedido se enviará de forma inmediata! Esperemos que sea de su agrado haber comprado en nuestra compañia! Le esperamos de nuevo, un saludo!!");
		
		mp.put("listaPedidos", listaPedidos);
		mp.put("correo", correo);
		mp.put("clave", clave);
		
		return "pedidoRealizado";
		
	}

}
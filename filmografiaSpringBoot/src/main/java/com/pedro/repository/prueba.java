package com.pedro.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pedro.modelo.Pelicula;
import com.pedro.modelo.Usuario;
import com.pedro.service.PeliculaServiceImpl;

public class prueba {
	static Pelicula p = new Pelicula();
	public static void main(String[] args) {
		PeliculaServiceImpl pser = new PeliculaServiceImpl();
		
		
		List<Pelicula> listaPelis = new ArrayList<>();
		
		try {
			
			
			listaPelis = pser.mostrarPeliculasDirector("Pedro");
			
			System.out.println(listaPelis.indexOf(p.getDirector()));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
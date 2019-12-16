/**
 * 
 */
package com.pedro.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author usuario
 *
 */
@Entity
@Table
public class Usuario {
	
	@Id
	private Integer id;
	private String nombre;
	private String password;
	
	public Usuario(Integer id,String nombre, String password) {
		
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		
	}
	
	public Usuario() {
		
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

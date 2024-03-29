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
	private int id;

	private String nombre;

	private String apellidos;

	private String user;

	private String password;

	public Usuario(int id, String nombre, String apellidos, String user, String password) {

		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = user;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}

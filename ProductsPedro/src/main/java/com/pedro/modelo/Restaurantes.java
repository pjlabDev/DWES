/**
 * 
 */
package com.pedro.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class Restaurantes.
 *
 * @author estudiante
 */

@Entity
@Table
public class Restaurantes {
	
	/** The CodRes. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodRes;
	
	/** The Correo. */
	@NotNull
	@Column
	private String Correo;
	
	/** The Clave. */
	@NotNull
	@Column
	private String Clave;
	
	/** The Pais. */
	@NotNull
	@Column
	private String Pais;
	
	/** The CP. */
	@NotNull
	@Column
	private int CP;
	
	/** The Ciudad. */
	@NotNull
	@Column
	private String Ciudad;
	
	/** The Direccion. */
	@NotNull
	@Column
	private String Direccion;
	
	/**
	 * Instantiates a new restaurantes.
	 *
	 * @param CodRes the cod res
	 * @param Correo the correo
	 * @param Clave the clave
	 * @param Pais the pais
	 * @param CP the cp
	 * @param Ciudad the ciudad
	 * @param Direccion the direccion
	 */
	public Restaurantes(int CodRes, String Correo, String Clave, String Pais, int CP, String Ciudad, String Direccion) {
		this.CodRes = CodRes;
		this.Correo = Correo;
		this.Clave = Clave;
		this.Pais = Pais;
		this.CP = CP;
		this.Ciudad = Ciudad;
		this.Direccion = Direccion;
	}
	
	public Restaurantes() {
		
	}

	/**
	 * Gets the cod res.
	 *
	 * @return the cod res
	 */
	public int getCodRes() {
		return CodRes;
	}

	/**
	 * Sets the cod res.
	 *
	 * @param codRes the new cod res
	 */
	public void setCodRes(int codRes) {
		CodRes = codRes;
	}

	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return Correo;
	}

	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		Correo = correo;
	}

	/**
	 * Gets the clave.
	 *
	 * @return the clave
	 */
	public String getClave() {
		return Clave;
	}

	/**
	 * Sets the clave.
	 *
	 * @param clave the new clave
	 */
	public void setClave(String clave) {
		Clave = clave;
	}

	/**
	 * Gets the pais.
	 *
	 * @return the pais
	 */
	public String getPais() {
		return Pais;
	}

	/**
	 * Sets the pais.
	 *
	 * @param pais the new pais
	 */
	public void setPais(String pais) {
		Pais = pais;
	}

	/**
	 * Gets the cp.
	 *
	 * @return the cp
	 */
	public int getCP() {
		return CP;
	}

	/**
	 * Sets the cp.
	 *
	 * @param cP the new cp
	 */
	public void setCP(int cP) {
		CP = cP;
	}

	/**
	 * Gets the ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return Ciudad;
	}

	/**
	 * Sets the ciudad.
	 *
	 * @param ciudad the new ciudad
	 */
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return Direccion;
	}

	/**
	 * Sets the direccion.
	 *
	 * @param direccion the new direccion
	 */
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
}

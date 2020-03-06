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
 * The Class Pedidos.
 *
 * @author estudiante
 */

@Entity
@Table
public class Pedidos {
	
	/** The Cod ped. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodPed;
	
	/** The Fecha. */
	@NotNull
	@Column
	private String Fecha;
	
	/** The Enviado. */
	@NotNull
	@Column
	private int Enviado;
	
	/** The CodRes. */
	@NotNull
	@Column
	private int CodRes;
	
	/**
	 * Instantiates a new Pedidos.
	 *
	 * @param CodPed the CodPed
	 * @param fecha the Fecha
	 * @param enviado the Enviado
	 * @param restaurante the CodRes
	 */
	public Pedidos(int CodPed, String Fecha, int Enviado, int CodRes) {
		this.CodPed = CodPed;
		this.Fecha = Fecha;
		this.Enviado = Enviado;
		this.CodRes = CodRes;
	}
	
	public Pedidos() {
		
	}

	public int getCodPed() {
		return CodPed;
	}

	public void setCodPed(int codPed) {
		CodPed = codPed;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public int getEnviado() {
		return Enviado;
	}

	public void setEnviado(int enviado) {
		Enviado = enviado;
	}

	public int getCodRes() {
		return CodRes;
	}

	public void setCodRes(int codRes) {
		CodRes = codRes;
	}
		
}

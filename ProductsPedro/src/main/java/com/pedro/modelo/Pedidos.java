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
@Table(name="Pedidos")
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
	 * @param Fecha the fecha
	 * @param Enviado the enviado
	 * @param CodRes the cod res
	 */
	public Pedidos(int CodPed, String Fecha, int Enviado, int CodRes) {
		this.CodPed = CodPed;
		this.Fecha = Fecha;
		this.Enviado = Enviado;
		this.CodRes = CodRes;
	}
	
	/**
	 * Instantiates a new pedidos.
	 */
	public Pedidos() {
		
	}

	/**
	 * Gets the cod ped.
	 *
	 * @return the cod ped
	 */
	public int getCodPed() {
		return CodPed;
	}

	/**
	 * Sets the cod ped.
	 *
	 * @param codPed the new cod ped
	 */
	public void setCodPed(int codPed) {
		CodPed = codPed;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public String getFecha() {
		return Fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	/**
	 * Gets the enviado.
	 *
	 * @return the enviado
	 */
	public int getEnviado() {
		return Enviado;
	}

	/**
	 * Sets the enviado.
	 *
	 * @param enviado the new enviado
	 */
	public void setEnviado(int enviado) {
		Enviado = enviado;
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
		
}

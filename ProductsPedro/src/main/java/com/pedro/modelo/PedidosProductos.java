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
 * The Class PedidosProductos.
 *
 * @author pedro
 */

@Entity
@Table(name="PedidosProductos")
public class PedidosProductos {

	/** The Codpedprod. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodPedProd;
	
	/** The pedido. */
	@NotNull
	@Column
	private int Pedido;
	
	/** The producto. */
	@NotNull
	@Column
	private int Producto;
	
	/** The unidades. */
	@NotNull
	@Column
	private int Unidades;
	
	/**
	 * Instantiates a new pedidos productos.
	 *
	 * @param CodPedProd the cod ped prod
	 * @param Pedido the pedido
	 * @param Producto the producto
	 * @param Unidades the unidades
	 */
	public PedidosProductos(int CodPedProd, int Pedido, int Producto, int Unidades) {
		this.CodPedProd = CodPedProd;
		this.Pedido = Pedido;
		this.Producto = Producto;
		this.Unidades = Unidades;
	}
	
	/**
	 * Instantiates a new pedidos productos.
	 */
	public PedidosProductos() {
		
	}

	/**
	 * Gets the cod ped prod.
	 *
	 * @return the cod ped prod
	 */
	public int getCodPedProd() {
		return CodPedProd;
	}

	/**
	 * Sets the cod ped prod.
	 *
	 * @param codPedProd the new cod ped prod
	 */
	public void setCodPedProd(int codPedProd) {
		CodPedProd = codPedProd;
	}

	/**
	 * Gets the pedido.
	 *
	 * @return the pedido
	 */
	public int getPedido() {
		return Pedido;
	}

	/**
	 * Sets the pedido.
	 *
	 * @param pedido the new pedido
	 */
	public void setPedido(int pedido) {
		Pedido = pedido;
	}

	/**
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public int getProducto() {
		return Producto;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the new producto
	 */
	public void setProducto(int producto) {
		Producto = producto;
	}

	/**
	 * Gets the unidades.
	 *
	 * @return the unidades
	 */
	public int getUnidades() {
		return Unidades;
	}

	/**
	 * Sets the unidades.
	 *
	 * @param unidades the new unidades
	 */
	public void setUnidades(int unidades) {
		Unidades = unidades;
	}
	
}

package transacciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import inventario.ObraDeArte;

@SuppressWarnings("unused")
public class Pago implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoPago;
	private double valor;
	private int identificacion_cliente;
	private int codigoRegistro;
	private ArrayList<Pago> pagosEfectivo;
	
	public Pago(String tipoPago, double valor, int identificacion_cliente, int codigoRegistro) {
		super();
		this.tipoPago = tipoPago;
		this.valor = valor;
		this.identificacion_cliente = identificacion_cliente;
		this.codigoRegistro = codigoRegistro;
		this.pagosEfectivo = new ArrayList<Pago>();
	}
	public String getTipoPago() {
		return tipoPago;
	}
	
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public double getValor() {
		return valor;
	}
	
	public ArrayList<Pago> agregarPagoListaPagosEfectivo () {
		Pago nuevoPago  = new Pago(tipoPago, valor, identificacion_cliente, codigoRegistro);
		pagosEfectivo.add(nuevoPago);
		return pagosEfectivo;
	}
	public int getIdentificacion_cliente() {
		return identificacion_cliente;
	}
	public int getCodigoRegistro() {
		return codigoRegistro;
	}
	public void setCodigoRegistro(int codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}
	public void setIdentificacion_cliente(int identificacion_cliente) {
		this.identificacion_cliente = identificacion_cliente;
	}
	
	
	
}

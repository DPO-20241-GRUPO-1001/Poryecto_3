package pasarelas;

import java.util.ArrayList;
import java.util.HashMap;

import inventario.ObraDeArte;
import transacciones.Compra;
import transacciones.Pago;
import transacciones.Subasta;
import transacciones.TarjetaCredito;
import usuarios.Cliente;

public abstract class PasarelaPago 
{
	//atributos
	private Cliente comprador;
	private Pago pago;
	private Compra compra;
	private Subasta ofertaSubasta;
	private ArrayList<Pago> pagosTarjetaCredito;

	
	//constructor
	public PasarelaPago (Cliente cliente, Compra solCom, Subasta oferSub) 
	{
		this.comprador = cliente;
		this.compra = solCom;
		this.ofertaSubasta = oferSub;
		this.pagosTarjetaCredito = new ArrayList<Pago>();
	}
	
	//métodos
	public boolean verificarTarjeta(int numTarjeta) {
		TarjetaCredito tarjeta = comprador.getTarjetaCredito();
		if (tarjeta.getNumeroTarjeta() == numTarjeta) {
			return true;
		}
		return false;
	}
	
	public boolean verificarCupoCompra(Compra solCompra, int numTarjeta) 
	{
		TarjetaCredito tarjeta = comprador.getTarjetaCredito();
		double valorDeCompra = solCompra.valorCompra();
		
		if (valorDeCompra > tarjeta.getCupo()) {
			return false;
		}
		return true;
	}
	
	public boolean verificarReportada(int numTarjeta)
	{
		TarjetaCredito tarjeta = comprador.getTarjetaCredito();
		if (!tarjeta.isReportada()) {
			return false;
		}
		return true;
	}
	
	public ArrayList<Pago> generarPagosCompra () {
		ArrayList<Pago> listaPagosCompra = new ArrayList<>();
		for (ObraDeArte pieza : compra.getSolicitudCompra().values()) {
			Pago nuevoPago  = new Pago(compra.getTipoPago(),compra.valorCompra(), comprador.getIdentificacion(), pieza.getCodigoRegistro());
			listaPagosCompra.add(nuevoPago);
		}
		return listaPagosCompra;
		
	}
	
	public Pago generarPagoSubasta () {
		Pago nuevoPagoSubasta  = new Pago(ofertaSubasta.getOfertaIndividual().getTipoDePago(),ofertaSubasta.getValor_minimo(), 
										ofertaSubasta.getComprador(), ofertaSubasta.getPieza().getCodigoRegistro());
		return nuevoPagoSubasta;
		
	}
	
	
	public ArrayList<Pago> agregarPagoListaDeTarjeta () {
		pagosTarjetaCredito.add(generarPagoSubasta());
		for (Pago pago : generarPagosCompra()) {
			pagosTarjetaCredito.add(pago);
		}
		return pagosTarjetaCredito;
	}
	
}

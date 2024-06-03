package pasarelas;

import java.util.ArrayList;
import java.util.HashMap;

import transacciones.Compra;
import transacciones.Pago;
import transacciones.Subasta;
import transacciones.TarjetaCredito;
import usuarios.Cliente;

public class Paypal extends PasarelaPago{
	
	//heredados
	private HashMap<Integer, TarjetaCredito> tarjetas;
	private Cliente comprador;
		
		
	//constructor
	public Paypal(Cliente cliente, Compra solCom, Subasta oferSub) {
		super(cliente, solCom, oferSub);
	}


	@Override
	public boolean verificarTarjeta(int numTarjeta) {
		// TODO Auto-generated method stub
		return super.verificarTarjeta(numTarjeta);
	}


	@Override
	public boolean verificarCupoCompra(Compra solCompra, int numTarjeta) {
		// TODO Auto-generated method stub
		return super.verificarCupoCompra(solCompra, numTarjeta);
	}


	@Override
	public boolean verificarReportada(int numTarjeta) {
		// TODO Auto-generated method stub
		return super.verificarReportada(numTarjeta);
	}


	@Override
	public ArrayList<Pago> generarPagosCompra() {
		// TODO Auto-generated method stub
		return super.generarPagosCompra();
	}


	@Override
	public Pago generarPagoSubasta() {
		// TODO Auto-generated method stub
		return super.generarPagoSubasta();
	}


	@Override
	public ArrayList<Pago> agregarPagoListaDeTarjeta() {
		// TODO Auto-generated method stub
		return super.agregarPagoListaDeTarjeta();
	}	

	
}

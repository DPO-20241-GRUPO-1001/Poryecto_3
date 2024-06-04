package pasarelas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import transacciones.Compra;
import transacciones.Pago;
import transacciones.Subasta;
import usuarios.Cliente;

public class ApplePay extends PasarelaPago
{
		
	//constructor
	public ApplePay(Cliente cliente, Compra solCom, Subasta oferSub) {
		super(cliente, solCom, oferSub);
		
	}
	
    @Override
    public void cargarPagos(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String tipoPago = datos[0];
                    double valor = Double.parseDouble(datos[1]);
                    int idComprador = Integer.parseInt(datos[2]);
                    int codigoRegistro = Integer.parseInt(datos[3]);
                    Pago pago = new Pago(tipoPago, valor, idComprador, codigoRegistro);
                    pagosTarjetaCredito.add(pago);
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando pagos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void guardarPagos(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Pago pago : pagosTarjetaCredito) {
                bw.write(pago.getTipoPago() + "," + pago.getValor() + "," + pago.getIdentificacion_cliente() + "," + pago.getCodigoRegistro());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error guardando pagos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public boolean verificarTarjeta(int numTarjeta) {
        return super.verificarTarjeta(numTarjeta);
    }

    @Override
    public boolean verificarCupoCompra(Compra solCompra, int numTarjeta) {
        return super.verificarCupoCompra(solCompra, numTarjeta);
    }

    @Override
    public ArrayList<Pago> generarPagosCompra() {
        return super.generarPagosCompra();
    }

    @Override
    public Pago generarPagoSubasta() {
        return super.generarPagoSubasta();
    }

    @Override
    public ArrayList<Pago> agregarPagoListaDeTarjeta() {
        return super.agregarPagoListaDeTarjeta();
    }
}

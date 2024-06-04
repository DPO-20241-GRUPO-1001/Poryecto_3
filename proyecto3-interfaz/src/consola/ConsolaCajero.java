package consola;

import inventario.Artista;
import central.Galeria;
import transacciones.Pago;
import usuarios.Empleado;

public class ConsolaCajero extends ConsolaBasica
{
	private final String[] opcionesMenuPrincipal = new String[] {"Registrar pago","Consultar el historial de un artista", "Consultar el historial de un comprador",  "Salir"};
	 
	private Galeria galeria;
	 
	 public ConsolaCajero(String clasePasarela, String archivoDatos) {
	        this.galeria = new Galeria(clasePasarela, archivoDatos);
	    }
	 //Métodos
	 
	 public void mostrarMenuPrincipal() 
	 {
	     
		 int opcion = mostrarMenu("Bienvenido a la Galería Cajero", opcionesMenuPrincipal);
	     if(opcion == 1)
	     {
	    	 registrarPago( );
	     }
	     
	     else if(opcion == 2) 
	     {
	    	 consultarHistorialDeUnaPieza();
	     }
	     
	     else if(opcion == 3) 
	     {
	    	 consultarHistorialDeUnArtista();
	     }
	     
	     else if(opcion == 4)
	     {
	    	 System.out.println("Saliendo...");
	    	 System.exit(0);
	     }
	     
	     mostrarMenuPrincipal();
	    	 
	     }
	     
	     public void registrarPago() 
	     {
			 int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
			 String tipoPago = ("Ingrese el tipo de pago: ");
			 int identificadorCliente = pedirEnteroAlUsuario("Ingrese el identificador del cliente del que desea consultar el historial: ");
			 double monto = pedirNumeroAlUsuario("Ingrese el monto del pago: ");
			 Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador);
			 int codigoRegistro = pedirEnteroAlUsuario("Ingrese el código de registro de las obras por pagar: ");
			 
			 Pago pago = new Pago(tipoPago, monto, identificadorCliente, codigoRegistro);
			    empleado.registrarPago(pago);
	     }
	     
	     public void consultarHistorialDeUnaPieza()
	     { 
			 int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
			 int codigoRegistro = pedirEnteroAlUsuario("Ingrese el código de registro de la pieza de la que dese ver el historial:  ");
			 Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador); 
			 
			 String historialArtista = empleado.verHistorialPieza(codigoRegistro);
		        System.out.println(historialArtista);
	     }
	     
	     public void consultarHistorialDeUnArtista()
	     {
			 int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
			 Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador);

		     String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista que desea consultar: ");
		     Artista artista = galeria.obtenerArtistaPorNombre(nombreArtista); 

		     if (artista != null) {
		         String historial = empleado.buscarHistorialArtista(artista);
		         System.out.println(historial);
		     }
		     else {
		         System.out.println("No se encontró un artista con el nombre " + nombreArtista);
		        }
	     }
	   
}

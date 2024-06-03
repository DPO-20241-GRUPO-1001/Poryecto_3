package transacciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import central.Oferta;
import inventario.ObraDeArte;
import usuarios.Usuario;

@SuppressWarnings("unused")
public class Subasta extends Transaccion 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//heredados
	private Date fechaSolicitud;
	private Date fechaAprobacion;
	private int comprador;
	private ObraDeArte pieza;
	private int valor_minimo;
	private Oferta ofertaIndividual;
	private HashMap<Integer, Usuario> Empleados;
	private HashMap<Integer, Usuario> Clientes;
	private ArrayList<Oferta> solicitudesSubasta;
	
		
	//constructor
	

	public Subasta( Date fechaAprobacion, int comprador, ObraDeArte pieza, int valor_minimo) {
		super( fechaAprobacion);
		this.pieza = pieza;
		this.valor_minimo = valor_minimo;
		this.Empleados = new HashMap<Integer, Usuario>( );
		this.Clientes = new HashMap<Integer, Usuario>( );
		this.solicitudesSubasta = new ArrayList<Oferta>( );
	}

	//metodos
	
	@Override
	public Date getFechaAprobacion() {
		// TODO Auto-generated method stub
		return super.getFechaAprobacion();
	}


	@Override
	public HashMap<Integer, Usuario> getEmpleados() {
		// TODO Auto-generated method stub
		return super.getEmpleados();
	}

	@Override
	public HashMap<Integer, Usuario> getClientes() {
		// TODO Auto-generated method stub
		return super.getClientes();
	}

	public HashMap<String, ObraDeArte> getSolicitudCompra() {
		return getSolicitudCompra();
	}

	public HashMap<String, ObraDeArte> getSolicitudSubasta() {
		return getSolicitudSubasta();
	}
	
	public void setPieza(ObraDeArte pieza) {
		this.pieza = pieza;
	}


	public int getValor_minimo() {
		return valor_minimo;
	}

	public void setValor_minimo(int valor_minimo) {
		this.valor_minimo = valor_minimo;
	}

	public Oferta getOfertaIndividual() {
		return ofertaIndividual;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}


	public void setComprador() {
		for (Oferta ofertaIndividual : solicitudesSubasta) {
			if (ofertaIndividual.getValor() > getValor_minimo());
			this.comprador = ofertaIndividual.getOfertante();
		}
	}
	
	public int getComprador() {
		return comprador;
	}

	public void setEmpleados(HashMap<Integer, Usuario> empleados) {
		Empleados = empleados;
	}


	public void setClientes(HashMap<Integer, Usuario> clientes) {
		Clientes = clientes;
	}

	public void setSolicitudSubasta(ArrayList<Oferta> solicitudesSubasta) {
		this.solicitudesSubasta = solicitudesSubasta;
	}
	
	public ObraDeArte getPieza() {
		return pieza;
	}
	
	public boolean  verificarOferta(Subasta subasta, int oferta) {
		 return subasta.getPieza().getValor_inicial()<oferta && oferta>subasta.getValor_minimo();
	}
	
	public boolean verificarEstadoPieza() {
    		if (pieza.getEstado().equals("en subasta")) {
    			return true;
    		}
    	return false;
    }
	
	public ArrayList<Oferta> agregarSolicitudesSubasta(Oferta ofertaIndividual){
		solicitudesSubasta.add(ofertaIndividual);
		return solicitudesSubasta;
	}
	
}


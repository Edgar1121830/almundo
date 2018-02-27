package co.com.almundo.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import co.com.almundo.modelo.Empleado;

/**
 * clase que representa el diparadro de llamadas
 * @author Edgar
 *
 */
public class Dispatcher implements Serializable{

	/**
	 * definicion de variables
	 */
	private static final long serialVersionUID = 1L;
	
	private Timestamp horaLlamadaIncio;
	
	private int tiempoDuracion;
	
	private Object receptorLlamada;
	
	private boolean disponible;
	
	private int numeroLlamadas;
	
	private List<Llamada> llamadaEspera;

	/**
	 * constructor
	 */
	public Dispatcher() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public Timestamp getHoraLlamadaIncio() {
		return horaLlamadaIncio;
	}

	/**
	 * 
	 * @param horaLlamadaIncio
	 */
	public void setHoraLlamadaIncio(Timestamp horaLlamadaIncio) {
		this.horaLlamadaIncio = horaLlamadaIncio;
	}

	/**
	 * 
	 * @return
	 */
	public int getTiempoDuracion() {
		return tiempoDuracion;
	}

	/**
	 * 
	 * @param tiempoDuracion
	 */
	public void setTiempoDuracion(int tiempoDuracion) {
		this.tiempoDuracion = tiempoDuracion;
	}

	/**
	 * 
	 * @return
	 */
	public Object getReceptorLlamada() {
		return receptorLlamada;
	}

	/**
	 * 
	 * @param receptorLlamada
	 */
	public void setReceptorLlamada(Object receptorLlamada) {
		this.receptorLlamada = receptorLlamada;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * 
	 * @param disponible
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * 
	 * @return
	 */
	public int getNumeroLlamadas() {
		return numeroLlamadas;
	}

	/**
	 * 
	 * @param numeroLlamadas
	 */
	public void setNumeroLlamadas(int numeroLlamadas) {
		this.numeroLlamadas = numeroLlamadas;
	}

	/**
	 * 
	 * @return
	 */
	public List<Llamada> getLlamadaEspera() {
		return llamadaEspera;
	}

	/**
	 * 
	 * @param llamadaEspera
	 */
	public void setLlamadaEspera(List<Llamada> llamadaEspera) {
		this.llamadaEspera = llamadaEspera;
	}

	/**
	 * metodo que asigna la persona según su disponibilidad
	 * @param empleado
	 * @param diponoble
	 * @param tiempo
	 */
	public Empleado dispacherCall(Object empleado, boolean diponoble,Llamada llamada) {
		Operario operario = new Operario();
		Supervisor supervisor = new Supervisor();
		Director director = new Director();
		Empleado empleadoAsignado = new Empleado();
		
		Calendar calendarHora = Calendar.getInstance();
		int minutosLlamada = calendarHora.get(Calendar.HOUR_OF_DAY);
		
		Calendar comparador = Calendar.getInstance();
		comparador.setTime(llamada.getHoraLlamada());
		int minutosLlamaEntrante = comparador.get(Calendar.HOUR_OF_DAY);
		
		int tiempoLlamada = minutosLlamada -minutosLlamaEntrante;
		
		if(empleado instanceof Empleado) {
			operario = (Operario) empleado;			
			if(operario.isDisponibilidad()) {
				empleadoAsignado = operario;
				if(tiempoLlamada>5 && tiempoLlamada<10) {
					operario.setDisponibilidad(false);
					operario.setNumeroLlamadas(operario.getNumeroLlamadas()+1);
				}
			}else {
				operario.setDisponibilidad(false);
			}
		}else if(empleado instanceof Empleado) {
			supervisor = (Supervisor) empleado;
			if(supervisor.isDisponibilidad()) {
				empleadoAsignado = supervisor;
				if(tiempoLlamada>5 && tiempoLlamada<10) {
					supervisor.setDisponibilidad(false);
				}
			}else{
				supervisor.setDisponibilidad(false);
			}
		}else if(empleado instanceof Empleado) {
			director = (Director) empleado;
			if(director.isDisponibilidad()) {
				empleadoAsignado = director;
				if(tiempoLlamada>5 && tiempoLlamada<10) {
					director.setDisponibilidad(false);
				}
			}else {
				director.setDisponibilidad(false);
			}
		}
		
		return empleadoAsignado;
	}
}

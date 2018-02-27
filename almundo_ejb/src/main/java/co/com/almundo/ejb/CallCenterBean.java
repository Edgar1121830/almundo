/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.almundo.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.almundo.enums.EstadoEnum;
import co.com.almundo.fachada.CallCenterFachada;
import co.com.almundo.modelo.Director;
import co.com.almundo.modelo.Dispatcher;
import co.com.almundo.modelo.Empleado;
import co.com.almundo.modelo.Llamada;
import co.com.almundo.modelo.Operario;
import co.com.almundo.modelo.Supervisor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;

/**
 * clase bean que se encarga de la persistencia de logica del callCenter
 * @author Edgar
 *
 */
@Stateless
@LocalBean
public class CallCenterBean implements CallCenterFachada{
	
	@PersistenceContext(unitName="almundo_ejb")
	private EntityManager em;

    /*
     * (non-Javadoc)
     * @see co.com.almundo.fachada.CallCenterFachada#crearLlamada(co.com.almundo.modelo.Llamada)
     */
	@Override
	public void crearLlamada(Llamada llamada) throws Exception{
    	if(llamada.getCodigoLlamada()>0) {
    		em.persist(llamada);
    	}
    }

	/*
	 * (non-Javadoc)
	 * @see co.com.almundo.fachada.CallCenterFachada#borrarLlamada(co.com.almundo.modelo.Llamada)
	 */
	@Override
	public void borrarLlamada(Llamada llamada) throws Exception {
		if(llamada.getCodigoLlamada()>0) {
			llamada.setEstadoLlamada(EstadoEnum.INACTIVO.getValor());
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.almundo.fachada.CallCenterFachada#asignarEmpleado(java.util.List, co.com.almundo.modelo.Llamada)
	 */
	@Override
	public Dispatcher asignarEmpleado(List<Empleado> empleado, Llamada llamada) throws Exception {
		Dispatcher dispatcher = new Dispatcher();
		boolean disponible = true;
		int numLlamadas = 0;
		for(Empleado empl :empleado) {
			numLlamadas = numLlamadas+1;
			Calendar calendarHora = Calendar.getInstance();
			int minutosLlamada = calendarHora.get(Calendar.HOUR_OF_DAY);
			
			Calendar comparador = Calendar.getInstance();
			comparador.setTime(llamada.getHoraLlamada());
			int minutosLlamaEntrante = comparador.get(Calendar.HOUR_OF_DAY);
			
			int tiempoLlamada = minutosLlamada -minutosLlamaEntrante;
			
			Object empleadoRecep = new Object(); 
			empleadoRecep = dispatcher.dispacherCall(empl, disponible, llamada);
			if(empleadoRecep instanceof Operario) {
				Operario e = (Operario) empleadoRecep;
				if(e.isDisponibilidad()){
					dispatcher.setDisponible(false);
					dispatcher.setHoraLlamadaIncio(new Timestamp(llamada.getHoraLlamada().getTime()));
					dispatcher.setNumeroLlamadas(numLlamadas);
					dispatcher.setReceptorLlamada(empleadoRecep);
					dispatcher.setTiempoDuracion(tiempoLlamada);
				}else {
					dispatcher = null;
				}
			}else if(empleadoRecep instanceof Supervisor) {
				Supervisor e = (Supervisor) empleadoRecep;
				if(e.isDisponibilidad()){
					dispatcher.setDisponible(false);
					dispatcher.setHoraLlamadaIncio(new Timestamp(llamada.getHoraLlamada().getTime()));
					dispatcher.setNumeroLlamadas(numLlamadas);
					dispatcher.setReceptorLlamada(empleadoRecep);
					dispatcher.setTiempoDuracion(tiempoLlamada);
				}else {
					dispatcher = null;
				}
			}else if(empleadoRecep instanceof Director) {
				Director e = (Director) empleadoRecep;
				if(e.isDisponibilidad()){
					dispatcher.setDisponible(false);
					dispatcher.setHoraLlamadaIncio(new Timestamp(llamada.getHoraLlamada().getTime()));
					dispatcher.setNumeroLlamadas(numLlamadas);
					dispatcher.setReceptorLlamada(empleadoRecep);
					dispatcher.setTiempoDuracion(tiempoLlamada);
				}else {
					dispatcher = null;
				}
			}
			
		}
		
		return dispatcher;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.almundo.fachada.CallCenterFachada#asignarLlamadaEnEspera(co.com.almundo.modelo.Llamada)
	 */
	@Override
	public Dispatcher asignarLlamadaEnEspera(Llamada llamada, Object empleado, int tiempoDuracion) throws Exception {
		Dispatcher dispatcher = new Dispatcher();
		
		Calendar calendarHora = Calendar.getInstance();
		int minutosLlamada = calendarHora.get(Calendar.HOUR_OF_DAY);
		
		Calendar comparador = Calendar.getInstance();
		comparador.setTime(llamada.getHoraLlamada());
		int minutosLlamaEntrante = comparador.get(Calendar.HOUR_OF_DAY);
		
		int tiempoLlamada = minutosLlamada -minutosLlamaEntrante;
		
		/*
		 * valida que el tiempo de duracion no sea mayor al tiempo de la llamada y asigna la llamada a un empleado
		 */
		if(tiempoDuracion>tiempoLlamada) {
			if(empleado instanceof Operario) {
				Operario e = (Operario) empleado;
				if(e.isDisponibilidad()){
					dispatcher.setDisponible(true);
					dispatcher.setHoraLlamadaIncio(new Timestamp(llamada.getHoraLlamada().getTime()));
					dispatcher.setNumeroLlamadas(0);
					dispatcher.setReceptorLlamada(empleado);
					dispatcher.setTiempoDuracion(tiempoLlamada);
				}else {
					dispatcher = null;
				}
			}else if(empleado instanceof Supervisor) {
				Supervisor e = (Supervisor) empleado;
				if(e.isDisponibilidad()){
					dispatcher.setDisponible(true);
					dispatcher.setHoraLlamadaIncio(new Timestamp(llamada.getHoraLlamada().getTime()));
					dispatcher.setNumeroLlamadas(0);
					dispatcher.setReceptorLlamada(empleado);
					dispatcher.setTiempoDuracion(tiempoLlamada);
				}else {
					dispatcher = null;
				}
			}else if(empleado instanceof Director) {
				Director e = (Director) empleado;
				if(e.isDisponibilidad()){
					dispatcher.setDisponible(true);
					dispatcher.setHoraLlamadaIncio(new Timestamp(llamada.getHoraLlamada().getTime()));
					dispatcher.setNumeroLlamadas(0
							);
					dispatcher.setReceptorLlamada(empleado);
					dispatcher.setTiempoDuracion(tiempoLlamada);
				}else {
					dispatcher = null;
				}
			}

		}		
		return dispatcher;
	}
    
   

}

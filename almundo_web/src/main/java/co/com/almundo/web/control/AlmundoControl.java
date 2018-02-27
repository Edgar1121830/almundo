package co.com.almundo.web.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.almundo.ejb.services.CallCenterServices;
import co.com.almundo.modelo.Dispatcher;
import co.com.almundo.modelo.Empleado;
import co.com.almundo.modelo.Llamada;

/**
 * clase control para ventana de call center
 * @author Edgar
 *
 */
@ManagedBean(name="off")
@SessionScoped
public class AlmundoControl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	CallCenterServices services;

	/**
	 * metodo que permite la sincronizacion de las llamadas y 
	 * la asignacionde los operarios por llamada
	 * @param empleados
	 * @param llamadas
	 * @return
	 */
	public Dispatcher asignarLlamada(List<Empleado>empleados, List<Llamada>llamadas) {
		Dispatcher d = new Dispatcher();
		try {
			if(llamadas.size()<=10) {
					synchronized (d) {
						d= services.asignarLlamada(empleados, llamadas);
					}
			}else {
				List<Llamada> restantes = new ArrayList<Llamada>();
				for(int i=0; i<llamadas.size(); i++) {
					if(i<=10) {
						synchronized (d) {
							d= services.asignarLlamada(empleados, llamadas);
							if(d.getReceptorLlamada()==null) {
								
							}
							llamadas.remove(i);
						}
					}else {
						Llamada llamadaRestante = new Llamada();
						restantes.add(llamadaRestante);
					}
					
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	/**
	 * metodo que permite la coloca en espera una llamdas hasta que un empleado se desocupe
	 * @param empleados
	 * @param llamadas
	 * @return
	 */
	public Dispatcher asignarLlamadaEnEspera(List<Empleado>empleados, List<Llamada>llamadas, Dispatcher dispatcher) {
		Dispatcher d = new Dispatcher();
		try {
			if(llamadas.size()<=10) {
					synchronized (d) {
						d= services.llamadaEnEspera(llamadas, empleados,dispatcher.getTiempoDuracion());
					}
			}else {
				List<Llamada> restantes = new ArrayList<Llamada>();
				for(int i=0; i<llamadas.size(); i++) {
					if(i<=10) {
						synchronized (d) {
							d= services.asignarLlamada(empleados, llamadas);
							if(d.getReceptorLlamada()==null) {
								
							}
							llamadas.remove(i);
						}
					}else {
						Llamada llamadaRestante = new Llamada();
						restantes.add(llamadaRestante);
					}
					
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
}

package co.com.almundo.ejb.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.almundo.fachada.CallCenterFachada;
import co.com.almundo.modelo.Dispatcher;
import co.com.almundo.modelo.Empleado;
import co.com.almundo.modelo.Llamada;


@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CallCenterServices {
	
	@EJB
	CallCenterFachada callCenterFachada;
	
	public Dispatcher asignarLlamada(List<Empleado> empleado, List<Llamada> llamada) throws Exception{
		Dispatcher dispatcher = new Dispatcher();
		Dispatcher dispatcherEspera = new Dispatcher();
		if(llamada.size()>0 && empleado.size()>0) {
			for(Llamada llamaRecibe:llamada) {
				Dispatcher dispatcherTemp = callCenterFachada.asignarEmpleado(empleado, llamaRecibe);
				if(dispatcherTemp!=null) {
					dispatcher = dispatcherTemp;
				}else {
					List<Llamada> llamadaEnEspera = new ArrayList<Llamada>();
					llamadaEnEspera.add(llamaRecibe);
					dispatcherEspera = llamadaEnEspera(llamadaEnEspera, (Empleado)dispatcher.getReceptorLlamada(),dispatcher.getTiempoDuracion());
				}
			}
		}
		
		return dispatcher;
	}
	
	/**
	 * metodo que se encarga de asignar una llamada en espera al
	 * no haber un empleado disponoble
	 * @param llamadasEspera
	 * @param empleado
	 * @param tiempoDuracionLlamada
	 * @return
	 * @throws Exception
	 */
	public Dispatcher llamadaEnEspera(List<Llamada> llamadasEspera, Object empleado, int tiempoDuracion) throws Exception{
		Dispatcher d = new Dispatcher();
		if(llamadasEspera.size()>0) {
			for(Llamada llamEsp:llamadasEspera) {
				d = callCenterFachada.asignarLlamadaEnEspera(llamEsp,empleado,tiempoDuracion);
			}
		}
		
		return d;
	}
}

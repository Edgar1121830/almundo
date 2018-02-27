package co.com.almundo.fachada;

import java.util.List;

import javax.ejb.Remote;

import co.com.almundo.modelo.Dispatcher;
import co.com.almundo.modelo.Empleado;
import co.com.almundo.modelo.Llamada;

@Remote
public interface CallCenterFachada {
	
	/**
	 * metodo que se encarga de crear una llamada
	 * @param llamada
	 * @throws Exception
	 */
	public void crearLlamada(Llamada llamada) throws Exception;
	
	/**
	 * metodo que elimna un llamada
	 * @param llamada
	 * @throws Exception
	 */
	public void borrarLlamada(Llamada llamada) throws Exception;
	
	
	/**
	 * meetodo que asigana una llamada a un empleado
	 * @param empleado
	 * @param llamada
	 * @return
	 * @throws Exception
	 */
	public Dispatcher asignarEmpleado(List<Empleado> empleado, Llamada llamada) throws Exception;
	
	
	/**
	 * meetodo que asigana una llamada en espera
	 * @param empleado
	 * @param llamada
	 * @return
	 * @throws Exception
	 */
	public Dispatcher asignarLlamadaEnEspera(Llamada llamada, Object empleado, int tiempoDuracion) throws Exception;

}

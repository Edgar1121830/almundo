package co.com.almundo.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Clase que indica el objeto de una llamada
 * @author Edgar
 *
 */
public class Llamada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codigoLlamada;
	
	private Date horaLlamada;
	
	private String lugarLlamda;
	
	private String numeroTelef�nicoOrigen;
	
	private String numeroTelef�nicoDestino;
	
	private String estadoLlamada;
	

	public Llamada() {
		super();
	}

	public int getCodigoLlamada() {
		return codigoLlamada;
	}

	public void setCodigoLlamada(int codigoLlamada) {
		this.codigoLlamada = codigoLlamada;
	}

	public Date getHoraLlamada() {
		return horaLlamada;
	}

	public void setHoraLlamada(Date horaLlamada) {
		this.horaLlamada = horaLlamada;
	}

	public String getLugarLlamda() {
		return lugarLlamda;
	}

	public void setLugarLlamda(String lugarLlamda) {
		this.lugarLlamda = lugarLlamda;
	}

	public String getNumeroTelef�nicoOrigen() {
		return numeroTelef�nicoOrigen;
	}

	public void setNumeroTelef�nicoOrigen(String numeroTelef�nicoOrigen) {
		this.numeroTelef�nicoOrigen = numeroTelef�nicoOrigen;
	}

	public String getNumeroTelef�nicoDestino() {
		return numeroTelef�nicoDestino;
	}

	public void setNumeroTelef�nicoDestino(String numeroTelef�nicoDestino) {
		this.numeroTelef�nicoDestino = numeroTelef�nicoDestino;
	}

	public String getEstadoLlamada() {
		return estadoLlamada;
	}

	public void setEstadoLlamada(String estadoLlamada) {
		this.estadoLlamada = estadoLlamada;
	}
	
	

}

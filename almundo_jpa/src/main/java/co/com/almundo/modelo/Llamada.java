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
	
	private String numeroTelefónicoOrigen;
	
	private String numeroTelefónicoDestino;
	
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

	public String getNumeroTelefónicoOrigen() {
		return numeroTelefónicoOrigen;
	}

	public void setNumeroTelefónicoOrigen(String numeroTelefónicoOrigen) {
		this.numeroTelefónicoOrigen = numeroTelefónicoOrigen;
	}

	public String getNumeroTelefónicoDestino() {
		return numeroTelefónicoDestino;
	}

	public void setNumeroTelefónicoDestino(String numeroTelefónicoDestino) {
		this.numeroTelefónicoDestino = numeroTelefónicoDestino;
	}

	public String getEstadoLlamada() {
		return estadoLlamada;
	}

	public void setEstadoLlamada(String estadoLlamada) {
		this.estadoLlamada = estadoLlamada;
	}
	
	

}

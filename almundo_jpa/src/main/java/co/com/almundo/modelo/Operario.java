package co.com.almundo.modelo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * clase que representa el objeto operario
 * @author Edgar
 *
 */
public class Operario extends Empleado implements Serializable{

	/**
	 * definicion de variables
	 */
	private static final long serialVersionUID = 1L;

	private int codigoOperario;
	
	private Timestamp horaIngreso;
	
	private String lugarTrabajo;
	
	private int numeroLlamadas;
	
	private boolean disponibilidad;
 
	/*
	 * constructor
	 */
	public Operario() {
		super();
	}

	/*
	 * metodos set y get
	 */
	
	/**
	 * 
	 * @return
	 */
	public int getCodigoOperario() {
		return codigoOperario;
	}

	/**
	 * 
	 * @param codigoOperario
	 */
	public void setCodigoOperario(int codigoOperario) {
		this.codigoOperario = codigoOperario;
	}

	/**
	 * 
	 * @return
	 */
	public Timestamp getHoraIngreso() {
		return horaIngreso;
	}

	/**
	 * 
	 * @param horaIngreso
	 */
	public void setHoraIngreso(Timestamp horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	/**
	 * 
	 * @return
	 */
	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	/**
	 * 
	 * @param lugarTrabajo
	 */
	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
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

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
}

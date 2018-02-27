package co.com.almundo.modelo;

import java.io.Serializable;

/**
 * clase que representa el objeto director
 * @author Edgar
 *
 */
public class Director extends Empleado implements Serializable{

	/**
	 * definicion de variables
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigoDirector;
	
	private float salario;
	
	private String centroACargo;
	
	private String direccionLugar;
	
	private boolean disponibilidad;

	/**
	 * constructor
	 */
	public Director() {
		super();
	}

	/*
	 * metodos set y get
	 */
	/**
	 * 
	 * @return
	 */
	public int getCodigoDirector() {
		return codigoDirector;
	}

	/**
	 * 
	 * @param codigoDirector
	 */
	public void setCodigoDirector(int codigoDirector) {
		this.codigoDirector = codigoDirector;
	}

	/**
	 * 
	 * @return
	 */
	public float getSalario() {
		return salario;
	}

	/**
	 * 
	 * @param salario
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}

	/**
	 * 
	 * @return
	 */
	public String getCentroACargo() {
		return centroACargo;
	}

	/**
	 * 
	 * @param centroACargo
	 */
	public void setCentroACargo(String centroACargo) {
		this.centroACargo = centroACargo;
	}

	/**
	 * 
	 * @return
	 */
	public String getDireccionLugar() {
		return direccionLugar;
	}

	/**
	 * 
	 * @param direccionLugar
	 */
	public void setDireccionLugar(String direccionLugar) {
		this.direccionLugar = direccionLugar;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
}

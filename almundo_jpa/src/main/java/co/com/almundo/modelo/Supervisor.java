package co.com.almundo.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * clase que representa el objeto supervisor
 * @author Edgar
 *
 */
public class Supervisor extends Empleado implements Serializable{

	/**
	 * definicion de variables
	 */
	private static final long serialVersionUID = 1L;
	
	private int codigoSupervisor;
	
	private List<Operario> personalACargo;
	
	private float salario;
	
	private boolean disponibilidad;
	
	/**
	 * constructor
	 */
	public Supervisor() {
		super();
	}

	/*
	 * metodos set y get
	 */
	
	/**
	 * 
	 * @return
	 */
	public int getCodigoSupervisor() {
		return codigoSupervisor;
	}

	/**
	 * 
	 * @param codigoSupervisor
	 */
	public void setCodigoSupervisor(int codigoSupervisor) {
		this.codigoSupervisor = codigoSupervisor;
	}

	/**
	 * 
	 * @return
	 */
	public List<Operario> getPersonalACargo() {
		return personalACargo;
	}

	/**
	 * 
	 * @param personalACargo
	 */
	public void setPersonalACargo(List<Operario> personalACargo) {
		this.personalACargo = personalACargo;
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

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
}

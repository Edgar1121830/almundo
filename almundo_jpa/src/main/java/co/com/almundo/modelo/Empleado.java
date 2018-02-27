package co.com.almundo.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * clase que representa el objeto empleado
 * @
 * @author Edgar
 */
public class Empleado implements Serializable{

	/**
	 * definicion de variables
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	private String apellido;
	
	private String direccionResidencia;
	
	private Date fechaNacimiento;
	
	private String genero;
	
	private String estadoCivil;

	private Date fechaIngreso;
	
	/*
	 * constructor de clase
	 */
	public Empleado() {
		super();
	}

	/*
	 * metodos set y get
	 */
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return
	 */
	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	/**
	 * 
	 * @param direccionResidencia
	 */
	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	/**
	 * 
	 * @return
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * 
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * 
	 * @return
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * 
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * 
	 * @return
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * 
	 * @param estadoCivil
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * 
	 * @return
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * 
	 * @param fechaIngreso
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
}

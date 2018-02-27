package co.com.almundo.web.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;

import org.junit.Before;
import org.junit.Test;

import co.com.almundo.enums.EstadoEnum;
import co.com.almundo.modelo.Director;
import co.com.almundo.modelo.Dispatcher;
import co.com.almundo.modelo.Empleado;
import co.com.almundo.modelo.Llamada;
import co.com.almundo.modelo.Operario;
import co.com.almundo.modelo.Supervisor;
import co.com.almundo.web.control.AlmundoControl;

@Stateless
@SessionScoped
public class DispatcherTest {
	
	/**
	 * creacion de varaiables
	 */
	private Llamada llamada = new Llamada();
	private Llamada llamada2 = new Llamada();
	private Llamada llamada3 = new Llamada();
	private Llamada llamada4 = new Llamada();
	private Llamada llamada5 = new Llamada();
	private Llamada llamada6 = new Llamada();
	private Llamada llamada7 = new Llamada();
	private Llamada llamada8 = new Llamada();
	private Llamada llamada9 = new Llamada();
	private Llamada llamada10 = new Llamada();
	private Empleado empleado = new Empleado();
	private Empleado empleado1 = new Empleado();
	private Empleado empleado2 = new Empleado();
	private Empleado empleado3 = new Empleado();
	private Operario operario = new Operario();
	private Operario operario1 = new Operario();
	private Operario operario2 = new Operario();
	private Supervisor supervisor = new Supervisor();
	private Director director = new Director();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private List<Empleado> empleados = new ArrayList<Empleado>();
	private List<Operario> operarios = new ArrayList<Operario>();

	
	/**
	 * metodo que se encarga de generar el personal para la prueba
	 */
	@Before
	public void crearPersonal() {
		
		/*
		 * inicilaizacion de objetos para la prueba
		 */
		Date fechaIngreso;
		Date fechaNa;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = "15/01/2018";
		String fechaNace = "14/04/1987";
		try {
			fechaIngreso = format.parse(fecha);
			fechaNa = format.parse(fechaNace);
			
			/*
			* creacion de personal
			*/
			empleado2.setApellido("Chavarro");
			empleado2.setDireccionResidencia("Carrera 8");
			empleado2.setEstadoCivil("Soltero");
			empleado2.setFechaIngreso(fechaIngreso);
			empleado2.setGenero("M");
			empleado2.setNombre("Cesar");
			empleado2.setFechaNacimiento(fechaNa);
			operario1.setApellido(empleado2.getApellido());
			operario1.setCodigoOperario(1);
			operario1.setDireccionResidencia(empleado2.getDireccionResidencia());
			operario1.setDisponibilidad(true);
			operario1.setEstadoCivil(empleado2.getEstadoCivil());
			operario1.setFechaIngreso(empleado2.getFechaIngreso());
			operario1.setFechaNacimiento(empleado2.getFechaNacimiento());
			operario1.setGenero(empleado2.getGenero());
			operario1.setHoraIngreso(new Timestamp(new Date().getTime()));
			operario1.setLugarTrabajo("Cubi1");
			operario1.setNombre(empleado2.getNombre());
			operario1.setNumeroLlamadas(1);
			operarios.add(operario1);
			empleados.add(operario1);
			
			empleado3.setApellido("Jimenez");
			empleado3.setDireccionResidencia("Calle13");
			empleado3.setEstadoCivil("Casado");
			empleado3.setFechaIngreso(fechaIngreso);
			empleado3.setGenero("M");
			empleado3.setNombre("Juan");
			empleado3.setFechaNacimiento(fechaNa);
			operario.setApellido(empleado3.getApellido());
			operario.setCodigoOperario(2);
			operario.setDireccionResidencia(empleado3.getDireccionResidencia());
			operario.setDisponibilidad(true);
			operario.setEstadoCivil(empleado3.getEstadoCivil());
			operario.setFechaIngreso(empleado3.getFechaIngreso());
			operario.setFechaNacimiento(empleado3.getFechaNacimiento());
			operario.setGenero(empleado3.getGenero());
			operario.setHoraIngreso(new Timestamp(new Date().getTime()));
			operario.setLugarTrabajo("Cubi2");
			operario.setNombre(empleado3.getNombre());
			operario.setNumeroLlamadas(1);
			operarios.add(operario);
			empleados.add(operario);
			
			empleado2.setApellido("Chavarro");
			empleado2.setDireccionResidencia("Carrera 8");
			empleado2.setEstadoCivil("Soltero");
			empleado2.setFechaIngreso(fechaIngreso);
			empleado2.setGenero("M");
			empleado2.setNombre("Cesar");
			empleado2.setFechaNacimiento(fechaNa);
			operario2.setApellido(empleado2.getApellido());
			operario2.setCodigoOperario(1);
			operario2.setDireccionResidencia(empleado2.getDireccionResidencia());
			operario2.setDisponibilidad(true);
			operario2.setEstadoCivil(empleado2.getEstadoCivil());
			operario2.setFechaIngreso(empleado2.getFechaIngreso());
			operario2.setFechaNacimiento(empleado2.getFechaNacimiento());
			operario2.setGenero(empleado2.getGenero());
			operario2.setHoraIngreso(new Timestamp(new Date().getTime()));
			operario2.setLugarTrabajo("Cubi1");
			operario2.setNombre(empleado2.getNombre());
			operario2.setNumeroLlamadas(1);
			empleados.add(operario2);
			
			
			empleado.setApellido("Medina");
			empleado.setDireccionResidencia("Calle 123");
			empleado.setEstadoCivil("Soltero");
			empleado.setFechaIngreso(fechaIngreso);
			empleado.setGenero("M");
			empleado.setNombre("Edgar");
			empleado.setFechaNacimiento(fechaNa);
			
			director.setApellido(empleado.getApellido());
			director.setCentroACargo("Tunja");
			director.setCodigoDirector(12);
			director.setDireccionLugar("Centro principal");
			director.setDireccionResidencia(empleado.getDireccionResidencia());
			director.setDisponibilidad(true);
			director.setEstadoCivil(empleado.getEstadoCivil());
			director.setFechaIngreso(empleado.getFechaIngreso());
			director.setFechaNacimiento(empleado.getFechaNacimiento());
			director.setGenero(empleado.getGenero());
			director.setNombre(empleado.getNombre());
			director.setSalario(700000000);
			empleados.add(director);
			
			
			empleado1.setApellido("Medina");
			empleado1.setDireccionResidencia("Carrera 46");
			empleado1.setEstadoCivil("Casado");
			empleado1.setFechaIngreso(fechaIngreso);
			empleado1.setGenero("M");
			empleado1.setNombre("Juan");
			empleado1.setFechaNacimiento(fechaNa);
			supervisor.setApellido(empleado1.getApellido());
			supervisor.setCodigoSupervisor(1);
			supervisor.setDireccionResidencia(empleado1.getDireccionResidencia());
			supervisor.setDisponibilidad(true);
			supervisor.setEstadoCivil(empleado1.getEstadoCivil());
			supervisor.setFechaIngreso(empleado1.getFechaIngreso());
			supervisor.setFechaNacimiento(empleado1.getFechaNacimiento());
			supervisor.setGenero(empleado1.getGenero());
			supervisor.setPersonalACargo(operarios);
			empleados.add(supervisor);
			
			/*
			 *fin creacion personal 
			 */
			
			/*
			 *llamada al metodo para crear las llamadas 
			 */
			llamadas();
			
		} catch (ParseException e1) {
			fail("Error al crear personal");
		}
	}
	
	/**
	 * metodo que se encarga de crear una lista de llamdas
	 */
	public void llamadas() {
		/*
		 * creacion de llamada
		 */
		llamada.setCodigoLlamada(1);
		llamada.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada.setHoraLlamada(new Date());
		llamada.setLugarLlamda("Tunja");
		llamada.setNumeroTelefónicoDestino("7467378");
		llamada.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada);
		
		llamada2.setCodigoLlamada(2);
		llamada2.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada2.setHoraLlamada(new Date());
		llamada2.setLugarLlamda("Tunja");
		llamada2.setNumeroTelefónicoDestino("7467378");
		llamada2.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada2);
	
		llamada3.setCodigoLlamada(3);
		llamada3.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada3.setHoraLlamada(new Date());
		llamada3.setLugarLlamda("Tunja");
		llamada.setNumeroTelefónicoDestino("7467378");
		llamada3.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada3);
		
		llamada4.setCodigoLlamada(4);
		llamada4.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada4.setHoraLlamada(new Date());
		llamada4.setLugarLlamda("Tunja");
		llamada4.setNumeroTelefónicoDestino("7467378");
		llamada4.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada4);
		
		llamada5.setCodigoLlamada(5);
		llamada5.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada5.setHoraLlamada(new Date());
		llamada5.setLugarLlamda("Tunja");
		llamada.setNumeroTelefónicoDestino("7467378");
		llamada5.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada5);
		
		llamada6.setCodigoLlamada(6);
		llamada6.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada6.setHoraLlamada(new Date());
		llamada6.setLugarLlamda("Tunja");
		llamada6.setNumeroTelefónicoDestino("7467378");
		llamada6.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada6);
		
		llamada7.setCodigoLlamada(7);
		llamada7.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada7.setHoraLlamada(new Date());
		llamada7.setLugarLlamda("Tunja");
		llamada7.setNumeroTelefónicoDestino("7467378");
		llamada7.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada7);
		
		llamada8.setCodigoLlamada(8);
		llamada8.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada8.setHoraLlamada(new Date());
		llamada8.setLugarLlamda("Tunja");
		llamada8.setNumeroTelefónicoDestino("7467378");
		llamada8.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada8);
		
		llamada9.setCodigoLlamada(9);
		llamada9.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada9.setHoraLlamada(new Date());
		llamada9.setLugarLlamda("Tunja");
		llamada9.setNumeroTelefónicoDestino("7467378");
		llamada9.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada9);
		
		llamada10.setCodigoLlamada(10);
		llamada10.setEstadoLlamada(EstadoEnum.ACTIVO.getValor());
		llamada10.setHoraLlamada(new Date());
		llamada10.setLugarLlamda("Tunja");
		llamada10.setNumeroTelefónicoDestino("7467378");
		llamada10.setNumeroTelefónicoOrigen("7752442");
		llamadas.add(llamada10);
		/*
		 * fin creacion llamada
		 */
		
	}
	
	
	/**
	 * metodo test para la asignacion de llamadas y tiempo por empleado
	 * Y COLOCA LA LLAMADA EN ESPERA.
	 */
	@Test
	public void AsigancionLlamadatest() {
		
		/*
		 * metodo de prueba para asignar llamada
		 */
		try {
			Dispatcher dispatcher = new Dispatcher();
			AlmundoControl almundoControl = new AlmundoControl();
			
			if(empleados.size()>0 && llamadas.size()>0) {
				/*
				 * valida si la hay disponibilidad de llamadas para despachar
				 */
				dispatcher = almundoControl.asignarLlamada(empleados, llamadas);
				assertTrue("Empleado asigando a un llamada", !dispatcher.getReceptorLlamada().equals(""));
			}else {
				fail("No se tiene datos para realizar la asignacion");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error al asignar las llamadas a un empleado");
		}
		
	}

}

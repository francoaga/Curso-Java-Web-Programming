package ar.com.educacionit.java_webprogramming.laboratorio_1.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.com.educacionit.java_webprogramming.laboratorio_1.utilities.FechaParser;


public class Alumno extends Persona {
	private LocalDate fechaIngreso;
	private ArrayList<Integer> cursos;
	
	/*Constructor por defecto*/
	public Alumno() {
		super();
		this.cursos = new ArrayList<>();
	}
	
	/**
	 * Constructor que permite establecer el nombre, apellido, documento, edad,
	 * fecha de nacimiento  y fecha de ingreso de un alumno.
	 * 
	 * @param nombre El nombre del alumno.
	 * @param apellido El apellido del alumno.
	 * @param documento El documento del alumno.
	 * @param edad La edad del alumno.
	 * @param fechaNac Fecha de nacimiento del alumno.
	 * @param fechaIngreso Fecha de ingreso del alumno.
	 */
	public Alumno(String nombre, String apellido, Documento documento,
			String fechaNac, String fechaIngreso) {
		super(nombre, apellido, documento, fechaNac);
		setFechaIngreso(fechaIngreso);
		this.cursos = new ArrayList<>();
	}

	/**
	 * Agrega un curso a un alumno.
	 * 
	 * @param idCurso El ID del curso que se quiere agregar.
	 */
	public void agregarCurso(Integer idCurso) {
		this.cursos.add(idCurso);
	}
	
	/**
	 * Representacion en cadena de un alumno, se muestra nombre, apellido, documento,
	 * edad, fecha de nacimiento y los cursos a los que esta inscripto.
	 * 
	 * @return Cadena que representa un alumno.
	 */
	@Override
	public String toString() {
		return "Alumno [" + super.toString() + ", cursos=" + cursos + "]";
	}

	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return this.getApellido() + ", " + this.getNombre() + " es un Alumno";
	}
	
	/**
	 * Establece la fecha de ingreso de un alumno.
	 * Si la fecha no existe, se lanza una excepcion.
	 * 
	 * @param fechaIngreso Fecha de ingreso del alumno.
	 * @throws DateTimeParseException Si la fecha no existe.
	 * @see FechaParser Para obtener mas detalles sobre el parseo de la fecha.
	 */
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = FechaParser.parsearFecha(fechaIngreso);
	}
	
	public String getFechaIngreso() {
		return FechaParser.fechaToString(fechaIngreso, FechaParser.FECHA_DDMMYYYY);
	}
}
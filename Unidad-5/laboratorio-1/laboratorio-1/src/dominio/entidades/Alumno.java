package dominio.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utilidades.FechaParser;

public class Alumno extends Persona {
	private LocalDate fechaIngreso;
	private List<Curso> cursos;
	
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
	public Alumno(String nombre, String apellido, Documento documento, int edad, 
			String fechaNac, String fechaIngreso) {
		super(nombre, apellido, documento, edad, fechaNac);
		setFechaIngreso(fechaIngreso);
		this.cursos = new ArrayList<>();
	}

	/**
	 * Agrega un curso a un alumno.
	 * Si se recibe una referencia nula, se lanza una excepcion.
	 * 
	 * @param nuevoCurso El curso que se quiere agregar.
	 * @throws NullPointerException Si se recibe una referencia nula.
	 */
	public void agregarCurso(Curso nuevoCurso) {
		if(nuevoCurso == null)
			throw new NullPointerException("Se recibio una referencia nula para el curso");
		
		this.cursos.add(nuevoCurso);
	}
	
	/**
	 * Muestra por consola todos los cursos a lo que esta inscripto un alumno.
	 */
	public void mostrarCursos() {
		if(cursos.isEmpty()) {
			System.out.println("La lista de cursos del alumno esta vacia.\n");
		}else {
			System.out.println("..:Cursos Inscriptos:..");
			for (Curso curso : cursos) {
				System.out.println(curso);
			}
		}
	}

	/**
	 * Representacion en cadena de un alumno, se muestra nombre, apellido, documento,
	 * edad, fecha de nacimiento y los cursos a los que esta inscripto.
	 * 
	 * @return Cadena que representa un alumno.
	 */
	@Override
	public String toString() {
		// Llamo al toString de Persona y elimino la subcadena "Persona {"
	    String personaString = super.toString().replace("Persona {", "");
	    return String.format("Alumno {%s, cursos= %s, sueldo= %s}", personaString, cursos);
	}

	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return String.format("%s, %s es un Alumno", this.getApellido(), this.getNombre());
	}
	
	@Override
	public void guardar() {
		System.out.println(String.format("El alumno %s se ha guardado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void eliminar() {
		System.out.println(String.format("El alumno %s se ha eliminado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void modificar() {
		System.out.println(String.format("El alumno %s se ha modificado correctamente\n", this.getNombreCompleto()));
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
}

package dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Empleado {
	private List<Curso> cursos;
	
	/*Constructor por defecto*/
	public Profesor() {
		super();
		this.cursos = new ArrayList<>();
	}
	
	/**
	 * Constructor que permite establece el nombre, apellido, documento, edad,
	 * fecha de nacimiento, fecha de cargo y sueldo de un profesor.
	 * 
	 * @param nombre Nombre del profesor.
	 * @param apellido Apellido del profesor.
	 * @param documento Documento del profesor.
	 * @param edad Edad del profesor.
	 * @param fechaNac Fecha de Nacimiento del profesor.
	 * @param fechaDeCargo Fecha de Cargo del profesor.
	 * @param sueldo Sueldo del profesor.
	 */
	public Profesor(String nombre, String apellido, Documento documento, int edad, String fechaNac,
			String fechaDeCargo, double sueldo) {
		super(nombre, apellido, documento, edad, fechaNac, fechaDeCargo, sueldo);
		this.cursos = new ArrayList<>();
	}
	
	/**
	 * Agrega un curso a un profesor.
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
	 * Muestra por consola todos los cursos a los que esta a cargo un profesor.
	 */
	public void mostrarCursos() {
		if(cursos.isEmpty()) {
			System.out.println("La lista de cursos a cargo esta vacia.\n");
		}else {
			System.out.println("..:Cursos a cargo:..");
			for (Curso curso : cursos) {
				System.out.println(curso);
			}
		}
	}
	
	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return String.format("%s, %s es un Profesor", this.getApellido(), this.getNombre());
	}

	
	@Override
	public void guardar() {
		System.out.println(String.format("El profesor %s se ha guardado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void eliminar() {
		System.out.println(String.format("El profesor %s se ha eliminado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void modificar() {
		System.out.println(String.format("El profesor %s se ha modificado correctamente\n", this.getNombreCompleto()));
	}

	/**
	 * Representacion en cadena de un profesor, incluye: nombre, apellido,
	 * documento, edad, fecha de nacimiento, fecha de cargo, sueldo y
	 * cursos a cargo.
	 * 
	 * @return Cadena que representa un profesor.
	 */
	@Override
	public String toString() {
		// Llamo al toString de Empleado y elimino la subcadena "Empleado {"
	    String empleadoString = super.toString().replace("Empleado {", "");
	    return String.format("Profesor {%s, cursos= %s}", empleadoString, cursos);
	}
}
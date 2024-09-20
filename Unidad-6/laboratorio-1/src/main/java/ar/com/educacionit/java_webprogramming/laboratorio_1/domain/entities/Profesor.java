package ar.com.educacionit.java_webprogramming.laboratorio_1.domain.entities;

import java.util.ArrayList;


public class Profesor extends Empleado {
	private ArrayList<Integer> cursos;
	
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
	public Profesor(String nombre, String apellido, Documento documento, String fechaNac,
			String fechaDeCargo, double sueldo) {
		super(nombre, apellido, documento, fechaNac, fechaDeCargo, sueldo);
		this.cursos = new ArrayList<>();
	}
	
	/**
	 * Agrega un curso a un profesor.
	 * 
	 * @param idCurso El ID del curso que se quiere agregar.
	 */
	public void agregarCurso(Integer idCurso) {
		this.cursos.add(idCurso);
	}
	
	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return this.getApellido() + ", " + this.getNombre() + " es un Profesor";
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
		return "Profesor [" + super.toString() + ", cursos=" + cursos + "]";
	}
	
	
}

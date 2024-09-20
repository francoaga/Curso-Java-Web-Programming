package ar.com.educacionit.java_webprogramming.laboratorio_1.domain.entities;

import ar.com.educacionit.java_webprogramming.laboratorio_1.utilities.Validador;

public class Director extends Empleado {
	private String carrera;
	
	/*Constructor por defecto*/
	public Director() {
		super();
	}

	/**
	 * Constructor que permite establece el nombre, apellido, documento, edad,
	 * fecha de nacimiento, fecha de cargo y sueldo de un director.
	 * 
	 * @param nombre Nombre del director.
	 * @param apellido Apellido del director.
	 * @param documento Documento del director.
	 * @param edad Edad del director.
	 * @param fechaNac Fecha de Nacimiento del director.
	 * @param fechaDeCargo Fecha de Cargo del director.
	 * @param sueldo Sueldo del director.
	 * @param carrera Carrera del director.
	 */
	public Director(String nombre, String apellido, Documento documento, String fechaNac, String fechaDeCargo,
			double sueldo, String carrera) {
		super(nombre, apellido, documento, fechaNac, fechaDeCargo, sueldo);
		setCarrera(carrera);
	}

	/**
	 * Representacion en cadena de un director, incluye: nombre, apellido,
	 * documento, edad, fecha de nacimiento, fecha de cargo, sueldo y carrera.
	 * 
	 * @return Cadena que representa un director.
	 */
	@Override
	public String toString() {
		return "Director ["+ super.toString() + ", carrera=" + carrera + "]";
	}

	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return this.getApellido() + ", " + this.getNombre() + " es un Director";
	}
	
	/**
	 * Establece la carrera de un director.
	 * Si la carrera tiene un formato invalido, se lanza una excepcion.
	 * 
	 * @param carrera
	 * @throws IllegalArgumentException Si la carrera es invalida.
	 * @see Validador Para obtener más detalles sobre las validaciones de la carrera.
	 */
	public void setCarrera(String carrera) {
		if(!Validador.validarNombreCursos(carrera))
			throw new IllegalArgumentException("El formato de la carrera no es valida");
		this.carrera = carrera;
	}
}

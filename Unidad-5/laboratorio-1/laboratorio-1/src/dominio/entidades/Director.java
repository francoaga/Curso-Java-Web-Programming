package dominio.entidades;

import utilidades.Validador;

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
	public Director(String nombre, String apellido, Documento documento, int edad, String fechaNac, String fechaDeCargo,
			double sueldo, String carrera) {
		super(nombre, apellido, documento, edad, fechaNac, fechaDeCargo, sueldo);
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
		// Llamo al toString de Empleado y elimino la subcadena "Empleado {"
	    String empleadoString = super.toString().replace("Empleado {", "");
	    return String.format("Director { %s, carrera= %s}", empleadoString, carrera); 
	}

	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return String.format("%s, %s es un Director", this.getApellido(), this.getNombre());
	}
	
	@Override
	public void guardar() {
		System.out.println(String.format("El director %s se ha guardado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void eliminar() {
		System.out.println(String.format("El director %s se ha eliminado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void modificar() {
		System.out.println(String.format("El director %s se ha modificado correctamente\n", this.getNombreCompleto()));
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

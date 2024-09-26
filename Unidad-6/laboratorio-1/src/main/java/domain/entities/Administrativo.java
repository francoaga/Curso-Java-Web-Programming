package domain.entities;

public class Administrativo extends Empleado {
	
	public Administrativo() { 
		super();
	}

	/**
	 * Constructor que permite establece el nombre, apellido, documento, edad,
	 * fecha de nacimiento, fecha de cargo y sueldo de un administrativo.
	 * 
	 * @param nombre Nombre del administrativo.
	 * @param apellido Apellido del administrativo.
	 * @param documento Documento del administrativo.
	 * @param edad Edad del administrativo.
	 * @param fechaNac Fecha de Nacimiento del administrativo.
	 * @param fechaDeCargo Fecha de Cargo del administrativo.
	 * @param sueldo Sueldo del administrativo.
	 */
	public Administrativo(String nombre, String apellido, Documento documento, String fechaNac,
			String fechaDeCargo, double sueldo) {
		super(nombre, apellido, documento, fechaNac, fechaDeCargo, sueldo);
	}

	/**
	 * Representacion en cadena de un admnistrativo, incluye: nombre, apellido,
	 * documento, edad, fecha de nacimiento, fecha de cargo y sueldo.
	 * 
	 * @return Cadena que representa un admnistrativo.
	 */
	@Override
	public String toString() {
		return "Administrativo [" + super.toString() + "]";
	}

	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return this.getApellido() + ", " + this.getNombre() + " es un Administrativo";
	}
}

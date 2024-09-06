package dominio.entidades;

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
	public Administrativo(String nombre, String apellido, Documento documento, int edad, String fechaNac,
			String fechaDeCargo, double sueldo) {
		super(nombre, apellido, documento, edad, fechaNac, fechaDeCargo, sueldo);
	}

	/**
	 * Representacion en cadena de un admnistrativo, incluye: nombre, apellido,
	 * documento, edad, fecha de nacimiento, fecha de cargo y sueldo.
	 * 
	 * @return Cadena que representa un admnistrativo.
	 */
	@Override
	public String toString() {
		// Llamo al toString de Empleado y elimino la subcadena "Empleado {"
	    String empleadoString = super.toString().replace("Empleado {", "");
	    return String.format("Administrativo { %s", empleadoString); 
	}

	/**
     * Obtiene el tipo de persona.
     *
     * @return El tipo de persona.
     */
	@Override
	public String tipoPersona() {
		return String.format("%s, %s es un Administrativo", this.getApellido(), this.getNombre());
	}

	@Override
	public void guardar() {
		System.out.println(String.format("El administrativo %s se ha guardado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void eliminar() {
		System.out.println(String.format("El administrativo %s se ha eliminado correctamente\n", this.getNombreCompleto()));
	}

	@Override
	public void modificar() {
		System.out.println(String.format("El administrativo %s se ha modificado correctamente\n", this.getNombreCompleto()));
	}
}

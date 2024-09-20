package ar.com.educacionit.java_webprogramming.laboratorio_1.domain.entities;

import java.time.LocalDate;

import ar.com.educacionit.java_webprogramming.laboratorio_1.utilities.FechaParser;


public abstract class Empleado extends Persona {
	private LocalDate fechaDeCargo;
	private double sueldo;
	
	/*Constructor por defecto*/
	public Empleado() {
		super();
	}
	
	/**
	 * Constructor que permite establece el nombre, apellido, documento, edad,
	 * fecha de nacimiento, fecha de cargo y sueldo de un empleado.
	 * 
	 * @param nombre Nombre del empleado.
	 * @param apellido Apellido del empleado.
	 * @param documento Documento del empleado.
	 * @param edad Edad del empleado.
	 * @param fechaNac Fecha de Nacimiento del empleado.
	 * @param fechaDeCargo Fecha de Cargo del empleado.
	 * @param sueldo Sueldo del empleado.
	 */
	public Empleado(String nombre, String apellido, Documento documento, String fechaNac,
			String fechaDeCargo, double sueldo) {
		super(nombre, apellido, documento, fechaNac);
		setFechaDeCargo(fechaDeCargo);
		setSueldo(sueldo);
	}
	
	
	/**
	 * Representacion en cadena de un empleado, incluye: nombre, apellido,
	 * documento, edad, fecha de nacimiento, fecha de cargo y sueldo.
	 * 
	 * @return Cadena que representa un empleado.
	 */
	@Override
	public String toString() {
		return "Empleado [" + super.toString() + ", fechaDeCargo=" + fechaDeCargo + ", sueldo=" + sueldo
				+ "]";
	}

	/**
	 * Establece la fecha de cargo de un empleado luego de evaluar
	 * su formato con una regex.
	 * Si la fecha no cumple con el formato de dd/MM/yyyy, se lanza una
	 * excepcion.
	 * 
	 * @param fechaDeCargo Fecha de cargo del empleado.
	 * @throws DateTimeParseException Si la fecha no existe.
	 * @see FecharParser Para obtener mas detalles sobre el parseo de la fecha.
	 */
	public void setFechaDeCargo(String fechaDeCargo) {
		this.fechaDeCargo = FechaParser.parsearFecha(fechaDeCargo);
	}

	/**
	 * Establece el sueldo de un empleado.
	 * Si se ingresa un valor negativo, se lanza una excepcion.
	 * 
	 * @param sueldo El sueldo del empleado.
	 * @throws IllegalArgumentException Si el sueldo es negativo.
	 */
	public void setSueldo(double sueldo) {
		if(sueldo < 0)
			throw new IllegalArgumentException("El sueldo del empleado es negativo");
		this.sueldo = sueldo;
	}
}

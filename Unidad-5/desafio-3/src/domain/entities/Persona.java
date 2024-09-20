package domain.entities;

import java.util.Objects;

import domain.enums.TipoDocumento;
import utilities.Validador;

public class Persona {
	private String nombre;
	private String apellido;
	private int edad;
	private Documento documento;
	
	/*
	 * Constructor simple por defecto.
	 */
	public Persona() {}
	
	/*Constructor que permite establecer el nombre, apellido, edad y documento
	 * de una persona.
	 * 
	 * @param nombre Nombre de la persona.
	 * @param apellido Apellido de la persona.
	 * @param edad Edad de la persona.
	 * @param documento Documento de la persona.
	 */
	public Persona(String nombre, String apellido, int edad, Documento documento) {
		setNombre(nombre);
		setApellido(apellido);
		setEdad(edad);
		setDocumento(documento);
	}
	
	/**
	 * Obtiene el nombre completo de la persona.
	 * 
	 * @return Nombre completo de la persona.
	 */
	public String getNombreCompleto() {
		return String.format("%s %s", this.getNombre(), this.getApellido());
	}
	
	/**
	 * Representacion en cadena de una persona, incluye nombre, apellido,
	 * documento, edad y fecha de nacimiento.
	 * 
	 * @return Cadena que representa una persona.
	 */
	@Override
	public String toString() {
		return String.format("Persona {nombre= %s, apellido= %s, documento= %s, edad= %s, fechaNacimiento= %s}",
				nombre, apellido, documento, edad);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, documento, edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(documento, other.documento)
				&& edad == other.edad && Objects.equals(nombre, other.nombre);
	}

	/**
	 * Obtiene el nombre de una persona.
	 * 
	 * @return Nombre de la persona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de una persona.
	 * Si el formato del nombre no es valida, se lanza una excepcion.
	 * 
	 * @param nombre Nombre de la persona.
	 * @throws IllegalArgumentException Si el formato del nombre no es valida.
	 * @see Validador Para obtener mas detalles de las validaciones sobre el nombre.
	 */
	public void setNombre(String nombre) {
		if(!Validador.validarNombre(nombre))
			throw new IllegalArgumentException("El formato del nombre es invalida");
		
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido de una persona.
	 * 
	 * @return Apellido de la persona.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido de una persona.
	 * Si el formato del apellido es invalida, se lanza una excepcion.
	 * 
	 * @param apellido Apellido de una persona.
	 * @throws IllegalArgumentException Si el formato del apellido no es valida.
	 * @see Validador Para obtener mas detalles de las validaciones sobre el apellido.
	 */
	public void setApellido(String apellido) {
		if(!Validador.validarNombre(apellido))
			throw new IllegalArgumentException("El formato del apellido es invalida.");
		this.apellido = apellido;
	}

	/**
	 * Obtiene la edad de la persona.
	 * 
	 * @return Edad de la persona.
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad de una persona.
	 * Si la edad es invalida se lanza una excepcion.
	 * 
	 * @param edad Edad de la persona.
	 * @throws IllegalArgumentException Si la edad es invalida.
	 */
	public void setEdad(int edad) {
		if(edad < 0)
			throw new IllegalArgumentException("Ingreso una edad invalida");
		this.edad = edad;
	}

	/**
	 * Obtiene el numero de documento de una persona.
	 * @return Numero de documento de una persona.
	 */
	public String getNumeroDocumento() {
		return documento.getNumero();
	}
	
	/**
	 * Obtiene el tipo de documento de una persona.
	 * @return Tipo de documento de una persona.
	 */
	public TipoDocumento getTipoDocumento() {
		return documento.getTipo();
	}

	/**
	 * Establece el documento de una persona.
	 * Si se recibe una referencia nula, se lanza una excepcion.
	 * 
	 * @param documento Documento de una persona.
	 * @throws NullPointerException Si la referencia de documento es nula.
	 */
	public void setDocumento(Documento documento) {
		if(Objects.isNull(documento))
			throw new NullPointerException("Referencia nula en documento");
		this.documento = documento;
	}
}
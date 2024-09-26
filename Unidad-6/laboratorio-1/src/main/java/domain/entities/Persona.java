package domain.entities;

import java.time.LocalDate;
import java.time.Period;

import domain.enums.TipoDocumento;
import utilities.FechaParser;
import utilities.Validador;


public abstract class Persona{
	private static int contador = 0;
	private int id;
	private String nombre;
	private String apellido;
	private Documento documento;
	private LocalDate fechaNacimiento;
	
	/*Constructor por defecto*/
	public Persona() {
		this.id = ++contador;
	}
	
	/**
	 * Constructor que permite establecer el nombre, apellido, documento, edad y fecha de nacimiento
	 * de una persona.
	 * 
	 * @param nombre El nombre de la persona.
	 * @param apellido El apellido de la persona.
	 * @param documento El documento de la persona.
	 * @param edad La edad de la persona.
	 * @param fechaNac Fecha de nacimiento de la persona.
	 */
	public Persona(String nombre, String apellido, Documento documento, String fechaNac) {
		this();
		setNombre(nombre);
		setApellido(apellido);
		setDocumento(documento);
		setFechaNacimiento(fechaNac);
	}
	
	/**
     * Obtiene el tipo de persona (por ejemplo, "Alumno", "Profesor").
     *
     * @return El tipo de persona.
     */
	public abstract String tipoPersona();
	
	/**
	 * Representacion en cadena de una persona, incluye nombre, apellido,
	 * documento, edad y fecha de nacimiento.
	 * 
	 * @return Cadena que representa una persona.
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + 
				", documento=" + documento.getTipo().getDescripcion() +
				", edad=" + getEdad() + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		return result;
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
		return documento.equals(other.documento);
	}

	/**
	 * Establece el documento de una persona.
	 * Si se recibe una referencia nula, se lanza una excepcion IllegalArgumentException.
	 * 
	 * @param documento Documento de una persona.
	 * @throws IllegalArgumentException Si la referencia de documento es nula.
	 */
	public void setDocumento(Documento documento) {
		if(documento == null)
			throw new IllegalArgumentException("Referencia nula para el documento.");
		this.documento = documento;
	}

	/**
	 * Establece el nombre de una persona luego de evuluar su formato.
	 * Si el formato no cumple con los requesitos establecidos en una regex,
	 * se lanza una excepcion IllegalArgumentException.
	 * 
	 * @param nombre El nombre de una persona.
	 * @throws IllegalArgumentException Si el nombre no es valido.
	 * @see Validador Para obtener más detalles sobre las validaciones del nombre.
	 */
	public void setNombre(String nombre) {
		if(!Validador.validarNombre(nombre))
			throw new IllegalArgumentException("El formato del nombre no es valido.");
		
		this.nombre = nombre;
	}

	/**
	 * Establece el apelliod de una persona luego de evaluar su formato.
	 * Si el formato del apellido no cumple con los requisitos definidos en una
	 * regex, se lanza una excepcion IllegalArgumentException.
	 * 
	 * @param apellido El apellido de una persona.
	 * @throws IllegalArgumentException Si el apellido no es valido.
	 * @see Validador Para obtener mas detalles sobre las validaciones del apellido.
	 */
	public void setApellido(String apellido) {
		if(!Validador.validarNombre(apellido))
			throw new IllegalArgumentException("El formato del apellido no es valido.");
		this.apellido = apellido;
	}

	/**
	 * Obtiene la edad de la persona.
	 * 
	 * @return La edad de la persona
	 */
	public int getEdad() {
		LocalDate today = LocalDate.now();
		
		Period periodo = Period.between(fechaNacimiento, today);
		
		return periodo.getYears();
	}

	/**
	 * Establece la fecha de nacimiento de una persona luego de evaluar
	 * su formato con una regex.
	 * Si la fecha no cumple con el formato de dd/MM/yyyy, se lanza una
	 * excepcion.
	 * 
	 * @param fechaNacimiento Fecha de nacimiento de una persona.
	 * @throws DateTimeParseException Si la fecha no existe.
	 * @see FecharParser Para obtener mas detalles sobre el parseo de la fecha.
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = FechaParser.parsearFecha(fechaNacimiento);
	}
	
	/**
	 * Obtiene el numero de documento de una persona.
	 * 
	 * @return El numero de documento.
	 */
	public String getNumeroDocumento() {
		return this.documento.getNumero();
	}
	
	/**
	 * Obtiene el tipo de documento de una persona.
	 * 
	 * @return El tipo de documento.
	 */
	public TipoDocumento getTipoDocumento() {
		return this.documento.getTipo();
	}

	/**
	 * Obtiene el nombre de una persona.
	 * 
	 * @return El nombre de la persona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el apellido de una persona.
	 * 
	 * @return El apellido de la persona
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Obtiene el nombre completo de la persona.
	 * 
	 * @return Nombre completo de la persona.
	 */
	public String getNombreCompleto() {
		return getNombre() + " " + getApellido();
	}
	
	public String getFechaNacimiento() {
		return FechaParser.fechaToString(fechaNacimiento, FechaParser.FECHA_DDMMYYYY);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}

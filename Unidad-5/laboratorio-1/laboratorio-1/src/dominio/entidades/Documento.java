package dominio.entidades;

import java.util.Objects;

import dominio.enums.TipoDocumento;
import utilidades.Validador;

public final class Documento {
	private String numero;
	private TipoDocumento tipo;
	
	/*Consctructor por defecto*/
	public Documento() { }
	
	/**
	 * Constructor que permite establecer el numero y tipo de documento
	 * de una persona.
	 * 
	 * @param numero El numero de documento.
	 * @param tipo El tipo de documento.
	 */
	public Documento(String numero, TipoDocumento tipo) {
		setNumero(numero);
		setTipo(tipo);
	}
	
	/**
	 * Representacion en cadena de un Documento, incluye numero y tipo
	 * de documento.
	 * 
	 * @return Cadena que representa un documento.
	 */
	@Override
	public String toString() {
		return String.format("Documento {numero= %s, tipo= %s}", numero, tipo);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numero, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(numero, other.numero) && tipo == other.tipo;
	}

	/**
	 * Establece el numero de documento luego de evaluar el formato.
	 * Si el formato del numero de documento no es valido, se lanza
	 * una excepcion IllegalArgumentException.
	 * 
	 * @param numero Numero de documento.
	 * @throws IllegalArgumentException Si el numero de documento no es valido.
	 * @see Validador Para obtener mas detalles sobre la validacion realizadas
	 * sobre el numero de documento.
	 */
	public void setNumero(String numero) {
		if(!Validador.validarNumeroDocumento(numero))
			throw new IllegalArgumentException("El formato del numero de documento no es valido");
		this.numero = numero;
	}
	
	/**
	 * Establece el tipo de documento.
	 * Si se recibe una referencia nula, se lanza una excepcion.
	 * 
	 * @param tipo Tipo de documento.
	 * @throws IllegalArgumentException Si el tipo de documento es una
	 * referencia nula.
	 */
	public void setTipo(TipoDocumento tipo) {
		if(tipo == null)
			throw new IllegalArgumentException("El tipo de documento tiene una referencia nula");
		this.tipo = tipo;
	}

	/**
	 * Obtiene el numero de documento.
	 * 
	 * @return Numero de documento.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Obtiene el tipo de documento.
	 * 
	 * @return El tipo de documento.
	 */
	public TipoDocumento getTipo() {
		return tipo;
	}
}
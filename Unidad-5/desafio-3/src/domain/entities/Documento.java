package domain.entities;

import java.util.Objects;

import domain.enums.TipoDocumento;
import utilities.Validador;

public final class Documento {
	private String numero;
	private TipoDocumento tipo;
	
	/*
	 * Constructor simple por defecto.
	 */
	public Documento() {}
	
	/*Constructor que permite establecer el numero y tipo de documento de una
	 * persona.
	 * 
	 * @param numero El numero de documento.
	 * @param tipo El tipo de documento.
	 */
	public Documento(String numero, TipoDocumento tipo) {
		setNumero(numero);
		setTipo(tipo);
	}
	
	/* Representacion en cadena de un documento, incluye numero y tipo
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
	 * Obtiene el numero de documento.
	 * @return Numero de documento
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Establece el numero de documento.
	 * Se valida el formato del numero de documento y en caso
	 * de no ser valido, se lanza una excepcion.
	 * 
	 * @param numero El numero de documento.
	 * @throws IllegalArgumentException Si el formato del numero de documento no es valida.
	 * @see Validador Para obtener mas detalles sobre la logica de validacion de formatos.
	 */
	public void setNumero(String numero) {
		if(!Validador.validarNumeroDocumento(numero))
			throw new IllegalArgumentException("El formato del numero de documento no es valido");
		this.numero = numero;
	}

	/**
	 * Obtiene el tipo de documento
	 * @return Tipo de documento
	 */
	public TipoDocumento getTipo() {
		return tipo;
	}

	/**
	 * Establece el tipo de documento.
	 * Si se recibe una referencia nula, se lanza una excepcion.
	 * 
	 * @param tipo El tipo de Documento
	 * @throws NullPointerException Si la referencia de tipo es nula.
	 */
	public void setTipo(TipoDocumento tipo) {
		if(tipo == null)
			throw new NullPointerException("El tipo de documento tiene una referencia nula");
		this.tipo = tipo;
	}
}


package model;

import java.util.Objects;

public class Documento {
	private String tipo;
	private String numero;
	
	/*Constructor*/
	public Documento(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return String.format("Documento {tipo: %s, numero: %s}", tipo, numero);
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
		return Objects.equals(numero, other.numero) && Objects.equals(tipo, other.tipo);
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
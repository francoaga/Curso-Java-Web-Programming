package model;

import java.util.Objects;

public class Telefono {
	private Integer codigo;
	private String pais;
	
	/*Constructor*/
	public Telefono() {}
	
	/*Constructor*/
	public Telefono(Integer codigo, String pais) {
		this.codigo = codigo;
		this.pais = pais;
	}

	@Override
	public String toString() {
		return String.format("Telefono {codigo: %s, pais: %s}", codigo, pais);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(pais, other.pais);
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

}

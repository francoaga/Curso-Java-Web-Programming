package domain.enums;

import java.util.Objects;

public enum TipoDocumento {
	DNI("Documento Nacional de Identidad"),
	PAS("Pasaporte"),
	CI("Cedula de Identidad"),
	LE("Libreta de Enrolamiento");
	
	private String descripcion;
	
	/*Constructor privado*/
	private TipoDocumento(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la descripcion del tipo de documento.
	 * 
	 * @return Descripcion del tipo de documento.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Obtiene el tipo de documento correspondiente a partir de un número.
	 *
	 * @param num Número para obtener un tipo de documento (0: DNI, 1: LC, 2: LE, 3: CI, 4: PAS).
	 * @return El TipoDocumento correspondiente al número.
	 * @throws IllegalArgumentException Si el número ingresado no es válido o no coincide con ningún tipo de documento.
	 */
	public static TipoDocumento obtenerTipoDocumento(int num) {
		
		if(num < 0) throw new IllegalArgumentException("El numero ingresado es invalido");
		
		TipoDocumento[] tipos = TipoDocumento.values();
		TipoDocumento tipoEncontrado = null;
		int i = 0;
		
		while(i < tipos.length && Objects.isNull(tipoEncontrado)) {
			if(tipos[i].ordinal() == (num - 1))
				tipoEncontrado = tipos[i];
			i++;
		}
		
		if(Objects.isNull(tipoEncontrado)) throw new IllegalArgumentException("El numero ingresado no coincide con ningun tipo de documento");
		
		return tipoEncontrado;
	}
	
	/**
	 * Muestra en consola los tipos de documentos que estan permitidos.
	 */
	public static void mostrarTiposDeDocumento() {
		TipoDocumento[] tipos = TipoDocumento.values();
		int i = 1;
		
		for (TipoDocumento tipo : tipos) {
			System.out.println(String.format("%s. %s", i++, tipo));
		}
	}
}

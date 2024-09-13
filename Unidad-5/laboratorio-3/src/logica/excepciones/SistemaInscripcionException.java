package logica.excepciones;

import java.util.Objects;

public class SistemaInscripcionException extends Exception {
	private static final long serialVersionUID = 4100688312974357436L;
	private ErrorSistemaIncripcion error;
	
	/**
	 * Constructor que permite establecer un codigo a la excepcion para identificarla.
	 * 
	 * @param codigo El codigo de la excepcion producida.
	 */
	public SistemaInscripcionException(int codigo) {
		this.error = new ErrorSistemaIncripcion(codigo);
	}
	
	/**
	 * Constructor que permite establecer un mensaje personalizado para
	 * la excepcion.
	 * 
	 * @param mensaje Mensaje que describe la excepcion.
	 */
	public SistemaInscripcionException(String mensaje) {
		super(mensaje);
	}

	/**
	 * Se obtiene una descripcion de la excepcion.
	 * 
	 * @return Descripcion de la excepcion producida.
	 */
	@Override
	public String getMessage() {
		return (Objects.nonNull(error)) ? error.getDescripcion() : super.getMessage();
	}
}

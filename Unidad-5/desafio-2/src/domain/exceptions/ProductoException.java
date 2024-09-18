package domain.exceptions;

public class ProductoException extends Exception {

	private static final long serialVersionUID = 8238665312155091761L;
	private ErrorProducto error;
	
	/**
	 * Constructor que permite establecer un codigo a la excepcion para identificarla.
	 * 
	 * @param codigo El codigo de la excepcion producida.
	 */
	public ProductoException(int codigo) {
		this.error = new ErrorProducto(codigo);
	}

	/**
	 * Se obtiene una descripcion de la excepcion.
	 * 
	 * @return Descripcion de la excepcion producida.
	 */
	@Override
	public String getMessage() {
		return error.getDescripcion();
	}
}
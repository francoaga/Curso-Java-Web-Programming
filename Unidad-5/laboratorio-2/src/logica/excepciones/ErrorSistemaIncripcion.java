package logica.excepciones;

public final class ErrorSistemaIncripcion {
	private int codigo;
	private String descripcion;
	
	/**
	 * Constructor que establece el codigo del error y a partir de este
	 * setea el mensaje de error al que esta asociado.
	 * 
	 * @param codigo Codigo del error.
	 */
	public ErrorSistemaIncripcion(int codigo) {
		setCodigo(codigo);
		setDescripcion(getMensaje(codigo));
	}
	
	/**
	 * Constructor que permite establecer el codigo y la descripcion.
	 * Utilizado para instanciar errores personalizados.
	 * 
	 * @param codigo Codigo del error.
	 * @param descripcion Descripcion del Error.
	 */
	public ErrorSistemaIncripcion(int codigo, String descripcion) {
		setCodigo(codigo);
		setDescripcion(descripcion);
	}

	/**
	 * Establece el codigo del error.
	 * 
	 * @param codigo El codigo del error.
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Establece la descripcion del error.
	 * @param descripcion La descripcion del error.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtiene la descripcion del error.
	 * 
	 * @return Descripcion del error.
	 */
	protected String getDescripcion() {
		return descripcion;
	}

	/**
	 * Obtiene el mensaje predeterminado que esta asociado al codigo
	 * de error.
	 * 
	 * @param codigo El codigo del error.
	 * @return Mensaje predeterminado del error.
	 */
	private String getMensaje(int codigo) {
		String mensaje = "";
		
		switch(codigo) {
			case 1:
				mensaje = "La persona ya ha sido dada de alta en el sistema";
			break;
			case 2:
				mensaje = "En el sistema no hay personas dadas de alta";
			break;
			default:
				mensaje = "Desconocido, contactar con el administrador";
			break;
		}
		return mensaje;
	}
}
package domain.exceptions;

public class ErrorProducto {
	private int codigo;
	private String descripcion;
	
	/**
	 * @param codigo
	 * @param mensaje
	 */
	public ErrorProducto(int codigo, String mensaje) {
		super();
		setCodigo(codigo);
		setDescripcion(mensaje);
	}
	
	public ErrorProducto(int codigo) {
		super();
		setCodigo(codigo);
		setDescripcion(getMensaje(codigo));
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private static String getMensaje(int codigo) {
		String mensaje ="";
		switch(codigo) {
			case 1:
				mensaje = "Producto No Disponible";
			break;
			case 2:
				mensaje = "Producto Inexistente";
			break;
			default:
				mensaje= "Desconocido contactar con el administrador";
		}
		
		return mensaje;
	}
}
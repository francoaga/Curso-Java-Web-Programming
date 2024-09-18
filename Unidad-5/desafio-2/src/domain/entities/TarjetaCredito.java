package domain.entities;

import utilities.Formatos;

public class TarjetaCredito extends Producto {
	private Integer claveSeguridad;
	
	/*Constructor por defecto*/
	public TarjetaCredito() {}

	/**
	 * Constructor que permite establecer el banco, sucursal y clave de seguridad
	 * de una tarjeta de credito.
	 * 
	 * @param banco El numero de banco.
	 * @param sucursal El numero de sucursal.
	 * @param claveSeguridad La clave de seguridad de la tarjeta de credito.
	 */
	public TarjetaCredito(Integer banco, Integer sucursal, Integer claveSeguridad) {
		super(banco, sucursal);
		setClaveSeguridad(claveSeguridad);
		generarNumeroProducto();
	}
	
	/**
	 * Representacion en cadena de una tarjeta de credito.
	 * 
	 * @return Cadena que representa una tarjeta de credito.
	 */
	@Override
	public String toString() {
		return String.format("Cuenta {banco: %s, sucursal: %s, numero: %s, claveSeguridad: %s}", 
				Formatos.getFormato(getBanco(), "Banco"),
				Formatos.getFormato(getSucursal(), "Sucursal"),
				Formatos.getFormato(getNumero(), "TC"),
				Formatos.getFormato(claveSeguridad, "CS"));
	}
	
	/**
	 * Genera el numero de producto para la tarjeta de credito a partir de la clase {@link NumeroProductoGenerador}.
	 */
	@Override
	public void generarNumeroProducto() {
		setNumero(NumeroProductoGenerador.generarNumeroTC());
	}
	
	/**
	 * Establece la clave de seguridad de una tarjeta de credito.
	 * Si se ingresa un valor invalido, se lanza una excepcion.
	 * 
	 * @param claveSeguridad La clave de seguridad de la tarjeta de credito.
	 * @throws IllegalArgumentException Si el formato de clave es invalida.
	 */
	public void setClaveSeguridad(Integer claveSeguridad) {
		if(claveSeguridad.intValue() < 0)
			throw new IllegalArgumentException("Ha ingresado un valor invalido para la clave de seguridad");
		
		this.claveSeguridad = claveSeguridad;
	}
}

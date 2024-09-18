package domain.entities;

import java.util.Objects;

import domain.enums.TipoCuenta;
import domain.exceptions.ProductoException;
import utilities.Formatos;

public class Cuenta extends Producto {
private TipoCuenta tipo;
	
	/*Constructor por defecto*/
	public Cuenta() { }

	/**
	 * Constructor que permite establecer el banco, sucursal y el tipo de una cuenta.
	 * 
	 * @param banco El numero del banco.
	 * @param sucursal El numero de sucursal.
	 * @param tipo El tipo de cuenta.
	 * @throws ProductoException 
	 */
	public Cuenta(Integer banco, Integer sucursal, TipoCuenta tipo) throws ProductoException {
		super(banco, sucursal);
		setTipo(tipo);
		generarNumeroProducto();
	}
	
	
	/**
	 * Representacion en cadena de una cuenta.
	 * 
	 * @return Cadena que representa una cuenta.
	 */
	@Override
	public String toString() {
		return String.format("Cuenta {banco: %s, sucursal: %s, numero: %s, tipo: %s}", 
				Formatos.getFormato(getBanco(), "Banco"),
				Formatos.getFormato(getSucursal(), "Sucursal"),
				Formatos.getFormato(getNumero(), tipo.toString()),
				TipoCuenta.getDescripcion(tipo));
	}

	/**
	 * Genera el numero de producto para una cuenta a partir de la logica de la clase {@link NumeroProductoGenerador}.
	 */
	@Override
	public void generarNumeroProducto() {
		if(tipo.equals(TipoCuenta.CA)) {
			setNumero(NumeroProductoGenerador.generarNumeroCA());			
		}else if(tipo.equals(TipoCuenta.CC)) {
			setNumero(NumeroProductoGenerador.generarNumeroCC());
		}
	}

	/**
	 * Establece el tipo de cuenta.
	 * Si se ingresa una referencia nula, se lanza una excepcion.
	 * 
	 * @param tipo El tipo de cuenta.
	 * @throws ProductoException 
	 * @throws NullPointerException Si el tipo tiene una referencia nula.
	 */
	public void setTipo(TipoCuenta tipo) throws ProductoException {
		if(!TipoCuenta.isHabilitado(tipo))
			throw new ProductoException(1);
			
		if(Objects.isNull(tipo))
			throw new NullPointerException("Ha ingresado una referencia nula en el tipo de cuenta");
		
		this.tipo = tipo;
	}

}

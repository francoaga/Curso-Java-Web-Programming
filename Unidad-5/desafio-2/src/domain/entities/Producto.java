package domain.entities;

public abstract class Producto {
	private Integer numero;
	private Integer banco;
	private Integer sucursal;
	
	/*Constructor simple por defecto*/
	public Producto() { }

	/**
	 * Constructor que permite establecer el banco y sucursal de un Producto bancario.
	 * 
	 * @param banco El numero de banco.
	 * @param sucursal El numero de sucursal.
	 */
	public Producto(Integer banco, Integer sucursal) {
		super();
		this.banco = banco;
		this.sucursal = sucursal;
	}
	
	public abstract void generarNumeroProducto();
	
	/**
	 * Representacion en cadena de un producto, incluye: numero, banco y sucursal.
	 * 
	 * @return Cadena que representa un producto.
	 */
	@Override
	public String toString() {
		return String.format("Producto {numero: %s, banco: %s, sucursal: %s}", numero, banco, sucursal);
	}

	/**
	 * Obtiene el numero de banco a la que esta asociado el producto.
	 * 
	 * @return El numero de banco.
	 */
	public Integer getBanco() {
		return banco;
	}

	/**
	 * Establece el numero de banco al que va estar asociado el producto.
	 * Si se ingresa un valor invalido, se lanza una excepcion.
	 * 
	 * @param banco El numero de banco.
	 * @throws IllegalArgumentException Si el numero de banco es invalido.
	 */
	public void setBanco(Integer banco) {
		if(banco.intValue() < 0)
			throw new IllegalArgumentException("Ha ingresado un valor invalido para el banco");
		
		this.banco = banco;
	}

	/**
	 * Obtiene el numero de sucursal a la que esta asociado el producto.
	 * 
	 * @return El numero de sucursal.
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece el numero de sucursal al que va estar asociado el producto.
	 * Si se ingresa un valor invalido, se lanza una excepcion.
	 * 
	 * @param sucursal El numero de sucursal.
	 * @throws IllegalArgumentException Si el numero de sucursal es invalido.
	 */
	public void setSucursal(Integer sucursal) {
		if(sucursal.intValue() < 0)
			throw new IllegalArgumentException("Ha ingresado un valor invalido para la sucursal");
		
		this.sucursal = sucursal;
	}

	/**
	 * Establece el numero del producto.
	 * 
	 * @param numero El numero de producto.
	 */
	protected void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * Obtiene el numero del producto.
	 * 
	 * @return El numero del producto
	 */
	public Integer getNumero() {
		return numero;
	}
}
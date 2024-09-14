package domain.enums;

import java.util.Objects;

public enum TipoCuenta {
	CA(true, "Caja de Ahorro"),
	CC(true, "Cuenta Corriente"),
	FCI(false, "Fondo Comercio de Inversion"),
	PF(false, "Plazo Fijo");
	
	
	private boolean habilitado;
	private String descripcion;
	
	private TipoCuenta(boolean habilitado, String descripcion) {
		this.habilitado = habilitado;
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtiene el tipo de cuenta a partir de un numero.
	 * 
	 * @param num Numero para obtener un tipo de cuenta.
	 * @return El TipoCuenta correspondiente al número.
	 * @throws IllegalArgumentException Si el numero ingresado no coincide con ningun tipo de cuenta.
	 */
	public static TipoCuenta obtenerTipoCuenta(int num) {
		
		if(num < 0) throw new IllegalArgumentException("El numero ingresado no coincide con ningun tipo de cuenta");
		
		TipoCuenta[] tipos = TipoCuenta.values();
		TipoCuenta tEncontrado = null;
		int i = 0;
		
		while(i < tipos.length && Objects.isNull(tEncontrado)) {
			if(tipos[i].ordinal() == (num - 1)) 
				tEncontrado = tipos[i];
			i++;
		}
		
		if(Objects.isNull(tEncontrado))
			throw new IllegalArgumentException("El numero ingresado no coincide con ningun tipo de cuenta");
		
		return tEncontrado;
	}
	
	/**
	 * Muestra por consola los tipos de cuenta que estan permitidos.
	 */
	public static void mostratTiposDeCuenta() {
		TipoCuenta[] tipos = TipoCuenta.values();
		
		for (int i = 0; i < tipos.length; i++) {
			System.out.println(String.format("%s. %s", i+1, tipos[i].descripcion));
		}
	}
	
	/**
	 * Obtiene si la cuenta esta habilitada.
	 * 
	 * @param tipo El tipo de cuenta.
	 * @return true si la cuenta esta habilitada, false en caso contrario.
	 */
	public static boolean isHabilitado(TipoCuenta tipo) {
		return tipo.habilitado;
	}
	
	/**
	 * Obtiene una descripcion del tipo de cuenta
	 * 
	 * @param tipo El tipo de cuenta.
	 * @return Descripcion del tipo de cuenta.
	 */
	public static  String getDescripcion(TipoCuenta tipo) {
		return tipo.descripcion;
	}
}
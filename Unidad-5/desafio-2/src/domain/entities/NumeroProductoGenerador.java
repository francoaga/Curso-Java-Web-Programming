package domain.entities;

import java.util.concurrent.atomic.AtomicInteger;

public final class NumeroProductoGenerador {
	private static AtomicInteger numeroCC = new AtomicInteger(1);
	private static AtomicInteger numeroCA = new AtomicInteger(1);
	private static AtomicInteger numeroTC = new AtomicInteger(1);
	
	/*Constructor privado*/
	private NumeroProductoGenerador() { }
	
	/**
	 * Genera y devuelve el numero de producto para una Cuenta Corriente (CC).
	 *
	 * @return Un numero de producto unico para la Cuenta Corriente.
	 */
	public static int generarNumeroCC() {
		return numeroCC.getAndIncrement();
	}
	
	/**
	 * Genera y devuelve el numero de producto para una Caja de Ahorro (CA).
	 * 
	 * @return Un numero de producto unico para la Caja de Ahorro.
	 */
	public static int generarNumeroCA() {
		return numeroCA.getAndIncrement();
	}
	
	/**
	 * Genera y devuelve el numero de producto para una Tarjeta de Credito (TC).
	 * 
	 * @return Un numero de producto unico para la Tarjeta de Credito.
	 */
	public static int generarNumeroTC() {
		return numeroTC.getAndIncrement();
	}
}

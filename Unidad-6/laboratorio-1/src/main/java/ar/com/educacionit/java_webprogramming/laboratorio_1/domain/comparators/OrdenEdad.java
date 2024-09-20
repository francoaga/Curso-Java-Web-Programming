package ar.com.educacionit.java_webprogramming.laboratorio_1.domain.comparators;

import java.util.Comparator;

import ar.com.educacionit.java_webprogramming.laboratorio_1.domain.entities.Persona;

public class OrdenEdad implements Comparator<Persona> {

	private boolean orden;
	
	/**
	 * Constructor que permite establecer el tipo de orden a realizar
	 * sobre las edades de las personas.
	 * 
	 * @param orden true para orden ascendente, false para orden descendente.
	 */
	public OrdenEdad(boolean orden) {
		this.orden = orden;
	}
	
	@Override
	public int compare(Persona o1, Persona o2) {
		int edadPersona1 = o1.getEdad();
		int edadPersona2 = o2.getEdad();
		
		 // Multiplicamos por 1 o -1 según el tipo de orden deseado.
		return tipoDeOrden() * (edadPersona1 - edadPersona2);
	}
	
	/**
	 * Determina si el orden es creciente (ascedente es true) o 
	 * decreciente (ascendente es false).
	 * 
	 * @return El tipo de orden, 1 para ascendente, -1 para descendente.
	 */
	private int tipoDeOrden() {
		return (orden) ? 1 : -1;
	}

}

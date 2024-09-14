package logic.comparators;

import java.util.Comparator;

import domain.entities.Producto;

public class OrdenProducto implements Comparator<Producto> {

	@Override
	public int compare(Producto o1, Producto o2) {
		int comparacionBanco = o1.getBanco() - o2.getBanco();
		int comparacionSucursal = Integer.MIN_VALUE;
		
		if(comparacionBanco == 0) {
			comparacionSucursal = o1.getSucursal() - o2.getSucursal();
			
			if(comparacionSucursal == 0) {
				return o1.getNumero() - o2.getNumero(); //Comparacion de Numeros
			}
			
			return comparacionSucursal;
		}
		return comparacionBanco;
	}
}

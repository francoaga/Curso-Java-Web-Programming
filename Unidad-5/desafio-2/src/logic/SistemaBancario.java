package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import domain.entities.Producto;
import logic.comparators.OrdenProducto;

public class SistemaBancario {
	private List<Producto> productos;
	
	/*Constructor*/
	public SistemaBancario() {
		this.productos = new ArrayList<>();
	}
	
	/**
	 * Agrega el producto de un cliente al sistema bancario.
	 * Si se ingresa una referencia nula en el producto, se lanza una excepcion.
	 * 
	 * @param p El producto a agregar.
	 * @throws NullPointerException Si el producto tiene una referencia nula.
	 */
	public void agregarProducto(Producto p) {
		if(Objects.isNull(p))
			throw new NullPointerException("Ha ingresado una referencia nula para el producto");
		this.productos.add(p);
	}
	
	/**
	 * Muestra por consola los productos que estan dados de alta en el sistema bancario.
	 * 
	 * @throws IllegalArgumentException Si no hay productos en el sistema.
	 */
	public void mostrarProductos() {
		if(productos.isEmpty()) {
			throw new IllegalArgumentException("No se han dado de alta productos al sistema");
		}else {
			System.out.println("\t..:PRODUCTOS DADOS DE ALTA:...");
			List<Producto> pOrdenados = ordenarProductos();
			for (Producto p : pOrdenados) {
				System.out.println(p);
			}
			System.out.println();
		}
	}
	
	private List<Producto> ordenarProductos() {
		return productos.stream().sorted(new OrdenProducto()).collect(Collectors.toList());
	}
}
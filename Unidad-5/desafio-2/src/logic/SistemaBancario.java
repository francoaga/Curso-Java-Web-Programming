package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import domain.entities.Cliente;
import domain.entities.Documento;
import domain.entities.Producto;
import logic.comparators.OrdenDocumento;

public class SistemaBancario {
	private Map<Documento, Cliente> clientes;
	
	/*Constructor*/
	public SistemaBancario() {
		this.clientes = new HashMap<>();
	}
	
	/**
	 * Agrega un nuevo producto a un cliente dado de alta.
	 * Si se ingresa una referencia nula en el producto, se lanza una excepcion.
	 * 
	 * @param d El documento del cliente a buscar.
	 * @param p El producto a agregar.
	 * @throws NullPointerException Si el producto y/o el cliente tiene una referencia nula.
	 */
	public void agregarProducto(Documento d, Producto p) {
		if(Objects.isNull(p) || Objects.isNull(d))
			throw new IllegalArgumentException("Ha ingresado una referencia nula para el producto y/o documento");
	
		Cliente cEncontrado = clientes.get(d);
		
		if(Objects.isNull(cEncontrado))
			throw new IllegalArgumentException("No hay un cliente dado de alta con el documento ingresado");
		
		cEncontrado.agregarProducto(p);
	}
	
	/**
	 * Da de alta un cliente en el sistema bancario.
	 * Si se ingresa una referencia nula en el cliente, se lanza una excepcion.
	 * 
	 * @param c El cliente a agregar.
	 * @throws NullPointerException Si el cliente tiene una referencia nula.
	 */
	public void agregarCliente(Cliente c) {
		if(Objects.isNull(c)) {
			throw new NullPointerException("Ha ingresado una referencia nula para el cliente");
		} else if(existeCliente(c.getDocumento())) {
			throw new IllegalArgumentException("El cliente ya esta dado de alta en el sistema");
		}
		
		this.clientes.put(c.getDocumento(), c);
	}
	
	/**
	 * Muestra por consola los clientes que estan dados de alta en el sistema bancario.
	 * 
	 * @throws IllegalArgumentException Si no hay clientes en el sistema.
	 */
	public void mostrarClientes() {
		if(clientes.isEmpty()) {
			throw new IllegalArgumentException("No se han dado de alta clientes en el sistema");
		}else {
			System.out.println("\t..:CLIENTES DADOS DE ALTA:...");
			List<Cliente> clientesOrdenados = ordenarClientes();
			for (Cliente c : clientesOrdenados) {
				System.out.println(c);
			}
			System.out.println();
		}
	}
	
	/**
	 * Muestra por consola los productos que estan dados de alta en el sistema bancario.
	 * 
	 * @throws IllegalArgumentException Si no hay productos en el sistema.
	 */
	public void mostrarProductos(Documento d) {
		if(Objects.isNull(d)) {
			throw new IllegalArgumentException("Se recibio una referencia nula en el documento");
		}else if(!existeCliente(d)) {
			throw new IllegalArgumentException("El cliente no esta dado de alta en el sistema");
		} else {
			System.out.println("\t...:PRODUCTOS DADOS DE ALTA :...");
			/*List<Producto> pOrdenados = ordenarProductos();
			for (Producto p : pOrdenados) {
				System.out.println(p);
			}*/
			
			this.clientes.get(d).mostrarProductos();
		}
	}
	
	/*private List<Producto> ordenarProductos() {
		return productos.stream().sorted(new OrdenProducto()).collect(Collectors.toList());
	}*/
	
	public boolean existeCliente(Documento d) {
		return this.clientes.containsKey(d);
	}
	
	private List<Cliente> ordenarClientes() {
		List<Documento> documentosOrdenados = clientes.keySet().stream().sorted(new OrdenDocumento()).collect(Collectors.toList());
		
		List<Cliente> clientesOrdenados = new ArrayList<>();
		
		documentosOrdenados.forEach((documento) -> {
			clientesOrdenados.add(this.clientes.get(documento));
		});
		
		return clientesOrdenados;
	}

	public Cliente buscarCliente(Documento documento) {
		if(!existeCliente(documento)) return null;
		
		return this.clientes.get(documento);
	}
}
package domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import utilities.FechaParser;
import utilities.Validador;

public class Cliente {
	private String nombre;
	private Documento documento;
	private LocalDate fechaNacimiento;
	private List<Producto> productos;
	
	
	public Cliente() {	}
	
	public Cliente(String nombre, Documento documento, String fechaNacimiento) {
		setNombre(nombre);
		setDocumento(documento);
		setFechaNacimiento(fechaNacimiento);
		this.productos = new ArrayList<>();
	}

	/**
	 * Establece el nombre de un cliente.
	 * Si el formato del nombre no es valido, se lanza una excepcion 
	 * IllegalArgumentException.
	 * 
	 * @param nombre El nombre de un cliente.
	 * @throws IllegalArgumentException Si el nombre no es valido.
	 * @see Validador Para obtener más detalles sobre las validaciones del nombre.
	 */
	public void setNombre(String nombre) {
		if(!Validador.validarNombre(nombre))
			throw new IllegalArgumentException("El formato del nombre no es valido.");
		
		this.nombre = nombre;
	}
	
	/**
	 * Establece la fecha de nacimiento de un cliente.
	 * Si la fecha no cumple con el formato de dd/MM/yyyy, se lanza una
	 * excepcion.
	 * 
	 * @param fechaNacimiento Fecha de nacimiento de un cliente.
	 * @throws DateTimeParseException Si la fecha no existe.
	 * @see FecharParser Para obtener mas detalles sobre el parseo de la fecha.
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = FechaParser.parsearFecha(fechaNacimiento);
	}


	/**
	 * Establece el documento de un cliente.
	 * Si se recibe una referencia nula, se lanza una excepcion IllegalArgumentException.
	 * 
	 * @param documento Documento de un cliente.
	 * @throws IllegalArgumentException Si la referencia de documento es nula.
	 */
	public void setDocumento(Documento documento) {
		if(documento == null)
			throw new IllegalArgumentException("Referencia nula para el documento.");
		this.documento = documento;
	}
	
	public Documento getDocumento() {
		return this.documento;
	}
	
	/**
	 * Agrega un nuevo productos al cliente.
	 * 
	 * @param productoNuevo Nuevo producto que adquiere el cliente.
	 * @throws IllegalArgumentException Si la referencia del producto es nula.
	 */
	public void agregarProducto(Producto productoNuevo) {
		if(Objects.isNull(productoNuevo))
			throw new IllegalArgumentException("Se ha recibido una referencia nula para el producto");
		this.productos.add(productoNuevo);
	}
	
	/**
	 * Muestra los productos de un cliente por consola.
	 * 
	 * @param documento Documento de un cliente.
	 * @throws IllegalArgumentException Si la referencia de documento es nula.
	 */
	public void mostrarProductos() {
		if(productos.isEmpty()) {
			System.out.println("ERROR: El cliente no posee productos");
		} else {
			System.out.println("\t\n....:PRODUCTOS ADQUIRIDOS:....");
			productos.forEach(System.out::println);
		}
	}
	
	/**
	 * Representacion en cadena de un Cliente, incluye documento y fecha de nacimiento.
	 * 
	 * @return Cadena que representa un Cliente.
	 */
	@Override
	public String toString() {
		return String.format("Cliente {nombre: %s, numero documento= %s, tipo documento= %s, fecha nacimiento: %s}",
				nombre, documento.getNumero(), documento.getTipo(), fechaNacimiento.toString());
	}
}

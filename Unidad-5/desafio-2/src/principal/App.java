package principal;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import domain.entities.*;
import domain.enums.TipoCuenta;
import domain.enums.TipoDocumento;
import domain.exceptions.ProductoException;
import logic.SistemaBancario;

public class App {

	private static final int SALIR = 5;

	public static void main(String[] args) {
		SistemaBancario sb = new SistemaBancario();
		Scanner sc = new Scanner(System.in);
		
		loadAplicacion(sb, sc);
		sc.close();
	}
	
	private static void loadAplicacion(SistemaBancario sb, Scanner input) {
		boolean seguir = true;
		int opcion;
		
		while(seguir) {
			menu();
			try {
				opcion = input.nextInt();
				opcionesMenu(sb, input, opcion);
				
				if(opcion == SALIR) seguir= false;
			}catch(InputMismatchException ime) {
				System.out.println("ERROR: No ha ingresado un valor numerico\n");
				limpiarBuffer(input);
			}catch(Exception ex) {
				System.out.println(String.format("ERROR: %s", ex.getMessage()));
			}
		}
	}
	
	private static void menu() {
		System.out.println("\t...:MENU:...");
		System.out.println("1. Agregar Cliente");
		System.out.println("2. Agregar producto a un cliente");
		System.out.println("3. Mostrar productos de un cliente");
		System.out.println("4. Mostrar clientes");
		System.out.println("5. Salir");
		System.out.print("Ingrese opcion: ");
	}
	
	private static void opcionesMenu(SistemaBancario sb, Scanner input, int opcion) {
		limpiarBuffer(input);
		
		switch(opcion) {
			case 1:
				agregarCliente(sb, input);
			break;
			case 2:
				agregarProducto(sb, input);
			break;
			case 3:
				mostrarProductosCliente(sb, input);
			break;
			case 4:
				mostrarClientes(sb);
			break;
			case 5:
				System.out.println("Cierre de la aplicacion");
			break;
			default:
				System.out.println("ERROR: Ha ingresado una opcion invalida, intente nuevamente\n");
		}
	}
	
	private static void mostrarClientes(SistemaBancario sb) {
	    sb.mostrarClientes();
	}

	private static void mostrarProductosCliente(SistemaBancario sb, Scanner input) {
		System.out.println("...:PRODUCTOS DE UN CLIENTE:...");
	    Documento documento = new Documento();
		cargarDocumentacion(documento, input);
		
		 // Verificar si el cliente existe
	    Cliente cliente = sb.buscarCliente(documento);
	    if(Objects.isNull(cliente)) {
	        System.out.println("El cliente no existe.");
	        return;
	    }
	    
	    cliente.mostrarProductos();	
	}

	/*private static void agregarProductoCliente(SistemaBancario sb, Scanner input) {
	    System.out.print("Ingrese el número de documento del cliente: ");
	    Documento documento = new Documento();
		cargarDocumentacion(documento, input);
	    
	    // Verificar si el cliente existe
	    Cliente cliente = sb.buscarCliente(documento);
	    if(Objects.isNull(cliente)) {
	        System.out.println("El cliente no existe.");
	        return;
	    }
	    
	    // Mostrar y seleccionar el producto para el cliente
        mostrarProductosPosibles();
        int opcion = input.nextInt();
        limpiarBuffer(input);
	    
	    // Lógica de agregar producto al cliente
	    Producto producto = crearProducto(opcion);
	    cliente.agregarProducto(producto);
	    System.out.println("Producto agregado exitosamente al cliente.");
	}*/

	private static void agregarCliente(SistemaBancario sb, Scanner input) {
	    System.out.println("\n\t...:CARGA DE CLIENTES:...\n");

	    boolean seguir = true;
	    boolean flag = false;
	    int opcion;

	    while (seguir) {
	        try {
	        	// Cargar datos del cliente
	        	Cliente clienteNuevo = cargarDatosCliente(input);
	        	sb.agregarCliente(clienteNuevo);

	        	// Mostrar y seleccionar el producto para el cliente
	            mostrarProductosPosibles();
	            opcion = input.nextInt();
	            limpiarBuffer(input);

	            if (!validarTipoDeProducto(opcion)) {
	                throw new ProductoException(2);
	            }

	            // Crear y cargar datos del producto seleccionado
	            Producto pNuevo = crearProducto(opcion);
	            cargarDatosProducto(pNuevo, opcion, input);

	            // Asignar producto al cliente
	            clienteNuevo.agregarProducto(pNuevo);

	            seguir = false;
	        } catch (InputMismatchException ime) {
	            System.out.println("ERROR: No ha ingresado un valor numerico");
	            flag = true;
	        } catch (Exception ex) {
	            System.out.println(String.format("ERROR: %s", ex.getMessage()));
	        } finally {
	            if (flag) limpiarBuffer(input);
	            flag = false;
	        }
	    }

	    System.out.println("\nSe ha cargado el cliente y su producto al sistema.\n");
	}

	// Método auxiliar para cargar los datos del cliente
	private static Cliente cargarDatosCliente(Scanner input) {
	    System.out.println("__Ingrese los datos del cliente__");
	    System.out.print("Nombre: ");
	    String nombre = input.nextLine();

		Documento documento = new Documento();
		cargarDocumentacion(documento, input);
		
		System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
		String fechaNacimiento= input.next();
		
		return new Cliente(nombre, documento, fechaNacimiento);
	}
	
	private static void cargarDocumentacion(Documento documento, Scanner input) {
		mostrarDocumentosPermitidos();
		documento.setTipo(TipoDocumento.obtenerTipoDocumento(input.nextInt()));
		
		limpiarBuffer(input);
		
		System.out.print("Numero de documento: ");
		documento.setNumero(input.nextLine());
	}


	private static void mostrarDocumentosPermitidos() {
		System.out.println("\t:Documentos Permitidos:");
		TipoDocumento.mostrarTiposDeDocumento();
		
		System.out.print("Ingrese tipo: ");
	}
	
	private static void agregarProducto(SistemaBancario sb, Scanner input) {
		System.out.println("\n\t...:CARGA DE PRODUCTOS:...\n");
		
		boolean seguir = true;
		boolean flag= false;
		int opcion;
		
		while(seguir) {
			try {
			    Documento documento = new Documento();
				cargarDocumentacion(documento, input);
			    			    
				mostrarProductosPosibles();
				opcion = input.nextInt();
				limpiarBuffer(input);
				
				if(!validarTipoDeProducto(opcion))
					throw new ProductoException(2);
				
				Producto pNuevo = crearProducto(opcion);
				cargarDatosProducto(pNuevo, opcion, input);
				
				sb.agregarProducto(documento, pNuevo);
				seguir = false;
			}catch(InputMismatchException ime) {
				System.out.println("ERROR: No ha ingresado un valor numerico\n");
				flag= true;
			}
			catch(Exception ex) {
				System.out.println(String.format("ERROR: %s", ex.getMessage()));
			}finally {
				if(flag) limpiarBuffer(input);
				flag= false;
			}
		}
		System.out.println("\nSe ha cargado correctamente el producto al cliente.\n");
	}
	
	private static boolean validarTipoDeProducto(int opcion) {
		return opcion >= 1 && opcion <=5;
	}

	private static Producto crearProducto(int opcion) {
		Producto pNuevo= null;
		switch(opcion) {
			case 1:
			case 2:
			case 3:
			case 4:
				pNuevo = new Cuenta();
			break;
			case 5:
				pNuevo = new TarjetaCredito();
			break;
		}
		return pNuevo;
	}

	private static void mostrarProductosPosibles() {
		System.out.println("--TIPOS DE PRODUCTOS--");
		TipoCuenta.mostratTiposDeCuenta();
		System.out.println("5. Tarjeta de Credito");
		System.out.print("Ingrese opcion: ");
	}

	private static void cargarDatosProducto(Producto p, int tipoProducto, Scanner input) throws ProductoException {
		if(tipoProducto != 5) {
			((Cuenta)p).setTipo(TipoCuenta.obtenerTipoCuenta(tipoProducto));
		}
		
		System.out.println("\n--CARGA DE DATOS--");
		System.out.print("Banco: ");
		p.setBanco(input.nextInt());
		System.out.print("Sucursal: ");
		p.setSucursal(input.nextInt());
		
		if(tipoProducto == 5) {
			System.out.print("Clave de seguridad: ");
			((TarjetaCredito)p).setClaveSeguridad(input.nextInt());
		}
		
		p.generarNumeroProducto();
	}

	private static void limpiarBuffer(Scanner input) {
		input.nextLine();
	}
}

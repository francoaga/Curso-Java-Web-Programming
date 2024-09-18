package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

import domain.entities.*;
import domain.enums.TipoCuenta;
import domain.exceptions.ProductoException;
import logic.SistemaBancario;

public class App {

	private static final int SALIR = 3;

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
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}
	
	private static void menu() {
		System.out.println("\t...:MENU:...");
		System.out.println("1. Agregar producto");
		System.out.println("2. Mostrar productos");
		System.out.println("3. Salir");
		System.out.print("Ingrese opcion: ");
	}
	
	private static void opcionesMenu(SistemaBancario sb, Scanner input, int opcion) {
		limpiarBuffer(input);
		
		switch(opcion) {
			case 1:
				agregarProducto(sb, input);
			break;
			case 2:
				mostrarProductos(sb);
			break;
			case 3:
				System.out.println("Cierre de la aplicacion");
			break;
			default:
				System.out.println("ERROR: Ha ingresado una opcion invalida, intente nuevamente\n");
		}
	}
	
	private static void mostrarProductos(SistemaBancario sb) {
		try {
			sb.mostrarProductos();				
		}catch(Exception ex) {
			System.out.println("ERROR: " + ex.getMessage() + "\n");
		}
	}

	private static void agregarProducto(SistemaBancario sb, Scanner input) {
		System.out.println("\n\t...:CARGA DE PRODUCTOS:...\n");
		
		boolean seguir = true;
		boolean flag= false;
		int opcion;
		
		while(seguir) {
			try {
				mostrarProductosPosibles();
				opcion = input.nextInt();
				limpiarBuffer(input);
				
				if(!validarTipoDeProducto(opcion))
					throw new ProductoException(2);
				
				Producto pNuevo = crearProducto(opcion);
				
				cargarDatosProducto(pNuevo, opcion, input);
				sb.agregarProducto(pNuevo);
				seguir = false;
			}catch(InputMismatchException ime) {
				System.out.println("ERROR: No ha ingresado un valor numerico\n");
				flag= true;
			}
			catch(Exception ex) {
				System.out.println("ERROR: " + ex.getMessage() + "\n");
			}finally {
				if(flag) limpiarBuffer(input);
				flag= false;
			}
		}
		System.out.println("\nSe ha cargado el producto al sistema.\n");
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

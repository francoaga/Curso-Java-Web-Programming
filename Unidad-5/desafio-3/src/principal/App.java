package principal;

import java.util.Scanner;

import domain.entities.Documento;
import domain.entities.Persona;
import domain.entities.Turno;
import domain.enums.TipoDocumento;
import logic.SistemaTurnos;

public class App {
	
	public static final int SALIR = 3;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SistemaTurnos sistemaTurnos = new SistemaTurnos();
		
		loadAplicacion(sistemaTurnos, input);
	}
	
	private static void loadAplicacion(SistemaTurnos sistemaTurnos, Scanner input) {
		boolean seguir= true;
		
		int opcion = 0;
		
		while(seguir) {
			menu();
			
			try {
				opcion = input.nextInt();
				opcionesMenu(opcion, input, sistemaTurnos);
				
				if(opcion == SALIR) seguir= false;
			}catch(Exception ex) {
				System.out.println(ex);
				limpiarBuffer(input);
			}
		}
	}
	
	private static void menu() {
		System.out.println("\n\t\t..:MENU:..");
		System.out.println("1. Agregar Turno");
		System.out.println("2. Tablero De Turnos");
		System.out.println("3. Salir");
		System.out.print("Ingrese opcion: ");
	}
	
	private static void opcionesMenu(int opcion, Scanner input, SistemaTurnos sistemaTurnos) {
		limpiarBuffer(input);
		
		switch(opcion) {
			case 1:
				agregarTurno(sistemaTurnos, input);
			break;
			case 2:
				mostrarTablero(sistemaTurnos);
			break;
			case 3:
				System.out.println("Cierre de la aplicacion");
			break;
			default:
				System.out.println("ERROR: Ha ingresado una opcion invalida, intente nuevamente");
		}
	}

	private static void agregarTurno(SistemaTurnos sistemaTurnos, Scanner input) {
		System.out.println("\n...:DATOS DEL NUEVO TURNO:...");
		Persona paciente = new Persona();
		boolean seguir = true;
		
		while(seguir) {
			try {
				cargarPersona(paciente, input);
				
				sistemaTurnos.agregarTurno(new Turno(paciente));
				System.out.println("El turno se agrego correctamente al sistema!");
				seguir = false;
			}catch(Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
				limpiarBuffer(input);
			}
		}
		
	}
	
	private static void mostrarTablero(SistemaTurnos sistemaTurnos) {
		try {
			sistemaTurnos.mostrarTableroTurnos();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void cargarPersona(Persona paciente, Scanner input) {
		System.out.println("\n--CARGA DE DATOS DEL PACIENTE--");

		System.out.print("Nombre: ");
		paciente.setNombre(input.nextLine());
		System.out.print("Apellido: ");
		paciente.setApellido(input.nextLine());
		System.out.print("Edad: ");
		paciente.setEdad(input.nextInt());
		
		limpiarBuffer(input);
		
		Documento documento = new Documento();
		cargarDocumentacion(documento, input);
		
		paciente.setDocumento(documento);
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

	private static void limpiarBuffer(Scanner input) {
		input.nextLine();
	}
}

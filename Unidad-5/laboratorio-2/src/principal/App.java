package principal;

import java.util.Scanner;

import dominio.entidades.*;
import dominio.enums.TipoDocumento;
import logica.SistemaInscripcion;

public class App {
	
	public static final int SALIR = 16;
	private static Parametros parametros;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SistemaInscripcion inscripcion = new SistemaInscripcion();
		parametros = new Parametros();
		
		loadAplicacion(inscripcion, input);
		input.close();
	}
	
	private static void loadAplicacion(SistemaInscripcion inscripcion, Scanner input) {
		boolean seguir= true;
		
		int opcion = 0;
		
		while(seguir) {
			menu();
			
			try {
				opcion = input.nextInt();
				opcionesMenu(opcion, input, inscripcion);
				
				if(opcion == SALIR) seguir= false;
			}catch(Exception ex) {
				System.out.println(ex);
				limpiarBuffer(input);
			}
		}
	}
	
	private static void menu() {
		System.out.println("\t\t..:MENU:..");
		System.out.println("1. Agregar Alumno");
		System.out.println("2. Agregar Profesor");
		System.out.println("3. Agregar Administrativo");
		System.out.println("4. Agregar Director");
		System.out.println("5. Mostrar Alumnos");
		System.out.println("6. Mostrar Profesores");
		System.out.println("7. Mostrar Administrativos");
		System.out.println("8. Mostrar Directores");
		System.out.println("9. Mostrar todas las personas");
		System.out.println("10. Cantidad de alumnos inscriptos");
		System.out.println("11. Cantidad de profesores trabajando");
		System.out.println("12. Cantidad de administrativos trabajando");
		System.out.println("13. Cantidad de directores trabajando");
		System.out.println("14. Cantidad de personas totales");
		System.out.println("15. Tomar Asistencia");
		System.out.println("16. Salir");
		System.out.print("Ingrese opcion: ");
	}
	
	private static void opcionesMenu(int opcion, Scanner input, SistemaInscripcion inscripcion) {
		limpiarBuffer(input);
		
		switch(opcion) {
			case 1:
				agregarAlumno(inscripcion, input);
			break;
			case 2:
				agregarProfesor(inscripcion, input);
			break;
			case 3:
				agregarAdministrativo(inscripcion, input);
			break;
			case 4:
				agregarDirector(inscripcion, input);
			break;
			case 5:
				mostrarPersonas(inscripcion, "alumno");
			break;
			case 6:
				mostrarPersonas(inscripcion, "profesor");
			break;
			case 7:
				mostrarPersonas(inscripcion, "administrativo");
			break;
			case 8:
				mostrarPersonas(inscripcion, "director");
			break;
			case 9:
				mostrarPersonas(inscripcion, "persona");
			break;
			case 10:
				cantidadDePersonasInscriptas(inscripcion, "alumno");
			break;
			case 11:
				cantidadDePersonasInscriptas(inscripcion, "profesor");
			break;
			case 12:
				cantidadDePersonasInscriptas(inscripcion, "administrativo");
			break;
			case 13:
				cantidadDePersonasInscriptas(inscripcion, "director");
			break;
			case 14:
				cantidadDePersonasInscriptas(inscripcion, "persona");
			break;
			case 15:
				tomarAsistencia(inscripcion);
			break;
			case 16:
				System.out.println("Cierre de la aplicacion");
			break;
			default:
				System.out.println("ERROR: Ha ingresado una opcion invalida, intente nuevamente");
		}
	}
	
	private static void tomarAsistencia(SistemaInscripcion inscripcion) {
		try {
			System.out.println("\t...:TOMA DE ASISTENCIA:...\n");
			inscripcion.tomarAsistencia();
		}catch(Exception ex) {
			System.out.println("ERROR: " + ex.getMessage() + "\n");
		}
	}

	private static void agregarDirector(SistemaInscripcion inscripcion, Scanner input) {
		System.out.println("\n...:DATOS DEL NUEVO DIRECTOR:...");
		Director director = new Director();
		boolean seguir = true;
		
		while(seguir) {
			try {
				cargarEmpleado(director, input);
				
				cargarCarrera(director, input);
				
				inscripcion.agregarPersona(director);
				seguir = false;
			}catch(Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
				limpiarBuffer(input);
			}
		}
		
	}

	private static void cargarCarrera(Director director, Scanner input) {
		System.out.print("Carrera: ");
		director.setCarrera(input.next());
	}

	private static void agregarAdministrativo(SistemaInscripcion inscripcion, Scanner input) {
		System.out.println("\n...:DATOS DEL NUEVO ADMINISTRATIVO:...");
		Administrativo administrativo = new Administrativo();
		boolean seguir = true;
		
		while(seguir) {
			try {
				cargarEmpleado(administrativo, input);
				
				inscripcion.agregarPersona(administrativo);
				seguir = false;
			}catch(Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
				limpiarBuffer(input);
			}
		}
		
	}

	private static void agregarProfesor(SistemaInscripcion inscripcion, Scanner input) {
		System.out.println("\n...:DATOS DEL NUEVO PROFESOR:...");
		Profesor profesor = new Profesor();
		boolean seguir = true;
		
		while(seguir) {
			try {
				cargarEmpleado(profesor, input);
				
				cargarCursos(profesor, input);
				
				inscripcion.agregarPersona(profesor);
				seguir = false;
			}catch(Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
				limpiarBuffer(input);
			}
		}
		
	}
	
	private static void cargarEmpleado(Empleado empleado, Scanner input) {
		cargarPersona(empleado, input);
		
		System.out.print("Fecha del cargo (dd/mm/aaaa): ");
		empleado.setFechaDeCargo(input.next());
		System.out.print("Sueldo: ");
		empleado.setSueldo(input.nextDouble());
	}
	
	
	private static void cantidadDePersonasInscriptas(SistemaInscripcion inscripcion, String tipoPersona) {
		System.out.println("Se inscribieron: " + inscripcion.cantidadDePersonasInscriptas(tipoPersona) + 
				(tipoPersona.equalsIgnoreCase("persona")? " personas": (" " + tipoPersona + "s")) 
				+ "\n");
	}

	private static void mostrarPersonas(SistemaInscripcion inscripcion, String tipoPersona) {
		try {
			System.out.println("\n--" + tipoPersona.toUpperCase() + "S INSCRIPTOS--");
			inscripcion.mostrarPersonasInscriptas(tipoPersona);			
		}catch(Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		System.out.println();
	}

	private static void agregarAlumno(SistemaInscripcion inscripcion, Scanner input) {
		System.out.println("...:DATOS DEL NUEVO ALUMNO:...");
		Alumno alumno = new Alumno();
		boolean seguir = true;
		
		while(seguir) {
			try {
				cargarPersona(alumno, input);
				
				cargarCursos(alumno, input);
				
				inscripcion.agregarPersona(alumno);
				seguir = false;
			}catch(Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
				limpiarBuffer(input);
			}
		}
	}
	
	private static void cargarPersona(Persona nuevaPersona, Scanner input) {
		System.out.println("\n--CARGA DE DATOS--");

		System.out.print("Nombre: ");
		nuevaPersona.setNombre(input.nextLine());
		System.out.print("Apellido: ");
		nuevaPersona.setApellido(input.nextLine());
		System.out.print("Edad: ");
		nuevaPersona.setEdad(input.nextInt());
		
		limpiarBuffer(input);
		
		Documento documento = new Documento();
		cargarDocumentacion(documento, input);
		
		nuevaPersona.setDocumento(documento);
		
		System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
		nuevaPersona.setFechaNacimiento(input.next());
	}
	
	private static void cargarCursos(Persona p, Scanner input) {
		System.out.println("\n--CARGA DE CURSOS--");
		consultarCantidadDeCursos(input);
		
		for(int i = 1; i <= parametros.getCantCursosInscripto(); i++) {
			Curso c = new Curso();
			System.out.println("Curso N°" + (i));
			System.out.print("Nombre: ");
			c.setNombre(input.nextLine());
			
			if(p instanceof Profesor) {
				((Profesor)p).agregarCurso(c);
			}else {
				((Alumno)p).agregarCurso(c);
			}
		}
	}
	
	private static void consultarCantidadDeCursos(Scanner input) {
		boolean seguir= true;
		
		while(seguir) {
			try {
				System.out.print("Cantidad de cursos a inscribir: ");
				parametros.setCantCursosInscripto(input.nextInt());
				seguir = false;
			}catch(Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}finally {
				limpiarBuffer(input);				
			}
		}
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
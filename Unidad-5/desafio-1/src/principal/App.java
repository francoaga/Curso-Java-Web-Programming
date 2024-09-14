package principal;

import domain.entities.*;
import logic.GestorTablas;
import model.*;

public class App {

	public static void main(String[] args) {
		GestorTablas baseDeDatos = new GestorTablas();
		
		//1. Tabla de Documentos
		Tabla<String, Documento> documentos = new Tabla<>();
		
		baseDeDatos.agregarTabla("Documentos", documentos);
		
		//Agrego documentos
		Documento doc4 = new Documento("DNI", "92980592");
		Documento doc1 = new Documento("DNI", "39983043");
		Documento doc2 = new Documento("DNI", "93117891");
		Documento doc3 = new Documento("DNI", "41710734");
		
		
		baseDeDatos.agregarRegistroAUnaTabla("Documentos", new Registro<String, Documento>(doc1.getNumero(), doc1));
		baseDeDatos.agregarRegistroAUnaTabla("Documentos", new Registro<String, Documento>(doc2.getNumero(), doc2));
		baseDeDatos.agregarRegistroAUnaTabla("Documentos", new Registro<String, Documento>(doc3.getNumero(), doc3));
		baseDeDatos.agregarRegistroAUnaTabla("Documentos", new Registro<String, Documento>(doc4.getNumero(), doc4));
		
		baseDeDatos.mostrarTabla("Documentos");
		
		System.out.println("\n\n-------------------------------------------------------------------------");
		
		//1. Tabla de Telefonos
		Tabla<Integer, Telefono> telefonos = new Tabla<>();
		
		baseDeDatos.agregarTabla("Telefonos", telefonos);
		
		//Agrego documentos
		Telefono tele1 = new Telefono(54, "Argentina");
		Telefono tele2 = new Telefono(58, "Venezuela");
		Telefono tele3 = new Telefono(56, "Chile");
		Telefono tele4 = new Telefono(57, "Colombia");
		
		
		baseDeDatos.agregarRegistroAUnaTabla("Telefonos", new Registro<Integer, Telefono>(tele1.getCodigo(), tele1));
		baseDeDatos.agregarRegistroAUnaTabla("Telefonos", new Registro<Integer, Telefono>(tele2.getCodigo(), tele2));
		baseDeDatos.agregarRegistroAUnaTabla("Telefonos", new Registro<Integer, Telefono>(tele3.getCodigo(), tele3));
		baseDeDatos.agregarRegistroAUnaTabla("Telefonos", new Registro<Integer, Telefono>(tele4.getCodigo(), tele4));
		
		baseDeDatos.mostrarTabla("Telefonos");
	}

}

package logic;

import java.util.HashMap;
import java.util.Map;

import domain.entities.Registro;
import domain.entities.Tabla;
import utilities.Validador;

public class GestorTablas {
	private Map<String, Tabla<?,?>> tablas;
	
	/*Constructor*/
	public GestorTablas() {
		this.tablas = new HashMap<>();
	}
	
	public <K,V> void agregarTabla(String nombreTabla, Tabla<K,V> tabla) {
		if(!Validador.validarNombre(nombreTabla))
			throw new IllegalArgumentException("El formato del nombre no es valido.");
		
		if(existeTabla(nombreTabla))
			throw new IllegalArgumentException(String.format("La tabla '%s' ya existe en el sistema", nombreTabla));
		
		this.tablas.put(nombreTabla, tabla);
	}
	
	public boolean existeTabla(String nombreTabla) {
		return this.tablas.containsKey(nombreTabla);
	}
	
	public <K,V> void agregarRegistroAUnaTabla(String nombreTabla, Registro<K,V> registro) {
		Tabla<K, V> tabla = getTabla(nombreTabla);
		
		tabla.agregarRegistro(registro);
	}
	
	private <K,V> Tabla<K, V> getTabla(String nombreTabla){
		if(!existeTabla(nombreTabla))
			throw new IllegalArgumentException(String.format("La tabla '%s' no existe en el sistema", nombreTabla));
		
		return (Tabla<K, V>)this.tablas.get(nombreTabla);
	}
	
	public <K,V> Registro<K,V> getRegistro(String nombreTabla, K idRegistro){
		Tabla<K, V> tabla = getTabla(nombreTabla);
		
		return tabla.buscarRegistro(idRegistro);
	}
	
	public <K,V> void mostrarTabla(String nombreTabla) {
		Tabla<K, V> tabla = getTabla(nombreTabla);
		
		System.out.println(String.format("\n\t----------TABLA '%s'----------", nombreTabla.toUpperCase()));
		tabla.mostrarTabla();
		
	}
 }
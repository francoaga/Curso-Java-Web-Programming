package domain.entities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import domain.interfaces.Persistencia;

public class Tabla<K,V> implements Persistencia {
	private Set<Registro<K,V>> tabla;
	
	/*Constructor*/
	public Tabla() {
		this.tabla = new HashSet<Registro<K,V>>();
	}
	
	/**
	 * Se agrega un registro a la tabla.
	 * 
	 * @param registro El registro que se quiere añadir a la tabla.
	 */
	public void agregarRegistro(Registro<K,V> registro) {
		if(this.tabla.add(registro)) {
			this.guardar();
		}else {
			throw new IllegalArgumentException("El registro ya existe en la tabla");
		}
	}
	
	/**
	 * Se busca en la tabla un registro a partir de su clave K.
	 * En caso de encontrarlo, lo devuelve, caso contrario se retorna null.
	 * 
	 * @param clave La clave del registro.
	 * @return El registro de la tabla o null.
	 */
	public Registro<K,V> buscarRegistro(K clave){
		Registro<K,V> registroEncontrado = null;
		
		//Iterador
		Iterator<Registro<K,V>> iterador = tabla.iterator();
		
		while(iterador.hasNext() && Objects.isNull(registroEncontrado)) {
			Registro<K,V> registroActual = iterador.next();
			
			if(Objects.equals(registroActual.getKey(), clave))
				registroEncontrado = registroActual;
		}
		
		return registroEncontrado;
	}
	
	/**
	 * Se muestra por consola todos los registros de la tabla.
	 * 
	 */
	public void mostrarTabla() {
		tabla.forEach(System.out::println);
	}

	@Override
	public void guardar() {
		System.out.println("El registro se ha guardado exitosamente en la tabla");
	}

	@Override
	public void borrar() {
		System.out.println("El registro se ha borrado exitosamente de la tabla");
	}

	@Override
	public void modificar() {
		System.out.println("El registro se ha modificado exitosamente");
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tabla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tabla<K,V> other = (Tabla<K,V>) obj;
		return Objects.equals(tabla, other.tabla);
	}
	
}

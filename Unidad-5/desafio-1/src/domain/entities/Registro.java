package domain.entities;

import java.util.Objects;

import domain.interfaces.Pair;

public class Registro<K,V> implements Pair<K, V>{
	private K clave;
	private V valor;
	
	/*Constructor*/
	public Registro(K clave, V valor) {
		setKey(clave);
		setValue(valor);
	}
	
	@Override
	public String toString() {
		return String.format("Registro {clave: %s, valor: %s}", clave, valor);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(clave, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro<K, V> other = (Registro<K,V>) obj;
		return Objects.equals(clave, other.clave) && Objects.equals(valor, other.valor);
	}
	
	@Override
	public K getKey() {
		return clave;
	}

	@Override
	public void setKey(K key) {
		if(Objects.isNull(key))
			throw new NullPointerException("Referencia nula para la clave");
		
		this.clave = key;
	}

	@Override
	public V getValue() {
		return valor;
	}

	@Override
	public void setValue(V value) {
		if(Objects.isNull(value))
			throw new NullPointerException("Referencia nula para el valor");
		
		this.valor = value;
	}
}

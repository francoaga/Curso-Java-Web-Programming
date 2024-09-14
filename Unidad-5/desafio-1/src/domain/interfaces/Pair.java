package domain.interfaces;

public interface Pair<K,V> {
	public abstract K getKey();
	
	public abstract void setKey(K key);
	
	public abstract V getValue();
	
	public abstract void setValue(V value);
}

package dominio.interfaces;

public interface Persistencia {
	public abstract void guardar();
	
	public abstract void eliminar();
	
	public abstract void modificar();
}

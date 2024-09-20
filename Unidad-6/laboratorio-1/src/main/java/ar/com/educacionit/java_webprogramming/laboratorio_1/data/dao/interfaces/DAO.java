package ar.com.educacionit.java_webprogramming.laboratorio_1.data.dao.interfaces;

import java.util.List;

import ar.com.educacionit.java_webprogramming.laboratorio_1.data.dao.exceptions.DAOException;


public interface DAO<T, K> {
	public abstract boolean insertar(T a) throws DAOException;
	
	public abstract boolean modificar(T a) throws DAOException;
	
	public abstract boolean eliminar(K id) throws DAOException;
	
	public abstract T obtener(K id) throws DAOException;
	
	public abstract List<T> obtenerTodos() throws DAOException;
}

package data.dao.interfaces;

import java.util.List;

import data.dao.exceptions.DAOException;
import domain.entities.Curso;


public interface AlumnoCursoDAO {
	
	public abstract boolean insertar(Curso c) throws DAOException;
	
	public abstract List<Curso> obtenerCursos() throws DAOException;
}

package ar.com.educacionit.java_webprogramming.laboratorio_1.data.dao.interfaces;

import java.util.List;

import ar.com.educacionit.java_webprogramming.laboratorio_1.data.dao.exceptions.DAOException;
import ar.com.educacionit.java_webprogramming.laboratorio_1.domain.entities.Curso;


public interface AlumnoCursoDAO {
	
	public abstract boolean insertar(Curso c) throws DAOException;
	
	public abstract List<Curso> obtenerCursos() throws DAOException;
}

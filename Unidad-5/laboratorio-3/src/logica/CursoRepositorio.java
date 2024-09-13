package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import dominio.entidades.Curso;

public class CursoRepositorio {
	private Map<Integer, Curso> cursos;
	
	/**
	 * Constructor por defecto.
	 */
	public CursoRepositorio() {
		this.cursos = new HashMap<>();
	}
	
	/**
	 * Agrega un nuevo curso al repositorio.
	 * 
	 * @param c El curso a agregar.
	 * @throws NullPointerException Si se envia una referencia nula.
	 * @throws IllegalArgumentException Si el curso ya esta dado de alta.
	 */
	public void agregarCurso(Curso c) {
		if(Objects.isNull(c))
			throw new NullPointerException("Se ha enviado una referencia nula en el curso");
		
		if(!cursos.isEmpty() && existeCurso(c.getNombre()))
			throw new IllegalArgumentException("El curso ya esta dado de alta en el sistema");
		
		this.cursos.put(c.getId(), c);
	}
	
	/**
	 * Obtiene un curso a partir de su ID.
	 * 
	 * @param id El ID del curso a buscar.
	 * @return El curso si existe, o null en caso contrario.
	 * @throws IllegalArgumentException Si en el sistema no hay cursos dados de alta.
	 */
	public Curso getCurso(Integer id) {
		if(cursos.isEmpty())
			throw new IllegalArgumentException("No se han dado de alta cursos en el sistema");
		
		return cursos.get(id);
	}
	
	/**
	 * Obtiene un curso a partir de su nombre.
	 * 
	 * @param nombre El nombre del curso a buscar.
	 * @return El Curso si existe, o null en caso contrario.
	 * @throws IllegalArgumentException Si en el sistema no hay cursos dados de alta.
	 */
	public Curso getCurso(String nombre) {
		
		if(cursos.isEmpty())
			throw new IllegalArgumentException("No se han dado de alta cursos en el sistema");
		
		Iterator<Curso> iterador = cursos.values().iterator();
		Curso cEncontrado = null;
		
		while(iterador.hasNext() && Objects.isNull(cEncontrado)) {
			Curso actual = iterador.next();
			
			if(actual.getNombre().equalsIgnoreCase(nombre)) {
				cEncontrado = actual;
			}
		}
		
		return cEncontrado;
	}
	
	/**
	 * Obtiene en una coleccion todos los cursos dados de alta en el sistema.
	 * 
	 * @throws IllegalArgumentException Si en el sistema no hay cursos dados de alta.
	 */
	public Collection<Curso> getCursos() {
		if(cursos.isEmpty())
			throw new IllegalArgumentException("No se han dado de alta cursos en el sistema");
		
		return cursos.values(); 
	}
	
	/**
	 * Determina a partir del nombre de un curso, si este ya esta dado de alta
	 * en el sistema.
	 * 
	 * @param nombre El nombre del curso.
	 * @return true si el curso ya existe, false en caso contrario.
	 */
	private boolean existeCurso(String nombre) {
		return Objects.nonNull(getCurso(nombre));
	}
}
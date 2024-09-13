package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import dominio.entidades.Curso;

public class GestorCursos {
	private CursoRepositorio repositorioCursos;
	
	/**
	 * Constructor por defecto.
	 */
	public GestorCursos() {
		this.repositorioCursos = new CursoRepositorio();
	}
	
	/**
	 * Agrega un nuevo curso al sistema.
	 * 
	 * @param nombre El nombre del nuevo curso a agregar.
	 */
	public void agregarCurso(String nombre) {
		Curso nuevoCurso = new Curso(nombre);
		repositorioCursos.agregarCurso(nuevoCurso);
	}
	
	/**
	 * Obtiene un curso a partir de su ID.
	 * 
	 * @param id El ID del cursos a buscar.
	 * @return El curso si existe.
	 * @throws IllegalArgumentException Si el curso no existe en el sistema.
	 */
	public Curso getCurso(Integer id) {
		Curso c = repositorioCursos.getCurso(id);
		
		if(Objects.isNull(c))
			throw new IllegalArgumentException(String.format("El curso con ID: %s no existe en el sistema", id));
		
		return c;
	}
	
	/**
	 * Obtiene una colección de cursos a partir de una colección de IDs.
	 *
	 * @param IDCursos La colección de IDs de cursos a buscar.
	 * @return Una colección de cursos correspondientes a los IDs proporcionados.
	 */
	public Collection<Curso> getCursos(Collection<Integer> IDCursos){
		List<Curso> cursos = new ArrayList<>();
		
		for (Integer id : IDCursos) {
			cursos.add(repositorioCursos.getCurso(id));
		}
		
		return cursos;
	}
	
	/**
	 * Muestra por consola los cursos dados de alta en el sistema
	 */
	public void mostrarCursos() {
		Collection<Curso> cursosAlta= repositorioCursos.getCursos();
		
		int i = 1;
		
		for (Curso curso : cursosAlta) {
			System.out.println(String.format("%s. %s", i++, curso.getNombre()));
		}
	}
	
}


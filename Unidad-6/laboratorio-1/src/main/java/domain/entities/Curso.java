package domain.entities;

import utilities.Validador;

public class Curso {
	private static int idContador = 0;
	private int id;
	private String nombre;
	
	/*Constructor por defecto*/
	public Curso() {
		this.id = ++idContador;
	}
	
	/**
	 * Constructor que permite establecer el nombre de un curso
	 * 
	 * @param nombre El nombre del curso.
	 */
	public Curso(String nombre) {
		this();
		setNombre(nombre);
	}
	
	/**
	 * Obtiene el ID del curso.
	 * 
	 * @return El ID del curso.
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id= id;
	}

	/**
	 * Obtiene el nombre del curso.
	 * 
	 * @return El nombre del curso.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de un curso luego de evaluar el formato.
	 * 
	 * @param nombre El nombre de un curso.
	 * @throws IllegalArgumentException Si el nombre no es valido.
	 * @see Validar Para obtener más detalles sobre las validaciones del nombre.
	 */
	public void setNombre(String nombre) {
		if(!Validador.validarNombreCursos(nombre))
			throw new IllegalArgumentException("El nombre del curso es invalido");
		this.nombre = nombre;
	}

	/**
	 * Representacion en cadena de un curso.
	 * 
	 * @return Cadena que representa un curso.
	 */
	@Override
	public String toString() {
		return "Curso [id= "+ id + ", nombre= " + nombre + "]";
	}
}

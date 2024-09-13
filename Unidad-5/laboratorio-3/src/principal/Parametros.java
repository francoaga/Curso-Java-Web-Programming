package principal;

public class Parametros {
	private int cantCursosInscripto;
	private int cantCursosACargo;
	
	/*Constructor por defecto*/
	public Parametros() { }
	
	/**
	 * Constructor que permite establecer la cantidad de cursos a incribir y cursos
	 * a cargo.
	 * 
	 * @param cantCursosInscripto La cantidad de cursos de inscritos.
	 * @param cantCursosACargo La cantidad de cursos a cargo.
	 */
	public Parametros(int cantCursosInscripto, int cantCursosACargo) {
		setCantCursosInscripto(cantCursosInscripto);
		setCantCursosACargo(cantCursosACargo);
	}


	/**
	 * Establece la cantidad de cursos a cargo.
	 * Si se ingresa un valor negativo, se lanza una excepcion.
	 * 
	 * @param cantCursosACargo La cantidad de cursos a cargo.
	 * @throws IllegalArgumentException Si se ingresa un valor negativo.
	 */
	public void setCantCursosACargo(int cantCursosACargo) {
		if(cantCursosACargo < 0)
			throw new IllegalArgumentException("La cantidad de cursos a cargo no puede ser negativa");
		this.cantCursosACargo = cantCursosACargo;
	}
	
	/**
	 * Establece la cantidad de cursos a inscribir.
	 * Si se ingresa un valor negativo, se lanza una excepcion.
	 * 
	 * @param cantCursosInscripto La cantidad de cursos a inscribir.
	 * @throws IllegalArgumentException Si se ingresa un valor negativo.
	 */
	public void setCantCursosInscripto(int cantCursosInscripto) {
		if(cantCursosInscripto < 0)
			throw new IllegalArgumentException("La cantidad de cursos a inscribir no puede ser negativa");
		this.cantCursosInscripto = cantCursosInscripto;
	}

	/**
	 * Obtiene el valor de cursos a los que se inscribira.
	 * 
	 * @return the cantCursosInscripto
	 */
	public int getCantCursosInscripto() {
		return cantCursosInscripto;
	}

	/**
	 * Obtiene el valor de cursos que tendra a cargo.
	 * 
	 * @return the cantCursosACargo
	 */
	public int getCantCursosACargo() {
		return cantCursosACargo;
	}
}

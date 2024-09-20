package domain.entities;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Turno {
	private static AtomicInteger contador= new AtomicInteger(1);
	public static final int EDAD_PRIORIDAD = 55;
	private int id;
	private Persona paciente;
	
	/**
	 * Constructor que permite establecer un paciente a un turno.
	 * 
	 * @param paciente Paciente asociada a un turno.
	 */
	public Turno(Persona paciente) {
		setPaciente(paciente);
		this.id = contador.getAndIncrement();
	}
	
	/**
	 * Representacion en cadena de un turno, incluye el paciente y el id del
	 * turno
	 * 
	 * @return Cadena que representa un turno.
	 */
	@Override
	public String toString() {
		return String.format("Turno {paciente: %s, id: %s}", paciente, id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, paciente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		return id == other.id && Objects.equals(paciente, other.paciente);
	}

	/**
	 * Obtiene el id del turno.
	 * 
	 * @return Id del turno.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece un paciente a un turno.
	 * Si se recibe una referencia nula, se lanza una excepcion.
	 * 
	 * @param persona El paciente asociada a un turno.
	 * @throws NullPointerException Si el paciente es una referencia nula.
	 */
	public void setPaciente(Persona paciente) {
		if(Objects.isNull(paciente))
			throw new NullPointerException("Ha ingresado una referencia nula en paciente");
		this.paciente = paciente;
	}
	
	/**
	 * Obtiene el paciente asociado a un turno.
	 * 
	 * @return Paciente del turno.
	 */
	public Persona getPaciente() {
		return paciente;
	}
}

package domain.comparators;

import java.util.Comparator;

import domain.entities.Turno;

public class PrioridadTurno implements Comparator<Turno> {

	@Override
	public int compare(Turno t1, Turno t2) {
		// Obtengo la prioridad de cada paciente
		int prioridadTurno1 = t1.getId();
		int prioridadTurno2 = t2.getId();

		// Valido si ambos pacientes son mayores o iguales a la edad de prioridad
		boolean turnoPrioridad1 = t1.getPaciente().getEdad() >= Turno.EDAD_PRIORIDAD;
		boolean turnoPrioridad2 = t2.getPaciente().getEdad() >= Turno.EDAD_PRIORIDAD;

		if (turnoPrioridad1 && turnoPrioridad2) {
			return prioridadTurno1 - prioridadTurno2;
		}

		if (turnoPrioridad1) {
			prioridadTurno1 = -prioridadTurno1;
		}
		if (turnoPrioridad2) {
			prioridadTurno2 = -prioridadTurno2;
		}

		return prioridadTurno1 - prioridadTurno2;
	}

}

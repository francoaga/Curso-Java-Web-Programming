package logic;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

import domain.comparators.PrioridadTurno;
import domain.entities.Turno;

public class SistemaTurnos {
	public static int tiempoDeEspera= 2000;
	private Queue<Turno> turnos;
	
	public SistemaTurnos() {
		this.turnos = new PriorityQueue<>(new PrioridadTurno());
	}
	
	/**
	 * Agrega el turno de un paciente al sistema de turnos.
	 * 
	 * @param turno Turno de un paciente
	 * @throws IllegalArgumentException
	 */
	public void agregarTurno(Turno turno) {
		if(turnos.contains(turno))
			throw new IllegalArgumentException("El turno ya ha sido cargado");
		
		try {
			turnos.add(turno);
		}catch(Exception ex) {
			throw new IllegalArgumentException(ex.getMessage(), ex.getCause());
		}
		
	}
	
	/**
	 * Muestra por consola los turnos que estan cargados en el sistema de turnos.
	 * 
	 * @throws InterruptedException 
	 * @throws IllegalArgumentException Si no hay turnos en el sistema.
	 */
	public void mostrarTableroTurnos() throws InterruptedException {
		System.out.println("\n\t-------TABLERO DE TURNOS-------");
		
		if(turnos.isEmpty())
			throw new IllegalArgumentException("No hay turnos en el sistema");

		while(!turnos.isEmpty()) {
			Turno turnoActual = turnos.poll();
			System.out.println(String.format("Esta siendo atendido: %s", turnoActual));
			
			Thread.sleep(tiempoDeEspera);
			
			Turno turnoSiguiente= turnos.peek();
			
			if(Objects.nonNull(turnoSiguiente)) {
				System.out.println(String.format("Siguiente en la fila: %s",  turnoSiguiente));
				System.out.println("----------------------------------------");
				Thread.sleep(tiempoDeEspera);
			}
		}
	}
}

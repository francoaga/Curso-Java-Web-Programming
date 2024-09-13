package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import dominio.comparadores.OrdenDocumento;
import dominio.comparadores.OrdenEdad;
import dominio.entidades.Administrativo;
import dominio.entidades.Alumno;
import dominio.entidades.Director;
import dominio.entidades.Persona;
import dominio.entidades.Profesor;
import dominio.enums.TipoDocumento;
import logica.excepciones.SistemaInscripcionException;


public class SistemaInscripcion {
	private Set<Persona> personas;
	
	/*Constructor por defecto*/
	public SistemaInscripcion() {
		this.personas = new HashSet<>();
	}
	
	/**
	 * Agrega una persona al sistema si no esta dada de alta.
	 * 
	 * @param p Una persona a inscribir.
	 * @throws SistemaIncripcionException Si la persona ya ha sido dada de alta en el sistema.
	 */
	public void agregarPersona(Persona p) throws SistemaInscripcionException {
		if(this.personas.add(p)) {
			p.guardar();			
		}else { 
			throw new SistemaInscripcionException(1);
		}
	}
	
	/**
	 * Busca por tipo y numero de documento si una persona esta inscripta.
	 * Si la persona esta inscripta retorna su referencia, caso contrario
	 * retorna una referencia null si la encuentra o no hay personas dadas
	 * de alta.
	 * 
	 * @param tipo El tipo de documento de la persona.
	 * @param numero El numero de documento de la persona.
	 * @return La persona encontrada o null si no se encuentra/no hay personas
	 * dadas de alta.
	 */
	public Persona buscarPersona(TipoDocumento tipo, String numero) {
		Persona personaEncontrada = null;
		
		if(personas.isEmpty()) return personaEncontrada;
		
		Iterator<Persona> iterador = personas.iterator();
		
		while(iterador.hasNext() && personaEncontrada == null) {
			Persona p = iterador.next();
			if(p.getTipoDocumento().equals(tipo) && p.getNumeroDocumento().equals(numero))
				personaEncontrada = p;
		}
		
		return personaEncontrada;
	}
	
	 /**
     * Muestra las personas inscriptas.
     * Si por parametro se pasa como tipo de persona a 'Persona', se mostraran todas las personas que se
     * han inscripto.
     * 
     * @param tipoPersona Se indica el tipo de personas a visualizar.
	 * @throws SistemaIncripcionException Si no hay personas dadas de alta en el sistema.
     */
    public void mostrarPersonasInscriptas(String tipoPersona) throws SistemaInscripcionException {
    	if(personas.isEmpty()) {
    		throw new SistemaInscripcionException(2);
    	}
    	
    	int cantPersonasTipo= cantidadDePersonasInscriptas(tipoPersona);
    	
    	if(cantPersonasTipo == 0)
    		throw new SistemaInscripcionException(String.format("En el sistema no hay %s dado/a de alta", tipoPersona));
    	
    	List<Persona> listaOrdenada = getListaOrdenada();
    	
        System.out.println(String.format("\n--%sS INSCRIPTOS", tipoPersona.toUpperCase()));
        
        listaOrdenada.forEach(System.out::println);
        
        System.out.println();
    }

    /**
     * Obtiene la cantidad de personas que están inscriptas.
     * Si por parametro se pasa como tipo de persona a 'Persona', se contaran todas las personas incriptas.
     *
     * @param tipoPersona Tipo de persona a contar (Alumno o Profesor).
     * @return Numero de personas inscriptas de ese tipo.
     */
    public int cantidadDePersonasInscriptas(String tipoPersona) {
        int contador = 0;
        
        if(!personas.isEmpty()) {
        	if(tipoPersona.equalsIgnoreCase("Persona")) {
            	contador = personas.size();
        	}else {
	        	for (Persona persona : personas) {
	                if (tipoPersona.equalsIgnoreCase("Alumno") && persona instanceof Alumno) {
	                    contador++;
	                } else if (tipoPersona.equalsIgnoreCase("Profesor") && persona instanceof Profesor) {
	                    contador++;
	                }else if (tipoPersona.equalsIgnoreCase("Administrativo") && persona instanceof Administrativo) {
	                    contador++;
	                }else if (tipoPersona.equalsIgnoreCase("Director") && persona instanceof Director) {
	                    contador++;
	                }
	            }
        	}
        }

        return contador;
    }
    
    /**
     * Se muestra por consola la toma de asistencia de las personas, que se atienden
     * en función de su edad.
     *
     * @throws SistemaInscripcionException Si no hay personas dadas de alta en el sistema.
     */
    public void tomarAsistencia() throws SistemaInscripcionException {
    	if(personas.isEmpty())
    		throw new SistemaInscripcionException(2);
    	
    	Queue<Persona> asistencia = colaDePrioridades(false);
    	
    	if(!asistencia.isEmpty()) {
    		//Remuevo el siguiente de la cola
    		Persona personaActual = asistencia.poll();
    		
    		//Remuevo la persona del conjunto
    		personas.remove(personaActual);
    		
    		System.out.println(String.format("Atendiendo a: %s", personaActual.getNombreCompleto()));
    		
    		//Obtengo el siguiente atender sin removerlo de la cola
    		Persona personaSiguiente = asistencia.peek();
    		
    		if(Objects.nonNull(personaSiguiente)) {
    			System.out.println(String.format("Será atendido: %s", personaSiguiente.getNombreCompleto()));
    		}
    	} else {
    		System.out.println("No hay personas para atender.");
    	}
    	
    	System.out.println();
    }
    
    /**
     * Crea y retorna una cola de prioridades para ordenar a las personas según su edad.
     *
     * @param tipoPrioridad Determina si el orden es ascendente (true) o descendente (false) por edad.
     * @return Una cola de prioridades ordenada por edad.
     */
    private Queue<Persona> colaDePrioridades(boolean tipoPrioridad){
    	Queue<Persona> colaDePrioridad = new PriorityQueue<>(new OrdenEdad(tipoPrioridad));
    	
    	colaDePrioridad.addAll(personas);
    	
    	return colaDePrioridad;
    }
    
    /**
     * Obtiene una lista, en la cual estan las personas dadas de alta ordenadas
     * por tipo y numero de documento.
     * 
     * @return Lista ordenada de las personas dadas de alta.
     * @throws SistemaIncripcionException Si no hay personas dadas de alta en el sistema.
     */
    private List<Persona> getListaOrdenada() throws SistemaInscripcionException{
    	if(personas.isEmpty()) {
    		throw new SistemaInscripcionException(2);
    	}
    	
    	List<Persona> lista= new ArrayList<>(personas);
    	lista.sort(new OrdenDocumento());
    	
    	return lista;
    }
}
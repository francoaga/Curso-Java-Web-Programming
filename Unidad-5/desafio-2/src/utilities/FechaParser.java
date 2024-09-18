package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FechaParser {
	
	public static final String FECHA_DDMMYYYY = "dd/MM/yyyy";
	
	/*Constructor privado*/
	private FechaParser() { }
	
	/**
	 * Convierte una cadena que representa una fecha en formato especificado
	 * a un objeto LocalDate.
	 * Si la cadena fecha no cumple con el formato especificado, se lanza una excepcion
	 * IllegalArgumentException.
	 * 
	 * @param fecha Cadena que representa la fecha
	 * @param formatoFecha Formato de fecha deseado (por ejemplo: "dd-MM-yyyy").
	 * @return Un objeto LocalDate que representa la fecha parseada.
	 * @throws IllegalArgumentException Si el formato de la fecha es invalido.
	 * @throws DateTimeParseException Si la fecha no es valida o no existe.
	 */
	public static LocalDate parsearFecha(String fecha, String formatoFecha) {
		try {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoFecha);
			return LocalDate.parse(fecha, formato);			
		}catch(IllegalArgumentException iae) {
			throw new IllegalArgumentException("El formato de la fecha es invalida");
		}catch(DateTimeParseException dtpe) {
			throw new DateTimeParseException("La fecha no es valida", dtpe.getParsedString(), dtpe.getErrorIndex());	
		}catch(Exception ex) {
			throw new IllegalArgumentException("La cadena fecha no coincide con el formato");
		}
	}
	
	/**
	 * Convierte una cadena que representa una fecha en formato dd/MM/yyyy a un objeto LocalDate.
	 * Si la cadena fecha no cumple con el formato especificado o no existe, se lanza una excepcion.
	 * 
	 * @param fecha Cadena que representa la fecha en formato dd/MM/yyyy.
	 * @return Un objeto LocalDate que representa la fecha parseada.
	 * @throws IllegalArgumentException Si la cadena fecha no coincide con el formato.
	 * @throws DateTimeParseException Si la fecha no es valida o no existe.
	 */
	public static LocalDate parsearFecha(String fecha) {
		return parsearFecha(fecha, FECHA_DDMMYYYY);
	}
	
	/**
	 * Valida si una cadena que representa una fecha en un formato especificado, 
	 * existe o no.
	 * 
	 * @param fecha Cadena que representa la fecha.
	 * @param formatoFecha Formato de fecha deseado(por ejemplo: dd-mm-yyyy)
	 * @return true si la fecha existe, false caso contrario.
	 */
	public static boolean validarFecha(String fecha, String formatoFecha) {
		return parsearFecha(fecha, formatoFecha) != null;
	}
	
	/**
	 * Valida si una cadena que representa una fecha en formato dd/MM/yyyy, 
	 * existe o no.
	 * 
	 * @param fecha Cadena que representa la fecha.
	 * @return true si la fecha existe, false caso contrario.
	 */
	public static boolean validarFecha(String fecha) {
		return validarFecha(fecha, FECHA_DDMMYYYY);
	}
}

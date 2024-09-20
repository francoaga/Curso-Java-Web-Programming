package ar.com.educacionit.java_webprogramming.laboratorio_1.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
    // Expresión regular para validar correos electrónicos de educacionit.com
    private static final String REGEX_EMAIL = "^[a-zA-Z0-9+._-]+@educacionit\\.com$";
    
    // Expresión regular para validar contraseñas que contienen letras mayúsculas, minúsculas, números y los caracteres *-_. 
    private static final String REGEX_CONTRASENIA = "^(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9-_.]+$";

    // Expresion regular para validar numeros de documentos que tienen una longitud de 7 a 8 numeros.
    private static final String REGEX_NUMERO_DOCUMENTO = "^[0-9]{7,8}$";
    
    // Expresion regular para validar el nombre y apellido de personas.
    private static final String REGEX_NOMBRE = "^[A-Za-zñÑ\\s'´]+$";
    
    // Expresion regular para validar nombres de cursos y carreras
    private static final String REGEX_NOMBRE_CURSOS = "^[A-Za-zñÑ0-9\\s\\p{Punct}]+$";
    
    // Expresion regular para validar fechas con el formato dd/MM/yyyy
    private static final String REGEX_FECHAS_DDMMYYYY = "^(0[1-9]|[1-2][0-9]|3[0-1]/0[1-9]|1[0-2])/\\d{4})$";
    
    /* Constructor privado para evitar instancias */
    private Validador() { }

    /**
     * Valida si una cadena es un correo electrónico válido de educacionit.com.
     *
     * @param email El correo electrónico a validar.
     * @return true si es válido, false en caso contrario.
     */
    public static boolean validarEmail(String email) {
        Pattern patron = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = patron.matcher(email);
        return matcher.matches();
    }

    /**
     * Valida si una cadena es una contraseña válida que cumple con ciertos criterios.
     *
     * @param contrasenia La contraseña a validar.
     * @return true si es válida, false en caso contrario.
     */
    public static boolean validarContrasenia(String contrasenia) {
        Pattern patron = Pattern.compile(REGEX_CONTRASENIA);
        Matcher matcher = patron.matcher(contrasenia);
        return matcher.matches();
    }
    
    public static boolean validarNumeroDocumento(String numero) {
    	return numero.matches(REGEX_NUMERO_DOCUMENTO);
    }
    
    public static boolean validarNombre(String nombre) {
    	return nombre.matches(REGEX_NOMBRE);
    }
    
    public static boolean validarNombreCursos(String nombre) {
    	 Pattern patron = Pattern.compile(REGEX_NOMBRE_CURSOS);
         Matcher matcher = patron.matcher(nombre);
         return matcher.matches();
    }
    
    public static boolean validarFechasDDMMYYYY(String fecha) {
    	Pattern patron = Pattern.compile(REGEX_FECHAS_DDMMYYYY);
    	Matcher matcher = patron.matcher(fecha);
    	
    	return matcher.matches();
    }
}
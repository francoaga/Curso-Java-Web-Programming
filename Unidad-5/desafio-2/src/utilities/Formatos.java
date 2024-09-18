package utilities;

public class Formatos {
	public static final String FORMATO_CUENTA = "###-#-####/#";
	public static final String FORMATO_CBU = "######## ##############";
	public static final String FORMATO_TC = "#### #### #### ####";
	public static final String FORMATO_BANCO_SUCURSAL = "####";
	public static final String FORMATO_CODIGO_SEGURIDAD_TC = "###";
	
	/*Constructor privado*/
	private Formatos() {
		
	}
	
	/**
     * Obtiene el formato deseado para un número dado, según el tipo especificado.
     *
     * @param numero El número a formatear.
     * @param tipo   El tipo de formato deseado (por ejemplo, "CC", "CA", "CBU", "TC", "BANCO", "SUCURSAL", "CS").
     * @return El número formateado de acuerdo al tipo especificado.
     */
	public static String getFormato(Integer numero, String tipo) {
		String formato = "";
		switch (tipo.toUpperCase()) {
		case "CC":
		case "CA":
			formato = getNumero(numero, FORMATO_CUENTA);
			break;
		case "CBU":
			formato = getNumero(numero, FORMATO_CBU);
			break;
		case "TC":
			formato = getNumero(numero, FORMATO_TC);
			break;
		case "BANCO":
		case "SUCURSAL":
			formato = getNumero(numero, FORMATO_BANCO_SUCURSAL);
			break;
		case "CS":
			formato = getNumero(numero, FORMATO_CODIGO_SEGURIDAD_TC);
			break;
		default:
			break;
		}
		return formato;
	}

	 /**
     * Formatea un número según un formato especificado, completando con ceros a la izquierda.
     *
     * @param numero   El número a formatear.
     * @param formato  El formato deseado que contiene caracteres "#" para reemplazar.
     * @return El número formateado de acuerdo al formato especificado.
     */
	private static String getNumero(Integer numero, String formato) {
		// Verificamos la longitud que debe tener nuestro numero
		int cantidadCeros = contarCaracteres(formato, '#');

		// completamos con ceros segun la longitud obtenida
		String numeroCadena = String.format("%0" + cantidadCeros + "d", numero);
		String numeroFinal = "";
		int indiceNumeroCadena = 0;

		// recorremos el formato para poder sustituir los valores
		for (int i = 0; i < formato.length(); i++) {
			numeroFinal += formato.charAt(i);
			// solo reemplazamos los numerales
			if (formato.charAt(i) == '#') {
				numeroFinal = numeroFinal.replace("#", String.valueOf(numeroCadena.charAt(indiceNumeroCadena)));
				// esto nos garantiza que si el formato tiene un caracter especial no nos
				// movamos en el numero original y nos de error
				indiceNumeroCadena++;
			}
		}

		return numeroFinal;
	}

    /**
     * Cuenta la cantidad de caracteres especiales en el formato especificado.
     *
     * @param formato El formato que se va a analizar.
     * @param caracterEspecial El caracter que se debe contabilizar dentro del formato.
     * @return La cantidad de caracteres especiales en el formato.
     */
	private static int contarCaracteres(String formato, char caracterEspecial) {
		int cantidad = 0;
		for (int i = 0; i < formato.length(); i++) {
			if (formato.charAt(i) == caracterEspecial) {
				cantidad++;
			}
		}
		
		return cantidad;
	}
}

package dominio.comparadores;

import java.util.Comparator;

import dominio.entidades.Persona;

public class OrdenDocumento implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		int resultadoComparacionFinal = Integer.MIN_VALUE;
		
		String tipoDocumentoPersona1= p1.getTipoDocumento().name();
		String tipoDocumentoPersona2= p2.getTipoDocumento().name();
		
		int resultadoCompararTipo = tipoDocumentoPersona1.compareTo(tipoDocumentoPersona2);
		
		if(resultadoCompararTipo == 0) {
			String numeroDocumentoPersona1= p1.getNumeroDocumento();
			String numeroDocumentoPersona2= p2.getNumeroDocumento();
			
			resultadoComparacionFinal= numeroDocumentoPersona1.compareTo(numeroDocumentoPersona2);
		}else {
			resultadoComparacionFinal = resultadoCompararTipo;
		}
		
		return resultadoComparacionFinal;
	}

}

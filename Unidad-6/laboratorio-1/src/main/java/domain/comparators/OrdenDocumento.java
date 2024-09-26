package domain.comparators;

import java.util.Comparator;

import domain.entities.Persona;

public class OrdenDocumento implements Comparator<Persona> {
	
	@Override
	public int compare(Persona o1, Persona o2) {
		int resultadoComparacionFinal = Integer.MIN_VALUE;
		
		String tipoDocumentoPersona1= o1.getTipoDocumento().name();
		String tipoDocumentoPersona2= o2.getTipoDocumento().name();
		
		int resultadoCompararTipo = tipoDocumentoPersona1.compareTo(tipoDocumentoPersona2);
		
		if(resultadoCompararTipo == 0) {
			String numeroDocumentoPersona1= o1.getNumeroDocumento();
			String numeroDocumentoPersona2= o2.getNumeroDocumento();
			
			resultadoComparacionFinal= numeroDocumentoPersona1.compareTo(numeroDocumentoPersona2);
		}else {
			resultadoComparacionFinal = resultadoCompararTipo;
		}
		
		return resultadoComparacionFinal;
	}

}
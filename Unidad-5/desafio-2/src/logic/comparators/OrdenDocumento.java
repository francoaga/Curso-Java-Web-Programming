package logic.comparators;

import java.util.Comparator;

import domain.entities.Documento;

public class OrdenDocumento implements Comparator<Documento> {

	@Override
	public int compare(Documento d1, Documento d2) {
		int resultadoComparacionFinal = Integer.MIN_VALUE;
		
		String tipoDocumento1= d1.getTipo().name();
		String tipoDocumento2= d2.getTipo().name();
		
		int resultadoCompararTipo = tipoDocumento1.compareTo(tipoDocumento2);
		
		if(resultadoCompararTipo == 0) {
			String numeroDocumento1= d1.getNumero();
			String numeroDocumento2= d2.getNumero();
			
			resultadoComparacionFinal= numeroDocumento1.compareTo(numeroDocumento2);
		}else {
			resultadoComparacionFinal = resultadoCompararTipo;
		}
		
		return resultadoComparacionFinal;
	}

}

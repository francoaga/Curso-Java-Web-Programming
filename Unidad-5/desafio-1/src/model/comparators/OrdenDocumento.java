package model.comparators;

import java.util.Comparator;

import model.Documento;

public class OrdenDocumento implements Comparator<Documento> {

	@Override
	public int compare(Documento o1, Documento o2) {
		int comparadorDeTipos = o1.getTipo().compareTo(o2.getTipo());
		int comparadorDeNumeros = Integer.MIN_VALUE;
		
		if(comparadorDeTipos == 0) comparadorDeNumeros =  o1.getNumero().compareTo(o2.getNumero());
		 
		return (comparadorDeTipos == 0) ? comparadorDeNumeros : comparadorDeTipos;
	}

}

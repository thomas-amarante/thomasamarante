package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class ComparadorLista implements Comparator<String> {

	@Override
	public int compare(String f1, String f2) {

		if( f1.compareTo(f2) != 0){
			return f1.compareTo(f2);			
		} else {
			return 0;
		}	

	}

}
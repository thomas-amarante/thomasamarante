package br.com.senacrs.alp.aulas;


import java.util.Comparator;

public class ComparatorString implements Comparator<String> {

	@Override

	public int compare(String o1, String o2) {

	return o2.compareTo(o1);

	}

}
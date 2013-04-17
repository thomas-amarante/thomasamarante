package br.com.senacrs.alp.aulas;

import java.util.Comparator;

class ComparatorInt implements Comparator<Integer> {

@Override

public int compare(Integer o1, Integer o2) {

	int resultado = 0;

		if(par(o1) == par(o2)){

			resultado = compareMesmaParidade(o1, o2);

		}

		else {

			resultado = compareParidadeDistinta(o1, o2);

		}

		return resultado;

	}

private boolean par(Integer o1) {

	boolean resultado = false;
	
	resultado = o1.intValue()%2==0;
	
	return resultado;

}

private int compareParidadeDistinta(Integer o1, Integer o2) {

	int resultado = 0;
	
	if (par(o1)){
	
		resultado = -1;
	
	}
	
	else {
	
		resultado = 1;

}

return resultado;

}

private int compareMesmaParidade(Integer o1, Integer o2) {

	int resultado = 0;
	
	resultado = o1.intValue() - o2.intValue();
	
	return resultado;
	
	}

}
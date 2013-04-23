package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class ComparadorFuncionariosPorDecrescenteSalario implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario s1, Funcionario s2) {
		
		int resultado = 0;
		if(s1.getSalario()<s2.getSalario()){
			resultado = 1;
		}else if(s1.getSalario()>s2.getSalario()){
			resultado = -1;
		}else{
			resultado = 0;
		}
		
		return resultado;
	}

}

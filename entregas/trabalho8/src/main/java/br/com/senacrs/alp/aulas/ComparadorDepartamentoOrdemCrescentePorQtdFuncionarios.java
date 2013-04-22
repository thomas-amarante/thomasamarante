package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class ComparadorDepartamentoOrdemCrescentePorQtdFuncionarios implements Comparator<Departamento> {

	@Override
	public int compare(Departamento dp1, Departamento dp2) {
		
		int resultado = 0;
		
		if(dp1.quantidadeFuncionarios() < dp2.quantidadeFuncionarios()){
			resultado = 1;
		}else if(dp1.quantidadeFuncionarios()>dp2.quantidadeFuncionarios()){
			resultado = -1;
		}else{
			resultado = 0;
		}
		
		return resultado;
	}

}

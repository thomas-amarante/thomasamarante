package br.com.senacrs.alp.aulas;

import br.com.senacrs.alp.aulas.Departamento;
import br.com.senacrs.alp.aulas.Empresa;
import br.com.senacrs.alp.aulas.Funcionario;

public class MeuFuncionario implements Funcionario {
	
	private Empresa empresa;
	private Departamento depto;
	private String nome;
	private double salario;

	
	public MeuFuncionario(Empresa empresa, Departamento depto, String nome, double salario){
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		if(depto == null){
			throw new IllegalArgumentException();
		}
		if(salario<0){
			throw new IllegalArgumentException();
		}
		
		this.empresa = empresa;
		this.depto = depto;
		this.nome = nome;
		this.salario = salario;
	}

	
	@Override
	public Empresa getEmpresa() {
		return this.empresa;
	}

	@Override
	public Departamento getDepartamento() {
		
		return this.depto;
	}

	@Override
	public String getNome() {		
		return this.nome;
	}

	@Override
	public double getSalario() {
		
		return this.salario;
	}

}

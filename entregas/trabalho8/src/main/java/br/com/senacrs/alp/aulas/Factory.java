package br.com.senacrs.alp.aulas;

public class Factory {
	

	private static final Factory instancia = new Factory();
	
	private Factory() {
		
	}
	
	public Funcionario criarFuncionario(Departamento departamento, String nome, double salario) {
	
		if(departamento == null){
			throw new IllegalArgumentException();
		}
		
		Funcionario resultado = null;
		
		resultado = new MeuFuncionario(departamento.getEmpresa(), departamento, nome, salario);
		
		return resultado;
	}
	
	public Departamento criarDepartamento(Empresa empresa, String nome) {
	
		Departamento resultado = null;
		
		resultado = new MeuDepartamento(empresa, nome);
		
		return resultado;
	}
	
	public Empresa criarEmpresa(String nome) {
	
		Empresa resultado = null;
		
		resultado = new MinhaEmpresa(nome);
		
		return resultado;
	}
	
	public static Factory getInstancia() {
		return instancia;
	}
}

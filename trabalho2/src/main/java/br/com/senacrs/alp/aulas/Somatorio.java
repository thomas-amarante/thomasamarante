package br.com.senacrs.alp.aulas;


public class Somatorio {
	
	private static Somatorio instancia = new Somatorio();
	
	
	private Somatorio() {

		super();
	}
	
	public double somaTotal(double[] valores) {
		
		double resultado = 0.0;
		
		if (valores == null) {
			resultado = Double.NaN;
		}
				
		else { 
			for (int x = 0; x < valores.length; x++) {
			 resultado = resultado + valores[x];
			 }
		}
		//Implementar
		
		return resultado;
	}
	
	public static Somatorio getInstancia() {
		
		return Somatorio.instancia;
	}
}

package br.com.senacrs.alp.aulas;


public class Factory {


	private static final Factory instancia = new Factory();


	private Factory() {
	}


	public ArquivoConfiguracao criarArquivoConfiguracao(String arquivoEntrada) {


		ArquivoConfiguracao resultado = null;


		if(arquivoEntrada == null){
			throw new IllegalArgumentException();
		}


		resultado = new MeuArquivo(arquivoEntrada);


		return resultado;
	}


	public static Factory getInstancia() {
		return instancia;
	}
}


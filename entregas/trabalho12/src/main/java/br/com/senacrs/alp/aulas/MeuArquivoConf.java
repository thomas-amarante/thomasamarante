package br.com.senacrs.alp.aulas;


public class MeuArquivoConf implements Configuracao {


	private ArquivoConfiguracao config;


	public MeuArquivoConf(ArquivoConfiguracao config){


		this.config = config;
	}			


	@Override
	public ArquivoConfiguracao getArquivoConfiguracao() {


		ArquivoConfiguracao resultado = null;


		resultado = ArquivoConfiguracao.class.cast(config);


		return resultado;
	}


	@Override
	public boolean valido() {


		boolean resultado = false;


		if((ArquivoConfiguracao.class.cast(config).getPort() >= 1024) 
				&& (ArquivoConfiguracao.class.cast(config).getPort()<= 65535)
				&& (ArquivoConfiguracao.class.cast(config).getRootDir().equals("./html"))
				&& (ArquivoConfiguracao.class.cast(config).getErrorDir().equals("./html/error/"))) {


			resultado = true;
		}




		return resultado;
	}
}



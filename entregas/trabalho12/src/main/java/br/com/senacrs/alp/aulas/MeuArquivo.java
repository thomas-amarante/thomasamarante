package br.com.senacrs.alp.aulas;

import java.io.*;

	public class MeuArquivo implements ArquivoConfiguracao, Configuracao {
	
	private ArquivoConfiguracao config;
	
	MeuArquivo (ArquivoConfiguracao config){
	
		if(config == null){
			throw new IllegalArgumentException();
	}
	
		this.config = config;
	}
	
		@Override
		public ArquivoConfiguracao getArquivoConfiguracao() {
	
		ArquivoConfiguracao resultado = null;
		return resultado;
	}
	
		@Override
		public boolean valido() {
	
			return false;
	}
	
		@Override
		public String getRootDir() {
	
			return null;
	}
	
		@Override
		public String getErrorDir() {
	
			return null;
	}
	
		@Override
		public int getPort() {
		
		return 0;
	}

}
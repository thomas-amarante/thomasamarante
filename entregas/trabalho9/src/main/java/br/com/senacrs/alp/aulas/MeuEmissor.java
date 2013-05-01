package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MeuEmissor implements EmissorMensagens {

	String arquivoEntrada;
	
	public MeuEmissor(String arquivoEntrada) {
		this.arquivoEntrada = arquivoEntrada;
		File f = obterFileLeitura(arquivoEntrada);
		verificarFormato(f);
	}
	
	
	private void verificarFile(File file) {
		if(file == null) {
			throw new IllegalArgumentException();
		}
		if(! file.exists()) {
			throw new IllegalArgumentException();
		}
		if(! file.isFile()) {
			throw new IllegalArgumentException();
		}
		if(! file.canRead()) {
			throw new IllegalArgumentException();
		}
	}
	
	private void verificarFormato(File f) {
		
		try{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String a[] = br.readLine().split("=");
			
			if(a.length != 2)
				throw new IllegalArgumentException();

		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	private File obterFileLeitura(String arquivo){
		File resultado = null;
		
		if(arquivo == null) {
			throw new IllegalArgumentException();
		} else {	
			resultado = new File(arquivo);
			verificarFile(resultado);
		}
		
		return resultado;
	}

	
	
	@Override
	public String formatarMensagem(String chave, Object... msg) {
		
		String retorno = null;
		
		try{
			
			FileReader fr = new FileReader(arquivoEntrada);
			BufferedReader br = new BufferedReader(fr);

			boolean possui = false; 
			String linha;
			while( (linha = br.readLine()) != null) {
			
				String l[] = linha.split("=");
				if(l[0].trim().equals(chave)) {
					retorno = String.format(l[1].trim(), msg);
					possui = true;
				} 
				
			}
			
			if(possui == false) {
				throw new IllegalArgumentException();
				
			}
			
			fr.close();
			br.close();
		
		} catch(IOException ex){
			ex.printStackTrace();
		}
		
		return  retorno;
	}

}

package br.com.senacrs.alp.aulas;

import java.io.*;
import java.util.*;

public class MeuArquivoConfiguracao implements ArquivoConfiguracao{

private String arquivoEntrada;

public MeuArquivoConfiguracao (String arquivoEntrada) {

	verificaArquivoEntrada(arquivoEntrada);
	File file = new File(arquivoEntrada);
	verificaFile(file);
	this.arquivoEntrada = arquivoEntrada;


}	
private void verificaFile(File file) {

	if(!file.exists()){
		throw new IllegalArgumentException();
			}
			if(file.isDirectory()){
		throw new IllegalArgumentException();
	}

}

private void verificaArquivoEntrada(String arquivoEntrada) {

	if(arquivoEntrada == null){
		throw new IllegalArgumentException();
	}

}

@Override
public String getRootDir() {

	FileReader filereader = null;
		BufferedReader buffreader = null;
		String resultado = null, linha;	
	try {

	filereader = new FileReader(arquivoEntrada);
	buffreader = new BufferedReader(filereader);	
	Map<String, String> mapa = new HashMap<String, String>();

	while ((linha = buffreader.readLine()) != null){

		String l[] = linha.split("=");

	if(l.length == 2){
		mapa.put(l[0].trim(), l[1].trim());
	}
}


resultado = mapa.get("root_dir");

	} catch (FileNotFoundException e) {
		throw new IllegalStateException();
		} catch (IOException e) {	
	throw new IllegalStateException();
	}

return resultado;

}

@Override
public String getErrorDir() {

	FileReader filereader = null;
		BufferedReader buffreader = null;
		String resultado = null, linha;	
	try {

		filereader = new FileReader(arquivoEntrada);
		buffreader = new BufferedReader(filereader);	
		Map<String, String> mapa = new HashMap<String, String>();

		while ((linha = buffreader.readLine()) != null){

			String l[] = linha.split("=");

			if(l.length == 2){
					mapa.put(l[0].trim(), l[1].trim());
			}
}


resultado = mapa.get("error_dir");

	} catch (FileNotFoundException e) {
		throw new IllegalStateException();
		} catch (IOException e) {	
		throw new IllegalStateException();
	}

return resultado;

}

@Override
public int getPort() {

	FileReader filereader = null;
	BufferedReader buffreader = null;
	String linha;
	int resultado = 0;
	try {

		filereader = new FileReader(arquivoEntrada);
		buffreader = new BufferedReader(filereader);	
		Map<String, String> mapa = new HashMap<String, String>();

		while ((linha = buffreader.readLine()) != null){

			String l[] = linha.split("=");

	if(l.length == 2){
		String porta[] = l[1].split("#");
		if(porta.length == 2){
		mapa.put(l[0].trim(), porta[0].trim());
		}
	}	
}

resultado = Integer.parseInt(mapa.get("port"));

	} catch (FileNotFoundException e) {
		throw new IllegalStateException();
		} catch (IOException e) {	
	throw new IllegalStateException();
	}

	return resultado;

	}
}
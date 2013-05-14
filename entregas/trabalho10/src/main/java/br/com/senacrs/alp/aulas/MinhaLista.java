package br.com.senacrs.alp.aulas;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MinhaLista implements ListaConteudoDiretorio {

	private String[] resultado = null;

	@Override
	public String[] listarConteudo(File diretorio) {

		ArrayList<String> listaD = new ArrayList<String>();
		ArrayList<String> listaA = new ArrayList<String>();

			verificaDiretorio(diretorio);

			resultado = diretorio.list();			

			if(resultado == null){
				throw new IllegalArgumentException();
			}

			for (String r : resultado) {

				File f = new File(diretorio + "/" + r);
				if(f.isFile()) {
					listaA.add(r);					
				} else {
					listaD.add(r);					
				}

			}			

			ComparadorLista cl = new ComparadorLista();
			Collections.sort(listaA, cl);
			Collections.sort(listaD, cl);

			String nova[] = new String[resultado.length];
			String n = "";

			int i = 0;
			for (String r : listaD) {

				File f = new File(diretorio + "/" + r);

				n = verificaFormato(f) + SEPARADOR + verificaPermissoes(f) + SEPARADOR + f.length() + SEPARADOR + f.getName(); 

				nova[i] = n;		

				i++;
			}			

			for (String r : listaA) {

				File f = new File(diretorio + "/" + r);

				n = verificaFormato(f) + SEPARADOR + verificaPermissoes(f) + SEPARADOR + f.length() + SEPARADOR + f.getName(); 

				nova[i] = n;

				i++;
			}

		return nova;



	}

	public static String verificaFormato(File f) {

		String n = "";

		if(f.isFile())
			n += NADA_CONSTA; 
		else
			n += IDENTIFICA_DIRETORIO;		

		return n;
	}

	public static String verificaPermissoes(File f) {

		String retorno = "";

		if(f.canRead()) 
			retorno += PERMISSAO_LEITURA;
		else
			retorno += NADA_CONSTA;

		if(f.canWrite()) 
			retorno += PERMISSAO_ESCRITA;
		else
			retorno += NADA_CONSTA;

		if(f.canExecute()) 
			retorno += PERMISSAO_EXECUCAO;
		else
			retorno += NADA_CONSTA;

		return retorno;

	}

	private void verificaDiretorio (File diretorio) {

		if(diretorio == null)
			throw new IllegalArgumentException();				

		if(!diretorio.canRead())
			throw new IllegalArgumentException();					

		if(!diretorio.canExecute())
			throw new IllegalArgumentException();					

		if(!diretorio.canWrite())
			throw new IllegalArgumentException();								

		if(!diretorio.exists())
			throw new IllegalArgumentException();
	}

}
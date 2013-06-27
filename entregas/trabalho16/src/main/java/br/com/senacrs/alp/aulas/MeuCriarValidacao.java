package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MeuCriarValidacao implements ObterRequisicaoGet {

	private static final String INDEX_HTML = "index.html";
	private static final String ERROR_404_HTML = "error_404.html";
	private static final String HTTP_1_0_200_OK = "HTTP/1.0 200 OK";
	private static final String HTTP_1_0_404_NOT_FOUND = "HTTP/1.0 404 NotFound";
	private static final String PATH = "/";
	private static final String GET = "GET " + PATH;
	private static final String ESPACO_BRANCO = " ";
	private ArquivoConfiguracao config;


	public MeuCriarValidacao(ArquivoConfiguracao config) {
		this.config = config;
	}

	@Override
	public String[] obterResposta(Reader requisicao) {
		String[] resultado = new String[6];
		String arqDir = null;
		File file = null;
		File error404 = new File(config.getErrorDir() + File.separator + ERROR_404_HTML);
		File index = new File(config.getRootDir() + File.separator + INDEX_HTML);


		try {

			arqDir = obterArqDir(requisicao);



		file = new File(arqDir);

		if((file.exists() && file.isFile())) {

			resultado = obterResposta(HTTP_1_0_200_OK, file);
		}  

		else if(file.isDirectory()){

			resultado = obterResposta(HTTP_1_0_200_OK, index);

		} else {

			resultado = obterResposta(HTTP_1_0_404_NOT_FOUND, error404 );
		}

		} catch (IOException e) {

			throw new IllegalArgumentException(e);
		}

		return resultado;
	}

	private String obterArqDir(Reader requisicao) throws IOException {

		StringBuilder res = new StringBuilder();
		String resultado = null;
		String texto = null;
		int i = requisicao.read();
		Character c;


		while(i != -1){

			c = (char)i;
			res.append(c);
			i = requisicao.read();
		}

		if(res.toString().endsWith(NOVA_LINHA)){

			texto = res.toString();

		} else {

			texto = "erro";
		}


		String[] linhas = texto.split(NOVA_LINHA);

		resultado = testarGet(linhas[0]);

		return resultado;
	}

	private String testarGet(String get) {
		String resultado = null;
		String aux = null;


		if(get.startsWith(GET)){


			aux = get.substring(GET.length());

			String[] res = aux.split(ESPACO_BRANCO);

			resultado = config.getRootDir()+ File.separator + res[0];

		}

		else {

		 resultado = null;

		}
		return resultado;
	}

	private String[] obterResposta(String http, File file) throws IOException {

		String[] resultado = null;
		List<String> parcial = null;
		List<String> conteudo = null;

		resultado = new String[6];
		parcial = new ArrayList<String>();
		parcial.add(http + ObterRequisicaoGet.NOVA_LINHA);
		parcial.add("Date: " + obterDataFormatada() + ObterRequisicaoGet.NOVA_LINHA);
		parcial.add("Server: " + ObterRequisicaoGet.SERVER + ObterRequisicaoGet.NOVA_LINHA);
		parcial.add("Content-Length: " + file.length() + ObterRequisicaoGet.NOVA_LINHA);
		parcial.add("Content-Type: text/html; charset=utf-8" + ObterRequisicaoGet.NOVA_LINHA);
		parcial.add("Connection: close" + ObterRequisicaoGet.NOVA_LINHA);
		parcial.add(ObterRequisicaoGet.NOVA_LINHA);
		conteudo = lerFile(file);
		parcial.addAll(conteudo);
		resultado = new String[parcial.size()];
		resultado = parcial.toArray(resultado);

		return resultado;
	}

	private String obterDataFormatada() {

		Date data = null;
	    DateFormat formatador = null;
	    String resultado = null;

	    data = new Date();

	    formatador = new SimpleDateFormat(
	            "EEE, dd MMM yyyy HH:mm:ss z",
	            Locale.getDefault());
	    formatador.setTimeZone(TimeZone.getTimeZone("GMT"));
	    resultado = formatador.format(data);

	    return resultado;
	}

	private List<String> lerFile(File file) throws IOException {

		List<String> resultado = null;
		Reader in = null;
		BufferedReader reader = null;
		String linha = null;

		resultado = new ArrayList<String>();
		in = new FileReader(file);
		reader = new BufferedReader(in);
		while ((linha = reader.readLine()) != null) {
			resultado.add(linha);
		}
		reader.close();

		return resultado;
	}

}
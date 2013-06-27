package br.com.senacrs.alp.aulas;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class meuCriarValidacao implements ObterCabecalhoRequisicaoGet {

	private ArquivoConfiguracao config;
	private static String PATH = "/";
	private static final String GET = "GET " + PATH;
	private static final String ESPACO_BRANCO = " ";
	private static final String HTTP_1_0_200_OK = "HTTP/1.0 200 OK";
	private static final String ERROR_404_HTML = "error_404.html";
	private static final String INDEX_HTML = "index.html";
	private static final String HTTP_1_0_404_NOT_FOUND = "HTTP/1.0 404 NotFound";


	public meuCriarValidacao(ArquivoConfiguracao config) {
		this.config = config;


	}

	@Override
	public String[] obterCabecalhoResposta(Reader requisicao) {
		String[] resultado = new String[6];
		String arqDir = null;
		File file = null;
		File error404 = new File(config.getErrorDir() + File.separator + ERROR_404_HTML);
		File index = new File(config.getRootDir() + File.separator + INDEX_HTML);


		try {

			arqDir = obterArqDir(requisicao);

		} catch (IOException e) {

			throw new IllegalArgumentException(e);
		}

		file = new File(arqDir);

		if((file.exists() && file.isFile())) {

			resultado = obterResposta(HTTP_1_0_200_OK, file);
		}  

		else if(file.isDirectory()){

			resultado = obterResposta(HTTP_1_0_200_OK, index);

		} else {

			resultado = obterResposta(HTTP_1_0_404_NOT_FOUND, error404 );
		}

		return resultado;
	}

	private String[] obterResposta(String http, File file) {
		String[] resultado = null;

		resultado = new String[6];
		resultado[0] = http + ObterCabecalhoRequisicaoGet.NOVA_LINHA;
		resultado[1] = "Date: " + obterDataFormatada() + ObterCabecalhoRequisicaoGet.NOVA_LINHA;
		resultado[2] = "Server: " + ObterCabecalhoRequisicaoGet.SERVER + ObterCabecalhoRequisicaoGet.NOVA_LINHA;
		resultado[3] = "Content-Length: " + file.length() + ObterCabecalhoRequisicaoGet.NOVA_LINHA;
		resultado[4] = "Content-Type: text/html; charset=utf-8" + ObterCabecalhoRequisicaoGet.NOVA_LINHA;
		resultado[5] = "Connection: close" + ObterCabecalhoRequisicaoGet.NOVA_LINHA;

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

}
package br.com.senacrs.alp.aulas;

import java.io.Reader;

public class MinhaCOP implements ObterPathRequisicaoGet {
	@Override
	public String caminhoAbsoluto(Reader requisicao) {
		if (requisicao == null) {
			throw new IllegalArgumentException();
		}
		return null;
	}
}
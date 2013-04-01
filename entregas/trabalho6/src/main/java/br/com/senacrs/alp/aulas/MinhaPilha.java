package br.com.senacrs.alp.aulas;

public class MinhaPilha<T> extends MinhaLista<T> implements Pilha<T> {

	Lista<T> lista = ListaFactory.getInstancia().criarLista();

	public void insercao(T valor) {
		lista.adicionarInicio(valor);

	}


	public T obter() {
		return lista.obterPosicao(0);
	}


	public T remocao() {

		return lista.removerPosicao(0);
	}


	public boolean vazia() {
		boolean resultado = true;
		if (lista.obterTamanho() > 0) {
			resultado = false;

		}
		return resultado;
	}


	public int tamanho() {
		return lista.obterTamanho();

	}

	public void esvaziar(){
		lista.esvaziar();

	}

}
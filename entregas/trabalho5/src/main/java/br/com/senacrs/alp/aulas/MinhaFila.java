package br.com.senacrs.alp.aulas;

public class MinhaFila<T> extends MinhaLista<T> implements Fila<T> {

	Lista<T> lista = ListaFactory.getInstancia().criarLista();

	public void insercao(T valor) {
		lista.adicionarPosicao(lista.obterTamanho(), valor);
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

	public void esvaziar() {
		lista.esvaziar();
	}

}
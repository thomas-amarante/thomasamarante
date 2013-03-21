package br.com.senacrs.alp.aulas;

public class ListaDeMetodos<T> implements Lista<T> {
	
	private Nodo<T> inicio = new Nodo<T>();
	
	@Override
	public void adicionarFinal(T valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarInicio(T valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarPosicao(int posicao, T valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T obterPrimeiro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T obterUltimo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T obterPosicao(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int obterTamanho() {
		int resultado = 0;

        Nodo<T> nodo = null;
        nodo = inicio;       

        while (nodo.proximo != null) {

            nodo = nodo.proximo;

            resultado++;
        }
		return resultado;
	}

	@Override
	public T removerPosicao(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void esvaziar() {
		// TODO Auto-generated method stub
		
	}

}

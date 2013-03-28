package br.com.senacrs.alp.aulas;

public class MinhaLista<T> implements Lista<T> {

private Nodo<T> inicio = new Nodo<T>();

@Override
public void adicionarFinal(T valor) {

adicionarPosicao(obterTamanho(), valor);

}

@Override
public void adicionarInicio(T valor) {

adicionarPosicao(0, valor);

}

@Override
public void adicionarPosicao(int posicao, T valor) {

Nodo<T> anterior = null;
Nodo<T> novo = null;

if(valor == null){
throw new IllegalArgumentException();
}
if(posicao < 0){
throw new IllegalArgumentException();
}
if(posicao > obterTamanho()){
throw new IllegalArgumentException();
}
novo = new Nodo<T>();
novo.conteudo = valor;
anterior = obterNodoPosicao(posicao -1);
novo.proximo = anterior.proximo;
anterior.proximo = novo;

}

@Override
public T obterPrimeiro() {

return obterPosicao(0);

}

@Override
public T obterUltimo() {

return obterPosicao(obterTamanho()-1);

}

@Override
public T obterPosicao(int posicao) {

Nodo<T> nodo = null;
if(posicao < 0){
throw new IllegalArgumentException();
}
if(posicao >= obterTamanho()){
throw new IllegalArgumentException();
}
nodo = obterNodoPosicao(posicao);
return nodo.conteudo;

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

Nodo<T> nodo = null;
Nodo<T> anterior = new Nodo<T>();
if(posicao < 0){
throw new IllegalArgumentException();
}
if(posicao >= obterTamanho()){
throw new IllegalArgumentException();
}
nodo = obterNodoPosicao(posicao);
anterior = obterNodoPosicao(posicao - 1);
anterior.proximo = nodo.proximo;
nodo.proximo = null;
T resultado = nodo.conteudo;
return resultado;

}

@Override
public void esvaziar() {

inicio.proximo = null;

}

private Nodo<T> obterNodoPosicao(int posicao) {

Nodo<T> resultado = null;
int indice = 0;
resultado = inicio;
indice = -1;
while (indice < posicao) {
resultado = resultado.proximo;
indice++;
}
return resultado;

}

}
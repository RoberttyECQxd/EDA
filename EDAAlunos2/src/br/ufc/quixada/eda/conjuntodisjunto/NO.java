package br.ufc.quixada.eda.conjuntodisjunto;

public class NO {
	
	private int size;
	private int elem;
	private NO prox;
	private NO repres;
	
	public NO(int n, int tamanho){
		elem = n;
		prox = null;
		repres = null;
		size = tamanho;
	}
	public NO inicia(int n, NO representante){
		NO aux = new NO(n, representante.tamanho());	
		repres = representante;
		return aux;
	}
	
	public void insereProx(NO n){
		prox = n;
	}	   	
	
	public NO passaProximo(){
		return prox;
	}
	
	public NO PegarRepresentante(){
		return repres;
	}
	
	public void MudarRepresentante(NO novoRepres){
		repres = novoRepres;
	}
	
	public int mostra(){
		return elem;
    }
	
	public NO pegarUltimo(){
		if(prox.passaProximo() == null) return prox;
		return prox.pegarUltimo();
	}
	
	public int tamanho(){
		return size;
	}
	
	public void alteratamanho(int tam){
		size += tam;
	}
}

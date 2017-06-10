package br.ufc.quixada.eda.splay;

public class Splay<T> {
	private NO<T> raiz = null;
	
	private NO<T> splay(NO<T> raiz, int chave){
		if(raiz == null) return null;
		if(raiz.getChave() == chave) return raiz;
		if(chave < raiz.getChave()){
			if(raiz.getEsq() != null){
				raiz.setEsq(splay(raiz.getEsq(), chave));
				raiz = rotacaosimplesDireita(raiz);
			}
		}else if(chave > raiz.getChave()){
			if(raiz.getDir() != null){
				raiz.setDir(splay(raiz.getDir(), chave));
				raiz = rotacaosimplesEsquerda(raiz);
			}
		}
		return raiz;
	}
	
	public NO<T> busca(int chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz != null && this.raiz.getChave() == chave) return this.raiz;
		return null;
	}
	
	public void inserir(int chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() == chave) return;
		NO<T> aux = new NO<T>(chave);
		aux.setDir(this.raiz);
		aux.setEsq(this.raiz.getEsq());
		this.raiz = aux;
	}
	
	public void remover(int chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() != chave) return;
		NO<T> aux = splay(this.raiz.getEsq(), chave);
		aux.setDir(raiz.getDir());
		raiz = aux;
	}
	
	NO<T> rotacaosimplesDireita(NO<T> no){
		NO<T> aux = no.getEsq();
		no.setEsq(no.getEsq().getDir());
		aux.setDir(no);
		return aux;
	}
	
	NO<T> rotacaosimplesEsquerda(NO<T> no){
		NO<T> aux = no.getDir();
		no.setDir(no.getDir().getEsq());
		aux.setEsq(no);
		return aux;
	}
	
}

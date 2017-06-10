package br.ufc.quixada.eda.splay;

public class NO<T> {
	
	private int chave;
	private NO<T> esq;
	private NO<T> dir;
	private T info;
	
	public NO(int chave){
		this.chave = chave;
		this.esq = null;
		this.dir = null;
	}
	
	public int getChave() {
		return chave;
	}
	
	public void setChave(int chave) {
		this.chave = chave;
	}
	
	public NO<T> getEsq() {
		return esq;
	}
	
	public void setEsq(NO<T> esq) {
		this.esq = esq;
	}
	
	public NO<T> getDir() {
		return dir;
	}
	
	public void setDir(NO<T> dir) {
		this.dir = dir;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
}

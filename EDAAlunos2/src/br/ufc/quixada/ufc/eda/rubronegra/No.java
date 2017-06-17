package br.ufc.quixada.ufc.eda.rubronegra;

public class No<T> {
	private No<T> esq;
	private No<T> dir;
	private int chave;
	private T info;
	private boolean cor;
	public static final boolean PRETO = true;
	public static final boolean VERMELHO = false;
	
	public No(int chave){
		this.chave = chave;
		this.cor = VERMELHO;
	}

	public No<T> getEsq() {
		return esq;
	}

	public void setEsq(No<T> esq) {
		this.esq = esq;
	}

	public No<T> getDir() {
		return dir;
	}

	public void setDir(No<T> dir) {
		this.dir = dir;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
}

package br.ufc.quixada.eda.avl;

public class NOAVL <T> {
	
	private int valor;
	private int altura;
	private NOAVL<T> direito;
	private NOAVL<T> esquerdo;
	private T infor;
	
	public NOAVL(int valor) {
		this.valor = valor;
		this.setAltura(1);
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public NOAVL<T> getDireito() {
		return direito;
	}
	public void setDireito(NOAVL<T> direito) {
		this.direito = direito;
	}
	public NOAVL<T> getEsquerdo() {
		return esquerdo;
	}
	public void setEsquerdo(NOAVL<T> esquerdo) {
		this.esquerdo = esquerdo;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public T getInfor() {
		return infor;
	}

	public void setInfor(T infor) {
		this.infor = infor;
	}
	
}

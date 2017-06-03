package br.ufc.quixada.eda.avl;

public class NOAVL {
	
	private int valor;
	private int altura;
	private NOAVL direito;
	private NOAVL esquerdo;
	
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
	public NOAVL getDireito() {
		return direito;
	}
	public void setDireito(NOAVL direito) {
		this.direito = direito;
	}
	public NOAVL getEsquerdo() {
		return esquerdo;
	}
	public void setEsquerdo(NOAVL esquerdo) {
		this.esquerdo = esquerdo;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
}

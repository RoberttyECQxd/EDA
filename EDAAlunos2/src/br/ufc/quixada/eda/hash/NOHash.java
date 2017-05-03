package br.ufc.quixada.eda.hash;

public class NOHash<T> {
	
	private Integer chave = 0;
	private int proximo = -1;
	private T valor;
	
	public NOHash (Integer chave, T valor){
		this.setChave(chave);
		this.setValor(valor);
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public int getProximo() {
		return proximo;
	}

	public void setProximo(int proximo) {
		this.proximo = proximo;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
}

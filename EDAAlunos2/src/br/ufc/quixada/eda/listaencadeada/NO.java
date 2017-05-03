package br.ufc.quixada.eda.listaencadeada;

public class NO<T> {
	
	private Integer chave = 0;
	private NO<T> proximo = null;
	private T valor;
	
	public NO (Integer chave, T valor){
		this.setChave(chave);
		this.setValor(valor);
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public NO<T> getProximo() {
		return proximo;
	}

	public void setProximo(NO<T> proximo) {
		this.proximo = proximo;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
}

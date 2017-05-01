package br.ufc.quixada.eda.hash;

public class NO {
	
	private Integer chave = 0;
	private NO proximo = null;
	private String valor;
	
	public NO (Integer chave, String valor){
		this.setChave(chave);
		this.setValor(valor);
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public NO getProximo() {
		return proximo;
	}

	public void setProximo(NO proximo) {
		this.proximo = proximo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}

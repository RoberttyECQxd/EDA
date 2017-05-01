package br.ufc.quixada.eda.hash;

public class NOHash {
	
	private Integer chave = 0;
	private int proximo = -1;
	private String valor;
	
	public NOHash (Integer chave, String valor){
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
}

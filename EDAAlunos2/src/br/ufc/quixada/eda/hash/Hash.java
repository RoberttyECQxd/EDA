package br.ufc.quixada.eda.hash;

public abstract class Hash {
	protected Integer m = 0;
	
	protected Hash(int tam){
		m = tam;
	}
	
	protected Integer fHash(Integer chave){
		return (chave % m);
	}
	
	
	protected abstract void inserir (Integer chave, String valor);
	protected abstract String buscar (Integer chave);
	protected abstract String remover (Integer chave);
	
}

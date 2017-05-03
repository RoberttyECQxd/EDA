package br.ufc.quixada.eda.hash;

import br.ufc.quixada.eda.listaencadeada.*;

public class EnderecamentoExterno<T> extends Hash<T> {
	
	private Listaencadeada<T> tabela [] = null;
	private int n = 0;
	
	
	protected EnderecamentoExterno(int tam) {
		super(tam);
		tabela = (Listaencadeada<T>[]) new Listaencadeada[tam];
		for (int i = 0; i < tam; i++) tabela[i] = new Listaencadeada<T>();
	}

	@Override
	protected void inserir(Integer chave, T valor) {
		if(n == m) return;
		int posicao = fHash(chave);
		if(tabela[posicao] == null) tabela[posicao] = new Listaencadeada<T>();
		tabela[posicao].inserir(chave, valor);
		n++;
	}

	@Override
	protected T buscar(Integer chave) {
		int posicao = fHash(chave);
		return tabela[posicao].buscar(chave);
	}

	@Override
	protected T remover(Integer chave) {
		int posicao = fHash(chave);
		n--;
		return tabela[posicao].remover(chave);
	}
	
	public void mostrar(){
		for (int i = 0; i < m; i++){
			System.out.println(i + " :");
			tabela[i].mostrar();
		}
	}

}

package br.ufc.quixada.eda.hash;



public class EnderecamentoExterno extends Hash {
	
	private Listaencadeada tabela [] = null;
	private int n = 0;
	
	protected EnderecamentoExterno(int tam) {
		super(tam);
		tabela = new Listaencadeada[tam];
		for (int i = 0; i < tam; i++) tabela[i] = new Listaencadeada();
	}

	@Override
	protected void inserir(Integer chave, String valor) {
		if(n == m) return;
		int posicao = fHash(chave);
		if(tabela[posicao] == null) tabela[posicao] = new Listaencadeada();
		tabela[posicao].inserir(chave, valor);
		n++;
	}

	@Override
	protected String buscar(Integer chave) {
		int posicao = fHash(chave);
		return tabela[posicao].buscar(chave);
	}

	@Override
	protected String remover(Integer chave) {
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

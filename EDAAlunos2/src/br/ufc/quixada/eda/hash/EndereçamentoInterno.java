package br.ufc.quixada.eda.hash;

public class EndereçamentoInterno<T> extends Hash<T> {
	
	private int p = 0;
	private NOHash<T> vetor[] = null;
	
	protected EndereçamentoInterno(int tam) {
		super(tam);
		p = (int) (tam * 0.7);
		vetor = (NOHash<T>[]) new NOHash[tam];
		for (int i = 0; i < m; i++) vetor[i] = (NOHash<T>) new NOHash(-1, null);
	}
	
	protected Integer fHash(Integer chave){
		return (chave % p);
	}

	@Override
	protected void inserir(Integer chave, T valor) {
		int indice = fHash(chave);
		if(vetor[indice].getChave() == -1){
			vetor[indice].setChave(chave);
			vetor[indice].setValor(valor);
			return;
		}
		int i;
		for (i = p; i < m; i++) if(vetor[i].getChave() == -1) break;
		if(i == m) return;
		vetor[i].setChave(chave);
		vetor[i].setValor(valor);
		while(vetor[indice].getProximo() != -1)
			indice = vetor[indice].getProximo();
		if(indice == m) throw new ErroHash("Erro ao tentar inserir");
		vetor[indice].setProximo(i);
	}

	@Override
	protected T buscar(Integer chave) {
		int indice = fHash(chave);
		while(vetor[indice].getChave() != chave)
			indice = vetor[indice].getProximo();
		return vetor[indice].getValor();
	}

	@Override
	protected T remover(Integer chave) {
		T result = null;
		int indice = fHash(chave);
		if(vetor[indice].getChave() == chave){
			result = vetor[indice].getValor();
			if(vetor[indice].getProximo() != -1){
				int proxIndice = vetor[indice].getProximo();
				vetor[indice].setChave(vetor[proxIndice].getChave());
				vetor[indice].setProximo(vetor[proxIndice].getProximo());
				vetor[indice].setValor(vetor[proxIndice].getValor());
				vetor[proxIndice].setChave(-1);
				vetor[proxIndice].setValor(null);
				vetor[proxIndice].setProximo(-1);
			}else{
				vetor[indice].setChave(-1);
				vetor[indice].setValor(null);
			}
		}else{
			int ant = -1;
			while(vetor[indice].getChave() != chave){
				ant = indice;
				indice = vetor[indice].getProximo();
			}
			vetor[ant].setProximo(vetor[indice].getProximo());
			result = vetor[indice].getValor();
			vetor[indice].setChave(-1);
			vetor[indice].setProximo(-1);
			vetor[indice].setValor(null);
		}
		return result;
	}
	
	public void mostrar(){
		for (int i = 0; i < m; i++)
			System.out.println(i + " " +vetor[i].getChave() + " - " + vetor[i].getValor() + " - " + vetor[i].getProximo());
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("");
	}
}

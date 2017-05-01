package br.ufc.quixada.eda.hash;

public class EndereçamentoInterno1 extends Hash {
	
	private NOHash vetor[] = null;
	
	protected EndereçamentoInterno1(int tam) {
		super(tam);
		vetor = new NOHash[tam];
		for (int i = 0; i < m; i++) vetor[i] = new NOHash(-1, "");
	}
	
	@Override
	protected void inserir(Integer chave, String valor) {
		int indice1 = fHash(chave);
		if(vetor[indice1].getChave() == -1){
			vetor[indice1].setChave(chave);
			vetor[indice1].setValor(valor);
			return;
		}
		int indice = indice1;
		while(vetor[indice].getProximo() != -1)
			indice = vetor[indice].getProximo();
		int i;
		for (i = indice; i < m + indice; i++)
			if(vetor[i % m].getChave() == -1) break;
		if(indice != i % m)
			vetor[indice].setProximo(i % m);
		vetor[i % m].setChave(chave);
		vetor[i % m].setValor(valor);
	}

	@Override
	protected String buscar(Integer chave) {
		int indice = fHash(chave);
		while(vetor[indice].getChave() != chave)
			indice = vetor[indice].getProximo();
		return vetor[indice].getValor();
	}

	@Override
	protected String remover(Integer chave) {
		String result = null;
		int indice = fHash(chave);
		if(vetor[indice].getProximo() == -1){
			result = vetor[indice].getValor();
			vetor[indice].setChave(-1);
			vetor[indice].setValor("");
			return result;
		}
		int ant = -1;
		while(vetor[indice].getChave() != chave){
			ant = indice;
			indice = vetor[indice].getProximo();
		}
		result = vetor[indice].getValor();
		while(indice != -1){
			int IndiceProx = vetor[indice].getProximo();
			if(IndiceProx == -1) break;
			if(fHash(vetor[IndiceProx].getChave()) == IndiceProx){
				if(ant != -1){
					vetor[ant].setProximo(IndiceProx);
					vetor[indice].setChave(-1);
					vetor[indice].setValor("");
					vetor[indice].setProximo(-1);
				}else{
					vetor[indice].setChave(-1);
					vetor[indice].setValor("");
					vetor[indice].setProximo(-1);
				}
			}else{
				vetor[indice].setChave(vetor[IndiceProx].getChave());
				vetor[indice].setValor(vetor[IndiceProx].getValor());
				vetor[indice].setProximo(vetor[IndiceProx].getProximo());
				vetor[IndiceProx].setChave(-1);
				vetor[IndiceProx].setValor("");
				vetor[IndiceProx].setProximo(-1);
			}
			ant = indice;
			indice = vetor[indice].getProximo();
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

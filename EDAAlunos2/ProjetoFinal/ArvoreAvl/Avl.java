package ArvoreAvl;

public class Avl <T extends Comparable<T>, Info> {
	
	private NOAVL<T, Info> raiz;
	
	public void inserir(T value){
		raiz = inserir1(raiz, value);
	}
	
	public Avl(){
		raiz = null;
	}
	
	NOAVL<T, Info> inserir1(NOAVL<T, Info> no, T value){
		if(no == null){
			NOAVL<T, Info> aux = new NOAVL<T, Info>(value);
			return aux;
		}
		int comp = value.compareTo(no.getValor());
		if(comp < 0){
			no.setEsquerdo(inserir1(no.getEsquerdo(), value));
			if((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2){
				if(altura(no.getEsquerdo().getEsquerdo()) > altura(no.getEsquerdo().getDireito())){
					no = rotacaosimplesDireita(no);
				}else{
					no = rotacaoduplaDireita(no);
				}
			}
		}else if(comp > 1){
			no.setDireito(inserir1(no.getDireito(), value));
			if((altura(no.getDireito()) - altura(no.getEsquerdo())) == 2){
				if(altura(no.getDireito().getDireito()) > altura(no.getDireito().getEsquerdo())){
					no = rotacaosimplesEsquerda(no);
				}else{
					no = rotacaoduplaEsquerda(no);
				}
			}
		}
		no.setAltura(((altura(no.getDireito()) > altura(no.getEsquerdo())) ? altura(no.getDireito()) : (altura(no.getEsquerdo()))) + 1);
		return no;
	}
	
	int altura(NOAVL<T, Info> no){
		return (no != null ? no.getAltura() : 0);
	}
	
	NOAVL<T, Info> rotacaosimplesDireita(NOAVL<T, Info> no){
		NOAVL<T, Info> aux = no.getEsquerdo();
		no.setEsquerdo(no.getEsquerdo().getDireito());
		aux.setDireito(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	NOAVL<T, Info> rotacaosimplesEsquerda(NOAVL<T, Info> no){
		NOAVL<T, Info> aux = no.getDireito();
		no.setDireito(no.getDireito().getEsquerdo());
		aux.setEsquerdo(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	NOAVL<T, Info> rotacaoduplaDireita(NOAVL<T, Info> no){
		no.setEsquerdo(rotacaosimplesEsquerda(no.getEsquerdo()));
		no = rotacaosimplesDireita(no);
		return no;
	}
	
	NOAVL<T, Info> rotacaoduplaEsquerda(NOAVL<T, Info> no){
		no.setDireito(rotacaosimplesDireita(no.getDireito()));
		no = rotacaosimplesEsquerda(no);
		return no;
	}
	
	private NOAVL<T, Info> busca1(NOAVL<T, Info> no, T value){
		if(no == null) return null;
		int cmp = value.compareTo(no.getValor());
		if(cmp > 0){
			return busca1(no.getDireito(), value);
		}else if(cmp < 0){
			return busca1(no.getEsquerdo(), value);
		}
		return no;
	}
	
	public NOAVL<T, Info> busca(T value){
		return busca1(raiz, value);
	}
	
	public void remover(T value){
		raiz = remover_recursivo(raiz, value);
	}
	
	NOAVL<T, Info> remover_recursivo(NOAVL<T, Info> no, T value){
		if(no == null)
			return null;
		int cmp = value.compareTo(no.getValor());
		if(cmp == 1){
			no.setDireito(remover_recursivo(no.getDireito(), value));
			if((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2){
				if(altura(no.getEsquerdo().getEsquerdo()) > altura(no.getEsquerdo().getDireito())){
					no = rotacaosimplesDireita(no);
				}else{
					no = rotacaoduplaDireita(no);
				}
			}
		}else if(cmp == -1){
			no.setEsquerdo(remover_recursivo(no.getEsquerdo(), value));
			if((altura(no.getDireito()) - altura(no.getEsquerdo())) == 2){
				if(altura(no.getDireito().getDireito()) > altura(no.getDireito().getEsquerdo())){
					no = rotacaosimplesEsquerda(no);
				}else{
					no = rotacaoduplaEsquerda(no);
				}
			}
		}else{
			if(no.getDireito() == null || no.getEsquerdo() == null){
				if(no.getDireito() == null && no.getDireito() == null)
					return null;
				if(no.getDireito() == null){
					no = no.getEsquerdo();
				}else{
					no = no.getDireito();
				}
			}else{
				NOAVL<T, Info> aux = pegar_menor(no.getDireito());
				no.setValor(aux.getValor());
				no.setDireito(remover_recursivo(no.getDireito(), aux.getValor()));
			}
		}
		no.setAltura(((altura(no.getDireito()) > altura(no.getEsquerdo())) ? altura(no.getDireito()) : (altura(no.getEsquerdo()))) + 1);
		return no;
	}
	
	NOAVL<T, Info> pegar_menor(NOAVL<T, Info> no){
		NOAVL<T, Info> aux = no;
		while(aux.getEsquerdo() != null)
			aux = aux.getEsquerdo();
		return aux;
	}

}

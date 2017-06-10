package br.ufc.quixada.eda.avl;

public class Arvoreavl <T> {
	
	private NOAVL<T> raiz = null;
	
	void inserir(int value){
		raiz = inserir1(raiz, value);
	}
	
	NOAVL<T> inserir1(NOAVL<T> no, int value){
		if(no == null){
			no = new NOAVL<T>(value);
			return no;
		}else if(raiz.getValor() > value){
			no.setEsquerdo(inserir1(no.getEsquerdo(), value));
			if((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2){
				if(altura(no.getEsquerdo().getEsquerdo()) > altura(no.getEsquerdo().getDireito())){
					no = rotacaosimplesDireita(no);
				}else{
					no = rotacaoduplaDireita(no);
				}
			}
		}else if(raiz.getValor() < value){
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
	
	int altura(NOAVL<T> no){
		return (no != null ? no.getAltura() : 0);
	}
	
	NOAVL<T> rotacaosimplesDireita(NOAVL<T> no){
		NOAVL<T> aux = no.getEsquerdo();
		no.setEsquerdo(no.getEsquerdo().getDireito());
		aux.setDireito(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	NOAVL<T> rotacaosimplesEsquerda(NOAVL<T> no){
		NOAVL<T> aux = no.getDireito();
		no.setDireito(no.getDireito().getEsquerdo());
		aux.setEsquerdo(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	NOAVL<T> rotacaoduplaDireita(NOAVL<T> no){
		no.setEsquerdo(rotacaosimplesEsquerda(no));
		no = rotacaosimplesDireita(no);
		return no;
	}
	
	NOAVL<T> rotacaoduplaEsquerda(NOAVL<T> no){
		no.setDireito(rotacaosimplesDireita(no));
		no = rotacaosimplesEsquerda(no);
		return no;
	}
	
	boolean busca1(NOAVL<T> no, int value){
		if(no == null) return false;
		return ((no.getValor() == value) || busca1(no.getDireito(), value) || busca1(no.getEsquerdo(), value));
	}
	
	boolean busca(int value){
		return busca1(raiz, value);
	}
	
	void mostrar1(NOAVL<T> no){
		if(no == null){
			System.out.print(" # ");
			return;
		}
		System.out.print(no.getValor() + " ");
		mostrar1(no.getEsquerdo());
		mostrar1(no.getDireito());
	}
	
	void mostrar(){
		mostrar1(raiz);
	}

}

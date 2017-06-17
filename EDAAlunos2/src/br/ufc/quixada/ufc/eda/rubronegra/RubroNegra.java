package br.ufc.quixada.ufc.eda.rubronegra;

public class RubroNegra<T> {
	
	private No<T> raiz;
	
	public boolean isPreto(No<T> no){
		if(no == null) return true;
		else if(no.isCor() == No.PRETO) return true;
		else return false;
	}
	
	public void add(int chave){
		raiz = add(raiz, chave);
		raiz.setCor(No.PRETO);
	}
	
	public No<T> add(No<T> raiz, int chave){
		if(raiz == null){
			No<T> no = new No<T>(chave);
			return no;
		}
		if(chave < raiz.getChave())
			raiz.setEsq(add(raiz.getEsq(), chave));
		else if(chave > raiz.getChave())
			raiz.setDir(add(raiz.getDir(), chave));
		if(!isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq()))
			recolorar(raiz);
		else if(!isPreto(raiz) && !isPreto(raiz.getDir()))
			raiz = rotacaoEsquerda(raiz);
		else if(isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())){
			raiz = rotacaoDireita(raiz);
			raiz.setCor(No.PRETO);
			raiz.getDir().setCor(No.VERMELHO);
		}else if(!isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getDir().getDir()))
			recolorar(raiz);
		else if(!isPreto(raiz) && !isPreto(raiz.getEsq()))
			raiz = rotacaoDireita(raiz);
		else if(isPreto(raiz.getEsq()) && !isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getDir())){
			raiz = rotacaoEsquerda(raiz);
			raiz.setCor(No.PRETO);
			raiz.getEsq().setCor(No.VERMELHO);
		}
		return raiz;
	}
	
	No<T> rotacaoDireita(No<T> no){
		No<T> aux = no.getEsq();
		no.setEsq(no.getEsq().getDir());
		aux.setDir(no);
		return aux;
	}
	
	public No<T> rotacaoEsquerda(No<T> no){
		No<T> aux = no.getDir();
		no.setDir(no.getDir().getEsq());
		aux.setEsq(no);
		return aux;
	}
	
	public void recolorar(No<T> no){
		no.setCor(No.VERMELHO);
		no.getEsq().setCor(No.PRETO);
		no.getDir().setCor(No.PRETO);
	}
}

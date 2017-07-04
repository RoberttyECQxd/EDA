package ArvoreSplay;


public class Splay <T extends Comparable<T>, Info>{
	private NO<T, Info> raiz = null;
	
	private NO<T, Info> splay(NO<T, Info> raiz, T chave){
		if(raiz == null) return null;
		int cmp = chave.compareTo(raiz.getChave());
		if(cmp == 0) return raiz;
		else if(cmp == 1){
			if(raiz.getEsq() != null){
				raiz.setEsq(splay(raiz.getEsq(), chave));
				raiz = rotacaosimplesDireita(raiz);
			}
			return raiz;
		}else{
			if(raiz.getDir() != null){
				raiz.setDir(splay(raiz.getDir(), chave));
				raiz = rotacaosimplesEsquerda(raiz);
			}
			return raiz;
		}
	}
	
	public NO<T, Info> busca(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz != null && this.raiz.getChave() == chave) return this.raiz;
		return null;
	}

	public void inserir(T chave){
		raiz = splay(raiz, chave);
		if(raiz != null && chave.compareTo(raiz.getChave()) == 0) return;
		if(raiz == null){
			raiz = new NO<T, Info>(chave);
		}else{
			int cmp = chave.compareTo(raiz.getChave());
			if(cmp > 0){
				NO<T, Info> aux = new NO<T, Info>(chave);
				aux.setDir(raiz);
				aux.getDir().setEsq(null);
				aux.setEsq(raiz.getEsq());
				raiz = aux;
			}else{
				NO<T, Info> aux = new NO<T, Info>(chave);
				aux.setEsq(raiz);
				aux.getEsq().setDir(null);
				aux.setDir(raiz.getDir());
				raiz = aux;
			}
		}
	}
	
	NO<T, Info> insert_recursivo(NO<T, Info> no, T chave){
		if(no == null)
			return new NO<T, Info>(chave);
		int cmp = chave.compareTo(no.getChave());
		if(cmp == 1){
			no.setDir(insert_recursivo(no.getDir(), chave));
		}else if(cmp == -1){
			no.setEsq(insert_recursivo(no.getEsq(), chave));
		}
		return no;
	}
	
	
	public void remover(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() != chave) return;
		NO<T, Info> aux = splay(this.raiz.getEsq(), chave);
		if(raiz.getDir() != null && aux != null) aux.setDir(raiz.getDir());
		raiz = aux;
	}
	
	NO<T, Info> rotacaosimplesDireita(NO<T, Info> no){
		NO<T, Info> aux = no.getEsq();
		no.setEsq(no.getEsq().getDir());
		aux.setDir(no);
		return aux;
	}
	
	NO<T, Info> rotacaosimplesEsquerda(NO<T, Info> no){
		NO<T, Info> aux = no.getDir();
		no.setDir(no.getDir().getEsq());
		aux.setEsq(no);
		return aux;
	}
		
}

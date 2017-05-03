package br.ufc.quixada.eda.listaencadeada;

public class Listaencadeada<T> {
	
	protected NO<T> head = null;
	
	public void inserir(int chave, T valor){
		if(head == null) head = new NO<T>(chave, valor);
		else{
			NO<T> aux = GetUltimoNO();
			NO<T> inserir = new NO<T>(chave, valor);
			aux.setProximo(inserir);
		}
	}
	
	public T remover(int chave){
		if(head == null) return null;
		if(head.getChave() == chave) head = head.getProximo();
		NO<T> aux = head;
		while(aux.getProximo() != null &&  aux.getProximo().getChave() != chave) aux = aux.getProximo();
		if(aux.getProximo() == null) return null;
		T result = aux.getProximo().getValor();
		aux.setProximo(aux.getProximo().getProximo());
		return result;
	}
	
	public T buscar(int chave){
		T retorno = null;
		NO<T> aux = head;
		while(aux != null &&  aux.getChave() != chave) aux = aux.getProximo();
		if(aux != null) retorno = aux.getValor();
		return retorno;
	}
	
	private NO<T> GetUltimoNO(){
		NO<T> aux = head;
		while(aux.getProximo() != null) aux = aux.getProximo();
		return aux;
	}
	
	public void mostrar(){
		NO<T> aux = head;
		while(aux != null){
			System.out.println(aux.getChave() + " - " + aux.getValor());
			aux = aux.getProximo();
		}
	}
}

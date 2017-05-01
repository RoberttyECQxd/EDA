package br.ufc.quixada.eda.hash;

public class Listaencadeada {
	
	protected NO head = null;
	
	public void inserir(int chave, String valor){
		if(head == null) head = new NO(chave, valor);
		else{
			NO aux = GetUltimoNO();
			NO inserir = new NO(chave, valor);
			aux.setProximo(inserir);
		}
	}
	
	public String remover(int chave){
		if(head == null) return "";
		if(head.getChave() == chave) head = head.getProximo();
		NO aux = head;
		while(aux.getProximo() != null &&  aux.getProximo().getChave() != chave) aux = aux.getProximo();
		if(aux.getProximo() == null) return "";
		String result = aux.getProximo().getValor();
		aux.setProximo(aux.getProximo().getProximo());
		return result;
	}
	
	public String buscar(int chave){
		String retorno = null;
		NO aux = head;
		while(aux != null &&  aux.getChave() != chave) aux = aux.getProximo();
		if(aux != null) retorno = aux.getValor();
		return retorno;
	}
	
	private NO GetUltimoNO(){
		NO aux = head;
		while(aux.getProximo() != null) aux = aux.getProximo();
		return aux;
	}
	
	public void mostrar(){
		NO aux = head;
		while(aux != null){
			System.out.println(aux.getChave() + " - " + aux.getValor());
			aux = aux.getProximo();
		}
	}
}

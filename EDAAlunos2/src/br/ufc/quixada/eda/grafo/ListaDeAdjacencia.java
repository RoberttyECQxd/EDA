package br.ufc.quixada.eda.grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaDeAdjacencia implements Iterator<Aresta> {
	
	private List<Aresta> lista;
	private int posicao;
	
	public ListaDeAdjacencia(){
		lista = new ArrayList<Aresta>();
		posicao = 0;
	}
	
	public boolean hasNext() {
		return (posicao != lista.size());
	}

	public Aresta next() {
		return lista.get(posicao++);
	}
	
	public void inserir (Aresta a){
		lista.add(a);
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}

}

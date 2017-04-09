package br.ufc.quixada.eda.grafo;

import java.util.ArrayList;

public class Grafo {
	
	private int TotalVertice;
	private ArrayList<Aresta> arestas = null;
	
	public Grafo(int nVertice){
		this.TotalVertice = nVertice;
		setArestas(new ArrayList<Aresta>());
	}
	
	public void AdicionarAresta(Aresta a){
		arestas.add(a);
	}
	
	public void RemoverAresta(Aresta a){
		arestas.remove(arestas.indexOf(a));
	}
	
	public Aresta PegarAresta(int indice){
		return arestas.get(indice);
	}

	public int getTotalVertice() {
		return TotalVertice;
	}

	public void setTotalVertice(int totalVertice) {
		TotalVertice = totalVertice;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}
	
}

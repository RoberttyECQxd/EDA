package br.ufc.quixada.eda.algoritmos;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo1;
import br.ufc.quixada.eda.grafo.ListaDeAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;



public class ProblemaCaminhoMinimo {

	private int pai[] = null;
	private int custo[] = null;
	
	public void AlgoritmoDijkstra(Grafo1 vetor, int origem){
		HeapMinimo heap = new HeapMinimo(vetor.getTotalVertice());
		heap.contruir(custo);
		while(!(heap.vazia())){
			int u = heap.remove() - 1;
			ListaDeAdjacencia lista = vetor.PegarAresta(u);
			while(lista.hasNext()){
				Relaxamento(lista.next(), heap);
			}
		}
	}
	
	public void Relaxamento(Aresta a, HeapMinimo h){
		if(custo[a.getY()] > custo[a.getX()] + a.getPeso()){
			pai[a.getY()] = a.getX();
			custo[a.getY()] = custo[a.getX()] + a.getPeso();
			h.alterarPrioridade(a.getY()+1, custo[a.getY()]);
		}
	}
	
	public ProblemaCaminhoMinimo(Grafo1 vetor, int origem){
		pai = new int[vetor.getTotalVertice()];
		custo = new int[vetor.getTotalVertice()];
		for (int i = 0; i < vetor.getTotalVertice(); i++) {
			custo[i] = Integer.MAX_VALUE;
			pai[i] = -1;
		}
		custo[origem] = 0;
		pai[origem] = origem;
	}
	
	public int imprimirResult(int vertice){
		return custo[vertice];
	}
}

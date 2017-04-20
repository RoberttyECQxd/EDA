package br.ufc.quixada.eda.grafo;


public class Grafo1 {
	
	private int TotalVertice;
	private ListaDeAdjacencia  adjacentes [];
	
	public Grafo1(int nVertice){
		this.TotalVertice = nVertice;
		adjacentes = new ListaDeAdjacencia[nVertice];
		for (int i = 0; i < nVertice; i++)
			adjacentes[i] = new ListaDeAdjacencia();
		
	}

	public void AdicionarAresta(int x, int y, int z){
		Aresta a = new Aresta(x, y, z);
		adjacentes[x].inserir(a);
	}
	
	public int getTotalVertice() {
		return TotalVertice;
	}

	public void setTotalVertice(int totalVertice) {
		TotalVertice = totalVertice;
	}
	
	public ListaDeAdjacencia PegarAresta(int u){
		return adjacentes[u];
	}
	
}

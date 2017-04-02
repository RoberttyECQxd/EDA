package Implementacoes;

public class FlorestaDeConjuntoDisjunto {
	
	private int tamanho = 0;
	private int pai[] = null;
	private int ordem[] = null;
	
	public FlorestaDeConjuntoDisjunto(int tamanho){
		this.pai = new int[tamanho];
		this.ordem = new int[tamanho];
		this.tamanho = tamanho;
	}
	
	
	public void construir(){
		for (int i = 0; i < tamanho; i++)
			Make_set(i);
	}
	
	public void Make_set(int v){
		pai[v] = v;
		ordem[v] = 0;
	}
	
	public int Find_set(int v){
		if(v == pai[v]) return v;
		pai[v] = Find_set(pai[v]);
		return pai[v];
	}
	
	public void Union(int v, int u){
		Link(Find_set(v), Find_set(u));
	}
	
	private void Link(int u, int v){
		if(ordem[v] < ordem[u])
			pai[v] = u;
		else{
			if(ordem[v] == ordem[u]) ordem[v]++;
			pai[u] = v;
		}
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=1; i <= this.tamanho; i++){
			s.append(this.pai[i]);
			s.append(", ");
		}
		
		if (this.tamanho > 0){
			s.append(this.pai[this.tamanho - 1]);
		}
		
		s.append("]");
		
		return s.toString();
	}
}

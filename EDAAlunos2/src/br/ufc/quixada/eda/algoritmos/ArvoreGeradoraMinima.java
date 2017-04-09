package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;

import br.ufc.quixada.eda.conjuntodisjunto.FlorestaDeConjuntoDisjunto;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;

public class ArvoreGeradoraMinima {
	
	
	public ArrayList<Aresta> Kruskal(Grafo g){
		FlorestaDeConjuntoDisjunto f = new FlorestaDeConjuntoDisjunto(g.getTotalVertice());
		f.construir();
		
		quick_sort(g.getArestas(), 0, g.getArestas().size() - 1);
		
		ArrayList<Aresta> result = new ArrayList<Aresta>();
		for (Aresta element : g.getArestas()) {
			if(f.Find_set(element.getX()) != f.Find_set(element.getY())){
				result.add(element);
				f.Union(element.getX(), element.getY());
				if(result.size() == g.getTotalVertice() - 1) return result;
			}
		}
		return result;
	}
	
	public double custo(ArrayList<Aresta> a){
		double result = 0;
		for (int i = 0; i < a.size(); i++)
			result += a.get(i).getPeso();
		return result;
	}
	
	void quick_sort(ArrayList<Aresta> aresta, int ini, int fim){
	    if(ini >= fim) return;

	    int pivo = fim;

	    int i = ini;
	    int j = fim - 1;

	    while(i < j){
	        while(aresta.get(i).getPeso() <=  aresta.get(pivo).getPeso() && j > i){
	            i++;
	        }
	        while(aresta.get(j).getPeso() >= aresta.get(pivo).getPeso() && i < j){
	            j--;
	        }
	        if(aresta.get(i).getPeso() > aresta.get(j).getPeso()){
	           Aresta aux = aresta.get(i);
	           aresta.set(i, aresta.get(j));
	           aresta.set(j, aux);
	        }
	    }
	    if(aresta.get(i).getPeso() > aresta.get(pivo).getPeso()){
	       Aresta aux = aresta.get(i);
	       aresta.set(i, aresta.get(pivo));
	       aresta.set(pivo, aux);
	    }

	    quick_sort(aresta, ini , i);
	    quick_sort(aresta, i+1,fim);

	}
	
}
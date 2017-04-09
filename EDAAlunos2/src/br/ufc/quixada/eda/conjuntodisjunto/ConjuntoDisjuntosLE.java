package br.ufc.quixada.eda.conjuntodisjunto;

import java.util.Vector;


public class ConjuntoDisjuntosLE {
	
	private Vector<NO> nos = null;
	private int tamanho = 0;
	
	public ConjuntoDisjuntosLE(int tamanho){
		nos = new Vector<NO>();
		this.tamanho = tamanho;
	}
	
	public void construir(){
		for (int i = 0; i < tamanho; i++)
			Make_set(i);
	}
	
	public void Make_set(int v){
		NO elemento = new NO(v, 1);
		nos.add(v, elemento);
	}
	
	public int Find_set(int v){
		if(nos.get(v).PegarRepresentante() == null) return nos.get(v).mostra();
		return nos.get(v).PegarRepresentante().mostra();
	}
	
	public void Union(int v, int u){
		if(Find_set(v) != Find_set(u)){
			if(nos.get(v).PegarRepresentante().tamanho() > nos.get(u).PegarRepresentante().tamanho()){
				nos.get(v).PegarRepresentante().pegarUltimo().insereProx(nos.get(u).PegarRepresentante());
				NO aux = nos.get(u).PegarRepresentante();
				while(aux != null){
					aux.MudarRepresentante(nos.get(v).PegarRepresentante());
					aux = aux.passaProximo();
				}
				nos.get(v).PegarRepresentante().alteratamanho(nos.get(u).PegarRepresentante().tamanho());
			}else{
				nos.get(u).PegarRepresentante().pegarUltimo().insereProx(nos.get(v).PegarRepresentante());
				NO aux = nos.get(v).PegarRepresentante();
				while(aux != null){
					aux.MudarRepresentante(nos.get(u).PegarRepresentante());
					aux = aux.passaProximo();
				}
				nos.get(u).PegarRepresentante().alteratamanho(nos.get(v).PegarRepresentante().tamanho());
			}
		}
	}
	
}

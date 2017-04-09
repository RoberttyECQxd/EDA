package br.ufc.quixada.eda.grafo;

public class Aresta {
	
	private int x;
	private int y;
	private int peso;
	
	public Aresta(int x, int y, int peso){
		this.x = x;
		this.y = y;
		this.setPeso(peso);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}

package br.ufc.quixada.eda.testes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.algoritmos.ProblemaCaminhoMinimo;
import br.ufc.quixada.eda.grafo.Grafo1;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteProblemaCaminhoMinimo {
	static List<String> result = new ArrayList<String>(); 

	public static void main(String[] args) {
		
		
		for (int tamanho : CriarInstancia.tamanhoInstancias) {
			for (int i = 0; i < 4; i++) {
				
				String arquivoOperacao = "tb8ch" + tamanho + "_" + i;
				String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes;
				operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				//Grafo1 g = new Grafo1(operacoes.get(0).getX());
				Grafo1 g = new Grafo1(operacoes.size());
				operacoes.remove(0);
				
				for (Operacao operacao : operacoes) {
					g.AdicionarAresta(operacao.getX(), operacao.getY(), operacao.getPeso());
				}
				
				
				ProblemaCaminhoMinimo pcm = new ProblemaCaminhoMinimo(g, i);
//					ArvoreGeradoraMinima a = new ArvoreGeradoraMinima();

//					ArrayList<Aresta> arestas = a.Kruskal(g);
				pcm.AlgoritmoDijkstra(g, i);
				
				
				long tempo = System.currentTimeMillis() - tempoInicial;			  

//					System.out.println(arquivoOperacao + " - " + a.custo(arestas) +" - " + tempo);
				

				
//				for (int x = 0; x < g.getTotalVertice(); x++) {
				System.out.println(arquivoOperacao + " v = " + (g.getTotalVertice()-1) + " - " + pcm.imprimirResult(g.getTotalVertice()-1) +" - " + tempo);
				System.out.println(arquivoOperacao + " v = " + 1 + " - " + pcm.imprimirResult(1) +" - " + tempo);
//					result.add(arquivoOperacao + " vertice = " + x + " custo[ " + pcm.imprimirResult(x) +" ] " + tempo);
//				}
				
				
			}
		}
		gravaTxt();
		System.out.println("fim");
		
//		for (String string : result) {
//			System.out.println(string);
//		}
	}
	

	public static void gravaTxt(){
		File file = new File("resultado2.txt");
		String nome = ""; // só um exemplo, crie todoas as variaveis que são atributos dos objetos do array list
		String conteudo;
 try	{
	        FileWriter f = new FileWriter (file, true);
	        for(int i = 0; i < result.size(); i++){
	        	nome = result.get(i); // chama o atributo do objeto na posição i
                                conteudo = nome;
	        	conteudo += "\r\n";
	        	f.write(conteudo);
	        }
	        f.close();
	    }catch (IOException e)  {
	            e.printStackTrace();
	    }catch (Exception e) {
			e.printStackTrace();  
		}
	}	

	public static void gravaTxt(String a, String b){
		File file = new File(a);
		String nome = ""; // só um exemplo, crie todoas as variaveis que são atributos dos objetos do array list
		String conteudo;
 try	{
	        FileWriter f = new FileWriter (file, true);
	        for(int i = 0; i < result.size(); i++){
	        	nome = result.get(i);conteudo = nome;
	        	conteudo += "\r\n";
	        	f.write(conteudo);
	        }
	        f.close();
	    }catch (IOException e)  {
	            e.printStackTrace();
	    }catch (Exception e) {
			e.printStackTrace();  
		}
	}	
	
}

package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import Ativade1.*;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteListaPrioridadesNOrdenado {
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				String arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				LPMaximaNOrdenada listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
				long tempoInicial = System.currentTimeMillis();				
				
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("A")){
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
					}else if(operacao.getId().equals("S")){
						if(listaPrioridade.getMaximaPrioridade() != operacao.getValor())
							System.out.println("ERRO!");
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("R")){
						if(listaPrioridade.remove() != operacao.getValor())
							System.out.println("ERRO!");
					}
				}	
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
				tempoInicial = System.currentTimeMillis();				
				
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("A")){
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
					}else if(operacao.getId().equals("S")){
						if(listaPrioridade.getMaximaPrioridade() != operacao.getValor())
							System.out.println("ERRO!");
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("R")){
						if(listaPrioridade.remove() != operacao.getValor())
							System.out.println("ERRO!");
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
				
				arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
				tempoInicial = System.currentTimeMillis();				
				
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("A")){
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
					}else if(operacao.getId().equals("S")){
						if(listaPrioridade.getMaximaPrioridade() != operacao.getValor())
							System.out.println("ERRO!");
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("R")){
						if(listaPrioridade.remove() != operacao.getValor())
							System.out.println("ERRO!");
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
				
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				listaPrioridade = new LPMaximaNOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
				tempoInicial = System.currentTimeMillis();				
				
				for (Operacao operacao : operacoes) {
					if(operacao.getId().equals("A")){
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
					}else if(operacao.getId().equals("S")){
						if(listaPrioridade.getMaximaPrioridade() != operacao.getValor())
							System.out.println("ERRO!");
					}else if(operacao.getId().equals("I")){
						listaPrioridade.inserir(operacao.getValor());
					}else if(operacao.getId().equals("R")){
						if(listaPrioridade.remove() != operacao.getValor())
							System.out.println("ERRO!");
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

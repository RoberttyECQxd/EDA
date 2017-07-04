package Testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ArvoreSplay.Splay;
import Dados.Empresa;
import Util.EDAConstants;
import Util.EDAUtil;

public class TesteComputacionalSplay1 {
	public static void main(String args[]){		
		try {
			System.out.println("Arvore Splay");
			String arquivoOperacao = "empresas";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Empresa> empresas = EDAUtil.getOperacoes(path);
			List<Empresa> buscados = new ArrayList<Empresa>();
			Splay<Empresa, Empresa> s = new Splay<Empresa, Empresa>();
			long tempoInicial = System.currentTimeMillis();				
			int taxa = (int) (empresas.size() * 0.2);
			for (int i = 1; i <= empresas.size(); i++) {
				s.inserir(empresas.get(i - 1));
				if(i % taxa == 0){
					for (int j = 0; j < i * 0.3; j++) {
						Random rand = new Random();
						Empresa e = empresas.get(rand.nextInt(i));
						buscados.add(e);
						s.busca(e);
					}
					for (int j = 0; j < i * 0.1; j++) {
						Random rand = new Random();
						s.remover(buscados.remove(rand.nextInt(buscados.size())));
					}
				}
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo total: " + tempo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

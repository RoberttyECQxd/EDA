package Testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ArvoreAvl.Avl;
import Dados.Empresa;
import Util.EDAConstants;
import Util.EDAUtil;

public class TesteComputacionalAvl1 {
	public static void main(String args[]){		
		try {
			System.out.println("Arvore Avl");
			String arquivoOperacao = "empresas";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Empresa> empresas = EDAUtil.getOperacoes(path);
			List<Empresa> buscados = new ArrayList<Empresa>();
			Avl<Empresa, Empresa> av = new Avl<Empresa, Empresa>();
			long tempoInicial = System.currentTimeMillis();				
			int taxa = (int) (empresas.size() * 0.2);
			for (int i = 1; i <= empresas.size(); i++) {
				av.inserir(empresas.get(i - 1));
				if(i % taxa == 0){
					for (int j = 0; j < i * 0.3; j++) {
						Random rand = new Random();
						Empresa e = empresas.get(rand.nextInt(i));
						buscados.add(e);
						av.busca(e);
					}
					for (int j = 0; j < i * 0.1; j++) {
						Random rand = new Random();
						av.remover(buscados.remove(rand.nextInt(buscados.size())));
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

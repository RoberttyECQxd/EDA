package Testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ArvoreSplay.Splay;
import Dados.Empresa;
import Util.EDAConstants;
import Util.EDAUtil;

public class TesteComputacionalSplay {
	public static void main(String args[]){		
		try {
			System.out.println("Arvore Splay");
			String arquivoOperacao = "empresas";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Empresa> empresas = EDAUtil.getOperacoes(path);
			List<Empresa> buscados = new ArrayList<Empresa>();
			Splay<Empresa, Empresa> s = new Splay<Empresa, Empresa>();
			long tempoInicial = System.currentTimeMillis();
			for (Empresa empresa : empresas) {
				s.inserir(empresa);
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de insercao: " + tempo);
			
			tempoInicial = System.currentTimeMillis();
			int tam = empresas.size();
			for (int i = 0; i < tam * 0.3; i++) {
				Random rand = new Random();
				Empresa e = empresas.get(rand.nextInt(tam));
				buscados.add(e);
				s.busca(e);
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de busca: " + tempo);
			
			tempoInicial = System.currentTimeMillis();
			for (int i = 0; i < tam * 0.3; i++) {
				Random rand = new Random();
				s.remover(buscados.remove(rand.nextInt(buscados.size())));
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de remorcao: " + tempo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

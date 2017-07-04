package Util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Dados.*;
public class EDAUtil {
	
	public static List<Empresa> getOperacoes(String path) throws IOException {
        List<Empresa> operacoes = new ArrayList<Empresa>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");	
        int k = 0;
		while (scanner.hasNext()){
			try{
				k++;
				operacoes.add(new Empresa(scanner.next().substring(5), scanner.next().substring(5), scanner.next().substring(12), scanner.next().substring(13), scanner.next().substring(5), scanner.next().substring(6), scanner.next().substring(4), scanner.next().substring(4), scanner.next().substring(7), scanner.next().substring(7), scanner.next().substring(7), scanner.next().substring(7), scanner.next().substring(9), scanner.next().substring(8)));
			}catch(Exception ex){
				ex.printStackTrace();
				System.out.println(k);
			}
		}
		scanner.close();
        return operacoes;
    }    
}

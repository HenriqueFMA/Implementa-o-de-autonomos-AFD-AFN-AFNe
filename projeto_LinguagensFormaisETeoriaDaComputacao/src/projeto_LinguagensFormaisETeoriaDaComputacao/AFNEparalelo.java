package projeto_LinguagensFormaisETeoriaDaComputacao;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//Q={q0,q1,q2}
//q0=q0
//F=q0
//alfabeto={0,1,2}

//       0    |  1
//->q0 {q0,q1}  {q0}
//  q1   {}     {q2}
// *q2   {}     {}

//010  aceita
//111 n aceita


public class AFNEparalelo {
	static int [][][] transicao= {{{1},{},{}},
		                       	{{},{2},{2}},
		                       	{{},{},{}}};
	public static int[][] transicaoVazia= {{},{0},{0}};
	static int estadoInicial=0;
	static int []aceitacao= {0};
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		String cadeia;
		
		System.out.println("Informe uma cadeia :");
		cadeia= leitor.nextLine();
		int posicao=0;
		int[] estados= eclose(new int[]{estadoInicial});
		
		
		while(posicao<cadeia.length()) {
			imprimeCI(cadeia,estados,posicao);
			int[] novosEstados= new int[] {};
			int elemento= Integer.parseInt(cadeia.substring(posicao, posicao+1));
			for(int i :estados) {
				int[] destinoTransicao= transicao[i][elemento];
				novosEstados=uniao(novosEstados, destinoTransicao);
				novosEstados=eclose(novosEstados);
			}
			estados=novosEstados;
			if(estados.length==0)break;
			posicao++;
		}
		imprimeCI(cadeia,estados,posicao);

		
		
		if(aceita(estados)) {
			System.out.println("aceita");
		}else {System.out.println("Não aceita");}
		
		
		
		
		
	}

	
	


	public static int[] uniao(int[] estados, int[] novosEstados) {
	    Set<Integer> uniao = new TreeSet<>();
	    for (int i : estados) uniao.add(i);
	    for (int i : novosEstados) uniao.add(i);
	    int[] ret = new int[uniao.size()];
	    int j = 0;
	    for (int i : uniao) ret[j++] = i;
	    return ret;
	}





public static void imprimeCI(String cadeia,int[] estado,int posicao) {
		
		System.out.print(cadeia.substring(0, posicao)+"{");
		for(int i=0;i<estado.length;i++) {
			System.out.print("q"+estado[i]);
			if(i<estado.length-1) {
				System.out.print(",");
			
		}
		System.out.println("}"+cadeia.substring(posicao));
		
		
		}
	}


	


public  static boolean aceita(int [] estados) {
	if (estados==null) return false;
	for(int i:estados) {
		for(int j :aceitacao) {
			if(i==j) {
				return true;
			}
		}
	}
	return false;
}
public static int[] eclose(int[] estados) {
	int[] eclose=estados;
	for(int i:estados) {
		int[] ecloseAux=transicaoVazia[i];
		int[] ecloseAux2=eclose(ecloseAux);
		eclose=uniao(eclose,ecloseAux);
		eclose=uniao(eclose,ecloseAux2);
	}
	
	return eclose;
}
}


package projeto_LinguagensFormaisETeoriaDaComputacao;

import java.util.Scanner;

///////////////(AFD)/////////////

public class AFDgenerico {
	static int [][] transicao= {{0,1} ,{1,0} };
	static int estadoInicial=0;
	static int []aceitacao= {1};
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		int posicao =0,estado=estadoInicial;
		char simbulo;
		String cadeia;
		
		System.out.println("Informe uma cadeia :");
		cadeia= leitor.nextLine();
		
		
		while(posicao<cadeia.length()) {
			imprimeCI(cadeia,estado,posicao);
			simbulo=cadeia.charAt(posicao);
			int simbuloInt=Integer.parseInt(simbulo+"");
			estado= transicao[estado][simbuloInt];
			
			posicao++;
			
		}
		imprimeCI(cadeia,estado,posicao);
		boolean aceita=false;
		for(int i:aceitacao) {
			if(estado==i) aceita=true;
		}
		if(estado==1) {
			System.out.println("Aceita");
		}else if(estado==0){
			System.out.println("Não aceita");
			
		}
		
	}
	
	public static void imprimeCI(String cadeia,int estado,int posicao) {
		
		System.out.print(cadeia.substring(0, posicao));
		System.out.print("[q"+estado+"]");
		System.out.println(cadeia.substring(posicao));
		
		
		
	}

}

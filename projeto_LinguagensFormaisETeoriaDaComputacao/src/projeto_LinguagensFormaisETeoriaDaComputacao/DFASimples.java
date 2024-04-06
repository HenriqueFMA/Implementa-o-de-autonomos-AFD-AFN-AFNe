package projeto_LinguagensFormaisETeoriaDaComputacao;

import java.util.Scanner;


//Q= {q0,q1}
//q0=q0
//f=q1
//   0 | 1
//q0 q0  q1
//q1 q1  q0

//alfabeto(0,1)

//100 aceita
//101 n aceita

public class DFASimples {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		int posicao =0,estado=0;
		char simbulo;
		String cadeia;
		
		System.out.println("Informe uma cadeia :");
		cadeia= leitor.nextLine();
		
		
		while(posicao<cadeia.length()) {
			imprimeCI(cadeia,estado,posicao);
			simbulo=cadeia.charAt(posicao);
			if(estado==0 && simbulo=='0'){
				estado=0;
			}else if(estado==0 && simbulo=='1') {
				estado=1;
			}else if(estado==1 && simbulo=='0') {
				estado=1;
			}else if(estado==1 && simbulo=='1') {
				estado=0;
			}
			posicao++;
			
		}
		imprimeCI(cadeia,estado,posicao);
		
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

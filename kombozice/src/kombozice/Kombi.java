package kombozice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kombi extends Posto {
	
	//kilometragem = new double[];
	
		String nomeDaKombosa;
		
		protected boolean tamanhoVetorNecessario = true, refreshAindaNãoClicado = true;
		
		protected int tamanhoVetores = 50, contadorKombi = 0;
		//protected int kilometroNovo = 55696; ????
		
		protected double km_litro = 6.5;
		protected double combustivelTanque = 3;
		protected double varKilometro =0,varGasolina =0;
		
		

		
		protected double[] GasolinaNoTanque = new double[tamanhoVetores];
		protected double[] GasolinaNoTanqueAntes = new double[tamanhoVetores];
		
		protected int[] kilometragem = new int[tamanhoVetores];
		
		protected double[] variacaoGasolinaNoTanque = new double[tamanhoVetores];
		protected int[] variacaokilometragem = new int[tamanhoVetores];
		
		//initialize vectors
		
		protected void inicializacaoVetoresKombi() {
			contadorKombi = 0;
			for(int i = 0; i < tamanhoVetores-3; i++) {
				GasolinaNoTanque[i]=0;
				GasolinaNoTanqueAntes[i]=0;
				kilometragem[i]=0;
				variacaoGasolinaNoTanque[i] = 0;
				variacaokilometragem[i]=0;
			}
		}
		
		
		
		
		protected void lerKilometragem(){
			
			try{
				
				Scanner  x = new Scanner(new File("kilometragem.txt"));
				
				for(int i = 0; i < tamanhoVetores -1; i++) {				
					
					if(x.hasNextInt()) {
						kilometragem[i] = x.nextInt();
						contadorKombi = i;
					}				

				}
				
				x.close();

				
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
			
		}
		
		protected void lerGasolinaNoTanque(){
			{
				try {

						Scanner  x = new Scanner(new File("GasolinaNoTanqueDepois.txt"));
						Scanner y = new Scanner(new File("GasolinaNoTanqueAntes.txt"));

						for(int j = 0; j < GasolinaNoTanque.length - 1; j++) {
							if(x.hasNext()) {
								GasolinaNoTanque[j] = x.nextDouble();
								//System.out.println("gasolinanotanque " + GasolinaNoTanque[j] + " j "+ j);
							}
							if(y.hasNext()) {
								GasolinaNoTanqueAntes[j] = y.nextDouble();
								//System.out.println("gasolinanotanqueantes " + GasolinaNoTanqueAntes[j] + " j "+ j);
							}
						}

						x.close();
						y.close();

				}catch (FileNotFoundException e){
					e.printStackTrace();
				}
			}
		}
	
		protected void lerDadosKombi() {
			inicializacaoVetoresKombi();
			lerKilometragem();
			lerGasolinaNoTanque();
		}
		
		protected void definirN() {
			for(int i = 0 ; i < tamanhoVetores-1; i++) {
				System.out.println("valor de kilometragem[" +i +"] = " + kilometragem[i]);
				if(kilometragem[i] != 0){
					//System.out.println("k e g diferente de zero com [" + i + "]" );
				} else {
					contadorKombi = i; //não sei como mas sai o contadorKombi sem precisar colocar o i + 1
					System.out.println("\nk e g vazios (=0) no  tamanhoVetores[" + i +"] e contadorKombi recebe " + i);
					return;
				}
			}
		}
		
		protected void calcular_km_litro() {
			double sumGasolina = 0, sumGasolinaVsKilometragem = 0, sumGasolina2 = 0, m = 0, buro=0;
			int sumKilometragem = 0;
			//System.out.println("valor de tam vetor " + tamanhoVetores);
			
			definirN();
			
		
			
			//varicacao
			//System.out.println();		
			for(int i = 0; i < tamanhoVetores-3; i++) {
				if(kilometragem[i+1] != 0 && GasolinaNoTanque[i] !=0) {
					variacaoGasolinaNoTanque[i] = GasolinaNoTanque[i] - GasolinaNoTanqueAntes[i+1];
					variacaokilometragem[i] = kilometragem[i+1] - kilometragem[i];
					
				} 
				
			}
			
			
			
			//sum
			//System.out.println();		
			for(int i = 0; i < tamanhoVetores-3;i++) {
				if(kilometragem[i+1] != 0 && GasolinaNoTanque[i] !=0) {
					sumGasolina = sumGasolina + variacaoGasolinaNoTanque[i];
					sumKilometragem = sumKilometragem +  variacaokilometragem[i];
					buro = (double) variacaokilometragem[i];
					sumGasolinaVsKilometragem = sumGasolinaVsKilometragem + buro * variacaoGasolinaNoTanque[i];
					sumGasolina2 = sumGasolina2 + variacaoGasolinaNoTanque[i]*variacaoGasolinaNoTanque[i];


				}

			}
			
			m = (contadorKombi * sumGasolinaVsKilometragem - sumGasolina * sumKilometragem) / (contadorKombi*sumGasolina2 - sumGasolina*sumGasolina) ;
			
			//System.out.println("valor de m é " + m);
			
			km_litro = m;
		}
		
		protected void calcularVariacaoTanque(int kilometroNovo,int n) {
			
			System.out.println("quem é n = " + n);
			
			kilometragem[n] = kilometroNovo;

			double buro = (double) kilometroNovo;
			//definirN();
			//System.out.println("valor de [contadorKombi] e [contadorKombi -1] "+ contadorKombi + " " + (contadorKombi-1));
			
			GasolinaNoTanque[n] = GasolinaNoTanque[n-1]-(buro - kilometragem[n-1])/km_litro;
			
		}
		
		protected void calcVarTanque2(int kilometroNovo, int n) {
			
			kilometragem[n] = kilometroNovo;
			double buro = (double) kilometroNovo;			
			GasolinaNoTanque[n] = ((double)valorAbastecimentoNovo)/precoGasolinaNovo + GasolinaNoTanque[n-2]-(buro - kilometragem[n-2])/km_litro;
			

		}
		
		protected void inserirValorTanque(int kilometroNovo){

			
			{
				try
				{
					PrintWriter pr = new PrintWriter("file.txt");    

					for (int i=0; i < tamanhoVetores; i++){
						if(kilometragem[i] != 0) {
							pr.println(GasolinaNoTanque[i]);
						}
						
					}
					
					pr.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println("No such file exists.");
				}
			}
			
		}
		
		protected void inserirValorKilometragem() {
			{
				try
				{
					PrintWriter pr = new PrintWriter("ktest.txt");    

					for (int i=0; i< tamanhoVetores-1; i++){
						if(kilometragem[i] != 0) {
							pr.println(kilometragem[i] + " i = " + i);
						}
					}
					
					pr.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println("No such file exists.");
				}
			}
			
		}
			
		
		
		
		protected void variarTanque(int kilometroNovo){
			

			
			//System.out.println("\nTamanho do vetor = " + tamanhoVetores);
			calcular_km_litro();
			
			inserirValorTanque(kilometroNovo);
			inserirValorKilometragem();
			
			//System.out.println("valor de contadorKombi é " + contadorKombi);
			
			if(kilometragem[contadorKombi] != 0 && GasolinaNoTanque[contadorKombi] !=0) {

				/*
				System.out.println("\no valor de kilometragem[" + 
						(kilometragem.length - 2) + 
						"] e de gasolina[" +
						(GasolinaNoTanque.length -2) +
						"] não são zero"
				);
				*/
			}
			
			for(int i = 0;i < tamanhoVetores; i++) {
				if(kilometragem[i] != 0 && GasolinaNoTanque[i] !=0) {
					/*
					System.out.println("[" + i + "] \tkilometragem " +
							kilometragem[i] +
							"\tgasolina no tanque = "+
							GasolinaNoTanque[i]
					);
					*/
				}else {
					System.out.println("para i = " + i + " os vetores estão vazios kilometragem = " + kilometragem[i]);
				}
				
			}

			
		}


		
		protected void variarKilometragem(int kilometroNovo) {
			calcularVariacaoTanque(kilometroNovo,contadorKombi);
			
			inserirValorKilometragem();
			inserirValorTanque(kilometroNovo);
			
		}


}
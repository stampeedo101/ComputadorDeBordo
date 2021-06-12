package kombozice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Kombi extends Posto {

	//kilometragem = new double[];
	
	String nomeDaKombosa;
	
	protected boolean tamanhoVetorNecessario = true;
	
	int tamanhoVetores = 50, n = 0;
	protected int kilometroNovo = 55696;
	
	protected double km_litro = 6.5;
	protected double combustivelTanque = 3;
	

	
	protected double[] GasolinaNoTanque = new double[tamanhoVetores];
	protected double[] GasolinaNoTanqueAntes = new double[tamanhoVetores];
	
	protected int[] kilometragem = new int[tamanhoVetores];
	
	protected double[] variacaoGasolinaNoTanque = new double[tamanhoVetores];
	protected int[] variacaokilometragem = new int[tamanhoVetores];
	
	//initialize vectors
	
	protected void inicializacaoVetores() {
		for(int i = 0; i < tamanhoVetores-3; i++) {
			GasolinaNoTanque[i]=0;
			GasolinaNoTanqueAntes[i]=0;
			kilometragem[i]=0;
			variacaoGasolinaNoTanque[i] = 0;
			variacaokilometragem[i]=0;
		}
	}
	
	/*
	protected  void verificarTamanhoVetor() {
		//System.out.println("essa é a kilometragem[tamanhovetor-2] " + kilometragem[tamanhoVetores-2]);
		for(int i = tamanhoVetores; i > tamanhoVetores/2;i--) {
			if(kilometragem[tamanhoVetores-1] != 0) {
				if(i-tamanhoVetores <2) {
					tamanhoVetores = tamanhoVetores+2;
					i=0;
					
				}
			}
		}
	}
	*/

	/*
	protected void variarTanque() {
		System.out.println(" " + kilometragem + " ");

		try {
			FileWriter myWriter = new FileWriter("kilometragem.txt");
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	 */

	
	protected void lerKilometragem(){
		
		try{
			
			Scanner  x = new Scanner(new File("kilometragem.txt"));
			
			for(int i = 0; i < tamanhoVetores -1; i++) {				
				
				if(x.hasNextInt()) {
					kilometragem[i] = x.nextInt();
					System.out.println("kilometragem " + kilometragem[i] + " i "+ i);
				}				

			}
			
			x.close();


			/*
			for(int i = 0; i<kilometragem.length; i++) {
				System.out.println(" " + kilometragem[i] + " com i = " + i); 
			}
			*/
			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	protected void lerGasolinaNoTanque(){
		{
			try {
				
				//System.out.println("essa é pra gasolina");	

					Scanner  x = new Scanner(new File("GasolinaNoTanqueDepois.txt"));
					Scanner y = new Scanner(new File("GasolinaNoTanqueAntes.txt"));

					for(int j = 0; j < GasolinaNoTanque.length - 1; j++) {
						if(x.hasNext()) {
							GasolinaNoTanque[j] = x.nextDouble();
							System.out.println("gasolinanotanque " + GasolinaNoTanque[j] + " j "+ j);
						}
						if(y.hasNext()) {
							GasolinaNoTanqueAntes[j] = y.nextDouble();
							System.out.println("gasolinanotanqueantes " + GasolinaNoTanqueAntes[j] + " j "+ j);
						}
					}

					x.close();
					y.close();

				


				/*
				for(int i = 0; i<GasolinaNoTanque.length; i++) {
					System.out.println(" " + GasolinaNoTanque[i] + " com i = " + i); 
				}
				*/

			}catch (FileNotFoundException e){
				e.printStackTrace();
			}
		}
	}
	
	protected void definirN() {
		for(int i = 0 ; i < tamanhoVetores-1; i++) {
			System.out.println("valor de kilometragem[" +i +"] = " + kilometragem[i]);
			if(kilometragem[i] != 0){
				//System.out.println("k e g diferente de zero com [" + i + "]" );
			} else {
				n = i; //não sei como mas sai o n sem precisar colocar o i + 1
				System.out.println("\nk e g vazios (=0) no  tamanhoVetores[" + i +"] e n recebe " + i);
				return;
			}
		}
	}
	
	protected void calcular_km_litro() {
		double sumGasolina = 0, sumGasolinaVsKilometragem = 0, sumGasolina2 = 0, m = 0, buro=0;
		int sumKilometragem = 0;
		System.out.println("valor de tam vetor " + tamanhoVetores);
		
		definirN();
		
		/*
		//mostrar gasolina tanque		
		System.out.println();		
		for(int i = 0; i < tamanhoVetores-1; i++) {
			System.out.println("[" + i + "] \tgasTanque " +
								GasolinaNoTanque[i] +
								"\tgasAntes " +
								GasolinaNoTanqueAntes[i]
			);
		}
		*/
		
		
		//varicacao
		System.out.println();		
		for(int i = 0; i < tamanhoVetores-3; i++) {
			if(kilometragem[i+1] != 0 && GasolinaNoTanque[i] !=0) {
				variacaoGasolinaNoTanque[i] = GasolinaNoTanque[i] - GasolinaNoTanqueAntes[i+1];
				variacaokilometragem[i] = kilometragem[i+1] - kilometragem[i];
				
				/* MOSTRAR VAR
				System.out.println("[" + i + "] \tvariacaoKilo " + 
									variacaokilometragem[i] +
									"\tvariacaoGas " +
									variacaoGasolinaNoTanque[i]
				);
				*/
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

				/*
				System.out.println("["+ i + 
						"] \tsumGas " + sumGasolina + 
						"\tsumKilo " + sumKilometragem + 
						" \tSgk " + sumGasolinaVsKilometragem
						);
				*/
			}

		}
		
		/* RESUMIR SUM
		System.out.println();
		
		System.out.println("\nsG " + sumGasolina + 
							" sK " + sumKilometragem + 
							" SgK " + sumGasolinaVsKilometragem);
		
		*/
		
		//System.out.println("valor de kilometragem -1 " + kilometragem[kilometragem.length-1]);
		
		//calulo de coeficiente angular
		/*
		while(kilometragem[(kilometragem.length-2)] == 0) {
			b = kilometragem.length -2;
		}
		
		System.out.println("valor de b " + b);
		*/
		m = (n * sumGasolinaVsKilometragem - sumGasolina * sumKilometragem) / (n*sumGasolina2 - sumGasolina*sumGasolina) ;
		
		System.out.println("valor de m é " + m);
		
		km_litro = m;
	}
	
	protected void calcularVariacaoTanque() {
		
		kilometragem[n] = kilometroNovo;

		double buro = (double) kilometroNovo;
		//definirN();
		System.out.println("valor de [n] e [n -1] "+ n + " " + (n-1));
		
		GasolinaNoTanque[n] = GasolinaNoTanque[n-1]-(buro - kilometragem[n-1])/km_litro;
		
		System.out.println("\nvalor de gasolina [" + n + "] = "+ GasolinaNoTanque[n]+
							" e o valor de kilometragem [" + n + "] = " + kilometragem[n]
		);

		
	}
	
	protected void inserirValorTanque(){
		
		calcularVariacaoTanque();
		
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
				PrintWriter pr = new PrintWriter("fileK.txt");    

				for (int i=0; i< tamanhoVetores-1; i++){
					if(kilometragem[i] != 0) {
						pr.println(kilometragem[i]);
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
		
	
	
	
	protected void variarTanque(){
		
		inicializacaoVetores();	

		
		lerKilometragem();
		lerGasolinaNoTanque();
		
		System.out.println("\nTamanho do vetor = " + tamanhoVetores);
		calcular_km_litro();
		
		inserirValorTanque();
		inserirValorKilometragem();
		
		//System.out.println("valor de n é " + n);
		
		if(kilometragem[n] != 0 && GasolinaNoTanque[n] !=0) {
			System.out.println();
			System.out.println("o valor de kilometragem[" + 
					(kilometragem.length - 2) + 
					"] e de gasolina[" +
					(GasolinaNoTanque.length -2) +
					"] não são zero");
		}
		
		System.out.println();
		for(int i = 0;i < tamanhoVetores; i++) {
			if(kilometragem[i] != 0 && GasolinaNoTanque[i] !=0) {
				System.out.println("[" + i + "] \tkilometragem " +
						kilometragem[i] +
						"\tgasolina no tanque = "+
						GasolinaNoTanque[i]
						);
			}else {
				System.out.println("para i = " + i + " os vetores estão vazios kilometragem = " + kilometragem[i]);
			}
			
		}

		
	}

	protected void inserirViaInterface() {
		
	}
	
	protected void variarKilometragem() {
		inserirViaInterface();
		calcularVariacaoTanque();
		inserirValorKilometragem();
		
	}

	void desenharDiagramaTanque(){
		System.out.println();
	}
	

}
   /*
  
      double tanque = 20;
	    
	    if(tanque <= 10) {
	    	tanquePanel.setBackground(Color.red);
	    } else if(tanque > 10 && tanque <= 20) {
	    	tanquePanel.setBackground(Color.orange);
	    } else if(tanque > 20 && tanque < 30) {
	    	tanquePanel.setBackground(Color.green);
	    } else if(tanque > 20 && tanque < 40) {
	    	tanquePanel.setBackground(Color.blue);
	    }
  
    */
	

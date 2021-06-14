package kombozice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Posto extends AbastecimentoSpinner{
	//kilometragem	Status tanque	Novo abastecimento mudar kilometragem e status tanque

	String[] siglasPosto = new String[]{"brC","brM","Outro"};

	byte tamanhoDosVetoresPosto = 50, nPosto=0;

	String[] siglaDoPosto = new String[tamanhoDosVetoresPosto];

	double[] precoGasolina = new double[tamanhoDosVetoresPosto];
	
	
	int[] valorAbastecimento = new int[tamanhoDosVetoresPosto];
	int[] diaAbastecimento = new int[tamanhoDosVetoresPosto];
	int[] mesAbastecimento = new int[tamanhoDosVetoresPosto];
	int[] anoAbastecimento = new int[tamanhoDosVetoresPosto];

	//initialize vectors

	protected void inicializacaoVetores() {
		for(int i = 0; i < tamanhoDosVetoresPosto-3; i++) {
			diaAbastecimento[i]=0;
			mesAbastecimento[i]=0;
			anoAbastecimento[i]=0;
			precoGasolina[i] = 0;
			valorAbastecimento[i]=0;
			siglaDoPosto[i] = "null";
		}
	}

	protected void lerDoubleInserirArquivoTxt(int contador, double[] doubleValues, String arquivo){
		System.out.println();

		try{

			Scanner  x = new Scanner(new File(arquivo));

			for(byte i = 0; i < contador -1; i++) {				

				if(x.hasNextDouble()) {
					doubleValues[i] = x.nextDouble()/1000;
					nPosto = i;
					System.out.println("valores de double" + arquivo + " " + doubleValues[i] + " i "+ i + " O nPosto é " + nPosto);
				}				

			}

			x.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}
	
	protected void lerByteInserirArquivoTxt(int contador, int[] doubleValues, String arquivo){
		
		System.out.println();

		try{

			Scanner  x = new Scanner(new File(arquivo));

			for(int i = 0; i < contador -1; i++) {				

				if(x.hasNextInt()) {
					doubleValues[i] = x.nextInt();
					System.out.println("valores no arquivo " + arquivo + " " + doubleValues[i] + " i "+ i);
				}				

			}

			x.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}
	
	protected void lerSiglaDoPosto(){
		System.out.println();

		try{

			Scanner  x = new Scanner(new File("siglaPosto.txt"));

			for(int i = 0; i < tamanhoDosVetoresPosto -1; i++) {				

				if(x.hasNext()) {
					siglaDoPosto[i] = x.next();
					System.out.println("siglaDoPosto " + siglaDoPosto[i] + " i "+ i);
				}				

			}

			x.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}
	
	protected void inserirByteArquivoTxt(String fileName, int[] numeros, int tamanhoVetor){		
		
		{
			try
			{
				PrintWriter pr = new PrintWriter(fileName);    

				for (int i=0; i < tamanhoVetor; i++){
					if(numeros[i] != 0) {
						pr.println(numeros[i]);
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
	
	protected void inserirDoubleArquivoTxt(String fileName, double[] numeros, int tamanhoVetor){		
		
		{
			try
			{
				PrintWriter pr = new PrintWriter(fileName);    

				for (int i=0; i < tamanhoVetor; i++){
					if(numeros[i] != 0) {
						pr.println(numeros[i]);
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
	
	protected void lerDadoPosto() {
		
		lerDoubleInserirArquivoTxt(tamanhoDosVetoresPosto, precoGasolina, "precoGasolina.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto, valorAbastecimento, "valorAbastecimento.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto, diaAbastecimento, "diaAbastecimento.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto, mesAbastecimento, "mesAbastecimento.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto,anoAbastecimento, "anoAbastecimento.txt");
		
		lerSiglaDoPosto();
	}
	
	protected void inserirNovosDadosTxT() {
		if(valorAbastecimentoNovo != 0) {
			precoGasolina[nPosto + 1] = precoGasolinaNovo;
			valorAbastecimento[nPosto + 1] = valorAbastecimentoNovo;
			diaAbastecimento[nPosto + 1] = diaAbastecimentoNovo;
			mesAbastecimento[nPosto + 1] = mesAbastecimentoNovo;
			anoAbastecimento[nPosto + 1] = anoAbastecimentoNovo;
			
			inserirDoubleArquivoTxt("precoGasolinaNovo.txt", precoGasolina,tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("vAbastNovo.txt", valorAbastecimento,tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("diaAbastNovo.txt", diaAbastecimento, tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("mesAbastNovo.txt", mesAbastecimento, tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("anoAbastNovo.txt", anoAbastecimento, tamanhoDosVetoresPosto);
		}
		
	}
	

}
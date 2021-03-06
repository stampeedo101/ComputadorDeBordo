package kombozice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Posto{
	//kilometragem	Status tanque	Novo abastecimento mudar kilometragem e status tanque
	
	int valorAbastecimentoNovo=0, diaAbastecimentoNovo=1, mesAbastecimentoNovo=1, anoAbastecimentoNovo=21;
	
	
	double precoGasolinaNovo=0;

	String[] valoresSiglasPosto = new String[]{"brC","brM","Outro"};

	byte tamanhoDosVetoresPosto = 120, contadorPosto=0;

	String[] siglaDoPosto = new String[tamanhoDosVetoresPosto];

	double[] precoGasolina = new double[tamanhoDosVetoresPosto];
	
	
	int[] valorAbastecimento = new int[tamanhoDosVetoresPosto];
	int[] diaAbastecimento = new int[tamanhoDosVetoresPosto];
	int[] mesAbastecimento = new int[tamanhoDosVetoresPosto];
	int[] anoAbastecimento = new int[tamanhoDosVetoresPosto];

	//initialize vectors

	protected void inicializacaoVetoresPosto() {
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
					contadorPosto = i;
					//System.out.println("valores de double" + arquivo + " " + doubleValues[i] + " i "+ i + " O contadorPosto é " + contadorPosto);
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
					//System.out.println("valores no arquivo " + arquivo + " " + doubleValues[i] + " i "+ i);
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
					//System.out.println("siglaDoPosto " + siglaDoPosto[i] + " i "+ i);
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
	
	protected void inserirSiglasPostoTXT(String fileName, String[] siglas, int tamanhoVetor){
		{
			try
			{
				PrintWriter pr = new PrintWriter(fileName);    

				for (int i = 0 ; i < tamanhoVetor -5; i++){
					
					if(!(siglas[i].contentEquals("null"))) {
						//System.out.println("entrou no loop, ou seja, (if = true) com i = " + i + " com string = " + siglas[i]);
						pr.println(siglas[i] + " i = " + i);
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
		
		inicializacaoVetoresPosto();
		
		lerDoubleInserirArquivoTxt(tamanhoDosVetoresPosto, precoGasolina, "precoGasolina.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto, valorAbastecimento, "valorAbastecimento.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto, diaAbastecimento, "diaAbastecimento.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto, mesAbastecimento, "mesAbastecimento.txt");

		lerByteInserirArquivoTxt(tamanhoDosVetoresPosto,anoAbastecimento, "anoAbastecimento.txt");
		
		lerSiglaDoPosto();
	}
	
	protected void inserirNovoAbstecimentoTxT() {

		if(precoGasolina[contadorPosto] != 0) {
			
			precoGasolina[contadorPosto + 1] = precoGasolinaNovo;
			valorAbastecimento[contadorPosto + 1] = valorAbastecimentoNovo;
			diaAbastecimento[contadorPosto + 1] = diaAbastecimentoNovo;
			mesAbastecimento[contadorPosto + 1] = mesAbastecimentoNovo;
			anoAbastecimento[contadorPosto + 1] = anoAbastecimentoNovo;
			
			inserirDoubleArquivoTxt("precoGasolinaNovo.txt", precoGasolina,tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("vAbastNovo.txt", valorAbastecimento,tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("diaAbastNovo.txt", diaAbastecimento, tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("mesAbastNovo.txt", mesAbastecimento, tamanhoDosVetoresPosto);
			inserirByteArquivoTxt("anoAbastNovo.txt", anoAbastecimento, tamanhoDosVetoresPosto);
			
			inserirSiglasPostoTXT("siglasNovas.txt", siglaDoPosto, tamanhoDosVetoresPosto);
		}
		
	}
	

}
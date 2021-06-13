package kombozice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Posto extends AbastecimentoSpinner{
	//kilometragem	Status tanque	Novo abastecimento mudar kilometragem e status tanque

	String[] siglasPosto = new String[]{"brC","brM","Outro"};

	byte tamanhoDosVetoresPosto = 50;

	String[] siglaDoPosto = new String[tamanhoDosVetoresPosto];

	double[] precoGasolina = new double[tamanhoDosVetoresPosto];
	
	
	byte[] valorAbastecimento = new byte[tamanhoDosVetoresPosto];
	byte[] diaAbastecimento = new byte[tamanhoDosVetoresPosto];
	byte[] mesAbastecimento = new byte[tamanhoDosVetoresPosto];
	byte[] anoAbastecimento = new byte[tamanhoDosVetoresPosto];

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

	protected void lerDoubleInserirArquivoTxt(byte contador, double[] doubleValues, String arquivo){
		System.out.println();

		try{

			Scanner  x = new Scanner(new File(arquivo));

			for(int i = 0; i < contador -1; i++) {				

				if(x.hasNextDouble()) {
					doubleValues[i] = x.nextDouble()/1000;
					System.out.println("valores de double" + arquivo + " " + doubleValues[i] + " i "+ i);
				}				

			}

			x.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}
	
	protected void lerByteInserirArquivoTxt(byte contador, byte[] doubleValues, String arquivo){
		
		System.out.println();

		try{

			Scanner  x = new Scanner(new File(arquivo));

			for(int i = 0; i < contador -1; i++) {				

				if(x.hasNextByte()) {
					doubleValues[i] = x.nextByte();
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
	
	protected void inserirByteArquivoTxt(String fileName, byte[] numeros, byte tamanhoVetor){		
		
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
	
	

}
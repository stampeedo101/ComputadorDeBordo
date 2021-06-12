package kombozice;

public class ComputadorDeBordo extends FrameGuide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double j = 15;
		double valorGasolina = 5.399, consumo = 6.5;
		int kilometragem = 12345, diaAbastecimento = 5, mesAbastecimento = 7, valorAbastecimento = 50;
		
		ComputadorDeBordo comp00zero = new ComputadorDeBordo();
		
		//comp00zero.criarPanelKILOMETRAGEM();
		comp00zero.variarTanque();
		
		//double gas, double valorGasolina, int diaAbastecimento, int mesAbastecimento, double valorAbastecimetnto, double consumo
		comp00zero.criarCompFramePrincipal(kilometragem,comp00zero.GasolinaNoTanque[comp00zero.n],valorGasolina,diaAbastecimento,mesAbastecimento,valorAbastecimento,consumo);
		
		comp00zero.nomeDaKombosa = "Kombosa do Rabujento";
		
		System.out.println("\nA " + comp00zero.nomeDaKombosa + 
							" já rodou " + comp00zero.kilometragem[comp00zero.n] +
							" kilometros.\nTem " +
							comp00zero.GasolinaNoTanque[comp00zero.n] +
							" de litros de gasolina no Tanque.\nE faz " +
							comp00zero.km_litro +
							" kilometros por litro."
		);
			
		/*
		if(comp00zero.GasolinaNoTanque[comp00zero.n] >= 0 && comp00zero.GasolinaNoTanque[comp00zero.n] <= 10) {
  			System.out.println("vermelho");
  		}else if(comp00zero.GasolinaNoTanque[comp00zero.n] > 10 && comp00zero.GasolinaNoTanque[comp00zero.n] <= 20){
  			System.out.println("\n\n\norange com gas = " + comp00zero.GasolinaNoTanque[comp00zero.n]);		
  		}else if(comp00zero.GasolinaNoTanque[comp00zero.n] > 20 && comp00zero.GasolinaNoTanque[comp00zero.n] <= 30){
  			System.out.println("green");	
  		}else if(comp00zero.GasolinaNoTanque[comp00zero.n] > 30 && comp00zero.GasolinaNoTanque[comp00zero.n] <= 40){
  			System.out.println("blue");	
  		}
  		*/	
		
		//comp00zero.kdirei = new String("asdfasdf"); POR QUE VC NAO VE OS OBJETOS DENTRO DAS CLASSES ESTENDIDAS
		
		/* comp00zero EXTENDS
		comp00zero.variarTanque();
		
		System.out.println("\n[" + comp00zero.n +"] o valor de \tkilometragem = " + 
							comp00zero.kilometragem[comp00zero.n-1] +
							" km Quantidade de gasolina no tanque = " 
				);
		*/

	}

}

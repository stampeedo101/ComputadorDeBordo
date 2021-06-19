package kombozice;

public class ComputadorDeBordo extends FrameGuide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		

		//double j = 15;
		double valorGasolina = 5.399, consumo = 6.5;
		int kilometragem = 55696, diaAbastecimento = 5, mesAbastecimento = 7, valorAbastecimento = 50;

		ComputadorDeBordo comp00zero = new ComputadorDeBordo();

		//comp00zero.criarPanelKILOMETRAGEM();
		comp00zero.lerDadosKombi();
		comp00zero.variarTanque(kilometragem);

		//double gas, double valorGasolina, int diaAbastecimento, int mesAbastecimento, double valorAbastecimetnto, double consumo
		comp00zero.criarCompFramePrincipal(kilometragem,comp00zero.GasolinaNoTanque[comp00zero.n],valorGasolina,diaAbastecimento,mesAbastecimento,valorAbastecimento,consumo);

		comp00zero.nomeDaKombosa = "Kombi";

		



		if(comp00zero.kilometragemNovaEntrou) {
			System.out.println("\no valor de kilometragem nova é " + comp00zero.kilometragemNova);
		}



		//comp00zero.kdirei = new String("asdfasdf"); POR QUE VC NAO VE OS OBJETOS DENTRO DAS CLASSES ESTENDIDAS

		/* comp00zero EXTENDS
				comp00zero.variarTanque();

				System.out.println("\n[" + comp00zero.n +"] o valor de \tkilometragem = " + 
									comp00zero.kilometragem[comp00zero.n-1] +
									" km Quantidade de gasolina no tanque = " 
						);
		 */

		//ler datas,precos ..., referentes ao posto
		comp00zero.lerDadoPosto();

		System.out.println("\n\n\nO valor de precoGasolina é " + comp00zero.precoGasolina[0] +
				" E o valor do abastecimento é " + comp00zero.valorAbastecimento[0] +
				" E o valor do ano é 20" + comp00zero.anoAbastecimento[0] + 
				" E a sigla do posto 0 é " + comp00zero.siglaDoPosto[0]
				);



	}




}
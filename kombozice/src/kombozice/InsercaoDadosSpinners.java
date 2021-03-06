package kombozice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;


public class InsercaoDadosSpinners extends Kombi {



	String siglaPostoNovo = "null";
	String preenchimentoSpinners = "null";
	String precoGasolinaFormatado = "null";

	double precoGasolinaNovo = 0;

	int kilometragemNova = 0;
	
	byte espacoVertical = 10,tamanhoPanel = 40,tamanhoSpinner = 60;
	byte centenaMilhar = 0, dezenaMilhar = 0, milhar=0,centena=0,dezena=0,unidade=0;

	int valorAbastecimentoNovo = 0, diaAbastecimentoNovo=1, mesAbastecimentoNovo=1, anoAbastecimentoNovo=20;
	
	boolean kilometragemInseridaApenas = false, botaoAbastecimentoClicado = false;
	
	protected String devolverprecoGasolinaTxT(double precoGasolina) {
		
		String precoGasolinaFormatado = String.valueOf(precoGasolina);

		String esquerda = new String();
		String direita = new String();
		
		//System.out.println("Dentro do método valor de preco = " + precoGasolinaFormatado);
		
		if((precoGasolinaFormatado.charAt(1)) != '.') {
			System.out.println("Corre que o mundo vai acabar o preço da gasolina chegou aos dois digitos!!!!!!! " + precoGasolinaFormatado);
		}else {
			esquerda = "" + precoGasolinaFormatado.charAt(0);
		}
		
		
		
		for(int i = precoGasolinaFormatado.length() - 3; i < precoGasolinaFormatado.length();i++) {
			direita = direita + precoGasolinaFormatado.charAt(i);
		}
		
		precoGasolinaFormatado = esquerda + "," + direita;
		
		//System.out.println("Dentro do método valor de preco = " + precoGasolinaFormatado);
		
		return (esquerda + "," + direita);
	}
	
	protected void descobrirPrecoGasolina(double precoGasolina){
		

		String precoGasolinaFormatado = String.valueOf(precoGasolina);

		String esquerda = new String();
		String direita = new String();
		
		
		//System.out.println("valor de 5 = " + Character.getNumericValue(5) + " valor de 6 = " + Character.getNumericValue(6));
		for(int i = 0; i<precoGasolinaFormatado.length();i++) {
			System.out.println("valor de precogasolinaformatado(" + i + ") = " + Character.getNumericValue(precoGasolinaFormatado.charAt(i)));
		}
		
		
		
	}
	
	protected void descobrirNumerosSpinner(int kilometragem) {
		
		int resto = 0;

		//CENTENA DE MILHAR
		if( (kilometragem > 99999) && (kilometragem < 200000)) {
			centenaMilhar = 1;
			resto = 100000;
		}

		for(int i = 1; i<9;i++) {
			if( (kilometragem > 99999 + (i*100000) ) && (kilometragem < ((i+1)*100000) ) ){
				centenaMilhar = (byte)(i + 1);
				resto = 100000*i;
			}

		}

		//DEZENA DE MILHAR
		
		if( (kilometragem - resto > 9999) && (kilometragem - resto < 20000)) {
			dezenaMilhar = 1;
		}

		for(int i = 1; i<9;i++) {
			if( (kilometragem - resto > 9999 + (i*10000)) && (kilometragem - resto < ((i+2)*10000) )) {
				dezenaMilhar = (byte)(i + 1);
			}
		}
		
		//MILHAR
		resto = centenaMilhar*100000 + dezenaMilhar*10000;
		
		if( (kilometragem -resto > 999) && (kilometragem-resto  < 2000)) {
			milhar = 1;
		}

		for(int i = 1; i<9;i++) {
			if( (kilometragem-resto  > 999 + (i*1000)) && (kilometragem-resto  < ((i+2)*1000) )) {
				milhar = (byte)(i + 1);
			}
		}
		
		//CENTENA
		resto = centenaMilhar*100000 + dezenaMilhar*10000 + milhar*1000;
		
		if( (kilometragem -resto > 99) && (kilometragem -resto < 200)) {
			centena = 1;
		}

		for(int i = 1; i<9;i++) {
			if( (kilometragem - resto > 99 + (i*100)) && (kilometragem -resto < ((i+2)*100) )) {
				centena = (byte)(i + 1);
			}
		}
		
		//DEZENA
		resto = centenaMilhar*100000 + dezenaMilhar*10000 + milhar*1000 + centena*100;
		
		if( (kilometragem -resto > 9) && (kilometragem -resto < 20)) {
			dezena = 1;
		}

		for(int i = 1; i<9;i++) {
			if( (kilometragem -resto > 9 + (i*10)) && (kilometragem -resto < ((i+2)*10) )) {
				dezena = (byte)(i + 1);
			}
		}
		
		//UNIDADE
		resto = centenaMilhar*100000 + dezenaMilhar*10000 + milhar*1000 + centena*100 + dezena*10;

		for(int i = 0; i<10;i++) {
			if( kilometragem - resto == i ) {
				unidade = (byte)(i);
			}
		}
		
	}
	
	protected void pegarEvariarkilometragem(int cm,int dm, int um, int c, int d , int u) {
		
		kilometragemNova = 
				cm*100*1000 +
				dm*10*1000 + 
				um*1000 + 
				c*100 + 
				d*10 +
				u 
				;
		
		variarKilometragem(kilometragemNova);
		
		contadorKombi = contadorKombi + 1;
		
		kilometragemInseridaApenas = true;
	}
	
	protected void pegarEvariarAbastecimento() {
		
	}

	protected void criarSpinnerAbastecimento() {

		JFrame f = new JFrame("Abastecimento de Combustível");

		f.setSize(720,4*tamanhoSpinner+4*tamanhoPanel+8*espacoVertical);
		f.getContentPane().setBackground(Color.decode("#FFF88F"));
		//3*tamanhoSpinner+3*tamanhoPanel+7*espacoVertical
		
		//SET NEW VARIABLES
		
		System.out.println(	"contador kombi  = " + contadorKombi +
							"\ncontador Posto = " + contadorPosto
							);
		
		descobrirNumerosSpinner(kilometragem[contadorKombi-1]);
		

		//INSERIR KILOMETRAGEM

		JPanel firstPanel = new JPanel();

		firstPanel.setBackground(Color.decode("#3F1D03"));
		firstPanel.setBounds(espacoVertical, espacoVertical, 700, tamanhoPanel);

		JLabel firstLabel = new JLabel();
		firstLabel.setBackground(Color.decode("#3F1D03"));
		firstLabel.setText("Kilometragem");
		firstLabel.setForeground(Color.decode("#20F400"));
		firstLabel.setFont(new Font("Monospace",Font.PLAIN,tamanhoPanel/2));
		firstLabel.setVerticalAlignment(JLabel.CENTER);
		firstLabel.setHorizontalAlignment(JLabel.CENTER);

		SpinnerModel kilometragemSpinnerValue0 =  
				new SpinnerNumberModel(dezenaMilhar, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel kilometragemSpinnerValue1 =  
				new SpinnerNumberModel(milhar, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel kilometragemSpinnerValue2 =  
				new SpinnerNumberModel(centena, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel kilometragemSpinnerValue3 =  
				new SpinnerNumberModel(dezena, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel kilometragemSpinnerValue4 =  
				new SpinnerNumberModel(unidade, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner kilometragemSpinner0 = new JSpinner(kilometragemSpinnerValue0);

		kilometragemSpinner0.setBounds((720-280)/2-50,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);

		kilometragemSpinner0.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(kilometragemSpinner0);


		JSpinner kilometragemSpinner1 = new JSpinner(kilometragemSpinnerValue1);

		kilometragemSpinner1.setBounds((720-280)/2 + 2*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		kilometragemSpinner1.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(kilometragemSpinner1);

		JSpinner kilometragemSpinner2 = new JSpinner(kilometragemSpinnerValue2);

		kilometragemSpinner2.setBounds((720-280)/2 + tamanhoSpinner + 3*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		kilometragemSpinner2.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(kilometragemSpinner2);

		JSpinner kilometragemSpinner3 = new JSpinner(kilometragemSpinnerValue3);

		kilometragemSpinner3.setBounds((720-280)/2 + 2*tamanhoSpinner+ 4*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		kilometragemSpinner3.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(kilometragemSpinner3);

		JSpinner kilometragemSpinner4 = new JSpinner(kilometragemSpinnerValue4);

		kilometragemSpinner4.setBounds((720-280)/2 + 3*tamanhoSpinner + 5*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		kilometragemSpinner4.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(kilometragemSpinner4);

		// (720-280)/2 = 360-190=170

		JButton insertKilometragemButton = new JButton();

		insertKilometragemButton.setText("INSERIR");
		insertKilometragemButton.setBackground(Color.decode("#3E67E8"));
		insertKilometragemButton.setForeground(Color.decode("#FFFFFF"));
		insertKilometragemButton.setFont(new Font("Monospace",Font.PLAIN,20));
		insertKilometragemButton.setBounds((720-280)/2 + 5*tamanhoSpinner + 5*espacoVertical,2*espacoVertical+tamanhoPanel, 120, tamanhoSpinner);
		f.add(insertKilometragemButton);
		
		/*
		System.out.println(	"\nEntrou no spinner:" +
				"\nkilometragem [" + (contadorKombi-1) + 
				"] = " + kilometragem[contadorKombi-1] +
				"\nkilometragem [" + contadorKombi +
				"] = " + kilometragem[contadorKombi] +
				" \nkilometragem[" + (contadorKombi+1) +
				"] = " + kilometragem[contadorKombi+1]+
				"\nkilometragemNova = " + kilometragemNova
);*/

		
		//BOTÃO INSERIR KILOMETRAGEM ------------------------------------------------------------------------------------------------------------
		
		insertKilometragemButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				pegarEvariarkilometragem(
						0,
						((Integer)kilometragemSpinner0.getValue()),
						(Integer)kilometragemSpinner1.getValue(),
						(Integer)kilometragemSpinner2.getValue(),
						(Integer)kilometragemSpinner3.getValue(),
						(Integer)kilometragemSpinner4.getValue())
				;


/*
				kilometragemNova =  
						((Integer)kilometragemSpinner0.getValue())*10*1000 + 
						((Integer)kilometragemSpinner1.getValue())*1000 + 
						((Integer)kilometragemSpinner2.getValue())*100 + 
						((Integer)kilometragemSpinner3.getValue())*10 +
						((Integer)kilometragemSpinner4.getValue()) 
						;
						
		
				System.out.println(	"\ndepois botao:" +
						"\nkilometragem [" + (contadorKombi-1) + 
						"] = " + kilometragem[contadorKombi-1] +
						"\nkilometragem [" + contadorKombi +
						"] = " + kilometragem[contadorKombi] +
						" \nkilometragem[" + (contadorKombi+1) +
						"] = " + kilometragem[contadorKombi+1]+
						"\nkilometragemNova = " + kilometragemNova
	); 
				
				//System.out.println("\nN antes do +1 = " + contadorKombi);
				
				variarKilometragem(kilometragemNova);
				
				
				System.out.println(	"\nDepois do metdodo:" +
						"\nkilometragem [" + (contadorKombi-1) + 
						"] = " + kilometragem[contadorKombi-1] +
						"\nkilometragem [" + contadorKombi +
						"] = " + kilometragem[contadorKombi] +
						" \nkilometragem[" + (contadorKombi+1) +
						"] = " + kilometragem[contadorKombi+1]+
						"\nkilometragemNova = " + kilometragemNova +
						"\n gasolina ["+ (contadorKombi-1) + 
						"] = " + GasolinaNoTanque[contadorKombi-1] +
						"\n gasolina [" + contadorKombi +
						"] = " + GasolinaNoTanque[contadorKombi] +
						" \n gasolina[" + (contadorKombi+1) +
						"] = " + GasolinaNoTanque[contadorKombi+1]
	);
				
				
				contadorKombi = contadorKombi + 1;
				
				//variarKilometragem(kilometragemNova);
				
				System.out.println(	"\nSomente a kilometragem foi modificada com:" +
									"\nkilometragem [" + (contadorKombi-1) + 
									"] = " + kilometragem[contadorKombi-1] +
									"\nkilometragem [" + contadorKombi +
									"] = " + kilometragem[contadorKombi] +
									" \nkilometragem[" + (contadorKombi+1) +
									"] = " + kilometragem[contadorKombi+1]+
									"\nkilometragemNova = " + kilometragemNova
				);
				
				
				kilometragemInseridaApenas = true;
				
				*/

				f.setState(Frame.ICONIFIED);
			}
		});

		//BOTÃO INSERIR KILOMETRAGEM ------------------------------------------------------------------------------------------------------------



		//INSERIR POSTO

		JPanel postoPanel = new JPanel();

		postoPanel.setBackground(Color.decode("#3F1D03"));
		postoPanel.setBounds(espacoVertical, tamanhoSpinner+tamanhoPanel+3*espacoVertical, 700, tamanhoPanel);

		JLabel postoLabel = new JLabel();

		postoLabel.setBackground(Color.decode("#3F1D03"));
		postoLabel.setText("Sigla do posto:                       Valor da Gasolina:");
		postoLabel.setForeground(Color.decode("#20F400"));
		postoLabel.setFont(new Font("Monospace",Font.PLAIN,tamanhoPanel/2));
		postoLabel.setVerticalAlignment(JLabel.CENTER);
		postoLabel.setHorizontalAlignment(JLabel.CENTER);

		SpinnerListModel listaSiglasPosto = new SpinnerListModel(new String[] { "BrC","BrM", "outro" });

		JSpinner SiglasPosto = new JSpinner(listaSiglasPosto);

		SiglasPosto.setBounds(espacoVertical, tamanhoSpinner + 2 * tamanhoPanel+4*espacoVertical,2*tamanhoSpinner,tamanhoSpinner);

		SiglasPosto.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner/2));

		f.add(SiglasPosto);
		//INSERIR POSTO



		//INSERIR VALOR GASOLINA
		
		System.out.println("\n\n\nprecogasolina [" + contadorPosto + "] = " + precoGasolina[contadorPosto] + "\n\n\n");

		precoGasolinaFormatado = "" + precoGasolina[contadorPosto];
		
		System.out.println("precogasolinaformatada = " + precoGasolinaFormatado + " contadorPosto" + contadorPosto);
		
		SpinnerModel gasolinaSpinnerValue0 =  
				new SpinnerNumberModel(Character.getNumericValue(precoGasolinaFormatado.charAt(0)), //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolinaSpinner0 = new JSpinner(gasolinaSpinnerValue0);

		gasolinaSpinner0.setBounds(6*tamanhoSpinner,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolinaSpinner0.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolinaSpinner0);

		SpinnerModel gasolinaSpinnerValue1 =  
				new SpinnerNumberModel(Character.getNumericValue(precoGasolinaFormatado.charAt(2)), //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolinaSpinner1 = new JSpinner(gasolinaSpinnerValue1);

		gasolinaSpinner1.setBounds(6*tamanhoSpinner+tamanhoSpinner+espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolinaSpinner1.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolinaSpinner1);

		SpinnerModel gasolinaSpinnerValue2 =  
				new SpinnerNumberModel(Character.getNumericValue(precoGasolinaFormatado.charAt(3)), //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolinaSpinner2 = new JSpinner(gasolinaSpinnerValue2);

		gasolinaSpinner2.setBounds(6*tamanhoSpinner+2*tamanhoSpinner+2*espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolinaSpinner2.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolinaSpinner2);

		SpinnerModel gasolinaSpinnerValue3 =  
				new SpinnerNumberModel(Character.getNumericValue(precoGasolinaFormatado.charAt(4)), //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolinaSpinner3 = new JSpinner(gasolinaSpinnerValue3);

		gasolinaSpinner3.setBounds(6*tamanhoSpinner+3*tamanhoSpinner+3*espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolinaSpinner3.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolinaSpinner3);

		//INSERIR VALO GASOLINA


		//INSERIR DATA ABASTECIMENTO

		JPanel valorAbastecimentoPanel = new JPanel();

		valorAbastecimentoPanel.setBackground(Color.decode("#3F1D03"));
		valorAbastecimentoPanel.setBounds(espacoVertical,2*tamanhoSpinner+2*tamanhoPanel+5*espacoVertical, 700, tamanhoPanel);


		JLabel valorAbastecimentoLabel = new JLabel();

		valorAbastecimentoLabel.setBackground(Color.decode("#3F1D03"));
		valorAbastecimentoLabel.setText("Abastecimento (R$):                                     data:            ");
		valorAbastecimentoLabel.setForeground(Color.decode("#20F400"));
		valorAbastecimentoLabel.setFont(new Font("Monospace",Font.PLAIN,tamanhoPanel/2));
		valorAbastecimentoLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		valorAbastecimentoLabel.setVerticalAlignment(JLabel.CENTER);
		valorAbastecimentoLabel.setHorizontalAlignment(10);

		SpinnerModel abastecimentoValue =  
				new SpinnerNumberModel(50, //initial value  
						10, //minimum value  
						300, //maximum value  
						10); //step

		JSpinner valorAbastecimentoSpinner = new JSpinner(abastecimentoValue);

		valorAbastecimentoSpinner.setBounds(espacoVertical,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,2*tamanhoSpinner,tamanhoSpinner);

		valorAbastecimentoSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(valorAbastecimentoSpinner);

		//INSERIR VALOR ABASTECIMENTO

		
				
		//DATA SPINNER

		/*
		for(int i = contadorPosto-2; i < (contadorPosto+2);i++) {
			System.out.println("dia[" + i + "] = " + diaAbastecimento[i] +
								"\nmes[" + i +"] = " + mesAbastecimento[i]+
								"\nano[" + i +"] = " + anoAbastecimento[i]+
								"\tcontadorPosot = " + contadorPosto);
		}
		*/
		
		SpinnerModel diaDataValue =  
				new SpinnerNumberModel(diaAbastecimento[contadorPosto], //initial value  
						1, //minimum value  
						30, //maximum value  
						1); //step

		JSpinner diaDataSpinner = new JSpinner(diaDataValue);

		diaDataSpinner.setBounds(7*tamanhoSpinner,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,3*espacoVertical+tamanhoSpinner,tamanhoSpinner);

		diaDataSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(diaDataSpinner);



		SpinnerModel mesDataValue =  
				new SpinnerNumberModel(mesAbastecimento[contadorPosto], //initial value  
						1, //minimum value  
						12, //maximum value  
						1); //step

		JSpinner mesDataSpinner = new JSpinner(mesDataValue);

		mesDataSpinner.setBounds(8*tamanhoSpinner+4*espacoVertical,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,3*espacoVertical+tamanhoSpinner,tamanhoSpinner);

		mesDataSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(mesDataSpinner);



		SpinnerModel anoDataValue =  
				new SpinnerNumberModel(anoAbastecimento[contadorPosto], //initial value  
						21, //minimum value  
						99, //maximum value  
						1); //step

		JSpinner anoDataSpinner = new JSpinner(anoDataValue);

		anoDataSpinner.setBounds(9*tamanhoSpinner+8*espacoVertical,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,3*espacoVertical+tamanhoSpinner,tamanhoSpinner);

		anoDataSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(anoDataSpinner);

		//DATA SPINNER



		//BOTÃO INSERIR ABASTECIMENTO ------------------------------------------------------------------------------------------------------------

		JButton insertButton = new JButton();

		insertButton.setText("INSERIR NOVO ABASTECIMENTO");
		insertButton.setBackground(Color.decode("#3E67E8"));
		insertButton.setForeground(Color.decode("#FFFFFF"));
		insertButton.setFont(new Font("Monospace",Font.PLAIN,20));
		insertButton.setBounds((720-400)/2, 3*tamanhoSpinner+3*tamanhoPanel+7*espacoVertical, 400, tamanhoSpinner);

		//insertButton.addActionListener(this);

		insertButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub


				//insertKilometragemNova();

				pegarEvariarkilometragem(
						0,
						((Integer)kilometragemSpinner0.getValue()),
						(Integer)kilometragemSpinner1.getValue(),
						(Integer)kilometragemSpinner2.getValue(),
						(Integer)kilometragemSpinner3.getValue(),
						(Integer)kilometragemSpinner4.getValue())
				;
				
				contadorPosto = (byte)(contadorPosto + 1);

				siglaDoPosto[contadorPosto] = (String) SiglasPosto.getValue();

				precoGasolina[contadorPosto] = ((Integer)gasolinaSpinnerValue0.getValue()) +
						((double)((Integer)gasolinaSpinnerValue1.getValue()))/10 +
						((double)((Integer)gasolinaSpinnerValue2.getValue()))/100 +
						((double)((Integer)gasolinaSpinnerValue3.getValue()))/1000
						;

				valorAbastecimento[contadorPosto] = (Integer)valorAbastecimentoSpinner.getValue();

				diaAbastecimento[contadorPosto] = (Integer)diaDataSpinner.getValue();

				mesAbastecimento[contadorPosto] = (Integer)mesDataSpinner.getValue();

				anoAbastecimento[contadorPosto] = (Integer)anoDataSpinner.getValue();
				
				System.out.println("\nGasolinaNoTanque[" + contadorKombi + "] = " + GasolinaNoTanque[contadorKombi-1] + " contadorPosto = " + contadorPosto+
						"\n " + valorAbastecimento[contadorPosto] + " " + precoGasolina[contadorPosto]
						
						
						);
				
				GasolinaNoTanque[contadorKombi-1] = GasolinaNoTanque[contadorKombi-1] +
						 (valorAbastecimento[contadorPosto] / precoGasolina[contadorPosto])
						;
		
				System.out.println("\nGasolinaNoTanque[" + (contadorKombi -1 )+ "] = " + GasolinaNoTanque[contadorKombi-1] + " contadorPosto = " + contadorPosto+
						"\n " + valorAbastecimento[contadorPosto] + " " + precoGasolina[contadorPosto] + " " + (valorAbastecimento[contadorPosto] / precoGasolina[contadorPosto])
						
						
						);
				
				inserirNovoAbstecimentoTxT();
				
				inserirDoubleArquivoTxt("gasolinaAbastecimento.txt", GasolinaNoTanque, contadorKombi+1);

				System.out.println("\nNovo Abastecimento[" + contadorKombi +"] realizado com a sigla do posto " +
						siglaDoPosto[contadorPosto] + " preço da Gasolina " +
						precoGasolina[contadorPosto] + " valor do Abastecimento " +
						valorAbastecimento[contadorPosto] + " e data " +
						diaAbastecimento[contadorPosto] + "/" +
						mesAbastecimento[contadorPosto] + "/20" +
						anoAbastecimento[contadorPosto] + "." 
				);
			
				
				botaoAbastecimentoClicado = true;

				f.setState(Frame.ICONIFIED);
			}
		});

		//BOTÃO INSERIR ABASTECIMENTO ------------------------------------------------------------------------------------------------------------



		firstPanel.add(firstLabel);
		f.add(firstPanel);

		postoPanel.add(postoLabel);
		f.add(postoPanel);

		valorAbastecimentoPanel.add(valorAbastecimentoLabel);
		f.add(valorAbastecimentoPanel);


		f.add(insertButton);


		f.setLayout(null);    
		f.setVisible(true);  

	}





}
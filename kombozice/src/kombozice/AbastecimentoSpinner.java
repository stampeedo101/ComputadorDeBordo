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


public class AbastecimentoSpinner extends Kombi {



	String siglaPostoNovo = "null";
	String preenchimentoSpinners = "null";
	String outroPreenchimento = "null";

	double precoGasolinaNovo = 0;

	int kilometragemNova = 0;
	
	byte espacoVertical = 10,tamanhoPanel = 40,tamanhoSpinner = 60;
	byte centenaMilhar = 0, dezenaMilhar = 0, milhar=0,centena=0,dezena=0,unidade=0;

	int valorAbastecimentoNovo = 0, diaAbastecimentoNovo=1, mesAbastecimentoNovo=1, anoAbastecimentoNovo=20;
	
	boolean kilometragemNovaEntrou = false, kilometragemInseridaApenas = false, botaoAbastecimentoClicado = false;
	
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

	protected void criarSpinnerAbastecimento() {

		JFrame f = new JFrame("Abastecimento de Combustível");

		f.setSize(720,4*tamanhoSpinner+4*tamanhoPanel+8*espacoVertical);
		f.getContentPane().setBackground(Color.decode("#FFF88F"));
		//3*tamanhoSpinner+3*tamanhoPanel+7*espacoVertical

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
		
		
		descobrirNumerosSpinner(kilometragem[contadorKombi-1]);

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
		
		System.out.println(	"\nEntrou no spinner:" +
				"\nkilometragem [" + (contadorKombi-1) + 
				"] = " + kilometragem[contadorKombi-1] +
				"\nkilometragem [" + contadorKombi +
				"] = " + kilometragem[contadorKombi] +
				" \nkilometragem[" + (contadorKombi+1) +
				"] = " + kilometragem[contadorKombi+1]+
				"\nkilometragemNova = " + kilometragemNova
);

		//INSERIR KILOMETRAGEM
		
		insertKilometragemButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub


				//insertKilometragemNova();



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
				
				System.out.println("\nN antes do +1 = " + contadorKombi);
				
				variarKilometragem(kilometroNovo);
				
				System.out.println(	"\nDepois do metdodo:" +
						"\nkilometragem [" + (contadorKombi-1) + 
						"] = " + kilometragem[contadorKombi-1] +
						"\nkilometragem [" + contadorKombi +
						"] = " + kilometragem[contadorKombi] +
						" \nkilometragem[" + (contadorKombi+1) +
						"] = " + kilometragem[contadorKombi+1]+
						"\nkilometragemNova = " + kilometragemNova
	);
				
				contadorKombi = contadorKombi + 1;
				
				variarKilometragem(kilometroNovo);
				
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

				f.setState(Frame.ICONIFIED);
			}
		});

		//INSERIR KILOMETRAGEM



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



		//INSERIR VALO GASOLINA

		SpinnerModel gasolinaSpinnerValue0 =  
				new SpinnerNumberModel(5, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolinaSpinner0 = new JSpinner(gasolinaSpinnerValue0);

		gasolinaSpinner0.setBounds(6*tamanhoSpinner,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolinaSpinner0.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolinaSpinner0);

		SpinnerModel gasolinaSpinnerValue1 =  
				new SpinnerNumberModel(1, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolinaSpinner1 = new JSpinner(gasolinaSpinnerValue1);

		gasolinaSpinner1.setBounds(6*tamanhoSpinner+tamanhoSpinner+espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolinaSpinner1.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolinaSpinner1);

		SpinnerModel gasolinaSpinnerValue2 =  
				new SpinnerNumberModel(2, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolinaSpinner2 = new JSpinner(gasolinaSpinnerValue2);

		gasolinaSpinner2.setBounds(6*tamanhoSpinner+2*tamanhoSpinner+2*espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolinaSpinner2.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolinaSpinner2);

		SpinnerModel gasolinaSpinnerValue3 =  
				new SpinnerNumberModel(3, //initial value  
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
						1, //minimum value  
						300, //maximum value  
						10); //step

		JSpinner valorAbastecimentoSpinner = new JSpinner(abastecimentoValue);

		valorAbastecimentoSpinner.setBounds(espacoVertical,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,2*tamanhoSpinner,tamanhoSpinner);

		valorAbastecimentoSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(valorAbastecimentoSpinner);

		//INSERIR VALOR ABASTECIMENTO

		//DATA SPINNER

		SpinnerModel diaDataValue =  
				new SpinnerNumberModel(15, //initial value  
						1, //minimum value  
						30, //maximum value  
						1); //step

		JSpinner diaDataSpinner = new JSpinner(diaDataValue);

		diaDataSpinner.setBounds(7*tamanhoSpinner,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,3*espacoVertical+tamanhoSpinner,tamanhoSpinner);

		diaDataSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(diaDataSpinner);



		SpinnerModel mesDataValue =  
				new SpinnerNumberModel(6, //initial value  
						1, //minimum value  
						12, //maximum value  
						1); //step

		JSpinner mesDataSpinner = new JSpinner(mesDataValue);

		mesDataSpinner.setBounds(8*tamanhoSpinner+4*espacoVertical,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,3*espacoVertical+tamanhoSpinner,tamanhoSpinner);

		mesDataSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(mesDataSpinner);



		SpinnerModel anoDataValue =  
				new SpinnerNumberModel(21, //initial value  
						21, //minimum value  
						99, //maximum value  
						1); //step

		JSpinner anoDataSpinner = new JSpinner(anoDataValue);

		anoDataSpinner.setBounds(9*tamanhoSpinner+8*espacoVertical,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,3*espacoVertical+tamanhoSpinner,tamanhoSpinner);

		anoDataSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		f.add(anoDataSpinner);

		//DATA SPINNER



		//BOTÃO INSERIR ABASTECIMENTO

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



				kilometragemNova = ((Integer)kilometragemSpinner0.getValue())*10*1000 + 
						((Integer)kilometragemSpinner1.getValue())*1000 + 
						((Integer)kilometragemSpinner2.getValue())*100 + 
						((Integer)kilometragemSpinner3.getValue())*10 +
						((Integer)kilometragemSpinner4.getValue()) 
						;
				


				siglaPostoNovo = (String) SiglasPosto.getValue();

				precoGasolinaNovo = ((Integer)gasolinaSpinnerValue0.getValue()) +
						((double)((Integer)gasolinaSpinnerValue1.getValue()))/10 +
						((double)((Integer)gasolinaSpinnerValue2.getValue()))/100 +
						((double)((Integer)gasolinaSpinnerValue3.getValue()))/1000
						;

				valorAbastecimentoNovo = (Integer)valorAbastecimentoSpinner.getValue();

				diaAbastecimentoNovo = (Integer)diaDataSpinner.getValue();

				mesAbastecimentoNovo = (Integer)mesDataSpinner.getValue();

				anoAbastecimentoNovo = (Integer)anoDataSpinner.getValue();
				
				System.out.println("\nn antes de (contadorKombi+1) = " + contadorKombi);
				
				System.out.println(	"\ngasolinanotanque [" + (contadorKombi + 1) + "] = " + GasolinaNoTanque[contadorKombi+1] +
						"\ngasolinanotanque [" + contadorKombi +"] = " + GasolinaNoTanque[contadorKombi] +
						"\ngasolinanotanque [" + (contadorKombi - 1) + "] = " + GasolinaNoTanque[contadorKombi-1] +
						"\ne uma parada = "+ ((double)valorAbastecimentoNovo)/precoGasolinaNovo
						);
				
				contadorKombi = contadorKombi + 1;
				
				
				
				
				siglaDoPosto[nPosto] = siglaPostoNovo;
				precoGasolina[nPosto] = precoGasolinaNovo;
				valorAbastecimento[nPosto] = valorAbastecimentoNovo;
				diaAbastecimento[nPosto] = diaAbastecimentoNovo;
				mesAbastecimento[nPosto] = mesAbastecimentoNovo;
				anoAbastecimento[nPosto] = anoAbastecimentoNovo;
				
				inserirNovosDadosTxT();
				
				System.out.println(	"\ngasolinanotanque [" + (contadorKombi + 1) + "] = " + GasolinaNoTanque[contadorKombi+1] +
									"\ngasolinanotanque [" + contadorKombi +"] = " + GasolinaNoTanque[contadorKombi] +
									"\ngasolinanotanque [" + (contadorKombi - 1) + "] = " + GasolinaNoTanque[contadorKombi-1] +
									"\ne uma parada = "+ ((double)valorAbastecimentoNovo)/precoGasolinaNovo
				);
				
				
				
				
				
				inserirDoubleArquivoTxt("gasolinaAbastecimento.txt", GasolinaNoTanque, contadorKombi+1);


				System.out.println("\nNovo Abastecimento[" + contadorKombi +"] realizado com a sigla do posto " +
									siglaPostoNovo + " preço da Gasolina " +
									precoGasolinaNovo + " valor do Abastecimento " +
									valorAbastecimentoNovo + " e data " +
									diaAbastecimentoNovo + "/" +
									mesAbastecimentoNovo + "/20" +
									anoAbastecimentoNovo + "." 
				);
				
				botaoAbastecimentoClicado = true;

				f.setState(Frame.ICONIFIED);
			}
		});

		//BOTÃO INSERIR ABASTECIMENTO



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
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



	String siglaPostoNovo = " "; 

	double precoGasolinaNovo = 0;

	int kilometragemNova = 0;
	
	byte espacoVertical = 10,tamanhoPanel = 40,tamanhoSpinner = 60;

	int valorAbastecimentoNovo = 0, diaAbastecimentoNovo=1, mesAbastecimentoNovo=1, anoAbastecimentoNovo=20;
	
	boolean kilometragemNovaEntrou = false, kilometragemInseridaApenas = false, botaoAbastecimentoClicado = false;

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

		SpinnerModel value0 =  
				new SpinnerNumberModel(5, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value1 =  
				new SpinnerNumberModel(5, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value2 =  
				new SpinnerNumberModel(6, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value3 =  
				new SpinnerNumberModel(9, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value4 =  
				new SpinnerNumberModel(6, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner spinner0 = new JSpinner(value0);

		spinner0.setBounds((720-280)/2-50,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);

		spinner0.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner0);


		JSpinner spinner1 = new JSpinner(value1);

		spinner1.setBounds((720-280)/2 + 2*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		spinner1.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner1);

		JSpinner spinner2 = new JSpinner(value2);

		spinner2.setBounds((720-280)/2 + tamanhoSpinner + 3*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		spinner2.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner2);

		JSpinner spinner3 = new JSpinner(value3);

		spinner3.setBounds((720-280)/2 + 2*tamanhoSpinner+ 4*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		spinner3.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner3);

		JSpinner spinner4 = new JSpinner(value4);

		spinner4.setBounds((720-280)/2 + 3*tamanhoSpinner + 5*espacoVertical,2*espacoVertical+tamanhoPanel,tamanhoSpinner,tamanhoSpinner);	            
		spinner4.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner4);

		// (720-280)/2 = 360-190=170

		JButton insertKilometragemButton = new JButton();

		insertKilometragemButton.setText("INSERIR");
		insertKilometragemButton.setBackground(Color.decode("#3E67E8"));
		insertKilometragemButton.setForeground(Color.decode("#FFFFFF"));
		insertKilometragemButton.setFont(new Font("Monospace",Font.PLAIN,20));
		insertKilometragemButton.setBounds((720-280)/2 + 5*tamanhoSpinner + 5*espacoVertical,2*espacoVertical+tamanhoPanel, 120, tamanhoSpinner);
		f.add(insertKilometragemButton);

		insertKilometragemButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub


				//insertKilometragemNova();



				kilometragemNova = ((Integer)spinner0.getValue())*10*1000 + 
						((Integer)spinner1.getValue())*1000 + 
						((Integer)spinner2.getValue())*100 + 
						((Integer)spinner3.getValue())*10 +
						((Integer)spinner4.getValue()) 
						;
				
				System.out.println("\nN antes do +1 = " + n);
				
				variarKilometragem(kilometroNovo);
				
				n = n + 1;
				
				variarKilometragem(kilometroNovo);
				
				System.out.println(	"\nSomente a kilometragem foi modificada com:" +
									"\nkilometragem [" + (n-1) + 
									"] = " + kilometragem[n-1] +
									"\nkilometragem [" + n +
									"] = " + kilometragem[n] +
									" \nkilometragem[" + (n+1) +
									"] = " + kilometragem[n+1]+
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

		SiglasPosto.setBounds(espacoVertical, tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,2*tamanhoSpinner,tamanhoSpinner);

		SiglasPosto.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner/2));

		f.add(SiglasPosto);
		//INSERIR POSTO



		//INSERIR VALO GASOLINA

		SpinnerModel gValue0 =  
				new SpinnerNumberModel(5, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolina0 = new JSpinner(gValue0);

		gasolina0.setBounds(6*tamanhoSpinner,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolina0.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolina0);

		SpinnerModel gValue1 =  
				new SpinnerNumberModel(1, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolina1 = new JSpinner(gValue1);

		gasolina1.setBounds(6*tamanhoSpinner+tamanhoSpinner+espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolina1.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolina1);

		SpinnerModel gValue2 =  
				new SpinnerNumberModel(2, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolina2 = new JSpinner(gValue2);

		gasolina2.setBounds(6*tamanhoSpinner+2*tamanhoSpinner+2*espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolina2.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolina2);

		SpinnerModel gValue3 =  
				new SpinnerNumberModel(3, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		JSpinner gasolina3 = new JSpinner(gValue3);

		gasolina3.setBounds(6*tamanhoSpinner+3*tamanhoSpinner+3*espacoVertical,tamanhoSpinner+2*tamanhoPanel+4*espacoVertical,tamanhoSpinner,tamanhoSpinner);

		gasolina3.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(gasolina3);

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



				kilometragemNova = ((Integer)spinner0.getValue())*10*1000 + 
						((Integer)spinner1.getValue())*1000 + 
						((Integer)spinner2.getValue())*100 + 
						((Integer)spinner3.getValue())*10 +
						((Integer)spinner4.getValue()) 
						;
				


				siglaPostoNovo = (String) SiglasPosto.getValue();

				precoGasolinaNovo = ((Integer)gValue0.getValue()) +
						((double)((Integer)gValue1.getValue()))/10 +
						((double)((Integer)gValue2.getValue()))/100 +
						((double)((Integer)gValue3.getValue()))/1000
						;

				valorAbastecimentoNovo = (Integer)valorAbastecimentoSpinner.getValue();

				diaAbastecimentoNovo = (Integer)diaDataSpinner.getValue();

				mesAbastecimentoNovo = (Integer)mesDataSpinner.getValue();

				anoAbastecimentoNovo = (Integer)anoDataSpinner.getValue();
				
				System.out.println("\nn antes de (n+1) = " + n);
				
				System.out.println(	"\ngasolinanotanque [" + (n + 1) + "] = " + GasolinaNoTanque[n+1] +
						"\ngasolinanotanque [" + n +"] = " + GasolinaNoTanque[n] +
						"\ngasolinanotanque [" + (n - 1) + "] = " + GasolinaNoTanque[n-1] +
						"\ne uma parada = "+ ((double)valorAbastecimentoNovo)/precoGasolinaNovo
						);
				
				n = n + 1;
				
				
				
				
				siglaDoPosto[nPosto] = siglaPostoNovo;
				precoGasolina[nPosto] = precoGasolinaNovo;
				valorAbastecimento[nPosto] = valorAbastecimentoNovo;
				diaAbastecimento[nPosto] = diaAbastecimentoNovo;
				mesAbastecimento[nPosto] = mesAbastecimentoNovo;
				anoAbastecimento[nPosto] = anoAbastecimentoNovo;
				
				inserirNovosDadosTxT();
				
				System.out.println(	"\ngasolinanotanque [" + (n + 1) + "] = " + GasolinaNoTanque[n+1] +
									"\ngasolinanotanque [" + n +"] = " + GasolinaNoTanque[n] +
									"\ngasolinanotanque [" + (n - 1) + "] = " + GasolinaNoTanque[n-1] +
									"\ne uma parada = "+ ((double)valorAbastecimentoNovo)/precoGasolinaNovo
				);
				
				
				
				
				
				inserirDoubleArquivoTxt("gasolinaAbastecimento.txt", GasolinaNoTanque, n+1);


				System.out.println("\nNovo Abastecimento[" + n +"] realizado com a sigla do posto " +
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
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


public class AbastecimentoSpinner extends KilometragemSpinner {
	
	int espacoVertical = 10,tamanhoPanel = 40,tamanhoSpinner = 60;

	protected void criarSpinnerAbastecimento() {

		JFrame f = new JFrame("Abastecimento de Combustível");
		
		f.setSize(720,4*tamanhoSpinner+4*tamanhoPanel+8*espacoVertical); 
		//3*tamanhoSpinner+3*tamanhoPanel+7*espacoVertical
		
		//INSERIR KILOMETRAGEM

		JPanel firstPanel = new JPanel();

		firstPanel.setBackground(Color.decode("#003500"));
		firstPanel.setBounds(espacoVertical, espacoVertical, 700, tamanhoPanel);

		JLabel firstLabel = new JLabel();
		firstLabel.setBackground(Color.decode("#004a93"));
		firstLabel.setText("Kilometragem");
		firstLabel.setForeground(Color.decode("#45ffff"));
		firstLabel.setFont(new Font("Monospace",Font.PLAIN,tamanhoPanel/2));
		firstLabel.setVerticalAlignment(JLabel.CENTER);
		firstLabel.setHorizontalAlignment(JLabel.CENTER);

		SpinnerModel value0 =  
				new SpinnerNumberModel(0, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value1 =  
				new SpinnerNumberModel(1, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value2 =  
				new SpinnerNumberModel(2, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value3 =  
				new SpinnerNumberModel(3, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step

		SpinnerModel value4 =  
				new SpinnerNumberModel(4, //initial value  
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
		insertKilometragemButton.setBackground(Color.decode("#367f39"));
		insertKilometragemButton.setForeground(Color.decode("#002232"));
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
				/*
				System.out.println("Value : " + 
						spinner0.getValue() + 
						spinner1.getValue() +
						spinner2.getValue() +
						spinner3.getValue() + 
						spinner4.getValue() 
				);  
				 */
				System.out.println("\nsomente a kilometragem foi modificada");

				f.setState(Frame.ICONIFIED);
			}
		});
		
		//INSERIR KILOMETRAGEM
		
		
		
		//INSERIR POSTO
		
		JPanel postoPanel = new JPanel();

		postoPanel.setBackground(Color.decode("#003500"));
		postoPanel.setBounds(espacoVertical, tamanhoSpinner+tamanhoPanel+3*espacoVertical, 700, tamanhoPanel);

		JLabel postoLabel = new JLabel();
		
		postoLabel.setBackground(Color.decode("#004a93"));
		postoLabel.setText("Sigla do posto:                       Valor da Gasolina:");
		postoLabel.setForeground(Color.decode("#45ffff"));
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
				 new SpinnerNumberModel(0, //initial value  
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

		 valorAbastecimentoPanel.setBackground(Color.decode("#003500"));
		 valorAbastecimentoPanel.setBounds(espacoVertical,2*tamanhoSpinner+2*tamanhoPanel+5*espacoVertical, 700, tamanhoPanel);

		 JLabel valorAbastecimentoLabel = new JLabel();

		 valorAbastecimentoLabel.setBackground(Color.decode("#004a93"));
		 valorAbastecimentoLabel.setText("Valor do abastecimento (em dezenas de reais): ");
		 valorAbastecimentoLabel.setForeground(Color.decode("#45ffff"));
		 valorAbastecimentoLabel.setFont(new Font("Monospace",Font.PLAIN,tamanhoPanel/2));
		 valorAbastecimentoLabel.setVerticalAlignment(JLabel.CENTER);
		 valorAbastecimentoLabel.setHorizontalAlignment(JLabel.CENTER);

		 SpinnerModel abastecimentoValue =  
				 new SpinnerNumberModel(50, //initial value  
						 0, //minimum value  
						 100, //maximum value  
						 10); //step

		 JSpinner valorAbastecimentoSpinner = new JSpinner(abastecimentoValue);

		 valorAbastecimentoSpinner.setBounds(6*tamanhoSpinner,2*tamanhoSpinner+3*tamanhoPanel+6*espacoVertical,2*tamanhoSpinner,tamanhoSpinner);

		 valorAbastecimentoSpinner.setFont(new Font("Monospace",Font.PLAIN,tamanhoSpinner-10));
		 f.add(valorAbastecimentoSpinner);

		 //INSERIR VALOR ABASTECIMENTO


		 
		 //BOTÃO INSERIR ABASTECIMENTO
		 
		JButton insertButton = new JButton();

		insertButton.setText("INSERIR NOVO ABASTECIMENTO");
		insertButton.setBackground(Color.decode("#367f39"));
		insertButton.setForeground(Color.decode("#002232"));
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
				/*
				System.out.println("Value : " + 
						spinner0.getValue() + 
						spinner1.getValue() +
						spinner2.getValue() +
						spinner3.getValue() + 
						spinner4.getValue() 
				);  
				 */
				System.out.println("\nNovo Abastecimento realizado");

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
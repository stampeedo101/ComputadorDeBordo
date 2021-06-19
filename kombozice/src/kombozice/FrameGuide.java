package kombozice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Hashtable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class FrameGuide extends AbastecimentoSpinner {
	
	DecimalFormat dc2 = new DecimalFormat("0.00");
	DecimalFormat dc3 = new DecimalFormat("0.000");
	
	public void executarAcaoInsert(MouseEvent ae) {
		
	}
	
	
	
	
	protected void criarCompFramePrincipal(int kilometragem, double gas, double valorGasolina, int diaAbastecimento, int mesAbastecimento, int valorAbastecimetnto, double consumo) {
		
		int jFrameWidth = 720, widthPanel = 700;
		int jFrameHight = 1080, heightPanel = 100;

		JFrame frame = new JFrame();	

		frame.setTitle("KOMBI");

		//about size, color and visibility of window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(jFrameWidth,jFrameHight);

		frame.getContentPane().setBackground(Color.decode("#fff88f"));
		frame.setLocationRelativeTo(null);

		/*KILOMETRAGEM PANEL*/

		JPanel kilometragemPanel = new JPanel();		
		kilometragemPanel.setBackground(Color.decode("#442f1f"));
		kilometragemPanel.setBounds(10, 0, widthPanel, heightPanel); 

		// ImageIcon woodTable = new ImageIcon("wood_700X100.png"); inserir com icone dá alguns erros
		
		JLabel kilometragemLabel = new JLabel();
		
		String s = String.valueOf(kilometragem);
		String esquerda = new String();
		String direita = new String();
		
		for(int i = s.length() - 3; i < s.length();i++) {
			direita = direita + s.charAt(i);
		}		
		
		if(kilometragem < 100000) {
			esquerda = "0";
			for(int i = 0; i < 2; i++) {
				esquerda = esquerda + s.charAt(i);
			}
		} else {
			for(int i = 0; i < 3; i++) {
				esquerda = esquerda + s.charAt(i);
			}
		}
		
		kilometragemLabel.setText(esquerda + " " + direita);
		kilometragemLabel.setForeground(Color.white);
		kilometragemLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		//kilometragemLabel.setVerticalAlignment((JLabel.CENTER);
		//kilometragemLabel.setHorizontalAlignment(JLabel.CENTER);	   

		/*KILOMETRAGEM PANEL*/



		/*TANQUE PANEL*/

		JPanel tanquePanel = new JPanel();

		if(gas > 0 && gas <= 10) {
			tanquePanel.setBackground(Color.red);			
		}else if(gas > 10 && gas <= 20){
			tanquePanel.setBackground(Color.orange);
		}else if(gas > 20 && gas <= 30){
			tanquePanel.setBackground(Color.green);	
		}else if(gas > 30 && gas <= 40){
			tanquePanel.setBackground(Color.blue);
		}

		tanquePanel.setBounds(10, 110, widthPanel, heightPanel);

		JLabel hpTanqueLabel = new JLabel();
		//hpTanqueLabel.setBackground(Color.red);
		//hpTanqueLabel.setText("055 123");		
		
		/*
		ImageIcon barrinha = new ImageIcon("barrinha2.png");
		hpTanqueLabel.setIcon(barrinha);
		*/

		hpTanqueLabel.setHorizontalAlignment(JLabel.CENTER);
		hpTanqueLabel.setVerticalAlignment(JLabel.CENTER);
		
		// Different settings on the sliders
        JSlider tanqueSlider = new JSlider(0,40,20);
        // JSlider slider = new JSlider(JSlider.VERTICAL);
        // JSlider slider = new JSlider(-100, 100, 50);
        // JSlider slider = new JSlider(JSlider.VERTICAL, -100, 100, 50);
         
        // Set the slider with the DefaultBoundedRangeModel
        //DefaultBoundedRangeModel model = new DefaultBoundedRangeModel(20, 0, 1, 100);
        //JSlider slider = new JSlider(model);
        
        //tamanho do Slide
        
        Dimension d = tanqueSlider.getPreferredSize();
        
        tanqueSlider.setPreferredSize(new Dimension(new Dimension(d.width+450,d.height+70)));
   
         
        // Set major or minor ticks for the slider
        tanqueSlider.setMajorTickSpacing(5);
        tanqueSlider.setMinorTickSpacing(1);
        tanqueSlider.setPaintTicks(true);
         
        // Set the labels to be painted on the tanqueSlider
        tanqueSlider.setPaintLabels(true);
        
        
        // Add positions label in the slider
        Hashtable position = new Hashtable();
        
        position.put(0, new JLabel("0"));
        position.put(10, new JLabel("10"));
        position.put(20, new JLabel("20"));
        position.put(30, new JLabel("30"));
        position.put(40, new JLabel("40"));
        
        /* 
        Map<Integer, String> map = new HashMap<>();
        
        map.put(0,"0");
        map.put(10,"10");
        map.put(20,"20");
        map.put(30,"30");
        map.put(40,"40");
        */
         
        // Set the label to be drawn
        tanqueSlider.setLabelTable(position);
         
        // Add the tanqueSlider to the panel
        tanquePanel.add(tanqueSlider);
         


		/*TANQUE PANEL*/


	/* BOTÃO ABASTECIMENTO */	
		
		/*
		JButton abastecimentoButton = new JButton("A");
		
		abastecimentoButton.setBackground(Color.decode("#367f39"));
		abastecimentoButton.setForeground(Color.decode("#002232"));
		abastecimentoButton.setBounds(10, 220, 50, 50);
		
		abastecimentoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Abastecimento foi clicado.");
				criarSpinnerAbastecimento();
				
			}
		});
		*/
		
		
		/* BOTÃO ABASTECIMENTO */

		
		
		/* BOTÃO INSERT*/

		JButton insertButton = new JButton();
		
		insertButton.setText("Insert");
		insertButton.setBackground(Color.decode("#3E67E8"));
		insertButton.setForeground(Color.decode("#ffffff"));
		insertButton.setFont(new Font("Monospace",Font.PLAIN,50));
		insertButton.setBounds(110, 220, 500, 60);
		
		//insertButton.addActionListener(this);
		
		insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("insert foi clicado.");
				
				//insertKilometragemNova();
				
				kilometragemInseridaApenas = false;
				
				criarSpinnerAbastecimento();
			}
		});

		/* BOTÃO INSERT*/
		
		
		




		/* NOME DO POSTO E VALOR DA GAS */

		JPanel nomePostoValorGasolinaPanel = new JPanel();
		nomePostoValorGasolinaPanel.setBackground(Color.decode("#442f1f"));
		nomePostoValorGasolinaPanel.setBounds(10, 290, widthPanel, heightPanel);

		JLabel nomePostoValorGasolinaLabel = new JLabel();
		nomePostoValorGasolinaLabel.setBackground(Color.decode("#004a93"));
		nomePostoValorGasolinaLabel.setText("brC R$ " + valorGasolina);
		nomePostoValorGasolinaLabel.setForeground(Color.decode("#ffffff"));
		nomePostoValorGasolinaLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		nomePostoValorGasolinaLabel.setVerticalAlignment(JLabel.CENTER);
		nomePostoValorGasolinaLabel.setHorizontalAlignment(JLabel.CENTER);

		/* NOME DO POSTO E VALOR DA GAS */



		/*DATA ÚLTIMO ABASTECIMENTO PANEL*/

		JPanel abastecimentoDatePanel = new JPanel();
		abastecimentoDatePanel.setBackground(Color.decode("#442f1f"));
		abastecimentoDatePanel.setBounds(10, 400, widthPanel, heightPanel);

		JLabel abastecimentoDateLabel = new JLabel();
		abastecimentoDateLabel.setBackground(Color.decode("#004a93"));
		
		if(diaAbastecimento<10 && mesAbastecimento>9) {
			abastecimentoDateLabel.setText("0" + diaAbastecimento + "/" + mesAbastecimento);
		}else if(diaAbastecimento>9 && mesAbastecimento<10) {
			abastecimentoDateLabel.setText(diaAbastecimento + "/0" + mesAbastecimento);
		}else if(diaAbastecimento<10 && mesAbastecimento<10) {
			abastecimentoDateLabel.setText("0" + diaAbastecimento + "/0" + mesAbastecimento);
		} else {
			abastecimentoDateLabel.setText(diaAbastecimento + "/" + mesAbastecimento);
		}

	
		abastecimentoDateLabel.setForeground(Color.decode("#ffffff"));
		abastecimentoDateLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		abastecimentoDateLabel.setVerticalAlignment(JLabel.CENTER);
		abastecimentoDateLabel.setHorizontalAlignment(JLabel.CENTER);

		/*DATA ÚLTIMO ABASTECIMENTO PANEL*/



		/*VALOR ÚLTIMO ABASTECIMENTO PANEL*/

		JPanel abastecimentoMoneyPanel = new JPanel();
		abastecimentoMoneyPanel.setBackground(Color.decode("#442f1f"));
		abastecimentoMoneyPanel.setBounds(10, 510, widthPanel, heightPanel);

		JLabel abastecimentoMoneyLabel = new JLabel();
		abastecimentoMoneyLabel.setBackground(Color.decode("#004a93"));
		
		abastecimentoMoneyLabel.setText("R$ " + valorAbastecimetnto + ".00");
		abastecimentoMoneyLabel.setForeground(Color.decode("#ffffff"));
		abastecimentoMoneyLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		abastecimentoMoneyLabel.setVerticalAlignment(JLabel.CENTER);
		abastecimentoMoneyLabel.setHorizontalAlignment(JLabel.CENTER);

		/*VALOR ÚLTIMO ABASTECIMENTO PANEL*/



		/*km/litro PANEL*/

		JPanel kmLitroPanel = new JPanel();
		kmLitroPanel.setBackground(Color.decode("#442f1f"));
		kmLitroPanel.setBounds(10, 620, widthPanel, heightPanel);

		JLabel kmLitroLabel = new JLabel();
		kmLitroLabel.setBackground(Color.decode("#004a93"));
		
		
		kmLitroLabel.setText(consumo + " km/l");
		kmLitroLabel.setForeground(Color.decode("#ffffff"));
		kmLitroLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		kmLitroLabel.setVerticalAlignment(JLabel.CENTER);
		kmLitroLabel.setHorizontalAlignment(JLabel.CENTER);

		/*km/litro PANEL*/
		
		
		
		//DESENHO   663X201		
		
		JPanel desenhoPanel = new JPanel();
		
		desenhoPanel.setBackground(Color.decode("#442f1f"));
		desenhoPanel.setBounds(10, 730, widthPanel, heightPanel);

		ImageIcon kombinha = new ImageIcon("VaisaberOtamanho.png");
		JLabel desenhoLabel = new JLabel(kombinha);		
		
		desenhoLabel.setBackground(Color.decode("#004a93"));
		
		//desenhoLabel.setText("R$ " + valorAbastecimetnto + ".00");
		desenhoLabel.setForeground(Color.decode("#ffffff"));
		desenhoLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		desenhoLabel.setVerticalAlignment(JLabel.CENTER);
		desenhoLabel.setHorizontalAlignment(JLabel.CENTER);
		
		desenhoPanel.add(desenhoLabel);
		frame.add(desenhoPanel);
		
		
		//DESENHO

		
		/* BOTÃO REFRESH */	
		
		Icon refreshIcon = new ImageIcon("refreshButton3.png");
		
		JButton refreshButton = new JButton(refreshIcon);
		
		refreshButton.setBackground(Color.decode("#367f39"));
		refreshButton.setForeground(Color.decode("#002232"));
		refreshButton.setBounds(630, 220, 50, 50);
		
		refreshButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("\nrefresh foi clicado.");
				
				//Display KilometragemNova();
				if(kilometragemNova != 0 ) {
					kilometragemLabel.setText("0" + kilometragemNova);
					//inserirValorKilometragem();
					//FrameGuide.this.kilometragem[n] = kilometragemNova;
				}
				
				//Display Abastecimento novo
				if(kilometragemNova != 0 && valorAbastecimentoNovo !=0) {
					kilometragemLabel.setText("0" + kilometragemNova);
					nomePostoValorGasolinaLabel.setText(siglaPostoNovo + " R$ " + dc3.format(precoGasolinaNovo));
					abastecimentoDateLabel.setText(diaAbastecimentoNovo + "/" + mesAbastecimentoNovo + "/" + "20" + anoAbastecimentoNovo );
					abastecimentoMoneyLabel.setText("R$ " + valorAbastecimentoNovo);
					kmLitroLabel.setText(dc2.format(km_litro) + " km/l");					
				}
				
				if(kilometragemInseridaApenas) {
					System.out.println("\nSaída depois do refresh (com modificação apenas na kilometragem):\nA " + nomeDaKombosa + 
							" já rodou " + FrameGuide.this.kilometragem[n] +
							" kilometros.\nTem " +
							GasolinaNoTanque[n] +
							" de litros de gasolina no Tanque.\nE faz " +
							km_litro +
							" kilometros por litro."
					);
				} else {
					System.out.println("\nSaída depois do refresh (Abastecimento inserido):\nA " + nomeDaKombosa + 
							" já rodou " + FrameGuide.this.kilometragem[n] +
							" kilometros.\nTem " +
							GasolinaNoTanque[n] +
							" de litros de gasolina no Tanque.\nE faz " +
							km_litro +
							" kilometros por litro.\nNova data de abastecimento " + 
							FrameGuide.this.diaAbastecimento[nPosto] +
							"/" + FrameGuide.this.mesAbastecimento[nPosto] +
							"/" + anoAbastecimento[nPosto] +
							" .\nO valor do novo Abastecimento foi de R$ " + valorAbastecimento[nPosto] +
							",00. A sigla do posto é " + siglaDoPosto[nPosto] +
							". O preço da gasolina no posto é " + dc3.format(precoGasolina[nPosto])
					);
				}

				
				tanqueSlider.setValue((int) Math.round(GasolinaNoTanque[n])); //inserir valor slider
				
			}
		});
		
		/* BOTÃO REFRESH */


		/* INSERT LABELS*/

		//kilometragem
		kilometragemPanel.add(kilometragemLabel);
		// frame.add(kilometragemLabel);
		frame.add(kilometragemPanel);
		kilometragemPanel.setVisible(true);

		//tanque
		tanquePanel.add(hpTanqueLabel);
		//frame.add(hpTanqueLabel);
		frame.add(tanquePanel);
		tanquePanel.setVisible(true);

		//button
		frame.add(insertButton);
		insertButton.setVisible(true);
		
		//frame.add(abastecimentoButton);
		frame.add(refreshButton);
	
		
		//nome Posto valor gasolina
		nomePostoValorGasolinaPanel.add(nomePostoValorGasolinaLabel);
		frame.add(nomePostoValorGasolinaPanel);

		//data abastecimento
		abastecimentoDatePanel.add(abastecimentoDateLabel);
		//frame.add(abastecimentoDateLabel);
		frame.add(abastecimentoDatePanel);
		abastecimentoDatePanel.setVisible(true);

		//money abastecimento
		abastecimentoMoneyPanel.add(abastecimentoMoneyLabel);
		//frame.add(abastecimentoMoneyLabel);
		frame.add(abastecimentoMoneyPanel);
		abastecimentoMoneyPanel.setVisible(true);

		//km/litro
		kmLitroPanel.add(kmLitroLabel);
		//frame.add(kmLitroLabel);
		frame.add(kmLitroPanel);
		kmLitroPanel.setVisible(true);


		frame.setVisible(true);


	}





}
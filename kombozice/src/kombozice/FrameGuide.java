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

public class FrameGuide extends InsercaoDadosSpinners {
	
	DecimalFormat dc2 = new DecimalFormat("0.00");
	DecimalFormat dc3 = new DecimalFormat("0.000");
	
	public void executarAcaoInsert(MouseEvent ae) {
		
	}
	
	protected void setKilometragemSpinner() {
		//FrameGuide.this.kilo
	}
	
	protected String formatarKilometragem(int kilometragemInt) {
		
		String kilometragemFormatada = String.valueOf(kilometragemInt);

		String esquerda = new String();
		String direita = new String();
		
		for(int i = kilometragemFormatada.length() - 3; i < kilometragemFormatada.length();i++) {
			direita = direita + kilometragemFormatada.charAt(i);
		}		
		
		if(kilometragemInt < 100000) {
			esquerda = "0";
			for(int i = 0; i < 2; i++) {
				esquerda = esquerda + kilometragemFormatada.charAt(i);
			}
		} else {
			for(int i = 0; i < 3; i++) {
				esquerda = esquerda + kilometragemFormatada.charAt(i);
			}
		}
		
		return (esquerda + " " + direita);
	}
	
	protected String formataroDiaMes(int nPosto) {
		if(diaAbastecimento[nPosto]<10 && mesAbastecimento[nPosto]>9) {
			return ("0" + diaAbastecimento[nPosto] + "/" + mesAbastecimento[nPosto] + "/" + anoAbastecimento[nPosto]);
		}else if(diaAbastecimento[nPosto]>9 && mesAbastecimento[nPosto]<10) {
			return (diaAbastecimento[nPosto] + "/0" + mesAbastecimento[nPosto] + "/" + anoAbastecimento[nPosto]);
		}else if(diaAbastecimento[nPosto]<10 && mesAbastecimento[nPosto]<10) {
			return ("0" + diaAbastecimento[nPosto] + "/0" + mesAbastecimento[nPosto] + "/" + anoAbastecimento[nPosto]);
		} else {
			return (diaAbastecimento[nPosto] + "/" + mesAbastecimento[nPosto] + "/" + anoAbastecimento[nPosto]);
		}
	}
	
	
	
	
	protected void criarCompFramePrincipal() {
		
		int jFrameWidth = 720, widthPanel = 700;
		int jFrameHight = 1080, heightPanel = 100;
	
		
		String kilometragemFormatada = new String();
		kilometragemFormatada = "null";

		JFrame frame = new JFrame();		
		
		frame.setTitle("KOMBI");

		//about size, color and visibility of window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(jFrameWidth,jFrameHight);

		frame.getContentPane().setBackground(Color.decode("#fff88f"));
		frame.setLocationRelativeTo(null);
		
		//ler dados
		
		lerDadosKombi();
		lerDadoPosto();
		
		//ler dados

		/*KILOMETRAGEM PANEL*/

		JPanel kilometragemPanel = new JPanel();		
		kilometragemPanel.setBackground(Color.decode("#442f1f"));
		kilometragemPanel.setBounds(10, 0, widthPanel, heightPanel); 

		// ImageIcon woodTable = new ImageIcon("wood_700X100.png"); inserir com icone d?? alguns erros
		
		JLabel kilometragemLabel = new JLabel();
		
		kilometragemLabel.setText(formatarKilometragem(kilometragem[contadorKombi]));
		kilometragemLabel.setForeground(Color.white);
		kilometragemLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		//kilometragemLabel.setVerticalAlignment((JLabel.CENTER);
		//kilometragemLabel.setHorizontalAlignment(JLabel.CENTER);	   

		/*KILOMETRAGEM PANEL*/



		/*TANQUE PANEL*/

		JPanel tanquePanel = new JPanel();

		if(GasolinaNoTanque[contadorKombi] > 0 && GasolinaNoTanque[contadorKombi] <= 10) {
			tanquePanel.setBackground(Color.red);			
		}else if(GasolinaNoTanque[contadorKombi] > 10 && GasolinaNoTanque[contadorKombi] <= 20){
			tanquePanel.setBackground(Color.orange);
		}else if(GasolinaNoTanque[contadorKombi] > 20 && GasolinaNoTanque[contadorKombi] <= 30){
			tanquePanel.setBackground(Color.green);	
		}else if(GasolinaNoTanque[contadorKombi] > 30 && GasolinaNoTanque[contadorKombi] <= 40){
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
		
		/*
		//VALORES PARA O SLIDER DO TANQUE:
		System.out.println("valor de tanque[n] = " + GasolinaNoTanque[contadorKombi] +
				"\nvalor de tanque[n+1] = " + GasolinaNoTanque[contadorKombi+1]
				);
		*/
		
		// Different settings on the sliders
        JSlider tanqueSlider = new JSlider(0,40,((int)  Math.round(GasolinaNoTanque[contadorKombi]) ));
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

        
        

		
		/* BOT??O INSERT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */

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
				botaoAbastecimentoClicado = false;
				
				criarSpinnerAbastecimento();
				
				//tanqueSlider.setValue(35);
			}
		});

		/* BOT??O INSERT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
		
		
		
		

		/* NOME DO POSTO E VALOR DA GAS */

		JPanel nomePostoValorGasolinaPanel = new JPanel();
		nomePostoValorGasolinaPanel.setBackground(Color.decode("#442f1f"));
		nomePostoValorGasolinaPanel.setBounds(10, 290, widthPanel, heightPanel);

		JLabel nomePostoValorGasolinaLabel = new JLabel();
		nomePostoValorGasolinaLabel.setBackground(Color.decode("#004a93"));
		nomePostoValorGasolinaLabel.setText("brC R$ " + devolverprecoGasolinaTxT(precoGasolina[contadorPosto]) );
		nomePostoValorGasolinaLabel.setForeground(Color.decode("#ffffff"));
		nomePostoValorGasolinaLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		nomePostoValorGasolinaLabel.setVerticalAlignment(JLabel.CENTER);
		nomePostoValorGasolinaLabel.setHorizontalAlignment(JLabel.CENTER);

		/* NOME DO POSTO E VALOR DA GAS */



		/*DATA ??LTIMO ABASTECIMENTO PANEL*/

		JPanel abastecimentoDatePanel = new JPanel();
		abastecimentoDatePanel.setBackground(Color.decode("#442f1f"));
		abastecimentoDatePanel.setBounds(10, 400, widthPanel, heightPanel);

		JLabel abastecimentoDateLabel = new JLabel();
		abastecimentoDateLabel.setBackground(Color.decode("#004a93"));
		

		abastecimentoDateLabel.setText(formataroDiaMes(contadorPosto));

	
		abastecimentoDateLabel.setForeground(Color.decode("#ffffff"));
		abastecimentoDateLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		abastecimentoDateLabel.setVerticalAlignment(JLabel.CENTER);
		abastecimentoDateLabel.setHorizontalAlignment(JLabel.CENTER);

		/*DATA ??LTIMO ABASTECIMENTO PANEL*/



		/*VALOR ??LTIMO ABASTECIMENTO PANEL*/

		JPanel abastecimentoMoneyPanel = new JPanel();
		abastecimentoMoneyPanel.setBackground(Color.decode("#442f1f"));
		abastecimentoMoneyPanel.setBounds(10, 510, widthPanel, heightPanel);

		JLabel abastecimentoMoneyLabel = new JLabel();
		abastecimentoMoneyLabel.setBackground(Color.decode("#004a93"));
		
		abastecimentoMoneyLabel.setText("R$ " + valorAbastecimento[contadorPosto] + ".00");
		abastecimentoMoneyLabel.setForeground(Color.decode("#ffffff"));
		abastecimentoMoneyLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		abastecimentoMoneyLabel.setVerticalAlignment(JLabel.CENTER);
		abastecimentoMoneyLabel.setHorizontalAlignment(JLabel.CENTER);

		/*VALOR ??LTIMO ABASTECIMENTO PANEL*/



		/*km/litro PANEL*/

		JPanel kmLitroPanel = new JPanel();
		kmLitroPanel.setBackground(Color.decode("#442f1f"));
		kmLitroPanel.setBounds(10, 620, widthPanel, heightPanel);

		JLabel kmLitroLabel = new JLabel();
		kmLitroLabel.setBackground(Color.decode("#004a93"));
		
		calcular_km_litro();
		
		kmLitroLabel.setText(dc2.format(km_litro) + " km/l");
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

		
		
		
		/* BOT??O REFRESH +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/	
		
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
					kilometragemLabel.setText(formatarKilometragem(kilometragemNova));
					//inserirValorKilometragem();
					//FrameGuide.this.kilometragem[contadorKombi] = kilometragemNova;
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
					System.out.println("\nSa??da depois do refresh (com modifica????o apenas na kilometragem):\nA " + nomeDaKombosa + 
							" j?? rodou " + FrameGuide.this.kilometragem[contadorKombi-1] +
							" kilometros.\nTem " +
							GasolinaNoTanque[contadorKombi-1] +
							" de litros de gasolina no Tanque.\nE faz " +
							km_litro +
							" kilometros por litro."
					);
	
					tanqueSlider.setValue((int) Math.round(GasolinaNoTanque[contadorKombi-1])); //inserir valor slider
					
					
				} else {
					System.out.println("\nSa??da depois do refresh (Abastecimento inserido):\nA " + nomeDaKombosa + 
							" j?? rodou " + FrameGuide.this.kilometragem[contadorKombi] +
							" kilometros.\nTem " +
							GasolinaNoTanque[contadorKombi] +
							" de litros de gasolina no Tanque.\nE faz " +
							km_litro +
							" kilometros por litro.\nNova data de abastecimento " + 
							FrameGuide.this.diaAbastecimento[contadorPosto] +
							"/" + FrameGuide.this.mesAbastecimento[contadorPosto] +
							"/" + anoAbastecimento[contadorPosto] +
							" .\nO valor do novo Abastecimento foi de R$ " + valorAbastecimento[contadorPosto] +
							",00. A sigla do posto ?? " + siglaDoPosto[contadorPosto] +
							". O pre??o da gasolina no posto ?? " + dc3.format(precoGasolina[contadorPosto])
					);
				}

				/*
				if(botaoAbastecimentoClicado) {
					tanqueSlider.setValue((int) Math.round(GasolinaNoTanque[contadorKombi+1])); //inserir valor slider
				}else {
					tanqueSlider.setValue((int) Math.round(GasolinaNoTanque[contadorKombi])); //inserir valor slider
				}
				*/
				
				
			}
		});
		
		/* BOT??O REFRESH +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


		descobrirPrecoGasolina(precoGasolina[contadorPosto]);
		
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
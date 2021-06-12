package kombozice;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameGuide extends Kombi{	

	protected void criarCompFramePrincipal(int kilometragem, double gas, double valorGasolina, int diaAbastecimento, int mesAbastecimento, int valorAbastecimetnto, double consumo) {

		JFrame frame = new JFrame();	

		frame.setTitle("KOMBOSA!!!");

		//about size, color and visibility of window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(720,1080);

		frame.getContentPane().setBackground(Color.decode("#1f4921"));
		frame.setLocationRelativeTo(null);

		/*KILOMETRAGEM PANEL*/

		JPanel kilometragemPanel = new JPanel();		
		kilometragemPanel.setBackground(Color.decode("#003500"));
		kilometragemPanel.setBounds(10, 0, 700, 100); 

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
		kilometragemLabel.setForeground(Color.decode("#45ffff"));
		kilometragemLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		kilometragemLabel.setVerticalAlignment(JLabel.CENTER);
		kilometragemLabel.setHorizontalAlignment(JLabel.CENTER);	   

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

		tanquePanel.setBounds(10, 110, 700, 100);

		JLabel hpTanqueLabel = new JLabel();
		//hpTanqueLabel.setBackground(Color.red);
		//hpTanqueLabel.setText("055 123");

		ImageIcon barrinha = new ImageIcon("b.png");
		hpTanqueLabel.setIcon(barrinha);

		hpTanqueLabel.setHorizontalAlignment(JLabel.CENTER);
		hpTanqueLabel.setVerticalAlignment(JLabel.CENTER);

		/*TANQUE PANEL*/




		/* BOTÃO INSERT*/

		JButton insertButton = new JButton();
		insertButton.setText("Insert");
		insertButton.setBackground(Color.decode("#367f39"));
		insertButton.setForeground(Color.decode("#002232"));
		insertButton.setFont(new Font("Monospace",Font.PLAIN,50));
		insertButton.setBounds(110, 220, 500, 60);

		/* BOTÃO INSERT*/



		/* NOME DO POSTO E VALOR DA GAS */

		JPanel nomePostoValorGasolinaPanel = new JPanel();
		nomePostoValorGasolinaPanel.setBackground(Color.decode("#003500"));
		nomePostoValorGasolinaPanel.setBounds(10, 290, 700, 100);

		JLabel nomePostoValorGasolinaLabel = new JLabel();
		nomePostoValorGasolinaLabel.setBackground(Color.decode("#004a93"));
		nomePostoValorGasolinaLabel.setText("brC R$ " + valorGasolina);
		nomePostoValorGasolinaLabel.setForeground(Color.decode("#45ffff"));
		nomePostoValorGasolinaLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		nomePostoValorGasolinaLabel.setVerticalAlignment(JLabel.CENTER);
		nomePostoValorGasolinaLabel.setHorizontalAlignment(JLabel.CENTER);

		/* NOME DO POSTO E VALOR DA GAS */



		/*DATA ÚLTIMO ABASTECIMENTO PANEL*/

		JPanel abastecimentoDatePanel = new JPanel();
		abastecimentoDatePanel.setBackground(Color.decode("#003500"));
		abastecimentoDatePanel.setBounds(10, 400, 700, 100);

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

	
		abastecimentoDateLabel.setForeground(Color.decode("#45ffff"));
		abastecimentoDateLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		abastecimentoDateLabel.setVerticalAlignment(JLabel.CENTER);
		abastecimentoDateLabel.setHorizontalAlignment(JLabel.CENTER);

		/*DATA ÚLTIMO ABASTECIMENTO PANEL*/



		/*VALOR ÚLTIMO ABASTECIMENTO PANEL*/

		JPanel abastecimentoMoneyPanel = new JPanel();
		abastecimentoMoneyPanel.setBackground(Color.decode("#003500"));
		abastecimentoMoneyPanel.setBounds(10, 510, 700, 100);

		JLabel abastecimentoMoneyLabel = new JLabel();
		abastecimentoMoneyLabel.setBackground(Color.decode("#004a93"));
		
		abastecimentoMoneyLabel.setText("R$ " + valorAbastecimetnto + ",00");
		abastecimentoMoneyLabel.setForeground(Color.decode("#45ffff"));
		abastecimentoMoneyLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		abastecimentoMoneyLabel.setVerticalAlignment(JLabel.CENTER);
		abastecimentoMoneyLabel.setHorizontalAlignment(JLabel.CENTER);

		/*VALOR ÚLTIMO ABASTECIMENTO PANEL*/



		/*km/litro PANEL*/

		JPanel kmLitroPanel = new JPanel();
		kmLitroPanel.setBackground(Color.decode("#003500"));
		kmLitroPanel.setBounds(10, 620, 700, 100);

		JLabel kmLitroLabel = new JLabel();
		kmLitroLabel.setBackground(Color.decode("#004a93"));
		
		
		kmLitroLabel.setText(consumo + " km/l");
		kmLitroLabel.setForeground(Color.decode("#45ffff"));
		kmLitroLabel.setFont(new Font("Monospace",Font.PLAIN,90));
		kmLitroLabel.setVerticalAlignment(JLabel.CENTER);
		kmLitroLabel.setHorizontalAlignment(JLabel.CENTER);

		/*km/litro PANEL*/



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

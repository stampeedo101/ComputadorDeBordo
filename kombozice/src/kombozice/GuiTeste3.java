package kombozice;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiTeste3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();		
		frame.setTitle("KOMBI");		
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
	    kilometragemLabel.setText("055 123");
	    kilometragemLabel.setForeground(Color.decode("#45ffff"));
	    kilometragemLabel.setFont(new Font("Monospace",Font.PLAIN,90));
	    kilometragemLabel.setVerticalAlignment(JLabel.CENTER);
	    kilometragemLabel.setHorizontalAlignment(JLabel.CENTER);
	    
		
	    /*KILOMETRAGEM PANEL*/
	    
	    
	    /*TANQUE PANEL*/
	    
		JPanel tanquePanel = new JPanel();
	    tanquePanel.setBackground(Color.decode("#45a2ff"));
	    tanquePanel.setBounds(10, 110, 700, 100);
	    
	    JLabel hpTanqueLabel = new JLabel();
	    hpTanqueLabel.setBackground(Color.decode("#004a93"));
	    //hpTanqueLabel.setText("055 123");
	    
	    ImageIcon barrinha = new ImageIcon("b.png");
	    hpTanqueLabel.setIcon(barrinha);
	    
	    hpTanqueLabel.setHorizontalAlignment(JLabel.CENTER);
	    hpTanqueLabel.setVerticalAlignment(JLabel.CENTER);
	    
	    /*TANQUE PANEL*/
	    
	    
	    
	    
	    /* BOTÃO REFRESH*/
	    
	    JPanel refreshButton = new JPanel();
	    refreshButton.setBackground(Color.decode("#367f39"));
	    refreshButton.setBounds(110, 220, 500, 60);
	  
	    /* BOTÃO REFRESH*/
	    
	    
	    
	    /*DATA ÚLTIMO ABASTECIMENTO PANEL*/
	    
	    JPanel abastecimentoDatePanel = new JPanel();
	    abastecimentoDatePanel.setBackground(Color.decode("#003500"));
	    abastecimentoDatePanel.setBounds(10, 290, 700, 100);
	    
	    JLabel abastecimentoDateLabel = new JLabel();
	    abastecimentoDateLabel.setBackground(Color.decode("#004a93"));
	    abastecimentoDateLabel.setText("04/07");
	    abastecimentoDateLabel.setForeground(Color.decode("#45ffff"));
	    abastecimentoDateLabel.setFont(new Font("Monospace",Font.PLAIN,90));
	    abastecimentoDateLabel.setVerticalAlignment(JLabel.CENTER);
	    abastecimentoDateLabel.setHorizontalAlignment(JLabel.CENTER);
	    
	    /*DATA ÚLTIMO ABASTECIMENTO PANEL*/
	    
	    
	    
	    /*VALOR ÚLTIMO ABASTECIMENTO PANEL*/
	    
	    JPanel abastecimentoMoneyPanel = new JPanel();
	    abastecimentoMoneyPanel.setBackground(Color.decode("#003500"));
	    abastecimentoMoneyPanel.setBounds(10, 400, 700, 100);
	    
	    JLabel abastecimentoMoneyLabel = new JLabel();
	    abastecimentoMoneyLabel.setBackground(Color.decode("#004a93"));
	    abastecimentoMoneyLabel.setText("R$ 50,00");
	    abastecimentoMoneyLabel.setForeground(Color.decode("#45ffff"));
	    abastecimentoMoneyLabel.setFont(new Font("Monospace",Font.PLAIN,90));
	    abastecimentoMoneyLabel.setVerticalAlignment(JLabel.CENTER);
	    abastecimentoMoneyLabel.setHorizontalAlignment(JLabel.CENTER);
	    
	    /*VALOR ÚLTIMO ABASTECIMENTO PANEL*/
	    
	    
	    
	    /*km/litro PANEL*/
	    
	    JPanel kmLitroPanel = new JPanel();
	    kmLitroPanel.setBackground(Color.decode("#003500"));
	    kmLitroPanel.setBounds(10, 510, 700, 100);
	    
	    JLabel kmLitroLabel = new JLabel();
	    kmLitroLabel.setBackground(Color.decode("#004a93"));
	    kmLitroLabel.setText("6,5 km/l");
	    kmLitroLabel.setForeground(Color.decode("#45ffff"));
	    kmLitroLabel.setFont(new Font("Monospace",Font.PLAIN,90));
	    kmLitroLabel.setVerticalAlignment(JLabel.CENTER);
	    kmLitroLabel.setHorizontalAlignment(JLabel.CENTER);
	    
	    /*km/litro PANEL*/
	    

	    
	    /* INSERT LABELS*/
	    
	    
	    
	    kilometragemPanel.add(kilometragemLabel);
	   // frame.add(kilometragemLabel);
	    frame.add(kilometragemPanel);
	    kilometragemPanel.setVisible(true);
	    
	    tanquePanel.add(hpTanqueLabel);
	    //frame.add(hpTanqueLabel);
	    frame.add(tanquePanel);
	    tanquePanel.setVisible(true);
	    
	    
	    frame.add(refreshButton);
	    refreshButton.setVisible(true);
	    
	    
	    abastecimentoDatePanel.add(abastecimentoDateLabel);
	    //frame.add(abastecimentoDateLabel);
	    frame.add(abastecimentoDatePanel);
	    abastecimentoDatePanel.setVisible(true);
	    
	    
	    abastecimentoMoneyPanel.add(abastecimentoMoneyLabel);
	    //frame.add(abastecimentoMoneyLabel);
	    frame.add(abastecimentoMoneyPanel);
	    abastecimentoMoneyPanel.setVisible(true);
	    
	    
	    kmLitroPanel.add(kmLitroLabel);
	    //frame.add(kmLitroLabel);
	    frame.add(kmLitroPanel);
	    kmLitroPanel.setVisible(true);
	    
	    frame.setVisible(true);
	    
	    
	    /*
	    JLabel hpTanqueLabel = new JLabel();
	    hpTanqueLabel.setHorizontalTextPosition(JLabel.TOP);
	    hpTanqueLabel.setVerticalTextPosition(JLabel.TOP);
	    hpTanqueLabel.setBackground(Color.black);
	    hpTanqueLabel.setForeground(Color.black);
	    hpTanqueLabel.setBounds(20, 20, 600, 80);
	    tanquePanel.add(hpTanqueLabel);
	    */

	}

}

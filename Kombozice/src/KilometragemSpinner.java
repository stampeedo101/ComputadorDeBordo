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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class KilometragemSpinner {
	
	
	int kilometragemNova = 0;
	
	boolean kilometragemNovaEntrou = false;

	protected void criarSpinnerKilometragem() {
		
		JFrame f = new JFrame("Spinner Example");
		
		JPanel firstPanel = new JPanel();
		
		firstPanel.setBackground(Color.decode("#003500"));
		firstPanel.setBounds(10, 10, 700, 60);

		JLabel firstLabel = new JLabel();
		firstLabel.setBackground(Color.decode("#004a93"));
		firstLabel.setText("Insira novo valor de kilometragem");
		firstLabel.setForeground(Color.decode("#45ffff"));
		firstLabel.setFont(new Font("Monospace",Font.PLAIN,20));
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
				new SpinnerNumberModel(5, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step
		
		SpinnerModel value3 =  
				new SpinnerNumberModel(5, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step
		
		SpinnerModel value4 =  
				new SpinnerNumberModel(5, //initial value  
						0, //minimum value  
						9, //maximum value  
						1); //step
		
		JSpinner spinner0 = new JSpinner(value0);

		spinner0.setBounds(170,80,60,60);

		spinner0.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner0);


		JSpinner spinner1 = new JSpinner(value1);

		spinner1.setBounds(240,80,60,60);	            
		spinner1.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner1);

		JSpinner spinner2 = new JSpinner(value2);

		spinner2.setBounds(310,80,60,60);	            
		spinner2.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner2);

		JSpinner spinner3 = new JSpinner(value3);

		spinner3.setBounds(380,80,60,60);	            
		spinner3.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner3);

		JSpinner spinner4 = new JSpinner(value4);
		
		spinner4.setBounds(450,80,60,60);	            
		spinner4.setFont(new Font("Monospace",Font.PLAIN,50));
		f.add(spinner4);
		
		// (720-280)/2 = 360-190=170
		
		JButton insertButton = new JButton();
		
		insertButton.setText("Enter");
		insertButton.setBackground(Color.decode("#367f39"));
		insertButton.setForeground(Color.decode("#002232"));
		insertButton.setFont(new Font("Monospace",Font.PLAIN,20));
		insertButton.setBounds(620, 150, 100, 60);
		
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
				
				f.setState(Frame.ICONIFIED);
			}
		});

		firstPanel.add(firstLabel);
		f.add(firstPanel);
		

		
		
		f.add(insertButton);
		
		f.setSize(720,300);    
		f.setLayout(null);    
		f.setVisible(true);  
	}



}

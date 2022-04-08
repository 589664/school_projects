package init;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import brett.Brett;


public class Spill {


	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {

	    kjor();
		
		}//main

		/**
		 * 
		 * @throws InterruptedException
		 * @throws IOException 
		 */
		private static void kjor() throws InterruptedException, IOException {
			
			String[] valg = { "1", "2", "3", "4"};

			JComboBox<String> liste = new JComboBox<String>(valg);
			
			liste.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            }
	        });
			
		    Object[] options = {"Avslutt spillet","Spill"};
		    Object[] array = {"Hvor mange spillere ønsker du å simulere?"
					+ "\nDu kan velge mellom 1 - 4", liste};
		    
			
			int option = JOptionPane.showOptionDialog(null,
					array,
				    "Antall spillere",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[1]);
			
			if (option == 0) {
				JOptionPane.showMessageDialog(null, "Spillet er avsluttet!");
				System.exit(1);
			}
		
			else {
				int antS = Integer.valueOf(liste.getSelectedItem().toString());
				new Brett(antS).spill(antS);;
			}

		}//kjor end
	
	
}//class

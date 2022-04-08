package pakke_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.eltima.components.ui.DatePicker;

public class MAIN {
	
	private List<Reservasjon> res = new ArrayList<>();
	private List<Bil> biler;
	
	public static void main(String[] args) {
		new MAIN().kjor();
//		new MAIN().leverBilFaktura("SD91919");
	}
	
	private void kjor() {
		
		Selskap selskap = new Selskap("ClownUtleie", 91929394, new Adresse("Jokernords gate", 5055, "Koksness"));
		
		List<Kontor> kontorer = Arrays.asList(
				new Kontor(1, new Adresse("Berksmann gate", 5054, "Koksness"), 91898989),
				new Kontor(2, new Adresse("Trollmann gate", 5054, "Koksness"), 91897766)
				);
		
		
		biler = Arrays.asList(
				new Bil("SD91919", "Honda", "Rød", "B"),
				new Bil("SD91911", "Mercedes", "Rød", "B"),
				new Bil("SD91912", "BMW", "Rød", "B"),
				new Bil("SD91913", "Mercedes", "Rød", "D"),
				new Bil("SD91914", "Volvo", "Rød", "C"),
				new Bil("SD91915", "Batmo", "Blå", "C")
				);
		
		//init
		
		Object[] options = {"Lever bil","Reserver bil", "Leig nå!"};
		
		int option = JOptionPane.showOptionDialog(null,
				"Heisan, velkommen til utleieselskap " + selskap.getNavn() + " hva kan vi hjelpe deg med?",
			    "Utleieselskap",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[1]);
		
		switch (option) {
		case 0:
			
			
			break;
		case 1:
			
			Object[] options1 = {"Opprett ny profil", "Allerede registrert"};
			int option1 = JOptionPane.showOptionDialog(null,
					"Er du registrert kunde, eller ønsker å opprette ny profil?",
				    "Utleieselskap",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options1,
				    options1[1]);
			
			switch (option1) {
			case 0:
				JTextField forN = new JTextField();
				JTextField etterN = new JTextField();
				JTextField tlf = new JTextField();
				JTextField gate = new JTextField();
				JTextField postNr = new JTextField();
				JTextField postS = new JTextField();
				
				Object[] message = {
				    "Fornavn:", forN,
				    "Etternavn:", etterN,
				    "Telefon:", tlf,
				    "Gate:", gate,
				    "Postnr:", postNr,
				    "Poststed:", postS
				};

				JOptionPane.showConfirmDialog(null, message, "Opprett ny profil", JOptionPane.OK_CANCEL_OPTION);
				
				try {
					if (!forN.getText().equals("")) {
						FileWriter myWriter = new FileWriter("src\\pakke_1\\kunder.txt");
						Adresse a = new Adresse(gate.getText(), Integer.valueOf(postNr.getText()), postS.getText());
						Kunde k = new Kunde(forN.getText(), etterN.getText(), a, Integer.valueOf(tlf.getText()));
						
						myWriter.write(k.toString());
						myWriter.close();
						
					}
					
					reserverbil();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				break;

			default:
				break;
			}
		break;	

		default:
			break;
		}
		
		
		
	}
	
	private void reserverbil() {
		
		JFrame f = new JFrame("Reservasjon");
        f.setSize(400, 300);
        f.setLocation(500, 500);
        
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.PAGE_AXIS));
        
        //dato
        final DatePicker dato1;
        dato1 = getDatePicker();
        DatePicker dato2 = getDatePicker();
        JPanel datoL = new JPanel();
        datoL.setLayout(new FlowLayout());
        datoL.setBorder(new TitledBorder("Dato:"));
        datoL.add(new JLabel("Dato fra:"));
        datoL.add(dato1);
        datoL.add(new JLabel("Dato til:"));
        datoL.add(dato2);
        f.add(datoL);
        datoL.setMaximumSize(new Dimension(250,100));
        //kategori
        JPanel katL = new JPanel();
        katL.setLayout(new FlowLayout());
        katL.setBorder(new TitledBorder("Kategori"));
        
        katL.add(new JLabel("Velg kategori"));
        
        String[] valg = {"B", "C", "D"};
		JComboBox<String> liste = new JComboBox<String>(valg);
		katL.add(liste);
		f.add(katL);
		katL.setMaximumSize(new Dimension(200,50));
		
		JPanel kredittL = new JPanel();
		kredittL.setLayout(new FlowLayout());
		kredittL.setBorder(new TitledBorder("Kredittkort"));
		JTextField kredittkort = new JTextField(20);
		kredittL.add(new JLabel("Kredittkort:"));
		kredittL.add(kredittkort);
		kredittL.setMaximumSize(new Dimension(300,60));
		f.add(kredittL);
		
        
        JPanel knappL = new JPanel();
     	//knapper
        JButton b = new JButton("Reserver");
        knappL.add(b);
        JButton b1 = new JButton("Avbryt");
        knappL.add(b1);
        knappL.setMaximumSize(new Dimension(200,50));
        f.add(knappL);
			
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime fra = LocalDateTime.parse(dato1.getText(), formatter);
                LocalDateTime til = LocalDateTime.parse(dato2.getText(), formatter);
                
                Reservasjon res = new Reservasjon(fra, til, Long.valueOf(kredittkort.getText()), tilgjengeligBil(biler, liste.getSelectedItem().toString(),fra, til));
                
                try {
                	
                	FileWriter fileWriter = new FileWriter("src\\pakke_1\\reservasjon.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(res.toString());
                    bufferedWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                System.exit(0);
            }
        });
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
	}
	
	
	
	private void leverBilFaktura(String regnr) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\\\pakke_1\\\\reservasjon.txt"));
			String line = br.readLine();
			
			while (line != null && !line.equals(regnr)) {
				line = br.readLine();
			}
			
			if (line != null) {
				String regnrFF = line;
				removeLine(line);
				
				line = br.readLine();
                LocalDateTime fra = LocalDateTime.parse(line);
                removeLine(line);
                
                line = br.readLine();
                LocalDateTime til = LocalDateTime.parse(line);
                removeLine(line);
                
                line = br.readLine();
                String kredittkort = line;
                removeLine(line);
                
                
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void removeLine(String lineContent) throws IOException {
	    File file = new File("src\\\\pakke_1\\\\reservasjon.txt");
	    List<String> out = Files.lines(file.toPath())
	                        .filter(line -> !line.contains(lineContent))
	                        .collect(Collectors.toList());
	    Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	}
	
	
	
	private String tilgjengeligBil(List<Bil> biler, String klasse, LocalDateTime fra, LocalDateTime til) {
		
		List<String> reservert = res.stream()
				.map(x -> x.getRegnr())
				.collect(Collectors.toList());
		
		for (Bil bil : biler) {
			if (!reservert.contains(bil.getRegnr()) && bil.getKategori().equals(klasse)) {
				return bil.getRegnr();
			}
		}
		
		for (Reservasjon reserv : res) {
			if(reserv.getDatoF().compareTo(fra) < 0 && reserv.getDatoT().compareTo(til) > 0) {
				String kat = biler.stream()
				.filter(x -> x.getRegnr().equals(reserv.getRegnr()))
				.map(x -> x.getKategori())
				.findFirst()
				.orElse(null);
				if (kat != null && kat.equals(klasse)) {
					return reserv.getRegnr();
				}
			}
		}
		
		return null;
	}
	
	
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        //  format
//        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        String DefaultFormat = "yyyy-MM-dd HH:mm";
        //  current time
        Date date = new Date();
        //  Font
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        Dimension dimension = new Dimension(177, 24);

        int[] hilightDays = { 1, 3, 5, 7 };

        int[] disabledDays = { 4, 6, 5, 9 };
    //Construction method (initial time, time display format, font, control size)
        datepick = new DatePicker(date, DefaultFormat, font, dimension);

        datepick.setLocation(137, 83);//Set starting position
        /*
                 //You can also use setBounds() to directly set the size and position
        datepick.setBounds(137, 83, 177, 24);
        */
        //  Set the day of the month that needs to be highlighted
        datepick.setHightlightdays(hilightDays, Color.red);
        //  Set days that you don’t need in a month, grayed out
        datepick.setDisableddays(disabledDays);
        //  Set country
        datepick.setLocale(Locale.ENGLISH);
        //  Set the clock panel to be visible
        datepick.setTimePanleVisible(true);
        return datepick;
    }

}

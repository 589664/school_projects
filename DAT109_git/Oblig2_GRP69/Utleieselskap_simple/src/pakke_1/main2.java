package pakke_1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.eltima.components.ui.DatePicker;

public class main2 {
	
	public static void main(String[] args) {

        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);

        final DatePicker datepick;
        datepick = getDatePicker();
        DatePicker datepick2 = getDatePicker();
        f.add(datepick);
        f.add(datepick2);
        
        datepick2.setLocation(100, 200);

        JButton b = new JButton("Harald er en clown");
        b.setBounds(137, 183, 400, 30);
        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Get the date in the control:" + datepick.getValue());
                System.out.println(datepick.getValue());//This is a java.util.Date object
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateTime = LocalDateTime.parse(datepick.getText(), formatter);
                
                LocalDateTime dateTime2 = LocalDateTime.parse(datepick2.getText(), formatter);
                
                System.out.println(dateTime2.getDayOfMonth() - dateTime.getDayOfMonth());
            }
        });
        

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
        
        
        
        
        
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

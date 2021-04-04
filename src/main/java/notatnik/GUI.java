package notatnik;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {

    ImageIcon backg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/tlo.png")));

    JTextArea jTextArea = new JTextArea();
    JTextField jTextField = new JTextField();
    JTextField sciezka = new JTextField();
    String tytul;
    String tekst;
    String adres;

    public GUI(){
        setSize(600,650);
        setTitle("Notatnik");
        setLayout(null);
        setResizable(false);

        JButton button = new JButton("Zatwierdź");
        button.setBounds(240, 500, 100,50);
        button.addActionListener(this);
        add(button);

        JLabel label = new JLabel("NOTATNIK");
        label.setBounds(185,30,400,100);
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        add(label);

        JLabel labelSciezka = new JLabel("Ścieżka dostępu:");
        labelSciezka.setBounds(50,140,100,50);
        add(labelSciezka);

        JLabel labelTytul = new JLabel("Tytuł:");
        labelTytul.setBounds(115,190,100,50);
        add(labelTytul);

        JLabel labelTresc = new JLabel("Treść:");
        labelTresc.setBounds(110,230,100,50);
        add(labelTresc);

        sciezka.setBounds(150,150,280,30);
        add(sciezka);

        jTextField.setBounds(150,200,280,30);
        add(jTextField);

        jTextArea.setBounds(150,250,280, 200);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        jTextArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        add(jTextArea);

        JLabel tlo = new JLabel((Icon) backg);
        tlo.setBounds(0, 0, 600,650);
        add(tlo);
    }

    public void okno(GUI gui){
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tytul = jTextField.getText();
        tekst = jTextArea.getText();
        adres = sciezka.getText();
        Notatka notatka = new Notatka();
        try {
            notatka.nowa(tytul, tekst, adres);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
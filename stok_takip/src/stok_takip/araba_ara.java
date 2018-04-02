package stok_takip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stok_takip.araba_silme.Butonu_dinle;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class araba_ara {

    private JFrame frame;
    private JTextField textField;

    JButton btnNewButton;
    String MN;
    JTextArea textArea;
    JButton btnNewButton_1;

    public araba_ara() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Aranacak araban\u0131n motor numarasını giriniz");
        lblNewLabel.setBounds(175, 89, 250, 30);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(213, 130, 125, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Arabay\u0131 Ara");
        btnNewButton.setBounds(225, 167, 100, 30);
        frame.getContentPane().add(btnNewButton);

        textArea = new JTextArea();
        textArea.setBounds(100, 220, 400, 211);
        frame.getContentPane().add(textArea);

        btnNewButton_1 = new JButton("Ana Men\u00FC");
        btnNewButton_1.setBounds(225, 450, 145, 23);
        frame.getContentPane().add(btnNewButton_1);

        Butonu_dinle bt_dinle = new Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        Butonu_dinle bt_dinle2 = new Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle2);
    }

    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton){
                try{
                    MN = textField.getText();
                    String don = araba.arabaAra(MN);
                    textArea.setText(don);

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Aranirken bir hata meydana geldi", "HATA", 0);

                }
            }

            else if(e.getSource()==btnNewButton_1){
                try{

                    secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yap.
                    frame.dispose();//arabaara penceresini kapat.

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "bir hata meydana geldi", "HATA", 0);

                }
            }
        }
    }
}
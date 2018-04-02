package stok_takip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stok_takip.tum_arabalar.Butonu_dinle;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class kisi_ara {

    private JFrame frame;
    private JTextField textField;

    JButton btnNewButton ;
    JButton btnNewButton_1;
    String TC;
    JTextArea textArea;

    public kisi_ara() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 505, 499);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Aranacak ki\u015Finin TC_no'sunu giriniz : ");
        lblNewLabel.setBounds(154, 36, 238, 14);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(139, 75, 212, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Ki\u015Fi ara");
        btnNewButton.setBounds(206, 119, 89, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("AnaMen\u00FC");
        btnNewButton_1.setBounds(206, 407, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        textArea = new JTextArea();
        textArea.setBounds(97, 170, 295, 213);
        frame.getContentPane().add(textArea);

        Butonu_dinle bt_dinle = new Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);

        Butonu_dinle bt_dinle1 = new Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);
    }

    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton){
                try{
                    TC = textField.getText();
                    String don = kisi.kisiAra(TC);
                    textArea.setText(don);
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }

            else if(e.getSource()==btnNewButton_1){
                try{
                    secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yap.
                    frame.dispose();//arabaara penceresini kapat.
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }

        }
    }
}
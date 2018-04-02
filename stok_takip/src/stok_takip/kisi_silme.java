package stok_takip;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stok_takip.personel_kayit.Butonu_dinle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class kisi_silme {

    private JFrame frame;
    private JTextField textField;

    JButton btnNewButton;
    JButton btnNewButton_1;
    String TC;
    private JLabel lblNewLabel_1;

    public kisi_silme() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Ki\u015Fi Silme \u0130\u015Flemi");
        lblNewLabel.setBounds(100, 25, 151, 14);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(120, 50, 193, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Ki\u015Fiyi Sil");
        btnNewButton.setBounds(150, 90, 89, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("AnaMen\u00FC");
        btnNewButton_1.setBounds(150, 125, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        lblNewLabel_1 = new JLabel("TC no :");
        lblNewLabel_1.setBounds(55, 50, 46, 14);
        frame.getContentPane().add(lblNewLabel_1);

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
                    TC=textField.getText();
                    kisi.kisiSil(TC);

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
package stok_takip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import stok_takip.kisi_ara.Butonu_dinle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class personel_kayit {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    public JButton btnNewButton;
    public JButton btnNewButton_1;

    String ad;
    String soyAd;
    String unvan;
    String tcNo;
    String sifre;
    private JLabel lblNewLabel_5;

    public personel_kayit() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 462, 509);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(243, 66, 125, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(243, 114, 125, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(243, 167, 125, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(243, 228, 125, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(243, 285, 125, 20);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel = new JLabel("Ad\u0131n\u0131z\u0131 Giriniz");
        lblNewLabel.setBounds(64, 61, 116, 30);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Soyad\u0131n\u0131z\u0131 Giriniz");
        lblNewLabel_1.setBounds(64, 109, 116, 30);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u00DCnvan\u0131n\u0131z\u0131 Giriniz");
        lblNewLabel_2.setBounds(64, 162, 116, 30);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Tc No");
        lblNewLabel_3.setBounds(64, 223, 92, 30);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("\u015Eifre");
        lblNewLabel_4.setBounds(64, 275, 92, 30);
        frame.getContentPane().add(lblNewLabel_4);

        btnNewButton = new JButton("Kaydet");
        btnNewButton.setBounds(159, 335, 104, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Ana Men\u00FC");
        btnNewButton_1.setBounds(159, 385, 104, 23);
        frame.getContentPane().add(btnNewButton_1);

        lblNewLabel_5 = new JLabel("Personel Kay\u0131t \u0130\u015Flemi");
        lblNewLabel_5.setBounds(178, 28, 174, 14);
        frame.getContentPane().add(lblNewLabel_5);

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
                    ad=textField.getText();
                    soyAd=textField_1.getText();
                    unvan=textField_2.getText();
                    tcNo=textField_3.getText();
                    sifre=textField_4.getText();
                    personel.personelKayit(ad, soyAd, unvan, tcNo, sifre);

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hataaa meydana geldi", "HATA", 0);

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
package stok_takip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stok_takip.personel_kayit.Butonu_dinle;

import javax.swing.JButton;

public class kisi_kayit {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    JButton btnNewButton;
    JButton btnNewButton_1;

    String ad;
    String soyAd;
    String TC;
    String mail;

    public kisi_kayit() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 708, 589);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Ki\u015Fi Kay\u0131t \u0130\u015Flemi");
        lblNewLabel.setBounds(309, 39, 158, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Ki\u015Fi TC no giriniz :");
        lblNewLabel_1.setBounds(150, 117, 113, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Ki\u015Fi Ad\u0131 giriniz :");
        lblNewLabel_2.setBounds(150, 193, 102, 14);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Ki\u015Fi Soyad\u0131 giriniz :");
        lblNewLabel_3.setBounds(150, 262, 113, 14);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Ki\u015Fi Mail giriniz :");
        lblNewLabel_4.setBounds(150, 341, 113, 14);
        frame.getContentPane().add(lblNewLabel_4);

        textField = new JTextField();
        textField.setBounds(338, 114, 187, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(338, 190, 187, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(338, 259, 187, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(338, 338, 187, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        btnNewButton = new JButton("Ki\u015Fi Ekle");
        btnNewButton.setBounds(283, 407, 113, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("AnaMen\u00FC");
        btnNewButton_1.setBounds(283, 464, 113, 23);
        frame.getContentPane().add(btnNewButton_1);

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
                    ad=textField_1.getText();
                    soyAd=textField_2.getText();
                    mail=textField_3.getText();

                    kisi.kisiKayit(ad, soyAd, TC, mail);

                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }

            else if(e.getSource()==btnNewButton_1){
                try{
                    secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yapt.
                    frame.dispose();//arabaara penceresini kapat.
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);

                }
            }

        }
    }


}

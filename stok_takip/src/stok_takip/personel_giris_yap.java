package stok_takip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import javax.swing.*;

public class personel_giris_yap {

    JFrame frame;
    JTextField textField;
    JPasswordField textField_1;
    JLabel lblfotograf;
    JLabel lblfotograf2;
    JLabel lblfotograf3;
    JLabel lblfotografana;
    JButton btnGiriYapn;
    String ad = null;

    String sicil;
    String sifre;

    public personel_giris_yap() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setBounds(100, 100, 550, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel lblSicilNoGiriniz = new JLabel("Personel Sicil NO Giriniz");
        lblSicilNoGiriniz.setBounds(40, 86, 137, 14);
        frame.getContentPane().add(lblSicilNoGiriniz);

        textField = new JTextField();
        textField.setBounds(205, 83, 131, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);


        JLabel lblPersonelifreGiriniz = new JLabel("Personel \u015Eifre Giriniz");
        lblPersonelifreGiriniz.setBounds(40, 117, 155, 17);
        frame.getContentPane().add(lblPersonelifreGiriniz);

        textField_1 = new JPasswordField();
        textField_1.setBounds(205, 114, 131, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        btnGiriYapn = new JButton("Giri\u015F Yap\u0131n");
        btnGiriYapn.setBounds(205, 145, 131, 23);
        frame.getContentPane().add(btnGiriYapn);

        Butonu_dinle bt_dinle1 = new Butonu_dinle();
        btnGiriYapn.addActionListener(bt_dinle1);

        lblfotograf = new JLabel(new ImageIcon("C:\\Users\\melik\\Desktop\\b2.png"));
        lblfotograf.setBounds(360, 200, 174, 114);
        frame.getContentPane().add(lblfotograf);
        this.frame.setVisible(true);

        lblfotograf2 = new JLabel(new ImageIcon("C:\\Users\\melik\\Desktop\\merc.png"));
        lblfotograf2.setBounds(0, 200, 174, 114);
        frame.getContentPane().add(lblfotograf2);
        this.frame.setVisible(true);

        lblfotograf3 = new JLabel(new ImageIcon("C:\\Users\\melik\\Desktop\\pas.png"));
        lblfotograf3.setBounds(180, 200, 174, 114);
        frame.getContentPane().add(lblfotograf3);
        this.frame.setVisible(true);

        lblfotografana = new JLabel(new ImageIcon("C:\\Users\\melik\\Desktop\\ana.png"));
        lblfotografana.setBounds(50, 25, 610, 65);
        frame.getContentPane().add(lblfotografana);
        this.frame.setVisible(true);


    }

    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==btnGiriYapn){
                sicil = textField.getText();
                sifre = textField_1.getText();


                if(personel.personelGiris(sicil, sifre)==false){
                    JOptionPane.showMessageDialog(null, "Giriş Başarısız Lütfen sicil no ve şifreyi Kontrol Ediniz!!!", "HATA", 0);//hata mesajý
                }
                else{
                    ad=personel.ad_getir(sicil);
                    System.out.println(ad);
                    secenekler yeni = new secenekler(ad);


                    frame.dispose();
                }

            }

        }

    }
}

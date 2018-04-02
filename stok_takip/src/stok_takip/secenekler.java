package stok_takip;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

import stok_takip.personel_giris_yap.Butonu_dinle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class secenekler extends JFrame {

    JButton btnNewButton_10;
    JButton btnNewButton_9;
    JButton btnNewButton_8;
    JButton btnNewButton_7;
    JButton btnNewButton_6;
    JButton btnNewButton_5;
    JButton btnNewButton_4;
    JButton btnNewButton_3;
    JButton btnNewButton_2;
    JButton btnNewButton_1;
    JButton btnNewButton;

    public static JFrame frame;
    JLabel lblNewLabel = new JLabel("New label");
    private String ad;

    public secenekler(String ad) {
        initialize(ad);

    }

    public void initialize(String ad) {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        lblNewLabel.setForeground(Color.WHITE);


        lblNewLabel.setBounds(31, 27, 207, 14);
        lblNewLabel.setText("Personel : "+ad);


        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("Araba Ekleme");
        btnNewButton.setBounds(55, 88, 169, 25);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("Araba Silme");
        btnNewButton_1.setBounds(348, 88, 169, 25);
        frame.getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("Araba Arama");
        btnNewButton_2.setBounds(55, 160, 169, 25);
        frame.getContentPane().add(btnNewButton_2);

        btnNewButton_3 = new JButton("T\u00FCm Arabalar\u0131 Listeleme");
        btnNewButton_3.setBounds(348, 160, 169, 25);
        frame.getContentPane().add(btnNewButton_3);

        btnNewButton_4 = new JButton("Ki\u015Fi Arama");
        btnNewButton_4.setBounds(55, 226, 169, 25);
        frame.getContentPane().add(btnNewButton_4);

        btnNewButton_5 = new JButton("Personel Kay\u0131t \u0130\u015Flemi");
        btnNewButton_5.setBounds(348, 226, 169, 25);
        frame.getContentPane().add(btnNewButton_5);

        btnNewButton_6 = new JButton("Ki\u015Fi Kay\u0131t \u0130\u015Flemi");
        btnNewButton_6.setBounds(55, 295, 169, 25);
        frame.getContentPane().add(btnNewButton_6);

        btnNewButton_7 = new JButton("Ki\u015Fi Silme \u0130\u015Flemi");
        btnNewButton_7.setBounds(348, 295, 169, 25);
        frame.getContentPane().add(btnNewButton_7);

        btnNewButton_8 = new JButton("Araba Kiralama");
        btnNewButton_8.setBounds(55, 357, 169, 25);
        frame.getContentPane().add(btnNewButton_8);

        btnNewButton_9 = new JButton("Araba Teslim \u0130\u015Flemi");
        btnNewButton_9.setBounds(348, 357, 169, 25);
        frame.getContentPane().add(btnNewButton_9);

        btnNewButton_10 = new JButton("Program\u0131 Kapat");
        btnNewButton_10.setBounds(208, 450, 154, 30);
        frame.getContentPane().add(btnNewButton_10);

        Butonu_dinle bt_dinle10 = new Butonu_dinle();
        btnNewButton_10.addActionListener(bt_dinle10);

        Butonu_dinle bt_dinle9 = new Butonu_dinle();
        btnNewButton_9.addActionListener(bt_dinle9);

        Butonu_dinle bt_dinle8 = new Butonu_dinle();
        btnNewButton_8.addActionListener(bt_dinle8);

        Butonu_dinle bt_dinle7 = new Butonu_dinle();
        btnNewButton_7.addActionListener(bt_dinle7);

        Butonu_dinle bt_dinle6 = new Butonu_dinle();
        btnNewButton_6.addActionListener(bt_dinle6);

        Butonu_dinle bt_dinle5 = new Butonu_dinle();
        btnNewButton_5.addActionListener(bt_dinle5);

        Butonu_dinle bt_dinle4 = new Butonu_dinle();
        btnNewButton_4.addActionListener(bt_dinle4);

        Butonu_dinle bt_dinle3 = new Butonu_dinle();
        btnNewButton_3.addActionListener(bt_dinle3);

        Butonu_dinle bt_dinle2 = new Butonu_dinle();
        btnNewButton_2.addActionListener(bt_dinle2);

        Butonu_dinle bt_dinle1 = new Butonu_dinle();
        btnNewButton_1.addActionListener(bt_dinle1);

        Butonu_dinle bt_dinle = new Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);
    }

    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton_10){
                System.exit(0);
            }
            else if(e.getSource()==btnNewButton_9){
                frame.setVisible(false);
                araba_teslim yeni=new araba_teslim();
            }
            else if(e.getSource()==btnNewButton_8){
                frame.setVisible(false);
                araba_kiralama yeni=new araba_kiralama();
            }
            else if(e.getSource()==btnNewButton_7){
                frame.setVisible(false);
                kisi_silme yeni=new kisi_silme();
            }
            else if(e.getSource()==btnNewButton_6){
                frame.setVisible(false);
                kisi_kayit yeni=new kisi_kayit();
            }
            else if(e.getSource()==btnNewButton_5){
                frame.setVisible(false);
                personel_kayit yeni=new personel_kayit();
            }
            else if(e.getSource()==btnNewButton_4){
                frame.setVisible(false);
                kisi_ara yeni = new kisi_ara();
            }
            else if(e.getSource()==btnNewButton_3){
                frame.setVisible(false);
                tum_arabalar yeni = new tum_arabalar();

            }
            else if(e.getSource()==btnNewButton_2){
                frame.setVisible(false);
                araba_ara yeni = new araba_ara();

            }
            else if(e.getSource()==btnNewButton_1){
                frame.setVisible(false);
                araba_silme yeni = new araba_silme();

            }
            else if(e.getSource()==btnNewButton){
                frame.setVisible(false);
                araba_ekleme yeni = new araba_ekleme();

            }
        }
    }

}


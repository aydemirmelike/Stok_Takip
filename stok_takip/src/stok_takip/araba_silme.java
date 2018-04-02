package stok_takip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stok_takip.secenekler.Butonu_dinle;

import javax.swing.JButton;

public class araba_silme {

    private JFrame frame;
    private JTextField textField;
    JButton btnNewButton;

    String sase_numarasi;
    private JButton btnNewButton_1;

    public araba_silme() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Silinecek araban\u0131n sase numaras\u0131n\u0131 giriniz :");
        lblNewLabel.setBounds(75, 77, 250, 14);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(140, 115, 164, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Araba Sil");
        btnNewButton.setBounds(176, 173, 89, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("AnaMen\u00FC");
        btnNewButton_1.setBounds(176, 207, 89, 23);
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
                    sase_numarasi = textField.getText();
                    araba.arabaSil(sase_numarasi);

                    secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yap.
                    frame.dispose();//arabasil penceresini kapat.
                }
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Silinirken bir hata meydana geldi", "HATA", 0);

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

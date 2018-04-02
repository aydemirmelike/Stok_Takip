package stok_takip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stok_takip.kisi_silme.Butonu_dinle;

import javax.swing.JButton;

public class araba_kiralama {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    JButton btnNewButton_1 ;
    JButton btnNewButton ;

    String TC;
    String sase_numarasi;

    public araba_kiralama() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 623, 369);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Araba Kiralama Sistemi");
        lblNewLabel.setBounds(244, 31, 193, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Arabay\u0131 alan ki\u015Finin TC numaras\u0131n\u0131 giriniz :");
        lblNewLabel_1.setBounds(79, 86, 250, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Al\u0131nan araba\u0131n motor numaras\u0131n\u0131 giriniz :");
        lblNewLabel_2.setBounds(79, 154, 250, 14);
        frame.getContentPane().add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(340, 83, 160, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(340, 151, 160, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        btnNewButton = new JButton("Kirala");
        btnNewButton.setBounds(226, 219, 145, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton("AnaMen\u00FC");
        btnNewButton_1.setBounds(226, 276, 145, 23);
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
                    sase_numarasi=textField_1.getText();
                    kisi.arabaKiralama(TC , sase_numarasi);
                    JOptionPane.showMessageDialog(null, "Kiralama işlemi gerçekleştirildi", "Bilgi", 1);
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

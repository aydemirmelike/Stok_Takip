package stok_takip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import stok_takip.araba_ara.Butonu_dinle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class tum_arabalar {

    private JFrame frame;

    JTextArea textArea;
    JButton btnNewButton;
    private JScrollPane scrollPane;

    public tum_arabalar() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 835, 820);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 62, 819, 664);
        frame.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String tumu = "SELECT * FROM araba";
            ResultSet rs = st.executeQuery(tumu);

            while(rs.next())
            {

                String s_modeli = rs.getString("araba_modeli");
                String s_markasi = rs.getString("araba_markasi");
                String s_ulkesi = rs.getString("araba_ulkesi");
                String s_uretimyili = rs.getString("uretim_yili");
                String s_MN = rs.getString("motor_no");
                String s_SN = rs.getString("sase_numarasi");
                int s_kira = rs.getInt("kiralama");

                if(s_kira==1){
                    textArea.append("----->> Araba Modeli : "+s_modeli +"\n"+
                            "----->> Araba Markasi : "+s_markasi +"\n"+
                            "----->> Araba Ulkesi : "+s_ulkesi +"\n"+
                            "----->> Araba Uretimyili : "+s_uretimyili +"\n"+
                            "----->> Araba Motor_No : "+s_MN +"\n"+
                            "----->> Araba Sase No : "+s_SN +"\n"+
                            "----->> !!!Araba Kiralanmistir.\n"+
                            "---------------------------------------------------------\n\n");

                }
                else{
                    textArea.append("----->> Araba Modeli: "+s_modeli +"\n"+
                            "----->> Araba Markasi : "+s_markasi +"\n"+
                            "----->> Araba Ulkesi : "+s_ulkesi +"\n"+
                            "----->> Araba Uretimyili : "+s_uretimyili +"\n"+
                            "----->> Araba Motor No : "+s_MN +"\n"+
                            "----->> Araba Sase No : "+s_SN +"\n"+
                            "----->> KİRALANABİLİR\n"+
                            "-------------------------------------------------------------\n\n");

                }
            }

        }

        catch(Exception a){
            System.err.println("Hata ! ");

            System.err.println(a.getMessage());
        }

        JLabel lblNewLabel = new JLabel("T\u00FCm Arabalar listelenmektedir");
        lblNewLabel.setBounds(335, 37, 220, 14);
        frame.getContentPane().add(lblNewLabel);

        btnNewButton = new JButton("Anamen\u00FC");
        btnNewButton.setBounds(335, 737, 141, 23);
        frame.getContentPane().add(btnNewButton);
        Butonu_dinle bt_dinle = new Butonu_dinle();
        btnNewButton.addActionListener(bt_dinle);
    }

    public class Butonu_dinle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton){
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

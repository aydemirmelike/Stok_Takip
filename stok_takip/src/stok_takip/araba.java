//-------------araba-------------------
package stok_takip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class araba {

    public String araba_modeli;
    public String araba_markasi;
    public String araba_ulkesi;
    public int uretim_yili;
    public String Motor_no;
    private static String sase_numarasi;
    public int kopya_sayisi = 0;

    public static String arabaAra(String ara){

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String ara_sorgusu = "SELECT * FROM araba WHERE motor_no='"+ara+"'";
            ResultSet rs = st.executeQuery(ara_sorgusu);

            boolean deneme=rs.next();
            if(deneme==true)
            {
                String s_modeli = rs.getString("araba_modeli");
                String s_marka = rs.getString("araba_markasi");
                String s_ulke = rs.getString("araba_ulkesi");
                String s_uretimyili = rs.getString("uretim_yili");
                String s_motor = rs.getString("motor_no");
                String s_sase = rs.getString("sase_numarasi");
                int s_kiralama = rs.getInt("kiralama");

                String sonuc = "Araba Modeli : "+s_modeli +"\n"+
                        "Araba Markası : "+s_marka +"\n"+
                        "\u00FCretim Yeri : "+s_ulke +"\n"+
                        "\u00FCretim Yılı : "+s_uretimyili +"\n"+
                        "Motor Numarası : "+s_motor +"\n"+
                        "Sase Numarası : "+s_sase +"\n"
                        ;

                if(s_kiralama==1){
                    sonuc = sonuc + "\nArabayi bir baskasi kiraladi.";
                }
                else{
                    sonuc = sonuc + "\nArabayi kiralayabilirsiniz";
                }

                return sonuc;

            }
            else{

                String sonuc = "araba bulunamadi";
                return sonuc;
            }
        }

        catch(Exception a){
            String sonuc = "hata";
            return sonuc;

        }

    }

    public static void arabaKayit(String araba_modeli,String marka,String ulke,int uretim_yili,String motor_no){

        araba temp = new araba();

        temp.araba_modeli=araba_modeli;
        temp.araba_markasi=marka;
        temp.araba_ulkesi=ulke;
        temp.uretim_yili=uretim_yili;
        temp.Motor_no=motor_no;

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String sorgu3 = "SELECT araba_modeli FROM araba WHERE araba_modeli='"+temp.araba_modeli+"'";

            ResultSet rs = st.executeQuery(sorgu3);

            while (rs.next())
            {
                temp.kopya_sayisi++;

                String s_adi = rs.getString("araba_modeli");

            }
            temp.sase_numarasi =sase_numarasi_olustur(temp.uretim_yili,temp.kopya_sayisi,temp.Motor_no);
            String sorgu2 =  "INSERT INTO araba(araba_modeli , araba_markasi , araba_ulkesi , uretim_yili , motor_no , sase_numarasi , araba_kopya_sayisi , kiralama)"
                    + "VALUES ('"+temp.araba_modeli+"','"+temp.araba_markasi+"','"+temp.araba_ulkesi+"',"+temp.uretim_yili+",'"+temp.Motor_no+"','"+temp.sase_numarasi+"',"+temp.kopya_sayisi+" , "+0+")";

            int sor = st.executeUpdate(sorgu2);

            st.close();
            JOptionPane.showMessageDialog(null, "Kayıt işlemi gerçekleştirildi.", "Bilgi", 1);
        }

        catch(Exception a){
            JOptionPane.showMessageDialog(null, "Bir hata meydana geldi.....!!", "Hata", 0);

        }


    }

    public static void arabaSil(String sase_numarasi){
        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String tumu = "delete from araba where sase_numarasi='"+ sase_numarasi +"' ORDER BY araba_kopya_sayisi DESC LIMIT 1 ";
            int sor = st.executeUpdate(tumu);
            if(sor==1){
                JOptionPane.showMessageDialog(null, "Silme islemi basari ile gerçeklesti", "Bilgi", 1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Girdiginiz sase numarasi bulunamadi","Bilgi", -1);
            }

        }

        catch(Exception a){
            JOptionPane.showMessageDialog(null, "Hata meydana geldi","Bilgi", -1);
        }

    }

    public araba(String araba_modeli, String araba_markasi, String araba_ulkesi, int uretim_yili, String mOTOR_no,
                 String sase_numarasi) {

        this.araba_modeli = araba_modeli;
        this.araba_markasi = araba_markasi;
        this.araba_ulkesi = araba_ulkesi;
        this.uretim_yili = uretim_yili;
        this.sase_numarasi = sase_numarasi;
        Motor_no = mOTOR_no;

    }

    public static String sase_numarasi_olustur(int uretimyili , int kopya_sayisi , String Motor_no){
        return Motor_no.substring(4,7)+"K"+kopya_sayisi+uretimyili;
    }

    public araba(){
    }

}

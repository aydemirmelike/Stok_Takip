package stok_takip;

import java.sql.Connection;
import java.time.temporal.ChronoUnit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class kisi {

    private String tcNo;
    public String ad;
    public String soyAd;
    private String mail;
    public String arabaKiralamaGunu;
    public String arabaTeslimGunu;
    static Scanner klavye3 = new Scanner(System.in);

    public kisi(String tcNo, String ad, String soyAd, String mail, String arabaKiralamaGunu, String arabaTeslimGunu) {

        this.tcNo = tcNo;
        this.ad = ad;
        this.soyAd = soyAd;
        this.mail = mail;
        this.arabaKiralamaGunu = arabaKiralamaGunu;
        this.arabaTeslimGunu = arabaTeslimGunu;
    }


    public kisi(){

    }

    public String getTcNo() {
        return tcNo;
    }
    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public static String kisiAra(String ara){

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String ara_sorgusu = "SELECT * FROM kisi WHERE TC_no='"+ara+"'";
            ResultSet rs = st.executeQuery(ara_sorgusu);

            boolean deneme=rs.next();
            if(deneme==true)
            {

                String s_adi = rs.getString("kisi_adi");
                String s_soyadi = rs.getString("kisi_soyadi");
                String s_mail = rs.getString("mail");
                String s_alis = rs.getString("alis_tarihi");
                String s_donus = rs.getString("donus_tarihi");
                String s_araba = rs.getString("alinan_araba");


                String sonuc ="Kisi Adi : "+s_adi +"\n"+
                        "Kisi Soyadi : "+s_soyadi +"\n"+
                        "Kisi Maili : "+s_mail +"\n"+
                        "Araba kiralama tarihi : "+s_alis +"\n"+
                        "Araba teslim tarihi : "+s_donus +"\n"+
                        "Kiraladigi arabanın motor numarası : "+s_araba +"\n"
                        ;

                return sonuc;
            }
            else{
                return "kisi bulunamadi..";
            }
        }

        catch(Exception a){
            return "hata";

        }

    }

    public static void kisiSil(String sil){

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();
            String tumu = "delete from kisi where TC_no='"+sil+"'";

            int sor = st.executeUpdate(tumu);
            if(sor==1){
                JOptionPane.showMessageDialog(null, "Kisi silme işlemi başarılı şekilde gerçekleşti", "Bilgi", 1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Silinecek kişi bulunamadı", "Hata", 0);
            }

        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

    }

    public static void kisiKayit(String ad,String soyAd,String tcNo,String mail){

        kisi temp = new kisi();

        temp.arabaKiralamaGunu = "0";
        temp.arabaTeslimGunu = "0";

        temp.ad=ad;
        temp.soyAd=soyAd;
        temp.mail=mail;
        temp.tcNo=tcNo;

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            Statement st = conn.createStatement();

            String sorgu2 =  "INSERT INTO kisi(TC_no , kisi_adi , kisi_soyadi , mail , alis_tarihi , donus_tarihi , alinan_araba)"
                    + "VALUES ('"+temp.tcNo+"','"+temp.ad+"','"+temp.soyAd+"','"+temp.mail+"','"+temp.arabaKiralamaGunu+"','"+temp.arabaTeslimGunu+"', '"+0+"')";
            int sor = st.executeUpdate(sorgu2);
            st.close();
            JOptionPane.showMessageDialog(null, "Kayıt işlemi gerçekleştirildi.", "Bilgi", 1);
        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }


    }

    public static void arabaKiralama(String tc , String sase_numarasi){
        DateTimeFormatter sekil = DateTimeFormatter.ofPattern("dd MM yyyy");
        LocalDate now = LocalDate.now();
        LocalDate sonra;

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            String simdi = String.valueOf(sekil.format(now));
            sonra = now.plusDays(15);
            String donus = String.valueOf(sekil.format(sonra));

            Statement st = conn.createStatement();
            float ata = (float) 0;
            String sorgu2 =  "UPDATE kisi SET alis_tarihi='"+simdi+"' , donus_tarihi='"+donus+"' , alinan_araba='"+sase_numarasi+"' WHERE TC_no='"+tc+"'";
            String sorgu3 = "UPDATE araba SET kiralama="+1+" WHERE sase_numarasi='"+sase_numarasi+"'";
            String sorgu4 = "select kiralama from araba";
            int sor = st.executeUpdate(sorgu2);
            int sor2 = st.executeUpdate(sorgu3);

            st.close();
        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

    }

    public static void arabaTeslim(String tc , String sase_numarasi){
        DateTimeFormatter sekil = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate now = LocalDate.now();
        LocalDate sonra;

        try{
            String myDriver = "com.mysql.jdbc.Driver";
            String db = "jdbc:mysql://localhost/stok_takip?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(db, "root", "");

            SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
            Statement st = conn.createStatement();

            String tarih = "SELECT donus_tarihi FROM kisi";
            ResultSet rs = st.executeQuery(tarih);
            while(rs.next()){
                String s_tarih = rs.getString("donus_tarihi");
                String once = s_tarih;

            }
            String sorgu2 =  "UPDATE kisi SET alis_tarihi='"+0+"' , donus_tarihi='"+0+"' , alinan_araba='"+0+"' WHERE TC_no='"+tc+"'";
            String sorgu3 = "UPDATE araba SET kiralama="+0+" WHERE sase_numarasi='"+sase_numarasi+"'";
            int sor = st.executeUpdate(sorgu2);
            int sor2 = st.executeUpdate(sorgu3);
            if(sor==1){

                JOptionPane.showMessageDialog(null, "Teslim etme işlemi gerçekleştirildi", "Bilgi", 1);

            }
            else{
                System.out.println("! Işlem gerçekleştirilemedi..");
            }
            st.close();
        }

        catch(Exception a){
            System.err.println("Hata ! ");
            System.err.println(a.getMessage());
        }

    }
}

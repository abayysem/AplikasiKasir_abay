/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_ujikom;
//import java.util.Scanner;
//import javax.swing.JOptionPane;
/**
 *
 * @author lab.pplg
 */
//Nomor 1
//public class latihan {
//    public static void main(String args[]){
//    String nama, nim, jurusan, kota_asal;
//    nama = "akbar";   
//    nim = "10012006";      
//    kota_asal = "Tasikmalaya";
//     
//    System.out.println("BIODATA");
//    System.out.println("========================================");      
//    System.out.println("Nama: "      + nama);
//    System.out.println("NIM: "       + nim);
//    System.out.println("Singkat Kota: "       + kota_asal.substring(0,5));
//  }
//}

//Nomor 2
//public class latihan2{
//      public static void main(String args[]){
//          int harga;
//          double besar_diskon, bayar, diskon;
//          Scanner ketik = new Scanner(System.in);
//          System.out.print("Harga barang : RP.");
//          harga = ketik.nextInt();
//          System.out.print("Diskon : ");
//          diskon = ketik.nextInt();
//          besar_diskon = (diskon/100)* harga;
//          bayar = harga-besar_diskon;
//          
//          System.out.println("Harga Barang :" +harga);
//          System.out.println("Diskon :" +diskon+ "%");
//          System.out.println("Dipotong : RP." +besar_diskon);
//          System.out.println("Bayar :" +bayar);
//      }  
//    }

//Nomok 4
//public class latihan{
//      public static void main(String args[]){
//          int nilai1,nilai2,hasil;
//          nilai1 = Integer.parseInt(JOptionPane.showInputDialog("Masukan nilai 1"));
//          nilai2 = Integer.parseInt(JOptionPane.showInputDialog("Masukan nilai 2"));
//          hasil=nilai1*nilai2;
//          JOptionPane.showMessageDialog(null,"Nilai 1:"+nilai1 +"\nNilai2 :" 
//          +nilai2 +"\nHasil : "+hasil);
//      }  
//    }

//Nomok 3
//    public class latihan{
//        public static void main(String args[]){
//        int nilai1,nilai2,nilai3;
//        double rata;
//        String Hasil;
//        nilai1 = Integer.parseInt(JOptionPane.showInputDialog("Masukan nilai 1"));
//        nilai2 = Integer.parseInt(JOptionPane.showInputDialog("Masukan nilai 2"));
//        nilai3 = Integer.parseInt(JOptionPane.showInputDialog("Masukan nilai 3"));
//        rata=(nilai1+nilai2+nilai3)/3;
//        
//        if(rata>=60){
//            Hasil="Lulus";
//        }else{
//            Hasil="Gagal";
//        }
//        
//        JOptionPane.showMessageDialog(null,"Nilai 1: "+nilai1 + "\nNilai 2 :"
//        +nilai2 +"\nNilai 3 :"+nilai3 +"\nRata-rata : "+rata+"\nKeterangan : "+Hasil);
//    }}

    public class latihan{
        public static void main(String args[]){
         int i,j,k;
         for (i=5;i>=1;i--){
             for (j=1;j<=5 - i;j++){
                System.out.print(j);
            }
             for(k=1; k<=i; k++){
                System.out.print(k); 
             }
             System.out.println();
           }
        }
    }
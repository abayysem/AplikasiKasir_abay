/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pbo_ujikom;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.util.Date;
/**
 *
 * @author lab.pplg
 */
public class FromPenjualan extends javax.swing.JFrame {
    Connection konek;
    PreparedStatement pst, pst2;
    ResultSet rst;
    int inputstok, inputstok2, inputharga, inputjumlah, kurangistok, tambahstok;
    String harga, idproduk, idprodukpenjualan, iddetail, jam, tanggal, sub_total;
    
    public FromPenjualan() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        konek = Koneksi.koneksiDB();
        detail();
        tampilJam();
        autonumber();
        penjumlahan();
        main();
    }
    
    private void main(){
        txtJam.setEnabled(false);
        txtTanggal.setEnabled(false);
        txtIdpenjualan.setEnabled(false);
        txtTotal.setEnabled(false);
        txtKembalian.setEnabled(false);
    }
    
    private void simpan(){
        String tgl = txtTanggal.getText();
        String jam = txtJam.getText();
        try {
            String sql="insert into penjualan (PenjualanID,DetailID,TanggalPenjualan,JamPenjualan,TotalHarga) value (?,?,?,?,?)";
            pst = konek.prepareStatement(sql);
            pst.setString(1, txtIdpenjualan.getText());
            pst.setString(2, iddetail);
            pst.setString(3, tgl);
            pst.setString(4, jam);
            pst.setString(5, txtTotal.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void total(){
        int total, bayar, kembalian;
            total = Integer.parseInt(txtBayar.getText());
            bayar = Integer.parseInt(txtTotal.getText());
            kembalian = total-bayar;
            String ssub =String.valueOf(kembalian);
            txtKembalian.setText(ssub);
    }
    
    public void clsr(){
    txtJumlah.setText("");
    txtIdpenjualan.setEnabled(false);
    }
    
    public void cari(){
        try{
            String sql ="select * from produk where NamaProduk LIKE '%"+txtIdproduk.getText()+"%' ";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            tblProduk.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void kurang_stok(){
        int qty;
        qty =Integer.parseInt(txtJumlah.getText());
        kurangistok=inputstok-qty;
    }
    
    private void subtotal(){
        int jumlah, sub;
            jumlah= Integer.parseInt(txtJumlah.getText());
            sub=(jumlah*inputharga);
            sub_total=String.valueOf(sub);
    }
    
    public void tambah_stok(){
        try{
            String update="update produk set Stok='"+tambahstok+"' where ProdukID='"+idproduk+"' ";
            pst2=konek.prepareStatement(update);
            pst2.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ambil_stok(){
        try{
            String sql="select * from produk where ProdukID='"+idproduk+"'";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            if(rst.next()){
                String stok=rst.getString(("Stok"));
                inputstok2= Integer.parseInt(stok);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void penjumlahan(){
        int totalBiaya = 0;
        int subtotal;
        DefaultTableModel dataModel = (DefaultTableModel) tblPenjualan.getModel();
        int jumlah = tblPenjualan.getRowCount();
        for (int i=0; i<jumlah; i++){
        subtotal = Integer.parseInt(dataModel.getValueAt(i, 4).toString());
        totalBiaya += subtotal;
        }
        txtTotal.setText(String.valueOf(totalBiaya));
    }
    
    public void autonumber(){
        try{
            String sql = "SELECT MAX(RIGHT(PenjualanID,3)) AS NO FROM Penjualan";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            while (rst.next()){
                if (rst.first() == false) {
                    txtIdpenjualan.setText("IDP001");
                } else {
                    rst.last();
                    int auto_id = rst.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    txtIdpenjualan.setText("IDP" + no);
                }
            }
            rst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void detail(){
        try{
            String kode_detail=txtIdpenjualan.getText();
            String KD="D"+kode_detail;
            String sql="select * from detailpenjualan where DetailID='"+KD+"' ";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            tblPenjualan.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tampilJam(){
        Thread clock= new Thread(){
            public void run(){
                for(;;){
                    Calendar cal=Calendar.getInstance();
                    SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
                    SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
                    txtJam.setText(format.format(cal.getTime()));
                    txtTanggal.setText(format2.format(cal.getTime()));
                try { sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FromPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        };
        clock.start();
    }
    
    /**
     * Creates new form FromPenjualan
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtJam = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdproduk = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPenjualan = new javax.swing.JTable();
        txtJumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdpenjualan = new javax.swing.JTextField();
        btnTambah = new javax.swing.JToggleButton();
        btnHapus = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        btnKeluar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSAKSI PENJUALAN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 50, 450, 40);

        txtJam.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJam.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtJam);
        txtJam.setBounds(1220, 40, 100, 22);

        txtTanggal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTanggal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTanggal.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        getContentPane().add(txtTanggal);
        txtTanggal.setBounds(1330, 40, 90, 22);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Masukan Kode Produk");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 160, 230, 24);

        txtIdproduk.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        getContentPane().add(txtIdproduk);
        txtIdproduk.setBounds(100, 202, 220, 30);

        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-search-20.png"))); // NOI18N
        btnCari.setText("cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari);
        btnCari.setBounds(340, 200, 80, 30);

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduk);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 250, 452, 230);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kode Transaksi");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(670, 170, 170, 24);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data Transaksi");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(670, 200, 160, 24);

        tblPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenjualanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPenjualan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(670, 250, 452, 230);

        txtJumlah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        getContentPane().add(txtJumlah);
        txtJumlah.setBounds(210, 510, 210, 30);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jumlah");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 510, 80, 24);

        txtIdpenjualan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        getContentPane().add(txtIdpenjualan);
        txtIdpenjualan.setBounds(820, 170, 220, 30);

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-add-20.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambah);
        btnTambah.setBounds(450, 510, 100, 30);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-delete-20.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(1020, 530, 100, 27);

        btnBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-basket-20.png"))); // NOI18N
        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBayar);
        btnBayar.setBounds(1020, 580, 100, 27);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(670, 510, 41, 24);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bayar");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(670, 570, 47, 24);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kembalian");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(670, 640, 90, 24);

        txtTotal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        getContentPane().add(txtTotal);
        txtTotal.setBounds(790, 510, 200, 30);

        txtBayar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBayar);
        txtBayar.setBounds(790, 572, 200, 30);

        txtKembalian.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        getContentPane().add(txtKembalian);
        txtKembalian.setBounds(790, 632, 200, 30);

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-logout-20.png"))); // NOI18N
        btnKeluar.setText("Keluar");
        getContentPane().add(btnKeluar);
        btnKeluar.setBounds(1020, 630, 100, 27);

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/Halamain dll.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 1440, 900);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
cari();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
try{
    int row=tblProduk.getSelectedRow();
    String tabel_klik=(tblProduk.getModel().getValueAt(row, 0).toString());
    String sql= "select * from produk where ProdukID='"+tabel_klik+"' ";
    pst=konek.prepareStatement(sql);
    rst=pst.executeQuery();
    if (rst.next()) {
        idproduk=rst.getString(("ProdukID"));
        String stok=rst.getString(("Stok"));
        inputstok=Integer.parseInt((stok));
        harga=rst.getString(("Harga"));
        inputharga=Integer.parseInt((harga));
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
    }//GEN-LAST:event_tblProdukMouseClicked

    private void tblPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenjualanMouseClicked
try{
    int row=tblPenjualan.getSelectedRow();
    idprodukpenjualan=(tblPenjualan.getModel().getValueAt(row, 1).toString());
    String sql="select * from detailpenjualan where ProdukID='"+idprodukpenjualan+"' ";
    pst=konek.prepareStatement(sql);
    rst=pst.executeQuery();
    if (rst.next()) {
        String jumlah=rst.getString(("JumlahProduk"));
        inputjumlah=Integer.parseInt(jumlah);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

        // TODO add your handling code here:
    }//GEN-LAST:event_tblPenjualanMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
subtotal();
kurang_stok();
try{
    String kode_detail=txtIdpenjualan.getText();
    iddetail="D"+kode_detail;
    String sql="insert into detailpenjualan (DetailID,ProdukID,Harga,JumlahProduk,Subtotal) value (?,?,?,?,?)";
    String update="update produk set Stok='"+kurangistok+"' where ProdukID='"+idproduk+"' ";
    pst=konek.prepareStatement(sql);
    pst2=konek.prepareStatement(update);
    pst.setString(1, iddetail);
    pst.setString(2, idproduk);
    pst.setString(3, harga);
    pst.setString(4, txtJumlah.getText());
    pst.setString(5, sub_total);
    pst.execute();
    pst2.execute();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
detail();
penjumlahan();
cari();
clsr();
// TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
try{
    String sql ="delete from detailpenjualan where ProdukID=?";
    pst=konek.prepareStatement(sql);
    pst.setString(1, idprodukpenjualan);
    pst.execute();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
detail();
penjumlahan();
tambah_stok();
cari();

// TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
total();
        simpan();
        autonumber();
        detail();
        txtTotal.setText("");
        txtBayar.setText("");
        txtKembalian.setText("");
        txtIdproduk.setText("");
        cari();
// TODO add your handling code here:
    }//GEN-LAST:event_btnBayarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JToggleButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPenjualan;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtIdpenjualan;
    private javax.swing.JTextField txtIdproduk;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pbo_ujikom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author lab.pplg
 */
public class FromProduk extends javax.swing.JFrame {
    Connection konek;
    PreparedStatement pst;
    ResultSet rst;
    /**
     * Creates new form FromProduk
     */
    public FromProduk() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        konek = Koneksi.koneksiDB();
        mulai();
        tampilWaktu();
        updateTabel();
    }

    public void mulai() {
        txtJam.setEnabled(false);
        txtTanggal.setEnabled(false);
    }

    public void tampilWaktu(){
        Thread clock = new Thread(){
            public void run(){
                for(;;){
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat jam = new SimpleDateFormat("hh:mm:ss");
                    SimpleDateFormat Tanggal = new SimpleDateFormat("dd-MM-yyy");
                    txtJam.setText(jam.format(cal.getTime()));
                    txtTanggal.setText(Tanggal.format(cal.getTime()));
                }
            }
        };
        clock.start();
    }
    public void updateTabel(){
        try{
            String sql = "select * from produk";
            pst = konek.prepareStatement(sql);
            rst = pst.executeQuery();
            tblProduk.setModel(DbUtils.resultSetToTableModel(rst));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void clear(){
        txtId.setText("");
        txtNama.setText("");
        txtHarga.setText("");
        txtStok.setText("");
    }

    public void simpan(){
        try{
            String sql = "insert into produk (ProdukID,NamaProduk,Harga,Stok) value (?,?,?,?)";
            pst = konek.prepareStatement(sql);
            pst.setString(1,txtId.getText());
            pst.setString(2,txtNama.getText());
            pst.setString(3,txtHarga.getText());
            pst.setString(4,txtStok.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"data berhasil disimpan");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        updateTabel();
        clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        txtJam = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        txtHarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INPUT PRODUK");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(540, 130, 350, 47);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Produk");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 360, 160, 30);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Produk");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 420, 160, 30);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 490, 160, 30);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stok");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 560, 160, 30);

        txtId.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        getContentPane().add(txtId);
        txtId.setBounds(320, 360, 260, 30);

        txtNama.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        getContentPane().add(txtNama);
        txtNama.setBounds(320, 420, 260, 30);

        txtStok.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        getContentPane().add(txtStok);
        txtStok.setBounds(320, 560, 260, 30);

        btnSimpan.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-save-20.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(660, 490, 100, 32);

        btnEdit.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-edit-20.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(660, 370, 100, 30);

        btnHapus.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-delete-20.png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(660, 430, 100, 30);

        btnKeluar.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-logout-20.png"))); // NOI18N
        btnKeluar.setText("KELUAR");
        getContentPane().add(btnKeluar);
        btnKeluar.setBounds(660, 560, 100, 30);

        txtJam.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJam.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtJam);
        txtJam.setBounds(1211, 50, 90, 22);

        txtTanggal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTanggal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtTanggal);
        txtTanggal.setBounds(1311, 50, 90, 22);

        tblProduk.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
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
        jScrollPane2.setViewportView(tblProduk);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(840, 340, 452, 280);

        txtHarga.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        getContentPane().add(txtHarga);
        txtHarga.setBounds(320, 490, 260, 30);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/Halamain dll.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel6AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1440, 900);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpan();
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{
            String ID = txtId.getText();
            String Nama = txtNama.getText();
            String Alt = txtHarga.getText();
            String No = txtStok.getText();
            String sql = "update produk set NamaProduk='"+Nama+"', Harga='"+Alt+"', Stok='"+No+"' where ProdukID='"+ID+"'";
            pst = konek.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"data berhasil diubah");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        updateTabel();
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try{
            String sql = "delete from produk where ProdukID=?";
            pst = konek.prepareStatement(sql);
            pst.setString(1,txtId.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"data berhasil dihapus");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        updateTabel();
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        try{
            int baris = tblProduk.getSelectedRow();
            String tabelklik = (tblProduk.getModel().getValueAt(baris, 0).toString());
            String sql = "select * from produk where ProdukID='"+tabelklik+"'";
            pst = konek.prepareStatement(sql);
            rst = pst.executeQuery();
            if(rst.next()){
                String dataIdProduk = rst.getString(("ProdukID"));
                txtId.setText(dataIdProduk);
                String dataNamaProduk = rst.getString(("NamaProduk"));
                txtNama.setText(dataNamaProduk);
                String dataHarga = rst.getString(("Harga"));
                txtHarga.setText(dataHarga);
                String dataStok = rst.getString(("Stok"));
                txtStok.setText(dataStok);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProdukMouseClicked

    private void jLabel6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel6AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6AncestorAdded

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
            java.util.logging.Logger.getLogger(FromProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}

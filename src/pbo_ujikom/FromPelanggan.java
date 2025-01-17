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
public class FromPelanggan extends javax.swing.JFrame {
    Connection konek;
    PreparedStatement pst;
    ResultSet rst;
    /**
     * Creates new form FromPelanggan
     */
    public FromPelanggan() {
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
            String sql = "select * from pelanggan";
            pst = konek.prepareStatement(sql);
            rst = pst.executeQuery();
            tblPelanggan.setModel(DbUtils.resultSetToTableModel(rst));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clear(){
        txtId.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtNo.setText("");
    }
    
    public void simpan(){
        try{
            String sql = "insert into pelanggan (PelangganID,NamaPelanggan,Alamat,NomorTelepon) value (?,?,?,?)";
            pst = konek.prepareStatement(sql);
            pst.setString(1,txtId.getText());
            pst.setString(2,txtNama.getText());
            pst.setString(3,txtAlamat.getText());
            pst.setString(4,txtNo.getText());
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
        txtNo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        txtJam = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INPUT PELANGGAN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(540, 130, 350, 47);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Pelanggan");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 350, 160, 30);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Pelanggan");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 400, 160, 30);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alamat");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 460, 160, 30);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No Telepon");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 580, 160, 30);

        txtId.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId);
        txtId.setBounds(340, 350, 260, 30);

        txtNama.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtNama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtNama);
        txtNama.setBounds(340, 400, 260, 30);

        txtNo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtNo);
        txtNo.setBounds(340, 580, 260, 30);

        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtAlamat.setRows(5);
        txtAlamat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(txtAlamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 460, 260, 100);

        btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-save-20.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(660, 490, 100, 32);

        btnEdit.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-edit-20.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(660, 370, 100, 30);

        btnHapus.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-delete-20.png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(660, 430, 100, 30);

        btnKeluar.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
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

        tblPelanggan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPelanggan);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(840, 340, 452, 280);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/Halamain dll.png"))); // NOI18N
        jLabel6.setText("jLabel6");
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

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
try{
    int baris = tblPelanggan.getSelectedRow();
    String tabelklik = (tblPelanggan.getModel().getValueAt(baris, 0).toString());
    String sql = "select * from pelanggan where PelangganID='"+tabelklik+"'";
    pst = konek.prepareStatement(sql);
    rst = pst.executeQuery();
    if(rst.next()){
        String dataIdPelanggan = rst.getString(("PelangganID"));
        txtId.setText(dataIdPelanggan);
        String dataNamaPelanggan = rst.getString(("NamaPelanggan"));
        txtNama.setText(dataNamaPelanggan);
        String dataAlamat = rst.getString(("Alamat"));
        txtAlamat.setText(dataAlamat);
        String dataNoTelepon = rst.getString(("NomorTelepon"));
        txtNo.setText(dataNoTelepon);
    }
} catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
} 
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
try{
    String sql = "delete from pelanggan where PelangganID=?";
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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
try{
    String ID = txtId.getText();
    String Nama = txtNama.getText();
    String Alt = txtAlamat.getText();
    String No = txtNo.getText();
    String sql = "update pelanggan set NamaPelanggan='"+Nama+"', Alamat='"+Alt+"', NomorTelepon='"+No+"' where PelangganID='"+ID+"'";
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

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

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
            java.util.logging.Logger.getLogger(FromPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromPelanggan().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}

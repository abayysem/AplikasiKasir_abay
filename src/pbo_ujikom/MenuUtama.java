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

/**
 *
 * @author lab.pplg
 */
public class MenuUtama extends javax.swing.JFrame {
    Connection konek;
    PreparedStatement pst;
    ResultSet rst;

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        konek = Koneksi.koneksiDB();
        mulai();
        tampilWaktu();
    }
    
    public void mulai(){
        Register.setEnabled(false);
        Logout.setEnabled(false);
        Master.setEnabled(false);
        Transaksi.setEnabled(false);
        Laporan.setEnabled(false);
        txtJam.setEnabled(false);
        txtTanggal.setEnabled(false);
        fromLogin.setVisible(false);
        btnTambah.setEnabled(false);
        btnProduk.setEnabled(false);
        btnPelanggan.setEnabled(false);
        btnPenjualan.setEnabled(false);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnPelanggan = new javax.swing.JButton();
        btnProduk = new javax.swing.JButton();
        btnPenjualan = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        Label = new javax.swing.JLabel();
        txtJam = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        fromLogin = new javax.swing.JInternalFrame();
        btnBatal = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        cmdHak = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Beranda = new javax.swing.JMenu();
        Logout = new javax.swing.JMenuItem();
        Login = new javax.swing.JMenuItem();
        Register = new javax.swing.JMenuItem();
        Master = new javax.swing.JMenu();
        Produk = new javax.swing.JMenuItem();
        Pelanggan = new javax.swing.JMenuItem();
        Transaksi = new javax.swing.JMenu();
        Penjualan = new javax.swing.JMenuItem();
        Laporan = new javax.swing.JMenu();
        rpkLaporan = new javax.swing.JMenuItem();
        Tentang = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apk kasir");
        getContentPane().setLayout(null);

        btnPelanggan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPelanggan.setText("PELANGGAN");
        btnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelangganActionPerformed(evt);
            }
        });
        getContentPane().add(btnPelanggan);
        btnPelanggan.setBounds(1290, 740, 120, 30);

        btnProduk.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnProduk.setText("PRODUK");
        getContentPane().add(btnProduk);
        btnProduk.setBounds(1030, 740, 100, 30);

        btnPenjualan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPenjualan.setText("PENJUALAN");
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(btnPenjualan);
        btnPenjualan.setBounds(1150, 740, 120, 30);

        btnTambah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTambah.setText("ADD");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambah);
        btnTambah.setBounds(42, 743, 90, 30);

        Label.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        Label.setForeground(new java.awt.Color(255, 255, 255));
        Label.setText("SILAHKAN LOGIN DULU");
        getContentPane().add(Label);
        Label.setBounds(60, 60, 300, 32);

        txtJam.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJam.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtJam);
        txtJam.setBounds(1160, 30, 110, 22);

        txtTanggal.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTanggal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtTanggal);
        txtTanggal.setBounds(1290, 30, 110, 22);

        fromLogin.setVisible(true);
        fromLogin.getContentPane().setLayout(new java.awt.GridBagLayout());

        btnBatal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 190, 30, 0);
        fromLogin.getContentPane().add(btnBatal, gridBagConstraints);

        btnLogin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(57, 83, 30, 173);
        fromLogin.getContentPane().add(btnLogin, gridBagConstraints);

        txtUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 281;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 190, 0, 173);
        fromLogin.getContentPane().add(txtUser, gridBagConstraints);

        cmdHak.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmdHak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Salah Satu -", "Admin", "Petugas" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 191;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 190, 0, 173);
        fromLogin.getContentPane().add(cmdHak, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 190, 0, 0);
        fromLogin.getContentPane().add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 190, 0, 0);
        fromLogin.getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Hak Akses");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 190, 0, 0);
        fromLogin.getContentPane().add(jLabel8, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setText("LOGIN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 61, 0, 0);
        fromLogin.getContentPane().add(jLabel2, gridBagConstraints);

        txtPass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 281;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 190, 0, 173);
        fromLogin.getContentPane().add(txtPass, gridBagConstraints);

        getContentPane().add(fromLogin);
        fromLogin.setBounds(360, 150, 720, 450);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/Frame 2 (1).png"))); // NOI18N
        jLabel1.setText("                ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1440, 830);

        Beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-home-25.png"))); // NOI18N
        Beranda.setText("Beranda");
        Beranda.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Beranda.setIconTextGap(5);

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Beranda.add(Logout);

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        Beranda.add(Login);

        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        Beranda.add(Register);

        jMenuBar1.add(Beranda);

        Master.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-market-25.png"))); // NOI18N
        Master.setText("Master");
        Master.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Master.setIconTextGap(5);

        Produk.setText("Produk");
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        Master.add(Produk);

        Pelanggan.setText("Pelanggan");
        Pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PelangganActionPerformed(evt);
            }
        });
        Master.add(Pelanggan);

        jMenuBar1.add(Master);

        Transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-card-exchange-25.png"))); // NOI18N
        Transaksi.setText("Transaksi");
        Transaksi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Transaksi.setIconTextGap(5);

        Penjualan.setText("Penjualan");
        Penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PenjualanActionPerformed(evt);
            }
        });
        Transaksi.add(Penjualan);

        jMenuBar1.add(Transaksi);

        Laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-document-25.png"))); // NOI18N
        Laporan.setText("Laporan");
        Laporan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Laporan.setIconTextGap(5);

        rpkLaporan.setText("Rekap Laporan");
        rpkLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpkLaporanActionPerformed(evt);
            }
        });
        Laporan.add(rpkLaporan);

        jMenuBar1.add(Laporan);

        Tentang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imej/icons8-question-25.png"))); // NOI18N
        Tentang.setText("Tentang");
        Tentang.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Tentang.setIconTextGap(5);

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Tentang.add(jMenuItem1);

        jMenuBar1.add(Tentang);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
new MenuUtama().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
new FromDaptar().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_RegisterActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
fromLogin.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_LoginActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_ProdukActionPerformed

    private void PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PelangganActionPerformed
new FromPelanggan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_PelangganActionPerformed

    private void PenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PenjualanActionPerformed
new FromPenjualan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_PenjualanActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
new FromDaptar().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
new FromPenjualan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
new FromPelanggan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnPelangganActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
try{
    String sql = "select * from login where Username='"+txtUser.getText()+"' and Password='"+txtPass.getText()+"' and HakAkses='"+cmdHak.getSelectedItem()+"' ";
    pst = konek.prepareStatement(sql);
    rst = pst.executeQuery();
    if (rst.next()){
        if (txtUser.getText().equals(rst.getString("Username")) &&txtPass.getText().equals(rst.getString("Password")) &&cmdHak.getSelectedItem().equals(rst.getString("HakAkses")))
            if (cmdHak.getSelectedItem().equals("Admin")){
                Register.setEnabled(true);
                Logout.setEnabled(true);
                Master.setEnabled(true);
                Transaksi.setEnabled(true);
                Laporan.setEnabled(true);
                txtTanggal.setEnabled(false);
                txtJam.setEnabled(false);
                fromLogin.setVisible(false);
                btnTambah.setEnabled(true);
                btnPelanggan.setEnabled(true);
                btnProduk.setEnabled(true);
                btnPenjualan.setEnabled(true);
            } else if (cmdHak.getSelectedItem().equals("Petugas")){
                Register.setEnabled(false);
                Logout.setEnabled(true);
                Master.setEnabled(true);
                Transaksi.setEnabled(true);
                Laporan.setEnabled(true);
                txtTanggal.setEnabled(false);
                txtJam.setEnabled(false);
                fromLogin.setVisible(false);
                btnTambah.setEnabled(true);
                btnPelanggan.setEnabled(true);
                btnProduk.setEnabled(true);
                btnPenjualan.setEnabled(true);
            }
        {
            JOptionPane.showMessageDialog(null, "Selamat Datang '"+txtUser.getText()+"'");
            String text = txtUser.getText();
            Label.setText("Selamat Datang, "+text);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Gagal Masuk, Silahkan Periksa Kembali");
            txtUser.setText("");
            txtPass.setText("");
            cmdHak.setSelectedItem("- Pilih Salah Satu -");
    }
}catch (Exception e){
    JOptionPane.showMessageDialog(null, "Login Gagal");
}

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
new MenuUtama().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatalActionPerformed

    private void rpkLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpkLaporanActionPerformed
new FromLaporanTran().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_rpkLaporanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
new FromAbout().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Beranda;
    private javax.swing.JLabel Label;
    private javax.swing.JMenu Laporan;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenu Master;
    private javax.swing.JMenuItem Pelanggan;
    private javax.swing.JMenuItem Penjualan;
    private javax.swing.JMenuItem Produk;
    private javax.swing.JMenuItem Register;
    private javax.swing.JMenu Tentang;
    private javax.swing.JMenu Transaksi;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnProduk;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmdHak;
    private javax.swing.JInternalFrame fromLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem rpkLaporan;
    private javax.swing.JTextField txtJam;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}


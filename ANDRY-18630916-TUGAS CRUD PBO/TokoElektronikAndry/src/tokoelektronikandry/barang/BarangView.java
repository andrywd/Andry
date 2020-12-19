/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoelektronikandry.barang;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tokoelektronikandry.koneksi.Koneksi;

/**
 *
 * @author Andre Fahlevi
 */
public class BarangView extends javax.swing.JFrame {

    /**
     * Creates new form BarangView
     */
    public BarangView() {
        initComponents();
        ulang();
        setLocationRelativeTo(null);
    }
    Connection conn = new Koneksi().getKoneksi();
    PreparedStatement pst;
    ResultSet rs;
    String status, sql;
    
    private void tampil_data(){
        try {
            String[] judul ={"Kode Barang", "Nama Barang", "Kategori", "Harga", "Stok"};
            DefaultTableModel dtm = new DefaultTableModel(null,judul);
            tabelBarang.setModel(dtm);
            if(textCari.getText().isEmpty()){
                sql = "select * from tb_barang";
            }else{
                sql = "select * from tb_barang where nama_barang like '%"+textCari.getText()+"%'";
            }
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] data = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void ulang(){
        textNama.setText("");
        textKode.setText("");
        textHarga.setText("");
        textStok.setText("");
        comboKategori.setSelectedIndex(0);
        textNama.setEditable(false);
        textKode.setEditable(false);
        textHarga.setEditable(false);
        textStok.setEditable(false);
        buttonSimpan.setEnabled(false);
        buttonHapus.setEnabled(false);
        buttonUbah.setEnabled(false);
        buttonTambah.setEnabled(true);
        tampil_data();   
    }
    
    private void kode_otomatis(){
        try {
            sql = "select * from tb_barang order by kode_barang desc limit 1";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                int kode = Integer.parseInt(rs.getString(1).substring(4))+1;
                textKode.setText("BRG-"+kode);
            }else{
                textKode.setText("BRG-1000");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
            
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textKode = new javax.swing.JTextField();
        textNama = new javax.swing.JTextField();
        comboKategori = new javax.swing.JComboBox<>();
        textHarga = new javax.swing.JTextField();
        textStok = new javax.swing.JTextField();
        buttonTambah = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonUlang = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        jTextField5.setText("jTextField5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Desa Lalayau, Kec. Juai, Kab, Balangan");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\cr.jpg")); // NOI18N
        jLabel2.setText("Search");

        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCariKeyReleased(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        jLabel3.setText("Kode Barang");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Kategori");

        jLabel6.setText("Harga");

        jLabel7.setText("Stok");

        comboKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kategori", "Kulkas", "Kipas Angin", "Televisi", "Setrika", "Rice Cooker", "Mesin Cuci" }));
        comboKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKategoriActionPerformed(evt);
            }
        });

        buttonTambah.setBackground(new java.awt.Color(255, 255, 0));
        buttonTambah.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\+.png")); // NOI18N
        buttonTambah.setText("Add");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonSimpan.setBackground(new java.awt.Color(255, 255, 0));
        buttonSimpan.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\sv.jpg")); // NOI18N
        buttonSimpan.setText("Save");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonUbah.setBackground(new java.awt.Color(255, 255, 0));
        buttonUbah.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\ed.jpg")); // NOI18N
        buttonUbah.setText("Edit");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonHapus.setBackground(new java.awt.Color(255, 255, 0));
        buttonHapus.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\Cancel-2-16x16.png")); // NOI18N
        buttonHapus.setText("Delete");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonUlang.setBackground(new java.awt.Color(255, 255, 0));
        buttonUlang.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\dt.jpg")); // NOI18N
        buttonUlang.setText("Reset");
        buttonUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUlangActionPerformed(evt);
            }
        });

        buttonKeluar.setBackground(new java.awt.Color(255, 255, 0));
        buttonKeluar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\Tutup.png")); // NOI18N
        buttonKeluar.setText("Exit");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("TOKO ELEKTRONIK ANDRY");
        jLabel8.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 2, 21)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Andre Fahlevi\\Downloads\\IkhsanPerpustakaanUPB\\IkhsanPerpustakaanUPB\\Perpus\\build\\classes\\gambar\\PETUGAS.png")); // NOI18N
        jLabel9.setText("Andry 18630916");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(textCari))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textStok)
                            .addComponent(textHarga)
                            .addComponent(comboKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textNama)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonTambah)
                                .addGap(9, 9, 9)
                                .addComponent(buttonSimpan)
                                .addGap(9, 9, 9)
                                .addComponent(buttonUbah)
                                .addGap(16, 16, 16)
                                .addComponent(buttonUlang)
                                .addGap(9, 9, 9)
                                .addComponent(buttonHapus)
                                .addGap(9, 9, 9)
                                .addComponent(buttonKeluar)))))
                .addGap(0, 98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(311, 311, 311))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(385, 385, 385))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambah)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonUbah)
                    .addComponent(buttonUlang)
                    .addComponent(buttonKeluar)
                    .addComponent(buttonHapus))
                .addGap(52, 52, 52)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
    kode_otomatis();
        textNama.setEditable(true);
        textHarga.setEditable(true);
        textStok.setEditable(true);
        comboKategori.setEditable(true);
        status = "tambah";
        buttonTambah.setEnabled(false);
        buttonSimpan.setEnabled(true);
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        textNama.setEditable(true);
        textHarga.setEditable(true);
        textStok.setEditable(true);
        comboKategori.setEditable(true);
        status = "ubah";
        buttonUbah.setEnabled(false);
        buttonTambah.setEnabled(false);
        buttonSimpan.setEnabled(true);
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if(textNama.getText().isEmpty() || textHarga.getText().isEmpty() || textStok.getText().isEmpty() || comboKategori.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Inputan belum diisi");
        }else{
            try {
                if(status.equals("tambah")){
                    sql = "insert into tb_barang values ('" + textKode.getText() + "', '" + textNama.getText() + "', '" + comboKategori.getSelectedItem().toString() + "', '" + textHarga.getText() + "', '" + textStok.getText() + "')";
                }else if (status.equals("ubah")){
                    sql = "update tb_barang set nama_barang = '" + textNama.getText() + "', kategori = '" + comboKategori.getSelectedItem().toString() + "', harga = '" + textHarga.getText() + "', stok = '" + textStok.getText() + "' where kode_barang = '" + textKode.getText() + "'";
                }
                pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data barang berhasil disimpan!!");
                ulang();
            } catch (SQLException ex) {
                Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah data barang ini mau dihapus?", "Hapus Data?", JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
            try {
                pst = conn.prepareStatement("delete from tb_barang where kode_barang = '"+textKode.getText() + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data barang berhasil dihapus");
                ulang();
            } catch (SQLException ex) {
                Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
       int baris = tabelBarang.getSelectedRow();
        String kode = tabelBarang.getValueAt(baris, 0).toString();
        if(!kode.isEmpty()){
            textKode.setText(kode);
            textNama.setText(tabelBarang.getValueAt(baris, 1).toString());
            comboKategori.setSelectedItem(tabelBarang.getValueAt(baris, 2).toString());
            textHarga.setText(tabelBarang.getValueAt(baris, 3).toString());
            textStok.setText(tabelBarang.getValueAt(baris, 4).toString());
            buttonTambah.setEnabled(false);
            buttonUbah.setEnabled(true);
            buttonHapus.setEnabled(true);
        }
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void buttonUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUlangActionPerformed
        ulang();
    }//GEN-LAST:event_buttonUlangActionPerformed

    private void textCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyReleased
       tampil_data();
    }//GEN-LAST:event_textCariKeyReleased

    private void comboKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKategoriActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JButton buttonUlang;
    private javax.swing.JComboBox<String> comboKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTextField textCari;
    private javax.swing.JTextField textHarga;
    private javax.swing.JTextField textKode;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textStok;
    // End of variables declaration//GEN-END:variables
}
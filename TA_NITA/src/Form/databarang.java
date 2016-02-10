/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aries
 */
public class databarang extends javax.swing.JInternalFrame {
    ResultSet r;
    Statement s;
    Connection c;
    private Object[][]databarang=null;
    private String[]label={"ID Barang","Nama Barang","Satuan","Spesifikasi"};

    /**
     * Creates new form databarang
     */
    public databarang() {
        initComponents();
        bukakoneksi();
        //reset();
        bacaTable();
        notrx();
    }
    public void reset(){
        jtspesifikasi.setText("");
        jtID.setText("");
        jComboBox1.setSelectedIndex(0);
        jtkode.setText("");
        jtnama.setText("");
        jtkode.requestFocus();
    }
    public void notrx(){
        try {
           String sql12 = "select * from barang order by id_barang desc";
           s =c.createStatement();
           r = s.executeQuery(sql12);
           if(r.next())
           {
               String noid = r.getString("id_barang");
               int nomor= Integer.valueOf(noid.substring(5,8));
               if(nomor<9){
                   jtkode.setText("BRG-000"+String.valueOf(nomor+1));
               }else if(nomor<99){
                   jtkode.setText("BRG-00"+String.valueOf(nomor+1));
               }else if(nomor<999){
                   jtkode.setText("BRG-0"+String.valueOf(nomor+1));
               }else{
                   jtkode.setText("BRG-"+String.valueOf(nomor+1));
               }  
           }else{
               jtkode.setText("BRG-0001");
           }
        } catch (Exception e) {
        }
    }
    private void bukakoneksi()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ta_nita","root","");
            System.out.println("Koneksi Sukses");
        } 
        catch (Exception e) 
        {
            System.out.println("Koneksi Sukses");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtspesifikasi = new javax.swing.JTextField();
        jtID = new javax.swing.JTextField();
        jtkode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtnama = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbreset = new javax.swing.JButton();
        jbsimpan = new javax.swing.JButton();
        jbedit = new javax.swing.JButton();
        jbhapus = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBarang = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtSearch = new javax.swing.JTextField();
        jbSearch = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Master :: Data Barang");

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nama Barang");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jtspesifikasi.setEnabled(false);
        jPanel2.add(jtspesifikasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 330, -1));

        jtID.setText("jTextField2");
        jPanel2.add(jtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 0, 0, -1));

        jtkode.setEnabled(false);
        jPanel2.add(jtkode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 330, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kode Barang");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...Satuan Barang...", "PCS", "RIM", "PAK", "Lusin", "Botol" }));
        jComboBox1.setEnabled(false);
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Spesifikasi");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Satuan");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jtnama.setEnabled(false);
        jPanel2.add(jtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 330, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 479, 150));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Button-Add-icon.png"))); // NOI18N
        jbreset.setText("Baru");
        jbreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbresetActionPerformed(evt);
            }
        });
        jPanel3.add(jbreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 91, 36));

        jbsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Floppy-Small-icon.png"))); // NOI18N
        jbsimpan.setText("Simpan");
        jbsimpan.setEnabled(false);
        jbsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsimpanActionPerformed(evt);
            }
        });
        jPanel3.add(jbsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 91, 36));

        jbedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Actions-document-edit-icon.png"))); // NOI18N
        jbedit.setText("Edit");
        jbedit.setEnabled(false);
        jbedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeditActionPerformed(evt);
            }
        });
        jPanel3.add(jbedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 91, 36));

        jbhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Actions-edit-delete-icon.png"))); // NOI18N
        jbhapus.setText("Hapus");
        jbhapus.setEnabled(false);
        jbhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbhapusActionPerformed(evt);
            }
        });
        jPanel3.add(jbhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 91, 36));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 110, 210));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbBarang);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 458, 140));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 480, 170));

        jLabel2.setText("Cari  Nama Barang");

        jtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtSearchKeyReleased(evt);
            }
        });

        jbSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Zoom-icon.png"))); // NOI18N
        jbSearch.setText("Search");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSearch)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearch))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 480, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void simpan()
    {
       try 
       {
           String sql = "INSERT INTO barang VALUES('"+jtkode.getText()+"','"+jtnama.getText()+"','"+jComboBox1.getSelectedItem()+"'"
                   + ",'"+jtspesifikasi.getText()+"')";
           s.executeUpdate(sql);
           s.close();
           JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
           bacaTable();
           //reset();
       }
       catch (SQLException e) 
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }
    private void editdata()
    {
      try 
      {
          String sql= "UPDATE barang SET Spesifikasi ='"+jtspesifikasi.getText()+"', "
          + "nama_barang='"+jtnama.getText()+"', satuan ='"+jComboBox1.getSelectedItem()+"' WHERE id_barang='"+jtkode.getText()+"'";
          s.executeUpdate(sql);
          s.close();
          JOptionPane.showMessageDialog(null, "Data berhasil di Edit");
          bacaTable();
          //reset();
      }
      catch (SQLException e) 
      {
          JOptionPane.showMessageDialog(null, e);
      }
    }
     private void settable()
   {
       int row = jtbBarang.getSelectedRow();
       jtkode.setText((String)jtbBarang.getValueAt(row, 0));
       jtnama.setText((String)jtbBarang.getValueAt(row, 1));
       jComboBox1.setSelectedItem((String)jtbBarang.getValueAt(row, 2));
       jtspesifikasi.setText((String)jtbBarang.getValueAt(row, 3));
       jtkode.requestFocus();
   }
    private void hapusdata()
  {
      try 
      {
          String sql = "DELETE FROM barang WHERE id_barang='"+jtkode.getText()+"'";
          s.executeUpdate(sql);
          s.close();
          JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
          bacaTable();
          //reset();
      } 
      catch (SQLException e)
      {
          JOptionPane.showMessageDialog(null, e);
      }
  }
    public void on(){
        jtkode.setEnabled(true);
        jtnama.setEnabled(true);
        jtspesifikasi.setEnabled(true);
        jbedit.setEnabled(true);
        jbsimpan.setEnabled(true);
        jbhapus.setEnabled(true);
        jbreset.setEnabled(true);
        jtspesifikasi.setEnabled(true);
        jComboBox1.setEnabled(true);
        jtnama.requestFocus();
    }
    private void jtbBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBarangMouseClicked
        // TODO add your handling code here:
        settable();
    }//GEN-LAST:event_jtbBarangMouseClicked

    private void jbresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbresetActionPerformed
        // TODO add your handling code here:
        reset();
        on();
        notrx();
    }//GEN-LAST:event_jbresetActionPerformed

    private void jbsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsimpanActionPerformed
        // TODO add your handling code here:
        if("".equals(jtspesifikasi.getText()) || "".equals(jtkode.getText()) || "...Satuan Barang...".equals(jComboBox1.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Lengkapi dahulu data");
            jtkode.requestFocus();
        }else{
            try {
                s=c.createStatement();
                String a="SELECT * FROM barang WHERE nama_barang ='"+jtnama.getText()+"' ";
                r=s.executeQuery(a);
                if(r.next()){
                    JOptionPane.showMessageDialog(null, "Nama Barang Sudah digunakan");
                    jtID.requestFocus();
                }
                else{
                    simpan();
                }
            } catch (Exception e) {
            }
        }
        
    }//GEN-LAST:event_jbsimpanActionPerformed

    private void jbeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeditActionPerformed
        // TODO add your handling code here:
        if("".equals(jtspesifikasi.getText()) || "".equals(jtkode.getText()) || "...Satuan Barang...".equals(jComboBox1.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
            jtkode.requestFocus();
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "apakah data ini ingin di Edit ?", "peringatan",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION)
            {
                try {
                s=c.createStatement();
                String a="SELECT * FROM barang WHERE nama_barang ='"+jtnama.getText()+"' ";
                r=s.executeQuery(a);
                if(r.next()){
                    JOptionPane.showMessageDialog(null, "Nama Barang Sama");
                    jtID.requestFocus();
                }
                else{
                    editdata();
                }
                } catch (Exception e) {
            }
            }
        }
    }//GEN-LAST:event_jbeditActionPerformed

    private void jbhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbhapusActionPerformed
        // TODO add your handling code here:
        if("".equals(jtnama.getText()) || "".equals(jtkode.getText()) || "...Satuan Barang...".equals(jComboBox1.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
            jtkode.requestFocus();
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "apakah data ini ingin di Hapus ?", "peringatan",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION)
            {
            hapusdata();
            }
        }
    }//GEN-LAST:event_jbhapusActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        // TODO add your handling code here:
        Pencarian();
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSearchKeyReleased
        // TODO add your handling code here:
        Pencarian();
    }//GEN-LAST:event_jtSearchKeyReleased
    public void bacaTable(){
        try 
       {
           s=c.createStatement();
           String sql = "select * from barang";
           r=s.executeQuery(sql);
           ResultSetMetaData m=r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next())
           {
               baris = r.getRow();
           }
           databarang= new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next())
           {
               databarang[x][0]=r.getString("id_barang");
               databarang[x][1]=r.getString("nama_barang");
               databarang[x][2]=r.getString("satuan");
               databarang[x][3]=r.getString("Spesifikasi");
               x++;
           }
           jtbBarang.setModel(new DefaultTableModel(databarang, label));
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }
    public void Pencarian(){
        try 
       {
           s=c.createStatement();
           String sql = "select * from barang where nama_barang like '%"+jtSearch.getText()+"%'";
           r=s.executeQuery(sql);
           ResultSetMetaData m=r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next())
           {
               baris = r.getRow();
           }
           databarang= new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next())
           {
               databarang[x][0]=r.getString("id_barang");
               databarang[x][1]=r.getString("nama_barang");
               databarang[x][2]=r.getString("satuan");
               databarang[x][3]=r.getString("Spesifikasi");
               x++;
           }
           jtbBarang.setModel(new DefaultTableModel(databarang, label));
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbedit;
    private javax.swing.JButton jbhapus;
    private javax.swing.JButton jbreset;
    private javax.swing.JButton jbsimpan;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtSearch;
    private javax.swing.JTable jtbBarang;
    private javax.swing.JTextField jtkode;
    private javax.swing.JTextField jtnama;
    private javax.swing.JTextField jtspesifikasi;
    // End of variables declaration//GEN-END:variables
}
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
public class datadapartemen extends javax.swing.JInternalFrame {
    ResultSet r;
    Statement s;
    Connection c;
    private Object[][]datadapartemen=null;
    private String[]label={"ID Dapartemen","Nama Dapartement"};
    /**
     * Creates new form datadapartemen
     */
    public datadapartemen() {
        initComponents();
        bukakoneksi();
        bacaTable();
        notrx();
    }
     public void bacaTable(){
        try 
       {
           s=c.createStatement();
           String sql = "select * from dapartemen";
           r=s.executeQuery(sql);
           ResultSetMetaData m=r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next())
           {
               baris = r.getRow();
           }
           datadapartemen= new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next())
           {
               datadapartemen[x][0]=r.getString("id_dapartement");
               datadapartemen[x][1]=r.getString("nama_dapartement");
               x++;
           }
           jbdapart.setModel(new DefaultTableModel(datadapartemen, label));
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }
     public void notrx(){
        try {
           String sql12 = "select * from dapartemen order by id_dapartement desc";
           s =c.createStatement();
           r = s.executeQuery(sql12);
           if(r.next())
           {
               
               String noid = r.getString("id_dapartement");
               int nomor= Integer.valueOf(noid.substring(5,6));
               if(nomor<9){
                   jdidDapart.setText("DEP-0"+String.valueOf(nomor+1));
               }else{
                   jdidDapart.setText("DEP-"+String.valueOf(nomor+1));
               }  
           }else{
               jdidDapart.setText("DEP-01");
           }
        } catch (Exception e) {
        }
    }
     public void Pencarian(){
        try 
       {
           s=c.createStatement();
           String sql = "select * from dapartemen where id_dapartement like '%"+jtSearch.getText()+"%'";
           r=s.executeQuery(sql);
           ResultSetMetaData m=r.getMetaData();
           int kolom=m.getColumnCount();
           int baris=0;
           while(r.next())
           {
               baris = r.getRow();
           }
           datadapartemen= new Object[baris][kolom];
           int x=0;
           r.beforeFirst();
           while(r.next())
           {
               datadapartemen[x][0]=r.getString("id_dapartement");
               datadapartemen[x][1]=r.getString("nama_dapartement");
               x++;
           }
           jbdapart.setModel(new DefaultTableModel(datadapartemen, label));
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    }
    public void reset(){
        jtnamadap.setText("");
        jdidDapart.setText("");
        jdidDapart.requestFocus();
    }
    private void simpan()
    {
       try 
       {
           String sql = "INSERT INTO dapartemen VALUES('"+jdidDapart.getText()+"','"+jtnamadap.getText()+"')";
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
          String sql= "UPDATE dapartemen SET nama_dapartement='"+jtnamadap.getText()+"' WHERE id_dapartement='"+jdidDapart.getText()+"'";
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
       int row = jbdapart.getSelectedRow();
       jdidDapart.setText((String)jbdapart.getValueAt(row, 0));
       jtnamadap.setText((String)jbdapart.getValueAt(row, 1));
       jdidDapart.requestFocus();
       }
     private void hapusdata()
    {
      try 
      {
          String sql = "DELETE FROM dapartemen WHERE id_dapartement='"+jdidDapart.getText()+"'";
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdidDapart = new javax.swing.JTextField();
        jtnamadap = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbdapart = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jbreset = new javax.swing.JButton();
        jbSimpan = new javax.swing.JButton();
        jbEdit = new javax.swing.JButton();
        jbHapus = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtSearch = new javax.swing.JTextField();
        jbSearch = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setClosable(true);
        setIconifiable(true);
        setTitle("Master :: Data Dapartement");

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID Dapartement");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nama Dapartement");

        jdidDapart.setEnabled(false);

        jtnamadap.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addComponent(jdidDapart, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jtnamadap, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jdidDapart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtnamadap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jbdapart.setModel(new javax.swing.table.DefaultTableModel(
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
        jbdapart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbdapartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jbdapart);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Button-Add-icon.png"))); // NOI18N
        jbreset.setText("Baru");
        jbreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbresetActionPerformed(evt);
            }
        });
        jPanel4.add(jbreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 91, 40));

        jbSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Floppy-Small-icon.png"))); // NOI18N
        jbSimpan.setText("Simpan");
        jbSimpan.setEnabled(false);
        jbSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSimpanActionPerformed(evt);
            }
        });
        jPanel4.add(jbSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 91, 40));

        jbEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Actions-document-edit-icon.png"))); // NOI18N
        jbEdit.setText("Edit");
        jbEdit.setEnabled(false);
        jbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditActionPerformed(evt);
            }
        });
        jPanel4.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 91, 40));

        jbHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Actions-edit-delete-icon.png"))); // NOI18N
        jbHapus.setText("Hapus");
        jbHapus.setEnabled(false);
        jbHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHapusActionPerformed(evt);
            }
        });
        jPanel4.add(jbHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 91, 40));

        jLabel1.setText("Cari ID Dapartment");

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
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSearch)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearch))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    }    public void on(){
        jbEdit.setEnabled(true);
        jbHapus.setEnabled(true);
        jbSimpan.setEnabled(true);
        jbreset.setEnabled(true);
        jtnamadap.setEnabled(true);
        jdidDapart.setEnabled(true);
        jtnamadap.requestFocus();
    }
    private void jbresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbresetActionPerformed
        // TODO add your handling code here:
        reset();
        on();
        notrx();
    }//GEN-LAST:event_jbresetActionPerformed

    private void jbSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSimpanActionPerformed
        // TODO add your handling code here:
        if("".equals(jdidDapart.getText()) || "".equals(jtnamadap.getText())){
            JOptionPane.showMessageDialog(null, "Lengkapi dahulu data");
            jtnamadap.requestFocus();
        }else{
            try {
                s=c.createStatement();
                String a="SELECT * FROM dapartemen WHERE nama_dapartement='"+jtnamadap.getText()+"'";
                r=s.executeQuery(a);
                if(r.next()){
                    JOptionPane.showMessageDialog(null, "Nama Dapartement Sudah ada");
                    jtnamadap.requestFocus();
                }else{
                    simpan();
                }
            } catch (Exception e) {
            }
            
        }
    }//GEN-LAST:event_jbSimpanActionPerformed

    private void jbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditActionPerformed
        // TODO add your handling code here:
        if("".equals(jdidDapart.getText())){
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
            jdidDapart.requestFocus();
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "apakah data ini ingin di Edit ?", "peringatan",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION)
            {
                try {
                s=c.createStatement();
                String a="SELECT * FROM dapartemen WHERE nama_dapartement='"+jtnamadap.getText()+"'";
                r=s.executeQuery(a);
                if(r.next()){
                    JOptionPane.showMessageDialog(null, "Nama Dapartement Sudah ada");
                    jtnamadap.requestFocus();
                }else{
                    editdata();
                }
            } catch (Exception e) {
            }
            
            }
        }
    }//GEN-LAST:event_jbEditActionPerformed

    private void jbHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHapusActionPerformed
        // TODO add your handling code here:
        if("".equals(jdidDapart.getText())){
            JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
            jdidDapart.requestFocus();
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "apakah data ini ingin di Edit ?", "peringatan",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION)
            {
            hapusdata();
            }
        }
    }//GEN-LAST:event_jbHapusActionPerformed

    private void jbdapartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbdapartMouseClicked
        // TODO add your handling code here:
        settable();
    }//GEN-LAST:event_jbdapartMouseClicked

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        // TODO add your handling code here:
        Pencarian();
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtSearchKeyReleased
        // TODO add your handling code here:
        Pencarian();
    }//GEN-LAST:event_jtSearchKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEdit;
    private javax.swing.JButton jbHapus;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbSimpan;
    private javax.swing.JTable jbdapart;
    private javax.swing.JButton jbreset;
    private javax.swing.JTextField jdidDapart;
    private javax.swing.JTextField jtSearch;
    private javax.swing.JTextField jtnamadap;
    // End of variables declaration//GEN-END:variables
}

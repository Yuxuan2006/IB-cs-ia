import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class updateQuestion extends javax.swing.JFrame {

    public updateQuestion() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(150, 183));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update Question.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 15, 140, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 40)); // NOI18N
        jLabel2.setText("Update Question");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 15, 381, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 9, 120, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 87, 1011, 10));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel3.setText("Question ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 115, 127, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel4.setText("Question ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 176, 127, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel5.setText("Option 1:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 232, 110, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel6.setText("Option 2:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 297, 102, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel7.setText("Option 3:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setText("Option 4:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 421, -1, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel9.setText("Answer:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 480, 87, -1));

        jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 112, 228, -1));

        jTextField2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 176, 746, -1));

        jTextField3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 232, 746, -1));

        jTextField4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 297, 746, -1));

        jTextField5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 360, 746, -1));

        jTextField6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 421, 746, -1));

        jTextField7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 480, 746, -1));

        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 139, -1));

        jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 167, -1));

        jButton4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear.png"))); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 148, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pages background admin.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, -1, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     adminHome.open=0;
     setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String id=jTextField1.getText();
    try
    {
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select *from question where id='"+id+"'");
        if(rs.first())
        {
            jTextField2.setText(rs.getString(2));
            jTextField3.setText(rs.getString(3));
            jTextField4.setText(rs.getString(4));
            jTextField5.setText(rs.getString(5));
            jTextField6.setText(rs.getString(6));
            jTextField7.setText(rs.getString(7));
            jTextField1.setEditable(false);
    }
    else
    {
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(jf,"Question Id does not Exist!");
    }
}
catch(Exception e)
{
    JFrame jf=new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,e);
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
String id=jTextField1.getText();
String name=jTextField2.getText();
String opt1=jTextField3.getText();
String opt2=jTextField4.getText();
String opt3=jTextField5.getText();
String opt4=jTextField6.getText();
String answer=jTextField7.getText();
try
{
    Connection con=ConnectionProvider.getCon();
    PreparedStatement ps=con.prepareStatement("update question set name=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id=?");
    ps.setString(1,name);
    ps.setString(2,opt1);
    ps.setString(3,opt2);
    ps.setString(4,opt3);
    ps.setString(5,opt4);
    ps.setString(6,answer);
    ps.setString(7,id);
    ps.executeUpdate();
JFrame jf=new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,"Successfully Updated");
    setVisible(false);
    new updateQuestion().setVisible(true);
}
catch(Exception e)
{
    JFrame jf=new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,e);
} 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
    jTextField1.setEditable(true);
    }//GEN-LAST:event_jButton4ActionPerformed

   
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}

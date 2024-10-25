import java.sql.*;
import Project.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class addNewQuestion extends javax.swing.JFrame {
    public addNewQuestion() {
        initComponents();
        try{
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select count(id) from question");
            if(rs.first())
            {
              int id=rs.getInt(1);
              id=id+1;
              String str=String.valueOf(id);
              jLabel4.setText(str);
            }
            else
            jLabel4.setText("1");
}
catch(Exception e)
{
    JFrame jf=new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf, e);
}
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
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(150, 183));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add new question.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 20, 82, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 40)); // NOI18N
        jLabel2.setText("Add New Question");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 28, 392, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 112, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1115, 17));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel3.setText("Question ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 127, 134, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("00");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 41, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel5.setText("Question:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 172, -1, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel6.setText("Option 1:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 228, 95, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel7.setText("Option 2:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 279, 95, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel8.setText("Option 3:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 336, -1, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel9.setText("Option 4:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 387, -1, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jLabel10.setText("Answer:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 438, 103, -1));

        jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 172, 702, -1));

        jTextField2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 225, 702, -1));

        jTextField3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 276, 702, -1));

        jTextField4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 333, 702, -1));

        jTextField5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 384, 702, -1));

        jTextField6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 435, 702, -1));

        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 120, -1));

        jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 20)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 123, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pages background admin.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String id=jLabel4.getText();
      String name=jTextField1.getText();
String opt1=jTextField2.getText();
String opt2=jTextField3.getText();
String opt3=jTextField4.getText();
String opt4=jTextField5.getText();
String answer=jTextField6.getText();
try{
    Connection con=ConnectionProvider.getCon();
    PreparedStatement ps=con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
    ps.setString(1, id);
    ps.setString(2, name);
    ps.setString(3, opt1);
    ps.setString(4, opt2);
    ps.setString(5, opt3);
    ps.setString(6, opt4);
    ps.setString(7, answer);
    ps.executeUpdate();
    JFrame jf=new JFrame();
    jf.setAlwaysOnTop(true);
    JOptionPane.showMessageDialog(jf,"Successfully Updated");
    setVisible(false);
    new addNewQuestion().setVisible(true);
}
catch(Exception e)
{
     JFrame jf=new JFrame ();
         jf.setAlwaysOnTop (true);
       JOptionPane.showMessageDialog(jf, "Successfully Updated");

}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
    jTextField1.setText("");
    jTextField2.setText ("");
    jTextField3.setText ("");
    jTextField4.setText ("");
    jTextField5.setText ("");
    jTextField6.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    adminHome.open=0;
    setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addNewQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    // End of variables declaration//GEN-END:variables
}

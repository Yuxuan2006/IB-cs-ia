
import javax.swing.JOptionPane;


public class instructionStudent extends javax.swing.JFrame {
public String rollNo;
    
    public instructionStudent() {
        initComponents();
    }
     public instructionStudent(String rollNo1) {
    initComponents();
    JOptionPane.showMessageDialog(null, rollNo1);
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/index student.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 40)); // NOI18N
        jLabel2.setText("Instruction");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 6, 253, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 72, 1366, 10));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 25)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("During the exam:\n\n1. The student may not use his or her textbook, course notes, or receive help from a\nproctor or any other outside source\n\n2.Students must complete the 10-question multiple-choice exam within the 10-minute time\nframe allotted for the exam.\n\n3.Students must not stop the session and then return to it. This is especially important\nin the online environment where the system will \"time-out\" and not allow the student\nor you to reenter the exam.\n\nNumber of Question:10\nExam Duration: 10 min\nAll the Best");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 111, 1172, 513));

        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 30)); // NOI18N
        jButton1.setText("START QUIZ");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 685, 238, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pages background student.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1370, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
    
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new instructionStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

import data.Question;
import java.util.ArrayList;
import util.AI;
import static util.QuestionArrayCreator.parseQuestionsFromJson;
public class QuestionType extends javax.swing.JFrame {

    String topic;
    String difficulty;
    int number;

    public QuestionType() {
        initComponents();
    }

    public static String generatePrompt(String topic, String diff, int num) {
    String prompt = String.format(
        "Generate %d IB economics multiple choice questions about %s with difficulty of %s in the following JSON format: " +
        "{ \"questions\": [" +
            "{" +
            "\"questioncontext\": \"\"," +
            "\"questioncontexta\": \"\"," +
            "\"questioncontextb\": \"\"," +
            "\"questioncontextc\": \"\"," +
            "\"questioncontextd\": \"\"," +
            "\"topic\": \"\"," +
            "\"difficulty\": \"\"," +
            "\"answer\": \"\"" +
            "}" +
        "]}", 
        num, topic, diff
    );
    return prompt;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EasyButton = new javax.swing.JButton();
        MediumButton = new javax.swing.JButton();
        HardButton = new javax.swing.JButton();
        MicroButton = new javax.swing.JButton();
        MacroButton = new javax.swing.JButton();
        GlobalButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Topic");

        jLabel2.setText("Difficulty");

        EasyButton.setText("Easy");
        EasyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyButtonActionPerformed(evt);
            }
        });

        MediumButton.setText("Medium");
        MediumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumButtonActionPerformed(evt);
            }
        });

        HardButton.setText("Hard");
        HardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardButtonActionPerformed(evt);
            }
        });

        MicroButton.setText("Microeconomics");
        MicroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MicroButtonActionPerformed(evt);
            }
        });

        MacroButton.setText("Macroeconomics");
        MacroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MacroButtonActionPerformed(evt);
            }
        });

        GlobalButton.setText("The Global Economy");
        GlobalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GlobalButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Number of Question");

        jLabel4.setText("Question Bank");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(EasyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(MicroButton)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MediumButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(HardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MacroButton)
                                        .addGap(25, 25, 25)
                                        .addComponent(GlobalButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {EasyButton, GlobalButton, HardButton, MacroButton, MediumButton, MicroButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MicroButton)
                    .addComponent(MacroButton)
                    .addComponent(GlobalButton))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EasyButton)
                    .addComponent(MediumButton)
                    .addComponent(HardButton))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(jButton1)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MicroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MicroButtonActionPerformed
        topic = "ircoeconmoics";

    }//GEN-LAST:event_MicroButtonActionPerformed

    private void MacroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MacroButtonActionPerformed
        topic = "Marcoeconmoics";
    }//GEN-LAST:event_MacroButtonActionPerformed

    private void GlobalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GlobalButtonActionPerformed
        topic = "The Global Economy";
    }//GEN-LAST:event_GlobalButtonActionPerformed

    private void EasyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyButtonActionPerformed
        difficulty = "Esay";
    }//GEN-LAST:event_EasyButtonActionPerformed

    private void MediumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumButtonActionPerformed
        difficulty = "Medium";

    }//GEN-LAST:event_MediumButtonActionPerformed

    private void HardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardButtonActionPerformed
        difficulty = "Hard";

    }//GEN-LAST:event_HardButtonActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        number = (Integer) jSpinner1.getValue();

    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String res = AI.GeminiApi(generatePrompt(topic,difficulty,number));
        ArrayList<Question> questions = parseQuestionsFromJson(res);
        System.out.println(res);
        new QuestionGui(questions).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EasyButton;
    private javax.swing.JButton GlobalButton;
    private javax.swing.JButton HardButton;
    private javax.swing.JButton MacroButton;
    private javax.swing.JButton MediumButton;
    private javax.swing.JButton MicroButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author rasha
 */
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class ChatClient extends javax.swing.JFrame {

    public ChatClient() {
        initComponents();
        customizeUI();
    }

   private void customizeUI() {
    // Set button size
    jButtonSend.setPreferredSize(new java.awt.Dimension(150, 50));
    // Set button border
    jButtonSend.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    // Set button background color
    jButtonSend.setBackground(new java.awt.Color(71, 120, 197));
    // Set button text color
    jButtonSend.setForeground(java.awt.Color.WHITE);
    // Set button font
    jButtonSend.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

    // Set text area background color
    jTextAreaMessage.setBackground(java.awt.Color.WHITE); // Set background color to white
    jTextAreaChat.setBackground(new java.awt.Color(210, 225, 244));
    // Set text area text color
    jTextAreaMessage.setForeground(java.awt.Color.BLACK);
    jTextAreaChat.setForeground(java.awt.Color.BLACK);
    // Set text area borders
    jTextAreaMessage.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new java.awt.Color(123, 165, 241), 2),
            new EmptyBorder(5, 5, 5, 5)
    ));
    jTextAreaChat.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new java.awt.Color(123, 165, 241), 2),
            new EmptyBorder(5, 5, 5, 5)
    ));
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
        jButtonSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        jPanel1.setLayout(new java.awt.BorderLayout(10, 10));

        jButtonSend.setText("Send");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSend, java.awt.BorderLayout.LINE_END);

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setRows(5);
        jTextAreaMessage.setTabSize(5);
        jTextAreaMessage.setPreferredSize(new java.awt.Dimension(50, 69));
        jScrollPane1.setViewportView(jTextAreaMessage);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTextAreaChat.setColumns(20);
        jTextAreaChat.setRows(5);
        jScrollPane2.setViewportView(jTextAreaChat);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 491, 444);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        String message = jTextAreaMessage.getText();
        writer.println(message);

        jTextAreaChat.append("client: " + message + "\n");
        jTextAreaMessage.setText("");
          if (message.equals("*exit*")) {
                System.exit(0);
            }
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            socket = new Socket("localhost", 3456);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new Scanner(socket.getInputStream());

            Thread mythread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        String message = reader.nextLine();
                        jTextAreaChat.append("server: " + message + "\n");

                    }
                }

            }
            );
            mythread.start();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextArea jTextAreaMessage;
    // End of variables declaration//GEN-END:variables
    private Socket socket;
    private PrintWriter writer;
    private Scanner reader;

}

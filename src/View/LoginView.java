/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Others.Image;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.*;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author samyc
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public LoginView() {
        defaultTheme();
        initComponents();
        email.putClientProperty("JTextField.placeholderText", "Email or card number");
        password.putClientProperty("JTextField.placeholderText", "Password");
        super.setLocationRelativeTo(null);
        Image image = new Image(540, 752, "/Resources/login.png");
        this.image.add(image);
        Image login = new Image(540, 752, "/Resources/loginDegradate.png");
        this.login.add(login);
        super.setIconImage(new ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
    }

    private void defaultTheme() {
        FlatArcDarkIJTheme.setup();
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 999);
        FlatLaf.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        image = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        signin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 752));
        setResizable(false);

        container.setLayout(new java.awt.GridLayout(1, 1));

        image.setLayout(new java.awt.BorderLayout());
        container.add(image);

        title.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Sign In");

        email.setBackground(new java.awt.Color(64, 64, 122));
        email.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N

        password.setBackground(new java.awt.Color(64, 64, 122));
        password.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N

        signin.setBackground(new java.awt.Color(68, 189, 50));
        signin.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        signin.setForeground(new java.awt.Color(255, 255, 255));
        signin.setText("Continue");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title)
                    .addComponent(email)
                    .addComponent(password)
                    .addComponent(signin, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(title)
                .addGap(28, 28, 28)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signin)
                .addContainerGap(283, Short.MAX_VALUE))
        );

        container.add(login);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel container;
    public javax.swing.JTextField email;
    public javax.swing.JPanel image;
    public javax.swing.JPanel login;
    public javax.swing.JPasswordField password;
    public javax.swing.JButton signin;
    public javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

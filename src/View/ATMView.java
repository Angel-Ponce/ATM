package View;

import Others.Helper;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;

/**
 *
 * @author samyc
 */
public class ATMView extends javax.swing.JFrame {

    /**
     * Creates new form ATMView
     */
    public ATMView() {
        defaultTheme();
        initComponents();
        pick.putClientProperty("JButton.buttonType", "roundRect");
        addUser.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 64, new Color(171, 171, 171)));
        initATM.setIcon(Helper.icon(GoogleMaterialDesignIcons.PLAY_CIRCLE_FILLED, 64, new Color(171, 171, 171)));
        addCash.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 64, new Color(171, 171, 171)));
        updateCard.setIcon(Helper.icon(GoogleMaterialDesignIcons.PAYMENT, 64, new Color(171, 171, 171)));
        updateLimit.setIcon(Helper.icon(GoogleMaterialDesignIcons.MONEY_OFF, 64, new Color(171, 171, 171)));
        userConsult.setIcon(Helper.icon(GoogleMaterialDesignIcons.PERSON, 64, new Color(171, 171, 171)));
        userControl.setIcon(Helper.icon(GoogleMaterialDesignIcons.PEOPLE, 64, new Color(171, 171, 171)));
        updatePin.setIcon(Helper.icon(GoogleMaterialDesignIcons.LOCK_OPEN, 64, new Color(171, 171, 171)));
        retreat.setIcon(Helper.icon(GoogleMaterialDesignIcons.PAYMENT, 64, new Color(171, 171, 171)));
        deposit.setIcon(Helper.icon(GoogleMaterialDesignIcons.MONETIZATION_ON, 64, new Color(171, 171, 171)));
        transactions.setIcon(Helper.icon(GoogleMaterialDesignIcons.HISTORY, 64, new Color(171, 171, 171)));
        amount.setIcon(Helper.icon(GoogleMaterialDesignIcons.MONETIZATION_ON, 64, new Color(171, 171, 171)));
        logout.setIcon(Helper.icon(GoogleMaterialDesignIcons.EXIT_TO_APP, 16, Color.LIGHT_GRAY));
        ImageIcon ic = Helper.roundImage(getClass().getResource("/Resources/default.png"), 192, 192);
        Image image = ic.getImage().getScaledInstance(192, 192, Image.SCALE_SMOOTH);
        pick.setIcon(new ImageIcon(image));
        addUser.putClientProperty("JButton.buttonType", "square");
        initATM.putClientProperty("JButton.buttonType", "square");
        addCash.putClientProperty("JButton.buttonType", "square");
        updateCard.putClientProperty("JButton.buttonType", "square");
        updateLimit.putClientProperty("JButton.buttonType", "square");
        userConsult.putClientProperty("JButton.buttonType", "square");
        userControl.putClientProperty("JButton.buttonType", "square");
        updatePin.putClientProperty("JButton.buttonType", "square");
        retreat.putClientProperty("JButton.buttonType", "square");
        deposit.putClientProperty("JButton.buttonType", "square");
        transactions.putClientProperty("JButton.buttonType", "square");
        amount.putClientProperty("JButton.buttonType", "square");
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
    }

    public void defaultTheme() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        barNavigation = new javax.swing.JPanel();
        pick = new javax.swing.JButton();
        userName = new javax.swing.JLabel();
        addUser = new javax.swing.JButton();
        initATM = new javax.swing.JButton();
        addCash = new javax.swing.JButton();
        updateCard = new javax.swing.JButton();
        updateLimit = new javax.swing.JButton();
        userConsult = new javax.swing.JButton();
        userControl = new javax.swing.JButton();
        updatePin = new javax.swing.JButton();
        retreat = new javax.swing.JButton();
        deposit = new javax.swing.JButton();
        transactions = new javax.swing.JButton();
        amount = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();
        content = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        bar = new javax.swing.JMenuBar();
        settings = new javax.swing.JMenu();
        user = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 752));
        setPreferredSize(new java.awt.Dimension(1080, 800));

        container.setMinimumSize(new java.awt.Dimension(1080, 752));
        container.setLayout(new java.awt.GridBagLayout());

        barNavigation.setLayout(new java.awt.GridBagLayout());

        pick.setBorderPainted(false);
        pick.setFocusable(false);
        pick.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pick.setIconTextGap(0);
        pick.setMargin(new java.awt.Insets(5, 0, 0, 0));
        pick.setMaximumSize(new java.awt.Dimension(192, 192));
        pick.setMinimumSize(new java.awt.Dimension(192, 192));
        pick.setPreferredSize(new java.awt.Dimension(192, 192));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        barNavigation.add(pick, gridBagConstraints);

        userName.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userName.setText("Name Lastname");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        barNavigation.add(userName, gridBagConstraints);

        addUser.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        addUser.setForeground(new java.awt.Color(255, 255, 255));
        addUser.setText("Add user");
        addUser.setBorderPainted(false);
        addUser.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(addUser, gridBagConstraints);

        initATM.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        initATM.setForeground(new java.awt.Color(255, 255, 255));
        initATM.setText("Init ATM");
        initATM.setBorderPainted(false);
        initATM.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        initATM.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(initATM, gridBagConstraints);

        addCash.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        addCash.setForeground(new java.awt.Color(255, 255, 255));
        addCash.setText("Add cash");
        addCash.setBorderPainted(false);
        addCash.setEnabled(false);
        addCash.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addCash.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(addCash, gridBagConstraints);

        updateCard.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        updateCard.setForeground(new java.awt.Color(255, 255, 255));
        updateCard.setText("Update card");
        updateCard.setBorderPainted(false);
        updateCard.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        updateCard.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(updateCard, gridBagConstraints);

        updateLimit.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        updateLimit.setForeground(new java.awt.Color(255, 255, 255));
        updateLimit.setText("Update limit");
        updateLimit.setBorderPainted(false);
        updateLimit.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        updateLimit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(updateLimit, gridBagConstraints);

        userConsult.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        userConsult.setForeground(new java.awt.Color(255, 255, 255));
        userConsult.setText("User consult");
        userConsult.setBorderPainted(false);
        userConsult.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        userConsult.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(userConsult, gridBagConstraints);

        userControl.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        userControl.setForeground(new java.awt.Color(255, 255, 255));
        userControl.setText("User control");
        userControl.setBorderPainted(false);
        userControl.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        userControl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(userControl, gridBagConstraints);

        updatePin.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        updatePin.setForeground(new java.awt.Color(255, 255, 255));
        updatePin.setText("Update pin");
        updatePin.setBorderPainted(false);
        updatePin.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        updatePin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(updatePin, gridBagConstraints);

        retreat.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        retreat.setForeground(new java.awt.Color(255, 255, 255));
        retreat.setText("Retreat");
        retreat.setBorderPainted(false);
        retreat.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        retreat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(retreat, gridBagConstraints);

        deposit.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        deposit.setForeground(new java.awt.Color(255, 255, 255));
        deposit.setText("Deposit");
        deposit.setBorderPainted(false);
        deposit.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        deposit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(deposit, gridBagConstraints);

        transactions.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        transactions.setForeground(new java.awt.Color(255, 255, 255));
        transactions.setText("Transactions");
        transactions.setBorderPainted(false);
        transactions.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        transactions.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(transactions, gridBagConstraints);

        amount.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.setText("Amount");
        amount.setBorderPainted(false);
        amount.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        amount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        barNavigation.add(amount, gridBagConstraints);

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        barNavigation.add(separator, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 15.0;
        gridBagConstraints.weighty = 100.0;
        container.add(barNavigation, gridBagConstraints);

        content.setLayout(new java.awt.BorderLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tipoLogo.png"))); // NOI18N
        content.add(logo, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 85.0;
        gridBagConstraints.weighty = 100.0;
        container.add(content, gridBagConstraints);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        settings.setText("Settings");
        bar.add(settings);

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/on.png"))); // NOI18N
        user.setText("user");

        logout.setText("Logout");
        user.add(logout);

        bar.add(user);

        setJMenuBar(bar);

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
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATMView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addCash;
    public javax.swing.JButton addUser;
    public javax.swing.JButton amount;
    public javax.swing.JMenuBar bar;
    public javax.swing.JPanel barNavigation;
    public javax.swing.JPanel container;
    public javax.swing.JPanel content;
    public javax.swing.JButton deposit;
    public javax.swing.JButton initATM;
    public javax.swing.JLabel logo;
    public javax.swing.JMenuItem logout;
    public javax.swing.JButton pick;
    public javax.swing.JButton retreat;
    private javax.swing.JSeparator separator;
    public javax.swing.JMenu settings;
    public javax.swing.JButton transactions;
    public javax.swing.JButton updateCard;
    public javax.swing.JButton updateLimit;
    public javax.swing.JButton updatePin;
    public javax.swing.JMenu user;
    public javax.swing.JButton userConsult;
    public javax.swing.JButton userControl;
    public javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import javax.swing.UIManager;

/**
 *
 * @author samyc
 */
public class BalanceView extends javax.swing.JPanel {

    /**
     * Creates new form BalanceView
     */
    public BalanceView() {
        defaultTheme();
        initComponents();
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

        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pick1 = new javax.swing.JButton();
        avaliableAmount = new javax.swing.JLabel();
        avAmount = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pick2 = new javax.swing.JButton();
        maximumAmount = new javax.swing.JLabel();
        maxAmount = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(3, 1));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        title.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        title.setText("Balance");
        jPanel2.add(title);

        add(jPanel2);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        pick1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/avaliable amount.png"))); // NOI18N
        pick1.setBorderPainted(false);
        pick1.setContentAreaFilled(false);
        pick1.setFocusable(false);
        pick1.setPreferredSize(new java.awt.Dimension(256, 256));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel3.add(pick1, gridBagConstraints);

        avaliableAmount.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        avaliableAmount.setText("Avaliable amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel3.add(avaliableAmount, gridBagConstraints);

        avAmount.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        jPanel3.add(avAmount, gridBagConstraints);

        add(jPanel3);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        pick2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/maximum retreat.png"))); // NOI18N
        pick2.setBorderPainted(false);
        pick2.setContentAreaFilled(false);
        pick2.setFocusable(false);
        pick2.setPreferredSize(new java.awt.Dimension(256, 256));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(pick2, gridBagConstraints);

        maximumAmount.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        maximumAmount.setText("Maximum amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel1.add(maximumAmount, gridBagConstraints);

        maxAmount.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 100.0;
        jPanel1.add(maxAmount, gridBagConstraints);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel avAmount;
    public javax.swing.JLabel avaliableAmount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel maxAmount;
    public javax.swing.JLabel maximumAmount;
    public javax.swing.JButton pick1;
    public javax.swing.JButton pick2;
    public javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Others.Helper;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import java.awt.Color;
import javax.swing.UIManager;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;

/**
 *
 * @author samyc
 */
public class RetreatView extends javax.swing.JPanel {

    /**
     * Creates new form RetreatView
     */
    public RetreatView() {
        defaultTheme();
        initComponents();
        pick.putClientProperty("JButton.buttonType", "square");
        pin.putClientProperty("JTextField.placeholderText", "Pin");
        $1.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 48, Color.GREEN));
        $5.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 48, Color.GREEN));
        $10.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 48, Color.GREEN));
        $20.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 48, Color.GREEN));
        $50.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 48, Color.GREEN));
        $100.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 48, Color.GREEN));
        $200.setIcon(Helper.icon(GoogleMaterialDesignIcons.ADD_CIRCLE, 48, Color.GREEN));
        reset.setIcon(Helper.icon(GoogleMaterialDesignIcons.REFRESH, 48, Color.LIGHT_GRAY));
        save.setIcon(Helper.icon(GoogleMaterialDesignIcons.SAVE, 32, Color.decode("#0A3D62")));
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

        jPanel1 = new javax.swing.JPanel();
        pick = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pin = new javax.swing.JPasswordField();
        save = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        $50 = new javax.swing.JButton();
        $100 = new javax.swing.JButton();
        $200 = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        $1 = new javax.swing.JButton();
        $5 = new javax.swing.JButton();
        $10 = new javax.swing.JButton();
        $20 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        pick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/retirada.png"))); // NOI18N
        pick.setBorderPainted(false);
        pick.setContentAreaFilled(false);
        pick.setFocusable(false);
        pick.setPreferredSize(new java.awt.Dimension(256, 256));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(pick, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        title.setText("To retreat");
        jPanel2.add(title, java.awt.BorderLayout.CENTER);
        jPanel2.add(reset, java.awt.BorderLayout.LINE_END);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        pin.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        pin.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(pin, gridBagConstraints);

        save.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        save.setText("Continue");
        save.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(save, gridBagConstraints);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.GridLayout(4, 1, 0, 100));

        $50.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        $50.setText("$50");
        $50.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel4.add($50);

        $100.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        $100.setText("$100");
        $100.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel4.add($100);

        $200.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        $200.setText("$200");
        $200.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel4.add($200);

        total.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setEnabled(false);
        total.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel4.add(total);

        add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setLayout(new java.awt.GridLayout(4, 1, 0, 100));

        $1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        $1.setText("$1");
        $1.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel5.add($1);

        $5.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        $5.setText("$5");
        $5.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel5.add($5);

        $10.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        $10.setText("$10");
        $10.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel5.add($10);

        $20.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        $20.setText("$20");
        $20.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel5.add($20);

        add(jPanel5, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton $1;
    public javax.swing.JButton $10;
    public javax.swing.JButton $100;
    public javax.swing.JButton $20;
    public javax.swing.JButton $200;
    public javax.swing.JButton $5;
    public javax.swing.JButton $50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JButton pick;
    public javax.swing.JPasswordField pin;
    public javax.swing.JButton reset;
    public javax.swing.JButton save;
    public javax.swing.JLabel title;
    public javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}

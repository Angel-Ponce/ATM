/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.User;
import Others.Helper;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Angel Ponce
 */
public class JUser extends javax.swing.JPanel {

    /**
     * Creates new form JUser
     *
     * @param user
     */
    private User user;

    public JUser(User user) {
        initComponents();
        event();
        this.user = user;
        name.setText(user.toString());
        pick.setIcon(Helper.roundImage(user.getPick(), 64, 64));
        name.putClientProperty("JButton.buttonType", "square");
    }

    private void event() {
        FocusListener focusEvent = new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                name.setBackground(Color.decode("#0099FF"));
                pick.setBackground(Color.decode("#0099FF"));
                setBackground(Color.decode("#0099FF"));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                name.setBackground(null);
                pick.setBackground(null);
                setBackground(null);
            }
        };
        name.addFocusListener(focusEvent);
        pick.addFocusListener(focusEvent);
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

        name = new javax.swing.JButton();
        pick = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(2147483647, 64));
        setMinimumSize(new java.awt.Dimension(250, 64));
        setPreferredSize(new java.awt.Dimension(250, 64));
        setLayout(new java.awt.GridBagLayout());

        name.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setBorderPainted(false);
        name.setContentAreaFilled(false);
        name.setFocusPainted(false);
        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        name.setMaximumSize(new java.awt.Dimension(30, 64));
        name.setMinimumSize(new java.awt.Dimension(30, 64));
        name.setPreferredSize(new java.awt.Dimension(77, 64));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 100.0;
        add(name, gridBagConstraints);

        pick.setBorderPainted(false);
        pick.setContentAreaFilled(false);
        pick.setFocusPainted(false);
        pick.setMaximumSize(new java.awt.Dimension(64, 64));
        pick.setMinimumSize(new java.awt.Dimension(64, 64));
        pick.setPreferredSize(new java.awt.Dimension(64, 64));
        add(pick, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton name;
    public javax.swing.JButton pick;
    // End of variables declaration//GEN-END:variables

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
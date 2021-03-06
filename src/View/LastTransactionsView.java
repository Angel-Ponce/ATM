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
public class LastTransactionsView extends javax.swing.JPanel {

    /**
     * Creates new form LastTransactionsView
     */
    public LastTransactionsView() {
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

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        graph = new javax.swing.JPanel();
        transactions = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        header.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("REPORT OF TRANSACTIONS");
        header.add(title, java.awt.BorderLayout.CENTER);

        add(header, java.awt.BorderLayout.PAGE_START);

        container.setLayout(new java.awt.GridLayout(2, 1));

        graph.setLayout(new java.awt.BorderLayout());
        container.add(graph);

        transactions.setLayout(new javax.swing.BoxLayout(transactions, javax.swing.BoxLayout.Y_AXIS));
        container.add(transactions);

        add(container, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel container;
    public javax.swing.JPanel graph;
    public javax.swing.JPanel header;
    public javax.swing.JLabel title;
    public javax.swing.JPanel transactions;
    // End of variables declaration//GEN-END:variables
}
